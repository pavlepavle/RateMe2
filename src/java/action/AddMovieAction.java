package action;

import dbbroker.DBBroker;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Film;
import model.Korisnik;
import model.Uloga;
import model.UlogaPK;
import model.Zanr;
import validator.Validator;

public class AddMovieAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        try {

            HttpSession sesija = request.getSession();
            Korisnik k = (Korisnik) sesija.getAttribute("ulogovan_korisnik");

            if (k == null || k.getAdministrator() != true) {
                return "login";
            } else {
                String title = request.getParameter("title");
                String year = request.getParameter("year");
                String duration = request.getParameter("duration");
                String plot = request.getParameter("plot");

                List<String> listaGresaka = Validator.getInstance().addMovieValidate(title, year, duration);
                if (!listaGresaka.isEmpty()) {
                    request.setAttribute("listaGresaka", listaGresaka);
                    return "addmovie";
                }

                Film f = new Film();
                f.setFilmID(getFilmID());
                f.setPoster("no-pic");
                f.setBrojUloga(Integer.parseInt(request.getParameter("brojUloga")));
                f.setDuzinaTrajanja(Integer.parseInt(duration));
                f.setGodina(Integer.parseInt(year));
                f.setNaziv(title);
                f.setOpis(plot);
                List<Zanr> listaZanrova = getZanr(request.getParameterValues("zanrovi"));
                List<Uloga> listaUloga = getUloga(f, request);
                f.setUlogaList(listaUloga);
                f.setZanrList(listaZanrova);

                DBBroker.getInstance().addRecord(f);

                request.setAttribute("porukaAM", "Movie " + f.getNaziv() + " successffully added!");

                return "addmovie";
            }

        } catch (Exception ex) {
            Logger.getLogger(AddMovieAction.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return "error";
        }
    }

    private List<Uloga> getUloga(Film f, HttpServletRequest request) {
        List<Uloga> listaUloga = new ArrayList<>();

        int brojUloga = Integer.parseInt(request.getParameter("brojUloga"));

        for (int i = 0; i < brojUloga; i++) {
            String name = request.getParameter("name" + i);
            String roleType = request.getParameter("roleType" + i);
            String roleName = request.getParameter("roleName" + i);

            Uloga u = new Uloga();
            u.setFilm(f);
            UlogaPK upk = new UlogaPK();
            upk.setFilmID(f.getFilmID());
            u.setUlogaPK(upk);
            u.setImePrezime(name);
            u.setVrstaUloge(roleType);
            u.setImeUloge(roleName);
            listaUloga.add(u);
        }

        return listaUloga;
    }

    private List<Zanr> getZanr(String[] zanrIDs) {
        List<Zanr> listaZanrova = new ArrayList<>();

        for (int i = 0; i < zanrIDs.length; i++) {
            Zanr z = new Zanr();
            z.setZanrID(Integer.parseInt(zanrIDs[i]));
            listaZanrova.add(z);
        }
        return listaZanrova;
    }

    private int getFilmID() {
        Query q = DBBroker.getInstance().getEm().createNativeQuery("SELECT filmid FROM film ORDER BY filmid DESC LIMIT 1");
        long i = (long) q.getSingleResult();

        return (int) ++i;
    }
}

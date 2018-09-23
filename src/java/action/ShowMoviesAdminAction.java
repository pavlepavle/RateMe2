package action;

import dbbroker.DBBroker;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Film;
import model.Korisnik;


public class ShowMoviesAdminAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        try {
            HttpSession sesija = request.getSession();
            Korisnik k = (Korisnik) sesija.getAttribute("ulogovan_korisnik");
            if (k == null || k.getAdministrator()!= true) {
                return "login";
            }
            
            List<Film> listaFilmova = (List<Film>) DBBroker.getInstance().getEm().createNamedQuery("Film.findAll", Film.class).getResultList();
            
            request.setAttribute("listaFilmova", listaFilmova);
            return "deletemovie";

        } catch (Exception ex) {
            Logger.getLogger(ShowMoviesAdminAction.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return "error";
        }
    }
}

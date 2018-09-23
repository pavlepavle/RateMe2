package action;

import dbbroker.DBBroker;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Film;
import model.Korisnik;

public class DeleteMovieAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        try {

            HttpSession sesija = request.getSession();
            Korisnik k = (Korisnik) sesija.getAttribute("ulogovan_korisnik");
            if (k == null || k.getAdministrator() != true) {
                return "login";
            } else {

                String movieID = request.getParameter("filmID");

                Film f = new Film();
                String naziv = f.getNaziv();
                int i = Integer.parseInt(movieID);
                f.setFilmID(i);
                f = (Film) DBBroker.getInstance().getRecord(f);

                DBBroker.getInstance().deleteRecord(f);

                request.setAttribute("porukaDelete", "Movie " + naziv + " successfully deleted!");
                ShowMoviesAdminAction action = new ShowMoviesAdminAction();
                return action.execute(request);
            }

        } catch (Exception ex) {
            Logger.getLogger(ShowMovieAction.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return "error";
        }
    }
}

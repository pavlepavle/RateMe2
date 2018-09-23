package action;

import dbbroker.DBBroker;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Korisnik;
import model.Zanr;


public class GenerateMovieFormAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        try {

            HttpSession sesija = request.getSession();
            Korisnik k = (Korisnik) sesija.getAttribute("ulogovan_korisnik");
            if (k == null || k.getAdministrator()!= true) {
                return "login";
            }


            List<Zanr> listaZanrova = (List<Zanr>) DBBroker.getInstance().getRecords(new Zanr());
            sesija.setAttribute("listaZanrova", listaZanrova);
            return "addmovie";

        } catch (Exception ex) {
            Logger.getLogger(GenerateMovieFormAction.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return "error";
        }
    }
}

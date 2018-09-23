/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dbbroker.DBBroker;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Film;
import model.Korisnik;
import model.Ocena;
import servis.RateMeHttpUrlConnection;


public class ShowMovieAction extends AbstractAction {

    String movieID;

    ShowMovieAction(String movieID) {
        this.movieID = movieID;
    }

    @Override
    public String execute(HttpServletRequest request) {
        try {

            HttpSession sesija = request.getSession(true);
            Korisnik k = (Korisnik) sesija.getAttribute("ulogovan_korisnik");

            if (k == null) {
                return "login";
            }

            Ocena o = new Ocena();
            o.setKorisnik(k);
            Film f = new Film();
            int i = Integer.parseInt(movieID);
            f.setFilmID(i);
            f = (Film) DBBroker.getInstance().getRecord(f);
            o.setFilm(f);
            o = (Ocena) DBBroker.getInstance().getRecord(o);
            if (o == null) {

            }
            o = RateMeHttpUrlConnection.getInstance().sendGETOcena(o);

            if (o == null) {
                //rateempty 
                return "error";
            } else {
                sesija.setAttribute("ocena", o);
                return "showmovie";
            }
        } catch (Exception ex) {
            Logger.getLogger(ShowMovieAction.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return "error";
        }
    }
}

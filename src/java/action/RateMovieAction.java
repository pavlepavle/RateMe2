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
import model.OcenaPK;
import servis.RateMeHttpUrlConnection;


public class RateMovieAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        try {

            HttpSession sesija = request.getSession(true);
            Korisnik k = (Korisnik) sesija.getAttribute("ulogovan_korisnik");

            String rating = request.getParameter("rating");
            String movieID = request.getParameter("filmID");
            System.out.println("Ocena: " + rating + ", filmID:  " + movieID);

            Ocena o = new Ocena();
            o.setKorisnik(k);
            Film f = new Film();
            int i = Integer.parseInt(movieID);
            f.setFilmID(i);
            f = (Film) DBBroker.getInstance().getRecord(f);
            o.setFilm(f);
            o = (Ocena) DBBroker.getInstance().getRecord(o);
            if (o.getOcena() == 0) {
                OcenaPK opk = new OcenaPK(k.getKorisnikID(), i);
                o.setOcenaPK(opk);
                o.setOcena(Integer.parseInt(rating));
                DBBroker.getInstance().addRecord(o);
                o = RateMeHttpUrlConnection.getInstance().sendGETOcena(o);
            } else {
                o.setOcena(Integer.parseInt(rating));
                DBBroker.getInstance().updateRecord(o);
                o = RateMeHttpUrlConnection.getInstance().sendGETOcena(o);
            }
                sesija.setAttribute("ocena", o);
                return "showmovie";
            
        } catch (Exception ex) {
            Logger.getLogger(ShowMovieAction.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return "error";
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dbbroker.DBBroker;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Film;
import model.Korisnik;
import servis.RateMeHttpUrlConnection;


public class UnratedAction extends AbstractAction {
    
    public UnratedAction() {
    }
    
    @Override
    public String execute(HttpServletRequest request) {
        try {
            
            
            
            HttpSession sesija = request.getSession(true);
            Korisnik k = (Korisnik) sesija.getAttribute("ulogovan_korisnik");
            if (k == null) {
                return "login";
            }
            
            EntityManager em = DBBroker.getInstance().getEm();
            //Query q1 = em.createQuery("Select o from Ocena o where o.korisnik.korisnikID=:id").setParameter("id", k.getKorisnikID());
            
            Query q2 = em.createNativeQuery("Select * from Film f left join (Select * from Ocena o where o.`KorisnikID` = "+k.getKorisnikID()+" ) as t on f.`FilmID` = t.FilmID where t.KorisnikID is null", Film.class);
   
            List<Film> listaFilmova = (List<Film>)q2.getResultList();
            
//            List<String> listaLinkova = new ArrayList<>();
//            for (Film film : listaFilmova) {
//                 listaLinkova.add(RateMeHttpUrlConnection.getInstance().sendGET(film.getNaziv()));
//            }

            listaFilmova = RateMeHttpUrlConnection.getInstance().sendGET(listaFilmova);
            
            if (listaFilmova.isEmpty()) {
                //rateempty 
                return "rate";
            } else {
                //sesija.setAttribute("listaLinkova", listaLinkova);
                sesija.setAttribute("listaFilmova", listaFilmova);
                return "rate";
            }
        } catch (Exception ex) {
            Logger.getLogger(UnratedAction.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return "error";
        }
    }
}

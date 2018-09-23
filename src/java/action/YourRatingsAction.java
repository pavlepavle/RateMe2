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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Korisnik;
import model.Ocena;
import servis.RateMeHttpUrlConnection;

public class YourRatingsAction extends AbstractAction {
    
    int cols = 0;
    YourRatingsAction(int i) {
        this.cols = i;
    }
    
    @Override
    public String execute(HttpServletRequest request) {
        try {
            
            
            
            HttpSession sesija = request.getSession(true);
            Korisnik k = (Korisnik) sesija.getAttribute("ulogovan_korisnik");
            
            Ocena o = new Ocena();
            o.setKorisnik(k);
            List<Ocena> listaOcena = (List<Ocena>) DBBroker.getInstance().getRecords(o);

            listaOcena = RateMeHttpUrlConnection.getInstance().sendGETOcena(listaOcena);
            
            if (listaOcena.isEmpty()) {
                //rateempty 
                return "yourratings1";
            } else {
                sesija.setAttribute("listaOcena", listaOcena);
                switch(cols){
                    case 1: return "yourratings1";
                    case 2: return "yourratings2";
                    case 3: return "yourratings3";
                    case 4: return "yourratings4";
                }
                return "yourratings1";
            }
        } catch (Exception ex) {
            Logger.getLogger(YourRatingsAction.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return "error";
        }
    }
}

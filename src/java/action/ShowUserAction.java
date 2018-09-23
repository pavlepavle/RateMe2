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


public class ShowUserAction extends AbstractAction {

    public ShowUserAction() {
        
    }

    @Override
    public String execute(HttpServletRequest request) {
        try {
            HttpSession sesija = request.getSession();

            Korisnik k = (Korisnik) sesija.getAttribute("ulogovan_korisnik");
            if (k != null && k.getAdministrator()) {
                List<Korisnik> listaKorisnika = (List<Korisnik>) DBBroker.getInstance().getRecords(k);

                sesija.setAttribute("listaKorisnika", listaKorisnika);
                return "promoteuser";
            } else {
                return "login";
            }

        } catch (Exception ex) {
            Logger.getLogger(ShowUserAction.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return "error";
        }
    }
}

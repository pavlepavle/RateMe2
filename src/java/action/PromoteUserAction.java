/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dbbroker.DBBroker;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Korisnik;


public class PromoteUserAction extends AbstractAction {

    PromoteUserAction() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        try {
            HttpSession sesija = request.getSession();
            Korisnik k = (Korisnik) sesija.getAttribute("ulogovan_korisnik");
            if (k == null || k.getAdministrator()!= true) {
                return "login";
            } else {
                Korisnik korisnik = new Korisnik();
                korisnik.setUsername(request.getParameter("b23"));
                //korisnik = (Korisnik) DBBroker.getInstance().getRecordHelp(korisnik);
                EntityManager em = DBBroker.getInstance().getEm();
                Query q = em.createNamedQuery("Korisnik.findByUsername", Korisnik.class).setParameter("username", korisnik.getUsername());
                Korisnik o = (Korisnik) q.getSingleResult();
                System.out.println(o);

                o.setAdministrator(true);
                DBBroker.getInstance().updateRecord(o);
                String s = "You successfully promoted user!";
                sesija.setAttribute("poruka", s);
                return "promoteuser";
            }
        } catch (Exception ex) {
            Logger.getLogger(PromoteUserAction.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return "error";
        }
    }
}

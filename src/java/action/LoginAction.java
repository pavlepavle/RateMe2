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
import model.Korisnik;


public class LoginAction extends AbstractAction {

    public LoginAction() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Korisnik kor = new Korisnik();
            kor.setUsername(username);
            kor.setPassword(password);
            
            Korisnik k = (Korisnik) DBBroker.getInstance().getRecord(kor);
            if (k == null) {
                String s = "Username with that password does not exist!";
                request.setAttribute("signalLogin", s);
                return "login";
            } else {
            
            System.out.println(k);
            HttpSession sesija = request.getSession(true);
            sesija.setAttribute("ulogovan_korisnik", k);
            return "index";
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return "error";
        }
    }
}

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
import validator.Validator;

public class EditKorisnikAction extends AbstractAction {

    public EditKorisnikAction() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        try {
            HttpSession sesija = request.getSession(true);
            Korisnik k = (Korisnik) sesija.getAttribute("ulogovan_korisnik");
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String passwordRepeat = request.getParameter("password_repeat");

            List<String> listaGresaka = Validator.getInstance().editProfileValidate(k.getUsername(), username, password, passwordRepeat);

            if (listaGresaka.isEmpty()) {   
                k.setUsername(username);
                k.setPassword(password);
                DBBroker.getInstance().updateRecord(k);

                String s = "You successfully edited your profile!";
                request.setAttribute("poruka", s);
                return "edituser";
            }
            request.setAttribute("listaGresaka", listaGresaka);
            return "edituser";
        } catch (Exception ex) {
            Logger.getLogger(EditKorisnikAction.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return "error";
        }
    }
}

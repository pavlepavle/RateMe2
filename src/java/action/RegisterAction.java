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
import model.Korisnik;
import validator.Validator;

public class RegisterAction extends AbstractAction {

    public RegisterAction() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String passwordRepeat = request.getParameter("password_repeat");

            List<String> listaGresaka = Validator.getInstance().registerValidate(username, password, passwordRepeat);

            //HttpSession sesija = request.getSession(true);
            if (listaGresaka.isEmpty()) {
                Korisnik kor = new Korisnik(100, username, password, false);

                DBBroker.getInstance().addRecord(kor);
                System.out.println("Registrovan korisnik :" + username + " " + password);
                //Prihvati i prikazi korisniku poruke
                String s = "You are registered!";
                request.setAttribute("signal", s);
                return "login";
            }
            request.setAttribute("listaGresaka", listaGresaka);
            return "register";
        } catch (Exception ex) {
            Logger.getLogger(RegisterAction.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return "error";
        }
    }
}

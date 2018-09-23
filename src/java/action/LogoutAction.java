/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;


public class LogoutAction extends AbstractAction {

    public LogoutAction() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        try {
            request.getSession().invalidate();
            return "login";

        } catch (Exception ex) {
            Logger.getLogger(LogoutAction.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return "error";
        }
    }
}

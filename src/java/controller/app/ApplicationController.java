/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.app;

import action.AbstractAction;
import action.ActionFactory;
import javax.servlet.http.HttpServletRequest;


public class ApplicationController {
    
    
    private static ApplicationController instance;

    public ApplicationController() {
    }
    
    public static ApplicationController getInstance(){
        if(instance == null){
            instance = new ApplicationController();
        }
        return instance;
    }
    
    public String processRequest(String inputAction, HttpServletRequest request){
            AbstractAction action = ActionFactory.createAction(inputAction);
        return action.execute(request);
    }
    
    public String processRequest(String s, String inputAction, HttpServletRequest request){
        AbstractAction action = ActionFactory.createAction(inputAction, s);
        return action.execute(request);
    }
    
}

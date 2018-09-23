/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageresolver;


public class PageResolver {
    
    public static String getPage(String view) {
        String page="";
        
        switch(view){
            case "login": page = "login.jsp"; break;
            case "register": page = "register.jsp"; break;
            case "index": page = "index.jsp"; break;     
            case "rate": page = "notrated.jsp"; break;
            case "yourratings1": page = "ocene1col.jsp"; break;
            case "yourratings2": page = "ocene2col.jsp"; break;
            case "yourratings3": page = "ocene3col.jsp"; break;
            case "yourratings4": page = "ocene4col.jsp"; break;
            case "showmovie": page = "showmovie.jsp"; break;
            case "top10": page = "top10.jsp"; break;
            case "edituser": page = "edituser.jsp"; break;
            case "promoteuser": page = "promoteuser.jsp"; break;
            case "addmovie": page = "addmovie.jsp"; break;
            case "deletemovie": page = "deletemovie.jsp"; break;
            case "error": page = "error.jsp"; break;
        }
        return page;
    }
}
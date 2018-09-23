/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import action.AbstractAction;

/**
 *
 * @author student
 */
public class ActionFactory {

    public static AbstractAction createAction(String inputAction) {
        AbstractAction action = null;

        if (inputAction.equalsIgnoreCase("login")) {
            action = new LoginAction();
        }

        if (inputAction.equalsIgnoreCase("register")) {
            action = new RegisterAction();
        }

        if (inputAction.equalsIgnoreCase("notrated")) {
            action = new UnratedAction();
        }

        if (inputAction.equalsIgnoreCase("yourratings1")) {
            action = new YourRatingsAction(1);
        }
        if (inputAction.equalsIgnoreCase("yourratings2")) {
            action = new YourRatingsAction(2);
        }
        if (inputAction.equalsIgnoreCase("yourratings3")) {
            action = new YourRatingsAction(3);
        }
        if (inputAction.equalsIgnoreCase("yourratings4")) {
            action = new YourRatingsAction(4);
        }
        if (inputAction.equalsIgnoreCase("logout")) {
            action = new LogoutAction();
        }
        if (inputAction.equalsIgnoreCase("ratemovie")) {
            action = new RateMovieAction();
        }

        if (inputAction.equalsIgnoreCase("top10")) {
            action = new Top10Action();
        }

        if (inputAction.equalsIgnoreCase("edituser")) {
            action = new EditKorisnikAction();
        }

        if (inputAction.equalsIgnoreCase("showusers")) {
            action = new ShowUserAction();
        }
        if (inputAction.equalsIgnoreCase("promoteuser")) {
            action = new PromoteUserAction();
        }
        if (inputAction.equalsIgnoreCase("generatemovieform")) {
            action = new GenerateMovieFormAction();
        }
        if (inputAction.equalsIgnoreCase("addmovie")) {
            action = new AddMovieAction();
        }
        if (inputAction.equalsIgnoreCase("showmoviesadmin")) {
            action = new ShowMoviesAdminAction();
        }
        if (inputAction.equalsIgnoreCase("deletemovie")) {
            action = new DeleteMovieAction();
        }
        return action;
    }

    public static AbstractAction createAction(String inputAction, String s) {
        AbstractAction action = null;
        if (inputAction.equalsIgnoreCase("showmovie")) {
            action = new ShowMovieAction(s);
        }
        

        return action;
    }
}

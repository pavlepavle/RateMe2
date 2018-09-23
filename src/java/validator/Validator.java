/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import dbbroker.DBBroker;
import java.util.ArrayList;
import java.util.List;
import model.Film;
import model.Korisnik;

public class Validator {

    private static Validator v;

    private Validator() {

    }

    public static Validator getInstance() {
        if (v == null) {
            v = new Validator();
        }
        return v;
    }

    public List<String> registerValidate(String username, String password, String passwordRepeat) throws Exception {

        List<String> listaGresaka = new ArrayList<>();
        if (!password.equals(passwordRepeat)) {
            listaGresaka.add("Password does not match! Try again!");
        }
        if (username.length() < 4) {
            listaGresaka.add("Username must be longer than 3 characters!");
        }
        if (password.length() < 4) {
            listaGresaka.add("Password must be longer than 3 characters!");
        }
        if (DBBroker.getInstance().getRecordHelp(new Korisnik(0, username, password, false)).equals("0")) {
            listaGresaka.add("Username already exists!");
        }
        return listaGresaka;

    }

    public List<String> editProfileValidate(String usernameOld, String usernameNew, String password, String passwordRepeat) throws Exception {

        List<String> listaGresaka = new ArrayList<>();
        if (!password.equals(passwordRepeat)) {
            listaGresaka.add("Password does not match! Try again!");
        }
        if (usernameNew.length() < 4) {
            listaGresaka.add("Username must be longer than 3 characters!");
        }
        if (password.length() < 4) {
            listaGresaka.add("Password must be longer than 3 characters!");
        }
        if (!usernameOld.equals(usernameNew)) {
            if (DBBroker.getInstance().getRecordHelp(new Korisnik(0, usernameNew, password, false)).equals("0")) {
                listaGresaka.add("Username already exists!");
            }
        }
        return listaGresaka;
    }

    public List<String> addMovieValidate(String title, String year, String duration) throws Exception {
        List<String> listaGresaka = new ArrayList<>();
        if (DBBroker.getInstance().getRecordHelp(new Film(0, title, 0, 0, 0)).equals("0")) {
            listaGresaka.add("Movie already exists!");
        }
        if (!duration.matches("(\\d*)")) {
            listaGresaka.add("Field duration must be numeric!");
        }
        if (!year.matches("(\\d*)")) {
            listaGresaka.add("Field year must be numeric!");
        }
        
        return listaGresaka;
    }

}

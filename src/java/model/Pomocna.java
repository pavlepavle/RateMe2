/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;


public class Pomocna implements Serializable{

    public long filmID;
    public String naziv;
    public int godina;
    public BigDecimal ocena;

    public Pomocna(long filmID, String naziv, int godina, BigDecimal ocena) {
        this.filmID = filmID;
        this.naziv = naziv;
        this.godina = godina;
        this.ocena = ocena;
    }

    public Pomocna() {
    }

    public long getFilmID() {
        return filmID;
    }

    public void setFilmID(long filmID) {
        this.filmID = filmID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public BigDecimal getOcena() {
        return ocena;
    }

    public void setOcena(BigDecimal ocena) {
        this.ocena = ocena;
    }

    
    
    

    @Override
    public String toString() {
        return "Pomocna{" + "filmID=" + filmID + ", naziv=" + naziv + ", godina=" + godina + ", ocena=" + ocena + '}';
    }

}


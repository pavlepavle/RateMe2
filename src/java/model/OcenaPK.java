/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@Embeddable
public class OcenaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "KorisnikID")
    private int korisnikID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FilmID")
    private int filmID;

    public OcenaPK() {
    }

    public OcenaPK(int korisnikID, int filmID) {
        this.korisnikID = korisnikID;
        this.filmID = filmID;
    }

    public int getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(int korisnikID) {
        this.korisnikID = korisnikID;
    }

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) korisnikID;
        hash += (int) filmID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OcenaPK)) {
            return false;
        }
        OcenaPK other = (OcenaPK) object;
        if (this.korisnikID != other.korisnikID) {
            return false;
        }
        if (this.filmID != other.filmID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.OcenaPK[ korisnikID=" + korisnikID + ", filmID=" + filmID + " ]";
    }
    
}

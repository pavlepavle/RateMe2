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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;


@Embeddable
public class UlogaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "UlogaID")
    private int ulogaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FilmID")
    private int filmID;

    public UlogaPK() {
    }

    public UlogaPK(int ulogaID, int filmID) {
        this.ulogaID = ulogaID;
        this.filmID = filmID;
    }

    public int getUlogaID() {
        return ulogaID;
    }

    public void setUlogaID(int ulogaID) {
        this.ulogaID = ulogaID;
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
        hash += (int) ulogaID;
        hash += (int) filmID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UlogaPK)) {
            return false;
        }
        UlogaPK other = (UlogaPK) object;
        if (this.ulogaID != other.ulogaID) {
            return false;
        }
        if (this.filmID != other.filmID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.UlogaPK[ ulogaID=" + ulogaID + ", filmID=" + filmID + " ]";
    }
    
}

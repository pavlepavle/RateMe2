/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "uloga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uloga.findAll", query = "SELECT u FROM Uloga u")
    , @NamedQuery(name = "Uloga.findByUlogaID", query = "SELECT u FROM Uloga u WHERE u.ulogaPK.ulogaID = :ulogaID")
    , @NamedQuery(name = "Uloga.findByImeUloge", query = "SELECT u FROM Uloga u WHERE u.imeUloge = :imeUloge")
    , @NamedQuery(name = "Uloga.findByVrstaUloge", query = "SELECT u FROM Uloga u WHERE u.vrstaUloge = :vrstaUloge")
    , @NamedQuery(name = "Uloga.findByImePrezime", query = "SELECT u FROM Uloga u WHERE u.imePrezime = :imePrezime")
    , @NamedQuery(name = "Uloga.findByFilmID", query = "SELECT u FROM Uloga u WHERE u.ulogaPK.filmID = :filmID")})
public class Uloga implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UlogaPK ulogaPK;
    //@Size(max = 30)
    @Column(name = "ImeUloge")
    private String imeUloge;
    //@Size(max = 30)
    @Column(name = "VrstaUloge")
    private String vrstaUloge;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 30)
    @Column(name = "ImePrezime")
    private String imePrezime;
    @JoinColumn(name = "FilmID", referencedColumnName = "FilmID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Film film;

    public Uloga() {
    }

    public Uloga(UlogaPK ulogaPK) {
        this.ulogaPK = ulogaPK;
    }

    public Uloga(UlogaPK ulogaPK, String imePrezime) {
        this.ulogaPK = ulogaPK;
        this.imePrezime = imePrezime;
    }

    public Uloga(int ulogaID, int filmID) {
        this.ulogaPK = new UlogaPK(ulogaID, filmID);
    }

    public UlogaPK getUlogaPK() {
        return ulogaPK;
    }

    public void setUlogaPK(UlogaPK ulogaPK) {
        this.ulogaPK = ulogaPK;
    }

    public String getImeUloge() {
        return imeUloge;
    }

    public void setImeUloge(String imeUloge) {
        this.imeUloge = imeUloge;
    }

    public String getVrstaUloge() {
        return vrstaUloge;
    }

    public void setVrstaUloge(String vrstaUloge) {
        this.vrstaUloge = vrstaUloge;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ulogaPK != null ? ulogaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uloga)) {
            return false;
        }
        Uloga other = (Uloga) object;
        if ((this.ulogaPK == null && other.ulogaPK != null) || (this.ulogaPK != null && !this.ulogaPK.equals(other.ulogaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Uloga[ ulogaPK=" + ulogaPK + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "zanr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zanr.findAll", query = "SELECT z FROM Zanr z")
    , @NamedQuery(name = "Zanr.findByZanrID", query = "SELECT z FROM Zanr z WHERE z.zanrID = :zanrID")
    , @NamedQuery(name = "Zanr.findByNaziv", query = "SELECT z FROM Zanr z WHERE z.naziv = :naziv")})
public class Zanr implements Serializable, Record {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ZanrID")
    private Integer zanrID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Naziv")
    private String naziv;
    @ManyToMany(mappedBy = "zanrList")
    private List<Film> filmList;

    public Zanr() {
    }

    public Zanr(Integer zanrID) {
        this.zanrID = zanrID;
    }

    public Zanr(Integer zanrID, String naziv) {
        this.zanrID = zanrID;
        this.naziv = naziv;
    }

    public Integer getZanrID() {
        return zanrID;
    }

    public void setZanrID(Integer zanrID) {
        this.zanrID = zanrID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @XmlTransient
    public List<Film> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zanrID != null ? zanrID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zanr)) {
            return false;
        }
        Zanr other = (Zanr) object;
        if ((this.zanrID == null && other.zanrID != null) || (this.zanrID != null && !this.zanrID.equals(other.zanrID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Zanr[ zanrID=" + zanrID + " ]";
    }

    @Override
    public Object getRecord(EntityManager em, UserTransaction userTxn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<? extends Record> getRecords(EntityManager em, UserTransaction userTxn) {
        TypedQuery tq =  em.createNamedQuery("Zanr.findAll", Zanr.class);
        List<Zanr> lista = new ArrayList<>(tq.getResultList());
        return lista;}

    @Override
    public void deleteRecord(EntityManager em, UserTransaction userTxn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addRecord(EntityManager em, UserTransaction userTxn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateRecord(EntityManager em, UserTransaction userTxn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getRecordHelp(EntityManager em, UserTransaction userTxn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

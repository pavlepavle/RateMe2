/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "ocena")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ocena.findAll", query = "SELECT o FROM Ocena o")
    , @NamedQuery(name = "Ocena.findByKorisnikID", query = "SELECT o FROM Ocena o WHERE o.ocenaPK.korisnikID = :korisnikID")
    , @NamedQuery(name = "Ocena.findByFilmID", query = "SELECT o FROM Ocena o WHERE o.ocenaPK.filmID = :filmID")
    , @NamedQuery(name = "Ocena.findByKorisnikIDAndFilmFilmID", query = "SELECT o FROM Ocena o WHERE o.ocenaPK.korisnikID = :korisnikID AND o.ocenaPK.filmID = :filmID")
    , @NamedQuery(name = "Ocena.findByFilmID", query = "SELECT o FROM Ocena o WHERE o.ocenaPK.filmID = :filmID")
    , @NamedQuery(name = "Ocena.findByOcena", query = "SELECT o FROM Ocena o WHERE o.ocena = :ocena")})
public class Ocena implements Serializable, Record {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OcenaPK ocenaPK;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "Ocena")
    private int ocena;
    @JoinColumn(name = "FilmID", referencedColumnName = "FilmID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Film film;
    @JoinColumn(name = "KorisnikID", referencedColumnName = "KorisnikID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Korisnik korisnik;

    public Ocena() {
    }

    public Ocena(OcenaPK ocenaPK) {
        this.ocenaPK = ocenaPK;
    }

    public Ocena(OcenaPK ocenaPK, int ocena) {
        this.ocenaPK = ocenaPK;
        this.ocena = ocena;
    }

    public Ocena(int korisnikID, int filmID) {
        this.ocenaPK = new OcenaPK(korisnikID, filmID);
    }

    public OcenaPK getOcenaPK() {
        return ocenaPK;
    }

    public void setOcenaPK(OcenaPK ocenaPK) {
        this.ocenaPK = ocenaPK;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ocenaPK != null ? ocenaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ocena)) {
            return false;
        }
        Ocena other = (Ocena) object;
        if ((this.ocenaPK == null && other.ocenaPK != null) || (this.ocenaPK != null && !this.ocenaPK.equals(other.ocenaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ocena{" + "ocena=" + ocena + ", film=" + film + ", korisnik=" + korisnik + '}';
    }

    @Override
    public Object getRecord(EntityManager em, UserTransaction userTxn) throws Exception {
        TypedQuery tq = em.createNamedQuery("Ocena.findByKorisnikIDAndFilmFilmID", Ocena.class).setParameter("korisnikID", this.korisnik.getKorisnikID()).setParameter("filmID", this.getFilm().getFilmID());
        if (tq.getResultList().isEmpty()) {
            return this;
        }
        Ocena o = (Ocena) tq.getResultList().get(0);
        return o;
    }

    @Override
    public List<? extends Record> getRecords(EntityManager em, UserTransaction userTxn) {
        TypedQuery tq = em.createNamedQuery("Ocena.findByKorisnikID", Ocena.class).setParameter("korisnikID", this.korisnik.getKorisnikID());
        List<Ocena> lista = new ArrayList<>(tq.getResultList());
        return lista;
    }

    @Override
    public void deleteRecord(EntityManager em, UserTransaction userTxn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addRecord(EntityManager em, UserTransaction userTxn) {
        try {
            userTxn.begin();
            em.persist(this);
            userTxn.commit();
        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            Logger.getLogger(Ocena.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateRecord(EntityManager em, UserTransaction userTxn) {
        try {
            userTxn.begin();
            em.merge(this);
            userTxn.commit();
        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            Logger.getLogger(Ocena.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object getRecordHelp(EntityManager em, UserTransaction userTxn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "film")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Film.findAll", query = "SELECT f FROM Film f")
    , @NamedQuery(name = "Film.findByFilmID", query = "SELECT f FROM Film f WHERE f.filmID = :filmID")
    , @NamedQuery(name = "Film.findByNaziv", query = "SELECT f FROM Film f WHERE f.naziv = :naziv")
    , @NamedQuery(name = "Film.findByGodina", query = "SELECT f FROM Film f WHERE f.godina = :godina")
    ,   @NamedQuery(name = "Film.findByOpis", query = "SELECT f FROM Film f WHERE f.opis = :opis")
    , @NamedQuery(name = "Film.findByBrojUloga", query = "SELECT f FROM Film f WHERE f.brojUloga = :brojUloga")
    , @NamedQuery(name = "Film.findByDuzinaTrajanja", query = "SELECT f FROM Film f WHERE f.duzinaTrajanja = :duzinaTrajanja")})
public class Film implements Record, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "FilmID")
    private Integer filmID;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 30)
    @Column(name = "Naziv")
    private String naziv;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "Godina")
    private int godina;
    //@Size(max = 300)
    @Column(name = "Opis")
    private String opis;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "BrojUloga")
    private int brojUloga;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "DuzinaTrajanja")
    private int duzinaTrajanja;
    @JoinTable(name = "filmzanr", joinColumns = {
        @JoinColumn(name = "FilmID", referencedColumnName = "FilmID")}, inverseJoinColumns = {
        @JoinColumn(name = "ZanrID", referencedColumnName = "ZanrID")})
    @ManyToMany
    private List<Zanr> zanrList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "film")
    private List<Uloga> ulogaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "film")
    private List<Ocena> ocenaList;

    @Column(name = "poster")
    private String poster;

    public Film() {
    }

    public Film(Integer filmID) {
        this.filmID = filmID;
    }

    public Film(Integer filmID, String naziv, int godina, int brojUloga, int duzinaTrajanja) {
        this.filmID = filmID;
        this.naziv = naziv;
        this.godina = godina;
        this.brojUloga = brojUloga;
        this.duzinaTrajanja = duzinaTrajanja;
    }

    public Integer getFilmID() {
        return filmID;
    }

    public void setFilmID(Integer filmID) {
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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getBrojUloga() {
        return brojUloga;
    }

    public void setBrojUloga(int brojUloga) {
        this.brojUloga = brojUloga;
    }

    public int getDuzinaTrajanja() {
        return duzinaTrajanja;
    }

    public void setDuzinaTrajanja(int duzinaTrajanja) {
        this.duzinaTrajanja = duzinaTrajanja;
    }

    @XmlTransient
    public List<Zanr> getZanrList() {
        return zanrList;
    }

    public void setZanrList(List<Zanr> zanrList) {
        this.zanrList = zanrList;
    }

    @XmlTransient
    public List<Uloga> getUlogaList() {
        return ulogaList;
    }

    public void setUlogaList(List<Uloga> ulogaList) {
        this.ulogaList = ulogaList;
    }

    @XmlTransient
    public List<Ocena> getOcenaList() {
        return ocenaList;
    }

    public void setOcenaList(List<Ocena> ocenaList) {
        this.ocenaList = ocenaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filmID != null ? filmID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.filmID == null && other.filmID != null) || (this.filmID != null && !this.filmID.equals(other.filmID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Film{" + "filmID=" + filmID + ", naziv=" + naziv + ", godina=" + godina + ", opis=" + opis + ", brojUloga=" + brojUloga + ", duzinaTrajanja=" + duzinaTrajanja + '}';
    }

    @Override
    public Object getRecord(EntityManager em, UserTransaction userTxn) throws Exception {
        try {
            Film f = em.find(Film.class,
                    this.getFilmID());
            if (f == null) {
                throw new Exception("Error, no such movie.");
            }
            return f;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw e;
        }
    }

    @Override
    public List<? extends Record> getRecords(EntityManager em, UserTransaction userTxn) {
        TypedQuery tq = em.createNamedQuery("Film.findAll", Film.class);
        List<Film> lista = new ArrayList<>(tq.getResultList());
        return lista;
    }

    @Override
    public void deleteRecord(EntityManager em, UserTransaction userTxn) {
        try {
            userTxn.begin();
            em.remove(em.merge(this));
            userTxn.commit();
        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            Logger.getLogger(Korisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addRecord(EntityManager em, UserTransaction userTxn) {
        try {
            userTxn.begin();
            em.persist(this);
            userTxn.commit();
        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            Logger.getLogger(Korisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateRecord(EntityManager em, UserTransaction userTxn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public Object getRecordHelp(EntityManager em, UserTransaction userTxn) throws Exception {
        try {
            TypedQuery tq = em.createNamedQuery("Film.findByNaziv", Film.class).setParameter("naziv", this.naziv);
            if (tq.getResultList().isEmpty()) {
                return "1";
            } else {
                return "0";
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw e;
        }}

}

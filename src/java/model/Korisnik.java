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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "korisnik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Korisnik.findByUsernameAndPassword", query = "SELECT k FROM Korisnik k WHERE k.username = :username AND k.password = :password")
    , @NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k")
    , @NamedQuery(name = "Korisnik.findByKorisnikID", query = "SELECT k FROM Korisnik k WHERE k.korisnikID = :korisnikID")
    , @NamedQuery(name = "Korisnik.findByUsername", query = "SELECT k FROM Korisnik k WHERE k.username = :username")
    , @NamedQuery(name = "Korisnik.findByPassword", query = "SELECT k FROM Korisnik k WHERE k.password = :password")
    , @NamedQuery(name = "Korisnik.findByAdministrator", query = "SELECT k FROM Korisnik k WHERE k.administrator = :administrator")})
public class Korisnik implements Serializable, Record {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KorisnikID")
    private Integer korisnikID;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 30)
    @Column(name = "Username")
    private String username;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 30)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "Administrator")
    private boolean administrator;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "korisnik")
    private List<Ocena> ocenaList;

    public Korisnik() {
    }

    public Korisnik(Integer korisnikID) {
        this.korisnikID = korisnikID;
    }

    public Korisnik(Integer korisnikID, String username, String password, boolean administrator) {
        this.korisnikID = korisnikID;
        this.username = username;
        this.password = password;
        this.administrator = administrator;
    }

    public Integer getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(Integer korisnikID) {
        this.korisnikID = korisnikID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
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
        hash += (korisnikID != null ? korisnikID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.korisnikID == null && other.korisnikID != null) || (this.korisnikID != null && !this.korisnikID.equals(other.korisnikID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Korisnik{" + "korisnikID=" + korisnikID + ", username=" + username + ", password=" + password + ", administrator=" + administrator + '}';
    }

    @Override
    public Object getRecord(EntityManager em, UserTransaction userTxn) throws Exception {
        try {

            TypedQuery kor = em.createNamedQuery("Korisnik.findByUsernameAndPassword", Korisnik.class).setParameter("username", this.username).setParameter("password", this.password);
            if (kor.getResultList().isEmpty()) {
                return null;
            } else {

                Korisnik k = (Korisnik) kor.getResultList().get(0);
                return k;
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw e;
        }
    }

    @Override
    public List<? extends Record> getRecords(EntityManager em, UserTransaction userTxn) {

        TypedQuery tq =  em.createNamedQuery("Korisnik.findByAdministrator", Korisnik.class).setParameter("administrator", false);
        List<Korisnik> lista = new ArrayList<>(tq.getResultList());
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
            Logger.getLogger(Korisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateRecord(EntityManager em, UserTransaction userTxn) {
        try {
            userTxn.begin();
            em.merge(this);
            userTxn.commit();
        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            Logger.getLogger(Korisnik.class.getName()).log(Level.SEVERE, null, ex);
        }}

    @Override
    public Object getRecordHelp(EntityManager em, UserTransaction userTxn) throws Exception {
         try {
            TypedQuery kor = em.createNamedQuery("Korisnik.findByUsername", Korisnik.class).setParameter("username", this.username);
            if (kor.getResultList().isEmpty()) {
                return "1";
            } else {
                return "0";
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw e;
        }
    }

}

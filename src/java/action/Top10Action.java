/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dbbroker.DBBroker;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Pomocna;


public class Top10Action extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        try {

            HttpSession sesija = request.getSession(true);

            EntityManager em = DBBroker.getInstance().getEm();
            Query q2 = em.createNativeQuery("SELECT f.filmid, f.naziv, f.godina,ROUND(AVG(o.ocena),1) AS AvgRating FROM film f JOIN ocena o ON f.filmid=o.filmid GROUP BY f.filmid, f.naziv, f.godina ORDER BY AvgRating DESC LIMIT 10");
            List<Object[]> rs = q2.getResultList();

            List<Pomocna> lista = new ArrayList<>(10);

            for (Object[] f : rs) {
                Pomocna p =  new Pomocna();
                p.setFilmID((long) f[0]);
                    p.setGodina((int) f[2]);
                    p.setNaziv((String) f[1]);
                    p.setOcena((BigDecimal) f[3]);
                lista.add(p);
            }

            sesija.setAttribute("lista_top10", lista);
            return "top10";

        } catch (Exception ex) {
            Logger.getLogger(Top10Action.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return "error";
        }
    }
}


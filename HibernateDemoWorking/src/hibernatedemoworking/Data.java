/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatedemoworking;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * SINGLETON PATTERN COURTESY OF BRO. TUCKETT
 *
 * Add Sword Functionality is jamesK
 *
 * @author jamesK
 */
public class Data {

    private Sword s = null;
    SessionFactory factory = null;
    Session session = null;

    private static Data single_instance = null;

    private Data() {
        factory = HibernateUtil.getSessionFactory();
    }

    public static Data getInstance() {
        if (single_instance == null) {
            single_instance = new Data();
        }

        return single_instance;
    }

    public Sword getSwordsById(int id) {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from hibernatedemoworking.Sword where swordID=" + Integer.toString(id);
            Sword s = (Sword)session.createQuery(sql).uniqueResult();
            session.getTransaction().commit();
            return s;

        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public List<Sword> getSwords() {
    
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from hibernatedemoworking.Sword";
            List<Sword> cs = (List<Sword>)session.createQuery(sql).getResultList();
            session.getTransaction().commit();
            return cs;

        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
        
    }
    
    public void addSword(String name, String culture, String shape) {

        try {
            s = new Sword(name, culture, shape);
            //s = new Sword("Longsword", "European", "Straight");
            session = factory.openSession();
            session.beginTransaction();
            session.save(s);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();

        } finally {
            session.close();
        }
    }
    
    public Sword getSwordByName(String name) {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from hibernatedemoworking.Sword where swordName=" + name;
            Sword s = (Sword)session.createQuery(sql).uniqueResult();
            session.getTransaction().commit();
            return s;

        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }
}

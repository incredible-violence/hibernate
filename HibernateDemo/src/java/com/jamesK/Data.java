/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jamesK;

import hibernatedemoworking.Sword;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * SINGLETON PATTERN COURTESY OF BRO. TUCKETT
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
        session = factory.openSession();
        session.getTransaction().begin();
        String sql = "from com.jamesK.Sword where swordID=" + Integer.toString(id);
        // Sword s = (Sword)session.createQuery(sql).getSingleResult();
        session.getTransaction().commit();
        return s;       
    }

    public void addSword(/*String name, String culture, String shape*/) {

        try {
            // s = new Sword(name, culture, shape);
            s = new Sword("Longsword", "European", "Straight");
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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Usuario1
 */ 
public class HibernateUtil {

    private static SessionFactory sessionFactory = null;
    protected Session sesion;
    protected Transaction transaction;
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            try {
                throw new Exception(e);
            } catch (Exception ex) {
                Logger.getLogger(HibernateUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void obtenerSesion(){
        if( (sesion != null) && (sesion.isOpen()) ){
            cerrar();
        }
        sesion = sessionFactory.openSession();
    }

    public void cerrar() {
        if( (sesion != null) && (sesion.isOpen()) ){
            sesion.close();
        }
    }
}

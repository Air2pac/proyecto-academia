/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.JDBCException;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.StaleStateException;

public class DaoGenerico extends HibernateUtil implements Serializable{

    public DaoGenerico() {
    }
    
    public List<Object> Leer(String clase, String where){
        List<Object> lista = new ArrayList();
        try{
            this.obtenerSesion();
            transaction = sesion.beginTransaction();
            lista = sesion.createQuery("from "+clase+" "+where).list();
        }catch(JDBCException jdbc){
            System.out.println("Codigo error: "+jdbc.getErrorCode());
            System.out.println("Mensaje error: "+jdbc.getMessage());
            System.out.println("Excepcion: "+jdbc.getSQLException());
            System.out.println("Estado de Mysql: "+jdbc.getSQLState());
            if(transaction != null){
                transaction.rollback();
            }
        }catch(RuntimeException ex){
            System.out.println("Error "+ex.getLocalizedMessage());
            System.out.println("Error: "+ex.getMessage());
            System.out.println("Ha ocurrido un error de ejecucion");
            System.out.println(ex.getMessage());
            System.out.println("Fin de mensaje de excepcion");
        }finally{
            cerrar();
        }
        return lista;
    }
    
    public void InsertarOActualizar(Object ob){
        try {
            this.obtenerSesion();
            transaction = sesion.beginTransaction();
            sesion.saveOrUpdate(ob);
            transaction.commit();
        } catch (JDBCException e) {
            System.out.println("Codigo error: "+e.getErrorCode());
            System.out.println("Mensaje error:"+e.getMessage());
            System.out.println("Mensaje error"+e.getSQL());
            System.out.println("Mensaje error:"+e.getSQLException());
            if(transaction != null){
                transaction.rollback();
            }
        } catch(NonUniqueObjectException nuoe){
            System.out.println("MEnsaje error: "+nuoe.getMessage());
            if(transaction != null){
                transaction.rollback();
            }
        }finally{
            cerrar();
        }
    }
    
    public void Borrar(Object o){
        try {
            this.obtenerSesion();
            transaction = sesion.beginTransaction();
            sesion.delete(o);
            transaction.commit();
        } catch (StaleStateException sse) {
             System.out.println("MEnsaje error: "+sse.getMessage());
            if(transaction != null){
                transaction.rollback();
            }
        }finally{
            cerrar();
        }
    }
}

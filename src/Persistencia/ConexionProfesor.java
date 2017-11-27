package Persistencia;

import java.util.List;

import model.Asignatura;
import model.Estudiante;
import model.Profesor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ConexionProfesor {
	private static SessionFactory sessionFactory;
	private static Session session;
	
	public ConexionProfesor(){
		Configuration configuration = new Configuration(); 
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
		//session =sessionFactory.openSession(); 
	}
	public boolean eliminarProfesor(Profesor profesor){
		boolean pasa=true;
		session =sessionFactory.openSession(); 
		session.beginTransaction(); 
		try {
		 session.delete(profesor); 
		 System.out.println("Se ha eliminado");
		 session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Error al modificar " + e);
			pasa=false;
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		
		return pasa;
	}
	public boolean modificarProfesor(Profesor profesor){
		boolean pasa=true;
		session =sessionFactory.openSession(); 
		session.beginTransaction(); 
		try {
		 session.update(profesor); 
		 System.out.println("Se ha modificado");
		 session.getTransaction().commit();
		
		}catch(Exception e) {
			System.out.println("Error al modificar " + e);
			pasa=false;
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		
		return pasa;
	}
	
	
	public boolean insertarProfesor(Profesor profesor){
		boolean pasa=true;
		session =sessionFactory.openSession(); 
		session.beginTransaction(); 
		try {
		 session.save(profesor); 
		 System.out.println("Se ha insertado");
		 session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Error al modificar " + e);
			pasa=false;
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		
		return pasa;
	}
	
	public List<Asignatura> listarAsingatura(){
		session = sessionFactory.openSession();
		Query query = session.createQuery("SELECT a.asi_des FROM Asignatura a");
		List<Asignatura> listaAsignaturas = query.list();
		session.close();
		return listaAsignaturas;
	}
	public List<Profesor> listarProfesores(){
		session = sessionFactory.openSession();
		Query query = session.createQuery("SELECT p FROM Profesor p");
		List<Profesor> listaProfesor = query.list();
		session.close();
		return listaProfesor;
	}
	
	
	public Profesor devolverProfesor(int id){
		session = sessionFactory.openSession();
		Profesor profesor = (Profesor) session.createQuery("SELECT p FROM Profesor p WHERE p.pro_id=" + id + "")
				.uniqueResult();
		session.close();
		return profesor;
	}
	
	public Asignatura devolverAsignatura(String des){
		session = sessionFactory.openSession();
		Asignatura asignatura = (Asignatura) session.createQuery(
				"SELECT a FROM Asignatura a WHERE a.asi_des='" + des + "'")
				.uniqueResult();
		session.close();
		return asignatura;
	}
	
	public boolean insertarProfAsignatura(Profesor profesor){
		boolean pasa=true;
		session =sessionFactory.openSession(); 
		session.beginTransaction(); 
		try {
		 session.saveOrUpdate(profesor); 
		 System.out.println("Se ha insertado");
		 session.getTransaction().commit();
		session.close();
		}catch(Exception e) {
			System.out.println("Error al modificar " + e);
			pasa=false;
			session.getTransaction().rollback();
		}
		
		return pasa;
	}
}

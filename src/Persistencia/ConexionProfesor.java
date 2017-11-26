package Persistencia;

import java.util.List;

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
		session.close();
		}catch(Exception e) {
			System.out.println("Error al modificar " + e);
			pasa=false;
			session.getTransaction().rollback();
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
		session.close();
		}catch(Exception e) {
			System.out.println("Error al modificar " + e);
			pasa=false;
			session.getTransaction().rollback();
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
		session.close();
		}catch(Exception e) {
			System.out.println("Error al modificar " + e);
			pasa=false;
			session.getTransaction().rollback();
		}
		
		return pasa;
	}
	
	public List<Profesor> listarAsingatura(){
		session = sessionFactory.openSession();
		Query query = session.createQuery("SELECT a.asi_des FROM Asignatura a");
		List<Profesor> listaAsignaturas = query.list();
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
	
	public Profesor devolverAsignatura(String des){
		session = sessionFactory.openSession();
		Profesor asignatura = (Profesor) session.createQuery("SELECT a FROM Asignatura a WHERE a.asi_des='" + des + "'")
				.uniqueResult();
		session.close();
		return asignatura;
	}
	
	/*public boolean insertarEstuAsignatura(Profesor estudiante){
		boolean pasa=true;
		session =sessionFactory.openSession(); 
		session.beginTransaction(); 
		System.out.println("--------" + estudiante.getEst_nombre());
		try {
		 session.saveOrUpdate(estudiante); 
		 System.out.println("Se ha insertado");
		 session.getTransaction().commit();
		session.close();
		}catch(Exception e) {
			System.out.println("Error al modificar " + e);
			pasa=false;
			session.getTransaction().rollback();
		}
		
		return pasa;
	}*/
}

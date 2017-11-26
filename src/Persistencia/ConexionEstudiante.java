package Persistencia;
import java.util.List;

import model.Asignatura;
import model.Curso;
import model.Estudiante;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class ConexionEstudiante {
	private static SessionFactory sessionFactory;
	private static Session session;
	
	public ConexionEstudiante(){
		Configuration configuration = new Configuration(); 
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
		//session =sessionFactory.openSession(); 
	}
	
	public boolean modificarEstudiante(Estudiante estudiante){
		boolean pasa=true;
		session =sessionFactory.openSession(); 
		session.beginTransaction(); 
		System.out.println("--------" + estudiante.getEst_nombre());
		try {
		 session.update(estudiante); 
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
	
	
	public boolean insertarEstudiante(Estudiante estudiante){
		boolean pasa=true;
		session =sessionFactory.openSession(); 
		session.beginTransaction(); 
		System.out.println("--------" + estudiante.getEst_nombre());
		try {
		 session.save(estudiante); 
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
	
	public List<Asignatura> listarAsingatura(){
		session = sessionFactory.openSession();
		Query query = session.createQuery("SELECT a.asi_des FROM Asignatura a");
		List<Asignatura> listaAsignaturas = query.list();
		session.close();
		return listaAsignaturas;
	}
	public List<Estudiante> listarEstudiante(){
		session = sessionFactory.openSession();
		Query query = session.createQuery("SELECT e FROM Estudiante e");
		List<Estudiante> listaEstudiantes = query.list();
		session.close();
		return listaEstudiantes;
	}
	
	public Asignatura devolverAsignatura(String des){
		session = sessionFactory.openSession();
		Asignatura asignatura = (Asignatura) session.createQuery(
				"SELECT a FROM Asignatura a WHERE a.asi_des='" + des + "'")
				.uniqueResult();
		session.close();
		return asignatura;
	}
	
	public boolean insertarEstuAsignatura(Estudiante estudiante){
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
	}
	
}

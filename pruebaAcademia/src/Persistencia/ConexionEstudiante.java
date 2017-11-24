package Persistencia;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import model.Curso;
import model.Estudiante;


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
}

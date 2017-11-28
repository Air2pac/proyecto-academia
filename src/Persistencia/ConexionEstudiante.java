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
		Query query = session.createQuery("SELECT a.asi_des, a.curso.cur_des FROM Asignatura a");
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
	
	public Asignatura devolverAsignatura(String des ,String curso){
		session = sessionFactory.openSession();
		Asignatura asignatura = (Asignatura) session.createQuery(
				"SELECT a FROM Asignatura a WHERE a.asi_des='" + des + "' and a.curso.cur_des='"+curso+"'")
				.uniqueResult();
		
		System.out.println(asignatura.getAsi_des());
		session.close();
		return asignatura;
	}
	
	public boolean insertarEstuAsignatura(Estudiante estudiante){
		boolean pasa=true;
		session =sessionFactory.openSession(); 
		session.beginTransaction(); 
		try {
		 session.saveOrUpdate(estudiante); 
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

	public boolean existeDni(String est_dni) {
		
		boolean existe = false;
		
		session = sessionFactory.openSession();
		
		Query query = session.createQuery("SELECT e FROM Estudiante e where e.est_dni='"+est_dni+"'");
		List<Asignatura> listaAsignaturas = query.list();
		if(listaAsignaturas.size()>0){
			existe=true;
		}
		session.close();
		

		return existe;
	}
	
	public List<Estudiante> consultaEstAsig(String ape1){
		
		session = sessionFactory.openSession();
		
		Query query = session.createQuery("SELECT e FROM Estudiante e where e.est_ape1 like '" + ape1 + "%'");
		List<Estudiante> listaEstudiantes = query.list();
		System.out.println(listaEstudiantes.size());
		session.close();
		

		return listaEstudiantes;
	}
	
}

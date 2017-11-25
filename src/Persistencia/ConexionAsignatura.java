package Persistencia;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import model.Asignatura;
import model.Curso;



public class ConexionAsignatura {
	private static SessionFactory sessionFactory;
	private static Session session;
	
	public ConexionAsignatura(){
		Configuration configuration = new Configuration(); 
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
		//session =sessionFactory.openSession(); 
	}
	
	public boolean insertarCurso(Asignatura asignatura){
		boolean pasa=true;
		session =sessionFactory.openSession(); 
		session.beginTransaction(); 

		try {
		 session.save(asignatura); 
		 System.out.println("Se ha guardado");
		 session.getTransaction().commit();
		
		}catch(Exception e) {
			System.out.println("Error al guardar " + e);
			pasa=false;
			session.getTransaction().rollback();
		}
		session.close();
		return pasa;
	}
	
	public boolean eliminarCurso(Asignatura asignatura){
	
		
		boolean pasa=true;
		session =sessionFactory.openSession(); 
		session.beginTransaction(); 

		try {
		 session.delete(asignatura); 
		 System.out.println("Se ha eliminado");
		 session.getTransaction().commit();
		
		}catch(Exception e) {
			System.out.println("Error al eliminar " + e);
			pasa=false;
			session.getTransaction().rollback();
		}
		session.close();
		return pasa;
	}
	
	public boolean modificarCurso(Asignatura asignatura){
		boolean pasa=true;
		session =sessionFactory.openSession(); 
		session.beginTransaction(); 
		
		try {
		 session.update(asignatura); 
		 System.out.println("Se ha modificado");
		 session.getTransaction().commit();
		
		}catch(Exception e) {
			System.out.println("Error al modificar " + e);
			pasa=false;
			session.getTransaction().rollback();
		}
		session.close();
		return pasa;
	}
	
	public List<Asignatura> listarCursos(){
		
		Query query = session.createQuery("SELECT a FROM Asignatura a");
		List<Asignatura> listaAsignaturas = query.list();
		return listaAsignaturas;
	}
	
	public String devolverDescripcion(int id){
		Asignatura asignatura = (Asignatura) session.createQuery("SELECT a FROM Asignatura a WHERE asi_des="+id+"").uniqueResult();
		return asignatura.getAsi_des();
	}
	
	public List<Curso> listarCursos(){
		
		Query query = session.createQuery("SELECT a FROM Curso c");
		List<Curso> listaCurso = query.list();
		return listaCurso;
	}
}

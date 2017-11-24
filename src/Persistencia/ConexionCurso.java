package Persistencia;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import model.Curso;



public class ConexionCurso {
	private static SessionFactory sessionFactory;
	private static Session session;
	
	public ConexionCurso(){
		Configuration configuration = new Configuration(); 
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
		//session =sessionFactory.openSession(); 
	}
	
	public boolean insertarCurso(Curso curso){
		boolean pasa=true;
		session =sessionFactory.openSession(); 
		session.beginTransaction(); 

		try {
		 session.save(curso); 
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
	
	public boolean eliminarCurso(Curso curso){
	
		
		boolean pasa=true;
		session =sessionFactory.openSession(); 
		session.beginTransaction(); 

		try {
		 session.delete(curso); 
		 System.out.println("Se ha eliminado");
		 session.getTransaction().commit();
		
		}catch(Exception e) {
			System.out.println("Error al eliminar " + e);
			pasa=false;
			session.getTransaction().rollback();
		}
		
		return pasa;
	}
	
	public boolean modificarCurso(Curso curso){
		boolean pasa=true;
		session =sessionFactory.openSession(); 
		session.beginTransaction(); 
		System.out.println("--------" + curso.getCur_des());
		try {
		 session.update(curso); 
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
	
	public List<Curso> listarCursos(){
		
		Query query = session.createQuery("SELECT c FROM PraCursos c");
		List<Curso> listaCursos = query.list();
		return listaCursos;
	}
	
	public String devolverNombre(int id){
		Curso curso = (Curso) session.createQuery("SELECT c FROM PraCursos c WHERE c.curId="+id+"").uniqueResult();
		return curso.getCur_des();
	}
}

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
		session.close();
		return pasa;
	}
	
	public boolean modificarCurso(Curso curso){
		boolean pasa=true;
		session =sessionFactory.openSession(); 
		session.beginTransaction(); 
		System.out.println("// " + curso.getCur_id() + " // " + curso.getCur_des());
		
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
		session =sessionFactory.openSession();
		Query query = session.createQuery("SELECT c FROM Curso c");
		List<Curso> listaCursos = query.list();
		session.close();
		return listaCursos;
	}
	
	public String devolverNombre(int id){
		session =sessionFactory.openSession();
		Curso curso = (Curso) session.createQuery("SELECT c FROM Curso c WHERE c.cur_id="+id+"").uniqueResult();
		session.close();
		return curso.getCur_des();
	}
	
	public Curso devolverCurso(int id){
		session =sessionFactory.openSession();
		Curso curso = (Curso) session.createQuery("SELECT c FROM Curso c WHERE c.cur_id="+id+"").uniqueResult();
		session.close();
		return curso;
		
		
	}
	
	
	public boolean existeCurso(String des){
		boolean existe = false;
		
		session = sessionFactory.openSession();
		
		Query query = session.createQuery("SELECT c FROM Curso c where c.cur_des='"+des+"'");
		List<Curso> listaCursos = query.list();
		if(listaCursos.size()>0){
			existe=true;
		}
		session.close();
		

		return existe;
	}
}

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

	public ConexionAsignatura() {
		Configuration configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	//Método para insertar una asignatura
	public boolean insertarAsignatura(Asignatura asignatura) {
		boolean pasa = true;
		session = sessionFactory.openSession();
		session.beginTransaction();

		try {
			session.save(asignatura);
			System.out.println("Se ha guardado");
			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Error al guardar " + e);
			pasa = false;
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		return pasa;
	}
	//Método para eliminar una asignatura
	public boolean eliminarAsignatura(Asignatura asignatura) {

		boolean pasa = true;
		session = sessionFactory.openSession();
		session.beginTransaction();

		try {
			session.delete(asignatura);
			System.out.println("Se ha eliminado");
			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Error al eliminar " + e);
			pasa = false;
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		return pasa;
	}
	//Método para modificar una asignatura
	public boolean modificarAsignatura(Asignatura asignatura) {
		boolean pasa = true;
		session = sessionFactory.openSession();
		session.beginTransaction();

		try {
			session.update(asignatura);
			System.out.println("Se ha modificado");
			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Error al modificar " + e);
			pasa = false;
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		return pasa;
	}
	//Método para listar las asignaturas
	public List<Asignatura> listarAsignaturas() {
		session = sessionFactory.openSession();
		//session.beginTransaction();
		Query query = session.createQuery("SELECT a FROM Asignatura a");
		List<Asignatura> listaAsignaturas = query.list();
		session.close();
		return listaAsignaturas;

	}
	//Método para devolver la descripción de la asignatura según su id
	public String devolverDescripcion(int id) {
		session = sessionFactory.openSession();
		//Al ser una consulta de resultado único utilizo uniqueResult
		Asignatura asignatura = (Asignatura) session.createQuery(
				"SELECT a FROM Asignatura a WHERE asi_id=" + id + "")
				.uniqueResult();
		
		session.close();
		return asignatura.getAsi_des();
	}
	//Método para listar la descripcion de cursos
	public List<Curso> listarCursos() {
		session = sessionFactory.openSession();
		//session.beginTransaction();
		Query query = session.createQuery("SELECT c.cur_des FROM Curso c");
		List<Curso> listaCurso = query.list();
		session.close();
		return listaCurso;
	}
	//Método para devolver el id de la descripción del curso que nos mandens
	public int devolverIdCurso(String des) {
		session = sessionFactory.openSession();
		//session.beginTransaction();*/
		Curso curso = (Curso) session.createQuery(
				"SELECT c FROM Curso c WHERE c.cur_des='" + des + "'")
				.uniqueResult();
		session.close();
		

		return curso.getCur_id();
	}
	//	//Método para comprobar si existe la asignatura en el curso
	public boolean existeAsignatura(String des, String cur){
		boolean existe = false;
		
		session = sessionFactory.openSession();
		
		Query query = session.createQuery("SELECT a FROM Asignatura a where a.asi_des='"+des+"' and a.curso.cur_des ='"+cur+"'");
		List<Asignatura> listaAsignaturas = query.list();
		if(listaAsignaturas.size()>0){
			existe=true;
		}
		session.close();
		

		return existe;
	}
	
	//Método para listar las asignaturas de un curso correspondiente
	public List<Asignatura> consultaCurAsig(String cur){

		
		session = sessionFactory.openSession();
		
		Query query = session.createQuery("SELECT a FROM Asignatura a where a.curso.cur_des ='"+cur+"'");
		List<Asignatura> listaAsignaturas = query.list();
		
		session.close();
		

		return listaAsignaturas;
	}
	

}

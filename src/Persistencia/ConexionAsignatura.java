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
		// session =sessionFactory.openSession();
	}

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

	public List<Asignatura> listarAsignaturas() {
		session = sessionFactory.openSession();
		//session.beginTransaction();
		Query query = session.createQuery("SELECT a FROM Asignatura a");
		List<Asignatura> listaAsignaturas = query.list();
		session.close();
		return listaAsignaturas;

	}

	public String devolverDescripcion(int id) {
		session = sessionFactory.openSession();
		//session.beginTransaction();
		Asignatura asignatura = (Asignatura) session.createQuery(
				"SELECT a FROM Asignatura a WHERE asi_id=" + id + "")
				.uniqueResult();
		
		session.close();
		return asignatura.getAsi_des();
	}

	public List<Curso> listarCursos() {
		session = sessionFactory.openSession();
		//session.beginTransaction();
		Query query = session.createQuery("SELECT c.cur_des FROM Curso c");
		List<Curso> listaCurso = query.list();
		session.close();
		return listaCurso;
	}

	public int devolverIdCurso(String des) {
		session = sessionFactory.openSession();
		//session.beginTransaction();*/
		Curso curso = (Curso) session.createQuery(
				"SELECT c FROM Curso c WHERE c.cur_des='" + des + "'")
				.uniqueResult();
		session.close();
		

		return curso.getCur_id();
	}
}

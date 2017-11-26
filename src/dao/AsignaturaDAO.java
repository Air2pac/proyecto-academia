package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Persistencia.ConexionAsignatura;
import Persistencia.ConexionCurso;

import com.opensymphony.xwork2.ActionSupport;

import model.Asignatura;
import model.Curso;


public class AsignaturaDAO extends ActionSupport {
	
	private Asignatura asignatura;
	private List<Asignatura> listadoAsignaturas = new ArrayList<Asignatura>();
	private Curso curso;
	private DaoGenerico dao = new DaoGenerico();
	ConexionAsignatura conexion = new ConexionAsignatura();
	private List<Curso> listCursos = new ArrayList<Curso>();
	
	public String listadoAsignaturas() {
		//Obtiene un listado de los estudiantes
		listadoAsignaturas = conexion.listarAsignaturas();
		return SUCCESS;
	}
	
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	public List<Asignatura> getListadoAsignaturas() {
		return listadoAsignaturas;
	}
	public void setListadoAsignaturas(List<Asignatura> listadoAsignaturas) {
		this.listadoAsignaturas = listadoAsignaturas;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public List<Curso> getListCursos() {
		return listCursos;
	}

	public void setListCursos(List<Curso> listCursos) {
		this.listCursos = listCursos;
	}
	
	public String abrirAddAsignatura(){
		setListCursos(conexion.listarCursos());
		return SUCCESS;
	}

	public String insertarAsignatura(){
		
		int id = conexion.devolverIdCurso(asignatura.getCurso().getCur_des());
		
		curso = asignatura.getCurso();
		curso.setCur_id(id);
		asignatura.setCurso(curso);
		boolean pasa = conexion.insertarAsignatura(asignatura);
		
		if(pasa) {
			listadoAsignaturas.clear();
			listadoAsignaturas = conexion.listarAsignaturas();
			return SUCCESS;
		}else {
			System.out.println("error");
			return INPUT;
		}
	}
	
	public String borrarAsignatura(){
		System.out.println(asignatura.getAsi_id());
		conexion.eliminarAsignatura(asignatura);
		listadoAsignaturas.clear();
		listadoAsignaturas = conexion.listarAsignaturas();
		return SUCCESS;
	}
	
	public String abrirModificarAsignatura(){
		setListCursos(conexion.listarCursos());
		listadoAsignaturas.clear();
		listadoAsignaturas = (ArrayList)dao.Leer("Asignatura", "where asi_id="+asignatura.getAsi_id()+"");
		asignatura = listadoAsignaturas.get(0);
		return SUCCESS;
	}
	
	
public String modificarAsignatura(){
	boolean pasa= true;
	
	int id = conexion.devolverIdCurso(asignatura.getCurso().getCur_des());
	curso = asignatura.getCurso();
	curso.setCur_id(id);
	asignatura.setCurso(curso);	
	
	Configuration configuration = new Configuration();
	configuration.configure();
	SessionFactory sessionFactory = configuration.buildSessionFactory();
	Session session =sessionFactory.openSession();
	
	session.beginTransaction();

	try {
		session.update(asignatura);
		System.out.println("Se ha modificado");
		session.getTransaction().commit();

	} catch (Exception e) {
		System.out.println("Error al modificar " + e);
		pasa=false;
		session.getTransaction().rollback();
	}finally{
		session.close();
	}
	
//	boolean pasa = conexion.modificarAsignatura(asignatura);
		
		if(pasa) {
			listadoAsignaturas.clear();
			listadoAsignaturas = conexion.listarAsignaturas();
			return SUCCESS;
		}else {
			return INPUT;
		}
	}
}

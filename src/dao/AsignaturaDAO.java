package dao;

import java.util.ArrayList;
import java.util.List;

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
	private List<Curso> listaCursos = new ArrayList<Curso>();
	
	public String listadoAsignaturas() {
		//Obtiene un listado de los estudiantes
		listadoAsignaturas = (ArrayList)dao.Leer("Asignatura", "");
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
		
	public String abrirAddAsignatura(){
		return SUCCESS;
	}

	
}

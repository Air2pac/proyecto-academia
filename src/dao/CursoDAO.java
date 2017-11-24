package dao;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Persistencia.ConexionCurso;
import model.Curso;

public class CursoDAO extends ActionSupport {
	
	private Curso curso;
	private List<Curso> listadoCursos = new ArrayList<Curso>();
	private DaoGenerico dao = new DaoGenerico();
	ConexionCurso conexion = new ConexionCurso();
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	public String listadoCursos() {
		//Obtiene un listado de los estudiantes
		listadoCursos = (ArrayList)dao.Leer("Curso", "");
		return SUCCESS;
	}

	public List<Curso> getListadoCursos() {
		return listadoCursos;
	}

	public void setListadoCursos(List<Curso> listadoCursos) {
		this.listadoCursos = listadoCursos;
	}

	public String borrarCurso() {
		System.out.println("pasa");
		System.out.println("--- " + curso.getCur_id());
			conexion.eliminarCurso(curso);
			//dao.Borrar(estudiante);
			listadoCursos.clear();
			listadoCursos = (ArrayList)dao.Leer("Curso", "");
			return SUCCESS;
		
	}
}

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
		// Obtiene un listado de los estudiantes
		listadoCursos = conexion.listarCursos();
		return SUCCESS;
	}

	public List<Curso> getListadoCursos() {
		return listadoCursos;
	}

	public void setListadoCursos(List<Curso> listadoCursos) {
		this.listadoCursos = listadoCursos;
	}

	public String borrarCurso() {
		conexion.eliminarCurso(curso);
		// dao.Borrar(estudiante);
		listadoCursos.clear();
		listadoCursos = conexion.listarCursos();
		return SUCCESS;

	}

	public String abrirAddCurso() {
		return SUCCESS;
	}

	public String insertarCurso() {

		boolean pasa = conexion.insertarCurso(curso);

		if (pasa) {
			listadoCursos.clear();
			listadoCursos = conexion.listarCursos();
			return SUCCESS;
		} else {
			System.out.println("error");
			return INPUT;
		}
	}

	public String abrirModificarCurso() {
		if(curso.getCur_des()==null){
			System.out.println("es nulo");
		}else{
			System.out.println("paeeeesa" + curso.getCur_des());
		}
		
		listadoCursos.clear();
		listadoCursos.add(conexion.devolverCurso(curso.getCur_id()));
		curso = listadoCursos.get(0);
		System.out.println(curso.getCur_des());
		return SUCCESS;
	}

	public String modificarCurso() {
		boolean pasa = conexion.modificarCurso(curso);

		if (pasa) {
			listadoCursos.clear();
			listadoCursos = conexion.listarCursos();
			return SUCCESS;
		} else {
			return INPUT;
		}
	}
}

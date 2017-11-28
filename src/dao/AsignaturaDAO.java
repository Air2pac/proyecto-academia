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
		// Obtiene un listado de los estudiantes
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

	public String abrirAddAsignatura() {
		setListCursos(conexion.listarCursos());
		return SUCCESS;
	}

	public String insertarAsignatura() {
		//Se guarda el id del curso
		int id = conexion.devolverIdCurso(asignatura.getCurso().getCur_des());

		curso = asignatura.getCurso();
		curso.setCur_id(id);
		asignatura.setCurso(curso);
		//Le paso al metodo de insertar la asignatura
		boolean pasa = conexion.insertarAsignatura(asignatura);
		//Si devuelve true limpiamos la lista y la volvemos a cargar
		if (pasa) {
			listadoAsignaturas.clear();
			listadoAsignaturas = conexion.listarAsignaturas();
			return SUCCESS;
		} else {
		//Si sale false devolvemos input 
			System.out.println("error");
			return INPUT;
		}
	}

	public String borrarAsignatura() {
		//Le pasamos la asignatura que queremos borrar 
		conexion.eliminarAsignatura(asignatura);
		//Limpiamos y aztualizamos la lista
		listadoAsignaturas.clear();
		listadoAsignaturas = conexion.listarAsignaturas();
		return SUCCESS;
	}

	public String abrirModificarAsignatura() {
		//guardamos en una lista los cursos existentes
		setListCursos(conexion.listarCursos());
		//Limpiamos y guardamos los datos de la asignatura que hemos seleccionado
		listadoAsignaturas.clear();
		listadoAsignaturas = (ArrayList) dao.Leer("Asignatura", "where asi_id="+ asignatura.getAsi_id() + "");
		asignatura = listadoAsignaturas.get(0);
		return SUCCESS;
	}
	
	
	public String modificarAsignatura() {
	
		boolean pasa = true;
		//Guardamos el id segun su descripcion
		int id = conexion.devolverIdCurso(asignatura.getCurso().getCur_des());
		curso = asignatura.getCurso();
		curso.setCur_id(id);
		asignatura.setCurso(curso);
		//Llamamos al metodo pasandole la asignatura para que nos la modifique
		pasa=conexion.modificarAsignatura(asignatura);

		if (pasa) {
			listadoAsignaturas.clear();
			listadoAsignaturas = conexion.listarAsignaturas();
			return SUCCESS;
		} else {
			return INPUT;
		}
	}
	
	//Método para validar que se inserte correctamente la asignatura
	public void validateInsertarAsignatura(){
		//Compruebo que el campo no este vacío
		if(asignatura.getAsi_des() == null || asignatura.getAsi_des().trim().equals("")){
			abrirAddAsignatura();
			addFieldError("asi_des", "Descripción vacía");
		}else 
			// Compruebo que la asignatura no exista
		if(conexion.existeAsignatura(asignatura.getAsi_des(), asignatura.getCurso().getCur_des())){
			abrirAddAsignatura();
			addFieldError("asi_des", "asignatura existente en el curso");
		}
		//Compruebo que exista un curso
		if(asignatura.getCurso().getCur_des()==null ) {
			addFieldError("cur_id", "Debe existir un curso");
		}
	}
	//Método para validar que se Modifique correctamente la asignatura
	public void validateModificarAsignatura(){
		if(asignatura.getAsi_des() == null || asignatura.getAsi_des().trim().equals("")){
			abrirAddAsignatura();
			addFieldError("asi_des", "Descripción vacía");
		}else 
		if(conexion.existeAsignatura(asignatura.getAsi_des(), asignatura.getCurso().getCur_des())){
			abrirAddAsignatura();
			addFieldError("asi_des", "asignatura existente en el curso");
		}
//		if(curso==null || listCursos.size()==0) {
//			addFieldError("curso", "Debe existir un curso");
//		}
	}
	
	
	
	
	//Consultas
	
	public String consultaCurAsig() {
		//Mando success para que abra directamente el jsp
		return SUCCESS;
	}
	
	public String consAsigCur(){
		//Lamo al metodo para que me liste las asignaturas de un curso mediante su descripción
		setListadoAsignaturas(conexion.consultaCurAsig(asignatura.getCurso().getCur_des()));
		return SUCCESS;
	}
}

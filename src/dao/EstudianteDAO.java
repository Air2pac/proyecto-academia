package dao;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Persistencia.ConexionEstudiante;
import model.Asignatura;
import model.Estudiante;


public class EstudianteDAO extends ActionSupport {

	private Estudiante estudiante;	
	private List<Estudiante> listadoEstudiantes = new ArrayList<Estudiante>();
	DaoGenerico dao = new DaoGenerico();
	private ConexionEstudiante conexion = new ConexionEstudiante();
	private List<Asignatura> listAsignatura = new ArrayList<Asignatura>();
	private Asignatura asignatura;
	
	public String listadoEstudiantes() {
		//Obtiene un listado de los estudiantes
		
		listadoEstudiantes =conexion.listarEstudiante();
		
		return SUCCESS;
	}
	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	public List<Estudiante> getListadoEstudiantes() {
		return listadoEstudiantes;
	}

	public void setListadoEstudiantes(List<Estudiante> listadoEstudiantes) {
		this.listadoEstudiantes = listadoEstudiantes;
	}
	
	
	public String abrirAddEstudiantes() {
		return SUCCESS;
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public List<Asignatura> getListAsignatura() {
		return listAsignatura;
	}

	public void setListAsignatura(List<Asignatura> listAsignatura) {
		this.listAsignatura = listAsignatura;
	}
	

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	public String borrarEstudiantes() {
		dao.Borrar(estudiante);
		listadoEstudiantes.clear();
		listadoEstudiantes = conexion.listarEstudiante();
		return SUCCESS;
	}
	
	public String abrirModificarEstudiantes(){
		listadoEstudiantes.clear();
		listadoEstudiantes = (ArrayList)dao.Leer("Estudiante", "where est_id="+estudiante.getEst_id());
		estudiante = listadoEstudiantes.get(0);
		return SUCCESS;
	}
	
	
	public String modificarEstudiantes(){
		
//		listadoEstudiantes.clear();
//		listadoEstudiantes = (ArrayList)dao.Leer("Estudiante", "where est_id="+estudiante.getEst_id());
		//estudiante = listadoEstudiantes.get(0);
		
		boolean pasa = conexion.modificarEstudiante(estudiante);
		
		if(pasa) {
			listadoEstudiantes.clear();
			listadoEstudiantes = conexion.listarEstudiante();
			return SUCCESS;
		}else {
			return INPUT;
		}
	}
	
	
	public String insertarEstudiante() {
		boolean pasa = conexion.insertarEstudiante(estudiante);
		
		if(pasa) {
			listadoEstudiantes.clear();
			listadoEstudiantes = conexion.listarEstudiante();
			return SUCCESS;
		}else {
			System.out.println("error");
			return INPUT;
		}
	}
	
	public String abrirAddEstAsign(){
		setListAsignatura(conexion.listarAsingatura());
		listadoEstudiantes.clear();
		listadoEstudiantes = (ArrayList)dao.Leer("Estudiante", "where est_id="+estudiante.getEst_id());
		estudiante = listadoEstudiantes.get(0);
		return SUCCESS;
	}
	
	public String addEstAsign(){
		System.out.println("pasaa");
		
		System.out.println(asignatura.getAsi_des());

		asignatura = conexion.devolverAsignatura(asignatura.getAsi_des());
		estudiante.getAsignaturas().add(asignatura);
		asignatura.getEstudiantes().add(estudiante);
		boolean pasa = conexion.insertarEstuAsignatura(estudiante);
		
		if(pasa) {
			listadoEstudiantes.clear();
			listadoEstudiantes = conexion.listarEstudiante();
			return SUCCESS;
		}else {
			System.out.println("error");
			return INPUT;
		}
		
		
	}

	





	
}
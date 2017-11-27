package dao;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Persistencia.ConexionProfesor;
import model.Asignatura;
import model.Profesor;

public class ProfesorDAO extends ActionSupport{
	
	private Profesor profesor; 
	private List<Profesor> listadoProfesores = new ArrayList<>();
	private ConexionProfesor conexion = new ConexionProfesor();
	private List<Asignatura> listAsignatura = new ArrayList<Asignatura>();
	private Asignatura asignatura;
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public List<Profesor> getListadoProfesores() {
		return listadoProfesores;
	}
	public void setListadoProfesores(List<Profesor> listadoProfesores) {
		this.listadoProfesores = listadoProfesores;
	}
	public ConexionProfesor getConexion() {
		return conexion;
	}
	public void setConexion(ConexionProfesor conexion) {
		this.conexion = conexion;
	}
	public List<Asignatura> getListAsignatura() {
		return listAsignatura;
	}
	public void setListAsignatura(List<Asignatura> listAsignatura) {
		this.listAsignatura = listAsignatura;
	}
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	
	public String listadoProfesores(){
		listadoProfesores =conexion.listarProfesores();
		
		return SUCCESS;
	}
	public String abrirInsertarProfesor(){
		return SUCCESS;
	}
	
	public String insertarProfesor(){
		
		boolean pasa = conexion.insertarProfesor(profesor);
		
		if(pasa) {
			listadoProfesores.clear();
			listadoProfesores = conexion.listarProfesores();
			return SUCCESS;
		}else {
			System.out.println("error");
			return INPUT;
		}
	}
	
	public String borrarProfesor(){
		conexion.eliminarProfesor(profesor);
		// dao.Borrar(estudiante);
		listadoProfesores.clear();
		listadoProfesores = conexion.listarProfesores();
		return SUCCESS;
	}
	
	public String abrirModificarProfesor(){
		listadoProfesores.clear();
		listadoProfesores.add(conexion.devolverProfesor(profesor.getPro_id()));
		profesor = listadoProfesores.get(0);
		return SUCCESS;
	}
	
	public String modificarProfesor(){
		boolean pasa = conexion.modificarProfesor(profesor);

		if (pasa) {
			listadoProfesores.clear();
			listadoProfesores = conexion.listarProfesores();
			return SUCCESS;
		} else {
			return INPUT;
		}
	}
}

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
	DaoGenerico dao = new DaoGenerico();
	private List<Asignatura> listAsignatura = new ArrayList<Asignatura>();
	private String arrayAsignaturas [];
	private Asignatura asignatura;
	private String StrAsign;
	
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
	
	public String[] getArrayAsignaturas() {
		return arrayAsignaturas;
	}
	public void setArrayAsignaturas(String arrayAsignaturas[]) {
		this.arrayAsignaturas = arrayAsignaturas;
	}
	public String getStrAsign() {
		return StrAsign;
	}
	public void setStrAsign(String strAsign) {
		StrAsign = strAsign;
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
	public String abrirAddProAsign(){
		
		
		setListAsignatura(conexion.listarAsingatura());
	
		listadoProfesores.clear();
		listadoProfesores = (ArrayList)dao.Leer("Profesor", "where pro_id="+profesor.getPro_id());
		profesor = listadoProfesores.get(0);
		return SUCCESS;
	}
	
	public String addProAsign(){
		List<Asignatura> listAsig = new ArrayList<>();
		for (String a : arrayAsignaturas) {
			listAsig.add(conexion.devolverAsignatura(a));
		}
		for (Asignatura a : listAsig) {
			profesor.getAsignaturas().add(a);
		}
		for (Asignatura a : listAsig) {
			a.getProfesores().add(profesor);
		}
		
		boolean pasa = conexion.insertarProfAsignatura(profesor);
		if (pasa) {
			listadoProfesores.clear();
			listadoProfesores = conexion.listarProfesores();
			return SUCCESS;
		} else {
			return INPUT;
		}
	}
	
}

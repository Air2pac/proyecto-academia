package dao;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Persistencia.ConexionEstudiante;
import model.Estudiante;


public class EstudianteDAO extends ActionSupport {

	private Estudiante estudiante;	
	private List<Estudiante> listadoEstudiantes = new ArrayList<Estudiante>();
	DaoGenerico dao = new DaoGenerico();
	private ConexionEstudiante conexion = new ConexionEstudiante();
	
	
	public String listadoEstudiantes() {
		//Obtiene un listado de los estudiantes
		
		listadoEstudiantes = (ArrayList)dao.Leer("Estudiante", "");
		
		return SUCCESS;
	}

	public List<Estudiante> getListadoEstudiantes() {
		return listadoEstudiantes;
	}

	public void setListadoEstudiantes(List<Estudiante> listadoEstudiantes) {
		this.listadoEstudiantes = listadoEstudiantes;
	}
	
	public String borrarEstudiantes() {
		dao.Borrar(estudiante);
		listadoEstudiantes.clear();
		listadoEstudiantes = (ArrayList)dao.Leer("Estudiante", "");
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
			listadoEstudiantes = (ArrayList)dao.Leer("Estudiante", "");
			return SUCCESS;
		}else {
			return INPUT;
		}
	}
	
	
	public String insertarEstudiante() {
		boolean pasa = conexion.insertarEstudiante(estudiante);
		
		if(pasa) {
			listadoEstudiantes.clear();
			listadoEstudiantes = (ArrayList)dao.Leer("Estudiante", "");
			return SUCCESS;
		}else {
			System.out.println("error");
			return INPUT;
		}
	}
	
	public String abrirAddEstudiantes() {
		return SUCCESS;
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}


	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}


	
}
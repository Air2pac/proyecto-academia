package dao;

import java.util.ArrayList;
import java.util.List;

import model.Asignatura;


public class AsignaturaDAO {
	
	private Asignatura asignatura;
	private List<Asignatura> listadoCursos = new ArrayList<Asignatura>();
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	public List<Asignatura> getListadoCursos() {
		return listadoCursos;
	}
	public void setListadoCursos(List<Asignatura> listadoCursos) {
		this.listadoCursos = listadoCursos;
	}
	
	
}

package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="pra_estudiantes")
public class Estudiante {

	@Id
	@Column(name="est_id")
	private int est_id;
	
	@Column(name="est_dni")
	private String est_dni;
	
	@Column(name="est_nombre")
	private String est_nombre;
	
	@Column(name="est_ape1")
	private String est_ape1;
	
	@Column(name="est_ape2")
	private String est_ape2;
	
	@ManyToMany(cascade = {CascadeType.ALL}) 
	@JoinTable(name="pra_asixest", joinColumns={@JoinColumn(name="est_id")}, inverseJoinColumns={@JoinColumn(name="asi_id")}) 
	private Set<Asignatura> asignaturas = new HashSet<>();
	
	

	public Estudiante() {
	}

	public Estudiante(int est_id, String est_dni, String est_nombre, String est_ape1, String est_ape2) {
		this.est_id     = est_id;
		this.est_dni    = est_dni;
		this.est_nombre = est_nombre;
		this.est_ape1   = est_ape1;
		this.est_ape2   = est_ape2;
	}
	
	public Estudiante(String est_dni, String est_nombre, String est_ape1, String est_ape2) {
		this.est_dni    = est_dni;
		this.est_nombre = est_nombre;
		this.est_ape1   = est_ape1;
		this.est_ape2   = est_ape2;
	}

	public int getEst_id() {
		return est_id;
	}

	public void setEst_id(int est_id) {
		this.est_id = est_id;
	}

	public String getEst_dni() {
		return est_dni;
	}

	public void setEst_dni(String est_dni) {
		this.est_dni = est_dni;
	}

	public String getEst_nombre() {
		return est_nombre;
	}

	public void setEst_nombre(String est_nombre) {
		this.est_nombre = est_nombre;
	}

	public String getEst_ape1() {
		return est_ape1;
	}

	public void setEst_ape1(String est_ape1) {
		this.est_ape1 = est_ape1;
	}

	public String getEst_ape2() {
		return est_ape2;
	}

	public void setEst_ape2(String est_ape2) {
		this.est_ape2 = est_ape2;
	}

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	@Override
	public String toString() {
		return "Estudiante [est_id=" + est_id + ", est_dni=" + est_dni + ", est_nombre=" + est_nombre + ", est_ape1="
				+ est_ape1 + ", est_ape2=" + est_ape2 + ", asignaturas=" + asignaturas + "]";
	}

}

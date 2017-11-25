package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pra_profesores")
public class Profesor {

	@Id
	@Column(name="pro_id")
	private int pro_id;
	
	@Column(name="pro_nombre")
	private String pro_nombre;
	
	@Column(name="pro_ape1")
	private String pro_ape1;
	
	@Column(name="pro_ape2")
	private String pro_ape2;
	
	@ManyToMany(cascade = {CascadeType.ALL}) 
	@JoinTable(name="pra_asixpro", joinColumns={@JoinColumn(name="pro_id")}, inverseJoinColumns={@JoinColumn(name="asi_id")}) 
	private List<Asignatura> asignaturas;
	
	

	public Profesor() {
		this.pro_id = 0;
		this.pro_nombre = "";
		this.pro_ape1 = "";
		this.pro_ape2 = "";
	}

	public Profesor(int pro_id, String pro_nombre, String pro_ape1, String pro_ape2) {
		super();
		this.pro_id = pro_id;
		this.pro_nombre = pro_nombre;
		this.pro_ape1 = pro_ape1;
		this.pro_ape2 = pro_ape2;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getPro_nombre() {
		return pro_nombre;
	}

	public void setPro_nombre(String pro_nombre) {
		this.pro_nombre = pro_nombre;
	}

	public String getPro_ape1() {
		return pro_ape1;
	}

	public void setPro_ape1(String pro_ape1) {
		this.pro_ape1 = pro_ape1;
	}

	public String getPro_ape2() {
		return pro_ape2;
	}

	public void setPro_ape2(String pro_ape2) {
		this.pro_ape2 = pro_ape2;
	}
	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
}

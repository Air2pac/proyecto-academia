package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pra_asignaturas")
public class Asignatura {
	@Id
	@Column(name="asi_id")
	private int asi_id;
	
	@ManyToOne
	@JoinColumn(name="cur_id")
	private Curso curso;
	
	@Column(name="asi_des")
	private String asi_des;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="asignaturas" )
	private Set<Estudiante> estudiantes = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="asignaturas" )
	private Set<Profesor> profesores = new HashSet<>();
	
	
	public Asignatura() {
		this.asi_id = 0;
		this.curso = null;
		this.asi_des = "";
	}

	public Asignatura(int asi_id, Curso curso, String asi_des) {
		super();
		this.asi_id = asi_id;
		this.curso = curso;
		this.asi_des = asi_des;
	}

	public int getAsi_id() {
		return asi_id;
	}

	public void setAsi_id(int asi_id) {
		this.asi_id = asi_id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getAsi_des() {
		return asi_des;
	}

	public void setAsi_des(String asi_des) {
		this.asi_des = asi_des;
	}

	public Set<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Set<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Set<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(Set<Profesor> profesores) {
		this.profesores = profesores;
	}

	
	
}

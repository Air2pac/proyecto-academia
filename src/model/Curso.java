package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pra_cursos")
public class Curso {

	@Id
	@Column(name="cur_id")
	private int cur_id;
	
	@Column(name="cur_des")
	private String cur_des;
	
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name="cur_id", nullable = false, insertable = false, updatable = false)
	private List<Asignatura> asignaturas;

	public Curso() {
		
	}

	public Curso(int cur_id, String cur_des) {
		this.cur_id = cur_id;
		this.cur_des = cur_des;
	}

	public int getCur_id() {
		return cur_id;
	}

	public void setCur_id(int cur_id) {
		this.cur_id = cur_id;
	}

	public String getCur_des() {
		return cur_des;
	}

	public void setCur_des(String cur_des) {
		this.cur_des = cur_des;
	}
	
	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
}

package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

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
	private String arrayAsignaturas[];
	private Asignatura asignatura;

	public String listadoEstudiantes() {
		// Obtiene un listado de los estudiantes

		listadoEstudiantes = conexion.listarEstudiante();

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

	public String[] getArrayAsignaturas() {
		return arrayAsignaturas;
	}

	public void setArrayAsignaturas(String arrayAsignaturas[]) {
		this.arrayAsignaturas = arrayAsignaturas;
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

	public String abrirModificarEstudiantes() {
		listadoEstudiantes.clear();
		listadoEstudiantes = (ArrayList) dao.Leer("Estudiante", "where est_id="
				+ estudiante.getEst_id());
		estudiante = listadoEstudiantes.get(0);
		return SUCCESS;
	}

	public String modificarEstudiantes() {

		// listadoEstudiantes.clear();
		// listadoEstudiantes = (ArrayList)dao.Leer("Estudiante",
		// "where est_id="+estudiante.getEst_id());
		// estudiante = listadoEstudiantes.get(0);

		boolean pasa = conexion.modificarEstudiante(estudiante);

		if (pasa) {
			listadoEstudiantes.clear();
			listadoEstudiantes = conexion.listarEstudiante();
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	public String insertarEstudiante() {
		
		estudiante.setEst_dni(estudiante.getEst_dni().trim());
		boolean pasa = conexion.insertarEstudiante(estudiante);

		if (pasa) {
			listadoEstudiantes.clear();
			listadoEstudiantes = conexion.listarEstudiante();
			return SUCCESS;
		} else {
			System.out.println("error");
			return INPUT;
		}
	}

	public String abrirAddEstAsign() {
		setListAsignatura(conexion.listarAsingatura());
		listadoEstudiantes.clear();
		listadoEstudiantes = (ArrayList) dao.Leer("Estudiante", "where est_id="+ estudiante.getEst_id());
		estudiante = listadoEstudiantes.get(0);
		return SUCCESS;
	}

	public String addEstAsign() {

		List<Asignatura> listAsig = new ArrayList<>();
		if (arrayAsignaturas != null || arrayAsignaturas.length > 0) {
			for (String a : arrayAsignaturas) {
				String parts[] = a.split(",");
				listAsig.add(conexion.devolverAsignatura(parts[0].trim(),parts[1].trim()));
			}
		
			for (Asignatura a : listAsig) {
				estudiante.getAsignaturas().add(a);
			}
			for (Asignatura a : listAsig) {
				a.getEstudiantes().add(estudiante);
			}

		}else{
			dao.Borrar(estudiante);
			System.out.println("pasa");
		}
		boolean pasa = conexion.insertarEstuAsignatura(estudiante);
		if (pasa) {
			listadoEstudiantes.clear();
			listadoEstudiantes = conexion.listarEstudiante();
			return SUCCESS;
		} else {
			return INPUT;
		}

	}
	
	public void validateInsertarEstudiante(){
		if(estudiante.getEst_nombre() == null || estudiante.getEst_nombre().trim().equals("")){
		
			addFieldError("est_nombre", "Nombre vacío");
		}
		if(estudiante.getEst_dni() == null || estudiante.getEst_dni().trim().equals("")){
		
			addFieldError("est_dni", "DNI vacío");
		}
		if(estudiante.getEst_ape1() == null || estudiante.getEst_ape1().trim().equals("")){
		
			addFieldError("est_ape1", "Primer Apellido vacío");
		}
		if(estudiante.getEst_ape2() == null || estudiante.getEst_ape2().trim().equals("")){
	
			addFieldError("est_ape2", "Segundo Apellido vacío");
		}
		if(!comprobarDni(estudiante.getEst_dni())){
			addFieldError("cur_dni", "DNI ya incorrecto");
		}	
		if(conexion.existeDni(estudiante.getEst_dni().trim())){
			
			addFieldError("cur_dni", "DNI ya existente");
		} 
	}
	
	public void validateModificarEstudiante(){
		
		if(estudiante.getEst_nombre() == null || estudiante.getEst_nombre().trim().equals("")){
			
			addFieldError("est_nombre", "Nombre vacío");
		}
		if(estudiante.getEst_dni() == null || estudiante.getEst_dni().trim().equals("")){
		
			addFieldError("est_dni", "DNI vacío");
		}
		if(estudiante.getEst_ape1() == null || estudiante.getEst_ape1().trim().equals("")){
		
			addFieldError("est_ape1", "Primer Apellido vacío");
		}
		if(estudiante.getEst_ape2() == null || estudiante.getEst_ape2().trim().equals("")){
	
			addFieldError("est_ape2", "Segundo Apellido vacío");
		}
	
	}
	
	
	private static boolean comprobarDni(String nif){
		 
		   
		 //si es NIE, eliminar la x,y,z inicial para tratarlo como nif
		   if (nif.toUpperCase().startsWith("X")||nif.toUpperCase().startsWith("Y")||nif.toUpperCase().startsWith("Z"))
		nif = nif.substring(1);
		 
		Pattern nifPattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
		Matcher m = nifPattern.matcher(nif);
		if(m.matches()){
		String letra = m.group(2);
		//Extraer letra del NIF
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		int dni = Integer.parseInt(m.group(1));
		dni = dni % 23;
		String reference = letras.substring(dni,dni+1);
		 
		if (reference.equalsIgnoreCase(letra)){
		//_log.debug("son iguales. Es NIF. "+letra+" "+reference);
			return true;
		}else{
		//_log.debug("NO son iguales. NO es NIF. "+letra+" "+reference);
			return false;
		}
		}else
			return false;
		}
	
	//Consultas
	public String consultaEstAsig() {
		return SUCCESS;
	}
	
	public String consEstAsig(){
	
		setListadoEstudiantes(conexion.consultaEstAsig(estudiante.getEst_ape1()));
		
		
		return SUCCESS;
	}
}
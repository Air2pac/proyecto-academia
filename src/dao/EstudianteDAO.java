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
		System.out.println(estudiante.getEst_id());
//		Estudiante estudiante2 = (Estudiante)dao.sesion.load(Estudiante.class, estudiante.getEst_id());
		dao.Borrar(estudiante);
		listadoEstudiantes.clear();
		listadoEstudiantes = (ArrayList)dao.Leer("Estudiante", "");
		return SUCCESS;
	}
	
	public String abrirModificarEstudiantes(){
		listadoEstudiantes.clear();
		listadoEstudiantes = (ArrayList)dao.Leer("Estudiante", "where est_id="+estudiante.getEst_id());
		estudiante = listadoEstudiantes.get(0);
		System.out.println(estudiante.getEst_nombre());
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


	
	
//	public String addEstudiante() {
//		//conectar a la base de datos y añadir a la lista los estudiantes leídos
//				String ret;
//				Connection conn = null;
//				try {
//					String URL = "jdbc:mysql://localhost/academia";
//					Class.forName("com.mysql.jdbc.Driver");
//					conn = DriverManager.getConnection(URL,"root","");
//					String sql = "INSERT INTO pra_estudiantes VALUES('0','"+estudiante.getEst_dni()+"','"+estudiante.getEst_nombre()+"'"
//							+ ",'"+estudiante.getEst_ape1()+"','"+estudiante.getEst_ape2()+"')";
//					PreparedStatement ps = conn.prepareStatement(sql);
//					ps.executeUpdate();
//
//				}catch(Exception e) {
//					System.out.println(e.toString());
//					ret = "error";
//				}finally {
//					if(conn != null) {
//						try {
//							conn.close();
//						}catch(Exception e) {
//							
//						}
//					}
//				}
//		
//		return listadoEstudiantes();
//		
//	}//addEstudiante
	
//	public String deleteEstudiante() {
//		
//		String ret;
//		Connection conn = null;
//		try {
//			String URL = "jdbc:mysql://localhost/academia";
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection(URL,"root","");
//			String sql = "DELETE FROM pra_estudiantes WHERE est_id = "+estudiante.getEst_id();
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.executeUpdate();
//
//		}catch(Exception e) {
//			System.out.println(e.toString());
//			ret = "error";
//		}finally {
//			if(conn != null) {
//				try {
//					conn.close();
//				}catch(Exception e) {
//					
//				}
//			}
//		}
//
//		return listadoEstudiantes();
//	}//deleteEstudiante
	
	
}

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/mantenimientoEstudiantes.css">
<script src="js/mantenimientoProfesores.js"></script>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-11">


				<button title="Añadir" class="btn btn-link addProf">
					<i style="color: green;" class="fa fa-plus-circle fa-lg"
						aria-hidden="true">Añadir Profesor</i>
				</button>
				<s:form id="eliminarProfesorForm" method="post">
					<table class="table table-hover table-sm">
						<thead class="table-info">
							<th style="display: none;">Id</th>
							<th>Nombre</th>
							<th>1º Apellido</th>
							<th>2º Apellido</th>
							<th>Add Asignaturas</th>
							<th>Modificar</th>
							<th>Eliminar</th>
						</thead>
						<tbody>
							<s:iterator status="stat" value="listadoProfesores">
								<tr>
									<td style="display: none;"><input type="radio"
										name="profesor.pro_id" value="${pro_id}">${pro_id}</td>
									<td><s:property value="pro_nombre" /></td>
									<td><s:property value="pro_ape1" /></td>
									<td><s:property value="pro_ape2" /></td>
									<td style="display: none;"><s:property value="asignaturas" /></td>
									<td>
										<button title="AddAsignaturas" class="btn btn-link addAsigna">
											<i class="fa fa-plus-square-o fa-lg" aria-hidden="true"></i>
										</button>
									</td>
									<td>
										<button title="modificar" class="btn btn-link modificarPro">
											<i class="fa fa-pencil-square-o fa-lg" aria-hidden="true"></i>
										</button>
									</td>
									<td>
										<button title="eliminar" class="btn btn-link eliminarPro">
											<i style="color: red;" class="fa fa-window-close fa-lg"
												aria-hidden="true"></i>
										</button>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>
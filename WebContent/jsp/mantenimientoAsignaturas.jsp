<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>mantenimiento Asignatura</title>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/mantenimientoEstudiantes.css">
<script src="js/mantenimientoAsignaturas.js"></script>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-11">
				<button title="Añadir" class="btn btn-link addAsign">
					<i style="color: green;" class="fa fa-plus-circle fa-lg"
						aria-hidden="true">Añadir Asignatura</i>
				</button>
				<s:form id="eliminarAsignaturaForm" method="post">
					<table class="table table-hover table-sm">
						<thead class="table-info">
							<th style="display: none;">Id</th>
							<th>Descripción</th>
							<th>Curso</th>
							<th>Modificar</th>
							<th>Eliminar</th>
						</thead>
						<tbody>
							<s:iterator status="stat" value="listadoAsignaturas">
								<tr>
									<td style="display: none;"><input type="radio"
										name="asignatura.asi_id" value="${asi_id}">${asi_id}</td>
									<td><s:property value="asi_des" /></td>
									<td><s:property value="curso.cur_des" /></td>
				
									<td>
										<button title="modificar" class="btn btn-link modificarAsig">
											<i class="fa fa-pencil-square-o fa-lg" aria-hidden="true"></i>
										</button>
									</td>
									<td>
										<button title="eliminar" class="btn btn-link eliminarAsig">
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
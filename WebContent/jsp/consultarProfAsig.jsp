<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>mantenimiento Asignatura</title>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="css/editaEstudiantes.css">
<script src="js/consultarProfAsig.js"></script>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-11">
				<div id="cuerpoConsEst">
					<div class="buscador">
						<s:form id="formConsultaProfAsig">
							<div class="row mt-3">
								<div class="col-md-12 text-center">
									<input type="text" name="profesor.pro_nombre">
									<button title="consultar" class="btn btn-success consultarproasig">
										<i class="fa fa-search" aria-hidden="true"></i>
									</button>
								</div>
							</div>
						</s:form>
					</div>


					<s:form id="eliminarAsignaturaForm" method="post">
						<table class="table table-hover table-sm">
							<thead class="table-info">
								<th style="display: none;">Id</th>
								<th>Nombre</th>
								<th>Primer Apellido</th>
								<th>Segundo Apellido</th>
								<th>Asignaturas</th>
								<th>Cursos</th>
							</thead>
							<tbody>
								<s:iterator status="stat" value="listadoProfesores">
									<tr>
										<td style="display: none;"><input type="radio"
											name="profesor.pro_id" value="${pro_id}">${pro_id}</td>
										<td><s:property value="pro_nombre" /></td>
										<td><s:property value="pro_ape1" /></td>
										<td><s:property value="pro_ape2" /></td>
										<td><s:iterator status="stat" value="asignaturas">
												<s:property value="asi_des" />
												<br />
											</s:iterator></td>
										<td><s:iterator status="stat" value="asignaturas">
												<s:property value="curso.cur_des" />
												<br />
											</s:iterator></td>
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
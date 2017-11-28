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
<script src="js/consultarEstCur.js"></script>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-11">
			<div id="cuerpoConsEst">
			<div class="buscador">
				<s:form id="formConsultaEstCur">
					<div class="row mt-3">
						<div class="col-md-12 text-center">
							<input type="text" name="estudiante.est_ape1">
							<button title="consultar" class="btn btn-success consultarestcur">
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
							<th>Cursos</th>
						</thead>
						<tbody>
							<s:iterator status="stat" value="listadoEstudiantes">
								<tr>
									<td style="display: none;"><input type="radio"
										name="estudiante.est_id" value="${est_id}">${est_id}</td>
									<td><s:property value="est_nombre" /></td>
									<td><s:property value="est_ape1" /></td>
									<td><s:property value="est_ape2" /></td>
									<td>
										<s:iterator  status="stat" value="listaCursos">
											<s:property value="cur_des" /></br>
										</s:iterator>
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
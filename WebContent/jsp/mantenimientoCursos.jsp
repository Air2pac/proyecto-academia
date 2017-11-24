<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="css/mantenimientoEstudiantes.css">
<script src="js/mantenimientoCurso.js"></script>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-7">
				<button title="Añadir" class="btn btn-link addCurso">
					<i style="color: green;" class="fa fa-plus-circle fa-lg"
						aria-hidden="true">Añadir Curso</i>
				</button>
				<s:form id="EliminarCursoForm" method="post">
				<table class="table table-hover table-sm">
					<thead class="table-info">
						<th style="display:none;">id</th>
						<th>Curso</th>
						<th>Modificar</th>
						<th>Eliminar</th>
						
					</thead>
					<tbody>
						<s:iterator status="stat" value="listadoCursos">
						<tr>
							<!-- <td><input type="hidden" name="curso.cur_id" value="<s:property value="cur_id"/>">${cur_id}</td> -->
							<td style="display: none;"><input type="radio"
										name="curso.cur_id" value="${cur_id}">${cur_id}</td>
							<td><s:property value="cur_des"/></td>
							<td>
								<button title="modificarCur" class="btn btn-link modificarCur">
										<i class="fa fa-pencil-square-o fa-lg" aria-hidden="true"></i>
								</button>
							</td>
							<td>
								<button title="eliminarCur" class="btn btn-link eliminarCur" >
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
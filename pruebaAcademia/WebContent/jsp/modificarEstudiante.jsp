<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Estudiante</title>
<link rel="stylesheet" href="css/mantenimientoEstudiantes.css">
<script src="js/modificarEstudiantes.js"></script>
</head>
<body>

	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-11">
				<s:form id="ModificarEstudiante">
					<input style="display: none;" type="text" name="estudiante.est_id"  value="<s:property value="estudiante.est_id"/>"></input></br>
					<input type="text" name="estudiante.est_nombre" label="Nombre estudiante" value="<s:property value="estudiante.est_nombre"/>" >Nombre</input></br>
					<input type="text" name="estudiante.est_dni" label="Dni estudiante" value="<s:property value="estudiante.est_dni"/>" >Dni</input></br>
					<input type="text" name="estudiante.est_ape1" label="Apellido1 estudiante" value="<s:property value="estudiante.est_ape1"/>" >Apellido1</input></br>
					<input type="text" name="estudiante.est_ape2" label="Apellido2 estudiante" value="<s:property value="estudiante.est_ape2"/>" >Apellido2</input></br>
					<button title="confirmar" class="btn btn-primary confirma"> CONFIRMAR</button>
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>
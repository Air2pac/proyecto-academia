<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Estudiante</title>
<link rel="stylesheet" href="css/mantenimientoEstudiantes.css">
<script src="js/addProAsignatura.js"></script>
</head>
<body>

	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-11">
				<s:form id="AddProAsign">
					<input style="display: none;" type="text" name="profesor.pro_id"  value="<s:property value="profesor.pro_id"/>"></input></br>
					<input readonly="readonly" type="text" name="profesor.pro_nombre" label="Nombre Profesor" value="<s:property value="profesor.pro_nombre"/>" >Nombre</input></br>
					<input readonly="readonly" type="text" name="profesor.pro_ape1" label="Apellido1 Profesor" value="<s:property value="profesor.pro_ape1"/>" >Apellido1</input></br>
					<input readonly="readonly" type="text" name="profesor.pro_ape2" label="Apellido2 Profesor" value="<s:property value="profesor.pro_ape2"/>" >Apellido2</input></br>
					<s:checkboxlist label="Elige las asignaturas del profesor" list="listAsignatura" 
							name="arrayAsignaturas" />
					<button title="confirmar" class="btn btn-primary confirma"> CONFIRMAR</button>
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/mantenimientoEstudiantes.css">
<script src="js/modificarProfesor.js"></script>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-11">
				<s:form id="ModificarProfesor">
					<input style="display: none;" type="text" name="profesor.pro_id"  value="<s:property value="profesor.pro_id"/>"></input></br>
					<input type="text" name="profesor.pro_nombre" label="Nombre del profesor"
					value="<s:property value="profesor.pro_nombre"/>" >Nombre del profesor</input></br>
					
					<input type="text" name="profesor.pro_ape1" label="Primer Apellido" 
					value="<s:property value="profesor.pro_ape1"/>">Primer Apellido</input></br>
					
					<input type="text" name="profesor.pro_ape2" label="Segundo Apellido" 
					value="<s:property value="profesor.pro_ape2"/>">Segundo Apellido</input></br>
					<s:fielderror style="color:red;"/>
					<button title="confirmar" class="btn btn-primary confirmarMod"> CONFIRMAR</button>
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>
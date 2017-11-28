<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/mantenimientoEstudiantes.css">
<script src="js/addProfesor.js"></script>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-11">
				<s:form id="InsertarProfesor">
<!-- 				<input style="display: none;" type="text" name="estudiante.est_id"></input></br> -->
					<input type="text" name="profesor.pro_nombre" label="Nombre del profesor" >Nombre del profesor</input></br>
					
					<input type="text" name="profesor.pro_ape1" label="Primer Apellido" >Primer Apellido</input></br>
					
					<input type="text" name="profesor.pro_ape2" label="Segundo Apellido" >Segundo Apellido</input></br>
					<s:fielderror style="color:red;"/>
					<button title="confirmar" class="btn btn-primary confirmarAdd"> CONFIRMAR</button>
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>
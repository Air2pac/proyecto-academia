<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Curso</title>
<link rel="stylesheet" href="css/mantenimientoEstudiantes.css">
<script src="js/modificarCurso.js"></script>
</head>
<body>

	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-11">
				<s:form id="ModificarCurso">
					<input style="display: none;" type="text" name="curso.cur_id"  value="<s:property value="curso.cur_id"/>"></input></br>
					<input type="text" name="curso.cur_des" label="Descripción Curso" value="<s:property value="curso.cur_des"/>" >Descripción Curso</input></br>
					<button title="confirmar" class="btn btn-primary confirma"> CONFIRMAR</button>
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>
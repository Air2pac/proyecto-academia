<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/mantenimientoEstudiantes.css">
<script src="js/modificarAsignatura.js"></script>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-11">
				<s:form id="ModificarAsignatura">
					<input style="display: none;" type="text" name="asignatura.asi_id"  value="<s:property value="asignatura.asi_id"/>"></input></br>
					<input type="text" name="asignatura.asi_des" label="Descripción asignatura"
					value="<s:property value="asignatura.asi_des"/>" > Descripción de la asignatura</input>
					</br>
					
					<s:select list="listCursos" name="asignatura.curso.cur_des"  value="asignatura.curso.cur_des"/>
					<button title="confirmar" class="btn btn-primary confirma">
						CONFIRMAR</button>
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>
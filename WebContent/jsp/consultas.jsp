<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Consultas</title>
	<link rel="stylesheet" href="css/mantenimiento.css" />
	<script src="js/mantenimiento.js"></script>
	<script src="js/consultas.js"></script>
</head>
<body>
	<div class="contenedor">
		<nav id="menuSuperior" class="row no-gutters justify-content-around">
			<div class="col-2 columna">
				<button id="ConsultarCurAsig" class="btn btn-primary btnConsultas" onclick="action('consultarCurAsig')">Cur-Asign</button></div>
			<div class="col-2 columna">
				<button id="ConsultarEstCur" class="btn btn-primary btnConsultas" onclick="action('ConsultarEstCur')">Cur-Est</button></div>
			<div class="col-2 columna">
				<button id="ConsultaEstAsig" class="btn btn-primary btnConsultas" onclick="action('ConsultaEstAsig')">Est-Asig</button></div>
			<div class="col-2 columna">
				<button id="ConsultarProfAsig" class="btn btn-primary btnConsultas" onclick="action('consultarProfAsig')">Prof-Asign</button></div>
		</nav>
		<main id="mainConsultas">
			
		</main>
	</div>
</body>
</html>
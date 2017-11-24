<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Mantenimiento</title>
<!-- 	<link rel="stylesheet" href="js/bootstrap.min.css"> -->
	<link rel="stylesheet" href="css/mantenimiento.css" />
<!-- 	<link rel="stylesheet" href="css/font-awesome.min.css" /> -->
<!-- 	<script src="js/bootstrap.min.js"></script> -->
<!-- 	<script src="js/jquery-3.2.1.min.js"></script> -->
	<script src="js/mantenimiento.js"></script>
</head>
<body>
	<div class="contenedor">
		<nav id="menuSuperior" class="row no-gutters justify-content-around">
			<div class="col-2 columna">
				<button id="ListadoCursos" class="btn btn-primary btnMantenimiento" onclick="action('ListadoCursos')">Cursos</button></div>
			<div class="col-2 columna">
				<button id="ListadoAsignaturas" class="btn btn-primary btnMantenimiento" onclick="action('ListadoAsignaturas')">Asignaturas</button></div>
			<div class="col-2 columna">
				<button id="ListadoEstudiantes" class="btn btn-primary btnMantenimiento" onclick="action('ListadoEstudiantes')">Estudiantes</button></div>
			<div class="col-2 columna">
				<button id="ListadoProfesores" class="btn btn-primary btnMantenimiento" onclick="action('ListadoProfesores')">Profesores</button></div>
		</nav>
		<main id="mainMantenimiento">
			
		</main>
	</div>
</body>
</html>
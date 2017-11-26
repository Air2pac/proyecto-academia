$(document).ready(function(){
	$(".eliminarPro").click(eliminar);
	$(".modificarPro ").click(modificar);
	$(".addProf").click(add);
	$(".addAsigna").click(addAsignatura);
});

function eliminar(event){
	event.preventDefault();
	var i = $(this).parent().siblings().first().children().first();
	$(i).attr('checked','checked');
	var dataForm = $('#eliminarProfesorForm').serialize();
	//alert(i);
	$.ajax({
		type: 'POST',
        url:  "BorrarProfesor",
        data : dataForm,
        success:  function (response) {
//        	$(i).parentsUntil('tbody').last().css('display','none');
        	$("#mainMantenimiento").html(response);
        },
        error: function(response){
        	alert("ERROR ocurrido");
        }
	});
}

function modificar(event){
	event.preventDefault();
	var i = $(this).parent().siblings().first().children().first();
	$(i).attr('checked','checked');
	var dataForm = $('#eliminarProfesorForm').serialize();
	alert(i);
	$.ajax({
		type: 'POST',
        url:  "AbrirModificarProfesor",
        data : dataForm,
        success:  function (response) {
//        	$(i).parentsUntil('tbody').last().css('display','none');
        	$("#mainMantenimiento").html(response);
        },
        error: function(response){
        	alert("ERROR ocurrido");
        }
	});
}


function add(event){
	event.preventDefault();
//	var i = $(this).parent().siblings().first().children().first();
//	$(i).attr('checked','checked');
//	var dataForm = $('#eliminarEstudianteForm').serialize();
	//alert(i);
	$.ajax({
		type: 'POST',
        url:  "AbrirAddProfesor",
        //data : dataForm,
        success:  function (response) {
//        	$(i).parentsUntil('tbody').last().css('display','none');
        	$("#mainMantenimiento").html(response);
        },
        error: function(response){
        	alert("ERROR ocurrido");
        }
	});
}

function addAsignatura(event){
	event.preventDefault();
	var i = $(this).parent().siblings().first().children().first();
	$(i).attr('checked','checked');
	var dataForm = $('#eliminarProfesorForm').serialize();
	alert(i);
	$.ajax({
		type: 'POST',
        url:  "AbrirAddProAsign",
        data : dataForm,
        success:  function (response) {
//        	$(i).parentsUntil('tbody').last().css('display','none');
        	$("#mainMantenimiento").html(response);
        },
        error: function(response){
        	alert("ERROR ocurrido");
        }
	});
}
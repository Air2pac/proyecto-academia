$(document).ready(function(){
	$(".eliminarAsig").click(eliminar);
	$(".modificarAsig").click(modificar);
	$(".addAsign").click(add);
});

function eliminar(event){
	event.preventDefault();
	var i = $(this).parent().siblings().first().children().first();
	$(i).attr('checked','checked');
	var dataForm = $('#eliminarAsignaturaForm').serialize();
	$.ajax({
		type: 'POST',
        url:  "BorrarAsignatura",
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
	var dataForm = $('#eliminarAsignaturaForm').serialize();
	alert(i);
	$.ajax({
		type: 'POST',
        url:  "AbrirModificarAsignatura",
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
        url:  "AbrirAddAsignatura",
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
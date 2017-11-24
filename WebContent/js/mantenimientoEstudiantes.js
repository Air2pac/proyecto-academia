$(document).ready(function(){
	$(".eliminar").click(eliminar);
	$(".modificar").click(modificar);
	$(".addEstud").click(add);
});

function eliminar(event){
	event.preventDefault();
	var i = $(this).parent().siblings().first().children().first();
	$(i).attr('checked','checked');
	var dataForm = $('#eliminarEstudianteForm').serialize();
	//alert(i);
	$.ajax({
		type: 'POST',
        url:  "BorrarEstudiante",
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
	var dataForm = $('#eliminarEstudianteForm').serialize();
	alert(i);
	$.ajax({
		type: 'POST',
        url:  "AbrirModificarEstudiante",
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
        url:  "AbrirAddEstudiante",
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
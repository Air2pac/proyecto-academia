$(document).ready(function(){
	$(".eliminarCur").click(eliminarCur);
	$(".modificarCur").click(modificarCur);
	$(".addCurso").click(add);
});

function eliminarCur(event){
	event.preventDefault();
	var i = $(this).parent().siblings().first().children().first();
	$(i).attr('checked','checked');
	var dataForm = $('#EliminarCursoForm').serialize();
	//alert('Pasa a borrar');
	alert(i);
	$.ajax({
		type: 'POST',
        url:  "BorrarCurso",
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

function modificarCur(event){
	event.preventDefault();
	var i = $(this).parent().siblings().first().children().first();
	$(i).attr('checked','checked');
	var dataForm = $('#EliminarCursoForm').serialize();
	alert(i);
	$.ajax({
		type: 'POST',
        url:  "AbrirModificarCurso",
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
        url:  "AbrirAddCurso",
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
$(document).ready(function(){
	$("#ConsultaEstAsig").click(consultaEstAsigna);
	$("#ConsultarProfAsig").click(consultarProfAsig);
	$("#ConsultarEstCur").click(consultarEstCur);
	$("#ConsultarCurEst").click(consultarCurEst);
});

function consultaEstAsigna(){
	$.ajax({
		type: 'POST',
        url:  "ConsultaEstAsig",
//        data : dataForm,
        success:  function (response) {
        	$("#mainConsultas").html(response);
        },
        error: function(response){
        	$("#mainConsultas").html(response);
        }
	});
	//$("#mainConsultas").load('jsp/consultarEstudiante.jsp');
}

function consultarEstCur(){
	$.ajax({
		type: 'POST',
        url:  "ConsultarEstCur",
//        data : dataForm,
        success:  function (response) {
        	$("#mainConsultas").html(response);
        },
        error: function(response){
        	$("#mainConsultas").html(response);
        }
	});
	//$("#mainConsultas").load('jsp/consultarCurEst.jsp');
}

function consultarProfAsig(){
	$.ajax({
		type: 'POST',
        url:  "ConsultarProfAsig",
//        data : dataForm,
        success:  function (response) {
        	$("#mainConsultas").html(response);
        },
        error: function(response){
        	$("#mainConsultas").html(response);
        }
	});
	//$("#mainConsultas").load('jsp/consultarProfAsig.jsp');
}

function consultarCurAsig(){

	//$("#mainConsultas").load('jsp/consultarCurAsig.jsp');
	$.ajax({
		type: 'POST',
        url:  "ConsultaCurAsig",
//        data : dataForm,
        success:  function (response) {
        	$("#mainConsultas").html(response);
        },
        error: function(response){
        	$("#mainConsultas").html(response);
        }
	});
}


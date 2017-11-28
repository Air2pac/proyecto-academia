$(document).ready(function(){
	$(".consultarestcur").click(consultarestcur);
});

function consultarestcur(event){
	event.preventDefault();
	var dataForm = $('#formConsultaEstCur').serialize();
	$.ajax({
		type: 'POST',
        url:  "ConsCurEst",
        data : dataForm,
        success:  function (response) {
        	$("#cuerpoConsEst").html(response);
        },
        error: function(response){
        	$("#mainMantenimiento").html(response);
        }
	});
}
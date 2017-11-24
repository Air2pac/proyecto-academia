$(document).ready(function(){
	$(".confirma").click(modificar);
});

function modificar(event){
	event.preventDefault();
	var i = $(this).parent().siblings().first().children().first();
	$(i).attr('checked','checked');
	var dataForm = $('#ModificarCurso').serialize();
	//alert(i);
	$.ajax({
		type: 'POST',
        url:  "ModificarCurso",
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
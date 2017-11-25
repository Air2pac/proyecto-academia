$(document).ready(function(){
	$(".confirmarAdd").click(add);
});

function add(event){
	event.preventDefault();
//	var i = $(this).parent().siblings().first().children().first();
//	$(i).attr('checked','checked');
	var dataForm = $('#InsertarAsignatura').serialize();
	$.ajax({
		type: 'POST',
        url:  "InsertarAsignatura",
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
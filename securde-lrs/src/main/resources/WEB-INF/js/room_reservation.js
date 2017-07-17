/**
 * 
 */

$(function() {
	
	//NEED TO MAKE ON FUNCTION TO RETRIEVE NUMBER OF ROOMS FROM DATABASE
	
	$(".room-reservation-table").find(".time-slot").each(function() {
		var state = $(this).data("state");
		
		if(state == 0) {
			$(this).css({
				"background-color": "#006635"
			});
			$(this).data("state", "1");
		}
		else {
			$(this).css({
				"background-color": "#99FF99"
			});
			$(this).data("state", "0");
		}
	});
	
	$(".time-slot").on("click", function(){
		var state = $(this).data("state");
		
		if(state == 0) {
			$(this).css({
				"background-color": "#006635"
			});
			$(this).data("state", "1");
		}
		else {
			$(this).css({
				"background-color": "#99FF99"
			});
			$(this).data("state", "0");
		}
	});
});
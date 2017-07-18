/**
 * 
 */

$(function() {
	$("#reservation-list-container").onload(function() {
		load_reservations();
	});
});

function load_reservations() {
	var reservationCount;
	
	for( var i = 1; i <= 5; i++ ) {
		$.ajax({
			url: "some/url",
			type: "GET",
			data: {
				roomId: i
			},
			success: function(data) {
				var response = JSON.parse(data);
				
				
			}
		});
	}
	
}
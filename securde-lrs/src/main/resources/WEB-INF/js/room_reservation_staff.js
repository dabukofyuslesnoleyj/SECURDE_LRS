/**
 * 
 */

$(function() {
	$("#room-list-container").onload(function() {
		for( var i = 1; i <= 5; i++) {
			load_room(i);
		}
	});
});

function load_room(roomId) {
	$.ajax({
		url: "/rest/room/slots",
		type: "GET",
		data: {
			roomId: roomId
		},
		success: function(data) {
			var response = JSON.parse(data);
			
			var entry = "<div class='media'><div class='media-body'><h4 class='media-heading'>Room " + roomId + "</h4>";
			
			if(response.length == 0) {
				entry += "<p>No Reservations</p><div class='media-right'><button>Disable Room</button>";
			}
			else {
				for( var i=0; i < response.length; i++) {
					entry += "<p>" + response[i].startH + ":" + response[i].startM + " - " + response.endH + ":" + response.endM + "</p>";
				}
			}
			
			entry += "</div>";
			
			$("#room-list-container").append(entry);
		}
	});
}
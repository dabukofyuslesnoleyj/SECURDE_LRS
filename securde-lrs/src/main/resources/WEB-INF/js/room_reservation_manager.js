/**
 * 
 */

var roomId = 0;
var reservationId = 0;

$(function() {
	
	$(".room-reservation-table").onload(fill_table());
	
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
		var slot = $(this);
		var state = slot.data("state");
		var timeStartH = slot.data("startH");
		var timeStartM = slot.data("startM");
		roomId = slot.data("roomId");
		reservationId = slot.data("reservationId");
		var reserveeId = slot.data("reserveeId");
		if(timeStartM == "30") {
			var timeEndH = slot.data("startH") + 1;
			var timeEndM = "00";
		}
		else {
			var timeEndH = slot.data("startH");
			var timeEndM = "30";
		}
		
		$("#room-slot-roomId").data("value", roomId);
		$("#room-slot-roomId").text("Room ID#: " + roomId);
		$("#room-slot-timeslot").data("startH", timeStartH);
		$("#room-slot-timeslot").data("startM", timeStartM);
		$("#room-slot-timeslot").data("endH", timeEndH);
		$("#room-slot-timeslot").data("endM", timeEndM);
		$("#room-slot-timeslot").text("Timeslot: " + timeStartH + ":" + timeStartM + " - " + timeEndH + ":" + timeEndM);
		$("#room-slot-reserveeId").data("value", reserveeId);
		$("#room-slot-reserveeId").text("Reservee ID#: " + reserveeId);
		
		$("#room-slot-override-reserveeId").val(reserveeId);
		$("#room-slot-override-availability").val(state);
	});
	
	$("#room-slot-override-button").on("click", override_slot());
});

function override_slot() {
	if(roomId != 0) {
		var timeStartH = $("#room-slot-timeslot").data("startH");
		var timeStartM = $("#room-slot-timeslot").data("startM");
		var timeEndH = $("#room-slot-timeslot").data("endH");
		var timeEndM = $("#room-slot-timeslot").data("endM");
		var reserveeId = $("#room-slot-reserveeId").data("reserveeId");
		var availability = $("#room-slot-override-availability").val();
		var availabilityText = $("#room-slot-override-availability option[value='" + $("#room-slot-override-availability").val() + "']").text();
		if(availability == 0) {
			reserveeId = 0;
		}
		
		$.ajax({
			url: "/",
			type: "POST",
			data: {
				reservationId: reservationId,
				roomId: roomId,
				startH: timeStartH,
				startM: timeStartM,
				endH: timeEndH,
				endM: timeEndM,
				reserveeId: reserveeId,
				availability: availabilityText
			}
		});
	}
}

function fill_table() {
	for(var i = 1; i <= 5; i++) {
		fill_table_row(i);
	}
}

function fill_table_row(roomId) {
	$.ajax({
		url: "/rest/room/slots",
		type: "GET",
		data: {
			roomId: roomId
		},
		success: function(data) {
			var response = JSON.parse(data);
			
			var startH = 7, startM = 0, endH = 7, endM = 30;
			var row = "<tr><th>";
			
			for( var i = 0; i < 27; i++) {
				if( i == 0 )
					row += response.id + "</th>";
				else {
					row += "<td id='" + roomId + "-" + startH + "-" + startM + "' roomId='" + roomId + "' startH='" + startH + "' startM='" + startM + "' reserveeId='" + response.reserveeId + "' class='time-slot' ";
					var value = 0;
					var reservationId = 0;
					
					if( response.startH == startH
							&& response.startM == startM ) {
						value = 1;
						reservationId = response.reservationId;
					}
					
					row += "state='" + value + "' reservationId='" + reservationId + "'></td>";
					
					startM += 30;
					if( startM == 60) {
						startH++;
						startM = 0;
					}
				}
			}
			
			row += "</tr>";
			
			$("#room-reservation-table").append(row);
		}
	});
}

/**
 * 
 */

var slots = new Array();
var roomId = 0;

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
		
		if(state == 0) {
			if(roomId == 0)
				roomId = slot.data("roomId");
			
			if(roomId == slot.data("roomId")){
				if(slots.length <= 4 && slots.length > 0) {
					$(this).css({
						"background-color": "#00FF00"
					});
					$(this).data("state", "2");
					
					slots.push(slot.getAttribute("id"));
				}
				else {
					alert("Cannot reserve slot.");
				}
			}
			else
				alert("Slots must be in the same room.");
		}
		else if( state == 2 ){
			$(this).css({
				"background-color": "#99FF99"
			});
			$(this).data("state", "0");
			
			slots.splice(slots.indexOf(data.getAttribute("id")), 1);
		}
	});
	
	$("#room-reservation-button").onclick(reserve_slots());
});

function reserve_slots() {
	var reservedSlots = new Array();
	
	if( slots.length > 0 && slots.length <= 4 ) {
		for(var i = 0; i < slots.length; i++) {
			reservedSlots[i] = {
				"roomId": $("#" + slots[i]).data("roomId"),
				"startH": $("#" + slots[i]).data("startH"),
				"startM": $("#" + slots[i]).data("startM")
			};
		}
		
		$.ajax({
			url: "/",
			type: "POST",
			data: {
				roomId: roomId,
				slots: JSON.stringify(reservedSlots)
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
					row += "<td id='" + roomId + "-" + startH + "-" + startM + "' roomId='" + roomId + "' startH='" + startH + "' startM='" + startM + "' class='time-slot' ";
					var value = 0;
					
					if( response.startH == startH
							&& response.startM == startM ) {
						value = 1;
					}
					
					row += "state='" + value + "'></td>";
					
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

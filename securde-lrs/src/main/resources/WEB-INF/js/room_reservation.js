/**
 * 
 */

var slots = 0;

$(function() {
	
	$("#room-reservation-table").onload(fill_table());
	
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
			
			slots++;
			if(slots <= 4 && slots > 0) {
				$(this).data("selected", slots);
			}
			else {
				alert("Cannot reserve more that 4 slots.");
				slots--;
			}
		}
		else if( $(this).data("selected") > 0 && $(this).data("selected") <= 4 ){
			$(this).css({
				"background-color": "#99FF99"
			});
			$(this).data("state", "0");
			
			$(this).data("selected", 0);
			slots--;
		}
	});
	
	$("form").submit(function(event) {
		var selected = new Array();
		
		for( var i = 0; i < slots; i++ ) {
			selected[i] = {
				"id": $("[selected=" + (i+1) + "]").data("roomId"),
				"startH": $("[selected=" + (i+1) + "]").data("startH"),
				"startM": $("[selected=" + (i+1) + "]").data("startM"),
				"endH": $("[selected=" + (i+1) + "]").data("endH"),
				"endM": $("[selected=" + (i+1) + "]").data("endM")
			}
		}
		
		var formData = {
			roomId: $("input[name=last-name]").val(),
			slots: selected,
			lastname: $("input[name=last-name]").val(),
			firstname: $("input[name=first-name]").val(),
			middleInitial: $("input[name=middle-initial").val(),
			attendeeCount: $("name=room-attendee-count").val()
		};
		
		$.ajax({
			type: "POST",
			url: "/some/URL",
			data: formData
		});
	});
});

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
					row += "<td roomId='" + roomId + "' startH='" + startH + "' startM='" + startM + "' endH='" + endH + "' end='" + endM + "' selected='0' class='time-slot' ";
					var value = 0;
					
					if( response.startH == startH
							&& response.startM == startM
							&& response.endH == endH
							&& response.endM == endM) {
						value = 1;
					}
					
					row += "state='" + value + "'></td>";
					
					startM += 30;
					if( startM == 60) {
						startH++;
						startM = 0;
					}
					endM += 30;
					if(endM == 60) {
						endH++;
						endM = 0;
					}
				}
			}
			
			row += "</tr>";
			
			$("#room-reservation-table").append(row);
		}
	})
}
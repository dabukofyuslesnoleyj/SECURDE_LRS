function initList(){

    $.get("demo_test.asp", 
    function(success, status, message, data, errorData){
        if(success){
            
        }
    });

}
/*
 <div class="row item_container">
                
                <div class="item_image col-md-1">
                    <img src="rsc/img/bookCover.jpg" class="img-responsive item_cover"/>
                </div>
                
                <div class="item_info col-md-11">
                    <div class="row item_info_upper_row">
                        <div class="item_info_name_div col-md-4">
                            <p class="item_info_name">Book of Worlds</p>
                        </div>
                        <div class="item_info_author_div col-md-4">
                            <p>by</p><p class="item_info_author">John Doe</p>
                        </div>
                        <div class="item_info_rating_div col-md-4">
                            <p>9.5</p><p>/10</p>
                        </div>
                    </div>
                    <div class="row item_info_lower_row">
                        <div class="item_info_type_div col-md-3">
                            <p class="item_info_type">Book</p>
                        </div>
                        <div class="item_info_tags_div col-md-9">
                            <ul class="list-inline">
                                <li class="list-inline-item"><span class="label label-default">New</span></li>
                                <li class="list-inline-item"><span class="label label-default">Sci-Fi</span></li>
                                <li class="list-inline-item"><span class="label label-default">Thriller</span></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
*/
$(document).ready(() => {
	console.log("Initializing List")
	$.ajax({
		type: "GET",
		url: "http://localhost:9000/rest/item/all",
		contentType: "application/json",
		dataType: "json"
	}).done((resp) => {
		console.log(resp);
		let items = resp.data;
		let html = "";
		for(i of items) {
			html += "<tr>";
			html += "<td>" + i.name + "</td>";
			html += "<td>" + i.desc + "</td>";
			html += "<td>" + i.status + "</td>";
			html += "<td><a href='http://localhost:9000/rest/item/borrow" + i.id +"'>Borrow<a/></td>";
			html += "</tr>";
		}
		$("#item-list-body").html(html);
	}).fail((xhr) => {
		msgChange($('#div-register-msg'), $('#icon-register-msg'), $('#text-register-msg'), "error", "glyphicon-remove", "Register error");
	})

});
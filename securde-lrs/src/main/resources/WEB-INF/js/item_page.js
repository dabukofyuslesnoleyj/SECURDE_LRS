function item_info(){
    $.post("rest/account/register",
            {
                itemId : $()
            },
            function(success, status, message, data, errorData){
                if(success){
                    var name = data.item_name;
                    var authors = data.item_authors;
                    var publisher = data.item_publisher;
                    var tags = data.item_tags;

                    $("#item_name").val(name);
                    $.each(
                        authors,
                        function (i, val){
                            $("#item_authors").append("<p> "+val.l+", "+val.f+" </p>");
                        }
                    );
                    $("#item_publisher").val(publisher);
                    $.each(
                        tags,
                        function (i, val){
                            $("#item_tags").append("<li class='list-inline-item'><span class='label label-default'> "+val+" </span></li>");
                        }
                    );
                }
        })
        .done(function(){
            
        })
        .fail(function(){
            
        });
}

$(document).ready(function(){



});
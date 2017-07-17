$(document).ready(function(){
    
    // $("p").click(function(){
    //     alert("The paragraph was clicked.");
    // });

    function register (){

        var date = new Date($('#register_bday').val());

        var register_info = {

            name : {
                f : $("#register_fname"),
                m : $("#register_mname"),
                l : $("#register_lname")
            },
            uname : $("#register_uname"),
            pass : $("#register_password"),
            id : $("#register_idno"),
            bday: { 
                d : date.getDate(),
                m : date.getMonth()+1,
                y : date.getFullYear()
            },
            secret: {
                q : $("register_question"), 
                a : $("register_answer")
            }

        };

        $.post("res/account/register",
            register_info,
            function(data, status){
                //TODO: do this
        });
    }

});
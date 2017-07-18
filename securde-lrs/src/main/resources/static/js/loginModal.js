/* #####################################################################
   #
   #   Project       : Modal Login with jQuery Effects
   #   Author        : Rodrigo Amarante (rodrigockamarante)
   #   Version       : 1.0
   #   Created       : 07/29/2015
   #   Last Change   : 08/04/2015
   #
   ##################################################################### */

$(function() {

	var $formLogin = $('#login-form');
	var $formLost = $('#lost-form');
	var $formRegister = $('#register-form');
	var $divForms = $('#div-forms');
	var $modalAnimateTime = 300;
	var $msgAnimateTime = 150;
	var $msgShowTime = 2000;

	$("form").submit(function () {
		switch(this.id) {
		case "login-form":
			var $lg_username=$('#login_username').val();
			var $lg_password=$('#login_password').val();

			$.ajax({
				type: "POST",
				url: "http://localhost:9000/rest/account/login",
				data: JSON.stringify({
					uname: $lg_username,
					pass: $lg_password
				}),
				contentType: "application/json",
				dataType: "json"
			}).done((resp) => {
				msgChange($('#div-login-msg'), $('#icon-login-msg'), $('#text-login-msg'), "success", "glyphicon-ok", "Login OK");
				window.location.reload(true);
			}).fail((xhr) => {
				msgChange($('#div-login-msg'), $('#icon-login-msg'), $('#text-login-msg'), "error", "glyphicon-remove", "Login error");
			})
			return false;
		case "register-form":
			var fname=$('#register_fname').val();
			var mname=$('#register_mname').val();
			var lname=$('#register_lname').val();
			var uname=$('#register_uname').val();
			var idno=$('#register_idno').val();
			var pass=$('#register_password').val();
			var que=$('#register_question').val();
			var ans=$('#register_answer').val();
			var bday=new Date($('#register_bday').val());
			
			var dataObj = {
					name: { f: fname, m: mname, l: lname },
					uname: uname,
					pass: pass,
					bday: { d: bday.getDate(), m: bday.getMonth() + 1, y: bday.getFullYear()},
					id: idno,
					secret: { q: que, a: ans }
			}
			
			console.log(dataObj);

			$.ajax({
				type: "POST",
				url: "http://localhost:9000/rest/account/register",
				data: JSON.stringify(dataObj),
				contentType: "application/json",
				dataType: "json"
			}).done((resp) => {
				msgChange($('#div-register-msg'), $('#icon-register-msg'), $('#text-register-msg'), "success", "glyphicon-ok", "Register OK");
				$('#login_register_btn').click();
			}).fail((xhr) => {
				msgChange($('#div-register-msg'), $('#icon-register-msg'), $('#text-register-msg'), "error", "glyphicon-remove", "Register error");
			})
			return false;
		}
		return false;
	});

	$('#login_register_btn').click( function () { modalAnimate($formLogin, $formRegister) });
	$('#register_login_btn').click( function () { modalAnimate($formRegister, $formLogin); });
	$('#login_lost_btn').click( function () { modalAnimate($formLogin, $formLost); });
	$('#lost_login_btn').click( function () { modalAnimate($formLost, $formLogin); });
	$('#lost_register_btn').click( function () { modalAnimate($formLost, $formRegister); });
	$('#register_lost_btn').click( function () { modalAnimate($formRegister, $formLost); });

	function modalAnimate ($oldForm, $newForm) {
		var $oldH = $oldForm.height();
		var $newH = $newForm.height();
		$divForms.css("height",$oldH);
		$oldForm.fadeToggle($modalAnimateTime, function(){
			$divForms.animate({height: $newH}, $modalAnimateTime, function(){
				$newForm.fadeToggle($modalAnimateTime);
			});
		});
	}

	function msgFade ($msgId, $msgText) {
		$msgId.fadeOut($msgAnimateTime, function() {
			$(this).text($msgText).fadeIn($msgAnimateTime);
		});
	}

	function msgChange($divTag, $iconTag, $textTag, $divClass, $iconClass, $msgText) {
		var $msgOld = $divTag.text();
		msgFade($textTag, $msgText);
		$divTag.addClass($divClass);
		$iconTag.removeClass("glyphicon-chevron-right");
		$iconTag.addClass($iconClass + " " + $divClass);
		setTimeout(function() {
			msgFade($textTag, $msgOld);
			$divTag.removeClass($divClass);
			$iconTag.addClass("glyphicon-chevron-right");
			$iconTag.removeClass($iconClass + " " + $divClass);
		}, $msgShowTime);
	}
});
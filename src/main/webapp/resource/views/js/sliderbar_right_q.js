$(function() {
	$("#sliderbar_login_btn").click(function(e) { //点击登录
		$.post("Http://10.80.13.136:8080/user/userLogin", {
			userName: $("#sliderbar_login_user").val(),
			userPassword: $("#sliderbar_login_pwd").val(),
		}, function(data) {
			console.log(data);
		});
	});
	$(".right_cart").click(function(){
		$("#sliderbar_right_q").css("display", "block");
	})
	$(".right_star").click(function(){
		$("#sliderbar_right_q").css("display", "block");
	})
	$("#sliderbar_login_del").click(function(){
//		$("#sliderbar_right_q").remove();
		$("#sliderbar_right_q").css("display","none");
		return false;
	})
	$(".right_top").click(function(){
		$("html").animate({
			scrollTop: "0px"
		},600);
	})
	
})
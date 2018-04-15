$(function() {
	$(".side_con a p").click(function() {
		$(this).addClass("logIn").parent().siblings().children().removeClass("logIn");
		$("#nav p").html($(this).html());
		$("#pageWrap").load($(this).attr("id") + ".html");
	});
	$(".title_up").click(function() {
		$(this).toggleClass("title_down").parent().siblings().toggleClass("bb");
	});
	$("#pageWrap").load("side_page1.html");
	$("#helpCenterNav a p").click(function() {
		$("#secondHref").attr("href", "new_hand.html");
		$("#newConstructor").html("关于顺电");
		$("#changeKnow").html($(this).html());
	})
	$(".logIn").click(function() {
		$("#secondHref").attr("href", "###");
		$("#newConstructor").html("新手指引");
		$("#changeKnow").html("会员登录小贴士");
	})
	$("#helpCenterSecond a p").click(function() {
		$("#firstHref").attr("href", "###");
		$("#helpCenter").html("buy+");
		$("#newConstructor").html($(this).html());
		$("#secondHref").attr("href", "###");
		$("#changeKnow").hide();
		$("#arrowFirst").hide();
	})
	$("#register a p").click(function(){
		$("#firstHref").attr("href", "side_register.html");
		$("#helpCenter").html("注册与隐私");
		$("#newConstructor").html($(this).html());
		$("#secondHref").attr("href", "###");
		$("#changeKnow").hide();
		$("#arrowFirst").hide();
	})
});
$(function() {
//	data = [{
//			img: "../img/new_product/phone.jpg",
//			first_name: "【预订】小米 红米note5 6GB+64GB ",
//			second_name: "全网通 智能手机 双卡双待",
//			price: "￥1699"
//		},
//		{
//			img: "../img/new_product/phone.jpg",
//			first_name: "【预订】小米 红米note5 6GB+64GB ",
//			second_name: "全网通 智能手机 双卡双待",
//			price: "￥1699"
//		},
//		{
//			img: "../img/new_product/phone.jpg",
//			first_name: "【预订】小米 红米note5 6GB+64GB ",
//			second_name: "全网通 智能手机 双卡双待",
//			price: "￥1699"
//		},
//		{
//			img: "../img/new_product/phone.jpg",
//			first_name: "【预订】小米 红米note5 6GB+64GB ",
//			second_name: "全网通 智能手机 双卡双待",
//			price: "￥1699"
//		},
//		{
//			img: "../img/new_product/phone.jpg",
//			first_name: "【预订】小米 红米note5 6GB+64GB ",
//			second_name: "全网通 智能手机 双卡双待",
//			price: "￥1699"
//		},
//		{
//			img: "../img/new_product/phone.jpg",
//			first_name: "【预订】小米 红米note5 6GB+64GB ",
//			second_name: "全网通 智能手机 双卡双待",
//			price: "￥1699"
//		},
//		{
//			img: "../img/new_product/phone.jpg",
//			first_name: "【预订】小米 红米note5 6GB+64GB ",
//			second_name: "全网通 智能手机 双卡双待",
//			price: "￥1699"
//		},
//		{
//			img: "../img/new_product/phone.jpg",
//			first_name: "【预订】小米 红米note5 6GB+64GB ",
//			second_name: "全网通 智能手机 双卡双待",
//			price: "￥1699"
//		},
//		{
//			img: "../img/new_product/phone.jpg",
//			first_name: "【预订】小米 红米note5 6GB+64GB ",
//			second_name: "全网通 智能手机 双卡双待",
//			price: "￥1699"
//		},
//		{
//			img: "../img/new_product/phone.jpg",
//			first_name: "【预订】小米 红米note5 6GB+64GB ",
//			second_name: "全网通 智能手机 双卡双待",
//			price: "￥1699"
//		},
//		{
//			img: "../img/new_product/phone.jpg",
//			first_name: "【预订】小米 红米note5 6GB+64GB ",
//			second_name: "全网通 智能手机 双卡双待",
//			price: "￥1699"
//		},
//		{
//			img: "../img/new_product/phone.jpg",
//			first_name: "【预订】小米 红米note5 6GB+64GB ",
//			second_name: "全网通 智能手机 双卡双待",
//			price: "￥1699"
//		},
//
//	];
	dataCarousel = [{
			img: "../img/new_product/actor.jpg"
		},
//		{
//			img: "../img/new_product/actor.jpg"
//		},
//		{
//			img: "../img/new_product/actor.jpg"
//		}
	];
//	var str = "";
//	data.forEach(function(v) {
//		str += "<div id='contentDisplayItem'>" +
//			"  <a href='###'>" +
//			"     <div id='displayShadow'>" +
//			"     </div>" +
//			"     <img src='" + v.img + "' />" +
//			"     <div id='DisplayIntro'>" +
//			"         <h3>" + v.first_name + " </h3>" +
//			"         <h3>" + v.second_name + "</h3>" +
//			"     </div>" +
//			"     <div id='displayPrice'>" +
//			"         <span>" + v.price + "</span>" +
//			"     </div>" +
//			"  </a>" +
//			"</div>"
//
//	});
	var img = "";
	dataCarousel.forEach(function(v) {
		img = "<img src='" + v.img + "'/>"
		document.getElementsByClassName("carousel_new")[0].innerHTML = img;
	})
//	document.getElementById("contentDisplay").innerHTML = str;

	$(".carousel-content").carousel({
		carousel: ".carousel", //轮播图容器
		indexContainer: ".img-index", //下标容器
		prev: ".carousel-prev", //左按钮
		next: ".carousel-next", //右按钮
		timing: 3000, //自动播放间隔
		animateTime: 700, //动画时间
		autoPlay: false, //是否自动播放 true/false
		direction: "left", //滚动方向 right/left
	});
	
		$("#contentDisplay").load("new_product1.html");
//		$("#contentDisplay").load("new_product2.html");
	//bug
	$(".first_btn").off('mouseenter').unbind('mouseleave');
	if($("#contentDisplay").load("new_product2.html")) {
		$(".first_btn").attr("disabled", true).css({
			"background": "#f3f3f3",
			"color": "#333"
		});
		
	}

	$(".first_btn").click(function() {
		$("#contentDisplay").load("new_product2.html");
		$(".second_btn").click()
		
	});
	$(".second_btn").click(function() {
		console.log('!!!!')
		$("#contentDisplay").load("new_product2.html");
		$(".first_btn").off('mouseenter').unbind('mouseleave');
		if($("#contentDisplay").load("new_product2.html")) {

			$(".first_btn").attr("disabled", true).css({"background": "#f3f3f3","color": "#333"})
			$(".forth_btn").attr("disabled", false).css("background", "white");

		}
		$(".forth_btn").on({
			"mouseenter": function(e) {
				$(".forth_btn").css({
					'backgroundColor': '#01bad6',
					'color': 'white'
				})

			},
			"mouseleave": function(e) {
				$(".forth_btn").css({
					'backgroundColor': 'white',
					'color': '#666'
					
				})

			}
		})
	});
	$(".third_btn").click(function() {
		console.log('????')
		$("#contentDisplay").load("new_product1.html");
		$(".forth_btn").off('mouseenter').unbind('mouseleave');
		$(".first_btn").on({
			"mouseenter": function(e) {
				$(".first_btn").css({
					'backgroundColor': '#01bad6',
					'color': 'white'
				})

			},
			"mouseleave": function(e) {
               $(".first_btn").css({
					'backgroundColor': 'white',
					'color': '#666'
					
				})
			}
		})
		if($("#contentDisplay").load("new_product1.html")) {
			$(".forth_btn").attr("disabled", true).css({"background":"#f3f3f3","color": "#333"})
			$(".first_btn").attr("disabled", false).css("background", "white");
		}
	});
	$(".forth_btn").click(function() {
		$("#contentDisplay").load("new_product1.html");
		$(".third_btn").click();
	});
	$("button").click(function() {
		if($(this).text() == '>' || $(this).text() == '<') return;
		$(this).addClass("cur").siblings().removeClass("cur");
	})

});

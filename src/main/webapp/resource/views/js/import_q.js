$(function() {
	var swiper = new Swiper('.swiper-container', {
		pagination: {
			el: '.swiper-pagination',
			autoplay: 5000, 
//			pagination: '.swiper-pagination',
		},
	});
	
	$(".counry_usa_logo").click(function(){
		$("html").animate({
			"scrollTop":1300
		},1000)
	})
	$(".country_germany_logo").click(function(){
		$("html").animate({
			"scrollTop":1955
		},1000)
	})
	$(".country_japan_logo").click(function(){
		$("html").animate({
			"scrollTop":2610
		},1000)
	})
	$(".country_korea_logo").click(function(){
		$("html").animate({
			"scrollTop":3265
		},1000)
	})
	$(".country_thailand_logo").click(function(){
		$("html").animate({
			"scrollTop":3920
		},1000)
	})
	
	$(window).resize(function(){
		$derectionImgWidth = $(window).width();
		if ($derectionImgWidth < 1800) {
			$(".coutry_direction1_img_q").hide();
			$(".coutry_direction2_img_q").hide();
			$(".coutry_direction3_img_q").hide();
			$(".coutry_direction4_img_q").hide();
		} else{
			$(".coutry_direction1_img_q").show();
			$(".coutry_direction2_img_q").show();
			$(".coutry_direction3_img_q").show();
			$(".coutry_direction4_img_q").show();
		}
	})
	
	
})
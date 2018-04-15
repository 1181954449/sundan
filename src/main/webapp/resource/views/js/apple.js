$(function() {
	$("#applePagination span").on("click", function() {
		$("#appleCarouselFigureContent").animate({
			left: -$(this).index() * $("#appleCarouselFigureContent img").width()
		});
	});
	data=[{
		img:"../img/apple/apple_carousel_figure.jpg"
	},{
		img:"../img/apple/apple_carousel_figure.jpg"
	},{
		img:"../img/apple/apple_carousel_figure.jpg"
	},{
		img:"../img/apple/apple_carousel_figure.jpg"
	},{
		img:"../img/apple/apple_carousel_figure.jpg"
	}
	]
	var str="";
	data.forEach(function(v){
		str+="<a href='###'>"
	        +"<img src='"+v.img+" '/>"
	        +"</a>"
	})
	document.querySelector("#appleCarouselFigureContent").innerHTML=str;
});
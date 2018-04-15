$(function(){
	$(document).scroll(function(){
		var scrollTopH = $(document).scrollTop();
		if (scrollTopH > 600) {
			$(".brand_all_address_url_a").css("padding-top","70px");
		}
	})
	
})
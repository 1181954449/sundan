$(function() {

	$(".help").load("help_center3.html");
	//bug
	$(".first_btn").off('mouseenter').unbind('mouseleave');
	if($(".help").load("help_center3.html")) {
		$(".first_btn").attr("disabled", true).css({
			"background": "#f3f3f3",
			"color": "#333"
		});
		
	}

	$(".first_btn").click(function() {
		$(".help").load("help_center3.html");
		$(".second_btn").click()
		
	});
	$(".second_btn").click(function() {
		console.log('!!!!')
		$(".help").load("help_center3.html");
		$(".first_btn").off('mouseenter').unbind('mouseleave');
		if($(".help").load("help_center3.html")) {

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
		$(".help").load("help_center2.html");
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
		if($(".help").load("help_center2.html")) {
			$(".forth_btn").attr("disabled", true).css({"background":"#f3f3f3","color": "#333"})
			$(".first_btn").attr("disabled", false).css("background", "white");
		}
	});
	$(".forth_btn").click(function() {
		$(".help").load("help_center2.html");
		$(".third_btn").click();
	});
	$("button").click(function() {
		if($(this).text() == '>' || $(this).text() == '<') return;
		$(this).addClass("cur").siblings().removeClass("cur");
	})

})
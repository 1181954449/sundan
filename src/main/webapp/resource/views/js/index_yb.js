(function() {

	var subblock = $(".subpage"),
		head = subblock.find('h2'),
		ul = $("#proinfo"),
		lis = ul.find("li"),
		inter = false;
	$(".log").click(function() { //点击log进入首页
		location.href = "http://10.80.13.199:8020/mysundan/index.html";
	});
	ul.hover(function(event) {
		event.stopPropagation();
	});

	lis.hover(function() {
		if(!$(this).hasClass('nochild')) {
			$(this).addClass("prosahover");
			$(this).find(".prosmore").removeClass('hide');
			$(this).find("a.ti img").attr("src", "img/nav_img/" + $(this).attr("id") + "blue.png");
		}
	}, function() {
		if(!$(this).hasClass('nochild')) {
			if($(this).hasClass("prosahover")) {
				$(this).removeClass("prosahover");
			}
			$(this).find("a.ti img").attr("src", "img/nav_img/" + $(this).attr("id") + "gray.png");
			$(this).find(".prosmore").addClass('hide');
		}

	});
	//头部搜索框聚焦则边框变色
	$(".search input").focus(function() {
		$(".search input").attr("placeholder", "")
	});
	$(".search input").blur(function() {
		$(".search input").attr("placeholder", "nova3e")
	});
	//鼠标移入列表背景色变灰
	$("#proinfo,.prosmore").hover(function() {
		$("body").css("background", "rgba(0,0,0,0.5)");
	}, function() {
		$("body").css("background", "white");
	});
	//头部轮播图
	var headImg = ["img/head_lunbo/1.jpg", "img/head_lunbo/2.jpg", "img/head_lunbo/3.jpg", "img/head_lunbo/4.jpg", "img/head_lunbo/5.jpg", "img/head_lunbo/6.jpg", "img/head_lunbo/7.jpg"];
	var headNum = 0;
	function lunbo() {
		$(".head_lunbo").css("background", "url(" + headImg[headNum] + ")");
		headNum++;
		if(headNum > 6) {
			headNum = 0;
		}
	}
	var headTime = setInterval(lunbo, 2000);
	$(".head_num div").click(function() {
		console.log($(this).attr("class").slice(-1))
		$(".head_lunbo").css("background", "url(img/head_lunbo/" + $(this).attr("class").slice(-1) + ".jpg)");
	});

	//login_register_cart 页面转换
	$(".linkbox div").click(function() {
		var linkbox = $(this).prop("className");
		//				open(linkbox+".html");
		location.href = "html/" + linkbox + ".html";
		console.log(linkbox);
		ul.css("display", "none");
	});

	//首页三级列表
	//errcode	请求的结果 0表示成功
	//msg		返回信息
	//category	三级分类全部数据	
	//			$.ajax({
	//			    type: "GET",
	////			    dataType: 'jsonp',
	//			    jsonp: "callback",
	//			    url: "http://10.80.13.82:8080/category/list",
	//			    data: "cat_id=0",
	//			    timeout: 3000,
	//			    success: function(msg) {
	//			    		console.log(msg);
	//			    		var jso = JSON.parse(msg);
	//			      	console.log(jso);
	//			    }
	//				
	//			});

	//搜索框交互
	//			$.post("Http://10.80.13.136:8080/search/globalSearch",{keyWord:$(".search input").val()},function(data){
	//				console.log(data);
	//			});

	//头部滚轮事件 固定定位
	//			var headline = $("div").css({
	//				width:"100%",
	//				height: "1px",
	//				background: "rgb(0,187,213)",
	//			});
	$(window).scroll(function() {
		//				console.log($(window).scrollTop());
		if($(window).scrollTop() >= 500) {
			console.log(1)
			$("header").css({
				position: "fixed",
				top: 0,
				left: "50%",
				background:"white",
				margin: "-5px 0 0 -612px",
			});
			$("header span").hide();
			$("header .search").css({
				marginTop: "-50px",
			})
			$("header .linkbox").css({
				top: "20px",
			})
			$("header").css({});

		} else {
			$("header").css({
				position: "relative",
				left: "50%",
				margin: "20px 0 20px -612px",
			});
			$("header span").show();
			$("header .search").css({
				marginTop: "-60px",
			})
			$("header .linkbox").css({
				top: "10px",
			})
		}
	});
	//左侧边栏滚动出现
	$(window).scroll(function() {
		if($(window).scrollTop() >= 250) {
			$(".left_side").css("display", "block");
		} else {
			$(".left_side").css("display", "none");
		}
	});
	//左侧边栏滚动定位
	$(".left_recommend").click(function() {
		$('html,body').animate({
			scrollTop: $().offset().top
		}, 800);
	});
	$(".left_find").click(function() {
		$('html,body').animate({
			scrollTop: $().offset().top
		}, 800);
	});
	$(".left_Man").click(function() {
		$('html,body').animate({
			scrollTop: $().offset().top
		}, 800);
	});
	$(".left_home").click(function() {
		$('html,body').animate({
			scrollTop: $().offset().top
		}, 800);
	});
	$(".left_taste").click(function() {
		$('html,body').animate({
			scrollTop: $().offset().top
		}, 800);
	});
	$(".left_seasons").click(function() {
		$('html,body').animate({
			scrollTop: $().offset().top
		}, 800);
	});
	$(".left_bargain").click(function() {
		$('html,body').animate({
			scrollTop: $().offset().top
		}, 800);
	});
	$(".left_top").click(function() {
		$('html,body').animate({
			scrollTop: '0'
		}, 800);
	});
})();
$(function() {
	$(".index_dingbu").load("common/index_sousuo.html", function() {
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
		//鼠标移入列表背景色变灰 prosmore出现
		$("#proinfo").mouseover(function() {
			$(".zy_cover").css("display", "block");
		}).mouseout(function() {
			$(".zy_cover").css("display", "none");
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
		//滚动头部的定位问题
		$(window).scroll(function() {
			if($(window).scrollTop() > 60 && $(window).scrollTop() < 400) {
				$("header").css("display", "none");
			} else if($(window).scrollTop() >= 400) {
				$("header").css({
					display: "block",
					position: "fixed",
					borderBottom: "5px solid #39BBD5"
				});
			} else {
				$("header").css({
					display: "block",
					position: "static",
					borderBottom: "0px solid #39BBD5"
				});
			}
		});
	});

});
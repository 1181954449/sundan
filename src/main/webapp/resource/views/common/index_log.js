$(function() {
	$(".dingbu").load("../common/sousuo_nav_log.html", function() {
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
				$(this).find("a.ti img").attr("src", "../img/nav_img/" + $(this).attr("id") + "blue.png");
			}
		}, function() {
			if(!$(this).hasClass('nochild')) {
				if($(this).hasClass("prosahover")) {
					$(this).removeClass("prosahover");
				}
				$(this).find("a.ti img").attr("src", "../img/nav_img/" + $(this).attr("id") + "gray.png");
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
		//右上侧账户列表显隐
		$(".account_head,.account_con ul,.account_con ul li").hover(function(){
			console.log(1)
			$(".account_con ul").show()},function(){$(".account_con ul").hide();
		});
		$(".account_con ul li").hover(function(){$(this).css("background-color","lightgray")},function(){$(this).css("background-color","white")});//右上侧账户列表背景颜色
		//点击购物车 进入购物车页面
		$(".cart").click(function(){
			location.href = "../html/cartLogin.html";
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
		
	});
	
	
	
	
		//个人页 左侧列表控制
		var arrow = true;
		$(".personal_listup").click(function(){
			arrow = !arrow;
			if (arrow) {
				$(this).find($(".personal_arrow")).attr("src","../img/account/personal_con_arrowdown.png");//箭头向下
				$(this).siblings().find("ul").show();//列表显
			} else{
				$(this).find($(".personal_arrow")).attr("src","../img/account/personal_con_arrow.png");//箭头向上
				$(this).siblings().find("ul").hide();//列表隐
			}
		});
		
		$(".personal_per ul li:nth-child(3)").click(function(){//安全中心
			location.href = "personal_safe.html";
		});
		$(".personal_per ul li:nth-child(4)").click(function(){//收货地址
			location.href = "goodAddress.html";
		});

	
	

});
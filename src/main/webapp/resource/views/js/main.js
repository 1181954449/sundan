$(function() {
	//首页推荐
	$.ajax({
		type: "post",
		url: "Http://10.80.13.136:8080/goods/findGoodsByRecommend",
		async: true,
		data: {

		},
		success: function(data) {
			var dataJson = JSON.parse(data);
			var proList = "";
			for(var i = 0; i < dataJson.length; i++) {
				proList += `<li class="goods_block">
						<div class="main_goods">
							<a href="html/products_details.html?goodsId=${dataJson[i].goodsId}" target="_blank">
								<img src=${dataJson[i].goodsFirstPic} />
							</a>
							<div class="main_goods_detail">
								<h4>${dataJson[i].goodsTitle}</h4>
								<p>梦境红渐变色，充满热情</p>
								<div class="price">¥${dataJson[i].price}</div>
							</div>
							<div class="main_goods_cover">
								<div class="price">¥${dataJson[i].price}</div>
								<div class="main_goods_goshopping">加入购物车</div>
							</div>
						</div>
					</li>`;
			}
			$("#recom_list").append(proList);
			$("#main_list_salesoff_con").append(proList);
			var proListStr = "";
			for(var i = 0; i < dataJson.length - 2; i++) {
				proListStr += `<li class="goods_block">
						<div class="main_goods">
							<a href="html/products_details.html?goodsId=${dataJson[i].goodsId}" target="_blank">
								<img src=${dataJson[i].goodsFirstPic} />
							</a>
							<div class="main_goods_detail">
								<h4>${dataJson[i].goodsTitle}</h4>
								<p>梦境红渐变色，充满热情</p>
								<div class="price">¥${dataJson[i].price}</div>
							</div>
							<div class="main_goods_cover">
								<div class="price">¥${dataJson[i].price}</div>
								<div class="main_goods_goshopping">加入购物车</div>
							</div>
						</div>
					</li>`;
			}
			$(".main_list_seacon").append(proListStr);
			//个体商品的移入移出去问题
			$(".goods_block").mouseover(function() {
				$(this).children().find($(".main_goods_detail")).hide().next().css("display", "block");
			}).mouseout(function() {
				$(".main_goods_detail").show().next().css("display", "none");
			});
		}
	});
	var i = 0;
	/*首页特价区的轮播图*/
	$("#sales_btn_r").click(function() {
		i++;
		$("#main_list_salesoff_con").animate({
			left: -248 * i
		}, 500);
		//如果i大于最大的个体产品个数 临界判断

	});
	$("#sales_btn_l").click(function() {
		i--;
		$("#main_list_salesoff_con").animate({
			left: -248 * i
		}, 500);
		//如果i<0,动态生成 个体产品 临界判断

	});
	//味
	//嘤嘤嘤,好难过 /(ㄒoㄒ)/~~ HTML里面有很多li重复的,那么就不要用到id 特别是JS交互(只能取到id的第一个) css样式还是有效果的
	$(".smell_li").mouseover(function() {
			$(this).find(".main_taste_cover").css("display", "block");
		}).mouseout(function() {
			$(this).find($(".main_taste_cover")).css("display", "none");
		}
		);
	//个体商品的移入移出去问题
	$(".sales_goods").mouseover(function() {
		$(".sales_goods_detail").hide().next().css("display", "block");
	});
	$(".sales_goods").mouseout(function() {
		$(".sales_goods_detail").show().next().css("display", "none");
	});
	/*侧边栏特效*/
	function sidetab(top){
		var dx = $(".main_con").offset().left;
		if(top >= 263) {
			$(".main_lsidebar").css({
				display: "block",
				left: dx,
				top: "40%"
			});
			if(top < 1089) {
				$(".recommend").addClass("active").parent().siblings().children().removeClass("active");
			} else if(top < 2013) {
				$(".discovery").addClass("active").parent().siblings().children().removeClass("active");
			} else if(top < 2794) {
				$(".man").addClass("active").parent().siblings().children().removeClass("active");
			} else if(top < 3576) {
				$(".home").addClass("active").parent().siblings().children().removeClass("active");
			} else if(top < 4343) {
				$(".taste").addClass("active").parent().siblings().children().removeClass("active");
			} else if(top < 4800) {
				$(".season").addClass("active").parent().siblings().children().removeClass("active");
			} else {
				$(".sales").addClass("active").parent().siblings().children().removeClass("active");
			}

		} else {
			$(".main_lsidebar").css({
				display: "none"
			});
		}
	}
	//滚轮位置 侧边栏颜色固定
	function sidetabfix(top){
		var dx = $(".main_con").offset().left;
		if(top >= 263) {
			$(".main_lsidebar").css({
				display: "block",
				left: dx,
				top: "40%"
			});
			if(top < 1089) {
				$(".recommend").addClass("active");
			} else if(top < 2013) {
				$(".discovery").addClass("active");
			} else if(top < 2794) {
				$(".man").addClass("active");
			} else if(top < 3576) {
				$(".home").addClass("active");
			} else if(top < 4343) {
				$(".taste").addClass("active");
			} else if(top < 4800) {
				$(".season").addClass("active");
			} else {
				$(".sales").addClass("active");
			}
		} else {
			$(".main_lsidebar").css({
				display: "none"
			});
		}
	}
	$(window).scroll(function() {
		var top = $(window).scrollTop();
		console.log(99999,top);
		sidetab(top);
	}).resize(function() {
		var dx = $(".main_con").offset().left;
		$(".main_lsidebar").css({
			left: dx
		});
	});
	//这里有bug .active  加类名无效果 
	$(".main_lsidebar a").mouseover(function(index) {
		//在mouseover的时候先找一找水已经有了 active这个类名
		$(this).children().addClass("active").parent().siblings().children().removeClass("active");
		sidetabfix($(window).scrollTop());
	}).mouseout(function(){
		$(this).children().removeClass("active");
		sidetabfix($(window).scrollTop());
	});
	//gototop  动画是html啦
	$("#gototop").click(function() {
		$("html").animate({
			scrollTop: "0px"
		},1000);
	});
});
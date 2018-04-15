//goods_id 没有改 啊啊啊啊啊啊!!!!!!!!
$(function() {
	//当前页面的url
	var aHref = window.location.href;
	//获取id中的id
	var aId = aHref.split("=")[1];
	//1.详情页单个商品所属的分类层级
	$.ajax({
		type: "post",
		url: "http://10.80.13.82:8080/category/hierarchy",
		data: "goodsId=2", //+aId,
		success: function(data) {
			var dataProWhere = JSON.parse(data);
			var whereStr = "";
			//处理后台给的嵌套分类层级数据
			var obj = dataProWhere.CatHierarchy;
			var lenNum = 0;
			var nameWhere = [];
			var decategoryIds = [];

			function nameNum(obj) {
				lenNum++;
				nameWhere.push(obj.name);
				decategoryIds.push(obj.category_id);
				if(obj.parent_id != 0) { //说明有父级
					var obj = obj.parents; //对象
					nameNum(obj);
				}
			}
			nameNum(obj);
			for(var i = lenNum - 1; i >= 0; i--) {
				if(i == 0) {
					whereStr += `<span>${nameWhere[i]}</span>`;
				} else {
					whereStr += `<span>
					<a href="listfilter.html?${decategoryIds[i]}">${nameWhere[i]}&nbsp;&nbsp;&gt;</a>
				</span>`;
				}
			}
			$(".pros_where").append(whereStr);
			//			console.log(nameWhere, lenNum,decategoryIds);
			//			console.log(dataProWhere.CatHierarchy,"层级");
		}
	});
	//2.详情接口
	$.ajax({
		type: "get",
		url: "/goods/goodsdetails",
		async: true,
		data: "goodsId=2", //+aId,
		success: function(data) {
			var dataJs = JSON.parse(data);
			$("h2[title='goodsTitle']").text(dataJs.data.goodsTitle);
			$(".pro_pri span").text(dataJs.data.price);
			var proTextstoreLi = dataJs.data.goods_attrbute.split(",");
			var lis = "";
			for(var i = 0; i < proTextstoreLi.length; i++) {
				lis += `<li>${proTextstoreLi[i]}</li>`;
			}
			$(".pro_textstore").append(lis);
			//商品展示的数组
			var goodsImgs = [];
			//介绍的数组
			var goodsImgPro = [];
			dataJs.data.goods_imgs.forEach(item => {
				if(item.goods_details == "商品展示") {
					goodsImgs.push(item);
				} else {
					goodsImgPro.push(item);
				}
			});
			var zoomLis = "";
			for(var i = 0; i < goodsImgs.length; i++) {
				if(i == 0) {
					zoomLis += `<li class="selected"><img src="${goodsImgs[0].goodsImg}" alt="" /></li>`;
				} else {
					zoomLis += `<li><img src="${goodsImgs[i].goodsImg}" alt="" /></li>`;
				}
			}
			$(".pros_album_pics_list").append(zoomLis);
			$(".pros_album_pics img").attr("src", $(".pros_album_pics_list li:first img").attr("src"));
			$(".zoom_big img").attr("src", $(".pros_album_pics_list li:first img").attr("src"));
			//放大镜这一块的效果 小图 mouseover的交互
			$(".pros_album_pics_list li").mouseover(function() {
				$(".pros_album_pics img").attr("src", $(this).children().attr("src"));
				$(".zoom_big img").attr("src", $(this).children().attr("src"));
				$(this).addClass("selected").siblings().removeClass("selected");
			});
			//颜色数组
			var goodsColorA = [];
			//容量数组
			var rongliangA = [];
			//库存数组
			var kuncunA = [];
			dataJs.data.typeList.forEach(item => {
				if(item.goodskey == "颜色") {
					goodsColorA.push(item);
				}
				if(item.goodskey == "容量") {
					rongliangA.push(item);
				} else {
					kuncunA.push(item);
				}
			});
			var choseFoC = "";
			for(var i = 0; i < goodsColorA.length; i++) {
				if(i == 0) {
					choseFoC += `<a href="999"><span class="pro_style_color selected">${goodsColorA[0].goodsvalue}</span></a>`;
				} else {
					choseFoC += `<a href="999"><span class="pro_style_color">${goodsColorA[i].goodsvalue}</span></a>`;
				}
			}
			$(".please_forcolor").append(choseFoC);
			//颜色选择  下面有ajax请求
			$(".pro_style_color").click(function() {
				event.preventDefault();
				$(this).addClass("selected").parent().siblings().children("span").removeClass("selected");
				$.ajax({
					type: "get",
					url: "Http://10.80.13.49:8091/goods/goodsCutImg",
					data: {
						goods_id: dataJs.data.goodsId,
						goodsvalue: $(this).text()
					},
					async: true,
					success: function(data) {
						var imgChange = JSON.parse(data);
						//移除节点li
						$(".pros_album_pics_list li").remove();
						//重新创建节点li
						var imgChan = "";
						for(var i = 0; i < imgChange.data.length; i++) {
							if(i == 0) {
								imgChan += `<li class="selected"><img src="${imgChange.data[0].goodsImg}" alt="" /></li>`;
							} else {
								imgChan += `<li><img src="${imgChange.data[i].goodsImg}" alt="" /></li>`;
							}
						}
						$(".pros_album_pics_list").append(imgChan);
						$(".pros_album_pics img").attr("src", $(".pros_album_pics_list li:first img").attr("src"));
						//放大镜这一块的效果 小图 mouseover的交互
						$(".pros_album_pics_list li").mouseover(function() {
							$(".pros_album_pics img").attr("src", $(this).children().attr("src"));
							$(".zoom_big img").attr("src", $(this).children().attr("src"));
							$(this).addClass("selected").siblings().removeClass("selected");
						});
						//console.log(imgChange);
					},
					error: function() {
						alert("后台小哥哥谈恋爱去了");
					}
				});
			});
			//选择容量 容量的数组
			var rongLiStr = "";
			for(var i = 0; i < rongliangA.length; i++) {
				if(i == 0) {
					rongLiStr += `<span class="pro_style_capa selected">${rongliangA[0].goodsvalue}</span>`;
				} else {
					rongLiStr += `<span class="pro_style_capa">${rongliangA[i].goodsvalue}</span>`;
				}
			}
			$(".a_rongliang").append(rongLiStr);
			$(".pro_style_capa").click(function() {
				event.preventDefault();
				$(this).addClass("selected").siblings().removeClass("selected");
			});
			//产品介绍
			$(".pro_intro>img").attr("src", goodsImgPro[0].goodsImg);
			var proIntroImg = "";
			for(var i = 1; i < 5; i++) {
				proIntroImg += `<li><img src="${goodsImgPro[i].goodsImg}"/></li>`;
			}
			$(".hot_pro").append(proIntroImg);
			var proIntroImgS = "";
			for(var i = 5; i < goodsImgPro.length; i++) {
				proIntroImgS += `<img src="${goodsImgPro[i].goodsImg}">`;
			}
			$(".pro_intro").append(proIntroImgS);
			//分享到那里的编号
			$("#serial").text(dataJs.data.goodsNumber);
			//规格参数的数据处理
			var guigeData = dataJs.data.specList;
			//console.log(guigeData);
			var lens = Object.keys(guigeData).length;
			var guigeTitle = [];
			for(x in guigeData) {
				guigeTitle.push(x);
			};
			//获取对象的属性值,[]方法,[]里面的属性可以是变量,而点语法则只能是对象中固定的属性
			for(var i = 0; i < guigeTitle.length; i++) {
				var guigeTitleStr = "";
				guigeTitleStr += `<div class="guide_title">${guigeTitle[i]}</div>
				<table class="pro_guige_table"></table>`;
				$(".pro_guigecs").append(guigeTitleStr);
				for(var j = 0; j < (guigeData[guigeTitle[i]]).length; j++) {
					var guigeCon = "";
					guigeCon += `<tr>
								<td class="item_titles">${(guigeData[guigeTitle[i]])[j].goodskey}</td>
								<td>${(guigeData[guigeTitle[i]])[j].goodsvalue}</td>
							</tr>`;
					$(".pro_guige_table").append(guigeCon);
				}
			};
			//同类商品推荐
			var goodssStr = dataJs.data.goodss;
			var goodsTui = "";
			//console.log(goodssStr,88888);
			for(var i = 0; i < goodssStr.length; i++) {
				goodsTui += `<div class="pro_same_con">
								<a href="products_details.html?=${goodssStr[i].goodsId}">
								<img src="${goodssStr[i].goodsFirstPic}"/>
								<div class="pro_same_ofimg">
									<p>${goodssStr[i].goodsTitle}</p>
									<span class="price">¥${goodssStr[i].price}</span>
								</div>
								</a>
							</div>`;
			}
			$(".pro_opt_same").append(goodsTui);
			//console.log(goodsImgPro);
			//console.log(goodsColorA, rongliangA);
			//console.log(goodssStr,88888);
			//立即购买按钮
			$(".pro_btn_now").click(function() {
				event.preventDefault();
				//id
				//console.log(dataJs.data.goodsId,111);
				//名字
				//console.log(dataJs.data.goodsTitle,222);
				//数量
				//console.log($("#pro_number").val(),333);
				//颜色
				console.log($(".please_forcolor selected").text(), 444); //没拿到结果
				//价格
				//console.log(dataJs.data.price,555);
				//如果没有登录 右边的侧边栏 登录页面出现
				//如果已经登陆了 点击立即购买  会员中心 安全中心 验证身份 验证身份后回到商城 变成已经完全登陆的状态
				//上传信息
				$.ajax({
					type: "get",
					url: "http://10.80.13.49:8091/order/buy",
					async: true,
					data: "goodsId="+dataJs.data.goodsId, //其实还要传别的很多东西的
					success: function(data) {
						var clickBuy = JSON.parse(data); //js最开始的对象
						//console.log(clickBuy,"立即购买");
						//把数据存到cookie
						addCookie("goodsId", dataJs.data.goodsId);
						addCookie("goodsTitle", dataJs.data.goodsTitle);
						addCookie("price", dataJs.data.price);
						addCookie("proNumber", $("#pro_number").val());
					},
					error: function() {
						alert("后台小哥哥抽烟去了");
					}
				});
				//然后跳转到 核对订单页面
				window.location.href = "../html/checkfororder.html"; //要不要拼写一个goodsId???
			});
			//点击加入购物车按钮
			$(".pro_btn_add").click(function() {
				event.preventDefault();
				$.ajax({
					type: "get",
					url: "http://10.80.13.49:8091/shop/add",
					async: true,
					data: "goodsId="+dataJs.data.goodsId,
					success: function(data) {
						var addProShop = JSON.parse(data);
						console.log(addProShop);
						//把数据存到cookie
						addCookie("goodsIdCar", dataJs.data.goodsId);
						addCookie("goodsTitleCar", dataJs.data.goodsTitle);
						addCookie("priceCar", dataJs.data.price);
						addCookie("proNumberCar", $("#pro_number").val());
					},
					error: function() {
						alert("这里是点击加入到购物车的后台数据");
					}
				});
			});
			console.log(dataJs, "data数据");
		},
		error: function() {
			alert("后台小哥哥谈恋爱去了");
		}
	});

	console.log(aId);
	console.log(aHref);

	$(".pro_style_capa").click(function() {
		event.preventDefault();
		$(this).addClass("selected").siblings().removeClass("selected");
	});
	$(".pro_stock_l").click(function() {
		var i = $("#pro_number").val();
		i--;
		if(i < 1) {
			i = 1;
		}
		$("#pro_number").val(i);
	});
	$(".pro_stock_r").click(function() {
		var i = $("#pro_number").val();
		i++;
		//如果大于库存就不能再加了,这里和后台再聊聊
		$("#pro_number").val(i);
	});
	//配件推荐的效果
	$(".pro_relative_title h2").mouseover(function() {
		$(this).addClass("state").siblings().removeClass("state");
		$(".pros_re_list" + $(this).index()).css("display", "block").siblings("ul").css("display", "none");

	});
	//同类推荐的导航
	$(".pro_same_nav li").click(function() {
		event.preventDefault();
		$(this).addClass("cliked").siblings().removeClass("cliked");
		$(".pro_same_right .tab").eq($(this).index()).css("display", "block").siblings().filter(".tab").css("display", "none");
	});
	//评论晒图
	$(".pro_show_img li").click(function() {
		$("#cover_forimg").css("display", "block");
		//滚轮事件 不滚动
		$(document).on('mousewheel', function() {
			return false;
		});
	});
	$(".img_circle").click(function() {
		$("#cover_forimg").css("display", "none");
		//解除滚轮事件
		$(document).off('mousewheel');
	});
	//您可能喜欢以下商品				
	$(".may_goods_block").mouseover(function() {
		$(this).children().filter(".may_goods_detail").hide().next().css("display", "block");
	}).mouseout(function() {
		$(this).children().filter(".may_goods_detail").show().next().css("display", "none");
	});
	//你可能喜欢的按钮
	var i = 0;
	$("#may_btn_r").click(function() {
		event.preventDefault();
		i++;
		$("#may_lunbo_con").animate({
			left: -242 * i
		}, 500);
		console.log(i);
		//如果i大于最大的个体产品个数 临界判断

	});
	$("#may_btn_l").click(function() {
		event.preventDefault();
		i--;
		$("#may_lunbo_con").animate({
			left: -242 * i
		}, 500);
		//如果i<0,动态生成 个体产品 临界判断
		console.log(i, 999);

	});
});

var leftDiv = document.querySelector(".pros_album_pics");
var zoomDiv = document.getElementById("zoom");
var rightDiv = document.querySelector(".zoom_big");
var img1 = document.getElementById("img1");
leftDiv.onmouseover = function() {
	zoomDiv.style.display = 'block';
	//不断移动的过程
	leftDiv.onmousemove = function(e) { //拖拽是移动(move)的过程不是over
		var eve = event || e;
		var x = eve.clientX - leftDiv.parentElement.parentElement.offsetLeft - zoomDiv.offsetWidth / 2 - 150; //??????
		var y = eve.clientY - leftDiv.parentElement.parentElement.offsetTop - zoomDiv.offsetHeight / 2; //????????
		var maxX = leftDiv.clientWidth - zoomDiv.clientWidth;
		var maxY = leftDiv.clientHeight - zoomDiv.clientHeight;
		if(x < 0) x = 0;
		if(x > maxX) x = maxX;
		if(y < 0) y = 0;
		if(y > maxY) y = maxY;
		zoomDiv.style.left = x + 'px';
		zoomDiv.style.top = y + 'px';
		//		console.log(zoomDiv.offsetWidth,zoomDiv.offsetHeight);
		//		console.log(x,y);
		//右侧出现放大图
		rightDiv.style.display = 'block';
		img1.style.position = 'absolute';
		img1.style.left = -x / maxX * (img1.offsetWidth - rightDiv.offsetWidth) + 'px';
		img1.style.top = -y / maxY * (img1.offsetHeight - rightDiv.offsetHeight) + 'px';
		//		console.log(img1.style.left,img1.style.top,img1.offsetWidth,rightDiv.offsetWidth);
	}
}
leftDiv.onmouseout = function() {
	zoomDiv.style.display = 'none';
	rightDiv.style.display = 'none';
}
//高德地图
$(function() {
	$(".mendain_now").click(function() {
		event.preventDefault();
		$("#container").css("display", "block");
	});
	$(".gaode_close").click(function() {
		console.log("高德地图");
		$("#container").css("display", "none");
		return false;
	});
});
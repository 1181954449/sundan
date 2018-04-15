$(function() {
	//		data = [{
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
	//			var str="";
	$.ajax({
		type: "post",
		url: "Http://10.80.13.136:8080/goods/findGoodsByNew",
		async: true,
		data: "page = 8",
		success: function(data) {
			var dataJson = JSON.parse(data);
			console.log(dataJson)
			var data = dataJson.goodss
			console.log(data);
			var str = "";
			data.forEach(function(v) {
				str += `<div class='contentDisplayItem'> 
				 			<a href='products_details.html?goodsId=2' target='_blank'>
				  				<div class='displayShadow'>
								</div>
					   			<img src=${v.goodsFirstPic } />
								<div class='DisplayIntro'>
				        				<p>${v.goodsTitle} </p>
					 			</div> 
							  	<div class='displayPrice'> <span>	¥
							      ${v.price} </span>
							    </div>
			  				</a>
						</div>`;
			});
			console.log(str)

			$("#contentDisplay").append(str);
		}
	});

})
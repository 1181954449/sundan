/*封装cookie操作的对应功能方法*/
//添加
/*c_key:键名
 *c_val: 键值
 * Time:失效时间 以秒计*/
function addCookie(c_key,c_val,time){
	document.cookie = c_key+"="+c_val+";max-age="+time;
}
//获取
function getCookieWithKey(c_key){
	if(hasCookieWithKey(c_key)){
		var arr = document.cookie.split(';');
		for (var i = 0; i < arr.length; i++) {
			var tmp = arr[i].split("=");
			if(tmp[0].trim() === c_key){   //1️⃣以;分号分割c_key前面会有一个空格,所以trim()[去除首尾多余空格]2️⃣或者刚开始就用;+空格来分割
				return	tmp[1];
			}
		}
	}else{
		return null;
	}
}
//修改
function setCookie(c_key,c_val,time){
	if(hasCookieWithKey(c_key)){
		addCookie(c_key,c_val,time);
	}
}
//删除
function deleteCookieWithKey(c_key){
	//时间设置为过去的时间就是删除
	addCookie(c_key,"",-1);
}
//是否含有某个键名
function hasCookieWithKey(c_key){
	if(document.cookie.indexOf(c_key)>-1){
		return true;
	}else{
		return false;
	}
}

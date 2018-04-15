var timer;
var btn=document.getElementById("back_to_top");
btn.onclick=function(){
	var t=document.documentElement.scrollTop||document.body.scrollTop;
	clearInterval(timer);
	timer=setInterval(function(){
		t-=20;
		//返回顶部的时候.scrollTop的t的条件语句一定要是<=0,也许是t的值最后是负的会出现bug?
		if(t<=0){
			clearInterval(timer);
		}
		console.log(timer);
		console.log(t);
		document.documentElement.scrollTop=document.body.scrollTop=t;
	},50)
}

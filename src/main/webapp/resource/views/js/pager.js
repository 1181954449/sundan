Page({
	num: 3, //页码数
	startnum: 1, //指定页码
	elem: $('#page1'), //指定的元素
	callback: function(n) { //回调函数
		console.log(n);
	}
});

function Page(opt) {
	var set = $.extend({
		num: null,
		startnum: 1,
		elem: null,
		callback: null
	}, opt || {});
	if(set.startnum > set.num || set.startnum < 1) {
		set.startnum = 1;
		return false;
	}
	var n = 0,
		htm = '';
	var clickpages = {
		elem: set.elem,
		num: set.num,
		callback: set.callback,
		init: function() {
			this.elem.next('div.pageJump').children('.button').unbind('click')
			this.elem.children('li').click(function() {
				
				var txt = $(this).children('a').text();
				var page = '',
					ele = null;
				var page1 = parseInt(clickpages.elem.children('li.active').attr('page'));
                
				if(isNaN(parseInt(txt))) {
					switch(txt) {
						case '<':
							if(page1 == '1') {
								return;
							}
							if(page1 >= (clickpages.num - 1) || page1 <= 3 || clickpages.num <= 6) {
								ele = clickpages.elem.children('li.active').prev();
							} else {
								clickpages.newPages('prev', page1 - 1);
								ele = clickpages.elem.children('li.active');
							}
							break;
					}
				} else {
					if((parseInt(txt) >= (clickpages.num - 3) || parseInt(txt) <= 3) && clickpages.num > 6) {
						clickpages.newPages('jump', parseInt(txt));
					}
					ele = $(this);
				}
				page = clickpages.actPages(ele);
				if(page != '' && page != page1) {
					if(clickpages.callback) {
						clickpages.callback(parseInt(page));
					}
				}
			});
		},
		//active
		actPages: function(ele) {
			ele.addClass('active').siblings().removeClass('active');
			return clickpages.elem.children('li.active').text();
			
		},

		//newpages
		newPages: function(type, i) {
			var html = "",
				htmlLeft = "",
				htmlRight = "",
				htmlC = "";
			var HL = '<li><a>...</a></li>';
			html = '<li><a  aria-label="Previous">&laquo;</a></li>\
					<li><a><</a></li>'
			for(var n = 0; n < 3; n++) {
				htmlC += '<li ' + ((n - 1) == 0 ? 'class="active"' : '') + ' page="' + (i + n - 1) + '"><a>' + (i + n - 1) + '</a></li>';
				htmlLeft += '<li ' + ((n + 2) == i ? 'class="active"' : '') + ' page="' + (n + 2) + '"><a>' + (n + 2) + '</a></li>';
				htmlRight += '<li ' + ((set.num + n - 3) == i ? 'class="active"' : '') + ' page="' + (set.num + n - 3) + '"><a>' + (set.num + n - 3) + '</a></li>';
			}
			if(this.num > 5 || this.num < 3) {
				set.elem.html(html);
				clickpages.init({
					num: set.num,
					elem: set.elem,
					callback: set.callback
				});
			}
		}
	}
	if(set.num <= 1) {
		$(".pagination").html('');
		return;
	} else if(parseInt(set.num) <= 6) {
		n = parseInt(set.num);
		var html = '<li><a ><</a></li>';
		for(var i = 1; i <= n; i++) {
			if(sessionStorage.getItem("startnum")!=1) {
			startnum=i
		}else{startnum=1};
		console.log(sessionStorage)
			if(i == set.startnum) {
				sessionStorage.setItem("startnum",i);
				html += '<li class="active" page="' + i + '"><a  href="new_product'+i+'.html">' + i + '</a></li>';
				
			} else {
				html += '<li page="' + i + '"><a  href="new_product'+i+'.html">' + i + '</a></li>';
			}
		}
		set.elem.html(html);
		clickpages.init();
	} 
	
}


   
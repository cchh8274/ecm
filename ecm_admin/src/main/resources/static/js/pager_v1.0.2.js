/**
 * 分页插件
	$(".pager").ucPager({
		pageClass	 : "分页样式",
		currentPage  : "当前页",				
		totalPage    : "总页数",				
		pageSize     : "每页显示的记录数",			
		clickCallback: cback				//分页回调方法
	})
 */
(function($){
	var pageBar = {
		pre : "<",
		next : ">",
		nav : function(p, pn,opid) {
			var html = "";
			if (pn <= 1 || p > pn) {
				html = this.pager(1, 1,opid);
			} else {
				html += (p == 1) ? this.showPre(0,0,opid) : this.showPre(1, p,opid);
				if (pn > 6) {
					var c = 1;
					if (p >= 5 && p <= pn) {
						html += (p == 1) ? this.numStatusHTML(0, 1,opid) : this.numStatusHTML(1, 1,opid);
					} else {
						for ( var i = 1; i < 4; i++) {
							html += (p == i) ? this.numStatusHTML(0, i,opid) : this.numStatusHTML(1, i,opid);
						}
					}
					html += (p >= 5) ? "<span class='placeholder'>...</span>" : "";
					c = p - 2; if (c >= 3 && c < pn - 2) html += (p == c) ? this.numStatusHTML(0, c,opid) : this.numStatusHTML(1, c,opid);
					c = p - 1; if (c > 3 && c < pn - 2) html += (p == c) ? this.numStatusHTML(0, c,opid) : this.numStatusHTML(1, c,opid);
					c = p;     if (c > 3 && c < pn - 2) html += (p == c) ? this.numStatusHTML(0, c,opid) : this.numStatusHTML(1, c,opid);
					c = p + 1; if (c > 3 && c < pn - 2) html += (p == c) ? this.numStatusHTML(0, c,opid) : this.numStatusHTML(1, c,opid);
					c = p + 2; if (c > 3 && c < pn - 2) html += (p == c) ? this.numStatusHTML(0, c,opid) : this.numStatusHTML(1, c,opid);
					html += (p <= pn - 4) ? "<span class='placeholder'>...</span>" : "";
					if (p <= pn - 4) {
						html += (p == pn) ? this.numStatusHTML(0, pn,opid) : this.numStatusHTML(1, pn,opid);
					} else {
						for ( var i = pn - 2; i <= pn; i++) {
							html += (p == i) ? this.numStatusHTML(0, i,opid) : this.numStatusHTML(1, i,opid);
						}
					}
				} else {
					for ( var i = 1; i <= pn; i++) {
						html += (p == i) ? this.numStatusHTML(0, i,opid) : this.numStatusHTML(1, i,opid);
					}
				}
				html += (p == pn) ? this.showNext(0,0,opid) : this.showNext(1, p,opid);
			}
			return html;
		},
		pager : function(p, pn,opid) {
			var html = "";
			if (pn <= 1) {
				this.p = p;
				this.pn = pn;
				html = this.showPre(0,0,opid) + this.numStatusHTML(0, p,opid) + this.showNext(0,opid);
			}
			return html;
		},
		go : function(p, pn,opid) {
			var html = this.nav(p, pn,opid) + this.btnHTML(p, pn,opid);
			return html;
		},
		numStatusHTML : function(t, p,opid) {
			return (t == 0) ? ("<span class='cur'>" + p + "</span>") : "<a href='javascript:void(0);' onclick='javascript:doPageNumSearch("	+ p + ",\"" + opid +"\");return false;'>" + p + "</a>";
		},
		showPre : function(t, p,opid) {
			var $disable = "<a class='prev disable' href='javascript:void(0);'>&nbsp;"
					+ this.pre + "<s class='icon-prev'></s><i></i></a>";
			var $able = "<a class='prev' href='javascript:void(0);' onclick='javascript:doPageNumSearch("
					+ (p - 1) + ",\"" + opid +"\");return false;'>&nbsp;" + this.pre
					+ "<s class='icon-prev'></s><i></i></a>";
			return (t == 0) ? $disable : $able;
		},
		showNext : function(t, p,opid) {
			var $disable = "<a class='next disable' href='javascript:void(0);'>"
					+ this.next + "<s class='icon-next'></s><i></i></a>";
			var $able = "<a class='next' href='javascript:void(0);' onclick='javascript:doPageNumSearch("
					+ (p + 1) + ",\"" + opid +"\");return false;'>" + this.next + "<s class='icon-next'></s><i></i></a>";
			return (t == 0) ? $disable : $able;
		},
		btnHTML : function(p, pn,opid) {
			var html = "<label for='pagenum' class='txt-wrap'>到<input type='text' id='pNum"+opid+"' class='txt' bNum='"+ pn +"' value='" + p + "'>页</label>"
					+ "<a href='javascript:void(0)' zdx='nBtn' class='btn"+opid+"'>确定</a>";
			return html;
		}
	};
	$.fn.extend({
		gPager: function(options) {
			this.ucPager(options);
		},
		ucPager: function(options) {
			var op = $.extend({pageClass:'pager',currentPage:1,totalPage:0,pageSize:15,clickCallback:function(){}},options);
			
			return this.each(function() {
				var $this = $(this);
				
				if(!$this.hasClass(op.pageClass)) {
					$this.addClass(op.pageClass);
				}
				
				var clickCallback = function() {
					op.clickCallback(op.currentPage);
					//$this.html(pageBar.go(op.currentPage, op.totalPage));
				}

				var opid = "";
				if(op.id != undefined && op.id != null){
					opid = op.id;
				}else{
					var parId = $this.parent().attr("id");
					opid = parId.replace("_fy","") + "gopage";
				}
				//alert(opid);
				$this.html(pageBar.go(op.currentPage, op.totalPage,opid));
				
				//翻页
				window.doPageNumSearch = function(p,opid){  //p当前页数
					op.currentPage = p.toString();
					//alert("p-tostring="+p.toString() )
					var funcEvalStr = opid + "(" + p.toString() + ")";
					//alert(funcEvalStr)
					eval(funcEvalStr)
					//clickCallback();
				};	
				
				var $pNum = $("#pNum"+opid, $this);
					
				$pNum.on('keyup', function(){
					var val = $(this).val(), reg1 = /^\d+$/ig, reg2 = /\d+/ig;
					if(!reg1.test(val)){
						$(this).val(val.match(reg2) ? val.match(reg2)[0] : '');
					};
				})
				
				$('.btn'+opid,$this).bind('click',function(){
					var $val = $.trim($pNum.val());
					if($val<1){
						$pNum.val(1);
						op.currentPage = 1 + '';
					}else if($val>op.totalPage){
						$pNum.val(op.totalPage);
						op.currentPage = op.totalPage.toString();
					}else{
						$pNum.val($val);
						op.currentPage = $val;
					};
					
					clickCallback();
				});
				
			});
		}
	})
})(jQuery);
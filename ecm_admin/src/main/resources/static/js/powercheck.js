/*
 * jQuery powercheck 对input、button元素，设置管制权限
 * @author luojing
 * @since 20170724
 * 使用方法（举例input元素）：
 * 1.在input元素中添加class “powercheck”
 * 2.在input元素中添加属性“resource”，并赋值。如：resource="/fileInfo/fileInfoView1.dhtml",属性值一般为菜单管理表中配置的菜单类型为“资源页面-030”状态的
 */
var powerCheck = {
	//初始化
	init : function() {
		var urlsParam = "";
		var powerCheckDom = $("input.powercheck,button.powercheck");
		if(powerCheckDom.length == 0){
			return;
		}
		
		powerCheckDom.each(function(index, element) {
			var self = $(this);
			var resource = self.attr('resource');
			
			urlsParam += resource;
			
			if (index != powerCheckDom.length - 1) {
				urlsParam += ",";
			}
		});
		
		if(urlsParam ==""){
			return;
		}
		
		var params={};
		params.urlsParam = urlsParam;
		
		var jsonStr = JSON.stringify(params);
	    jsonStr = encodeURIComponent(jsonStr);
	    
		$.ajax({
			type : "POST",
			url : webUrl + "/roleLinkPower/check.dhtml",
			timeout : 60000,
			dataType : 'json',
			data : "jsonStr=" + jsonStr,
			success : function(data) {
				var powerCheck = new Array();
				var dataStr = data.code;

				powerCheck = dataStr.split(",");
				for(var i=0;i<powerCheckDom.length;i++){
					if(powerCheck[i] == "false"){
						$(powerCheckDom[i]).attr("disabled",true);
					}else{
						$(powerCheckDom[i]).attr("disabled",false);
					}
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				layer.alert('系统异常，请稍后重试！');
			},
			complete : function(XMLHttpRequest, status) {
				if (status == "timeout") {
					ajaxTimeoutTest.abort();
					layer.alert("操作超时！");
				}
			}
		});
	}
};
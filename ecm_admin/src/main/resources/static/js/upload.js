/***
 * formid 提交表单id
 * successhand 上传成功回调函数
 * errhand    上传失败回调函数
 * return 
 * code":"success" 成功  error：失败
 * othMsg 返回上传文件信息
 * **/
function upLoad (formid,successhand,storeType){
	var url = $("#"+formid).attr("action");
	if(storeType != undefined){
		$("#"+formid+" #store_type").val(storeType);
	}
	var options = {
			 url : url,
			 type : 'POST',
			 dataType : 'json',
			 success : function(result){
					 window[successhand](result);
			 },
			 error:function(){
				 var errMessage = new Object();
				 errMessage.code="error";
				 window[successhand](errMessage);
			 }
	};
	 $("#"+formid).ajaxSubmit(options);
 }




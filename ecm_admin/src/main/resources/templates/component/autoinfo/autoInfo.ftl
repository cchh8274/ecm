<#--
	页面调用 js以及样式已经放入resourceofhead.ftl （jquery-ui.min.css、jQuery-2.1.4.min.js、jquery-ui.min.js）其中jquery的js要放在前面
	formId:所在form的id，如果不属于form中的输入项，则填写所在父类的元素的id
	id:调用页面input 唯一标示
	queryUrl:自动补全请求后台绝对路径
	class:调用页面input 样式
	<@autoInfo.autoInfoHtml formId="queryDemoInfoForm" id="demoNm" queryUrl="${props('myctx')}/demoInfo/autoInfo.dhtml" class="form-control" />
	
	
	后台方法
	入参
	queryParam:查询条件
	
	出参 JSONArray
	
	JSONObject 参数定义
	name:其余需要的参数（自己定义）
	value:补全之后自动显示的参数
	
	// 测试方法 （根据具体需求重写或完善方法）
 	@RequestMapping("/autoInfo.dhtml")
    public void autoInfo(HttpServletRequest request, HttpServletResponse response){
    	JSONArray array = new JSONArray();
    	if(StringUtils.isEmpty(request.getParameter("queryParam"))){
    		return;
    	}
    	HashMap<String, Object> paramMap = new HashMap<String, Object>();
    	paramMap.put("demoNm", request.getParameter("queryParam"));
    	try {
			paramMap = demoInfoLogic.queryPageDemoInfo(paramMap);
			paramMap = (HashMap<String, Object>) afterLogic(request, paramMap);
			List<HashMap<String, Object>> records = (List<HashMap<String, Object>>) paramMap.get(PageQueryUtil.PAGERECORDS);
	        if (records != null) {
	            // 如果是分页的查询，则对每一个结果进行处理
	            for (HashMap<String, Object> cell_of_list : records) {
	                JSONObject jo = new JSONObject();
		    		jo.put("name",cell_of_list.get("demoId"));
		    		jo.put("value",cell_of_list.get("demoNm"));
		    		array.add(jo);
	            }
	        }
		        
    	} catch (Exception e) {
			e.printStackTrace();
		} finally{
			ajaxJsonMessage(request, response,array.toString());
		}
    	
	   } 
-->

<#macro autoInfoHtml formId id queryUrl class >
<input class="${class}" id="${id}" name="${id}"/>
<script>
    $(function () {
        var cache = {};
        $("#${formId} #${id}").autocomplete({
            minLength: 2,
            source: function (request, response) {
                var term = request.term;
                if (term in cache) {
                    response(cache[term]);
                    return;
                }
                $.getJSON("${queryUrl}?queryParam=" + $("#${formId} #${id}").val(), request, function (data, status, xhr) {
                    cache[term] = data;
                    response(data);
                });
            }
        });

    });
</script>
</#macro>

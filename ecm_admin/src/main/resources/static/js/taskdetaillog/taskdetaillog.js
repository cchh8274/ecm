$(function(){
    searchTaskDetailLog('');
    $('#queryTaskDetailLogpageSize').on('change',function () {
        var currentPage = $("#queryTaskDetailLogcurrentPage").val();
        searchTaskDetailLog(currentPage);
    });
    
    //时间框校验函数，时间框在校验失败后，再点击，不会触发校验，因此手工触发
    function revalidateDate(formname,datefieldname){
        if($("#"+formname+"").data('bootstrapValidator')!=null
            && $("#"+formname+"").data('bootstrapValidator').validateField !=null)
        {
            $("#"+formname+"").data('bootstrapValidator').updateStatus(datefieldname,"NOT_VALIDATED",null);
            $("#"+formname+"").data('bootstrapValidator').validateField(datefieldname);
        }
    }
    //在模态框对用户完全可见后，清空所有的校验状态，经验证：
    // show.bs.modal，shown.bs.modal，hide.bs.modal	，hidden.bs.modal仅有  shown.bs.modal在功能上没问题，但是视觉上仍不太满意
    // 理论上说，最合适的是hidden.bs.modal，当模态框关闭时清空，但实际上未能生效，因此使用了shown.bs.modal
    $('#updateTaskDetailLog').on('shown.bs.modal', function () {
        $('#validateUpdateTaskDetailLogForm').bootstrapValidator('resetForm', false);
    });
    $('#queryTaskDetailLogForm #createTime').dateRangePicker({
        startOfWeek: 'monday',
        separator : ' 至 ',
        format: 'YYYY-MM-DD HH:mm:ss',
        autoClose: false,
        time: {
            enabled: true
        }
    });

    //增加任务执行日志表校验
    $('#validateAddTaskDetailLogForm').bootstrapValidator({
        fields : {
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         addTaskDetailLog();
     });

    //修改任务执行日志表校验
    $('#validateUpdateTaskDetailLogForm').bootstrapValidator({
        fields : {
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         updateTaskDetailLog();
     });
    //查询任务执行日志表校验
    $('#queryTaskDetailLogForm').bootstrapValidator({
        fields : {
            taskCnName : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9_]+$","message":"中文名称只能是中文、英文、数字与下划线"},"stringLength":{"min":1,"max":10,"message":"中文名称长度不正确"}}
            }
            ,
            businessObjName : {
                validators : {"regexp":{"regexp":"^[A-Za-z0-9_]+$","message":"业务对象名称只能是英文、数字与下划线"},"stringLength":{"min":1,"max":32,"message":"业务对象名称长度不正确"}}
            }
            ,
            registerGroup : {
                validators : {"regexp":{"regexp":"^[A-Za-z0-9_]+$","message":"注册组只能是英文、数字与下划线"},"stringLength":{"min":1,"max":32,"message":"注册组名称长度不正确"}}
            }
            ,
            execResult : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9_]+$","message":"执行结果只能是中文、英文、数字与下划线"},"stringLength":{"min":1,"max":10,"message":"执行结果长度不正确"}}
            }
            ,
            createTime : {
                validators : {"stringLength":{"min":1,"max":100,"message":"XX信息长度不正确"},"regexp":{"regexp":"^([0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2})( )*至( )*([0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2})$","message":"时间格式不正确"}}
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         console.log("查询校验通过");
     });

});

function searchTaskDetailLog(currentPage,queryType,fileName,exportParam){
    //没有bootstrapvalidator，则返回
    if($('#queryTaskDetailLogForm').data('bootstrapValidator')!=null) {
        //对查询框进行校验
        $('#queryTaskDetailLogForm').data('bootstrapValidator').validate();
        //校验没有通过，则返回
        if(!$('#queryTaskDetailLogForm').data('bootstrapValidator').isValid()){
            return;
        }
        //----个性化校验示例开始
        //if($('#query"+cleanentityClassName+"Form #被验证组件name').val()=='#'){
        //    layer.alert('XX禁止查询')
        //    //第三个参数为，显示的错误信息所属的validator规则
        //    $('#queryTaskDetailLogForm').data('bootstrapValidator').updateStatus('被验证组件name','INVALID','stringLength');
        //    return;
        //}
        //----个性化校验示例结束
    }
    var params ={};
    if(currentPage == "undefined" || currentPage =="" || currentPage == null){
        var currentPage_text = $("#queryTaskDetailLogcurrentPage").val();
        if(currentPage_text =="undefined" || currentPage_text =="" || currentPage_text == null){
            currentPage_text = "1";
        }
        params.startIndex = currentPage_text;
    }else{
        params.startIndex = currentPage;
    }

    var pageSize= $("#queryTaskDetailLogpageSize").val();
    if(pageSize=="undefined" || pageSize =="" || pageSize == null){
        params.pageSize = "10";
    }else{
        params.pageSize = pageSize;
    }
    if(queryType!=undefined && queryType =='download'){
        params.queryType='download';
        params.exportParam=exportParam;
        params.fileName=fileName;
    }

    params.taskCnName = $("#queryTaskDetailLogForm #taskCnName").val();
    params.businessObjName = $("#queryTaskDetailLogForm #businessObjName").val();
    params.registerGroup = $("#queryTaskDetailLogForm #registerGroup").val();
    params.execResult = $("#queryTaskDetailLogForm #execResult").val();
    var createTime_regexp = new RegExp('^([0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2})( )*至( )*([0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2})$');
    var createTime_value = $("#queryTaskDetailLogForm #createTime").val();
    if(createTime_regexp.test(createTime_value)){
        var cs = createTime_regexp.exec(createTime_value);
        params.createTime_start = cs[1]||'';
        params.createTime_end = cs[4]||'';
    }
    

    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    jsonStr = encodeURIComponent(jsonStr);
    if(queryType!=undefined && queryType =='download'){
        window.location.href=webUrl+"/taskDetailLog/search.dhtml?jsonStr="+jsonStr+"&v="+Math.random();
        return;
    }
    
    $.ajax({
        type:"POST",
        url:webUrl+"/taskDetailLog/search.dhtml",
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $("#taskDetailLogTR_FIRST").siblings().remove();
                var  resultList=data.rows[0].pageRecords;

                //分页
                $("#queryTaskDetailLogcurrentPage").val(data.rows[0].startIndex);
                $("#queryTaskDetailLogtotalPage").val(data.rows[0].totalPage);
                $("#queryTaskDetailLogpageSize").val(data.rows[0].pageSize);
                for(var i=0;i<resultList.length;i++){
                    var taskDetailLogTr = $("<tr class=\"taskDetailLogTr\"></tr>");
                    $("#taskDetailLogTR_FIRST").parent().append(taskDetailLogTr);
                    taskDetailLogTr.append("<td><input style=\"width:23px;\" type=\"checkbox\"/></td><td>"+(i+1)+"</td>")
                    .append("<td>"+resultList[i].taskCnName+"</td>")
                    .append("<td>"+resultList[i].businessObjName+"</td>")
                    .append("<td>"+resultList[i].registerGroup+"</td>")
                    .append("<td>"+resultList[i].globalTaskName+"</td>")
                    .append("<td>"+resultList[i].beginTime+"</td>")
                    .append("<td>"+resultList[i].endTime+"</td>")
                    .append("<td>"+resultList[i].execResult+"</td>")
                    .append("<td>"+resultList[i].createTime+"</td>")
                    .append("<td class=\"operateTbl\"><button class=\"btn btn-default btn-sm\" onclick=\"return queryTaskDetailLogObject('"+resultList[i].id+"');\"><i class=\"fa fa-search\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return  delTaskDetailLog('"+resultList[i].id+"');\"><i class=\"fa fa-trash-o\"></i></button></td>");
                }
                var currentPage = Number($("#queryTaskDetailLogcurrentPage").val());
                var totalPage   = Number($("#queryTaskDetailLogtotalPage").val());
                var pageSize    = Number($("#queryTaskDetailLogpageSize").val());
                $("#queryTaskDetailLog_fy .pager").ucPager({
                    currentPage : currentPage,
                    totalPage : totalPage,
                    pageSize : pageSize,
                    clickCallback: queryTaskDetailLoggopage
                });
            }else{
                layer.alert(data.message);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                layer.alert("操作超时！");
            }
        }
    });
}

function queryTaskDetailLoggopage(currentPage) {
    searchTaskDetailLog(currentPage);
}

function addTaskDetailLog(){
    var url=webUrl+"/taskDetailLog/insert.dhtml";
    var params={};
    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    $.ajax({
        type:"POST",
        url:url,
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $('#addTaskDetailLog').modal('hide');
                searchTaskDetailLog('');
                layer.msg('添加成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateAddTaskDetailLogForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateAddTaskDetailLogForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
                $('#validateAddTaskDetailLogForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateAddTaskDetailLogForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function updateTaskDetailLog(){
    var url=webUrl+"/taskDetailLog/edit.dhtml";
    var params={};
    params.id_key = $("#validateUpdateTaskDetailLogForm #id_key").val();
    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    $.ajax({
        type:"POST",
        url:url,
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $('#updateTaskDetailLog').modal('hide');
                searchTaskDetailLog('');
                layer.msg('修改成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateUpdateTaskDetailLogForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateUpdateTaskDetailLogForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
            $('#validateUpdateTaskDetailLogForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateUpdateTaskDetailLogForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function editTaskDetailLog(id_key){
    var url=webUrl+"/taskDetailLog/queryObject.dhtml";
    var params={};
    params.id_key = id_key;;
    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    $.ajax({
        type:"POST",
        url:url,
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $('#updateTaskDetailLog').modal();
                $("#validateUpdateTaskDetailLogForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblTaskDetailLog;
            }else{
                layer.alert(data.message);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
            }
        }
    });
}

function queryTaskDetailLogObject(id_key){
    var url=webUrl+"/taskDetailLog/queryObject.dhtml";
    var params={};
    params.id_key = id_key;;
    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    $.ajax({
        type:"POST",
        url:url,
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $('#detailTaskDetailLog').modal();
                $("#validateDetailTaskDetailLogForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblTaskDetailLog;
                $("#validateDetailTaskDetailLogForm #id2").val(objInfo.id!=null?objInfo.id:'');
                $("#validateDetailTaskDetailLogForm #taskCnName2").val(objInfo.taskCnName!=null?objInfo.taskCnName:'');
                $("#validateDetailTaskDetailLogForm #businessObjName2").val(objInfo.businessObjName!=null?objInfo.businessObjName:'');
                $("#validateDetailTaskDetailLogForm #registerGroup2").val(objInfo.registerGroup!=null?objInfo.registerGroup:'');
                $("#validateDetailTaskDetailLogForm #ipInfo2").val(objInfo.ipInfo!=null?objInfo.ipInfo:'');
                $("#validateDetailTaskDetailLogForm #globalTaskName2").val(objInfo.globalTaskName!=null?objInfo.globalTaskName:'');
                $("#validateDetailTaskDetailLogForm #globalTaskCount2").val(objInfo.globalTaskCount!=null?objInfo.globalTaskCount:'');
                $("#validateDetailTaskDetailLogForm #globalTaskIndex2").val(objInfo.globalTaskIndex!=null?objInfo.globalTaskIndex:'');
                $("#validateDetailTaskDetailLogForm #batchCount2").val(objInfo.batchCount!=null?objInfo.batchCount:'');
                $("#validateDetailTaskDetailLogForm #batchIndex2").val(objInfo.batchIndex!=null?objInfo.batchIndex:'');
                $("#validateDetailTaskDetailLogForm #beginTime2").val(objInfo.beginTime!=null?objInfo.beginTime:'');
                $("#validateDetailTaskDetailLogForm #endTime2").val(objInfo.endTime!=null?objInfo.endTime:'');
                $("#validateDetailTaskDetailLogForm #execResult2").val(objInfo.execResult!=null?objInfo.execResult:'');
                $("#validateDetailTaskDetailLogForm #execLog2").val(objInfo.execLog!=null?objInfo.execLog:'');
                $("#validateDetailTaskDetailLogForm #createTime2").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateDetailTaskDetailLogForm #upTime2").val(objInfo.upTime!=null?objInfo.upTime:'');
            }else{
                layer.alert(data.message);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
            }
        }
    });
}
function delTaskDetailLog(id_key){
    layer.confirm('是否删除？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        var url=webUrl+"/taskDetailLog/del.dhtml";
        var params={};
        var currentPage= $("#queryTaskDetailLogcurrentPage").val();
        params.id_key = id_key;;
        var jsonStr = JSON.stringify(params);
        jsonStr = encodeURIComponent(jsonStr);
        $.ajax({
            type:"POST",
            url:url,
            timeout:60000,
            dataType:'json',
            data:"jsonStr="+jsonStr,
            success:function(data){
                if(data.code == "success"){
                    layer.msg('删除成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                    searchTaskDetailLog(currentPage);
                }else{
                    layer.alert(data.message);
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                layer.alert('系统异常，请稍后重试！');
            },
            complete : function(XMLHttpRequest,status){
                if(status == "timeout"){
                    ajaxTimeoutTest.abort();
                    alert("操作超时！");
                }
            }
        });
    });
}



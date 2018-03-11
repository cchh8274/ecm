$(function(){
    searchTaskDetailReport('');
    $('#queryTaskDetailReportpageSize').on('change',function () {
        var currentPage = $("#queryTaskDetailReportcurrentPage").val();
        searchTaskDetailReport(currentPage);
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
    $('#updateTaskDetailReport').on('shown.bs.modal', function () {
        $('#validateUpdateTaskDetailReportForm').bootstrapValidator('resetForm', false);
    });

    //增加任务执行实例表校验
    $('#validateAddTaskDetailReportForm').bootstrapValidator({
        fields : {
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         addTaskDetailReport();
     });

    //修改任务执行实例表校验
    $('#validateUpdateTaskDetailReportForm').bootstrapValidator({
        fields : {
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         updateTaskDetailReport();
     });
    //查询任务执行实例表校验
    $('#queryTaskDetailReportForm').bootstrapValidator({
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
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         console.log("查询校验通过");
     });

});

function searchTaskDetailReport(currentPage,queryType,fileName,exportParam){
    //没有bootstrapvalidator，则返回
    if($('#queryTaskDetailReportForm').data('bootstrapValidator')!=null) {
        //对查询框进行校验
        $('#queryTaskDetailReportForm').data('bootstrapValidator').validate();
        //校验没有通过，则返回
        if(!$('#queryTaskDetailReportForm').data('bootstrapValidator').isValid()){
            return;
        }
        //----个性化校验示例开始
        //if($('#query"+cleanentityClassName+"Form #被验证组件name').val()=='#'){
        //    layer.alert('XX禁止查询')
        //    //第三个参数为，显示的错误信息所属的validator规则
        //    $('#queryTaskDetailReportForm').data('bootstrapValidator').updateStatus('被验证组件name','INVALID','stringLength');
        //    return;
        //}
        //----个性化校验示例结束
    }
    var params ={};
    if(currentPage == "undefined" || currentPage =="" || currentPage == null){
        var currentPage_text = $("#queryTaskDetailReportcurrentPage").val();
        if(currentPage_text =="undefined" || currentPage_text =="" || currentPage_text == null){
            currentPage_text = "1";
        }
        params.startIndex = currentPage_text;
    }else{
        params.startIndex = currentPage;
    }

    var pageSize= $("#queryTaskDetailReportpageSize").val();
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

    params.taskCnName = $("#queryTaskDetailReportForm #taskCnName").val();
    params.businessObjName = $("#queryTaskDetailReportForm #businessObjName").val();
    params.registerGroup = $("#queryTaskDetailReportForm #registerGroup").val();

    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    jsonStr = encodeURIComponent(jsonStr);
    if(queryType!=undefined && queryType =='download'){
        window.location.href=webUrl+"/taskDetailReport/search.dhtml?jsonStr="+jsonStr+"&v="+Math.random();
        return;
    }
    
    $.ajax({
        type:"POST",
        url:webUrl+"/taskDetailReport/search.dhtml",
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $("#taskDetailReportTR_FIRST").siblings().remove();
                var  resultList=data.rows[0].pageRecords;

                //分页
                $("#queryTaskDetailReportcurrentPage").val(data.rows[0].startIndex);
                $("#queryTaskDetailReporttotalPage").val(data.rows[0].totalPage);
                $("#queryTaskDetailReportpageSize").val(data.rows[0].pageSize);
                for(var i=0;i<resultList.length;i++){
                    var taskDetailReportTr = $("<tr class=\"taskDetailReportTr\"></tr>");
                    $("#taskDetailReportTR_FIRST").parent().append(taskDetailReportTr);
                    taskDetailReportTr.append("<td><input style=\"width:23px;\" type=\"checkbox\"/></td><td>"+(i+1)+"</td>")
                    .append("<td>"+resultList[i].taskCnName+"</td>")
                    .append("<td>"+resultList[i].businessObjName+"</td>")
                    .append("<td>"+resultList[i].registerGroup+"</td>")
                    .append("<td>"+resultList[i].globalTaskName+"</td>")
                    .append("<td>"+resultList[i].lastBeginTime+"</td>")
                    .append("<td>"+resultList[i].lastEndTime+"</td>")
                    .append("<td>"+resultList[i].last5AvgCost+"</td>")
                    .append("<td>"+resultList[i].execNeedCount+"</td>")
                    .append("<td>"+resultList[i].execSuccCount+"</td>")
                    .append("<td class=\"operateTbl\"><button class=\"btn btn-default btn-sm\" onclick=\"return queryTaskDetailReportObject('"+resultList[i].id+"');\"><i class=\"fa fa-search\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return  delTaskDetailReport('"+resultList[i].id+"');\"><i class=\"fa fa-trash-o\"></i></button></td>");
                }
                var currentPage = Number($("#queryTaskDetailReportcurrentPage").val());
                var totalPage   = Number($("#queryTaskDetailReporttotalPage").val());
                var pageSize    = Number($("#queryTaskDetailReportpageSize").val());
                $("#queryTaskDetailReport_fy .pager").ucPager({
                    currentPage : currentPage,
                    totalPage : totalPage,
                    pageSize : pageSize,
                    clickCallback: queryTaskDetailReportgopage
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

function queryTaskDetailReportgopage(currentPage) {
    searchTaskDetailReport(currentPage);
}

function addTaskDetailReport(){
    var url=webUrl+"/taskDetailReport/insert.dhtml";
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
                $('#addTaskDetailReport').modal('hide');
                searchTaskDetailReport('');
                layer.msg('添加成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateAddTaskDetailReportForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateAddTaskDetailReportForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
                $('#validateAddTaskDetailReportForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateAddTaskDetailReportForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function updateTaskDetailReport(){
    var url=webUrl+"/taskDetailReport/edit.dhtml";
    var params={};
    params.id_key = $("#validateUpdateTaskDetailReportForm #id_key").val();
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
                $('#updateTaskDetailReport').modal('hide');
                searchTaskDetailReport('');
                layer.msg('修改成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateUpdateTaskDetailReportForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateUpdateTaskDetailReportForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
            $('#validateUpdateTaskDetailReportForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateUpdateTaskDetailReportForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function editTaskDetailReport(id_key){
    var url=webUrl+"/taskDetailReport/queryObject.dhtml";
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
                $('#updateTaskDetailReport').modal();
                $("#validateUpdateTaskDetailReportForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblTaskDetailReport;
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

function queryTaskDetailReportObject(id_key){
    var url=webUrl+"/taskDetailReport/queryObject.dhtml";
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
                $('#detailTaskDetailReport').modal();
                $("#validateDetailTaskDetailReportForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblTaskDetailReport;
                $("#validateDetailTaskDetailReportForm #id2").val(objInfo.id!=null?objInfo.id:'');
                $("#validateDetailTaskDetailReportForm #taskCnName2").val(objInfo.taskCnName!=null?objInfo.taskCnName:'');
                $("#validateDetailTaskDetailReportForm #businessObjName2").val(objInfo.businessObjName!=null?objInfo.businessObjName:'');
                $("#validateDetailTaskDetailReportForm #registerGroup2").val(objInfo.registerGroup!=null?objInfo.registerGroup:'');
                $("#validateDetailTaskDetailReportForm #ipInfo2").val(objInfo.ipInfo!=null?objInfo.ipInfo:'');
                $("#validateDetailTaskDetailReportForm #globalTaskName2").val(objInfo.globalTaskName!=null?objInfo.globalTaskName:'');
                $("#validateDetailTaskDetailReportForm #globalTaskCount2").val(objInfo.globalTaskCount!=null?objInfo.globalTaskCount:'');
                $("#validateDetailTaskDetailReportForm #globalTaskIndex2").val(objInfo.globalTaskIndex!=null?objInfo.globalTaskIndex:'');
                $("#validateDetailTaskDetailReportForm #lastBeginTime2").val(objInfo.lastBeginTime!=null?objInfo.lastBeginTime:'');
                $("#validateDetailTaskDetailReportForm #lastEndTime2").val(objInfo.lastEndTime!=null?objInfo.lastEndTime:'');
                $("#validateDetailTaskDetailReportForm #last10AvgCost2").val(objInfo.last10AvgCost!=null?objInfo.last10AvgCost:'');
                $("#validateDetailTaskDetailReportForm #last5AvgCost2").val(objInfo.last5AvgCost!=null?objInfo.last5AvgCost:'');
                $("#validateDetailTaskDetailReportForm #execNeedCount2").val(objInfo.execNeedCount!=null?objInfo.execNeedCount:'');
                $("#validateDetailTaskDetailReportForm #execSuccCount2").val(objInfo.execSuccCount!=null?objInfo.execSuccCount:'');
                $("#validateDetailTaskDetailReportForm #execHistory2").val(objInfo.execHistory!=null?JSON.stringify(objInfo.execHistory):'');
                $("#validateDetailTaskDetailReportForm #createTime2").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateDetailTaskDetailReportForm #upTime2").val(objInfo.upTime!=null?objInfo.upTime:'');
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
function delTaskDetailReport(id_key){
    layer.confirm('是否删除？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        var url=webUrl+"/taskDetailReport/del.dhtml";
        var params={};
        var currentPage= $("#queryTaskDetailReportcurrentPage").val();
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
                    searchTaskDetailReport(currentPage);
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



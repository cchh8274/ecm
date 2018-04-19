$(function(){
    searchAreaInfo('');
    $('#queryAreaInfopageSize').on('change',function () {
        var currentPage = $("#queryAreaInfocurrentPage").val();
        searchAreaInfo(currentPage);
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
    $('#updateAreaInfo').on('shown.bs.modal', function () {
        $('#validateUpdateAreaInfoForm').bootstrapValidator('resetForm', false);
    });

    //增加区域表校验
    $('#validateAddAreaInfoForm').bootstrapValidator({
        fields : {
            id1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            areaName1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            status1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            enableLevl1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            pageStatus1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            createTime1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            createUser1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            updateTime1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            upUser1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         addAreaInfo();
     });

    //修改区域表校验
    $('#validateUpdateAreaInfoForm').bootstrapValidator({
        fields : {
            id3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            areaName3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            status3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            enableLevl3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            pageStatus3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            createTime3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            createUser3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            updateTime3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            upUser3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         updateAreaInfo();
     });
    //查询区域表校验
    $('#queryAreaInfoForm').bootstrapValidator({
        fields : {
            id : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            areaName : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            status : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            enableLevl : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            pageStatus : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            createTime : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            createUser : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            updateTime : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            upUser : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         console.log("查询校验通过");
     });

});

function searchAreaInfo(currentPage,queryType,fileName,exportParam){
    //没有bootstrapvalidator，则返回
    if($('#queryAreaInfoForm').data('bootstrapValidator')!=null) {
        //对查询框进行校验
        $('#queryAreaInfoForm').data('bootstrapValidator').validate();
        //校验没有通过，则返回
        if(!$('#queryAreaInfoForm').data('bootstrapValidator').isValid()){
            return;
        }
        //----个性化校验示例开始
        //if($('#query"+cleanentityClassName+"Form #被验证组件name').val()=='#'){
        //    layer.alert('XX禁止查询')
        //    //第三个参数为，显示的错误信息所属的validator规则
        //    $('#queryAreaInfoForm').data('bootstrapValidator').updateStatus('被验证组件name','INVALID','stringLength');
        //    return;
        //}
        //----个性化校验示例结束
    }
    var params ={};
    if(currentPage == "undefined" || currentPage =="" || currentPage == null){
        var currentPage_text = $("#queryAreaInfocurrentPage").val();
        if(currentPage_text =="undefined" || currentPage_text =="" || currentPage_text == null){
            currentPage_text = "1";
        }
        params.startIndex = currentPage_text;
    }else{
        params.startIndex = currentPage;
    }

    var pageSize= $("#queryAreaInfopageSize").val();
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

    params.id = $("#queryAreaInfoForm #id").val();
    params.areaName = $("#queryAreaInfoForm #areaName").val();
    params.status = $("#queryAreaInfoForm #status").val();
    params.enableLevl = $("#queryAreaInfoForm #enableLevl").val();
    params.pageStatus = $("#queryAreaInfoForm #pageStatus").val();
    params.createTime = $("#queryAreaInfoForm #createTime").val();
    params.createUser = $("#queryAreaInfoForm #createUser").val();
    params.updateTime = $("#queryAreaInfoForm #updateTime").val();
    params.upUser = $("#queryAreaInfoForm #upUser").val();

    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    jsonStr = encodeURIComponent(jsonStr);
    if(queryType!=undefined && queryType =='download'){
        window.location.href=webUrl+"/areaInfo/search.dhtml?jsonStr="+jsonStr+"&v="+Math.random();
        return;
    }
    
    $.ajax({
        type:"POST",
        url:webUrl+"/areaInfo/search.dhtml",
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $("#areaInfoTR_FIRST").siblings().remove();
                var  resultList=data.rows[0].pageRecords;

                //分页
                $("#queryAreaInfocurrentPage").val(data.rows[0].startIndex);
                $("#queryAreaInfototalPage").val(data.rows[0].totalPage);
                $("#queryAreaInfopageSize").val(data.rows[0].pageSize);
                for(var i=0;i<resultList.length;i++){
                    var areaInfoTr = $("<tr class=\"areaInfoTr\"></tr>");
                    $("#areaInfoTR_FIRST").parent().append(areaInfoTr);
                    areaInfoTr.append("<td><input style=\"width:23px;\" type=\"checkbox\"/></td><td>"+(i+1)+"</td>")
                    .append("<td>"+resultList[i].id+"</td>")
                    .append("<td>"+resultList[i].areaName+"</td>")
                    .append("<td>"+resultList[i].status+"</td>")
                    .append("<td>"+resultList[i].enableLevl+"</td>")
                    .append("<td>"+resultList[i].pageStatus+"</td>")
                    .append("<td>"+resultList[i].createTime+"</td>")
                    .append("<td>"+resultList[i].createUser+"</td>")
                    .append("<td>"+resultList[i].updateTime+"</td>")
                    .append("<td>"+resultList[i].upUser+"</td>")
                    .append("<td class=\"operateTbl\"><button class=\"btn btn-default btn-sm\" onclick=\"return editAreaInfo('"+resultList[i].id+"');\"><i class=\"fa fa-edit\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return  delAreaInfo('"+resultList[i].id+"');\"><i class=\"fa fa-trash-o\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return queryAreaInfoObject('"+resultList[i].id+"');\"><i class=\"fa fa-search\"></i></button></td>");
                }
                var currentPage = Number($("#queryAreaInfocurrentPage").val());
                var totalPage   = Number($("#queryAreaInfototalPage").val());
                var pageSize    = Number($("#queryAreaInfopageSize").val());
                $("#queryAreaInfo_fy .pager").ucPager({
                    currentPage : currentPage,
                    totalPage : totalPage,
                    pageSize : pageSize,
                    clickCallback: queryAreaInfogopage
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

function queryAreaInfogopage(currentPage) {
    searchAreaInfo(currentPage);
}

function addAreaInfo(){
    var url=webUrl+"/areaInfo/insert.dhtml";
    var params={};
    params.id = $("#validateAddAreaInfoForm #id1").val();
    params.areaName = $("#validateAddAreaInfoForm #areaName1").val();
    params.status = $("#validateAddAreaInfoForm #status1").val();
    params.enableLevl = $("#validateAddAreaInfoForm #enableLevl1").val();
    params.pageStatus = $("#validateAddAreaInfoForm #pageStatus1").val();
    params.createTime = $("#validateAddAreaInfoForm #createTime1").val();
    params.createUser = $("#validateAddAreaInfoForm #createUser1").val();
    params.updateTime = $("#validateAddAreaInfoForm #updateTime1").val();
    params.upUser = $("#validateAddAreaInfoForm #upUser1").val();
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
                $('#addAreaInfo').modal('hide');
                searchAreaInfo('');
                layer.msg('添加成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateAddAreaInfoForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateAddAreaInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
                $('#validateAddAreaInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateAddAreaInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function updateAreaInfo(){
    var url=webUrl+"/areaInfo/edit.dhtml";
    var params={};
    params.id_key = $("#validateUpdateAreaInfoForm #id_key").val();
    params.id = $("#validateUpdateAreaInfoForm #id3").val();
    params.areaName = $("#validateUpdateAreaInfoForm #areaName3").val();
    params.status = $("#validateUpdateAreaInfoForm #status3").val();
    params.enableLevl = $("#validateUpdateAreaInfoForm #enableLevl3").val();
    params.pageStatus = $("#validateUpdateAreaInfoForm #pageStatus3").val();
    params.createTime = $("#validateUpdateAreaInfoForm #createTime3").val();
    params.createUser = $("#validateUpdateAreaInfoForm #createUser3").val();
    params.updateTime = $("#validateUpdateAreaInfoForm #updateTime3").val();
    params.upUser = $("#validateUpdateAreaInfoForm #upUser3").val();
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
                $('#updateAreaInfo').modal('hide');
                searchAreaInfo('');
                layer.msg('修改成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateUpdateAreaInfoForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateUpdateAreaInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
            $('#validateUpdateAreaInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateUpdateAreaInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function editAreaInfo(id_key){
    var url=webUrl+"/areaInfo/queryObject.dhtml";
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
                $('#updateAreaInfo').modal();
                $("#validateUpdateAreaInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblAreaInfo;
                $("#validateUpdateAreaInfoForm #id3").val(objInfo.id!=null?objInfo.id:'');
                $("#validateUpdateAreaInfoForm #areaName3").val(objInfo.areaName!=null?objInfo.areaName:'');
                $("#validateUpdateAreaInfoForm #status3").val(objInfo.status!=null?objInfo.status:'');
                $("#validateUpdateAreaInfoForm #enableLevl3").val(objInfo.enableLevl!=null?objInfo.enableLevl:'');
                $("#validateUpdateAreaInfoForm #pageStatus3").val(objInfo.pageStatus!=null?objInfo.pageStatus:'');
                $("#validateUpdateAreaInfoForm #createTime3").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateUpdateAreaInfoForm #createUser3").val(objInfo.createUser!=null?objInfo.createUser:'');
                $("#validateUpdateAreaInfoForm #updateTime3").val(objInfo.updateTime!=null?objInfo.updateTime:'');
                $("#validateUpdateAreaInfoForm #upUser3").val(objInfo.upUser!=null?objInfo.upUser:'');
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

function queryAreaInfoObject(id_key){
    var url=webUrl+"/areaInfo/queryObject.dhtml";
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
                $('#detailAreaInfo').modal();
                $("#validateDetailAreaInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblAreaInfo;
                $("#validateDetailAreaInfoForm #id2").val(objInfo.id!=null?objInfo.id:'');
                $("#validateDetailAreaInfoForm #areaName2").val(objInfo.areaName!=null?objInfo.areaName:'');
                $("#validateDetailAreaInfoForm #status2").val(objInfo.status!=null?objInfo.status:'');
                $("#validateDetailAreaInfoForm #enableLevl2").val(objInfo.enableLevl!=null?objInfo.enableLevl:'');
                $("#validateDetailAreaInfoForm #pageStatus2").val(objInfo.pageStatus!=null?objInfo.pageStatus:'');
                $("#validateDetailAreaInfoForm #createTime2").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateDetailAreaInfoForm #createUser2").val(objInfo.createUser!=null?objInfo.createUser:'');
                $("#validateDetailAreaInfoForm #updateTime2").val(objInfo.updateTime!=null?objInfo.updateTime:'');
                $("#validateDetailAreaInfoForm #upUser2").val(objInfo.upUser!=null?objInfo.upUser:'');
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
function delAreaInfo(id_key){
    layer.confirm('是否删除？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        var url=webUrl+"/areaInfo/del.dhtml";
        var params={};
        var currentPage= $("#queryAreaInfocurrentPage").val();
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
                    searchAreaInfo(currentPage);
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



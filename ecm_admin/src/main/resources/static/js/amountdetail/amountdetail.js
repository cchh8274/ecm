$(function(){
    searchAmountDetail('');
    $('#queryAmountDetailpageSize').on('change',function () {
        var currentPage = $("#queryAmountDetailcurrentPage").val();
        searchAmountDetail(currentPage);
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
    $('#updateAmountDetail').on('shown.bs.modal', function () {
        $('#validateUpdateAmountDetailForm').bootstrapValidator('resetForm', false);
    });

    //增加账户明细表校验
    $('#validateAddAmountDetailForm').bootstrapValidator({
        fields : {
            id1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            accountId1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            unversityName1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            unversityId1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            earningMonth1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            areaId1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            areaName1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            isFreeze1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            earningType1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            earningsMoney1 : {
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
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         addAmountDetail();
     });

    //修改账户明细表校验
    $('#validateUpdateAmountDetailForm').bootstrapValidator({
        fields : {
            id3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            accountId3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            unversityName3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            unversityId3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            earningMonth3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            areaId3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            areaName3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            isFreeze3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            earningType3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            earningsMoney3 : {
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
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         updateAmountDetail();
     });
    //查询账户明细表校验
    $('#queryAmountDetailForm').bootstrapValidator({
        fields : {
            id : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            accountId : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            unversityName : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            unversityId : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            earningMonth : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            areaId : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            areaName : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            isFreeze : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            earningType : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            earningsMoney : {
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
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         console.log("查询校验通过");
     });

});

function searchAmountDetail(currentPage,queryType,fileName,exportParam){
    //没有bootstrapvalidator，则返回
    if($('#queryAmountDetailForm').data('bootstrapValidator')!=null) {
        //对查询框进行校验
        $('#queryAmountDetailForm').data('bootstrapValidator').validate();
        //校验没有通过，则返回
        if(!$('#queryAmountDetailForm').data('bootstrapValidator').isValid()){
            return;
        }
        //----个性化校验示例开始
        //if($('#query"+cleanentityClassName+"Form #被验证组件name').val()=='#'){
        //    layer.alert('XX禁止查询')
        //    //第三个参数为，显示的错误信息所属的validator规则
        //    $('#queryAmountDetailForm').data('bootstrapValidator').updateStatus('被验证组件name','INVALID','stringLength');
        //    return;
        //}
        //----个性化校验示例结束
    }
    var params ={};
    if(currentPage == "undefined" || currentPage =="" || currentPage == null){
        var currentPage_text = $("#queryAmountDetailcurrentPage").val();
        if(currentPage_text =="undefined" || currentPage_text =="" || currentPage_text == null){
            currentPage_text = "1";
        }
        params.startIndex = currentPage_text;
    }else{
        params.startIndex = currentPage;
    }

    var pageSize= $("#queryAmountDetailpageSize").val();
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

    params.id = $("#queryAmountDetailForm #id").val();
    params.accountId = $("#queryAmountDetailForm #accountId").val();
    params.unversityName = $("#queryAmountDetailForm #unversityName").val();
    params.unversityId = $("#queryAmountDetailForm #unversityId").val();
    params.earningMonth = $("#queryAmountDetailForm #earningMonth").val();
    params.areaId = $("#queryAmountDetailForm #areaId").val();
    params.areaName = $("#queryAmountDetailForm #areaName").val();
    params.isFreeze = $("#queryAmountDetailForm #isFreeze").val();
    params.earningType = $("#queryAmountDetailForm #earningType").val();
    params.earningsMoney = $("#queryAmountDetailForm #earningsMoney").val();
    params.createTime = $("#queryAmountDetailForm #createTime").val();
    params.createUser = $("#queryAmountDetailForm #createUser").val();

    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    jsonStr = encodeURIComponent(jsonStr);
    if(queryType!=undefined && queryType =='download'){
        window.location.href=webUrl+"/amountDetail/search.dhtml?jsonStr="+jsonStr+"&v="+Math.random();
        return;
    }
    
    $.ajax({
        type:"POST",
        url:webUrl+"/amountDetail/search.dhtml",
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $("#amountDetailTR_FIRST").siblings().remove();
                var  resultList=data.rows[0].pageRecords;

                //分页
                $("#queryAmountDetailcurrentPage").val(data.rows[0].startIndex);
                $("#queryAmountDetailtotalPage").val(data.rows[0].totalPage);
                $("#queryAmountDetailpageSize").val(data.rows[0].pageSize);
                for(var i=0;i<resultList.length;i++){
                    var amountDetailTr = $("<tr class=\"amountDetailTr\"></tr>");
                    $("#amountDetailTR_FIRST").parent().append(amountDetailTr);
                    amountDetailTr.append("<td><input style=\"width:23px;\" type=\"checkbox\"/></td><td>"+(i+1)+"</td>")
                    .append("<td>"+resultList[i].id+"</td>")
                    .append("<td>"+resultList[i].accountId+"</td>")
                    .append("<td>"+resultList[i].unversityName+"</td>")
                    .append("<td>"+resultList[i].unversityId+"</td>")
                    .append("<td>"+resultList[i].earningMonth+"</td>")
                    .append("<td>"+resultList[i].areaId+"</td>")
                    .append("<td>"+resultList[i].areaName+"</td>")
                    .append("<td>"+resultList[i].isFreeze+"</td>")
                    .append("<td>"+resultList[i].earningType+"</td>")
                    .append("<td>"+resultList[i].earningsMoney+"</td>")
                    .append("<td>"+resultList[i].createTime+"</td>")
                    .append("<td>"+resultList[i].createUser+"</td>")
                    .append("<td class=\"operateTbl\"><button class=\"btn btn-default btn-sm\" onclick=\"return editAmountDetail('"+resultList[i].id+"');\"><i class=\"fa fa-edit\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return  delAmountDetail('"+resultList[i].id+"');\"><i class=\"fa fa-trash-o\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return queryAmountDetailObject('"+resultList[i].id+"');\"><i class=\"fa fa-search\"></i></button></td>");
                }
                var currentPage = Number($("#queryAmountDetailcurrentPage").val());
                var totalPage   = Number($("#queryAmountDetailtotalPage").val());
                var pageSize    = Number($("#queryAmountDetailpageSize").val());
                $("#queryAmountDetail_fy .pager").ucPager({
                    currentPage : currentPage,
                    totalPage : totalPage,
                    pageSize : pageSize,
                    clickCallback: queryAmountDetailgopage
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

function queryAmountDetailgopage(currentPage) {
    searchAmountDetail(currentPage);
}

function addAmountDetail(){
    var url=webUrl+"/amountDetail/insert.dhtml";
    var params={};
    params.id = $("#validateAddAmountDetailForm #id1").val();
    params.accountId = $("#validateAddAmountDetailForm #accountId1").val();
    params.unversityName = $("#validateAddAmountDetailForm #unversityName1").val();
    params.unversityId = $("#validateAddAmountDetailForm #unversityId1").val();
    params.earningMonth = $("#validateAddAmountDetailForm #earningMonth1").val();
    params.areaId = $("#validateAddAmountDetailForm #areaId1").val();
    params.areaName = $("#validateAddAmountDetailForm #areaName1").val();
    params.isFreeze = $("#validateAddAmountDetailForm #isFreeze1").val();
    params.earningType = $("#validateAddAmountDetailForm #earningType1").val();
    params.earningsMoney = $("#validateAddAmountDetailForm #earningsMoney1").val();
    params.createTime = $("#validateAddAmountDetailForm #createTime1").val();
    params.createUser = $("#validateAddAmountDetailForm #createUser1").val();
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
                $('#addAmountDetail').modal('hide');
                searchAmountDetail('');
                layer.msg('添加成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateAddAmountDetailForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateAddAmountDetailForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
                $('#validateAddAmountDetailForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateAddAmountDetailForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function updateAmountDetail(){
    var url=webUrl+"/amountDetail/edit.dhtml";
    var params={};
    params.id_key = $("#validateUpdateAmountDetailForm #id_key").val();
    params.id = $("#validateUpdateAmountDetailForm #id3").val();
    params.accountId = $("#validateUpdateAmountDetailForm #accountId3").val();
    params.unversityName = $("#validateUpdateAmountDetailForm #unversityName3").val();
    params.unversityId = $("#validateUpdateAmountDetailForm #unversityId3").val();
    params.earningMonth = $("#validateUpdateAmountDetailForm #earningMonth3").val();
    params.areaId = $("#validateUpdateAmountDetailForm #areaId3").val();
    params.areaName = $("#validateUpdateAmountDetailForm #areaName3").val();
    params.isFreeze = $("#validateUpdateAmountDetailForm #isFreeze3").val();
    params.earningType = $("#validateUpdateAmountDetailForm #earningType3").val();
    params.earningsMoney = $("#validateUpdateAmountDetailForm #earningsMoney3").val();
    params.createTime = $("#validateUpdateAmountDetailForm #createTime3").val();
    params.createUser = $("#validateUpdateAmountDetailForm #createUser3").val();
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
                $('#updateAmountDetail').modal('hide');
                searchAmountDetail('');
                layer.msg('修改成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateUpdateAmountDetailForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateUpdateAmountDetailForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
            $('#validateUpdateAmountDetailForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateUpdateAmountDetailForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function editAmountDetail(id_key){
    var url=webUrl+"/amountDetail/queryObject.dhtml";
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
                $('#updateAmountDetail').modal();
                $("#validateUpdateAmountDetailForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblAmountDetail;
                $("#validateUpdateAmountDetailForm #id3").val(objInfo.id!=null?objInfo.id:'');
                $("#validateUpdateAmountDetailForm #accountId3").val(objInfo.accountId!=null?objInfo.accountId:'');
                $("#validateUpdateAmountDetailForm #unversityName3").val(objInfo.unversityName!=null?objInfo.unversityName:'');
                $("#validateUpdateAmountDetailForm #unversityId3").val(objInfo.unversityId!=null?objInfo.unversityId:'');
                $("#validateUpdateAmountDetailForm #earningMonth3").val(objInfo.earningMonth!=null?objInfo.earningMonth:'');
                $("#validateUpdateAmountDetailForm #areaId3").val(objInfo.areaId!=null?objInfo.areaId:'');
                $("#validateUpdateAmountDetailForm #areaName3").val(objInfo.areaName!=null?objInfo.areaName:'');
                $("#validateUpdateAmountDetailForm #isFreeze3").val(objInfo.isFreeze!=null?objInfo.isFreeze:'');
                $("#validateUpdateAmountDetailForm #earningType3").val(objInfo.earningType!=null?objInfo.earningType:'');
                $("#validateUpdateAmountDetailForm #earningsMoney3").val(objInfo.earningsMoney!=null?objInfo.earningsMoney:'');
                $("#validateUpdateAmountDetailForm #createTime3").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateUpdateAmountDetailForm #createUser3").val(objInfo.createUser!=null?objInfo.createUser:'');
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

function queryAmountDetailObject(id_key){
    var url=webUrl+"/amountDetail/queryObject.dhtml";
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
                $('#detailAmountDetail').modal();
                $("#validateDetailAmountDetailForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblAmountDetail;
                $("#validateDetailAmountDetailForm #id2").val(objInfo.id!=null?objInfo.id:'');
                $("#validateDetailAmountDetailForm #accountId2").val(objInfo.accountId!=null?objInfo.accountId:'');
                $("#validateDetailAmountDetailForm #unversityName2").val(objInfo.unversityName!=null?objInfo.unversityName:'');
                $("#validateDetailAmountDetailForm #unversityId2").val(objInfo.unversityId!=null?objInfo.unversityId:'');
                $("#validateDetailAmountDetailForm #earningMonth2").val(objInfo.earningMonth!=null?objInfo.earningMonth:'');
                $("#validateDetailAmountDetailForm #areaId2").val(objInfo.areaId!=null?objInfo.areaId:'');
                $("#validateDetailAmountDetailForm #areaName2").val(objInfo.areaName!=null?objInfo.areaName:'');
                $("#validateDetailAmountDetailForm #isFreeze2").val(objInfo.isFreeze!=null?objInfo.isFreeze:'');
                $("#validateDetailAmountDetailForm #earningType2").val(objInfo.earningType!=null?objInfo.earningType:'');
                $("#validateDetailAmountDetailForm #earningsMoney2").val(objInfo.earningsMoney!=null?objInfo.earningsMoney:'');
                $("#validateDetailAmountDetailForm #createTime2").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateDetailAmountDetailForm #createUser2").val(objInfo.createUser!=null?objInfo.createUser:'');
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
function delAmountDetail(id_key){
    layer.confirm('是否删除？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        var url=webUrl+"/amountDetail/del.dhtml";
        var params={};
        var currentPage= $("#queryAmountDetailcurrentPage").val();
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
                    searchAmountDetail(currentPage);
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



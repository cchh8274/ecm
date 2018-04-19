$(function(){
    searchMachineGatherInfo('');
    $('#queryMachineGatherInfopageSize').on('change',function () {
        var currentPage = $("#queryMachineGatherInfocurrentPage").val();
        searchMachineGatherInfo(currentPage);
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
    $('#updateMachineGatherInfo').on('shown.bs.modal', function () {
        $('#validateUpdateMachineGatherInfoForm').bootstrapValidator('resetForm', false);
    });

    //增加用户咖啡机表校验
    $('#validateAddMachineGatherInfoForm').bootstrapValidator({
        fields : {
            id1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            openid1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            wxUserName1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            areaId1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            areId1 : {
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
            price1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            number1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            payTime1 : {
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
            updateUser1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         addMachineGatherInfo();
     });

    //修改用户咖啡机表校验
    $('#validateUpdateMachineGatherInfoForm').bootstrapValidator({
        fields : {
            id3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            openid3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            wxUserName3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            areaId3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            areId3 : {
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
            price3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            number3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            payTime3 : {
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
            updateUser3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         updateMachineGatherInfo();
     });
    //查询用户咖啡机表校验
    $('#queryMachineGatherInfoForm').bootstrapValidator({
        fields : {
            id : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            openid : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            wxUserName : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            areaId : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            areId : {
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
            price : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            number : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            payTime : {
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
            updateUser : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         console.log("查询校验通过");
     });

});

function searchMachineGatherInfo(currentPage,queryType,fileName,exportParam){
    //没有bootstrapvalidator，则返回
    if($('#queryMachineGatherInfoForm').data('bootstrapValidator')!=null) {
        //对查询框进行校验
        $('#queryMachineGatherInfoForm').data('bootstrapValidator').validate();
        //校验没有通过，则返回
        if(!$('#queryMachineGatherInfoForm').data('bootstrapValidator').isValid()){
            return;
        }
        //----个性化校验示例开始
        //if($('#query"+cleanentityClassName+"Form #被验证组件name').val()=='#'){
        //    layer.alert('XX禁止查询')
        //    //第三个参数为，显示的错误信息所属的validator规则
        //    $('#queryMachineGatherInfoForm').data('bootstrapValidator').updateStatus('被验证组件name','INVALID','stringLength');
        //    return;
        //}
        //----个性化校验示例结束
    }
    var params ={};
    if(currentPage == "undefined" || currentPage =="" || currentPage == null){
        var currentPage_text = $("#queryMachineGatherInfocurrentPage").val();
        if(currentPage_text =="undefined" || currentPage_text =="" || currentPage_text == null){
            currentPage_text = "1";
        }
        params.startIndex = currentPage_text;
    }else{
        params.startIndex = currentPage;
    }

    var pageSize= $("#queryMachineGatherInfopageSize").val();
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

    params.id = $("#queryMachineGatherInfoForm #id").val();
    params.openid = $("#queryMachineGatherInfoForm #openid").val();
    params.wxUserName = $("#queryMachineGatherInfoForm #wxUserName").val();
    params.areaId = $("#queryMachineGatherInfoForm #areaId").val();
    params.areId = $("#queryMachineGatherInfoForm #areId").val();
    params.unversityName = $("#queryMachineGatherInfoForm #unversityName").val();
    params.unversityId = $("#queryMachineGatherInfoForm #unversityId").val();
    params.price = $("#queryMachineGatherInfoForm #price").val();
    params.number = $("#queryMachineGatherInfoForm #number").val();
    params.payTime = $("#queryMachineGatherInfoForm #payTime").val();
    params.createTime = $("#queryMachineGatherInfoForm #createTime").val();
    params.createUser = $("#queryMachineGatherInfoForm #createUser").val();
    params.updateTime = $("#queryMachineGatherInfoForm #updateTime").val();
    params.updateUser = $("#queryMachineGatherInfoForm #updateUser").val();

    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    jsonStr = encodeURIComponent(jsonStr);
    if(queryType!=undefined && queryType =='download'){
        window.location.href=webUrl+"/machineGatherInfo/search.dhtml?jsonStr="+jsonStr+"&v="+Math.random();
        return;
    }
    
    $.ajax({
        type:"POST",
        url:webUrl+"/machineGatherInfo/search.dhtml",
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $("#machineGatherInfoTR_FIRST").siblings().remove();
                var  resultList=data.rows[0].pageRecords;

                //分页
                $("#queryMachineGatherInfocurrentPage").val(data.rows[0].startIndex);
                $("#queryMachineGatherInfototalPage").val(data.rows[0].totalPage);
                $("#queryMachineGatherInfopageSize").val(data.rows[0].pageSize);
                for(var i=0;i<resultList.length;i++){
                    var machineGatherInfoTr = $("<tr class=\"machineGatherInfoTr\"></tr>");
                    $("#machineGatherInfoTR_FIRST").parent().append(machineGatherInfoTr);
                    machineGatherInfoTr.append("<td><input style=\"width:23px;\" type=\"checkbox\"/></td><td>"+(i+1)+"</td>")
                    .append("<td>"+resultList[i].id+"</td>")
                    .append("<td>"+resultList[i].openid+"</td>")
                    .append("<td>"+resultList[i].wxUserName+"</td>")
                    .append("<td>"+resultList[i].areaId+"</td>")
                    .append("<td>"+resultList[i].areId+"</td>")
                    .append("<td>"+resultList[i].unversityName+"</td>")
                    .append("<td>"+resultList[i].unversityId+"</td>")
                    .append("<td>"+resultList[i].price+"</td>")
                    .append("<td>"+resultList[i].number+"</td>")
                    .append("<td>"+resultList[i].payTime+"</td>")
                    .append("<td>"+resultList[i].createTime+"</td>")
                    .append("<td>"+resultList[i].createUser+"</td>")
                    .append("<td>"+resultList[i].updateTime+"</td>")
                    .append("<td>"+resultList[i].updateUser+"</td>")
                    .append("<td class=\"operateTbl\"><button class=\"btn btn-default btn-sm\" onclick=\"return editMachineGatherInfo('"+resultList[i].id+"');\"><i class=\"fa fa-edit\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return  delMachineGatherInfo('"+resultList[i].id+"');\"><i class=\"fa fa-trash-o\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return queryMachineGatherInfoObject('"+resultList[i].id+"');\"><i class=\"fa fa-search\"></i></button></td>");
                }
                var currentPage = Number($("#queryMachineGatherInfocurrentPage").val());
                var totalPage   = Number($("#queryMachineGatherInfototalPage").val());
                var pageSize    = Number($("#queryMachineGatherInfopageSize").val());
                $("#queryMachineGatherInfo_fy .pager").ucPager({
                    currentPage : currentPage,
                    totalPage : totalPage,
                    pageSize : pageSize,
                    clickCallback: queryMachineGatherInfogopage
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

function queryMachineGatherInfogopage(currentPage) {
    searchMachineGatherInfo(currentPage);
}

function addMachineGatherInfo(){
    var url=webUrl+"/machineGatherInfo/insert.dhtml";
    var params={};
    params.id = $("#validateAddMachineGatherInfoForm #id1").val();
    params.openid = $("#validateAddMachineGatherInfoForm #openid1").val();
    params.wxUserName = $("#validateAddMachineGatherInfoForm #wxUserName1").val();
    params.areaId = $("#validateAddMachineGatherInfoForm #areaId1").val();
    params.areId = $("#validateAddMachineGatherInfoForm #areId1").val();
    params.unversityName = $("#validateAddMachineGatherInfoForm #unversityName1").val();
    params.unversityId = $("#validateAddMachineGatherInfoForm #unversityId1").val();
    params.price = $("#validateAddMachineGatherInfoForm #price1").val();
    params.number = $("#validateAddMachineGatherInfoForm #number1").val();
    params.payTime = $("#validateAddMachineGatherInfoForm #payTime1").val();
    params.createTime = $("#validateAddMachineGatherInfoForm #createTime1").val();
    params.createUser = $("#validateAddMachineGatherInfoForm #createUser1").val();
    params.updateTime = $("#validateAddMachineGatherInfoForm #updateTime1").val();
    params.updateUser = $("#validateAddMachineGatherInfoForm #updateUser1").val();
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
                $('#addMachineGatherInfo').modal('hide');
                searchMachineGatherInfo('');
                layer.msg('添加成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateAddMachineGatherInfoForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateAddMachineGatherInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
                $('#validateAddMachineGatherInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateAddMachineGatherInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function updateMachineGatherInfo(){
    var url=webUrl+"/machineGatherInfo/edit.dhtml";
    var params={};
    params.id_key = $("#validateUpdateMachineGatherInfoForm #id_key").val();
    params.id = $("#validateUpdateMachineGatherInfoForm #id3").val();
    params.openid = $("#validateUpdateMachineGatherInfoForm #openid3").val();
    params.wxUserName = $("#validateUpdateMachineGatherInfoForm #wxUserName3").val();
    params.areaId = $("#validateUpdateMachineGatherInfoForm #areaId3").val();
    params.areId = $("#validateUpdateMachineGatherInfoForm #areId3").val();
    params.unversityName = $("#validateUpdateMachineGatherInfoForm #unversityName3").val();
    params.unversityId = $("#validateUpdateMachineGatherInfoForm #unversityId3").val();
    params.price = $("#validateUpdateMachineGatherInfoForm #price3").val();
    params.number = $("#validateUpdateMachineGatherInfoForm #number3").val();
    params.payTime = $("#validateUpdateMachineGatherInfoForm #payTime3").val();
    params.createTime = $("#validateUpdateMachineGatherInfoForm #createTime3").val();
    params.createUser = $("#validateUpdateMachineGatherInfoForm #createUser3").val();
    params.updateTime = $("#validateUpdateMachineGatherInfoForm #updateTime3").val();
    params.updateUser = $("#validateUpdateMachineGatherInfoForm #updateUser3").val();
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
                $('#updateMachineGatherInfo').modal('hide');
                searchMachineGatherInfo('');
                layer.msg('修改成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateUpdateMachineGatherInfoForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateUpdateMachineGatherInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
            $('#validateUpdateMachineGatherInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateUpdateMachineGatherInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function editMachineGatherInfo(id_key){
    var url=webUrl+"/machineGatherInfo/queryObject.dhtml";
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
                $('#updateMachineGatherInfo').modal();
                $("#validateUpdateMachineGatherInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblMachineGatherInfo;
                $("#validateUpdateMachineGatherInfoForm #id3").val(objInfo.id!=null?objInfo.id:'');
                $("#validateUpdateMachineGatherInfoForm #openid3").val(objInfo.openid!=null?objInfo.openid:'');
                $("#validateUpdateMachineGatherInfoForm #wxUserName3").val(objInfo.wxUserName!=null?objInfo.wxUserName:'');
                $("#validateUpdateMachineGatherInfoForm #areaId3").val(objInfo.areaId!=null?objInfo.areaId:'');
                $("#validateUpdateMachineGatherInfoForm #areId3").val(objInfo.areId!=null?objInfo.areId:'');
                $("#validateUpdateMachineGatherInfoForm #unversityName3").val(objInfo.unversityName!=null?objInfo.unversityName:'');
                $("#validateUpdateMachineGatherInfoForm #unversityId3").val(objInfo.unversityId!=null?objInfo.unversityId:'');
                $("#validateUpdateMachineGatherInfoForm #price3").val(objInfo.price!=null?objInfo.price:'');
                $("#validateUpdateMachineGatherInfoForm #number3").val(objInfo.number!=null?objInfo.number:'');
                $("#validateUpdateMachineGatherInfoForm #payTime3").val(objInfo.payTime!=null?objInfo.payTime:'');
                $("#validateUpdateMachineGatherInfoForm #createTime3").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateUpdateMachineGatherInfoForm #createUser3").val(objInfo.createUser!=null?objInfo.createUser:'');
                $("#validateUpdateMachineGatherInfoForm #updateTime3").val(objInfo.updateTime!=null?objInfo.updateTime:'');
                $("#validateUpdateMachineGatherInfoForm #updateUser3").val(objInfo.updateUser!=null?objInfo.updateUser:'');
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

function queryMachineGatherInfoObject(id_key){
    var url=webUrl+"/machineGatherInfo/queryObject.dhtml";
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
                $('#detailMachineGatherInfo').modal();
                $("#validateDetailMachineGatherInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblMachineGatherInfo;
                $("#validateDetailMachineGatherInfoForm #id2").val(objInfo.id!=null?objInfo.id:'');
                $("#validateDetailMachineGatherInfoForm #openid2").val(objInfo.openid!=null?objInfo.openid:'');
                $("#validateDetailMachineGatherInfoForm #wxUserName2").val(objInfo.wxUserName!=null?objInfo.wxUserName:'');
                $("#validateDetailMachineGatherInfoForm #areaId2").val(objInfo.areaId!=null?objInfo.areaId:'');
                $("#validateDetailMachineGatherInfoForm #areId2").val(objInfo.areId!=null?objInfo.areId:'');
                $("#validateDetailMachineGatherInfoForm #unversityName2").val(objInfo.unversityName!=null?objInfo.unversityName:'');
                $("#validateDetailMachineGatherInfoForm #unversityId2").val(objInfo.unversityId!=null?objInfo.unversityId:'');
                $("#validateDetailMachineGatherInfoForm #price2").val(objInfo.price!=null?objInfo.price:'');
                $("#validateDetailMachineGatherInfoForm #number2").val(objInfo.number!=null?objInfo.number:'');
                $("#validateDetailMachineGatherInfoForm #payTime2").val(objInfo.payTime!=null?objInfo.payTime:'');
                $("#validateDetailMachineGatherInfoForm #createTime2").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateDetailMachineGatherInfoForm #createUser2").val(objInfo.createUser!=null?objInfo.createUser:'');
                $("#validateDetailMachineGatherInfoForm #updateTime2").val(objInfo.updateTime!=null?objInfo.updateTime:'');
                $("#validateDetailMachineGatherInfoForm #updateUser2").val(objInfo.updateUser!=null?objInfo.updateUser:'');
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
function delMachineGatherInfo(id_key){
    layer.confirm('是否删除？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        var url=webUrl+"/machineGatherInfo/del.dhtml";
        var params={};
        var currentPage= $("#queryMachineGatherInfocurrentPage").val();
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
                    searchMachineGatherInfo(currentPage);
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



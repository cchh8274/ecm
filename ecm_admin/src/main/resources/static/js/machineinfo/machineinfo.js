$(function(){
    searchMachineInfo('');
    $('#queryMachineInfopageSize').on('change',function () {
        var currentPage = $("#queryMachineInfocurrentPage").val();
        searchMachineInfo(currentPage);
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
    $('#updateMachineInfo').on('shown.bs.modal', function () {
        $('#validateUpdateMachineInfoForm').bootstrapValidator('resetForm', false);
    });

    //增加机器信息表校验
    $('#validateAddMachineInfoForm').bootstrapValidator({
        fields : {
            id1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            machineName1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            adress1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            isUse1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            price1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            totalPlaces1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            leftPlace1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            outSalePlace1 : {
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
         addMachineInfo();
     });

    //修改机器信息表校验
    $('#validateUpdateMachineInfoForm').bootstrapValidator({
        fields : {
            id3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            machineName3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            adress3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            isUse3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            price3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            totalPlaces3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            leftPlace3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            outSalePlace3 : {
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
         updateMachineInfo();
     });
    //查询机器信息表校验
    $('#queryMachineInfoForm').bootstrapValidator({
        fields : {
            id : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            machineName : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            adress : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            isUse : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            price : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            totalPlaces : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            leftPlace : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            outSalePlace : {
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

function searchMachineInfo(currentPage,queryType,fileName,exportParam){
    //没有bootstrapvalidator，则返回
    if($('#queryMachineInfoForm').data('bootstrapValidator')!=null) {
        //对查询框进行校验
        $('#queryMachineInfoForm').data('bootstrapValidator').validate();
        //校验没有通过，则返回
        if(!$('#queryMachineInfoForm').data('bootstrapValidator').isValid()){
            return;
        }
        //----个性化校验示例开始
        //if($('#query"+cleanentityClassName+"Form #被验证组件name').val()=='#'){
        //    layer.alert('XX禁止查询')
        //    //第三个参数为，显示的错误信息所属的validator规则
        //    $('#queryMachineInfoForm').data('bootstrapValidator').updateStatus('被验证组件name','INVALID','stringLength');
        //    return;
        //}
        //----个性化校验示例结束
    }
    var params ={};
    if(currentPage == "undefined" || currentPage =="" || currentPage == null){
        var currentPage_text = $("#queryMachineInfocurrentPage").val();
        if(currentPage_text =="undefined" || currentPage_text =="" || currentPage_text == null){
            currentPage_text = "1";
        }
        params.startIndex = currentPage_text;
    }else{
        params.startIndex = currentPage;
    }

    var pageSize= $("#queryMachineInfopageSize").val();
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

    params.id = $("#queryMachineInfoForm #id").val();
    params.machineName = $("#queryMachineInfoForm #machineName").val();
    params.adress = $("#queryMachineInfoForm #adress").val();
    params.isUse = $("#queryMachineInfoForm #isUse").val();
    params.price = $("#queryMachineInfoForm #price").val();
    params.totalPlaces = $("#queryMachineInfoForm #totalPlaces").val();
    params.leftPlace = $("#queryMachineInfoForm #leftPlace").val();
    params.outSalePlace = $("#queryMachineInfoForm #outSalePlace").val();
    params.createTime = $("#queryMachineInfoForm #createTime").val();
    params.createUser = $("#queryMachineInfoForm #createUser").val();
    params.updateTime = $("#queryMachineInfoForm #updateTime").val();
    params.updateUser = $("#queryMachineInfoForm #updateUser").val();

    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    jsonStr = encodeURIComponent(jsonStr);
    if(queryType!=undefined && queryType =='download'){
        window.location.href=webUrl+"/machineInfo/search.dhtml?jsonStr="+jsonStr+"&v="+Math.random();
        return;
    }
    
    $.ajax({
        type:"POST",
        url:webUrl+"/machineInfo/search.dhtml",
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $("#machineInfoTR_FIRST").siblings().remove();
                var  resultList=data.rows[0].pageRecords;

                //分页
                $("#queryMachineInfocurrentPage").val(data.rows[0].startIndex);
                $("#queryMachineInfototalPage").val(data.rows[0].totalPage);
                $("#queryMachineInfopageSize").val(data.rows[0].pageSize);
                for(var i=0;i<resultList.length;i++){
                    var machineInfoTr = $("<tr class=\"machineInfoTr\"></tr>");
                    $("#machineInfoTR_FIRST").parent().append(machineInfoTr);
                    machineInfoTr.append("<td><input style=\"width:23px;\" type=\"checkbox\"/></td><td>"+(i+1)+"</td>")
                    .append("<td>"+resultList[i].id+"</td>")
                    .append("<td>"+resultList[i].machineName+"</td>")
                    .append("<td>"+resultList[i].adress+"</td>")
                    .append("<td>"+resultList[i].isUse+"</td>")
                    .append("<td>"+resultList[i].price+"</td>")
                    .append("<td>"+resultList[i].totalPlaces+"</td>")
                    .append("<td>"+resultList[i].leftPlace+"</td>")
                    .append("<td>"+resultList[i].outSalePlace+"</td>")
                    .append("<td>"+resultList[i].createTime+"</td>")
                    .append("<td>"+resultList[i].createUser+"</td>")
                    .append("<td>"+resultList[i].updateTime+"</td>")
                    .append("<td>"+resultList[i].updateUser+"</td>")
                    .append("<td class=\"operateTbl\"><button class=\"btn btn-default btn-sm\" onclick=\"return editMachineInfo('"+ resultList[i].id+"," +  resultList[i].machineName+"');\"><i class=\"fa fa-edit\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return  delMachineInfo('"+ resultList[i].id+"," +  resultList[i].machineName+"');\"><i class=\"fa fa-trash-o\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return queryMachineInfoObject('"+ resultList[i].id+"," +  resultList[i].machineName+"');\"><i class=\"fa fa-search\"></i></button></td>");
                }
                var currentPage = Number($("#queryMachineInfocurrentPage").val());
                var totalPage   = Number($("#queryMachineInfototalPage").val());
                var pageSize    = Number($("#queryMachineInfopageSize").val());
                $("#queryMachineInfo_fy .pager").ucPager({
                    currentPage : currentPage,
                    totalPage : totalPage,
                    pageSize : pageSize,
                    clickCallback: queryMachineInfogopage
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

function queryMachineInfogopage(currentPage) {
    searchMachineInfo(currentPage);
}

function addMachineInfo(){
    var url=webUrl+"/machineInfo/insert.dhtml";
    var params={};
    params.id = $("#validateAddMachineInfoForm #id1").val();
    params.machineName = $("#validateAddMachineInfoForm #machineName1").val();
    params.adress = $("#validateAddMachineInfoForm #adress1").val();
    params.isUse = $("#validateAddMachineInfoForm #isUse1").val();
    params.price = $("#validateAddMachineInfoForm #price1").val();
    params.totalPlaces = $("#validateAddMachineInfoForm #totalPlaces1").val();
    params.leftPlace = $("#validateAddMachineInfoForm #leftPlace1").val();
    params.outSalePlace = $("#validateAddMachineInfoForm #outSalePlace1").val();
    params.createTime = $("#validateAddMachineInfoForm #createTime1").val();
    params.createUser = $("#validateAddMachineInfoForm #createUser1").val();
    params.updateTime = $("#validateAddMachineInfoForm #updateTime1").val();
    params.updateUser = $("#validateAddMachineInfoForm #updateUser1").val();
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
                $('#addMachineInfo').modal('hide');
                searchMachineInfo('');
                layer.msg('添加成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateAddMachineInfoForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateAddMachineInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
                $('#validateAddMachineInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateAddMachineInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function updateMachineInfo(){
    var url=webUrl+"/machineInfo/edit.dhtml";
    var params={};
    params.id_key = $("#validateUpdateMachineInfoForm #id_key").val();
    params.id = $("#validateUpdateMachineInfoForm #id3").val();
    params.machineName = $("#validateUpdateMachineInfoForm #machineName3").val();
    params.adress = $("#validateUpdateMachineInfoForm #adress3").val();
    params.isUse = $("#validateUpdateMachineInfoForm #isUse3").val();
    params.price = $("#validateUpdateMachineInfoForm #price3").val();
    params.totalPlaces = $("#validateUpdateMachineInfoForm #totalPlaces3").val();
    params.leftPlace = $("#validateUpdateMachineInfoForm #leftPlace3").val();
    params.outSalePlace = $("#validateUpdateMachineInfoForm #outSalePlace3").val();
    params.createTime = $("#validateUpdateMachineInfoForm #createTime3").val();
    params.createUser = $("#validateUpdateMachineInfoForm #createUser3").val();
    params.updateTime = $("#validateUpdateMachineInfoForm #updateTime3").val();
    params.updateUser = $("#validateUpdateMachineInfoForm #updateUser3").val();
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
                $('#updateMachineInfo').modal('hide');
                searchMachineInfo('');
                layer.msg('修改成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateUpdateMachineInfoForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateUpdateMachineInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
            $('#validateUpdateMachineInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateUpdateMachineInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function editMachineInfo(id_key){
    var url=webUrl+"/machineInfo/queryObject.dhtml";
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
                $('#updateMachineInfo').modal();
                $("#validateUpdateMachineInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblMachineInfo;
                $("#validateUpdateMachineInfoForm #id3").val(objInfo.id!=null?objInfo.id:'');
                $("#validateUpdateMachineInfoForm #machineName3").val(objInfo.machineName!=null?objInfo.machineName:'');
                $("#validateUpdateMachineInfoForm #adress3").val(objInfo.adress!=null?objInfo.adress:'');
                $("#validateUpdateMachineInfoForm #isUse3").val(objInfo.isUse!=null?objInfo.isUse:'');
                $("#validateUpdateMachineInfoForm #price3").val(objInfo.price!=null?objInfo.price:'');
                $("#validateUpdateMachineInfoForm #totalPlaces3").val(objInfo.totalPlaces!=null?objInfo.totalPlaces:'');
                $("#validateUpdateMachineInfoForm #leftPlace3").val(objInfo.leftPlace!=null?objInfo.leftPlace:'');
                $("#validateUpdateMachineInfoForm #outSalePlace3").val(objInfo.outSalePlace!=null?objInfo.outSalePlace:'');
                $("#validateUpdateMachineInfoForm #createTime3").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateUpdateMachineInfoForm #createUser3").val(objInfo.createUser!=null?objInfo.createUser:'');
                $("#validateUpdateMachineInfoForm #updateTime3").val(objInfo.updateTime!=null?objInfo.updateTime:'');
                $("#validateUpdateMachineInfoForm #updateUser3").val(objInfo.updateUser!=null?objInfo.updateUser:'');
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

function queryMachineInfoObject(id_key){
    var url=webUrl+"/machineInfo/queryObject.dhtml";
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
                $('#detailMachineInfo').modal();
                $("#validateDetailMachineInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblMachineInfo;
                $("#validateDetailMachineInfoForm #id2").val(objInfo.id!=null?objInfo.id:'');
                $("#validateDetailMachineInfoForm #machineName2").val(objInfo.machineName!=null?objInfo.machineName:'');
                $("#validateDetailMachineInfoForm #adress2").val(objInfo.adress!=null?objInfo.adress:'');
                $("#validateDetailMachineInfoForm #isUse2").val(objInfo.isUse!=null?objInfo.isUse:'');
                $("#validateDetailMachineInfoForm #price2").val(objInfo.price!=null?objInfo.price:'');
                $("#validateDetailMachineInfoForm #totalPlaces2").val(objInfo.totalPlaces!=null?objInfo.totalPlaces:'');
                $("#validateDetailMachineInfoForm #leftPlace2").val(objInfo.leftPlace!=null?objInfo.leftPlace:'');
                $("#validateDetailMachineInfoForm #outSalePlace2").val(objInfo.outSalePlace!=null?objInfo.outSalePlace:'');
                $("#validateDetailMachineInfoForm #createTime2").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateDetailMachineInfoForm #createUser2").val(objInfo.createUser!=null?objInfo.createUser:'');
                $("#validateDetailMachineInfoForm #updateTime2").val(objInfo.updateTime!=null?objInfo.updateTime:'');
                $("#validateDetailMachineInfoForm #updateUser2").val(objInfo.updateUser!=null?objInfo.updateUser:'');
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
function delMachineInfo(id_key){
    layer.confirm('是否删除？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        var url=webUrl+"/machineInfo/del.dhtml";
        var params={};
        var currentPage= $("#queryMachineInfocurrentPage").val();
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
                    searchMachineInfo(currentPage);
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



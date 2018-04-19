$(function(){
    searchReflectInfo('');
    $('#queryReflectInfopageSize').on('change',function () {
        var currentPage = $("#queryReflectInfocurrentPage").val();
        searchReflectInfo(currentPage);
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
    $('#updateReflectInfo').on('shown.bs.modal', function () {
        $('#validateUpdateReflectInfoForm').bootstrapValidator('resetForm', false);
    });

    //增加体现记录表校验
    $('#validateAddReflectInfoForm').bootstrapValidator({
        fields : {
            id1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            transNo1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            openid1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            wxUser1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            reflectUser1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            bankCard1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            bankName1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            reflectMoney1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            isAccount1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            isFreeze1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            accountTime1 : {
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
         addReflectInfo();
     });

    //修改体现记录表校验
    $('#validateUpdateReflectInfoForm').bootstrapValidator({
        fields : {
            id3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            transNo3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            openid3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            wxUser3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            reflectUser3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            bankCard3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            bankName3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            reflectMoney3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            isAccount3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            isFreeze3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            accountTime3 : {
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
         updateReflectInfo();
     });
    //查询体现记录表校验
    $('#queryReflectInfoForm').bootstrapValidator({
        fields : {
            id : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            transNo : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            openid : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            wxUser : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            reflectUser : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            bankCard : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            bankName : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            reflectMoney : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            isAccount : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            isFreeze : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            accountTime : {
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

function searchReflectInfo(currentPage,queryType,fileName,exportParam){
    //没有bootstrapvalidator，则返回
    if($('#queryReflectInfoForm').data('bootstrapValidator')!=null) {
        //对查询框进行校验
        $('#queryReflectInfoForm').data('bootstrapValidator').validate();
        //校验没有通过，则返回
        if(!$('#queryReflectInfoForm').data('bootstrapValidator').isValid()){
            return;
        }
        //----个性化校验示例开始
        //if($('#query"+cleanentityClassName+"Form #被验证组件name').val()=='#'){
        //    layer.alert('XX禁止查询')
        //    //第三个参数为，显示的错误信息所属的validator规则
        //    $('#queryReflectInfoForm').data('bootstrapValidator').updateStatus('被验证组件name','INVALID','stringLength');
        //    return;
        //}
        //----个性化校验示例结束
    }
    var params ={};
    if(currentPage == "undefined" || currentPage =="" || currentPage == null){
        var currentPage_text = $("#queryReflectInfocurrentPage").val();
        if(currentPage_text =="undefined" || currentPage_text =="" || currentPage_text == null){
            currentPage_text = "1";
        }
        params.startIndex = currentPage_text;
    }else{
        params.startIndex = currentPage;
    }

    var pageSize= $("#queryReflectInfopageSize").val();
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

    params.id = $("#queryReflectInfoForm #id").val();
    params.transNo = $("#queryReflectInfoForm #transNo").val();
    params.openid = $("#queryReflectInfoForm #openid").val();
    params.wxUser = $("#queryReflectInfoForm #wxUser").val();
    params.reflectUser = $("#queryReflectInfoForm #reflectUser").val();
    params.bankCard = $("#queryReflectInfoForm #bankCard").val();
    params.bankName = $("#queryReflectInfoForm #bankName").val();
    params.reflectMoney = $("#queryReflectInfoForm #reflectMoney").val();
    params.isAccount = $("#queryReflectInfoForm #isAccount").val();
    params.isFreeze = $("#queryReflectInfoForm #isFreeze").val();
    params.accountTime = $("#queryReflectInfoForm #accountTime").val();
    params.createTime = $("#queryReflectInfoForm #createTime").val();
    params.createUser = $("#queryReflectInfoForm #createUser").val();

    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    jsonStr = encodeURIComponent(jsonStr);
    if(queryType!=undefined && queryType =='download'){
        window.location.href=webUrl+"/reflectInfo/search.dhtml?jsonStr="+jsonStr+"&v="+Math.random();
        return;
    }
    
    $.ajax({
        type:"POST",
        url:webUrl+"/reflectInfo/search.dhtml",
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $("#reflectInfoTR_FIRST").siblings().remove();
                var  resultList=data.rows[0].pageRecords;

                //分页
                $("#queryReflectInfocurrentPage").val(data.rows[0].startIndex);
                $("#queryReflectInfototalPage").val(data.rows[0].totalPage);
                $("#queryReflectInfopageSize").val(data.rows[0].pageSize);
                for(var i=0;i<resultList.length;i++){
                    var reflectInfoTr = $("<tr class=\"reflectInfoTr\"></tr>");
                    $("#reflectInfoTR_FIRST").parent().append(reflectInfoTr);
                    reflectInfoTr.append("<td><input style=\"width:23px;\" type=\"checkbox\"/></td><td>"+(i+1)+"</td>")
                    .append("<td>"+resultList[i].id+"</td>")
                    .append("<td>"+resultList[i].transNo+"</td>")
                    .append("<td>"+resultList[i].openid+"</td>")
                    .append("<td>"+resultList[i].wxUser+"</td>")
                    .append("<td>"+resultList[i].reflectUser+"</td>")
                    .append("<td>"+resultList[i].bankCard+"</td>")
                    .append("<td>"+resultList[i].bankName+"</td>")
                    .append("<td>"+resultList[i].reflectMoney+"</td>")
                    .append("<td>"+resultList[i].isAccount+"</td>")
                    .append("<td>"+resultList[i].isFreeze+"</td>")
                    .append("<td>"+resultList[i].accountTime+"</td>")
                    .append("<td>"+resultList[i].createTime+"</td>")
                    .append("<td>"+resultList[i].createUser+"</td>")
                    .append("<td class=\"operateTbl\"><button class=\"btn btn-default btn-sm\" onclick=\"return editReflectInfo('"+resultList[i].id+"');\"><i class=\"fa fa-edit\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return  delReflectInfo('"+resultList[i].id+"');\"><i class=\"fa fa-trash-o\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return queryReflectInfoObject('"+resultList[i].id+"');\"><i class=\"fa fa-search\"></i></button></td>");
                }
                var currentPage = Number($("#queryReflectInfocurrentPage").val());
                var totalPage   = Number($("#queryReflectInfototalPage").val());
                var pageSize    = Number($("#queryReflectInfopageSize").val());
                $("#queryReflectInfo_fy .pager").ucPager({
                    currentPage : currentPage,
                    totalPage : totalPage,
                    pageSize : pageSize,
                    clickCallback: queryReflectInfogopage
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

function queryReflectInfogopage(currentPage) {
    searchReflectInfo(currentPage);
}

function addReflectInfo(){
    var url=webUrl+"/reflectInfo/insert.dhtml";
    var params={};
    params.id = $("#validateAddReflectInfoForm #id1").val();
    params.transNo = $("#validateAddReflectInfoForm #transNo1").val();
    params.openid = $("#validateAddReflectInfoForm #openid1").val();
    params.wxUser = $("#validateAddReflectInfoForm #wxUser1").val();
    params.reflectUser = $("#validateAddReflectInfoForm #reflectUser1").val();
    params.bankCard = $("#validateAddReflectInfoForm #bankCard1").val();
    params.bankName = $("#validateAddReflectInfoForm #bankName1").val();
    params.reflectMoney = $("#validateAddReflectInfoForm #reflectMoney1").val();
    params.isAccount = $("#validateAddReflectInfoForm #isAccount1").val();
    params.isFreeze = $("#validateAddReflectInfoForm #isFreeze1").val();
    params.accountTime = $("#validateAddReflectInfoForm #accountTime1").val();
    params.createTime = $("#validateAddReflectInfoForm #createTime1").val();
    params.createUser = $("#validateAddReflectInfoForm #createUser1").val();
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
                $('#addReflectInfo').modal('hide');
                searchReflectInfo('');
                layer.msg('添加成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateAddReflectInfoForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateAddReflectInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
                $('#validateAddReflectInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateAddReflectInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function updateReflectInfo(){
    var url=webUrl+"/reflectInfo/edit.dhtml";
    var params={};
    params.id_key = $("#validateUpdateReflectInfoForm #id_key").val();
    params.id = $("#validateUpdateReflectInfoForm #id3").val();
    params.transNo = $("#validateUpdateReflectInfoForm #transNo3").val();
    params.openid = $("#validateUpdateReflectInfoForm #openid3").val();
    params.wxUser = $("#validateUpdateReflectInfoForm #wxUser3").val();
    params.reflectUser = $("#validateUpdateReflectInfoForm #reflectUser3").val();
    params.bankCard = $("#validateUpdateReflectInfoForm #bankCard3").val();
    params.bankName = $("#validateUpdateReflectInfoForm #bankName3").val();
    params.reflectMoney = $("#validateUpdateReflectInfoForm #reflectMoney3").val();
    params.isAccount = $("#validateUpdateReflectInfoForm #isAccount3").val();
    params.isFreeze = $("#validateUpdateReflectInfoForm #isFreeze3").val();
    params.accountTime = $("#validateUpdateReflectInfoForm #accountTime3").val();
    params.createTime = $("#validateUpdateReflectInfoForm #createTime3").val();
    params.createUser = $("#validateUpdateReflectInfoForm #createUser3").val();
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
                $('#updateReflectInfo').modal('hide');
                searchReflectInfo('');
                layer.msg('修改成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateUpdateReflectInfoForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateUpdateReflectInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
            $('#validateUpdateReflectInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateUpdateReflectInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function editReflectInfo(id_key){
    var url=webUrl+"/reflectInfo/queryObject.dhtml";
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
                $('#updateReflectInfo').modal();
                $("#validateUpdateReflectInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblReflectInfo;
                $("#validateUpdateReflectInfoForm #id3").val(objInfo.id!=null?objInfo.id:'');
                $("#validateUpdateReflectInfoForm #transNo3").val(objInfo.transNo!=null?objInfo.transNo:'');
                $("#validateUpdateReflectInfoForm #openid3").val(objInfo.openid!=null?objInfo.openid:'');
                $("#validateUpdateReflectInfoForm #wxUser3").val(objInfo.wxUser!=null?objInfo.wxUser:'');
                $("#validateUpdateReflectInfoForm #reflectUser3").val(objInfo.reflectUser!=null?objInfo.reflectUser:'');
                $("#validateUpdateReflectInfoForm #bankCard3").val(objInfo.bankCard!=null?objInfo.bankCard:'');
                $("#validateUpdateReflectInfoForm #bankName3").val(objInfo.bankName!=null?objInfo.bankName:'');
                $("#validateUpdateReflectInfoForm #reflectMoney3").val(objInfo.reflectMoney!=null?objInfo.reflectMoney:'');
                $("#validateUpdateReflectInfoForm #isAccount3").val(objInfo.isAccount!=null?objInfo.isAccount:'');
                $("#validateUpdateReflectInfoForm #isFreeze3").val(objInfo.isFreeze!=null?objInfo.isFreeze:'');
                $("#validateUpdateReflectInfoForm #accountTime3").val(objInfo.accountTime!=null?objInfo.accountTime:'');
                $("#validateUpdateReflectInfoForm #createTime3").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateUpdateReflectInfoForm #createUser3").val(objInfo.createUser!=null?objInfo.createUser:'');
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

function queryReflectInfoObject(id_key){
    var url=webUrl+"/reflectInfo/queryObject.dhtml";
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
                $('#detailReflectInfo').modal();
                $("#validateDetailReflectInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblReflectInfo;
                $("#validateDetailReflectInfoForm #id2").val(objInfo.id!=null?objInfo.id:'');
                $("#validateDetailReflectInfoForm #transNo2").val(objInfo.transNo!=null?objInfo.transNo:'');
                $("#validateDetailReflectInfoForm #openid2").val(objInfo.openid!=null?objInfo.openid:'');
                $("#validateDetailReflectInfoForm #wxUser2").val(objInfo.wxUser!=null?objInfo.wxUser:'');
                $("#validateDetailReflectInfoForm #reflectUser2").val(objInfo.reflectUser!=null?objInfo.reflectUser:'');
                $("#validateDetailReflectInfoForm #bankCard2").val(objInfo.bankCard!=null?objInfo.bankCard:'');
                $("#validateDetailReflectInfoForm #bankName2").val(objInfo.bankName!=null?objInfo.bankName:'');
                $("#validateDetailReflectInfoForm #reflectMoney2").val(objInfo.reflectMoney!=null?objInfo.reflectMoney:'');
                $("#validateDetailReflectInfoForm #isAccount2").val(objInfo.isAccount!=null?objInfo.isAccount:'');
                $("#validateDetailReflectInfoForm #isFreeze2").val(objInfo.isFreeze!=null?objInfo.isFreeze:'');
                $("#validateDetailReflectInfoForm #accountTime2").val(objInfo.accountTime!=null?objInfo.accountTime:'');
                $("#validateDetailReflectInfoForm #createTime2").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateDetailReflectInfoForm #createUser2").val(objInfo.createUser!=null?objInfo.createUser:'');
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
function delReflectInfo(id_key){
    layer.confirm('是否删除？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        var url=webUrl+"/reflectInfo/del.dhtml";
        var params={};
        var currentPage= $("#queryReflectInfocurrentPage").val();
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
                    searchReflectInfo(currentPage);
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



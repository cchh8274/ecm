$(function(){
    searchWxUserInfo('');
    $('#queryWxUserInfopageSize').on('change',function () {
        var currentPage = $("#queryWxUserInfocurrentPage").val();
        searchWxUserInfo(currentPage);
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
    $('#updateWxUserInfo').on('shown.bs.modal', function () {
        $('#validateUpdateWxUserInfoForm').bootstrapValidator('resetForm', false);
    });

    //增加微信用户表校验
    $('#validateAddWxUserInfoForm').bootstrapValidator({
        fields : {
            id1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            openid1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            nickname1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            sex1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            city1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            country1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            province1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            language1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            headimgurl1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            subscribeTime1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            unionid1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            remark1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            groupid1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            tagidList1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            subscribeScene1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            qrScene1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            qrSceneStr1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            createtTime1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            createUser1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         addWxUserInfo();
     });

    //修改微信用户表校验
    $('#validateUpdateWxUserInfoForm').bootstrapValidator({
        fields : {
            id3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            openid3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            nickname3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            sex3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            city3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            country3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            province3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            language3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            headimgurl3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            subscribeTime3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            unionid3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            remark3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            groupid3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            tagidList3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            subscribeScene3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            qrScene3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            qrSceneStr3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            createtTime3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            createUser3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         updateWxUserInfo();
     });
    //查询微信用户表校验
    $('#queryWxUserInfoForm').bootstrapValidator({
        fields : {
            id : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            openid : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            nickname : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            sex : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            city : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            country : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            province : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            language : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            headimgurl : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            subscribeTime : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            unionid : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            remark : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            groupid : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            tagidList : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            subscribeScene : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            qrScene : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            qrSceneStr : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            createtTime : {
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

function searchWxUserInfo(currentPage,queryType,fileName,exportParam){
    //没有bootstrapvalidator，则返回
    if($('#queryWxUserInfoForm').data('bootstrapValidator')!=null) {
        //对查询框进行校验
        $('#queryWxUserInfoForm').data('bootstrapValidator').validate();
        //校验没有通过，则返回
        if(!$('#queryWxUserInfoForm').data('bootstrapValidator').isValid()){
            return;
        }
        //----个性化校验示例开始
        //if($('#query"+cleanentityClassName+"Form #被验证组件name').val()=='#'){
        //    layer.alert('XX禁止查询')
        //    //第三个参数为，显示的错误信息所属的validator规则
        //    $('#queryWxUserInfoForm').data('bootstrapValidator').updateStatus('被验证组件name','INVALID','stringLength');
        //    return;
        //}
        //----个性化校验示例结束
    }
    var params ={};
    if(currentPage == "undefined" || currentPage =="" || currentPage == null){
        var currentPage_text = $("#queryWxUserInfocurrentPage").val();
        if(currentPage_text =="undefined" || currentPage_text =="" || currentPage_text == null){
            currentPage_text = "1";
        }
        params.startIndex = currentPage_text;
    }else{
        params.startIndex = currentPage;
    }

    var pageSize= $("#queryWxUserInfopageSize").val();
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

    params.id = $("#queryWxUserInfoForm #id").val();
    params.openid = $("#queryWxUserInfoForm #openid").val();
    params.nickname = $("#queryWxUserInfoForm #nickname").val();
    params.sex = $("#queryWxUserInfoForm #sex").val();
    params.city = $("#queryWxUserInfoForm #city").val();
    params.country = $("#queryWxUserInfoForm #country").val();
    params.province = $("#queryWxUserInfoForm #province").val();
    params.language = $("#queryWxUserInfoForm #language").val();
    params.headimgurl = $("#queryWxUserInfoForm #headimgurl").val();
    params.subscribeTime = $("#queryWxUserInfoForm #subscribeTime").val();
    params.unionid = $("#queryWxUserInfoForm #unionid").val();
    params.remark = $("#queryWxUserInfoForm #remark").val();
    params.groupid = $("#queryWxUserInfoForm #groupid").val();
    params.tagidList = $("#queryWxUserInfoForm #tagidList").val();
    params.subscribeScene = $("#queryWxUserInfoForm #subscribeScene").val();
    params.qrScene = $("#queryWxUserInfoForm #qrScene").val();
    params.qrSceneStr = $("#queryWxUserInfoForm #qrSceneStr").val();
    params.createtTime = $("#queryWxUserInfoForm #createtTime").val();
    params.createUser = $("#queryWxUserInfoForm #createUser").val();

    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    jsonStr = encodeURIComponent(jsonStr);
    if(queryType!=undefined && queryType =='download'){
        window.location.href=webUrl+"/wxUserInfo/search.dhtml?jsonStr="+jsonStr+"&v="+Math.random();
        return;
    }
    
    $.ajax({
        type:"POST",
        url:webUrl+"/wxUserInfo/search.dhtml",
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $("#wxUserInfoTR_FIRST").siblings().remove();
                var  resultList=data.rows[0].pageRecords;

                //分页
                $("#queryWxUserInfocurrentPage").val(data.rows[0].startIndex);
                $("#queryWxUserInfototalPage").val(data.rows[0].totalPage);
                $("#queryWxUserInfopageSize").val(data.rows[0].pageSize);
                for(var i=0;i<resultList.length;i++){
                    var wxUserInfoTr = $("<tr class=\"wxUserInfoTr\"></tr>");
                    $("#wxUserInfoTR_FIRST").parent().append(wxUserInfoTr);
                    wxUserInfoTr.append("<td><input style=\"width:23px;\" type=\"checkbox\"/></td><td>"+(i+1)+"</td>")
                    .append("<td>"+resultList[i].id+"</td>")
                    .append("<td>"+resultList[i].openid+"</td>")
                    .append("<td>"+resultList[i].nickname+"</td>")
                    .append("<td>"+resultList[i].sex+"</td>")
                    .append("<td>"+resultList[i].city+"</td>")
                    .append("<td>"+resultList[i].country+"</td>")
                    .append("<td>"+resultList[i].province+"</td>")
                    .append("<td>"+resultList[i].language+"</td>")
                    .append("<td>"+resultList[i].headimgurl+"</td>")
                    .append("<td>"+resultList[i].subscribeTime+"</td>")
                    .append("<td>"+resultList[i].unionid+"</td>")
                    .append("<td>"+resultList[i].remark+"</td>")
                    .append("<td>"+resultList[i].groupid+"</td>")
                    .append("<td>"+resultList[i].tagidList+"</td>")
                    .append("<td>"+resultList[i].subscribeScene+"</td>")
                    .append("<td>"+resultList[i].qrScene+"</td>")
                    .append("<td>"+resultList[i].qrSceneStr+"</td>")
                    .append("<td>"+resultList[i].createtTime+"</td>")
                    .append("<td>"+resultList[i].createUser+"</td>")
                    .append("<td class=\"operateTbl\"><button class=\"btn btn-default btn-sm\" onclick=\"return editWxUserInfo('"+resultList[i].id+"');\"><i class=\"fa fa-edit\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return  delWxUserInfo('"+resultList[i].id+"');\"><i class=\"fa fa-trash-o\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return queryWxUserInfoObject('"+resultList[i].id+"');\"><i class=\"fa fa-search\"></i></button></td>");
                }
                var currentPage = Number($("#queryWxUserInfocurrentPage").val());
                var totalPage   = Number($("#queryWxUserInfototalPage").val());
                var pageSize    = Number($("#queryWxUserInfopageSize").val());
                $("#queryWxUserInfo_fy .pager").ucPager({
                    currentPage : currentPage,
                    totalPage : totalPage,
                    pageSize : pageSize,
                    clickCallback: queryWxUserInfogopage
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

function queryWxUserInfogopage(currentPage) {
    searchWxUserInfo(currentPage);
}

function addWxUserInfo(){
    var url=webUrl+"/wxUserInfo/insert.dhtml";
    var params={};
    params.id = $("#validateAddWxUserInfoForm #id1").val();
    params.openid = $("#validateAddWxUserInfoForm #openid1").val();
    params.nickname = $("#validateAddWxUserInfoForm #nickname1").val();
    params.sex = $("#validateAddWxUserInfoForm #sex1").val();
    params.city = $("#validateAddWxUserInfoForm #city1").val();
    params.country = $("#validateAddWxUserInfoForm #country1").val();
    params.province = $("#validateAddWxUserInfoForm #province1").val();
    params.language = $("#validateAddWxUserInfoForm #language1").val();
    params.headimgurl = $("#validateAddWxUserInfoForm #headimgurl1").val();
    params.subscribeTime = $("#validateAddWxUserInfoForm #subscribeTime1").val();
    params.unionid = $("#validateAddWxUserInfoForm #unionid1").val();
    params.remark = $("#validateAddWxUserInfoForm #remark1").val();
    params.groupid = $("#validateAddWxUserInfoForm #groupid1").val();
    params.tagidList = $("#validateAddWxUserInfoForm #tagidList1").val();
    params.subscribeScene = $("#validateAddWxUserInfoForm #subscribeScene1").val();
    params.qrScene = $("#validateAddWxUserInfoForm #qrScene1").val();
    params.qrSceneStr = $("#validateAddWxUserInfoForm #qrSceneStr1").val();
    params.createtTime = $("#validateAddWxUserInfoForm #createtTime1").val();
    params.createUser = $("#validateAddWxUserInfoForm #createUser1").val();
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
                $('#addWxUserInfo').modal('hide');
                searchWxUserInfo('');
                layer.msg('添加成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateAddWxUserInfoForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateAddWxUserInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
                $('#validateAddWxUserInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateAddWxUserInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function updateWxUserInfo(){
    var url=webUrl+"/wxUserInfo/edit.dhtml";
    var params={};
    params.id_key = $("#validateUpdateWxUserInfoForm #id_key").val();
    params.id = $("#validateUpdateWxUserInfoForm #id3").val();
    params.openid = $("#validateUpdateWxUserInfoForm #openid3").val();
    params.nickname = $("#validateUpdateWxUserInfoForm #nickname3").val();
    params.sex = $("#validateUpdateWxUserInfoForm #sex3").val();
    params.city = $("#validateUpdateWxUserInfoForm #city3").val();
    params.country = $("#validateUpdateWxUserInfoForm #country3").val();
    params.province = $("#validateUpdateWxUserInfoForm #province3").val();
    params.language = $("#validateUpdateWxUserInfoForm #language3").val();
    params.headimgurl = $("#validateUpdateWxUserInfoForm #headimgurl3").val();
    params.subscribeTime = $("#validateUpdateWxUserInfoForm #subscribeTime3").val();
    params.unionid = $("#validateUpdateWxUserInfoForm #unionid3").val();
    params.remark = $("#validateUpdateWxUserInfoForm #remark3").val();
    params.groupid = $("#validateUpdateWxUserInfoForm #groupid3").val();
    params.tagidList = $("#validateUpdateWxUserInfoForm #tagidList3").val();
    params.subscribeScene = $("#validateUpdateWxUserInfoForm #subscribeScene3").val();
    params.qrScene = $("#validateUpdateWxUserInfoForm #qrScene3").val();
    params.qrSceneStr = $("#validateUpdateWxUserInfoForm #qrSceneStr3").val();
    params.createtTime = $("#validateUpdateWxUserInfoForm #createtTime3").val();
    params.createUser = $("#validateUpdateWxUserInfoForm #createUser3").val();
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
                $('#updateWxUserInfo').modal('hide');
                searchWxUserInfo('');
                layer.msg('修改成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateUpdateWxUserInfoForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateUpdateWxUserInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
            $('#validateUpdateWxUserInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateUpdateWxUserInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function editWxUserInfo(id_key){
    var url=webUrl+"/wxUserInfo/queryObject.dhtml";
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
                $('#updateWxUserInfo').modal();
                $("#validateUpdateWxUserInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblWxUserInfo;
                $("#validateUpdateWxUserInfoForm #id3").val(objInfo.id!=null?objInfo.id:'');
                $("#validateUpdateWxUserInfoForm #openid3").val(objInfo.openid!=null?objInfo.openid:'');
                $("#validateUpdateWxUserInfoForm #nickname3").val(objInfo.nickname!=null?objInfo.nickname:'');
                $("#validateUpdateWxUserInfoForm #sex3").val(objInfo.sex!=null?objInfo.sex:'');
                $("#validateUpdateWxUserInfoForm #city3").val(objInfo.city!=null?objInfo.city:'');
                $("#validateUpdateWxUserInfoForm #country3").val(objInfo.country!=null?objInfo.country:'');
                $("#validateUpdateWxUserInfoForm #province3").val(objInfo.province!=null?objInfo.province:'');
                $("#validateUpdateWxUserInfoForm #language3").val(objInfo.language!=null?objInfo.language:'');
                $("#validateUpdateWxUserInfoForm #headimgurl3").val(objInfo.headimgurl!=null?objInfo.headimgurl:'');
                $("#validateUpdateWxUserInfoForm #subscribeTime3").val(objInfo.subscribeTime!=null?objInfo.subscribeTime:'');
                $("#validateUpdateWxUserInfoForm #unionid3").val(objInfo.unionid!=null?objInfo.unionid:'');
                $("#validateUpdateWxUserInfoForm #remark3").val(objInfo.remark!=null?objInfo.remark:'');
                $("#validateUpdateWxUserInfoForm #groupid3").val(objInfo.groupid!=null?objInfo.groupid:'');
                $("#validateUpdateWxUserInfoForm #tagidList3").val(objInfo.tagidList!=null?objInfo.tagidList:'');
                $("#validateUpdateWxUserInfoForm #subscribeScene3").val(objInfo.subscribeScene!=null?objInfo.subscribeScene:'');
                $("#validateUpdateWxUserInfoForm #qrScene3").val(objInfo.qrScene!=null?objInfo.qrScene:'');
                $("#validateUpdateWxUserInfoForm #qrSceneStr3").val(objInfo.qrSceneStr!=null?objInfo.qrSceneStr:'');
                $("#validateUpdateWxUserInfoForm #createtTime3").val(objInfo.createtTime!=null?objInfo.createtTime:'');
                $("#validateUpdateWxUserInfoForm #createUser3").val(objInfo.createUser!=null?objInfo.createUser:'');
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

function queryWxUserInfoObject(id_key){
    var url=webUrl+"/wxUserInfo/queryObject.dhtml";
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
                $('#detailWxUserInfo').modal();
                $("#validateDetailWxUserInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblWxUserInfo;
                $("#validateDetailWxUserInfoForm #id2").val(objInfo.id!=null?objInfo.id:'');
                $("#validateDetailWxUserInfoForm #openid2").val(objInfo.openid!=null?objInfo.openid:'');
                $("#validateDetailWxUserInfoForm #nickname2").val(objInfo.nickname!=null?objInfo.nickname:'');
                $("#validateDetailWxUserInfoForm #sex2").val(objInfo.sex!=null?objInfo.sex:'');
                $("#validateDetailWxUserInfoForm #city2").val(objInfo.city!=null?objInfo.city:'');
                $("#validateDetailWxUserInfoForm #country2").val(objInfo.country!=null?objInfo.country:'');
                $("#validateDetailWxUserInfoForm #province2").val(objInfo.province!=null?objInfo.province:'');
                $("#validateDetailWxUserInfoForm #language2").val(objInfo.language!=null?objInfo.language:'');
                $("#validateDetailWxUserInfoForm #headimgurl2").val(objInfo.headimgurl!=null?objInfo.headimgurl:'');
                $("#validateDetailWxUserInfoForm #subscribeTime2").val(objInfo.subscribeTime!=null?objInfo.subscribeTime:'');
                $("#validateDetailWxUserInfoForm #unionid2").val(objInfo.unionid!=null?objInfo.unionid:'');
                $("#validateDetailWxUserInfoForm #remark2").val(objInfo.remark!=null?objInfo.remark:'');
                $("#validateDetailWxUserInfoForm #groupid2").val(objInfo.groupid!=null?objInfo.groupid:'');
                $("#validateDetailWxUserInfoForm #tagidList2").val(objInfo.tagidList!=null?objInfo.tagidList:'');
                $("#validateDetailWxUserInfoForm #subscribeScene2").val(objInfo.subscribeScene!=null?objInfo.subscribeScene:'');
                $("#validateDetailWxUserInfoForm #qrScene2").val(objInfo.qrScene!=null?objInfo.qrScene:'');
                $("#validateDetailWxUserInfoForm #qrSceneStr2").val(objInfo.qrSceneStr!=null?objInfo.qrSceneStr:'');
                $("#validateDetailWxUserInfoForm #createtTime2").val(objInfo.createtTime!=null?objInfo.createtTime:'');
                $("#validateDetailWxUserInfoForm #createUser2").val(objInfo.createUser!=null?objInfo.createUser:'');
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
function delWxUserInfo(id_key){
    layer.confirm('是否删除？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        var url=webUrl+"/wxUserInfo/del.dhtml";
        var params={};
        var currentPage= $("#queryWxUserInfocurrentPage").val();
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
                    searchWxUserInfo(currentPage);
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



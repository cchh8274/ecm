$(function(){
    searchEarningsInfo('');
    $('#queryEarningsInfopageSize').on('change',function () {
        var currentPage = $("#queryEarningsInfocurrentPage").val();
        searchEarningsInfo(currentPage);
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
    $('#updateEarningsInfo').on('shown.bs.modal', function () {
        $('#validateUpdateEarningsInfoForm').bootstrapValidator('resetForm', false);
    });

    //增加收益表校验
    $('#validateAddEarningsInfoForm').bootstrapValidator({
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
            manicheId1 : {
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
            manicheName1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            price1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            coffeeNumber1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            tolalMoney1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            earingMonth1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            earningStartTime1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            isEaningStatus1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            earningSendTime1 : {
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
         addEarningsInfo();
     });

    //修改收益表校验
    $('#validateUpdateEarningsInfoForm').bootstrapValidator({
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
            manicheId3 : {
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
            manicheName3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            price3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            coffeeNumber3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            tolalMoney3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            earingMonth3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            earningStartTime3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            isEaningStatus3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            earningSendTime3 : {
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
         updateEarningsInfo();
     });
    //查询收益表校验
    $('#queryEarningsInfoForm').bootstrapValidator({
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
            manicheId : {
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
            manicheName : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            price : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            coffeeNumber : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            tolalMoney : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            earingMonth : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            earningStartTime : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            isEaningStatus : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            earningSendTime : {
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

function searchEarningsInfo(currentPage,queryType,fileName,exportParam){
    //没有bootstrapvalidator，则返回
    if($('#queryEarningsInfoForm').data('bootstrapValidator')!=null) {
        //对查询框进行校验
        $('#queryEarningsInfoForm').data('bootstrapValidator').validate();
        //校验没有通过，则返回
        if(!$('#queryEarningsInfoForm').data('bootstrapValidator').isValid()){
            return;
        }
        //----个性化校验示例开始
        //if($('#query"+cleanentityClassName+"Form #被验证组件name').val()=='#'){
        //    layer.alert('XX禁止查询')
        //    //第三个参数为，显示的错误信息所属的validator规则
        //    $('#queryEarningsInfoForm').data('bootstrapValidator').updateStatus('被验证组件name','INVALID','stringLength');
        //    return;
        //}
        //----个性化校验示例结束
    }
    var params ={};
    if(currentPage == "undefined" || currentPage =="" || currentPage == null){
        var currentPage_text = $("#queryEarningsInfocurrentPage").val();
        if(currentPage_text =="undefined" || currentPage_text =="" || currentPage_text == null){
            currentPage_text = "1";
        }
        params.startIndex = currentPage_text;
    }else{
        params.startIndex = currentPage;
    }

    var pageSize= $("#queryEarningsInfopageSize").val();
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

    params.id = $("#queryEarningsInfoForm #id").val();
    params.openid = $("#queryEarningsInfoForm #openid").val();
    params.wxUserName = $("#queryEarningsInfoForm #wxUserName").val();
    params.manicheId = $("#queryEarningsInfoForm #manicheId").val();
    params.unversityName = $("#queryEarningsInfoForm #unversityName").val();
    params.unversityId = $("#queryEarningsInfoForm #unversityId").val();
    params.manicheName = $("#queryEarningsInfoForm #manicheName").val();
    params.price = $("#queryEarningsInfoForm #price").val();
    params.coffeeNumber = $("#queryEarningsInfoForm #coffeeNumber").val();
    params.tolalMoney = $("#queryEarningsInfoForm #tolalMoney").val();
    params.earingMonth = $("#queryEarningsInfoForm #earingMonth").val();
    params.earningStartTime = $("#queryEarningsInfoForm #earningStartTime").val();
    params.isEaningStatus = $("#queryEarningsInfoForm #isEaningStatus").val();
    params.earningSendTime = $("#queryEarningsInfoForm #earningSendTime").val();
    params.createTime = $("#queryEarningsInfoForm #createTime").val();
    params.createUser = $("#queryEarningsInfoForm #createUser").val();
    params.updateTime = $("#queryEarningsInfoForm #updateTime").val();
    params.updateUser = $("#queryEarningsInfoForm #updateUser").val();

    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    jsonStr = encodeURIComponent(jsonStr);
    if(queryType!=undefined && queryType =='download'){
        window.location.href=webUrl+"/earningsInfo/search.dhtml?jsonStr="+jsonStr+"&v="+Math.random();
        return;
    }
    
    $.ajax({
        type:"POST",
        url:webUrl+"/earningsInfo/search.dhtml",
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $("#earningsInfoTR_FIRST").siblings().remove();
                var  resultList=data.rows[0].pageRecords;

                //分页
                $("#queryEarningsInfocurrentPage").val(data.rows[0].startIndex);
                $("#queryEarningsInfototalPage").val(data.rows[0].totalPage);
                $("#queryEarningsInfopageSize").val(data.rows[0].pageSize);
                for(var i=0;i<resultList.length;i++){
                    var earningsInfoTr = $("<tr class=\"earningsInfoTr\"></tr>");
                    $("#earningsInfoTR_FIRST").parent().append(earningsInfoTr);
                    earningsInfoTr.append("<td><input style=\"width:23px;\" type=\"checkbox\"/></td><td>"+(i+1)+"</td>")
                    .append("<td>"+resultList[i].id+"</td>")
                    .append("<td>"+resultList[i].openid+"</td>")
                    .append("<td>"+resultList[i].wxUserName+"</td>")
                    .append("<td>"+resultList[i].manicheId+"</td>")
                    .append("<td>"+resultList[i].unversityName+"</td>")
                    .append("<td>"+resultList[i].unversityId+"</td>")
                    .append("<td>"+resultList[i].manicheName+"</td>")
                    .append("<td>"+resultList[i].price+"</td>")
                    .append("<td>"+resultList[i].coffeeNumber+"</td>")
                    .append("<td>"+resultList[i].tolalMoney+"</td>")
                    .append("<td>"+resultList[i].earingMonth+"</td>")
                    .append("<td>"+resultList[i].earningStartTime+"</td>")
                    .append("<td>"+resultList[i].isEaningStatus+"</td>")
                    .append("<td>"+resultList[i].earningSendTime+"</td>")
                    .append("<td>"+resultList[i].createTime+"</td>")
                    .append("<td>"+resultList[i].createUser+"</td>")
                    .append("<td>"+resultList[i].updateTime+"</td>")
                    .append("<td>"+resultList[i].updateUser+"</td>")
                    .append("<td class=\"operateTbl\"><button class=\"btn btn-default btn-sm\" onclick=\"return editEarningsInfo('"+resultList[i].id+"');\"><i class=\"fa fa-edit\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return  delEarningsInfo('"+resultList[i].id+"');\"><i class=\"fa fa-trash-o\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return queryEarningsInfoObject('"+resultList[i].id+"');\"><i class=\"fa fa-search\"></i></button></td>");
                }
                var currentPage = Number($("#queryEarningsInfocurrentPage").val());
                var totalPage   = Number($("#queryEarningsInfototalPage").val());
                var pageSize    = Number($("#queryEarningsInfopageSize").val());
                $("#queryEarningsInfo_fy .pager").ucPager({
                    currentPage : currentPage,
                    totalPage : totalPage,
                    pageSize : pageSize,
                    clickCallback: queryEarningsInfogopage
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

function queryEarningsInfogopage(currentPage) {
    searchEarningsInfo(currentPage);
}

function addEarningsInfo(){
    var url=webUrl+"/earningsInfo/insert.dhtml";
    var params={};
    params.id = $("#validateAddEarningsInfoForm #id1").val();
    params.openid = $("#validateAddEarningsInfoForm #openid1").val();
    params.wxUserName = $("#validateAddEarningsInfoForm #wxUserName1").val();
    params.manicheId = $("#validateAddEarningsInfoForm #manicheId1").val();
    params.unversityName = $("#validateAddEarningsInfoForm #unversityName1").val();
    params.unversityId = $("#validateAddEarningsInfoForm #unversityId1").val();
    params.manicheName = $("#validateAddEarningsInfoForm #manicheName1").val();
    params.price = $("#validateAddEarningsInfoForm #price1").val();
    params.coffeeNumber = $("#validateAddEarningsInfoForm #coffeeNumber1").val();
    params.tolalMoney = $("#validateAddEarningsInfoForm #tolalMoney1").val();
    params.earingMonth = $("#validateAddEarningsInfoForm #earingMonth1").val();
    params.earningStartTime = $("#validateAddEarningsInfoForm #earningStartTime1").val();
    params.isEaningStatus = $("#validateAddEarningsInfoForm #isEaningStatus1").val();
    params.earningSendTime = $("#validateAddEarningsInfoForm #earningSendTime1").val();
    params.createTime = $("#validateAddEarningsInfoForm #createTime1").val();
    params.createUser = $("#validateAddEarningsInfoForm #createUser1").val();
    params.updateTime = $("#validateAddEarningsInfoForm #updateTime1").val();
    params.updateUser = $("#validateAddEarningsInfoForm #updateUser1").val();
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
                $('#addEarningsInfo').modal('hide');
                searchEarningsInfo('');
                layer.msg('添加成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateAddEarningsInfoForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateAddEarningsInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
                $('#validateAddEarningsInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateAddEarningsInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function updateEarningsInfo(){
    var url=webUrl+"/earningsInfo/edit.dhtml";
    var params={};
    params.id_key = $("#validateUpdateEarningsInfoForm #id_key").val();
    params.id = $("#validateUpdateEarningsInfoForm #id3").val();
    params.openid = $("#validateUpdateEarningsInfoForm #openid3").val();
    params.wxUserName = $("#validateUpdateEarningsInfoForm #wxUserName3").val();
    params.manicheId = $("#validateUpdateEarningsInfoForm #manicheId3").val();
    params.unversityName = $("#validateUpdateEarningsInfoForm #unversityName3").val();
    params.unversityId = $("#validateUpdateEarningsInfoForm #unversityId3").val();
    params.manicheName = $("#validateUpdateEarningsInfoForm #manicheName3").val();
    params.price = $("#validateUpdateEarningsInfoForm #price3").val();
    params.coffeeNumber = $("#validateUpdateEarningsInfoForm #coffeeNumber3").val();
    params.tolalMoney = $("#validateUpdateEarningsInfoForm #tolalMoney3").val();
    params.earingMonth = $("#validateUpdateEarningsInfoForm #earingMonth3").val();
    params.earningStartTime = $("#validateUpdateEarningsInfoForm #earningStartTime3").val();
    params.isEaningStatus = $("#validateUpdateEarningsInfoForm #isEaningStatus3").val();
    params.earningSendTime = $("#validateUpdateEarningsInfoForm #earningSendTime3").val();
    params.createTime = $("#validateUpdateEarningsInfoForm #createTime3").val();
    params.createUser = $("#validateUpdateEarningsInfoForm #createUser3").val();
    params.updateTime = $("#validateUpdateEarningsInfoForm #updateTime3").val();
    params.updateUser = $("#validateUpdateEarningsInfoForm #updateUser3").val();
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
                $('#updateEarningsInfo').modal('hide');
                searchEarningsInfo('');
                layer.msg('修改成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateUpdateEarningsInfoForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateUpdateEarningsInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
            $('#validateUpdateEarningsInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateUpdateEarningsInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function editEarningsInfo(id_key){
    var url=webUrl+"/earningsInfo/queryObject.dhtml";
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
                $('#updateEarningsInfo').modal();
                $("#validateUpdateEarningsInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblEarningsInfo;
                $("#validateUpdateEarningsInfoForm #id3").val(objInfo.id!=null?objInfo.id:'');
                $("#validateUpdateEarningsInfoForm #openid3").val(objInfo.openid!=null?objInfo.openid:'');
                $("#validateUpdateEarningsInfoForm #wxUserName3").val(objInfo.wxUserName!=null?objInfo.wxUserName:'');
                $("#validateUpdateEarningsInfoForm #manicheId3").val(objInfo.manicheId!=null?objInfo.manicheId:'');
                $("#validateUpdateEarningsInfoForm #unversityName3").val(objInfo.unversityName!=null?objInfo.unversityName:'');
                $("#validateUpdateEarningsInfoForm #unversityId3").val(objInfo.unversityId!=null?objInfo.unversityId:'');
                $("#validateUpdateEarningsInfoForm #manicheName3").val(objInfo.manicheName!=null?objInfo.manicheName:'');
                $("#validateUpdateEarningsInfoForm #price3").val(objInfo.price!=null?objInfo.price:'');
                $("#validateUpdateEarningsInfoForm #coffeeNumber3").val(objInfo.coffeeNumber!=null?objInfo.coffeeNumber:'');
                $("#validateUpdateEarningsInfoForm #tolalMoney3").val(objInfo.tolalMoney!=null?objInfo.tolalMoney:'');
                $("#validateUpdateEarningsInfoForm #earingMonth3").val(objInfo.earingMonth!=null?objInfo.earingMonth:'');
                $("#validateUpdateEarningsInfoForm #earningStartTime3").val(objInfo.earningStartTime!=null?objInfo.earningStartTime:'');
                $("#validateUpdateEarningsInfoForm #isEaningStatus3").val(objInfo.isEaningStatus!=null?objInfo.isEaningStatus:'');
                $("#validateUpdateEarningsInfoForm #earningSendTime3").val(objInfo.earningSendTime!=null?objInfo.earningSendTime:'');
                $("#validateUpdateEarningsInfoForm #createTime3").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateUpdateEarningsInfoForm #createUser3").val(objInfo.createUser!=null?objInfo.createUser:'');
                $("#validateUpdateEarningsInfoForm #updateTime3").val(objInfo.updateTime!=null?objInfo.updateTime:'');
                $("#validateUpdateEarningsInfoForm #updateUser3").val(objInfo.updateUser!=null?objInfo.updateUser:'');
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

function queryEarningsInfoObject(id_key){
    var url=webUrl+"/earningsInfo/queryObject.dhtml";
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
                $('#detailEarningsInfo').modal();
                $("#validateDetailEarningsInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblEarningsInfo;
                $("#validateDetailEarningsInfoForm #id2").val(objInfo.id!=null?objInfo.id:'');
                $("#validateDetailEarningsInfoForm #openid2").val(objInfo.openid!=null?objInfo.openid:'');
                $("#validateDetailEarningsInfoForm #wxUserName2").val(objInfo.wxUserName!=null?objInfo.wxUserName:'');
                $("#validateDetailEarningsInfoForm #manicheId2").val(objInfo.manicheId!=null?objInfo.manicheId:'');
                $("#validateDetailEarningsInfoForm #unversityName2").val(objInfo.unversityName!=null?objInfo.unversityName:'');
                $("#validateDetailEarningsInfoForm #unversityId2").val(objInfo.unversityId!=null?objInfo.unversityId:'');
                $("#validateDetailEarningsInfoForm #manicheName2").val(objInfo.manicheName!=null?objInfo.manicheName:'');
                $("#validateDetailEarningsInfoForm #price2").val(objInfo.price!=null?objInfo.price:'');
                $("#validateDetailEarningsInfoForm #coffeeNumber2").val(objInfo.coffeeNumber!=null?objInfo.coffeeNumber:'');
                $("#validateDetailEarningsInfoForm #tolalMoney2").val(objInfo.tolalMoney!=null?objInfo.tolalMoney:'');
                $("#validateDetailEarningsInfoForm #earingMonth2").val(objInfo.earingMonth!=null?objInfo.earingMonth:'');
                $("#validateDetailEarningsInfoForm #earningStartTime2").val(objInfo.earningStartTime!=null?objInfo.earningStartTime:'');
                $("#validateDetailEarningsInfoForm #isEaningStatus2").val(objInfo.isEaningStatus!=null?objInfo.isEaningStatus:'');
                $("#validateDetailEarningsInfoForm #earningSendTime2").val(objInfo.earningSendTime!=null?objInfo.earningSendTime:'');
                $("#validateDetailEarningsInfoForm #createTime2").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateDetailEarningsInfoForm #createUser2").val(objInfo.createUser!=null?objInfo.createUser:'');
                $("#validateDetailEarningsInfoForm #updateTime2").val(objInfo.updateTime!=null?objInfo.updateTime:'');
                $("#validateDetailEarningsInfoForm #updateUser2").val(objInfo.updateUser!=null?objInfo.updateUser:'');
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
function delEarningsInfo(id_key){
    layer.confirm('是否删除？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        var url=webUrl+"/earningsInfo/del.dhtml";
        var params={};
        var currentPage= $("#queryEarningsInfocurrentPage").val();
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
                    searchEarningsInfo(currentPage);
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



$(function(){
    searchOrderInfo('');
    $('#queryOrderInfopageSize').on('change',function () {
        var currentPage = $("#queryOrderInfocurrentPage").val();
        searchOrderInfo(currentPage);
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
    $('#updateOrderInfo').on('shown.bs.modal', function () {
        $('#validateUpdateOrderInfoForm').bootstrapValidator('resetForm', false);
    });

    //增加订单表校验
    $('#validateAddOrderInfoForm').bootstrapValidator({
        fields : {
            id1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            orderNo1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            body1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            detail1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            number1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            price1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            totalFee1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            spbillCreateIp1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            payStartTime1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            payEndTime1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            goodsTag1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            openid1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            userName1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            payTime1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            payStatus1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            manicheId1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            manicheName1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            areaName1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            areaId1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            unversityName1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            universityId1 : {
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
         addOrderInfo();
     });

    //修改订单表校验
    $('#validateUpdateOrderInfoForm').bootstrapValidator({
        fields : {
            id3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            orderNo3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            body3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            detail3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            number3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            price3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            totalFee3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            spbillCreateIp3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            payStartTime3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            payEndTime3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            goodsTag3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            openid3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            userName3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            payTime3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            payStatus3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            manicheId3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            manicheName3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            areaName3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            areaId3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            unversityName3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            universityId3 : {
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
         updateOrderInfo();
     });
    //查询订单表校验
    $('#queryOrderInfoForm').bootstrapValidator({
        fields : {
            id : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            orderNo : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            body : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            detail : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            number : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            price : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            totalFee : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            spbillCreateIp : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            payStartTime : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            payEndTime : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            goodsTag : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            openid : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            userName : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            payTime : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            payStatus : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            manicheId : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            manicheName : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            areaName : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            areaId : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            unversityName : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            universityId : {
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

function searchOrderInfo(currentPage,queryType,fileName,exportParam){
    //没有bootstrapvalidator，则返回
    if($('#queryOrderInfoForm').data('bootstrapValidator')!=null) {
        //对查询框进行校验
        $('#queryOrderInfoForm').data('bootstrapValidator').validate();
        //校验没有通过，则返回
        if(!$('#queryOrderInfoForm').data('bootstrapValidator').isValid()){
            return;
        }
        //----个性化校验示例开始
        //if($('#query"+cleanentityClassName+"Form #被验证组件name').val()=='#'){
        //    layer.alert('XX禁止查询')
        //    //第三个参数为，显示的错误信息所属的validator规则
        //    $('#queryOrderInfoForm').data('bootstrapValidator').updateStatus('被验证组件name','INVALID','stringLength');
        //    return;
        //}
        //----个性化校验示例结束
    }
    var params ={};
    if(currentPage == "undefined" || currentPage =="" || currentPage == null){
        var currentPage_text = $("#queryOrderInfocurrentPage").val();
        if(currentPage_text =="undefined" || currentPage_text =="" || currentPage_text == null){
            currentPage_text = "1";
        }
        params.startIndex = currentPage_text;
    }else{
        params.startIndex = currentPage;
    }

    var pageSize= $("#queryOrderInfopageSize").val();
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

    params.id = $("#queryOrderInfoForm #id").val();
    params.orderNo = $("#queryOrderInfoForm #orderNo").val();
    params.body = $("#queryOrderInfoForm #body").val();
    params.detail = $("#queryOrderInfoForm #detail").val();
    params.number = $("#queryOrderInfoForm #number").val();
    params.price = $("#queryOrderInfoForm #price").val();
    params.totalFee = $("#queryOrderInfoForm #totalFee").val();
    params.spbillCreateIp = $("#queryOrderInfoForm #spbillCreateIp").val();
    params.payStartTime = $("#queryOrderInfoForm #payStartTime").val();
    params.payEndTime = $("#queryOrderInfoForm #payEndTime").val();
    params.goodsTag = $("#queryOrderInfoForm #goodsTag").val();
    params.openid = $("#queryOrderInfoForm #openid").val();
    params.userName = $("#queryOrderInfoForm #userName").val();
    params.payTime = $("#queryOrderInfoForm #payTime").val();
    params.payStatus = $("#queryOrderInfoForm #payStatus").val();
    params.manicheId = $("#queryOrderInfoForm #manicheId").val();
    params.manicheName = $("#queryOrderInfoForm #manicheName").val();
    params.areaName = $("#queryOrderInfoForm #areaName").val();
    params.areaId = $("#queryOrderInfoForm #areaId").val();
    params.unversityName = $("#queryOrderInfoForm #unversityName").val();
    params.universityId = $("#queryOrderInfoForm #universityId").val();
    params.createTime = $("#queryOrderInfoForm #createTime").val();
    params.createUser = $("#queryOrderInfoForm #createUser").val();
    params.updateTime = $("#queryOrderInfoForm #updateTime").val();
    params.updateUser = $("#queryOrderInfoForm #updateUser").val();

    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    jsonStr = encodeURIComponent(jsonStr);
    if(queryType!=undefined && queryType =='download'){
        window.location.href=webUrl+"/orderInfo/search.dhtml?jsonStr="+jsonStr+"&v="+Math.random();
        return;
    }
    
    $.ajax({
        type:"POST",
        url:webUrl+"/orderInfo/search.dhtml",
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $("#orderInfoTR_FIRST").siblings().remove();
                var  resultList=data.rows[0].pageRecords;

                //分页
                $("#queryOrderInfocurrentPage").val(data.rows[0].startIndex);
                $("#queryOrderInfototalPage").val(data.rows[0].totalPage);
                $("#queryOrderInfopageSize").val(data.rows[0].pageSize);
                for(var i=0;i<resultList.length;i++){
                    var orderInfoTr = $("<tr class=\"orderInfoTr\"></tr>");
                    $("#orderInfoTR_FIRST").parent().append(orderInfoTr);
                    orderInfoTr.append("<td><input style=\"width:23px;\" type=\"checkbox\"/></td><td>"+(i+1)+"</td>")
                    .append("<td>"+resultList[i].id+"</td>")
                    .append("<td>"+resultList[i].orderNo+"</td>")
                    .append("<td>"+resultList[i].body+"</td>")
                    .append("<td>"+resultList[i].detail+"</td>")
                    .append("<td>"+resultList[i].number+"</td>")
                    .append("<td>"+resultList[i].price+"</td>")
                    .append("<td>"+resultList[i].totalFee+"</td>")
                    .append("<td>"+resultList[i].spbillCreateIp+"</td>")
                    .append("<td>"+resultList[i].payStartTime+"</td>")
                    .append("<td>"+resultList[i].payEndTime+"</td>")
                    .append("<td>"+resultList[i].goodsTag+"</td>")
                    .append("<td>"+resultList[i].openid+"</td>")
                    .append("<td>"+resultList[i].userName+"</td>")
                    .append("<td>"+resultList[i].payTime+"</td>")
                    .append("<td>"+resultList[i].payStatus+"</td>")
                    .append("<td>"+resultList[i].manicheId+"</td>")
                    .append("<td>"+resultList[i].manicheName+"</td>")
                    .append("<td>"+resultList[i].areaName+"</td>")
                    .append("<td>"+resultList[i].areaId+"</td>")
                    .append("<td>"+resultList[i].unversityName+"</td>")
                    .append("<td>"+resultList[i].universityId+"</td>")
                    .append("<td>"+resultList[i].createTime+"</td>")
                    .append("<td>"+resultList[i].createUser+"</td>")
                    .append("<td>"+resultList[i].updateTime+"</td>")
                    .append("<td>"+resultList[i].updateUser+"</td>")
                    .append("<td class=\"operateTbl\"><button class=\"btn btn-default btn-sm\" onclick=\"return editOrderInfo('"+resultList[i].id+"');\"><i class=\"fa fa-edit\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return  delOrderInfo('"+resultList[i].id+"');\"><i class=\"fa fa-trash-o\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return queryOrderInfoObject('"+resultList[i].id+"');\"><i class=\"fa fa-search\"></i></button></td>");
                }
                var currentPage = Number($("#queryOrderInfocurrentPage").val());
                var totalPage   = Number($("#queryOrderInfototalPage").val());
                var pageSize    = Number($("#queryOrderInfopageSize").val());
                $("#queryOrderInfo_fy .pager").ucPager({
                    currentPage : currentPage,
                    totalPage : totalPage,
                    pageSize : pageSize,
                    clickCallback: queryOrderInfogopage
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

function queryOrderInfogopage(currentPage) {
    searchOrderInfo(currentPage);
}

function addOrderInfo(){
    var url=webUrl+"/orderInfo/insert.dhtml";
    var params={};
    params.id = $("#validateAddOrderInfoForm #id1").val();
    params.orderNo = $("#validateAddOrderInfoForm #orderNo1").val();
    params.body = $("#validateAddOrderInfoForm #body1").val();
    params.detail = $("#validateAddOrderInfoForm #detail1").val();
    params.number = $("#validateAddOrderInfoForm #number1").val();
    params.price = $("#validateAddOrderInfoForm #price1").val();
    params.totalFee = $("#validateAddOrderInfoForm #totalFee1").val();
    params.spbillCreateIp = $("#validateAddOrderInfoForm #spbillCreateIp1").val();
    params.payStartTime = $("#validateAddOrderInfoForm #payStartTime1").val();
    params.payEndTime = $("#validateAddOrderInfoForm #payEndTime1").val();
    params.goodsTag = $("#validateAddOrderInfoForm #goodsTag1").val();
    params.openid = $("#validateAddOrderInfoForm #openid1").val();
    params.userName = $("#validateAddOrderInfoForm #userName1").val();
    params.payTime = $("#validateAddOrderInfoForm #payTime1").val();
    params.payStatus = $("#validateAddOrderInfoForm #payStatus1").val();
    params.manicheId = $("#validateAddOrderInfoForm #manicheId1").val();
    params.manicheName = $("#validateAddOrderInfoForm #manicheName1").val();
    params.areaName = $("#validateAddOrderInfoForm #areaName1").val();
    params.areaId = $("#validateAddOrderInfoForm #areaId1").val();
    params.unversityName = $("#validateAddOrderInfoForm #unversityName1").val();
    params.universityId = $("#validateAddOrderInfoForm #universityId1").val();
    params.createTime = $("#validateAddOrderInfoForm #createTime1").val();
    params.createUser = $("#validateAddOrderInfoForm #createUser1").val();
    params.updateTime = $("#validateAddOrderInfoForm #updateTime1").val();
    params.updateUser = $("#validateAddOrderInfoForm #updateUser1").val();
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
                $('#addOrderInfo').modal('hide');
                searchOrderInfo('');
                layer.msg('添加成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateAddOrderInfoForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateAddOrderInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
                $('#validateAddOrderInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateAddOrderInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function updateOrderInfo(){
    var url=webUrl+"/orderInfo/edit.dhtml";
    var params={};
    params.id_key = $("#validateUpdateOrderInfoForm #id_key").val();
    params.id = $("#validateUpdateOrderInfoForm #id3").val();
    params.orderNo = $("#validateUpdateOrderInfoForm #orderNo3").val();
    params.body = $("#validateUpdateOrderInfoForm #body3").val();
    params.detail = $("#validateUpdateOrderInfoForm #detail3").val();
    params.number = $("#validateUpdateOrderInfoForm #number3").val();
    params.price = $("#validateUpdateOrderInfoForm #price3").val();
    params.totalFee = $("#validateUpdateOrderInfoForm #totalFee3").val();
    params.spbillCreateIp = $("#validateUpdateOrderInfoForm #spbillCreateIp3").val();
    params.payStartTime = $("#validateUpdateOrderInfoForm #payStartTime3").val();
    params.payEndTime = $("#validateUpdateOrderInfoForm #payEndTime3").val();
    params.goodsTag = $("#validateUpdateOrderInfoForm #goodsTag3").val();
    params.openid = $("#validateUpdateOrderInfoForm #openid3").val();
    params.userName = $("#validateUpdateOrderInfoForm #userName3").val();
    params.payTime = $("#validateUpdateOrderInfoForm #payTime3").val();
    params.payStatus = $("#validateUpdateOrderInfoForm #payStatus3").val();
    params.manicheId = $("#validateUpdateOrderInfoForm #manicheId3").val();
    params.manicheName = $("#validateUpdateOrderInfoForm #manicheName3").val();
    params.areaName = $("#validateUpdateOrderInfoForm #areaName3").val();
    params.areaId = $("#validateUpdateOrderInfoForm #areaId3").val();
    params.unversityName = $("#validateUpdateOrderInfoForm #unversityName3").val();
    params.universityId = $("#validateUpdateOrderInfoForm #universityId3").val();
    params.createTime = $("#validateUpdateOrderInfoForm #createTime3").val();
    params.createUser = $("#validateUpdateOrderInfoForm #createUser3").val();
    params.updateTime = $("#validateUpdateOrderInfoForm #updateTime3").val();
    params.updateUser = $("#validateUpdateOrderInfoForm #updateUser3").val();
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
                $('#updateOrderInfo').modal('hide');
                searchOrderInfo('');
                layer.msg('修改成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateUpdateOrderInfoForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateUpdateOrderInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
            $('#validateUpdateOrderInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateUpdateOrderInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function editOrderInfo(id_key){
    var url=webUrl+"/orderInfo/queryObject.dhtml";
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
                $('#updateOrderInfo').modal();
                $("#validateUpdateOrderInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblOrderInfo;
                $("#validateUpdateOrderInfoForm #id3").val(objInfo.id!=null?objInfo.id:'');
                $("#validateUpdateOrderInfoForm #orderNo3").val(objInfo.orderNo!=null?objInfo.orderNo:'');
                $("#validateUpdateOrderInfoForm #body3").val(objInfo.body!=null?objInfo.body:'');
                $("#validateUpdateOrderInfoForm #detail3").val(objInfo.detail!=null?objInfo.detail:'');
                $("#validateUpdateOrderInfoForm #number3").val(objInfo.number!=null?objInfo.number:'');
                $("#validateUpdateOrderInfoForm #price3").val(objInfo.price!=null?objInfo.price:'');
                $("#validateUpdateOrderInfoForm #totalFee3").val(objInfo.totalFee!=null?objInfo.totalFee:'');
                $("#validateUpdateOrderInfoForm #spbillCreateIp3").val(objInfo.spbillCreateIp!=null?objInfo.spbillCreateIp:'');
                $("#validateUpdateOrderInfoForm #payStartTime3").val(objInfo.payStartTime!=null?objInfo.payStartTime:'');
                $("#validateUpdateOrderInfoForm #payEndTime3").val(objInfo.payEndTime!=null?objInfo.payEndTime:'');
                $("#validateUpdateOrderInfoForm #goodsTag3").val(objInfo.goodsTag!=null?objInfo.goodsTag:'');
                $("#validateUpdateOrderInfoForm #openid3").val(objInfo.openid!=null?objInfo.openid:'');
                $("#validateUpdateOrderInfoForm #userName3").val(objInfo.userName!=null?objInfo.userName:'');
                $("#validateUpdateOrderInfoForm #payTime3").val(objInfo.payTime!=null?objInfo.payTime:'');
                $("#validateUpdateOrderInfoForm #payStatus3").val(objInfo.payStatus!=null?objInfo.payStatus:'');
                $("#validateUpdateOrderInfoForm #manicheId3").val(objInfo.manicheId!=null?objInfo.manicheId:'');
                $("#validateUpdateOrderInfoForm #manicheName3").val(objInfo.manicheName!=null?objInfo.manicheName:'');
                $("#validateUpdateOrderInfoForm #areaName3").val(objInfo.areaName!=null?objInfo.areaName:'');
                $("#validateUpdateOrderInfoForm #areaId3").val(objInfo.areaId!=null?objInfo.areaId:'');
                $("#validateUpdateOrderInfoForm #unversityName3").val(objInfo.unversityName!=null?objInfo.unversityName:'');
                $("#validateUpdateOrderInfoForm #universityId3").val(objInfo.universityId!=null?objInfo.universityId:'');
                $("#validateUpdateOrderInfoForm #createTime3").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateUpdateOrderInfoForm #createUser3").val(objInfo.createUser!=null?objInfo.createUser:'');
                $("#validateUpdateOrderInfoForm #updateTime3").val(objInfo.updateTime!=null?objInfo.updateTime:'');
                $("#validateUpdateOrderInfoForm #updateUser3").val(objInfo.updateUser!=null?objInfo.updateUser:'');
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

function queryOrderInfoObject(id_key){
    var url=webUrl+"/orderInfo/queryObject.dhtml";
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
                $('#detailOrderInfo').modal();
                $("#validateDetailOrderInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblOrderInfo;
                $("#validateDetailOrderInfoForm #id2").val(objInfo.id!=null?objInfo.id:'');
                $("#validateDetailOrderInfoForm #orderNo2").val(objInfo.orderNo!=null?objInfo.orderNo:'');
                $("#validateDetailOrderInfoForm #body2").val(objInfo.body!=null?objInfo.body:'');
                $("#validateDetailOrderInfoForm #detail2").val(objInfo.detail!=null?objInfo.detail:'');
                $("#validateDetailOrderInfoForm #number2").val(objInfo.number!=null?objInfo.number:'');
                $("#validateDetailOrderInfoForm #price2").val(objInfo.price!=null?objInfo.price:'');
                $("#validateDetailOrderInfoForm #totalFee2").val(objInfo.totalFee!=null?objInfo.totalFee:'');
                $("#validateDetailOrderInfoForm #spbillCreateIp2").val(objInfo.spbillCreateIp!=null?objInfo.spbillCreateIp:'');
                $("#validateDetailOrderInfoForm #payStartTime2").val(objInfo.payStartTime!=null?objInfo.payStartTime:'');
                $("#validateDetailOrderInfoForm #payEndTime2").val(objInfo.payEndTime!=null?objInfo.payEndTime:'');
                $("#validateDetailOrderInfoForm #goodsTag2").val(objInfo.goodsTag!=null?objInfo.goodsTag:'');
                $("#validateDetailOrderInfoForm #openid2").val(objInfo.openid!=null?objInfo.openid:'');
                $("#validateDetailOrderInfoForm #userName2").val(objInfo.userName!=null?objInfo.userName:'');
                $("#validateDetailOrderInfoForm #payTime2").val(objInfo.payTime!=null?objInfo.payTime:'');
                $("#validateDetailOrderInfoForm #payStatus2").val(objInfo.payStatus!=null?objInfo.payStatus:'');
                $("#validateDetailOrderInfoForm #manicheId2").val(objInfo.manicheId!=null?objInfo.manicheId:'');
                $("#validateDetailOrderInfoForm #manicheName2").val(objInfo.manicheName!=null?objInfo.manicheName:'');
                $("#validateDetailOrderInfoForm #areaName2").val(objInfo.areaName!=null?objInfo.areaName:'');
                $("#validateDetailOrderInfoForm #areaId2").val(objInfo.areaId!=null?objInfo.areaId:'');
                $("#validateDetailOrderInfoForm #unversityName2").val(objInfo.unversityName!=null?objInfo.unversityName:'');
                $("#validateDetailOrderInfoForm #universityId2").val(objInfo.universityId!=null?objInfo.universityId:'');
                $("#validateDetailOrderInfoForm #createTime2").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateDetailOrderInfoForm #createUser2").val(objInfo.createUser!=null?objInfo.createUser:'');
                $("#validateDetailOrderInfoForm #updateTime2").val(objInfo.updateTime!=null?objInfo.updateTime:'');
                $("#validateDetailOrderInfoForm #updateUser2").val(objInfo.updateUser!=null?objInfo.updateUser:'');
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
function delOrderInfo(id_key){
    layer.confirm('是否删除？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        var url=webUrl+"/orderInfo/del.dhtml";
        var params={};
        var currentPage= $("#queryOrderInfocurrentPage").val();
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
                    searchOrderInfo(currentPage);
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



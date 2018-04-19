$(function(){
    searchOrderDeal('');
    $('#queryOrderDealpageSize').on('change',function () {
        var currentPage = $("#queryOrderDealcurrentPage").val();
        searchOrderDeal(currentPage);
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
    $('#updateOrderDeal').on('shown.bs.modal', function () {
        $('#validateUpdateOrderDealForm').bootstrapValidator('resetForm', false);
    });

    //增加订单支付临时表校验
    $('#validateAddOrderDealForm').bootstrapValidator({
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
         addOrderDeal();
     });

    //修改订单支付临时表校验
    $('#validateUpdateOrderDealForm').bootstrapValidator({
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
         updateOrderDeal();
     });
    //查询订单支付临时表校验
    $('#queryOrderDealForm').bootstrapValidator({
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

function searchOrderDeal(currentPage,queryType,fileName,exportParam){
    //没有bootstrapvalidator，则返回
    if($('#queryOrderDealForm').data('bootstrapValidator')!=null) {
        //对查询框进行校验
        $('#queryOrderDealForm').data('bootstrapValidator').validate();
        //校验没有通过，则返回
        if(!$('#queryOrderDealForm').data('bootstrapValidator').isValid()){
            return;
        }
        //----个性化校验示例开始
        //if($('#query"+cleanentityClassName+"Form #被验证组件name').val()=='#'){
        //    layer.alert('XX禁止查询')
        //    //第三个参数为，显示的错误信息所属的validator规则
        //    $('#queryOrderDealForm').data('bootstrapValidator').updateStatus('被验证组件name','INVALID','stringLength');
        //    return;
        //}
        //----个性化校验示例结束
    }
    var params ={};
    if(currentPage == "undefined" || currentPage =="" || currentPage == null){
        var currentPage_text = $("#queryOrderDealcurrentPage").val();
        if(currentPage_text =="undefined" || currentPage_text =="" || currentPage_text == null){
            currentPage_text = "1";
        }
        params.startIndex = currentPage_text;
    }else{
        params.startIndex = currentPage;
    }

    var pageSize= $("#queryOrderDealpageSize").val();
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

    params.id = $("#queryOrderDealForm #id").val();
    params.orderNo = $("#queryOrderDealForm #orderNo").val();
    params.body = $("#queryOrderDealForm #body").val();
    params.detail = $("#queryOrderDealForm #detail").val();
    params.number = $("#queryOrderDealForm #number").val();
    params.price = $("#queryOrderDealForm #price").val();
    params.totalFee = $("#queryOrderDealForm #totalFee").val();
    params.spbillCreateIp = $("#queryOrderDealForm #spbillCreateIp").val();
    params.payStartTime = $("#queryOrderDealForm #payStartTime").val();
    params.payEndTime = $("#queryOrderDealForm #payEndTime").val();
    params.goodsTag = $("#queryOrderDealForm #goodsTag").val();
    params.openid = $("#queryOrderDealForm #openid").val();
    params.userName = $("#queryOrderDealForm #userName").val();
    params.payTime = $("#queryOrderDealForm #payTime").val();
    params.payStatus = $("#queryOrderDealForm #payStatus").val();
    params.manicheId = $("#queryOrderDealForm #manicheId").val();
    params.manicheName = $("#queryOrderDealForm #manicheName").val();
    params.areaName = $("#queryOrderDealForm #areaName").val();
    params.areaId = $("#queryOrderDealForm #areaId").val();
    params.unversityName = $("#queryOrderDealForm #unversityName").val();
    params.universityId = $("#queryOrderDealForm #universityId").val();
    params.createTime = $("#queryOrderDealForm #createTime").val();
    params.createUser = $("#queryOrderDealForm #createUser").val();
    params.updateTime = $("#queryOrderDealForm #updateTime").val();
    params.updateUser = $("#queryOrderDealForm #updateUser").val();

    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    jsonStr = encodeURIComponent(jsonStr);
    if(queryType!=undefined && queryType =='download'){
        window.location.href=webUrl+"/orderDeal/search.dhtml?jsonStr="+jsonStr+"&v="+Math.random();
        return;
    }
    
    $.ajax({
        type:"POST",
        url:webUrl+"/orderDeal/search.dhtml",
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $("#orderDealTR_FIRST").siblings().remove();
                var  resultList=data.rows[0].pageRecords;

                //分页
                $("#queryOrderDealcurrentPage").val(data.rows[0].startIndex);
                $("#queryOrderDealtotalPage").val(data.rows[0].totalPage);
                $("#queryOrderDealpageSize").val(data.rows[0].pageSize);
                for(var i=0;i<resultList.length;i++){
                    var orderDealTr = $("<tr class=\"orderDealTr\"></tr>");
                    $("#orderDealTR_FIRST").parent().append(orderDealTr);
                    orderDealTr.append("<td><input style=\"width:23px;\" type=\"checkbox\"/></td><td>"+(i+1)+"</td>")
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
                    .append("<td class=\"operateTbl\"><button class=\"btn btn-default btn-sm\" onclick=\"return editOrderDeal('"+resultList[i].id+"');\"><i class=\"fa fa-edit\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return  delOrderDeal('"+resultList[i].id+"');\"><i class=\"fa fa-trash-o\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return queryOrderDealObject('"+resultList[i].id+"');\"><i class=\"fa fa-search\"></i></button></td>");
                }
                var currentPage = Number($("#queryOrderDealcurrentPage").val());
                var totalPage   = Number($("#queryOrderDealtotalPage").val());
                var pageSize    = Number($("#queryOrderDealpageSize").val());
                $("#queryOrderDeal_fy .pager").ucPager({
                    currentPage : currentPage,
                    totalPage : totalPage,
                    pageSize : pageSize,
                    clickCallback: queryOrderDealgopage
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

function queryOrderDealgopage(currentPage) {
    searchOrderDeal(currentPage);
}

function addOrderDeal(){
    var url=webUrl+"/orderDeal/insert.dhtml";
    var params={};
    params.id = $("#validateAddOrderDealForm #id1").val();
    params.orderNo = $("#validateAddOrderDealForm #orderNo1").val();
    params.body = $("#validateAddOrderDealForm #body1").val();
    params.detail = $("#validateAddOrderDealForm #detail1").val();
    params.number = $("#validateAddOrderDealForm #number1").val();
    params.price = $("#validateAddOrderDealForm #price1").val();
    params.totalFee = $("#validateAddOrderDealForm #totalFee1").val();
    params.spbillCreateIp = $("#validateAddOrderDealForm #spbillCreateIp1").val();
    params.payStartTime = $("#validateAddOrderDealForm #payStartTime1").val();
    params.payEndTime = $("#validateAddOrderDealForm #payEndTime1").val();
    params.goodsTag = $("#validateAddOrderDealForm #goodsTag1").val();
    params.openid = $("#validateAddOrderDealForm #openid1").val();
    params.userName = $("#validateAddOrderDealForm #userName1").val();
    params.payTime = $("#validateAddOrderDealForm #payTime1").val();
    params.payStatus = $("#validateAddOrderDealForm #payStatus1").val();
    params.manicheId = $("#validateAddOrderDealForm #manicheId1").val();
    params.manicheName = $("#validateAddOrderDealForm #manicheName1").val();
    params.areaName = $("#validateAddOrderDealForm #areaName1").val();
    params.areaId = $("#validateAddOrderDealForm #areaId1").val();
    params.unversityName = $("#validateAddOrderDealForm #unversityName1").val();
    params.universityId = $("#validateAddOrderDealForm #universityId1").val();
    params.createTime = $("#validateAddOrderDealForm #createTime1").val();
    params.createUser = $("#validateAddOrderDealForm #createUser1").val();
    params.updateTime = $("#validateAddOrderDealForm #updateTime1").val();
    params.updateUser = $("#validateAddOrderDealForm #updateUser1").val();
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
                $('#addOrderDeal').modal('hide');
                searchOrderDeal('');
                layer.msg('添加成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateAddOrderDealForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateAddOrderDealForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
                $('#validateAddOrderDealForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateAddOrderDealForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function updateOrderDeal(){
    var url=webUrl+"/orderDeal/edit.dhtml";
    var params={};
    params.id_key = $("#validateUpdateOrderDealForm #id_key").val();
    params.id = $("#validateUpdateOrderDealForm #id3").val();
    params.orderNo = $("#validateUpdateOrderDealForm #orderNo3").val();
    params.body = $("#validateUpdateOrderDealForm #body3").val();
    params.detail = $("#validateUpdateOrderDealForm #detail3").val();
    params.number = $("#validateUpdateOrderDealForm #number3").val();
    params.price = $("#validateUpdateOrderDealForm #price3").val();
    params.totalFee = $("#validateUpdateOrderDealForm #totalFee3").val();
    params.spbillCreateIp = $("#validateUpdateOrderDealForm #spbillCreateIp3").val();
    params.payStartTime = $("#validateUpdateOrderDealForm #payStartTime3").val();
    params.payEndTime = $("#validateUpdateOrderDealForm #payEndTime3").val();
    params.goodsTag = $("#validateUpdateOrderDealForm #goodsTag3").val();
    params.openid = $("#validateUpdateOrderDealForm #openid3").val();
    params.userName = $("#validateUpdateOrderDealForm #userName3").val();
    params.payTime = $("#validateUpdateOrderDealForm #payTime3").val();
    params.payStatus = $("#validateUpdateOrderDealForm #payStatus3").val();
    params.manicheId = $("#validateUpdateOrderDealForm #manicheId3").val();
    params.manicheName = $("#validateUpdateOrderDealForm #manicheName3").val();
    params.areaName = $("#validateUpdateOrderDealForm #areaName3").val();
    params.areaId = $("#validateUpdateOrderDealForm #areaId3").val();
    params.unversityName = $("#validateUpdateOrderDealForm #unversityName3").val();
    params.universityId = $("#validateUpdateOrderDealForm #universityId3").val();
    params.createTime = $("#validateUpdateOrderDealForm #createTime3").val();
    params.createUser = $("#validateUpdateOrderDealForm #createUser3").val();
    params.updateTime = $("#validateUpdateOrderDealForm #updateTime3").val();
    params.updateUser = $("#validateUpdateOrderDealForm #updateUser3").val();
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
                $('#updateOrderDeal').modal('hide');
                searchOrderDeal('');
                layer.msg('修改成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateUpdateOrderDealForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateUpdateOrderDealForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
            $('#validateUpdateOrderDealForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateUpdateOrderDealForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function editOrderDeal(id_key){
    var url=webUrl+"/orderDeal/queryObject.dhtml";
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
                $('#updateOrderDeal').modal();
                $("#validateUpdateOrderDealForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblOrderDeal;
                $("#validateUpdateOrderDealForm #id3").val(objInfo.id!=null?objInfo.id:'');
                $("#validateUpdateOrderDealForm #orderNo3").val(objInfo.orderNo!=null?objInfo.orderNo:'');
                $("#validateUpdateOrderDealForm #body3").val(objInfo.body!=null?objInfo.body:'');
                $("#validateUpdateOrderDealForm #detail3").val(objInfo.detail!=null?objInfo.detail:'');
                $("#validateUpdateOrderDealForm #number3").val(objInfo.number!=null?objInfo.number:'');
                $("#validateUpdateOrderDealForm #price3").val(objInfo.price!=null?objInfo.price:'');
                $("#validateUpdateOrderDealForm #totalFee3").val(objInfo.totalFee!=null?objInfo.totalFee:'');
                $("#validateUpdateOrderDealForm #spbillCreateIp3").val(objInfo.spbillCreateIp!=null?objInfo.spbillCreateIp:'');
                $("#validateUpdateOrderDealForm #payStartTime3").val(objInfo.payStartTime!=null?objInfo.payStartTime:'');
                $("#validateUpdateOrderDealForm #payEndTime3").val(objInfo.payEndTime!=null?objInfo.payEndTime:'');
                $("#validateUpdateOrderDealForm #goodsTag3").val(objInfo.goodsTag!=null?objInfo.goodsTag:'');
                $("#validateUpdateOrderDealForm #openid3").val(objInfo.openid!=null?objInfo.openid:'');
                $("#validateUpdateOrderDealForm #userName3").val(objInfo.userName!=null?objInfo.userName:'');
                $("#validateUpdateOrderDealForm #payTime3").val(objInfo.payTime!=null?objInfo.payTime:'');
                $("#validateUpdateOrderDealForm #payStatus3").val(objInfo.payStatus!=null?objInfo.payStatus:'');
                $("#validateUpdateOrderDealForm #manicheId3").val(objInfo.manicheId!=null?objInfo.manicheId:'');
                $("#validateUpdateOrderDealForm #manicheName3").val(objInfo.manicheName!=null?objInfo.manicheName:'');
                $("#validateUpdateOrderDealForm #areaName3").val(objInfo.areaName!=null?objInfo.areaName:'');
                $("#validateUpdateOrderDealForm #areaId3").val(objInfo.areaId!=null?objInfo.areaId:'');
                $("#validateUpdateOrderDealForm #unversityName3").val(objInfo.unversityName!=null?objInfo.unversityName:'');
                $("#validateUpdateOrderDealForm #universityId3").val(objInfo.universityId!=null?objInfo.universityId:'');
                $("#validateUpdateOrderDealForm #createTime3").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateUpdateOrderDealForm #createUser3").val(objInfo.createUser!=null?objInfo.createUser:'');
                $("#validateUpdateOrderDealForm #updateTime3").val(objInfo.updateTime!=null?objInfo.updateTime:'');
                $("#validateUpdateOrderDealForm #updateUser3").val(objInfo.updateUser!=null?objInfo.updateUser:'');
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

function queryOrderDealObject(id_key){
    var url=webUrl+"/orderDeal/queryObject.dhtml";
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
                $('#detailOrderDeal').modal();
                $("#validateDetailOrderDealForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblOrderDeal;
                $("#validateDetailOrderDealForm #id2").val(objInfo.id!=null?objInfo.id:'');
                $("#validateDetailOrderDealForm #orderNo2").val(objInfo.orderNo!=null?objInfo.orderNo:'');
                $("#validateDetailOrderDealForm #body2").val(objInfo.body!=null?objInfo.body:'');
                $("#validateDetailOrderDealForm #detail2").val(objInfo.detail!=null?objInfo.detail:'');
                $("#validateDetailOrderDealForm #number2").val(objInfo.number!=null?objInfo.number:'');
                $("#validateDetailOrderDealForm #price2").val(objInfo.price!=null?objInfo.price:'');
                $("#validateDetailOrderDealForm #totalFee2").val(objInfo.totalFee!=null?objInfo.totalFee:'');
                $("#validateDetailOrderDealForm #spbillCreateIp2").val(objInfo.spbillCreateIp!=null?objInfo.spbillCreateIp:'');
                $("#validateDetailOrderDealForm #payStartTime2").val(objInfo.payStartTime!=null?objInfo.payStartTime:'');
                $("#validateDetailOrderDealForm #payEndTime2").val(objInfo.payEndTime!=null?objInfo.payEndTime:'');
                $("#validateDetailOrderDealForm #goodsTag2").val(objInfo.goodsTag!=null?objInfo.goodsTag:'');
                $("#validateDetailOrderDealForm #openid2").val(objInfo.openid!=null?objInfo.openid:'');
                $("#validateDetailOrderDealForm #userName2").val(objInfo.userName!=null?objInfo.userName:'');
                $("#validateDetailOrderDealForm #payTime2").val(objInfo.payTime!=null?objInfo.payTime:'');
                $("#validateDetailOrderDealForm #payStatus2").val(objInfo.payStatus!=null?objInfo.payStatus:'');
                $("#validateDetailOrderDealForm #manicheId2").val(objInfo.manicheId!=null?objInfo.manicheId:'');
                $("#validateDetailOrderDealForm #manicheName2").val(objInfo.manicheName!=null?objInfo.manicheName:'');
                $("#validateDetailOrderDealForm #areaName2").val(objInfo.areaName!=null?objInfo.areaName:'');
                $("#validateDetailOrderDealForm #areaId2").val(objInfo.areaId!=null?objInfo.areaId:'');
                $("#validateDetailOrderDealForm #unversityName2").val(objInfo.unversityName!=null?objInfo.unversityName:'');
                $("#validateDetailOrderDealForm #universityId2").val(objInfo.universityId!=null?objInfo.universityId:'');
                $("#validateDetailOrderDealForm #createTime2").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateDetailOrderDealForm #createUser2").val(objInfo.createUser!=null?objInfo.createUser:'');
                $("#validateDetailOrderDealForm #updateTime2").val(objInfo.updateTime!=null?objInfo.updateTime:'');
                $("#validateDetailOrderDealForm #updateUser2").val(objInfo.updateUser!=null?objInfo.updateUser:'');
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
function delOrderDeal(id_key){
    layer.confirm('是否删除？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        var url=webUrl+"/orderDeal/del.dhtml";
        var params={};
        var currentPage= $("#queryOrderDealcurrentPage").val();
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
                    searchOrderDeal(currentPage);
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



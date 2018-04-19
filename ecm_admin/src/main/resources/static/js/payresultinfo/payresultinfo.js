$(function(){
    searchPayResultInfo('');
    $('#queryPayResultInfopageSize').on('change',function () {
        var currentPage = $("#queryPayResultInfocurrentPage").val();
        searchPayResultInfo(currentPage);
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
    $('#updatePayResultInfo').on('shown.bs.modal', function () {
        $('#validateUpdatePayResultInfoForm').bootstrapValidator('resetForm', false);
    });

    //增加支付结果通知表校验
    $('#validateAddPayResultInfoForm').bootstrapValidator({
        fields : {
            id1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            appid1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            mchId1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            deviceInfo1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            nonceStr1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            sign1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            signType1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            resultCode1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            errCode1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            errCodeDes1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            openid1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            isSubscribe1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            tradeType1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            bankType1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            totalFee1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            settlementTotalFee1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            feeType1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            cashFee1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            cashFeeType1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            couponFee1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            couponCount1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            couponType1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            couponId1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            couponFeeOne1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            transactionIdtransactionId1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            outTradeNo1 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            timeEnd1 : {
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
         addPayResultInfo();
     });

    //修改支付结果通知表校验
    $('#validateUpdatePayResultInfoForm').bootstrapValidator({
        fields : {
            id3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            appid3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            mchId3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            deviceInfo3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            nonceStr3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            sign3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            signType3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            resultCode3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            errCode3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            errCodeDes3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            openid3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            isSubscribe3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            tradeType3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            bankType3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            totalFee3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            settlementTotalFee3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            feeType3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            cashFee3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            cashFeeType3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            couponFee3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            couponCount3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            couponType3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            couponId3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            couponFeeOne3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            transactionIdtransactionId3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            outTradeNo3 : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"notEmpty":{"message":"不可以为空"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            timeEnd3 : {
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
         updatePayResultInfo();
     });
    //查询支付结果通知表校验
    $('#queryPayResultInfoForm').bootstrapValidator({
        fields : {
            id : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            appid : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            mchId : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            deviceInfo : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            nonceStr : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            sign : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            signType : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            resultCode : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            errCode : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            errCodeDes : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            openid : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            isSubscribe : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            tradeType : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            bankType : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            totalFee : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            settlementTotalFee : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            feeType : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            cashFee : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            cashFeeType : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            couponFee : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            couponCount : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            couponType : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            couponId : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            couponFeeOne : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            transactionIdtransactionId : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            outTradeNo : {
                validators : {"regexp":{"regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9]*$","message":"不符合规则"},"stringLength":{"min":0,"max":999,"message":"长度不正确"}}
            }
            ,
            timeEnd : {
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

function searchPayResultInfo(currentPage,queryType,fileName,exportParam){
    //没有bootstrapvalidator，则返回
    if($('#queryPayResultInfoForm').data('bootstrapValidator')!=null) {
        //对查询框进行校验
        $('#queryPayResultInfoForm').data('bootstrapValidator').validate();
        //校验没有通过，则返回
        if(!$('#queryPayResultInfoForm').data('bootstrapValidator').isValid()){
            return;
        }
        //----个性化校验示例开始
        //if($('#query"+cleanentityClassName+"Form #被验证组件name').val()=='#'){
        //    layer.alert('XX禁止查询')
        //    //第三个参数为，显示的错误信息所属的validator规则
        //    $('#queryPayResultInfoForm').data('bootstrapValidator').updateStatus('被验证组件name','INVALID','stringLength');
        //    return;
        //}
        //----个性化校验示例结束
    }
    var params ={};
    if(currentPage == "undefined" || currentPage =="" || currentPage == null){
        var currentPage_text = $("#queryPayResultInfocurrentPage").val();
        if(currentPage_text =="undefined" || currentPage_text =="" || currentPage_text == null){
            currentPage_text = "1";
        }
        params.startIndex = currentPage_text;
    }else{
        params.startIndex = currentPage;
    }

    var pageSize= $("#queryPayResultInfopageSize").val();
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

    params.id = $("#queryPayResultInfoForm #id").val();
    params.appid = $("#queryPayResultInfoForm #appid").val();
    params.mchId = $("#queryPayResultInfoForm #mchId").val();
    params.deviceInfo = $("#queryPayResultInfoForm #deviceInfo").val();
    params.nonceStr = $("#queryPayResultInfoForm #nonceStr").val();
    params.sign = $("#queryPayResultInfoForm #sign").val();
    params.signType = $("#queryPayResultInfoForm #signType").val();
    params.resultCode = $("#queryPayResultInfoForm #resultCode").val();
    params.errCode = $("#queryPayResultInfoForm #errCode").val();
    params.errCodeDes = $("#queryPayResultInfoForm #errCodeDes").val();
    params.openid = $("#queryPayResultInfoForm #openid").val();
    params.isSubscribe = $("#queryPayResultInfoForm #isSubscribe").val();
    params.tradeType = $("#queryPayResultInfoForm #tradeType").val();
    params.bankType = $("#queryPayResultInfoForm #bankType").val();
    params.totalFee = $("#queryPayResultInfoForm #totalFee").val();
    params.settlementTotalFee = $("#queryPayResultInfoForm #settlementTotalFee").val();
    params.feeType = $("#queryPayResultInfoForm #feeType").val();
    params.cashFee = $("#queryPayResultInfoForm #cashFee").val();
    params.cashFeeType = $("#queryPayResultInfoForm #cashFeeType").val();
    params.couponFee = $("#queryPayResultInfoForm #couponFee").val();
    params.couponCount = $("#queryPayResultInfoForm #couponCount").val();
    params.couponType = $("#queryPayResultInfoForm #couponType").val();
    params.couponId = $("#queryPayResultInfoForm #couponId").val();
    params.couponFeeOne = $("#queryPayResultInfoForm #couponFeeOne").val();
    params.transactionIdtransactionId = $("#queryPayResultInfoForm #transactionIdtransactionId").val();
    params.outTradeNo = $("#queryPayResultInfoForm #outTradeNo").val();
    params.timeEnd = $("#queryPayResultInfoForm #timeEnd").val();
    params.createTime = $("#queryPayResultInfoForm #createTime").val();
    params.createUser = $("#queryPayResultInfoForm #createUser").val();

    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    jsonStr = encodeURIComponent(jsonStr);
    if(queryType!=undefined && queryType =='download'){
        window.location.href=webUrl+"/payResultInfo/search.dhtml?jsonStr="+jsonStr+"&v="+Math.random();
        return;
    }
    
    $.ajax({
        type:"POST",
        url:webUrl+"/payResultInfo/search.dhtml",
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $("#payResultInfoTR_FIRST").siblings().remove();
                var  resultList=data.rows[0].pageRecords;

                //分页
                $("#queryPayResultInfocurrentPage").val(data.rows[0].startIndex);
                $("#queryPayResultInfototalPage").val(data.rows[0].totalPage);
                $("#queryPayResultInfopageSize").val(data.rows[0].pageSize);
                for(var i=0;i<resultList.length;i++){
                    var payResultInfoTr = $("<tr class=\"payResultInfoTr\"></tr>");
                    $("#payResultInfoTR_FIRST").parent().append(payResultInfoTr);
                    payResultInfoTr.append("<td><input style=\"width:23px;\" type=\"checkbox\"/></td><td>"+(i+1)+"</td>")
                    .append("<td>"+resultList[i].id+"</td>")
                    .append("<td>"+resultList[i].appid+"</td>")
                    .append("<td>"+resultList[i].mchId+"</td>")
                    .append("<td>"+resultList[i].deviceInfo+"</td>")
                    .append("<td>"+resultList[i].nonceStr+"</td>")
                    .append("<td>"+resultList[i].sign+"</td>")
                    .append("<td>"+resultList[i].signType+"</td>")
                    .append("<td>"+resultList[i].resultCode+"</td>")
                    .append("<td>"+resultList[i].errCode+"</td>")
                    .append("<td>"+resultList[i].errCodeDes+"</td>")
                    .append("<td>"+resultList[i].openid+"</td>")
                    .append("<td>"+resultList[i].isSubscribe+"</td>")
                    .append("<td>"+resultList[i].tradeType+"</td>")
                    .append("<td>"+resultList[i].bankType+"</td>")
                    .append("<td>"+resultList[i].totalFee+"</td>")
                    .append("<td>"+resultList[i].settlementTotalFee+"</td>")
                    .append("<td>"+resultList[i].feeType+"</td>")
                    .append("<td>"+resultList[i].cashFee+"</td>")
                    .append("<td>"+resultList[i].cashFeeType+"</td>")
                    .append("<td>"+resultList[i].couponFee+"</td>")
                    .append("<td>"+resultList[i].couponCount+"</td>")
                    .append("<td>"+resultList[i].couponType+"</td>")
                    .append("<td>"+resultList[i].couponId+"</td>")
                    .append("<td>"+resultList[i].couponFeeOne+"</td>")
                    .append("<td>"+resultList[i].transactionIdtransactionId+"</td>")
                    .append("<td>"+resultList[i].outTradeNo+"</td>")
                    .append("<td>"+resultList[i].timeEnd+"</td>")
                    .append("<td>"+resultList[i].createTime+"</td>")
                    .append("<td>"+resultList[i].createUser+"</td>")
                    .append("<td class=\"operateTbl\"><button class=\"btn btn-default btn-sm\" onclick=\"return editPayResultInfo('"+resultList[i].id+"');\"><i class=\"fa fa-edit\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return  delPayResultInfo('"+resultList[i].id+"');\"><i class=\"fa fa-trash-o\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return queryPayResultInfoObject('"+resultList[i].id+"');\"><i class=\"fa fa-search\"></i></button></td>");
                }
                var currentPage = Number($("#queryPayResultInfocurrentPage").val());
                var totalPage   = Number($("#queryPayResultInfototalPage").val());
                var pageSize    = Number($("#queryPayResultInfopageSize").val());
                $("#queryPayResultInfo_fy .pager").ucPager({
                    currentPage : currentPage,
                    totalPage : totalPage,
                    pageSize : pageSize,
                    clickCallback: queryPayResultInfogopage
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

function queryPayResultInfogopage(currentPage) {
    searchPayResultInfo(currentPage);
}

function addPayResultInfo(){
    var url=webUrl+"/payResultInfo/insert.dhtml";
    var params={};
    params.id = $("#validateAddPayResultInfoForm #id1").val();
    params.appid = $("#validateAddPayResultInfoForm #appid1").val();
    params.mchId = $("#validateAddPayResultInfoForm #mchId1").val();
    params.deviceInfo = $("#validateAddPayResultInfoForm #deviceInfo1").val();
    params.nonceStr = $("#validateAddPayResultInfoForm #nonceStr1").val();
    params.sign = $("#validateAddPayResultInfoForm #sign1").val();
    params.signType = $("#validateAddPayResultInfoForm #signType1").val();
    params.resultCode = $("#validateAddPayResultInfoForm #resultCode1").val();
    params.errCode = $("#validateAddPayResultInfoForm #errCode1").val();
    params.errCodeDes = $("#validateAddPayResultInfoForm #errCodeDes1").val();
    params.openid = $("#validateAddPayResultInfoForm #openid1").val();
    params.isSubscribe = $("#validateAddPayResultInfoForm #isSubscribe1").val();
    params.tradeType = $("#validateAddPayResultInfoForm #tradeType1").val();
    params.bankType = $("#validateAddPayResultInfoForm #bankType1").val();
    params.totalFee = $("#validateAddPayResultInfoForm #totalFee1").val();
    params.settlementTotalFee = $("#validateAddPayResultInfoForm #settlementTotalFee1").val();
    params.feeType = $("#validateAddPayResultInfoForm #feeType1").val();
    params.cashFee = $("#validateAddPayResultInfoForm #cashFee1").val();
    params.cashFeeType = $("#validateAddPayResultInfoForm #cashFeeType1").val();
    params.couponFee = $("#validateAddPayResultInfoForm #couponFee1").val();
    params.couponCount = $("#validateAddPayResultInfoForm #couponCount1").val();
    params.couponType = $("#validateAddPayResultInfoForm #couponType1").val();
    params.couponId = $("#validateAddPayResultInfoForm #couponId1").val();
    params.couponFeeOne = $("#validateAddPayResultInfoForm #couponFeeOne1").val();
    params.transactionIdtransactionId = $("#validateAddPayResultInfoForm #transactionIdtransactionId1").val();
    params.outTradeNo = $("#validateAddPayResultInfoForm #outTradeNo1").val();
    params.timeEnd = $("#validateAddPayResultInfoForm #timeEnd1").val();
    params.createTime = $("#validateAddPayResultInfoForm #createTime1").val();
    params.createUser = $("#validateAddPayResultInfoForm #createUser1").val();
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
                $('#addPayResultInfo').modal('hide');
                searchPayResultInfo('');
                layer.msg('添加成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateAddPayResultInfoForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateAddPayResultInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
                $('#validateAddPayResultInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateAddPayResultInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function updatePayResultInfo(){
    var url=webUrl+"/payResultInfo/edit.dhtml";
    var params={};
    params.id_key = $("#validateUpdatePayResultInfoForm #id_key").val();
    params.id = $("#validateUpdatePayResultInfoForm #id3").val();
    params.appid = $("#validateUpdatePayResultInfoForm #appid3").val();
    params.mchId = $("#validateUpdatePayResultInfoForm #mchId3").val();
    params.deviceInfo = $("#validateUpdatePayResultInfoForm #deviceInfo3").val();
    params.nonceStr = $("#validateUpdatePayResultInfoForm #nonceStr3").val();
    params.sign = $("#validateUpdatePayResultInfoForm #sign3").val();
    params.signType = $("#validateUpdatePayResultInfoForm #signType3").val();
    params.resultCode = $("#validateUpdatePayResultInfoForm #resultCode3").val();
    params.errCode = $("#validateUpdatePayResultInfoForm #errCode3").val();
    params.errCodeDes = $("#validateUpdatePayResultInfoForm #errCodeDes3").val();
    params.openid = $("#validateUpdatePayResultInfoForm #openid3").val();
    params.isSubscribe = $("#validateUpdatePayResultInfoForm #isSubscribe3").val();
    params.tradeType = $("#validateUpdatePayResultInfoForm #tradeType3").val();
    params.bankType = $("#validateUpdatePayResultInfoForm #bankType3").val();
    params.totalFee = $("#validateUpdatePayResultInfoForm #totalFee3").val();
    params.settlementTotalFee = $("#validateUpdatePayResultInfoForm #settlementTotalFee3").val();
    params.feeType = $("#validateUpdatePayResultInfoForm #feeType3").val();
    params.cashFee = $("#validateUpdatePayResultInfoForm #cashFee3").val();
    params.cashFeeType = $("#validateUpdatePayResultInfoForm #cashFeeType3").val();
    params.couponFee = $("#validateUpdatePayResultInfoForm #couponFee3").val();
    params.couponCount = $("#validateUpdatePayResultInfoForm #couponCount3").val();
    params.couponType = $("#validateUpdatePayResultInfoForm #couponType3").val();
    params.couponId = $("#validateUpdatePayResultInfoForm #couponId3").val();
    params.couponFeeOne = $("#validateUpdatePayResultInfoForm #couponFeeOne3").val();
    params.transactionIdtransactionId = $("#validateUpdatePayResultInfoForm #transactionIdtransactionId3").val();
    params.outTradeNo = $("#validateUpdatePayResultInfoForm #outTradeNo3").val();
    params.timeEnd = $("#validateUpdatePayResultInfoForm #timeEnd3").val();
    params.createTime = $("#validateUpdatePayResultInfoForm #createTime3").val();
    params.createUser = $("#validateUpdatePayResultInfoForm #createUser3").val();
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
                $('#updatePayResultInfo').modal('hide');
                searchPayResultInfo('');
                layer.msg('修改成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateUpdatePayResultInfoForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateUpdatePayResultInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
            $('#validateUpdatePayResultInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateUpdatePayResultInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function editPayResultInfo(id_key){
    var url=webUrl+"/payResultInfo/queryObject.dhtml";
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
                $('#updatePayResultInfo').modal();
                $("#validateUpdatePayResultInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblPayResultInfo;
                $("#validateUpdatePayResultInfoForm #id3").val(objInfo.id!=null?objInfo.id:'');
                $("#validateUpdatePayResultInfoForm #appid3").val(objInfo.appid!=null?objInfo.appid:'');
                $("#validateUpdatePayResultInfoForm #mchId3").val(objInfo.mchId!=null?objInfo.mchId:'');
                $("#validateUpdatePayResultInfoForm #deviceInfo3").val(objInfo.deviceInfo!=null?objInfo.deviceInfo:'');
                $("#validateUpdatePayResultInfoForm #nonceStr3").val(objInfo.nonceStr!=null?objInfo.nonceStr:'');
                $("#validateUpdatePayResultInfoForm #sign3").val(objInfo.sign!=null?objInfo.sign:'');
                $("#validateUpdatePayResultInfoForm #signType3").val(objInfo.signType!=null?objInfo.signType:'');
                $("#validateUpdatePayResultInfoForm #resultCode3").val(objInfo.resultCode!=null?objInfo.resultCode:'');
                $("#validateUpdatePayResultInfoForm #errCode3").val(objInfo.errCode!=null?objInfo.errCode:'');
                $("#validateUpdatePayResultInfoForm #errCodeDes3").val(objInfo.errCodeDes!=null?objInfo.errCodeDes:'');
                $("#validateUpdatePayResultInfoForm #openid3").val(objInfo.openid!=null?objInfo.openid:'');
                $("#validateUpdatePayResultInfoForm #isSubscribe3").val(objInfo.isSubscribe!=null?objInfo.isSubscribe:'');
                $("#validateUpdatePayResultInfoForm #tradeType3").val(objInfo.tradeType!=null?objInfo.tradeType:'');
                $("#validateUpdatePayResultInfoForm #bankType3").val(objInfo.bankType!=null?objInfo.bankType:'');
                $("#validateUpdatePayResultInfoForm #totalFee3").val(objInfo.totalFee!=null?objInfo.totalFee:'');
                $("#validateUpdatePayResultInfoForm #settlementTotalFee3").val(objInfo.settlementTotalFee!=null?objInfo.settlementTotalFee:'');
                $("#validateUpdatePayResultInfoForm #feeType3").val(objInfo.feeType!=null?objInfo.feeType:'');
                $("#validateUpdatePayResultInfoForm #cashFee3").val(objInfo.cashFee!=null?objInfo.cashFee:'');
                $("#validateUpdatePayResultInfoForm #cashFeeType3").val(objInfo.cashFeeType!=null?objInfo.cashFeeType:'');
                $("#validateUpdatePayResultInfoForm #couponFee3").val(objInfo.couponFee!=null?objInfo.couponFee:'');
                $("#validateUpdatePayResultInfoForm #couponCount3").val(objInfo.couponCount!=null?objInfo.couponCount:'');
                $("#validateUpdatePayResultInfoForm #couponType3").val(objInfo.couponType!=null?objInfo.couponType:'');
                $("#validateUpdatePayResultInfoForm #couponId3").val(objInfo.couponId!=null?objInfo.couponId:'');
                $("#validateUpdatePayResultInfoForm #couponFeeOne3").val(objInfo.couponFeeOne!=null?objInfo.couponFeeOne:'');
                $("#validateUpdatePayResultInfoForm #transactionIdtransactionId3").val(objInfo.transactionIdtransactionId!=null?objInfo.transactionIdtransactionId:'');
                $("#validateUpdatePayResultInfoForm #outTradeNo3").val(objInfo.outTradeNo!=null?objInfo.outTradeNo:'');
                $("#validateUpdatePayResultInfoForm #timeEnd3").val(objInfo.timeEnd!=null?objInfo.timeEnd:'');
                $("#validateUpdatePayResultInfoForm #createTime3").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateUpdatePayResultInfoForm #createUser3").val(objInfo.createUser!=null?objInfo.createUser:'');
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

function queryPayResultInfoObject(id_key){
    var url=webUrl+"/payResultInfo/queryObject.dhtml";
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
                $('#detailPayResultInfo').modal();
                $("#validateDetailPayResultInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblPayResultInfo;
                $("#validateDetailPayResultInfoForm #id2").val(objInfo.id!=null?objInfo.id:'');
                $("#validateDetailPayResultInfoForm #appid2").val(objInfo.appid!=null?objInfo.appid:'');
                $("#validateDetailPayResultInfoForm #mchId2").val(objInfo.mchId!=null?objInfo.mchId:'');
                $("#validateDetailPayResultInfoForm #deviceInfo2").val(objInfo.deviceInfo!=null?objInfo.deviceInfo:'');
                $("#validateDetailPayResultInfoForm #nonceStr2").val(objInfo.nonceStr!=null?objInfo.nonceStr:'');
                $("#validateDetailPayResultInfoForm #sign2").val(objInfo.sign!=null?objInfo.sign:'');
                $("#validateDetailPayResultInfoForm #signType2").val(objInfo.signType!=null?objInfo.signType:'');
                $("#validateDetailPayResultInfoForm #resultCode2").val(objInfo.resultCode!=null?objInfo.resultCode:'');
                $("#validateDetailPayResultInfoForm #errCode2").val(objInfo.errCode!=null?objInfo.errCode:'');
                $("#validateDetailPayResultInfoForm #errCodeDes2").val(objInfo.errCodeDes!=null?objInfo.errCodeDes:'');
                $("#validateDetailPayResultInfoForm #openid2").val(objInfo.openid!=null?objInfo.openid:'');
                $("#validateDetailPayResultInfoForm #isSubscribe2").val(objInfo.isSubscribe!=null?objInfo.isSubscribe:'');
                $("#validateDetailPayResultInfoForm #tradeType2").val(objInfo.tradeType!=null?objInfo.tradeType:'');
                $("#validateDetailPayResultInfoForm #bankType2").val(objInfo.bankType!=null?objInfo.bankType:'');
                $("#validateDetailPayResultInfoForm #totalFee2").val(objInfo.totalFee!=null?objInfo.totalFee:'');
                $("#validateDetailPayResultInfoForm #settlementTotalFee2").val(objInfo.settlementTotalFee!=null?objInfo.settlementTotalFee:'');
                $("#validateDetailPayResultInfoForm #feeType2").val(objInfo.feeType!=null?objInfo.feeType:'');
                $("#validateDetailPayResultInfoForm #cashFee2").val(objInfo.cashFee!=null?objInfo.cashFee:'');
                $("#validateDetailPayResultInfoForm #cashFeeType2").val(objInfo.cashFeeType!=null?objInfo.cashFeeType:'');
                $("#validateDetailPayResultInfoForm #couponFee2").val(objInfo.couponFee!=null?objInfo.couponFee:'');
                $("#validateDetailPayResultInfoForm #couponCount2").val(objInfo.couponCount!=null?objInfo.couponCount:'');
                $("#validateDetailPayResultInfoForm #couponType2").val(objInfo.couponType!=null?objInfo.couponType:'');
                $("#validateDetailPayResultInfoForm #couponId2").val(objInfo.couponId!=null?objInfo.couponId:'');
                $("#validateDetailPayResultInfoForm #couponFeeOne2").val(objInfo.couponFeeOne!=null?objInfo.couponFeeOne:'');
                $("#validateDetailPayResultInfoForm #transactionIdtransactionId2").val(objInfo.transactionIdtransactionId!=null?objInfo.transactionIdtransactionId:'');
                $("#validateDetailPayResultInfoForm #outTradeNo2").val(objInfo.outTradeNo!=null?objInfo.outTradeNo:'');
                $("#validateDetailPayResultInfoForm #timeEnd2").val(objInfo.timeEnd!=null?objInfo.timeEnd:'');
                $("#validateDetailPayResultInfoForm #createTime2").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateDetailPayResultInfoForm #createUser2").val(objInfo.createUser!=null?objInfo.createUser:'');
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
function delPayResultInfo(id_key){
    layer.confirm('是否删除？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        var url=webUrl+"/payResultInfo/del.dhtml";
        var params={};
        var currentPage= $("#queryPayResultInfocurrentPage").val();
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
                    searchPayResultInfo(currentPage);
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



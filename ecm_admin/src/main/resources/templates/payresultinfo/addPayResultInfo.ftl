<#import "/component/register.ftl" as  register/>

<#macro addPayResultInfoHtml>
    <div class="modal fade" id="addPayResultInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateAddPayResultInfoForm" method="post" class="form-horizontal">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">新增支付结果通知表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>id：</label>
                            <div class="col-lg-9">
                                <input id="id1" name="id1"  class="form-control" placeholder="id" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>公众账号ID：</label>
                            <div class="col-lg-9">
                                <input id="appid1" name="appid1"  class="form-control" placeholder="公众账号ID" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>商户号：</label>
                            <div class="col-lg-9">
                                <input id="mchId1" name="mchId1"  class="form-control" placeholder="商户号" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>设备号：</label>
                            <div class="col-lg-9">
                                <input id="deviceInfo1" name="deviceInfo1"  class="form-control" placeholder="设备号" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>随机字符串：</label>
                            <div class="col-lg-9">
                                <input id="nonceStr1" name="nonceStr1"  class="form-control" placeholder="随机字符串" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>签名：</label>
                            <div class="col-lg-9">
                                <input id="sign1" name="sign1"  class="form-control" placeholder="签名" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>签名类型：</label>
                            <div class="col-lg-9">
                                <input id="signType1" name="signType1"  class="form-control" placeholder="签名类型" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>支付结果：</label>
                            <div class="col-lg-9">
                                <input id="resultCode1" name="resultCode1"  class="form-control" placeholder="支付结果" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>错误代码：</label>
                            <div class="col-lg-9">
                                <input id="errCode1" name="errCode1"  class="form-control" placeholder="错误代码" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>错误代码描述：</label>
                            <div class="col-lg-9">
                                <input id="errCodeDes1" name="errCodeDes1"  class="form-control" placeholder="错误代码描述" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户标识ID：</label>
                            <div class="col-lg-9">
                                <input id="openid1" name="openid1"  class="form-control" placeholder="用户标识ID" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>是否关注公众账号：</label>
                            <div class="col-lg-9">
                                <input id="isSubscribe1" name="isSubscribe1"  class="form-control" placeholder="是否关注公众账号" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>交易类型：</label>
                            <div class="col-lg-9">
                                <input id="tradeType1" name="tradeType1"  class="form-control" placeholder="交易类型" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>付款银行：</label>
                            <div class="col-lg-9">
                                <input id="bankType1" name="bankType1"  class="form-control" placeholder="付款银行" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>订单金额：</label>
                            <div class="col-lg-9">
                                <input id="totalFee1" name="totalFee1"  class="form-control" placeholder="订单金额" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>应结订单金额：</label>
                            <div class="col-lg-9">
                                <input id="settlementTotalFee1" name="settlementTotalFee1"  class="form-control" placeholder="应结订单金额" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>货币种类：</label>
                            <div class="col-lg-9">
                                <input id="feeType1" name="feeType1"  class="form-control" placeholder="货币种类" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>现金支付金额：</label>
                            <div class="col-lg-9">
                                <input id="cashFee1" name="cashFee1"  class="form-control" placeholder="现金支付金额" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>现金支付货币类型：</label>
                            <div class="col-lg-9">
                                <input id="cashFeeType1" name="cashFeeType1"  class="form-control" placeholder="现金支付货币类型" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>总代金券金额：</label>
                            <div class="col-lg-9">
                                <input id="couponFee1" name="couponFee1"  class="form-control" placeholder="总代金券金额" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>代金券使用数量：</label>
                            <div class="col-lg-9">
                                <input id="couponCount1" name="couponCount1"  class="form-control" placeholder="代金券使用数量" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>代金券类型：</label>
                            <div class="col-lg-9">
                                <input id="couponType1" name="couponType1"  class="form-control" placeholder="代金券类型" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>代金券ID：</label>
                            <div class="col-lg-9">
                                <input id="couponId1" name="couponId1"  class="form-control" placeholder="代金券ID" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>单个代金券支付金额：</label>
                            <div class="col-lg-9">
                                <input id="couponFeeOne1" name="couponFeeOne1"  class="form-control" placeholder="单个代金券支付金额" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>微信支付订单号：</label>
                            <div class="col-lg-9">
                                <input id="transactionIdtransactionId1" name="transactionIdtransactionId1"  class="form-control" placeholder="微信支付订单号" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>商户订单号：</label>
                            <div class="col-lg-9">
                                <input id="outTradeNo1" name="outTradeNo1"  class="form-control" placeholder="商户订单号" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>支付完成时间：</label>
                            <div class="col-lg-9">
                                <input id="timeEnd1" name="timeEnd1"  class="form-control" placeholder="支付完成时间" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>创建时间：</label>
                            <div class="col-lg-9">
                                <input id="createTime1" name="createTime1"  class="form-control" placeholder="创建时间" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>创建人：</label>
                            <div class="col-lg-9">
                                <input id="createUser1" name="createUser1"  class="form-control" placeholder="创建人" type="text"/>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">提交</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</#macro>



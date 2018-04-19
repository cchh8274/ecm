<#import "/component/register.ftl" as  register/>

<#macro updatePayResultInfoHtml>
    <div class="modal fade" id="updatePayResultInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateUpdatePayResultInfoForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">修改支付结果通知表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>id：</label>
                            <div class="col-lg-9">
                                <input id="id3" name="id3"  class="form-control" placeholder="id" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>公众账号ID：</label>
                            <div class="col-lg-9">
                                <input id="appid3" name="appid3"  class="form-control" placeholder="公众账号ID" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>商户号：</label>
                            <div class="col-lg-9">
                                <input id="mchId3" name="mchId3"  class="form-control" placeholder="商户号" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>设备号：</label>
                            <div class="col-lg-9">
                                <input id="deviceInfo3" name="deviceInfo3"  class="form-control" placeholder="设备号" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>随机字符串：</label>
                            <div class="col-lg-9">
                                <input id="nonceStr3" name="nonceStr3"  class="form-control" placeholder="随机字符串" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>签名：</label>
                            <div class="col-lg-9">
                                <input id="sign3" name="sign3"  class="form-control" placeholder="签名" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>签名类型：</label>
                            <div class="col-lg-9">
                                <input id="signType3" name="signType3"  class="form-control" placeholder="签名类型" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>支付结果：</label>
                            <div class="col-lg-9">
                                <input id="resultCode3" name="resultCode3"  class="form-control" placeholder="支付结果" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>错误代码：</label>
                            <div class="col-lg-9">
                                <input id="errCode3" name="errCode3"  class="form-control" placeholder="错误代码" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>错误代码描述：</label>
                            <div class="col-lg-9">
                                <input id="errCodeDes3" name="errCodeDes3"  class="form-control" placeholder="错误代码描述" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户标识ID：</label>
                            <div class="col-lg-9">
                                <input id="openid3" name="openid3"  class="form-control" placeholder="用户标识ID" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>是否关注公众账号：</label>
                            <div class="col-lg-9">
                                <input id="isSubscribe3" name="isSubscribe3"  class="form-control" placeholder="是否关注公众账号" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>交易类型：</label>
                            <div class="col-lg-9">
                                <input id="tradeType3" name="tradeType3"  class="form-control" placeholder="交易类型" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>付款银行：</label>
                            <div class="col-lg-9">
                                <input id="bankType3" name="bankType3"  class="form-control" placeholder="付款银行" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>订单金额：</label>
                            <div class="col-lg-9">
                                <input id="totalFee3" name="totalFee3"  class="form-control" placeholder="订单金额" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>应结订单金额：</label>
                            <div class="col-lg-9">
                                <input id="settlementTotalFee3" name="settlementTotalFee3"  class="form-control" placeholder="应结订单金额" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>货币种类：</label>
                            <div class="col-lg-9">
                                <input id="feeType3" name="feeType3"  class="form-control" placeholder="货币种类" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>现金支付金额：</label>
                            <div class="col-lg-9">
                                <input id="cashFee3" name="cashFee3"  class="form-control" placeholder="现金支付金额" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>现金支付货币类型：</label>
                            <div class="col-lg-9">
                                <input id="cashFeeType3" name="cashFeeType3"  class="form-control" placeholder="现金支付货币类型" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>总代金券金额：</label>
                            <div class="col-lg-9">
                                <input id="couponFee3" name="couponFee3"  class="form-control" placeholder="总代金券金额" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>代金券使用数量：</label>
                            <div class="col-lg-9">
                                <input id="couponCount3" name="couponCount3"  class="form-control" placeholder="代金券使用数量" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>代金券类型：</label>
                            <div class="col-lg-9">
                                <input id="couponType3" name="couponType3"  class="form-control" placeholder="代金券类型" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>代金券ID：</label>
                            <div class="col-lg-9">
                                <input id="couponId3" name="couponId3"  class="form-control" placeholder="代金券ID" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>单个代金券支付金额：</label>
                            <div class="col-lg-9">
                                <input id="couponFeeOne3" name="couponFeeOne3"  class="form-control" placeholder="单个代金券支付金额" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>微信支付订单号：</label>
                            <div class="col-lg-9">
                                <input id="transactionIdtransactionId3" name="transactionIdtransactionId3"  class="form-control" placeholder="微信支付订单号" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>商户订单号：</label>
                            <div class="col-lg-9">
                                <input id="outTradeNo3" name="outTradeNo3"  class="form-control" placeholder="商户订单号" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>支付完成时间：</label>
                            <div class="col-lg-9">
                                <input id="timeEnd3" name="timeEnd3"  class="form-control" placeholder="支付完成时间" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>创建时间：</label>
                            <div class="col-lg-9">
                                <input id="createTime3" name="createTime3"  class="form-control" placeholder="创建时间" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>创建人：</label>
                            <div class="col-lg-9">
                                <input id="createUser3" name="createUser3"  class="form-control" placeholder="创建人" type="text" />
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">提交更改</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</#macro>




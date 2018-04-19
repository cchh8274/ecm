<#import "/component/register.ftl" as  register/>

<#macro detailPayResultInfoHtml>
    <div class="modal fade" id="detailPayResultInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateDetailPayResultInfoForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">查看支付结果通知表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title">id：</label>
                            <div class="col-lg-9">
                                <input id="id2" name="id2"  class="form-control" placeholder="id" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">公众账号ID：</label>
                            <div class="col-lg-9">
                                <input id="appid2" name="appid2"  class="form-control" placeholder="公众账号ID" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">商户号：</label>
                            <div class="col-lg-9">
                                <input id="mchId2" name="mchId2"  class="form-control" placeholder="商户号" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">设备号：</label>
                            <div class="col-lg-9">
                                <input id="deviceInfo2" name="deviceInfo2"  class="form-control" placeholder="设备号" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">随机字符串：</label>
                            <div class="col-lg-9">
                                <input id="nonceStr2" name="nonceStr2"  class="form-control" placeholder="随机字符串" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">签名：</label>
                            <div class="col-lg-9">
                                <input id="sign2" name="sign2"  class="form-control" placeholder="签名" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">签名类型：</label>
                            <div class="col-lg-9">
                                <input id="signType2" name="signType2"  class="form-control" placeholder="签名类型" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">支付结果：</label>
                            <div class="col-lg-9">
                                <input id="resultCode2" name="resultCode2"  class="form-control" placeholder="支付结果" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">错误代码：</label>
                            <div class="col-lg-9">
                                <input id="errCode2" name="errCode2"  class="form-control" placeholder="错误代码" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">错误代码描述：</label>
                            <div class="col-lg-9">
                                <input id="errCodeDes2" name="errCodeDes2"  class="form-control" placeholder="错误代码描述" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">用户标识ID：</label>
                            <div class="col-lg-9">
                                <input id="openid2" name="openid2"  class="form-control" placeholder="用户标识ID" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">是否关注公众账号：</label>
                            <div class="col-lg-9">
                                <input id="isSubscribe2" name="isSubscribe2"  class="form-control" placeholder="是否关注公众账号" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">交易类型：</label>
                            <div class="col-lg-9">
                                <input id="tradeType2" name="tradeType2"  class="form-control" placeholder="交易类型" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">付款银行：</label>
                            <div class="col-lg-9">
                                <input id="bankType2" name="bankType2"  class="form-control" placeholder="付款银行" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">订单金额：</label>
                            <div class="col-lg-9">
                                <input id="totalFee2" name="totalFee2"  class="form-control" placeholder="订单金额" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">应结订单金额：</label>
                            <div class="col-lg-9">
                                <input id="settlementTotalFee2" name="settlementTotalFee2"  class="form-control" placeholder="应结订单金额" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">货币种类：</label>
                            <div class="col-lg-9">
                                <input id="feeType2" name="feeType2"  class="form-control" placeholder="货币种类" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">现金支付金额：</label>
                            <div class="col-lg-9">
                                <input id="cashFee2" name="cashFee2"  class="form-control" placeholder="现金支付金额" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">现金支付货币类型：</label>
                            <div class="col-lg-9">
                                <input id="cashFeeType2" name="cashFeeType2"  class="form-control" placeholder="现金支付货币类型" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">总代金券金额：</label>
                            <div class="col-lg-9">
                                <input id="couponFee2" name="couponFee2"  class="form-control" placeholder="总代金券金额" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">代金券使用数量：</label>
                            <div class="col-lg-9">
                                <input id="couponCount2" name="couponCount2"  class="form-control" placeholder="代金券使用数量" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">代金券类型：</label>
                            <div class="col-lg-9">
                                <input id="couponType2" name="couponType2"  class="form-control" placeholder="代金券类型" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">代金券ID：</label>
                            <div class="col-lg-9">
                                <input id="couponId2" name="couponId2"  class="form-control" placeholder="代金券ID" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">单个代金券支付金额：</label>
                            <div class="col-lg-9">
                                <input id="couponFeeOne2" name="couponFeeOne2"  class="form-control" placeholder="单个代金券支付金额" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">微信支付订单号：</label>
                            <div class="col-lg-9">
                                <input id="transactionIdtransactionId2" name="transactionIdtransactionId2"  class="form-control" placeholder="微信支付订单号" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">商户订单号：</label>
                            <div class="col-lg-9">
                                <input id="outTradeNo2" name="outTradeNo2"  class="form-control" placeholder="商户订单号" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">支付完成时间：</label>
                            <div class="col-lg-9">
                                <input id="timeEnd2" name="timeEnd2"  class="form-control" placeholder="支付完成时间" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">创建时间：</label>
                            <div class="col-lg-9">
                                <input id="createTime2" name="createTime2"  class="form-control" placeholder="创建时间" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">创建人：</label>
                            <div class="col-lg-9">
                                <input id="createUser2" name="createUser2"  class="form-control" placeholder="创建人" type="text" disabled="disabled"/>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</#macro>




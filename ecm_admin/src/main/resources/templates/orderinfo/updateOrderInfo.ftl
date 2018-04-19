<#import "/component/register.ftl" as  register/>

<#macro updateOrderInfoHtml>
    <div class="modal fade" id="updateOrderInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateUpdateOrderInfoForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">修改订单表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>id：</label>
                            <div class="col-lg-9">
                                <input id="id3" name="id3"  class="form-control" placeholder="id" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>订单号：</label>
                            <div class="col-lg-9">
                                <input id="orderNo3" name="orderNo3"  class="form-control" placeholder="订单号" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>商品描述：</label>
                            <div class="col-lg-9">
                                <input id="body3" name="body3"  class="form-control" placeholder="商品描述" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>商品详情：</label>
                            <div class="col-lg-9">
                                <input id="detail3" name="detail3"  class="form-control" placeholder="商品详情" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>名额数量：</label>
                            <div class="col-lg-9">
                                <input id="number3" name="number3"  class="form-control" placeholder="名额数量" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>名额单价：</label>
                            <div class="col-lg-9">
                                <input id="price3" name="price3"  class="form-control" placeholder="名额单价" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>总金额：</label>
                            <div class="col-lg-9">
                                <input id="totalFee3" name="totalFee3"  class="form-control" placeholder="总金额" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户IP地址：</label>
                            <div class="col-lg-9">
                                <input id="spbillCreateIp3" name="spbillCreateIp3"  class="form-control" placeholder="用户IP地址" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>交易起始时间：</label>
                            <div class="col-lg-9">
                                <input id="payStartTime3" name="payStartTime3"  class="form-control" placeholder="交易起始时间" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>交易结束时间：</label>
                            <div class="col-lg-9">
                                <input id="payEndTime3" name="payEndTime3"  class="form-control" placeholder="交易结束时间" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>goods_tag：</label>
                            <div class="col-lg-9">
                                <input id="goodsTag3" name="goodsTag3"  class="form-control" placeholder="goods_tag" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>购买用户ID：</label>
                            <div class="col-lg-9">
                                <input id="openid3" name="openid3"  class="form-control" placeholder="购买用户ID" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户微信名称：</label>
                            <div class="col-lg-9">
                                <input id="userName3" name="userName3"  class="form-control" placeholder="用户微信名称" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>支付完成时间：</label>
                            <div class="col-lg-9">
                                <input id="payTime3" name="payTime3"  class="form-control" placeholder="支付完成时间" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>支付状态：</label>
                            <div class="col-lg-9">
                                <input id="payStatus3" name="payStatus3"  class="form-control" placeholder="支付状态" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>机器ID：</label>
                            <div class="col-lg-9">
                                <input id="manicheId3" name="manicheId3"  class="form-control" placeholder="机器ID" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>机器名称：</label>
                            <div class="col-lg-9">
                                <input id="manicheName3" name="manicheName3"  class="form-control" placeholder="机器名称" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>区域名称：</label>
                            <div class="col-lg-9">
                                <input id="areaName3" name="areaName3"  class="form-control" placeholder="区域名称" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>区域ID：</label>
                            <div class="col-lg-9">
                                <input id="areaId3" name="areaId3"  class="form-control" placeholder="区域ID" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>大学名称：</label>
                            <div class="col-lg-9">
                                <input id="unversityName3" name="unversityName3"  class="form-control" placeholder="大学名称" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>大学ID：</label>
                            <div class="col-lg-9">
                                <input id="universityId3" name="universityId3"  class="form-control" placeholder="大学ID" type="text" />
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
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>修改时间：</label>
                            <div class="col-lg-9">
                                <input id="updateTime3" name="updateTime3"  class="form-control" placeholder="修改时间" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>修改人：</label>
                            <div class="col-lg-9">
                                <input id="updateUser3" name="updateUser3"  class="form-control" placeholder="修改人" type="text" />
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




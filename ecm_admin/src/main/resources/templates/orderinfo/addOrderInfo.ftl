<#import "/component/register.ftl" as  register/>

<#macro addOrderInfoHtml>
    <div class="modal fade" id="addOrderInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateAddOrderInfoForm" method="post" class="form-horizontal">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">新增订单表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>id：</label>
                            <div class="col-lg-9">
                                <input id="id1" name="id1"  class="form-control" placeholder="id" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>订单号：</label>
                            <div class="col-lg-9">
                                <input id="orderNo1" name="orderNo1"  class="form-control" placeholder="订单号" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>商品描述：</label>
                            <div class="col-lg-9">
                                <input id="body1" name="body1"  class="form-control" placeholder="商品描述" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>商品详情：</label>
                            <div class="col-lg-9">
                                <input id="detail1" name="detail1"  class="form-control" placeholder="商品详情" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>名额数量：</label>
                            <div class="col-lg-9">
                                <input id="number1" name="number1"  class="form-control" placeholder="名额数量" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>名额单价：</label>
                            <div class="col-lg-9">
                                <input id="price1" name="price1"  class="form-control" placeholder="名额单价" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>总金额：</label>
                            <div class="col-lg-9">
                                <input id="totalFee1" name="totalFee1"  class="form-control" placeholder="总金额" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户IP地址：</label>
                            <div class="col-lg-9">
                                <input id="spbillCreateIp1" name="spbillCreateIp1"  class="form-control" placeholder="用户IP地址" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>交易起始时间：</label>
                            <div class="col-lg-9">
                                <input id="payStartTime1" name="payStartTime1"  class="form-control" placeholder="交易起始时间" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>交易结束时间：</label>
                            <div class="col-lg-9">
                                <input id="payEndTime1" name="payEndTime1"  class="form-control" placeholder="交易结束时间" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>goods_tag：</label>
                            <div class="col-lg-9">
                                <input id="goodsTag1" name="goodsTag1"  class="form-control" placeholder="goods_tag" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>购买用户ID：</label>
                            <div class="col-lg-9">
                                <input id="openid1" name="openid1"  class="form-control" placeholder="购买用户ID" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户微信名称：</label>
                            <div class="col-lg-9">
                                <input id="userName1" name="userName1"  class="form-control" placeholder="用户微信名称" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>支付完成时间：</label>
                            <div class="col-lg-9">
                                <input id="payTime1" name="payTime1"  class="form-control" placeholder="支付完成时间" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>支付状态：</label>
                            <div class="col-lg-9">
                                <input id="payStatus1" name="payStatus1"  class="form-control" placeholder="支付状态" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>机器ID：</label>
                            <div class="col-lg-9">
                                <input id="manicheId1" name="manicheId1"  class="form-control" placeholder="机器ID" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>机器名称：</label>
                            <div class="col-lg-9">
                                <input id="manicheName1" name="manicheName1"  class="form-control" placeholder="机器名称" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>区域名称：</label>
                            <div class="col-lg-9">
                                <input id="areaName1" name="areaName1"  class="form-control" placeholder="区域名称" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>区域ID：</label>
                            <div class="col-lg-9">
                                <input id="areaId1" name="areaId1"  class="form-control" placeholder="区域ID" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>大学名称：</label>
                            <div class="col-lg-9">
                                <input id="unversityName1" name="unversityName1"  class="form-control" placeholder="大学名称" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>大学ID：</label>
                            <div class="col-lg-9">
                                <input id="universityId1" name="universityId1"  class="form-control" placeholder="大学ID" type="text"/>
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
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>修改时间：</label>
                            <div class="col-lg-9">
                                <input id="updateTime1" name="updateTime1"  class="form-control" placeholder="修改时间" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>修改人：</label>
                            <div class="col-lg-9">
                                <input id="updateUser1" name="updateUser1"  class="form-control" placeholder="修改人" type="text"/>
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



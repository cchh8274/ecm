<#import "/component/register.ftl" as  register/>

<#macro detailOrderInfoHtml>
    <div class="modal fade" id="detailOrderInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateDetailOrderInfoForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">查看订单表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title">id：</label>
                            <div class="col-lg-9">
                                <input id="id2" name="id2"  class="form-control" placeholder="id" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">订单号：</label>
                            <div class="col-lg-9">
                                <input id="orderNo2" name="orderNo2"  class="form-control" placeholder="订单号" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">商品描述：</label>
                            <div class="col-lg-9">
                                <input id="body2" name="body2"  class="form-control" placeholder="商品描述" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">商品详情：</label>
                            <div class="col-lg-9">
                                <input id="detail2" name="detail2"  class="form-control" placeholder="商品详情" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">名额数量：</label>
                            <div class="col-lg-9">
                                <input id="number2" name="number2"  class="form-control" placeholder="名额数量" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">名额单价：</label>
                            <div class="col-lg-9">
                                <input id="price2" name="price2"  class="form-control" placeholder="名额单价" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">总金额：</label>
                            <div class="col-lg-9">
                                <input id="totalFee2" name="totalFee2"  class="form-control" placeholder="总金额" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">用户IP地址：</label>
                            <div class="col-lg-9">
                                <input id="spbillCreateIp2" name="spbillCreateIp2"  class="form-control" placeholder="用户IP地址" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">交易起始时间：</label>
                            <div class="col-lg-9">
                                <input id="payStartTime2" name="payStartTime2"  class="form-control" placeholder="交易起始时间" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">交易结束时间：</label>
                            <div class="col-lg-9">
                                <input id="payEndTime2" name="payEndTime2"  class="form-control" placeholder="交易结束时间" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">goods_tag：</label>
                            <div class="col-lg-9">
                                <input id="goodsTag2" name="goodsTag2"  class="form-control" placeholder="goods_tag" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">购买用户ID：</label>
                            <div class="col-lg-9">
                                <input id="openid2" name="openid2"  class="form-control" placeholder="购买用户ID" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">用户微信名称：</label>
                            <div class="col-lg-9">
                                <input id="userName2" name="userName2"  class="form-control" placeholder="用户微信名称" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">支付完成时间：</label>
                            <div class="col-lg-9">
                                <input id="payTime2" name="payTime2"  class="form-control" placeholder="支付完成时间" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">支付状态：</label>
                            <div class="col-lg-9">
                                <input id="payStatus2" name="payStatus2"  class="form-control" placeholder="支付状态" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">机器ID：</label>
                            <div class="col-lg-9">
                                <input id="manicheId2" name="manicheId2"  class="form-control" placeholder="机器ID" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">机器名称：</label>
                            <div class="col-lg-9">
                                <input id="manicheName2" name="manicheName2"  class="form-control" placeholder="机器名称" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">区域名称：</label>
                            <div class="col-lg-9">
                                <input id="areaName2" name="areaName2"  class="form-control" placeholder="区域名称" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">区域ID：</label>
                            <div class="col-lg-9">
                                <input id="areaId2" name="areaId2"  class="form-control" placeholder="区域ID" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">大学名称：</label>
                            <div class="col-lg-9">
                                <input id="unversityName2" name="unversityName2"  class="form-control" placeholder="大学名称" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">大学ID：</label>
                            <div class="col-lg-9">
                                <input id="universityId2" name="universityId2"  class="form-control" placeholder="大学ID" type="text" disabled="disabled"/>
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
                        <div class="form-group">
                            <label class="col-lg-3 title">修改时间：</label>
                            <div class="col-lg-9">
                                <input id="updateTime2" name="updateTime2"  class="form-control" placeholder="修改时间" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">修改人：</label>
                            <div class="col-lg-9">
                                <input id="updateUser2" name="updateUser2"  class="form-control" placeholder="修改人" type="text" disabled="disabled"/>
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




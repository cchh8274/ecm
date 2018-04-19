<#import "/component/register.ftl" as  register/>

<#macro detailEarningsInfoHtml>
    <div class="modal fade" id="detailEarningsInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateDetailEarningsInfoForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">查看收益表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title">id：</label>
                            <div class="col-lg-9">
                                <input id="id2" name="id2"  class="form-control" placeholder="id" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">openid：</label>
                            <div class="col-lg-9">
                                <input id="openid2" name="openid2"  class="form-control" placeholder="openid" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">微信用户：</label>
                            <div class="col-lg-9">
                                <input id="wxUserName2" name="wxUserName2"  class="form-control" placeholder="微信用户" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">机器ID：</label>
                            <div class="col-lg-9">
                                <input id="manicheId2" name="manicheId2"  class="form-control" placeholder="机器ID" type="text" disabled="disabled"/>
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
                                <input id="unversityId2" name="unversityId2"  class="form-control" placeholder="大学ID" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">机器名称：</label>
                            <div class="col-lg-9">
                                <input id="manicheName2" name="manicheName2"  class="form-control" placeholder="机器名称" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">收益单价：</label>
                            <div class="col-lg-9">
                                <input id="price2" name="price2"  class="form-control" placeholder="收益单价" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">收益咖啡机数量：</label>
                            <div class="col-lg-9">
                                <input id="coffeeNumber2" name="coffeeNumber2"  class="form-control" placeholder="收益咖啡机数量" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">当月收益总金额：</label>
                            <div class="col-lg-9">
                                <input id="tolalMoney2" name="tolalMoney2"  class="form-control" placeholder="当月收益总金额" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">收益时间：</label>
                            <div class="col-lg-9">
                                <input id="earingMonth2" name="earingMonth2"  class="form-control" placeholder="收益时间" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">收益开始时间：</label>
                            <div class="col-lg-9">
                                <input id="earningStartTime2" name="earningStartTime2"  class="form-control" placeholder="收益开始时间" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">是否下发收益：</label>
                            <div class="col-lg-9">
                                <input id="isEaningStatus2" name="isEaningStatus2"  class="form-control" placeholder="是否下发收益" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">收益下发时间：</label>
                            <div class="col-lg-9">
                                <input id="earningSendTime2" name="earningSendTime2"  class="form-control" placeholder="收益下发时间" type="text" disabled="disabled"/>
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




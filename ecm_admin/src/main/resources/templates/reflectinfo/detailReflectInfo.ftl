<#import "/component/register.ftl" as  register/>

<#macro detailReflectInfoHtml>
    <div class="modal fade" id="detailReflectInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateDetailReflectInfoForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">查看体现记录表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title">id：</label>
                            <div class="col-lg-9">
                                <input id="id2" name="id2"  class="form-control" placeholder="id" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">体现流水号：</label>
                            <div class="col-lg-9">
                                <input id="transNo2" name="transNo2"  class="form-control" placeholder="体现流水号" type="text" disabled="disabled"/>
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
                                <input id="wxUser2" name="wxUser2"  class="form-control" placeholder="微信用户" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">体现用户：</label>
                            <div class="col-lg-9">
                                <input id="reflectUser2" name="reflectUser2"  class="form-control" placeholder="体现用户" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">银行卡号：</label>
                            <div class="col-lg-9">
                                <input id="bankCard2" name="bankCard2"  class="form-control" placeholder="银行卡号" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">银行名称：</label>
                            <div class="col-lg-9">
                                <input id="bankName2" name="bankName2"  class="form-control" placeholder="银行名称" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">提现金额：</label>
                            <div class="col-lg-9">
                                <input id="reflectMoney2" name="reflectMoney2"  class="form-control" placeholder="提现金额" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">是否到账：</label>
                            <div class="col-lg-9">
                                <input id="isAccount2" name="isAccount2"  class="form-control" placeholder="是否到账" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">是否冻结：</label>
                            <div class="col-lg-9">
                                <input id="isFreeze2" name="isFreeze2"  class="form-control" placeholder="是否冻结" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">到账时间：</label>
                            <div class="col-lg-9">
                                <input id="accountTime2" name="accountTime2"  class="form-control" placeholder="到账时间" type="text" disabled="disabled"/>
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




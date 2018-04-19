<#import "/component/register.ftl" as  register/>

<#macro detailBankamountInfoHtml>
    <div class="modal fade" id="detailBankamountInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateDetailBankamountInfoForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">查看银行账户表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title">id：</label>
                            <div class="col-lg-9">
                                <input id="id2" name="id2"  class="form-control" placeholder="id" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">用户名称：</label>
                            <div class="col-lg-9">
                                <input id="userName2" name="userName2"  class="form-control" placeholder="用户名称" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">身份证号：</label>
                            <div class="col-lg-9">
                                <input id="idcard2" name="idcard2"  class="form-control" placeholder="身份证号" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">电话：</label>
                            <div class="col-lg-9">
                                <input id="phone2" name="phone2"  class="form-control" placeholder="电话" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">微信用户名称：</label>
                            <div class="col-lg-9">
                                <input id="wxName2" name="wxName2"  class="form-control" placeholder="微信用户名称" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">openid：</label>
                            <div class="col-lg-9">
                                <input id="openid2" name="openid2"  class="form-control" placeholder="openid" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">银行账户：</label>
                            <div class="col-lg-9">
                                <input id="bankAmountNo2" name="bankAmountNo2"  class="form-control" placeholder="银行账户" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">银行名称：</label>
                            <div class="col-lg-9">
                                <input id="bankName2" name="bankName2"  class="form-control" placeholder="银行名称" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">开户地址：</label>
                            <div class="col-lg-9">
                                <input id="bankAdress2" name="bankAdress2"  class="form-control" placeholder="开户地址" type="text" disabled="disabled"/>
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




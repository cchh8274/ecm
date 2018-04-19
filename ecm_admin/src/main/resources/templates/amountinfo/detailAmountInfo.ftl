<#import "/component/register.ftl" as  register/>

<#macro detailAmountInfoHtml>
    <div class="modal fade" id="detailAmountInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateDetailAmountInfoForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">查看用户账户表</h4>
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
                            <label class="col-lg-3 title">openid：</label>
                            <div class="col-lg-9">
                                <input id="openid2" name="openid2"  class="form-control" placeholder="openid" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">账户金额：</label>
                            <div class="col-lg-9">
                                <input id="accountMoney2" name="accountMoney2"  class="form-control" placeholder="账户金额" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">是否启用：</label>
                            <div class="col-lg-9">
                                <input id="isStart2" name="isStart2"  class="form-control" placeholder="是否启用" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">账户ID：</label>
                            <div class="col-lg-9">
                                <input id="accountId2" name="accountId2"  class="form-control" placeholder="账户ID" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">账户创建时间：</label>
                            <div class="col-lg-9">
                                <input id="accountTime2" name="accountTime2"  class="form-control" placeholder="账户创建时间" type="text" disabled="disabled"/>
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
                            <label class="col-lg-3 title">是否冻结：</label>
                            <div class="col-lg-9">
                                <input id="isFreeze2" name="isFreeze2"  class="form-control" placeholder="是否冻结" type="text" disabled="disabled"/>
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




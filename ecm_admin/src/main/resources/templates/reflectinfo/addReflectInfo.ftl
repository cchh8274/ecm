<#import "/component/register.ftl" as  register/>

<#macro addReflectInfoHtml>
    <div class="modal fade" id="addReflectInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateAddReflectInfoForm" method="post" class="form-horizontal">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">新增体现记录表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>id：</label>
                            <div class="col-lg-9">
                                <input id="id1" name="id1"  class="form-control" placeholder="id" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>体现流水号：</label>
                            <div class="col-lg-9">
                                <input id="transNo1" name="transNo1"  class="form-control" placeholder="体现流水号" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>openid：</label>
                            <div class="col-lg-9">
                                <input id="openid1" name="openid1"  class="form-control" placeholder="openid" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>微信用户：</label>
                            <div class="col-lg-9">
                                <input id="wxUser1" name="wxUser1"  class="form-control" placeholder="微信用户" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>体现用户：</label>
                            <div class="col-lg-9">
                                <input id="reflectUser1" name="reflectUser1"  class="form-control" placeholder="体现用户" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>银行卡号：</label>
                            <div class="col-lg-9">
                                <input id="bankCard1" name="bankCard1"  class="form-control" placeholder="银行卡号" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>银行名称：</label>
                            <div class="col-lg-9">
                                <input id="bankName1" name="bankName1"  class="form-control" placeholder="银行名称" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>提现金额：</label>
                            <div class="col-lg-9">
                                <input id="reflectMoney1" name="reflectMoney1"  class="form-control" placeholder="提现金额" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>是否到账：</label>
                            <div class="col-lg-9">
                                <input id="isAccount1" name="isAccount1"  class="form-control" placeholder="是否到账" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>是否冻结：</label>
                            <div class="col-lg-9">
                                <input id="isFreeze1" name="isFreeze1"  class="form-control" placeholder="是否冻结" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>到账时间：</label>
                            <div class="col-lg-9">
                                <input id="accountTime1" name="accountTime1"  class="form-control" placeholder="到账时间" type="text"/>
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



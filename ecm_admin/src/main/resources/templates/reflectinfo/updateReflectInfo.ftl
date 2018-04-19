<#import "/component/register.ftl" as  register/>

<#macro updateReflectInfoHtml>
    <div class="modal fade" id="updateReflectInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateUpdateReflectInfoForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">修改体现记录表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>id：</label>
                            <div class="col-lg-9">
                                <input id="id3" name="id3"  class="form-control" placeholder="id" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>体现流水号：</label>
                            <div class="col-lg-9">
                                <input id="transNo3" name="transNo3"  class="form-control" placeholder="体现流水号" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>openid：</label>
                            <div class="col-lg-9">
                                <input id="openid3" name="openid3"  class="form-control" placeholder="openid" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>微信用户：</label>
                            <div class="col-lg-9">
                                <input id="wxUser3" name="wxUser3"  class="form-control" placeholder="微信用户" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>体现用户：</label>
                            <div class="col-lg-9">
                                <input id="reflectUser3" name="reflectUser3"  class="form-control" placeholder="体现用户" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>银行卡号：</label>
                            <div class="col-lg-9">
                                <input id="bankCard3" name="bankCard3"  class="form-control" placeholder="银行卡号" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>银行名称：</label>
                            <div class="col-lg-9">
                                <input id="bankName3" name="bankName3"  class="form-control" placeholder="银行名称" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>提现金额：</label>
                            <div class="col-lg-9">
                                <input id="reflectMoney3" name="reflectMoney3"  class="form-control" placeholder="提现金额" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>是否到账：</label>
                            <div class="col-lg-9">
                                <input id="isAccount3" name="isAccount3"  class="form-control" placeholder="是否到账" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>是否冻结：</label>
                            <div class="col-lg-9">
                                <input id="isFreeze3" name="isFreeze3"  class="form-control" placeholder="是否冻结" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>到账时间：</label>
                            <div class="col-lg-9">
                                <input id="accountTime3" name="accountTime3"  class="form-control" placeholder="到账时间" type="text" />
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




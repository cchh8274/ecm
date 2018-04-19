<#import "/component/register.ftl" as  register/>

<#macro addEarningsInfoHtml>
    <div class="modal fade" id="addEarningsInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateAddEarningsInfoForm" method="post" class="form-horizontal">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">新增收益表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>id：</label>
                            <div class="col-lg-9">
                                <input id="id1" name="id1"  class="form-control" placeholder="id" type="text"/>
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
                                <input id="wxUserName1" name="wxUserName1"  class="form-control" placeholder="微信用户" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>机器ID：</label>
                            <div class="col-lg-9">
                                <input id="manicheId1" name="manicheId1"  class="form-control" placeholder="机器ID" type="text"/>
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
                                <input id="unversityId1" name="unversityId1"  class="form-control" placeholder="大学ID" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>机器名称：</label>
                            <div class="col-lg-9">
                                <input id="manicheName1" name="manicheName1"  class="form-control" placeholder="机器名称" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>收益单价：</label>
                            <div class="col-lg-9">
                                <input id="price1" name="price1"  class="form-control" placeholder="收益单价" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>收益咖啡机数量：</label>
                            <div class="col-lg-9">
                                <input id="coffeeNumber1" name="coffeeNumber1"  class="form-control" placeholder="收益咖啡机数量" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>当月收益总金额：</label>
                            <div class="col-lg-9">
                                <input id="tolalMoney1" name="tolalMoney1"  class="form-control" placeholder="当月收益总金额" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>收益时间：</label>
                            <div class="col-lg-9">
                                <input id="earingMonth1" name="earingMonth1"  class="form-control" placeholder="收益时间" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>收益开始时间：</label>
                            <div class="col-lg-9">
                                <input id="earningStartTime1" name="earningStartTime1"  class="form-control" placeholder="收益开始时间" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>是否下发收益：</label>
                            <div class="col-lg-9">
                                <input id="isEaningStatus1" name="isEaningStatus1"  class="form-control" placeholder="是否下发收益" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>收益下发时间：</label>
                            <div class="col-lg-9">
                                <input id="earningSendTime1" name="earningSendTime1"  class="form-control" placeholder="收益下发时间" type="text"/>
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



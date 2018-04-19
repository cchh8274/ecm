<#import "/component/register.ftl" as  register/>

<#macro updateEarningsInfoHtml>
    <div class="modal fade" id="updateEarningsInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateUpdateEarningsInfoForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">修改收益表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>id：</label>
                            <div class="col-lg-9">
                                <input id="id3" name="id3"  class="form-control" placeholder="id" type="text" />
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
                                <input id="wxUserName3" name="wxUserName3"  class="form-control" placeholder="微信用户" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>机器ID：</label>
                            <div class="col-lg-9">
                                <input id="manicheId3" name="manicheId3"  class="form-control" placeholder="机器ID" type="text" />
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
                                <input id="unversityId3" name="unversityId3"  class="form-control" placeholder="大学ID" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>机器名称：</label>
                            <div class="col-lg-9">
                                <input id="manicheName3" name="manicheName3"  class="form-control" placeholder="机器名称" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>收益单价：</label>
                            <div class="col-lg-9">
                                <input id="price3" name="price3"  class="form-control" placeholder="收益单价" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>收益咖啡机数量：</label>
                            <div class="col-lg-9">
                                <input id="coffeeNumber3" name="coffeeNumber3"  class="form-control" placeholder="收益咖啡机数量" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>当月收益总金额：</label>
                            <div class="col-lg-9">
                                <input id="tolalMoney3" name="tolalMoney3"  class="form-control" placeholder="当月收益总金额" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>收益时间：</label>
                            <div class="col-lg-9">
                                <input id="earingMonth3" name="earingMonth3"  class="form-control" placeholder="收益时间" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>收益开始时间：</label>
                            <div class="col-lg-9">
                                <input id="earningStartTime3" name="earningStartTime3"  class="form-control" placeholder="收益开始时间" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>是否下发收益：</label>
                            <div class="col-lg-9">
                                <input id="isEaningStatus3" name="isEaningStatus3"  class="form-control" placeholder="是否下发收益" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>收益下发时间：</label>
                            <div class="col-lg-9">
                                <input id="earningSendTime3" name="earningSendTime3"  class="form-control" placeholder="收益下发时间" type="text" />
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




<#import "/component/register.ftl" as  register/>

<#macro detailAmountDetailHtml>
    <div class="modal fade" id="detailAmountDetail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateDetailAmountDetailForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">查看账户明细表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title">id：</label>
                            <div class="col-lg-9">
                                <input id="id2" name="id2"  class="form-control" placeholder="id" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">账户ID：</label>
                            <div class="col-lg-9">
                                <input id="accountId2" name="accountId2"  class="form-control" placeholder="账户ID" type="text" disabled="disabled"/>
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
                            <label class="col-lg-3 title">月份收益：</label>
                            <div class="col-lg-9">
                                <input id="earningMonth2" name="earningMonth2"  class="form-control" placeholder="月份收益" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">区域ID：</label>
                            <div class="col-lg-9">
                                <input id="areaId2" name="areaId2"  class="form-control" placeholder="区域ID" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">区域名称：</label>
                            <div class="col-lg-9">
                                <input id="areaName2" name="areaName2"  class="form-control" placeholder="区域名称" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">是否冻结：</label>
                            <div class="col-lg-9">
                                <input id="isFreeze2" name="isFreeze2"  class="form-control" placeholder="是否冻结" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">收益类型：</label>
                            <div class="col-lg-9">
                                <input id="earningType2" name="earningType2"  class="form-control" placeholder="收益类型" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">收益金额：</label>
                            <div class="col-lg-9">
                                <input id="earningsMoney2" name="earningsMoney2"  class="form-control" placeholder="收益金额" type="text" disabled="disabled"/>
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




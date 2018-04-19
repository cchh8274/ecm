<#import "/component/register.ftl" as  register/>

<#macro addAmountDetailHtml>
    <div class="modal fade" id="addAmountDetail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateAddAmountDetailForm" method="post" class="form-horizontal">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">新增账户明细表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>id：</label>
                            <div class="col-lg-9">
                                <input id="id1" name="id1"  class="form-control" placeholder="id" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>账户ID：</label>
                            <div class="col-lg-9">
                                <input id="accountId1" name="accountId1"  class="form-control" placeholder="账户ID" type="text"/>
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
                            <label class="col-lg-3 title"><i class="redFont">*</i>月份收益：</label>
                            <div class="col-lg-9">
                                <input id="earningMonth1" name="earningMonth1"  class="form-control" placeholder="月份收益" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>区域ID：</label>
                            <div class="col-lg-9">
                                <input id="areaId1" name="areaId1"  class="form-control" placeholder="区域ID" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>区域名称：</label>
                            <div class="col-lg-9">
                                <input id="areaName1" name="areaName1"  class="form-control" placeholder="区域名称" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>是否冻结：</label>
                            <div class="col-lg-9">
                                <input id="isFreeze1" name="isFreeze1"  class="form-control" placeholder="是否冻结" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>收益类型：</label>
                            <div class="col-lg-9">
                                <input id="earningType1" name="earningType1"  class="form-control" placeholder="收益类型" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>收益金额：</label>
                            <div class="col-lg-9">
                                <input id="earningsMoney1" name="earningsMoney1"  class="form-control" placeholder="收益金额" type="text"/>
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



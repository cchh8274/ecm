<#import "/component/register.ftl" as  register/>

<#macro addMachineInfoHtml>
    <div class="modal fade" id="addMachineInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateAddMachineInfoForm" method="post" class="form-horizontal">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">新增机器信息表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>id：</label>
                            <div class="col-lg-9">
                                <input id="id1" name="id1"  class="form-control" placeholder="id" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>机器名称：</label>
                            <div class="col-lg-9">
                                <input id="machineName1" name="machineName1"  class="form-control" placeholder="机器名称" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>投放位置：</label>
                            <div class="col-lg-9">
                                <input id="adress1" name="adress1"  class="form-control" placeholder="投放位置" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>是否使用：</label>
                            <div class="col-lg-9">
                                <input id="isUse1" name="isUse1"  class="form-control" placeholder="是否使用" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>单个名额价格：</label>
                            <div class="col-lg-9">
                                <input id="price1" name="price1"  class="form-control" placeholder="单个名额价格" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>总名额：</label>
                            <div class="col-lg-9">
                                <input id="totalPlaces1" name="totalPlaces1"  class="form-control" placeholder="总名额" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>剩余名额：</label>
                            <div class="col-lg-9">
                                <input id="leftPlace1" name="leftPlace1"  class="form-control" placeholder="剩余名额" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>已售名额：</label>
                            <div class="col-lg-9">
                                <input id="outSalePlace1" name="outSalePlace1"  class="form-control" placeholder="已售名额" type="text"/>
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



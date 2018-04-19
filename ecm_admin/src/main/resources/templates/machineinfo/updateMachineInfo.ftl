<#import "/component/register.ftl" as  register/>

<#macro updateMachineInfoHtml>
    <div class="modal fade" id="updateMachineInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateUpdateMachineInfoForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">修改机器信息表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>id：</label>
                            <div class="col-lg-9">
                                <input id="id3" name="id3"  class="form-control" placeholder="id" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>机器名称：</label>
                            <div class="col-lg-9">
                                <input id="machineName3" name="machineName3"  class="form-control" placeholder="机器名称" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>投放位置：</label>
                            <div class="col-lg-9">
                                <input id="adress3" name="adress3"  class="form-control" placeholder="投放位置" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>是否使用：</label>
                            <div class="col-lg-9">
                                <input id="isUse3" name="isUse3"  class="form-control" placeholder="是否使用" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>单个名额价格：</label>
                            <div class="col-lg-9">
                                <input id="price3" name="price3"  class="form-control" placeholder="单个名额价格" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>总名额：</label>
                            <div class="col-lg-9">
                                <input id="totalPlaces3" name="totalPlaces3"  class="form-control" placeholder="总名额" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>剩余名额：</label>
                            <div class="col-lg-9">
                                <input id="leftPlace3" name="leftPlace3"  class="form-control" placeholder="剩余名额" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>已售名额：</label>
                            <div class="col-lg-9">
                                <input id="outSalePlace3" name="outSalePlace3"  class="form-control" placeholder="已售名额" type="text" />
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




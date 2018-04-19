<#import "/component/register.ftl" as  register/>

<#macro detailMachineInfoHtml>
    <div class="modal fade" id="detailMachineInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateDetailMachineInfoForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">查看机器信息表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title">id：</label>
                            <div class="col-lg-9">
                                <input id="id2" name="id2"  class="form-control" placeholder="id" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">机器名称：</label>
                            <div class="col-lg-9">
                                <input id="machineName2" name="machineName2"  class="form-control" placeholder="机器名称" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">投放位置：</label>
                            <div class="col-lg-9">
                                <input id="adress2" name="adress2"  class="form-control" placeholder="投放位置" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">是否使用：</label>
                            <div class="col-lg-9">
                                <input id="isUse2" name="isUse2"  class="form-control" placeholder="是否使用" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">单个名额价格：</label>
                            <div class="col-lg-9">
                                <input id="price2" name="price2"  class="form-control" placeholder="单个名额价格" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">总名额：</label>
                            <div class="col-lg-9">
                                <input id="totalPlaces2" name="totalPlaces2"  class="form-control" placeholder="总名额" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">剩余名额：</label>
                            <div class="col-lg-9">
                                <input id="leftPlace2" name="leftPlace2"  class="form-control" placeholder="剩余名额" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">已售名额：</label>
                            <div class="col-lg-9">
                                <input id="outSalePlace2" name="outSalePlace2"  class="form-control" placeholder="已售名额" type="text" disabled="disabled"/>
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




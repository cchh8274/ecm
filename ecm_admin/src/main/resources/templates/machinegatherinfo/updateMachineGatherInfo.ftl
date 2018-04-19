<#import "/component/register.ftl" as  register/>

<#macro updateMachineGatherInfoHtml>
    <div class="modal fade" id="updateMachineGatherInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateUpdateMachineGatherInfoForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">修改用户咖啡机表</h4>
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
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户名称：</label>
                            <div class="col-lg-9">
                                <input id="wxUserName3" name="wxUserName3"  class="form-control" placeholder="用户名称" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>区域名称：</label>
                            <div class="col-lg-9">
                                <input id="areaId3" name="areaId3"  class="form-control" placeholder="区域名称" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>区域ID：</label>
                            <div class="col-lg-9">
                                <input id="areId3" name="areId3"  class="form-control" placeholder="区域ID" type="text" />
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
                            <label class="col-lg-3 title"><i class="redFont">*</i>购买金额：</label>
                            <div class="col-lg-9">
                                <input id="price3" name="price3"  class="form-control" placeholder="购买金额" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>购买数量：</label>
                            <div class="col-lg-9">
                                <input id="number3" name="number3"  class="form-control" placeholder="购买数量" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>购买时间：</label>
                            <div class="col-lg-9">
                                <input id="payTime3" name="payTime3"  class="form-control" placeholder="购买时间" type="text" />
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




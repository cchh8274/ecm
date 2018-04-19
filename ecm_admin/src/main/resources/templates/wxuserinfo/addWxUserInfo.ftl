<#import "/component/register.ftl" as  register/>

<#macro addWxUserInfoHtml>
    <div class="modal fade" id="addWxUserInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateAddWxUserInfoForm" method="post" class="form-horizontal">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">新增微信用户表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>ID：</label>
                            <div class="col-lg-9">
                                <input id="id1" name="id1"  class="form-control" placeholder="ID" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>openid：</label>
                            <div class="col-lg-9">
                                <input id="openid1" name="openid1"  class="form-control" placeholder="openid" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户的昵称：</label>
                            <div class="col-lg-9">
                                <input id="nickname1" name="nickname1"  class="form-control" placeholder="用户的昵称" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>性别：</label>
                            <div class="col-lg-9">
                                <input id="sex1" name="sex1"  class="form-control" placeholder="性别" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户所在城市：</label>
                            <div class="col-lg-9">
                                <input id="city1" name="city1"  class="form-control" placeholder="用户所在城市" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户所在国家：</label>
                            <div class="col-lg-9">
                                <input id="country1" name="country1"  class="form-control" placeholder="用户所在国家" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户所在省份：</label>
                            <div class="col-lg-9">
                                <input id="province1" name="province1"  class="form-control" placeholder="用户所在省份" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户的语言：</label>
                            <div class="col-lg-9">
                                <input id="language1" name="language1"  class="form-control" placeholder="用户的语言" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>：</label>
                            <div class="col-lg-9">
                                <input id="headimgurl1" name="headimgurl1"  class="form-control" placeholder="" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户关注时间：</label>
                            <div class="col-lg-9">
                                <input id="subscribeTime1" name="subscribeTime1"  class="form-control" placeholder="用户关注时间" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。：</label>
                            <div class="col-lg-9">
                                <input id="unionid1" name="unionid1"  class="form-control" placeholder="只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>公众号运营者对粉丝的备注：</label>
                            <div class="col-lg-9">
                                <input id="remark1" name="remark1"  class="form-control" placeholder="公众号运营者对粉丝的备注" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户所在的分组ID：</label>
                            <div class="col-lg-9">
                                <input id="groupid1" name="groupid1"  class="form-control" placeholder="用户所在的分组ID" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户被打上的标签ID列表：</label>
                            <div class="col-lg-9">
                                <input id="tagidList1" name="tagidList1"  class="form-control" placeholder="用户被打上的标签ID列表" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>返回用户关注的渠道来源：</label>
                            <div class="col-lg-9">
                                <input id="subscribeScene1" name="subscribeScene1"  class="form-control" placeholder="返回用户关注的渠道来源" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>二维码扫码场景：</label>
                            <div class="col-lg-9">
                                <input id="qrScene1" name="qrScene1"  class="form-control" placeholder="二维码扫码场景" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>二维码扫码场景描述：</label>
                            <div class="col-lg-9">
                                <input id="qrSceneStr1" name="qrSceneStr1"  class="form-control" placeholder="二维码扫码场景描述" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>创建时间：</label>
                            <div class="col-lg-9">
                                <input id="createtTime1" name="createtTime1"  class="form-control" placeholder="创建时间" type="text"/>
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



<#import "/component/register.ftl" as  register/>

<#macro updateWxUserInfoHtml>
    <div class="modal fade" id="updateWxUserInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateUpdateWxUserInfoForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">修改微信用户表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>ID：</label>
                            <div class="col-lg-9">
                                <input id="id3" name="id3"  class="form-control" placeholder="ID" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>openid：</label>
                            <div class="col-lg-9">
                                <input id="openid3" name="openid3"  class="form-control" placeholder="openid" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户的昵称：</label>
                            <div class="col-lg-9">
                                <input id="nickname3" name="nickname3"  class="form-control" placeholder="用户的昵称" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>性别：</label>
                            <div class="col-lg-9">
                                <input id="sex3" name="sex3"  class="form-control" placeholder="性别" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户所在城市：</label>
                            <div class="col-lg-9">
                                <input id="city3" name="city3"  class="form-control" placeholder="用户所在城市" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户所在国家：</label>
                            <div class="col-lg-9">
                                <input id="country3" name="country3"  class="form-control" placeholder="用户所在国家" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户所在省份：</label>
                            <div class="col-lg-9">
                                <input id="province3" name="province3"  class="form-control" placeholder="用户所在省份" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户的语言：</label>
                            <div class="col-lg-9">
                                <input id="language3" name="language3"  class="form-control" placeholder="用户的语言" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>：</label>
                            <div class="col-lg-9">
                                <input id="headimgurl3" name="headimgurl3"  class="form-control" placeholder="" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户关注时间：</label>
                            <div class="col-lg-9">
                                <input id="subscribeTime3" name="subscribeTime3"  class="form-control" placeholder="用户关注时间" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。：</label>
                            <div class="col-lg-9">
                                <input id="unionid3" name="unionid3"  class="form-control" placeholder="只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>公众号运营者对粉丝的备注：</label>
                            <div class="col-lg-9">
                                <input id="remark3" name="remark3"  class="form-control" placeholder="公众号运营者对粉丝的备注" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户所在的分组ID：</label>
                            <div class="col-lg-9">
                                <input id="groupid3" name="groupid3"  class="form-control" placeholder="用户所在的分组ID" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户被打上的标签ID列表：</label>
                            <div class="col-lg-9">
                                <input id="tagidList3" name="tagidList3"  class="form-control" placeholder="用户被打上的标签ID列表" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>返回用户关注的渠道来源：</label>
                            <div class="col-lg-9">
                                <input id="subscribeScene3" name="subscribeScene3"  class="form-control" placeholder="返回用户关注的渠道来源" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>二维码扫码场景：</label>
                            <div class="col-lg-9">
                                <input id="qrScene3" name="qrScene3"  class="form-control" placeholder="二维码扫码场景" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>二维码扫码场景描述：</label>
                            <div class="col-lg-9">
                                <input id="qrSceneStr3" name="qrSceneStr3"  class="form-control" placeholder="二维码扫码场景描述" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>创建时间：</label>
                            <div class="col-lg-9">
                                <input id="createtTime3" name="createtTime3"  class="form-control" placeholder="创建时间" type="text" />
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




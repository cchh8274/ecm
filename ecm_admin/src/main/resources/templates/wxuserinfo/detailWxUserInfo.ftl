<#import "/component/register.ftl" as  register/>

<#macro detailWxUserInfoHtml>
    <div class="modal fade" id="detailWxUserInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateDetailWxUserInfoForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">查看微信用户表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title">ID：</label>
                            <div class="col-lg-9">
                                <input id="id2" name="id2"  class="form-control" placeholder="ID" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">openid：</label>
                            <div class="col-lg-9">
                                <input id="openid2" name="openid2"  class="form-control" placeholder="openid" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">用户的昵称：</label>
                            <div class="col-lg-9">
                                <input id="nickname2" name="nickname2"  class="form-control" placeholder="用户的昵称" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">性别：</label>
                            <div class="col-lg-9">
                                <input id="sex2" name="sex2"  class="form-control" placeholder="性别" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">用户所在城市：</label>
                            <div class="col-lg-9">
                                <input id="city2" name="city2"  class="form-control" placeholder="用户所在城市" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">用户所在国家：</label>
                            <div class="col-lg-9">
                                <input id="country2" name="country2"  class="form-control" placeholder="用户所在国家" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">用户所在省份：</label>
                            <div class="col-lg-9">
                                <input id="province2" name="province2"  class="form-control" placeholder="用户所在省份" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">用户的语言：</label>
                            <div class="col-lg-9">
                                <input id="language2" name="language2"  class="form-control" placeholder="用户的语言" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">：</label>
                            <div class="col-lg-9">
                                <input id="headimgurl2" name="headimgurl2"  class="form-control" placeholder="" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">用户关注时间：</label>
                            <div class="col-lg-9">
                                <input id="subscribeTime2" name="subscribeTime2"  class="form-control" placeholder="用户关注时间" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。：</label>
                            <div class="col-lg-9">
                                <input id="unionid2" name="unionid2"  class="form-control" placeholder="只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">公众号运营者对粉丝的备注：</label>
                            <div class="col-lg-9">
                                <input id="remark2" name="remark2"  class="form-control" placeholder="公众号运营者对粉丝的备注" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">用户所在的分组ID：</label>
                            <div class="col-lg-9">
                                <input id="groupid2" name="groupid2"  class="form-control" placeholder="用户所在的分组ID" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">用户被打上的标签ID列表：</label>
                            <div class="col-lg-9">
                                <input id="tagidList2" name="tagidList2"  class="form-control" placeholder="用户被打上的标签ID列表" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">返回用户关注的渠道来源：</label>
                            <div class="col-lg-9">
                                <input id="subscribeScene2" name="subscribeScene2"  class="form-control" placeholder="返回用户关注的渠道来源" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">二维码扫码场景：</label>
                            <div class="col-lg-9">
                                <input id="qrScene2" name="qrScene2"  class="form-control" placeholder="二维码扫码场景" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">二维码扫码场景描述：</label>
                            <div class="col-lg-9">
                                <input id="qrSceneStr2" name="qrSceneStr2"  class="form-control" placeholder="二维码扫码场景描述" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">创建时间：</label>
                            <div class="col-lg-9">
                                <input id="createtTime2" name="createtTime2"  class="form-control" placeholder="创建时间" type="text" disabled="disabled"/>
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




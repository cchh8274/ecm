<#import "/component/register.ftl" as  register/>

<#macro detailSysuserInfoHtml>
    <div class="modal fade" id="detailSysuserInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateDetailSysuserInfoForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">查看系统用户表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title">用户编号：</label>
                            <div class="col-lg-9">
                                <input id="userNo2" name="userNo2"  class="form-control" placeholder="用户编号" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">用户姓名：</label>
                            <div class="col-lg-9">
                                <input id="userName2" name="userName2"  class="form-control" placeholder="用户姓名" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">用户昵称：</label>
                            <div class="col-lg-9">
                                <input id="userNickname2" name="userNickname2"  class="form-control" placeholder="用户昵称" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">用户登录帐号：</label>
                            <div class="col-lg-9">
                                <input id="loginName2" name="loginName2"  class="form-control" placeholder="用户登录帐号" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">用户状态：</label>
                            <div class="col-lg-9">
                                <input id="userStatus2" name="userStatus2"  class="form-control" placeholder="用户状态" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">应用名称：</label>
                            <div class="col-lg-9">
                                <input id="applicationCode2" name="applicationCode2"  class="form-control" placeholder="应用名称" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <#assign options="0001"/>
                        <@register.fileupdownload form="validateDetailSysuserInfoForm" name="userIcon2" label="用户图标" options=options value=""
                        need="true" upload_base_path="/file/upLoad.dhtml" download_base_path="/file/downLoad.dhtml" fileDesc="SysuserInfo-userIcon-用户图标"
                        businessType="010" businessNo="010" class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                        <div class="form-group">
                            <label class="col-lg-3 title">最后登录ip：</label>
                            <div class="col-lg-9">
                                <input id="lastLoginIp2" name="lastLoginIp2"  class="form-control" placeholder="最后登录ip" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">最后登录时间：</label>
                            <div class="col-lg-9">
                                <input id="lastLoginTm2" name="lastLoginTm2"  class="form-control" placeholder="最后登录时间" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">添加时间：</label>
                            <div class="col-lg-9">
                                <input id="createTime2" name="createTime2"  class="form-control" placeholder="添加时间" type="text" disabled="disabled"/>
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




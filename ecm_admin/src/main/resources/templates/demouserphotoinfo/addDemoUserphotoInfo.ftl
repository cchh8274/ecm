<#import "/component/register.ftl" as  register/>

<#macro addDemoUserphotoInfoHtml>
    <div class="modal fade" id="addDemoUserphotoInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateAddDemoUserphotoInfoForm" method="post" class="form-horizontal">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">新增用户照片表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>编号：</label>
                            <div class="col-lg-9">
                                <input id="id1" name="id1"  class="form-control" placeholder="编号" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>用户名称：</label>
                            <div class="col-lg-9">
                                <input id="userNm1" name="userNm1"  class="form-control" placeholder="用户名称" type="text"/>
                            </div>
                        </div>
                        <#assign options="1111"/>
                        <@register.fileupdownload form="validateAddDemoUserphotoInfoForm" name="photo1" label="照片" options=options value=""
                        need="true" upload_base_path="/file/upLoad.dhtml" download_base_path="/file/downLoad.dhtml" fileDesc="DemoUserphotoInfo-photo-照片"
                        businessType="010" businessNo="010" class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="false"/>
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



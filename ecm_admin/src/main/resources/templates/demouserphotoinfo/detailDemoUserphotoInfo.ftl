<#import "/component/register.ftl" as  register/>

<#macro detailDemoUserphotoInfoHtml>
    <div class="modal fade" id="detailDemoUserphotoInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateDetailDemoUserphotoInfoForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">查看用户照片表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title">编号：</label>
                            <div class="col-lg-9">
                                <input id="id2" name="id2"  class="form-control" placeholder="编号" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">用户名称：</label>
                            <div class="col-lg-9">
                                <input id="userNm2" name="userNm2"  class="form-control" placeholder="用户名称" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <#assign options="0001"/>
                        <@register.fileupdownload form="validateDetailDemoUserphotoInfoForm" name="photo2" label="照片" options=options value=""
                        need="true" upload_base_path="/file/upLoad.dhtml" download_base_path="/file/downLoad.dhtml" fileDesc="DemoUserphotoInfo-photo-照片"
                        businessType="010" businessNo="010" class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</#macro>




<#import "/component/register.ftl" as  register/>

<#macro detailUnionDemoSlavebInfoHtml>
    <div class="modal fade" id="detailUnionDemoSlavebInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateDetailUnionDemoSlavebInfoForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">查看联表查询DEMO-从表b</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title">表ID：</label>
                            <div class="col-lg-9">
                                <input id="demoIdb2" name="demoIdb2"  class="form-control" placeholder="表ID" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">表ID：</label>
                            <div class="col-lg-9">
                                <input id="forgienId2" name="forgienId2"  class="form-control" placeholder="表ID" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">演示名称：</label>
                            <div class="col-lg-9">
                                <input id="demoNmb2" name="demoNmb2"  class="form-control" placeholder="演示名称" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">创建时间：</label>
                            <div class="col-lg-9">
                                <input id="createTimeb2" name="createTimeb2"  class="form-control" placeholder="创建时间" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">整数：</label>
                            <div class="col-lg-9">
                                <input id="countNumberb2" name="countNumberb2"  class="form-control" placeholder="整数" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">演示金额：</label>
                            <div class="col-lg-9">
                                <input id="demoMoneyb2" name="demoMoneyb2"  class="form-control" placeholder="演示金额" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">静态选择框：</label>
                            <div class="col-lg-9">
                                <input id="selectStaticb2" name="selectStaticb2"  class="form-control" placeholder="静态选择框" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">动态选择框：</label>
                            <div class="col-lg-9">
                                <input id="selectDynamicb2" name="selectDynamicb2"  class="form-control" placeholder="动态选择框" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">静态单选按钮：</label>
                            <div class="col-lg-9">
                                <input id="radioStaticb2" name="radioStaticb2"  class="form-control" placeholder="静态单选按钮" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">动态单选按钮：</label>
                            <div class="col-lg-9">
                                <input id="radioDynamicb2" name="radioDynamicb2"  class="form-control" placeholder="动态单选按钮" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <#--静态模式-start-->
                        <#assign options=["正常","禁用","失效"]/>
                        <@register.checkbox form="validateDetailUnionDemoSlavebInfoForm" name="checkboxStaticb2" label="静态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="true"/>
                        <#--静态模式- end -->
                        <#--动态模式-start-->
                        <#assign options=dicCheckbox['application_code,application_code']/>
                        <@register.checkbox form="validateDetailUnionDemoSlavebInfoForm" name="checkboxDynamicb2" label="动态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="true"/>
                        <#--动态模式- end -->
                        <div class="form-group">
                            <label class="col-lg-3 title">创建日期：</label>
                            <div class="col-lg-9">
                                <input id="createDateb2" name="createDateb2"  class="form-control" placeholder="创建日期" type="text" disabled="disabled"/>
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




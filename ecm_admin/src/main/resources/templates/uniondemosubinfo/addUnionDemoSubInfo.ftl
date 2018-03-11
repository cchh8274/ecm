<#import "/component/register.ftl" as  register/>

<#macro addUnionDemoSubInfoHtml>
    <div class="modal fade" id="addUnionDemoSubInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateAddUnionDemoSubInfoForm" method="post" class="form-horizontal">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">新增联表查询DEMO-子表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>演示名称：</label>
                            <div class="col-lg-9">
                                <input id="demoNmc1" name="demoNmc1"  class="form-control" placeholder="演示名称" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>创建时间：</label>
                            <div class="col-lg-9">
                                <input id="createTimec1" name="createTimec1"  class="form-control" placeholder="创建时间" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>演示金额：</label>
                            <div class="col-lg-9">
                                <input id="demoMoneyc1" name="demoMoneyc1"  class="form-control" placeholder="演示金额" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>静态选择框：</label>
                            <div class="col-lg-9">
                                <select class="form-control select2" id="selectStaticc1" name="selectStaticc1">
                                    <#--静态模式-start-->
                                    <#assign options={"010":"正常","020":"禁用","030":"失效"}/>
                                    <#list options?keys as key >
                                        <option value="${key}">${options[key]}</option>
                                    </#list>
                                    <#--静态模式- end -->
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>动态选择框：</label>
                            <div class="col-lg-9">
                                <select class="form-control select2" id="selectDynamicc1" name="selectDynamicc1">
                                    <#--动态模式-start-->
                                    <#assign options=dicList['application_code,application_code']/>
                                    <#list options as item >
                                        <option value="${item.codeParam}">${item.codeValue}</option>
                                    </#list>
                                    <#--动态模式- end -->
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>静态单选按钮：</label>
                            <div class="col-lg-9">
                                <#--静态模式-start-->
                                <#assign options={"010":"正常","020":"禁用","030":"失效"}/>
                                <#list options?keys as key >
                                <label class="radio-inline">
                                    <input type="radio" id="radioStaticc1_${key}" name="radioStaticc1" value="${key}">${options[key]}
                                </label>
                                </#list>
                                <#--静态模式- end -->
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>动态单选按钮：</label>
                            <div class="col-lg-9">
                                <#--动态模式-start-->
                                <#assign options=dicList['application_code,application_code']/>
                                <#list options as item >
                                <label class="radio-inline">
                                    <input type="radio" id="radioDynamicc1_${item.codeParam}" name="radioDynamicc1" value="${item.codeParam}">${item.codeValue}
                                </label>
                                </#list>
                                <#--动态模式- end -->
                            </div>
                        </div>
                        <#--静态模式-start-->
                        <#assign options=["正常","禁用","失效"]/>
                        <@register.checkbox form="validateAddUnionDemoSubInfoForm" name="checkboxStaticc1" label="静态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                        <#--静态模式- end -->
                        <#--动态模式-start-->
                        <#assign options=dicCheckbox['application_code,application_code']/>
                        <@register.checkbox form="validateAddUnionDemoSubInfoForm" name="checkboxDynamicc1" label="动态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                        <#--动态模式- end -->
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>创建日期：</label>
                            <div class="col-lg-9">
                                <input id="createDatec1" name="createDatec1"  class="form-control" placeholder="创建日期" type="text"/>
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



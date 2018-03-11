<#import "/component/register.ftl" as  register/>

<#macro detailUnionUnionDemoInfoHtml>
    <div class="modal fade" id="detailUnionUnionDemoInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateDetailUnionUnionDemoInfoForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">查看联表查询DEMO</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title">表ID：</label>
                            <div class="col-lg-9">
                                <input id="demoId2" name="demoId2"  class="form-control" placeholder="表ID" type="text" disabled="disabled"/>
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
                                <input id="demoNm2" name="demoNm2"  class="form-control" placeholder="演示名称" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">创建时间：</label>
                            <div class="col-lg-9">
                                <input id="createTime2" name="createTime2"  class="form-control" placeholder="创建时间" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">整数：</label>
                            <div class="col-lg-9">
                                <input id="countNumber2" name="countNumber2"  class="form-control" placeholder="整数" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">演示金额：</label>
                            <div class="col-lg-9">
                                <input id="demoMoney2" name="demoMoney2"  class="form-control" placeholder="演示金额" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">静态选择框：</label>
                            <div class="col-lg-9">
                                <input id="selectStatic2" name="selectStatic2"  class="form-control" placeholder="静态选择框" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">动态选择框：</label>
                            <div class="col-lg-9">
                                <input id="selectDynamic2" name="selectDynamic2"  class="form-control" placeholder="动态选择框" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">静态单选按钮：</label>
                            <div class="col-lg-9">
                                <input id="radioStatic2" name="radioStatic2"  class="form-control" placeholder="静态单选按钮" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">动态单选按钮：</label>
                            <div class="col-lg-9">
                                <input id="radioDynamic2" name="radioDynamic2"  class="form-control" placeholder="动态单选按钮" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <#--静态模式-start-->
                        <#assign options=["正常","禁用","失效"]/>
                        <@register.checkbox form="validateDetailUnionUnionDemoInfoForm" name="checkboxStatic2" label="静态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="true"/>
                        <#--静态模式- end -->
                        <#--动态模式-start-->
                        <#assign options=dicCheckbox['application_code,application_code']/>
                        <@register.checkbox form="validateDetailUnionUnionDemoInfoForm" name="checkboxDynamic2" label="动态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="true"/>
                        <#--动态模式- end -->
                        <div class="form-group">
                            <label class="col-lg-3 title">创建日期：</label>
                            <div class="col-lg-9">
                                <input id="createDate2" name="createDate2"  class="form-control" placeholder="创建日期" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">表ID：</label>
                            <div class="col-lg-9">
                                <input id="demoIda2" name="demoIda2"  class="form-control" placeholder="表ID" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">演示名称：</label>
                            <div class="col-lg-9">
                                <input id="demoNma2" name="demoNma2"  class="form-control" placeholder="演示名称" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">创建时间：</label>
                            <div class="col-lg-9">
                                <input id="createTimea2" name="createTimea2"  class="form-control" placeholder="创建时间" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">整数：</label>
                            <div class="col-lg-9">
                                <input id="countNumbera2" name="countNumbera2"  class="form-control" placeholder="整数" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">演示金额：</label>
                            <div class="col-lg-9">
                                <input id="demoMoneya2" name="demoMoneya2"  class="form-control" placeholder="演示金额" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">静态选择框：</label>
                            <div class="col-lg-9">
                                <input id="selectStatica2" name="selectStatica2"  class="form-control" placeholder="静态选择框" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">动态选择框：</label>
                            <div class="col-lg-9">
                                <input id="selectDynamica2" name="selectDynamica2"  class="form-control" placeholder="动态选择框" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">静态单选按钮：</label>
                            <div class="col-lg-9">
                                <input id="radioStatica2" name="radioStatica2"  class="form-control" placeholder="静态单选按钮" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">动态单选按钮：</label>
                            <div class="col-lg-9">
                                <input id="radioDynamica2" name="radioDynamica2"  class="form-control" placeholder="动态单选按钮" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <#--静态模式-start-->
                        <#assign options=["正常","禁用","失效"]/>
                        <@register.checkbox form="validateDetailUnionUnionDemoInfoForm" name="checkboxStatica2" label="静态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="true"/>
                        <#--静态模式- end -->
                        <#--动态模式-start-->
                        <#assign options=dicCheckbox['application_code,application_code']/>
                        <@register.checkbox form="validateDetailUnionUnionDemoInfoForm" name="checkboxDynamica2" label="动态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="true"/>
                        <#--动态模式- end -->
                        <div class="form-group">
                            <label class="col-lg-3 title">创建日期：</label>
                            <div class="col-lg-9">
                                <input id="createDatea2" name="createDatea2"  class="form-control" placeholder="创建日期" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">表ID：</label>
                            <div class="col-lg-9">
                                <input id="demoIdb2" name="demoIdb2"  class="form-control" placeholder="表ID" type="text" disabled="disabled"/>
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
                        <@register.checkbox form="validateDetailUnionUnionDemoInfoForm" name="checkboxStaticb2" label="静态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="true"/>
                        <#--静态模式- end -->
                        <#--动态模式-start-->
                        <#assign options=dicCheckbox['application_code,application_code']/>
                        <@register.checkbox form="validateDetailUnionUnionDemoInfoForm" name="checkboxDynamicb2" label="动态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="true"/>
                        <#--动态模式- end -->
                        <div class="form-group">
                            <label class="col-lg-3 title">创建日期：</label>
                            <div class="col-lg-9">
                                <input id="createDateb2" name="createDateb2"  class="form-control" placeholder="创建日期" type="text" disabled="disabled"/>
                            </div>
                        </div>
                    </div>
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">查看联表查询DEMO-子表</h4>
                    </div>
                    <div id="subContent2" class="subContent">
                        <div class="subContentScoll">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" onclick ="closeModel()" data-dismiss="modal">关闭</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        function detailUnionUnionDemoInfoSub(type){
            var subNum = $("#validateDetailUnionUnionDemoInfoForm .sub2_").length;
            var divStr = '<div id="sub2_'+subNum+'" class="sub2_ sub_" subNum="'+subNum+'">';
                divStr+='<div class="modal-body addList">';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>表ID：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<input id="demoIdc2_'+subNum+'" name="demoIdc2_'+subNum+'"  class="form-control" placeholder="表ID" readonly="readonly" type="text"/>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>表ID：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<input id="forgienId2_'+subNum+'" name="forgienId2_'+subNum+'"  class="form-control" placeholder="表ID" readonly="readonly" type="text"/>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>演示名称：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<input id="demoNmc2_'+subNum+'" name="demoNmc2_'+subNum+'"  class="form-control" placeholder="演示名称" readonly="readonly" type="text"/>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>创建时间：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<input id="createTimec2_'+subNum+'" name="createTimec2_'+subNum+'"  class="form-control" placeholder="创建时间" readonly="readonly" type="text"/>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>整数：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<input id="countNumberc2_'+subNum+'" name="countNumberc2_'+subNum+'"  class="form-control" placeholder="整数" readonly="readonly" type="text"/>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>演示金额：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<input id="demoMoneyc2_'+subNum+'" name="demoMoneyc2_'+subNum+'"  class="form-control" placeholder="演示金额" readonly="readonly" type="text"/>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>静态选择框：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<input type="text" id="selectStaticc2_'+subNum+'"  class="form-control" name="selectStaticc2_'+subNum+'" readonly="readonly"  disabled="disabled"/>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>动态选择框：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<input type="text" id="selectDynamicc2_'+subNum+'"  class="form-control" name="selectDynamicc2_'+subNum+'" readonly="readonly"  disabled="disabled"/>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>静态单选按钮：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<input type="text" id="radioStaticc2_'+subNum+'"  class="form-control" name="radioStaticc2_'+subNum+'" readonly="readonly"  disabled="disabled"/>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>动态单选按钮：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<input type="text" id="radioDynamicc2_'+subNum+'"  class="form-control" name="radioDynamicc2_'+subNum+'" readonly="readonly"  disabled="disabled"/>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group addqure">';
                        divStr+='<label class="col-lg-3 title">静态复选框：</label>';
                        divStr+='<div class="checkbox_validateDetailUnionUnionDemoInfoForm_checkboxStaticc2_'+subNum+' col-lg-9">';
                            divStr+='<#assign options=["正常","禁用","失效"]/>';
                            divStr+='<#assign idx=0/>';
                            divStr+='<input type="text" id="validateDetailUnionUnionDemoInfoForm_checkboxStaticc2_'+subNum+'" name="validateDetailUnionUnionDemoInfoForm_checkboxStaticc2_'+subNum+'" style="display:none" value="" >';
                            divStr+='<#list options as item >';
                                divStr+='<label class="checkbox-inline">';
                                    divStr+='<input type="checkbox" class="inline1" id="checkedBox_validateDetailUnionUnionDemoInfoForm_checkboxStaticc2_'+subNum+'_${idx}" name="validateDetailUnionUnionDemoInfoForm_checkboxStaticc2_'+subNum+'" value="${item}" onclick="return false;">${options[idx]}';
                                divStr+='</label>';
                                divStr+='<#assign idx=idx+1/>';
                            divStr+='</#list>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group addqure">';
                        divStr+='<label class="col-lg-3 title">动态复选框：</label>';
                        divStr+='<div class="checkbox_validateDetailUnionUnionDemoInfoForm_checkboxDynamicc2_'+subNum+' col-lg-9">';
                            divStr+='<#assign options=dicCheckbox["application_code,application_code"]/>';
                            divStr+='<#assign idx=0/>';
                            divStr+='<input type="text" id="validateDetailUnionUnionDemoInfoForm_checkboxDynamicc2_'+subNum+'" name="validateDetailUnionUnionDemoInfoForm_checkboxDynamicc2_'+subNum+'" style="display:none" value="" >';
                            divStr+='<#list options as item >';
                                divStr+='<label class="checkbox-inline">';
                                    divStr+='<input type="checkbox" class="inline1" id="checkedBox_validateDetailUnionUnionDemoInfoForm_checkboxDynamicc2_'+subNum+'_${idx}" name="validateDetailUnionUnionDemoInfoForm_checkboxDynamicc2_'+subNum+'" value="${item}" onclick="return false;">${options[idx]}';
                                divStr+='</label>';
                                divStr+='<#assign idx=idx+1/>';
                            divStr+='</#list>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>创建日期：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<input id="createDatec2_'+subNum+'" name="createDatec2_'+subNum+'"  class="form-control" placeholder="创建日期" readonly="readonly" type="text"/>';
                        divStr+='</div>';
                    divStr+='</div>';
                divStr+='</div>';
            divStr+='</div>';
            $("#validateDetailUnionUnionDemoInfoForm #subContent2 div:first").append(divStr);
        }
    </script>
    <style>
        <#--一下代码用于覆盖new.css中的样式-->
        <#--调整弹出框宽度-->
        #validateDetailUnionUnionDemoInfoForm .modal-content{
            width:800px;
        }
        <#--调整子表宽度-->
        #validateDetailUnionUnionDemoInfoForm .sub_ .modal-body{
            width:1600px;
        }
        #validateDetailUnionUnionDemoInfoForm .sub_ .modal-body .form-group{float: left;}
        #validateDetailUnionUnionDemoInfoForm .sub_ .addList{padding:0; padding: 0 20px;}
        #validateDetailUnionUnionDemoInfoForm .addList .addqure{width:14%;}
        #validateDetailUnionUnionDemoInfoForm .sub_ .addList .addqure .radio-inline{ width: 33%;float: left;  margin: 0;}
        #validateDetailUnionUnionDemoInfoForm .sub_ .addList .addqure .checkbox-inline{ width: 33%;float: left;  margin: 0;}
        #validateDetailUnionUnionDemoInfoForm .sub_ .addList .col-lg-9{padding:0px;}
    </style>
</#macro>




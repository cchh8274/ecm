<#import "/component/register.ftl" as  register/>

<#macro updateUnionUnionDemoInfoHtml>
    <div class="modal fade" id="updateUnionUnionDemoInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateUpdateUnionUnionDemoInfoForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">修改联表查询DEMO</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>表ID：</label>
                            <div class="col-lg-9">
                                <input id="demoId3" name="demoId3"  class="form-control" placeholder="表ID" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>表ID：</label>
                            <div class="col-lg-9">
                                <input id="forgienId3" name="forgienId3"  class="form-control" placeholder="表ID" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>演示名称：</label>
                            <div class="col-lg-9">
                                <input id="demoNm3" name="demoNm3"  class="form-control" placeholder="演示名称" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>创建时间：</label>
                            <div class="col-lg-9">
                                <input id="createTime3" name="createTime3"  class="form-control" placeholder="创建时间" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>整数：</label>
                            <div class="col-lg-9">
                                <input id="countNumber3" name="countNumber3"  class="form-control" placeholder="整数" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>演示金额：</label>
                            <div class="col-lg-9">
                                <input id="demoMoney3" name="demoMoney3"  class="form-control" placeholder="演示金额" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>静态选择框：</label>
                            <div class="col-lg-9">
                                <select class="form-control select2" id="selectStatic3" name="selectStatic3">
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
                                <select class="form-control select2" id="selectDynamic3" name="selectDynamic3">
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
                                    <input type="radio" id="radioStatic3_${key}" name="radioStatic3" value="${key}">${options[key]}
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
                                    <input type="radio" id="radioDynamic3_${item.codeParam}" name="radioDynamic3" value="${item.codeParam}">${item.codeValue}
                                </label>
                                </#list>
                                <#--动态模式- end -->
                            </div>
                        </div>
                        <#--静态模式-start-->
                        <#assign options=["正常","禁用","失效"]/>
                        <@register.checkbox form="validateUpdateUnionUnionDemoInfoForm" name="checkboxStatic3" label="静态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                        <#--静态模式- end -->
                        <#--动态模式-start-->
                        <#assign options=dicCheckbox['application_code,application_code']/>
                        <@register.checkbox form="validateUpdateUnionUnionDemoInfoForm" name="checkboxDynamic3" label="动态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                        <#--动态模式- end -->
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>创建日期：</label>
                            <div class="col-lg-9">
                                <input id="createDate3" name="createDate3"  class="form-control" placeholder="创建日期" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>表ID：</label>
                            <div class="col-lg-9">
                                <input id="demoIda3" name="demoIda3"  class="form-control" placeholder="表ID" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>演示名称：</label>
                            <div class="col-lg-9">
                                <input id="demoNma3" name="demoNma3"  class="form-control" placeholder="演示名称" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>创建时间：</label>
                            <div class="col-lg-9">
                                <input id="createTimea3" name="createTimea3"  class="form-control" placeholder="创建时间" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>整数：</label>
                            <div class="col-lg-9">
                                <input id="countNumbera3" name="countNumbera3"  class="form-control" placeholder="整数" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>演示金额：</label>
                            <div class="col-lg-9">
                                <input id="demoMoneya3" name="demoMoneya3"  class="form-control" placeholder="演示金额" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>静态选择框：</label>
                            <div class="col-lg-9">
                                <select class="form-control select2" id="selectStatica3" name="selectStatica3">
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
                                <select class="form-control select2" id="selectDynamica3" name="selectDynamica3">
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
                                    <input type="radio" id="radioStatica3_${key}" name="radioStatica3" value="${key}">${options[key]}
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
                                    <input type="radio" id="radioDynamica3_${item.codeParam}" name="radioDynamica3" value="${item.codeParam}">${item.codeValue}
                                </label>
                                </#list>
                                <#--动态模式- end -->
                            </div>
                        </div>
                        <#--静态模式-start-->
                        <#assign options=["正常","禁用","失效"]/>
                        <@register.checkbox form="validateUpdateUnionUnionDemoInfoForm" name="checkboxStatica3" label="静态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                        <#--静态模式- end -->
                        <#--动态模式-start-->
                        <#assign options=dicCheckbox['application_code,application_code']/>
                        <@register.checkbox form="validateUpdateUnionUnionDemoInfoForm" name="checkboxDynamica3" label="动态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                        <#--动态模式- end -->
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>创建日期：</label>
                            <div class="col-lg-9">
                                <input id="createDatea3" name="createDatea3"  class="form-control" placeholder="创建日期" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>表ID：</label>
                            <div class="col-lg-9">
                                <input id="demoIdb3" name="demoIdb3"  class="form-control" placeholder="表ID" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>演示名称：</label>
                            <div class="col-lg-9">
                                <input id="demoNmb3" name="demoNmb3"  class="form-control" placeholder="演示名称" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>创建时间：</label>
                            <div class="col-lg-9">
                                <input id="createTimeb3" name="createTimeb3"  class="form-control" placeholder="创建时间" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>整数：</label>
                            <div class="col-lg-9">
                                <input id="countNumberb3" name="countNumberb3"  class="form-control" placeholder="整数" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>演示金额：</label>
                            <div class="col-lg-9">
                                <input id="demoMoneyb3" name="demoMoneyb3"  class="form-control" placeholder="演示金额" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>静态选择框：</label>
                            <div class="col-lg-9">
                                <select class="form-control select2" id="selectStaticb3" name="selectStaticb3">
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
                                <select class="form-control select2" id="selectDynamicb3" name="selectDynamicb3">
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
                                    <input type="radio" id="radioStaticb3_${key}" name="radioStaticb3" value="${key}">${options[key]}
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
                                    <input type="radio" id="radioDynamicb3_${item.codeParam}" name="radioDynamicb3" value="${item.codeParam}">${item.codeValue}
                                </label>
                                </#list>
                                <#--动态模式- end -->
                            </div>
                        </div>
                        <#--静态模式-start-->
                        <#assign options=["正常","禁用","失效"]/>
                        <@register.checkbox form="validateUpdateUnionUnionDemoInfoForm" name="checkboxStaticb3" label="静态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                        <#--静态模式- end -->
                        <#--动态模式-start-->
                        <#assign options=dicCheckbox['application_code,application_code']/>
                        <@register.checkbox form="validateUpdateUnionUnionDemoInfoForm" name="checkboxDynamicb3" label="动态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                        <#--动态模式- end -->
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>创建日期：</label>
                            <div class="col-lg-9">
                                <input id="createDateb3" name="createDateb3"  class="form-control" placeholder="创建日期" type="text"/>
                            </div>
                        </div>
                    </div>
                    <#--添加子表信息-->
                    <div style="width:108px;margin:10px 0px;"><button type="button" class="btn btn-block btn-success" data-toggle="modal" onclick="updateUnionUnionDemoInfoSub();">添加子表信息</button></div>
                    <div id="subContent3" class="subContent">
                        <div class="subContentScoll"></div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">提交更改</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        function updateUnionUnionDemoInfoSub(){
            var subNum = $("#validateUpdateUnionUnionDemoInfoForm .sub3_").length;
            var divStr = '<div id="sub3_'+subNum+'" class="sub3_ sub_" subNum="'+subNum+'">';
                divStr+='<div class="modal-body addList">';
                    divStr+='<div class="form-group closebutton">';
                        divStr+='<label class="col-lg-3 title"></label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<button type="button" class="close" onclick=colseSub("validateUpdateUnionUnionDemoInfoForm","sub3_'+subNum+'")>&times;</button>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>演示名称：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<input id="demoNmc3_'+subNum+'" name="demoNmc3_'+subNum+'"  class="form-control" placeholder="演示名称" type="text"/>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>创建时间：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<input id="createTimec3_'+subNum+'" name="createTimec3_'+subNum+'"  class="form-control" placeholder="创建时间" type="text"/>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>演示金额：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<input id="demoMoneyc3_'+subNum+'" name="demoMoneyc3_'+subNum+'"  class="form-control" placeholder="演示金额" type="text"/>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>静态选择框：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<select class="form-control select2" id="selectStaticc3_'+subNum+'" name="selectStaticc3_'+subNum+'">';
                                divStr+='<#assign options={"010":"正常","020":"禁用","030":"失效"}/>';
                                divStr+='<#list options?keys as key >';
                                    divStr+='<option value="${key}">${options[key]}</option>';
                                divStr+='</#list>';
                            divStr+='</select>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>动态选择框：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<select class="form-control select2" id="selectDynamicc3_'+subNum+'" name="selectDynamicc3_'+subNum+'">';
                                divStr+='<#assign options=dicList['application_code,application_code']/>';
                                divStr+='<#list options as item >';
                                    divStr+='<option value="${item.codeParam}">${item.codeValue}</option>';
                                divStr+='</#list>';
                            divStr+='</select>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group addqure">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>静态单选按钮：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<#assign options={"010":"正常","020":"禁用","030":"失效"}/>';
                            divStr+='<#list options?keys as key >';
                                divStr+='<label class="radio-inline">';
                                divStr+='<input type="radio" id="radioStaticc3_'+subNum+'_${key}" name="radioStaticc3_'+subNum+'" value="${key}">${options[key]}';
                                divStr+='</label>';
                            divStr+='</#list>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group addqure">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>动态单选按钮：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<#assign options=dicList["application_code,application_code"]/>';
                            divStr+='<#list options as item >';
                                divStr+='<label class="radio-inline">';
                                divStr+='<input type="radio" id="radioDynamicc3_'+subNum+'_${item.codeParam}" name="radioDynamicc3_'+subNum+'" value="${item.codeParam}">${item.codeValue}';
                                divStr+='</label>';
                            divStr+='</#list>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group addqure">';
                        divStr+='<label class="col-lg-3 title">静态复选框：</label>';
                        divStr+='<div class="checkbox_validateUpdateUnionUnionDemoInfoForm_checkboxStaticc3_'+subNum+' col-lg-9">';
                            divStr+='<#assign options=["正常","禁用","失效"]/>';
                            divStr+='<#assign idx=0/>';
                            divStr+='<input type="text" id="validateUpdateUnionUnionDemoInfoForm_checkboxStaticc3_'+subNum+'" name="validateUpdateUnionUnionDemoInfoForm_checkboxStaticc3_'+subNum+'" style="display:none" value="" >';
                            divStr+='<#list options as item >';
                                divStr+='<label class="checkbox-inline">';
                                    divStr+='<input type="checkbox" class="inline1" id="checkedBox_validateUpdateUnionUnionDemoInfoForm_checkboxStaticc3_'+subNum+'_${idx}" name="validateUpdateUnionUnionDemoInfoForm_checkboxStaticc3_'+subNum+'" value="${item}" onclick=flushCheckBox2FieldVal("validateUpdateUnionUnionDemoInfoForm","checkboxStaticc3_'+subNum+'")>${options[idx]}';
                                divStr+='</label>';
                                divStr+='<#assign idx=idx+1/>';
                            divStr+='</#list>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group addqure">';
                        divStr+='<label class="col-lg-3 title">动态复选框：</label>';
                        divStr+='<div class="checkbox_validateUpdateUnionUnionDemoInfoForm_checkboxDynamicc3_'+subNum+' col-lg-9">';
                            divStr+='<#assign options=dicCheckbox["application_code,application_code"]/>';
                            divStr+='<#assign idx=0/>';
                            divStr+='<input type="text" id="validateUpdateUnionUnionDemoInfoForm_checkboxDynamicc3_'+subNum+'" name="validateUpdateUnionUnionDemoInfoForm_checkboxDynamicc3_'+subNum+'" style="display:none" value="" >';
                            divStr+='<#list options as item >';
                                divStr+='<label class="checkbox-inline">';
                                    divStr+='<input type="checkbox" class="inline1" id="checkedBox_validateUpdateUnionUnionDemoInfoForm_checkboxDynamicc3_'+subNum+'_${idx}" name="validateUpdateUnionUnionDemoInfoForm_checkboxDynamicc3_'+subNum+'" value="${item}" onclick=flushCheckBox2FieldVal("validateUpdateUnionUnionDemoInfoForm","checkboxDynamicc3_'+subNum+'")>${options[idx]}';
                                divStr+='</label>';
                                divStr+='<#assign idx=idx+1/>';
                            divStr+='</#list>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>创建日期：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<input id="createDatec3_'+subNum+'" name="createDatec3_'+subNum+'"  class="form-control" placeholder="创建日期" type="text"/>';
                        divStr+='</div>';
                    divStr+='</div>';
                divStr+='</div>';
            divStr+='</div>';
            $("#validateUpdateUnionUnionDemoInfoForm #subContent3 div:first").append(divStr);
            $('#validateUpdateUnionUnionDemoInfoForm #createTimec3_'+subNum).ECalendar({
                type:"time",
                stamp : false,
                offset:[0,2],
                format:"yyyy-mm-dd hh:ii:ss",
                skin:1,
                step:1,
                callback:function(v,e){
                    $("#validateUpdateUnionUnionDemoInfoForm").data('bootstrapValidator').updateStatus("createTimec3_"+subNum,"NOT_VALIDATED",null);
                    $("#validateUpdateUnionUnionDemoInfoForm").data('bootstrapValidator').validateField("createTimec3_"+subNum);
                } //回调函数
            });
            $('#validateUpdateUnionUnionDemoInfoForm #createDatec3_'+subNum).ECalendar({
                type:"date",
                stamp : false,
                offset:[0,2],
                format:"yyyy-mm-dd",
                skin:1,
                callback:function(v,e){
                    $("#validateUpdateUnionUnionDemoInfoForm").data('bootstrapValidator').updateStatus("createDatec3_"+subNum,"NOT_VALIDATED",null);
                    $("#validateUpdateUnionUnionDemoInfoForm").data('bootstrapValidator').validateField("createDatec3_"+subNum);
                } //回调函数
            });


            $("#validateUpdateUnionUnionDemoInfoForm").data('bootstrapValidator').addField('demoNmc3_'+subNum,{
                validators : {"notEmpty":{"message":"演示名称不能为空"},"stringLength":{"min":1,"max":100,"message":"演示名称长度不正确"},"regexp":{"regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$","message":"演示名称只能是中文、英文、数字与下划线"}}
            });
            $("#validateUpdateUnionUnionDemoInfoForm").data('bootstrapValidator').addField('createTimec3_'+subNum,{
                validators : {
                    notEmpty : {
                        message : 'XX信息不能为空'
                    },
                    stringLength : {
                        min : 1,
                        max : 100,
                        message : 'XX信息长度不正确'
                    },
                    regexp : {
                        regexp : "^.+$",
                        message : 'XX信息与要求的格式不符'
                    }
                }
            });
            $("#validateUpdateUnionUnionDemoInfoForm").data('bootstrapValidator').addField('demoMoneyc3_'+subNum,{
                validators : {"notEmpty":{"message":"演示金额不能为空"},"stringLength":{"min":1,"max":100,"message":"演示金额长度不正确"},"regexp":{"regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$","message":"演示金额格式不符"}}
            });
            $("#validateUpdateUnionUnionDemoInfoForm").data('bootstrapValidator').addField('selectStaticc3_'+subNum,{
                validators : {"notEmpty":{"message":"请选择一个静态选择框"}}
            });
            $("#validateUpdateUnionUnionDemoInfoForm").data('bootstrapValidator').addField('selectDynamicc3_'+subNum,{
                validators : {"notEmpty":{"message":"请选择一个动态选择框"}}
            });
            $("#validateUpdateUnionUnionDemoInfoForm").data('bootstrapValidator').addField('radioStaticc3_'+subNum,{
                validators : {"notEmpty":{"message":"请选择一个静态单选按钮"}}
            });
            $("#validateUpdateUnionUnionDemoInfoForm").data('bootstrapValidator').addField('radioDynamicc3_'+subNum,{
                validators : {"notEmpty":{"message":"请选择一个动态单选按钮"}}
            });
            $("#validateUpdateUnionUnionDemoInfoForm").data('bootstrapValidator').addField('createDatec3_'+subNum,{
                validators : {
                    notEmpty : {
                        message : 'XX信息不能为空'
                    },
                    stringLength : {
                        min : 1,
                        max : 100,
                        message : 'XX信息长度不正确'
                    },
                    regexp : {
                        regexp : "^.+$",
                        message : 'XX信息与要求的格式不符'
                    }
                }
            });

        }
    </script>
    <style>
        <#--一下代码用于覆盖new.css中的样式-->
        <#--调整弹出框宽度-->
        #validateUpdateUnionUnionDemoInfoForm .modal-content{
            width:800px;
        }
        <#--调整子表宽度-->
        #validateUpdateUnionUnionDemoInfoForm .sub_ .modal-body{
            width:1600px;
        }
        #validateUpdateUnionUnionDemoInfoForm .sub_ .modal-body .form-group{float: left;}
        #validateUpdateUnionUnionDemoInfoForm .sub_ .addList{padding:0; padding: 0 20px;}
        #validateUpdateUnionUnionDemoInfoForm .addList .addqure{width:14%;}
        #validateUpdateUnionUnionDemoInfoForm .sub_ .addList .addqure .radio-inline{ width: 33%;float: left;  margin: 0;}
        #validateUpdateUnionUnionDemoInfoForm .sub_ .addList .addqure .checkbox-inline{ width: 33%;float: left;  margin: 0;}
        #validateUpdateUnionUnionDemoInfoForm .sub_ .addList .col-lg-9{padding:0px;}
    </style>
</#macro>




<#import "/component/register.ftl" as  register/>

<#macro addUnionUnionDemoInfoHtml>
    <div class="modal fade" id="addUnionUnionDemoInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateAddUnionUnionDemoInfoForm" method="post" class="form-horizontal">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">新增联表查询DEMO</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>演示名称：</label>
                            <div class="col-lg-9">
                                <input id="demoNm1" name="demoNm1"  class="form-control" placeholder="演示名称" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>创建时间：</label>
                            <div class="col-lg-9">
                                <input id="createTime1" name="createTime1"  class="form-control" placeholder="创建时间" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>演示金额：</label>
                            <div class="col-lg-9">
                                <input id="demoMoney1" name="demoMoney1"  class="form-control" placeholder="演示金额" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>静态选择框：</label>
                            <div class="col-lg-9">
                                <select class="form-control select2" id="selectStatic1" name="selectStatic1">
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
                                <select class="form-control select2" id="selectDynamic1" name="selectDynamic1">
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
                                    <input type="radio" id="radioStatic1_${key}" name="radioStatic1" value="${key}">${options[key]}
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
                                    <input type="radio" id="radioDynamic1_${item.codeParam}" name="radioDynamic1" value="${item.codeParam}">${item.codeValue}
                                </label>
                                </#list>
                                <#--动态模式- end -->
                            </div>
                        </div>
                        <#--静态模式-start-->
                        <#assign options=["正常","禁用","失效"]/>
                        <@register.checkbox form="validateAddUnionUnionDemoInfoForm" name="checkboxStatic1" label="静态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                        <#--静态模式- end -->
                        <#--动态模式-start-->
                        <#assign options=dicCheckbox['application_code,application_code']/>
                        <@register.checkbox form="validateAddUnionUnionDemoInfoForm" name="checkboxDynamic1" label="动态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                        <#--动态模式- end -->
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>创建日期：</label>
                            <div class="col-lg-9">
                                <input id="createDate1" name="createDate1"  class="form-control" placeholder="创建日期" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>演示名称：</label>
                            <div class="col-lg-9">
                                <input id="demoNma1" name="demoNma1"  class="form-control" placeholder="演示名称" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>创建时间：</label>
                            <div class="col-lg-9">
                                <input id="createTimea1" name="createTimea1"  class="form-control" placeholder="创建时间" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>演示金额：</label>
                            <div class="col-lg-9">
                                <input id="demoMoneya1" name="demoMoneya1"  class="form-control" placeholder="演示金额" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>静态选择框：</label>
                            <div class="col-lg-9">
                                <select class="form-control select2" id="selectStatica1" name="selectStatica1">
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
                                <select class="form-control select2" id="selectDynamica1" name="selectDynamica1">
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
                                    <input type="radio" id="radioStatica1_${key}" name="radioStatica1" value="${key}">${options[key]}
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
                                    <input type="radio" id="radioDynamica1_${item.codeParam}" name="radioDynamica1" value="${item.codeParam}">${item.codeValue}
                                </label>
                                </#list>
                                <#--动态模式- end -->
                            </div>
                        </div>
                        <#--静态模式-start-->
                        <#assign options=["正常","禁用","失效"]/>
                        <@register.checkbox form="validateAddUnionUnionDemoInfoForm" name="checkboxStatica1" label="静态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                        <#--静态模式- end -->
                        <#--动态模式-start-->
                        <#assign options=dicCheckbox['application_code,application_code']/>
                        <@register.checkbox form="validateAddUnionUnionDemoInfoForm" name="checkboxDynamica1" label="动态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                        <#--动态模式- end -->
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>创建日期：</label>
                            <div class="col-lg-9">
                                <input id="createDatea1" name="createDatea1"  class="form-control" placeholder="创建日期" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>演示名称：</label>
                            <div class="col-lg-9">
                                <input id="demoNmb1" name="demoNmb1"  class="form-control" placeholder="演示名称" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>创建时间：</label>
                            <div class="col-lg-9">
                                <input id="createTimeb1" name="createTimeb1"  class="form-control" placeholder="创建时间" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>演示金额：</label>
                            <div class="col-lg-9">
                                <input id="demoMoneyb1" name="demoMoneyb1"  class="form-control" placeholder="演示金额" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>静态选择框：</label>
                            <div class="col-lg-9">
                                <select class="form-control select2" id="selectStaticb1" name="selectStaticb1">
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
                                <select class="form-control select2" id="selectDynamicb1" name="selectDynamicb1">
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
                                    <input type="radio" id="radioStaticb1_${key}" name="radioStaticb1" value="${key}">${options[key]}
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
                                    <input type="radio" id="radioDynamicb1_${item.codeParam}" name="radioDynamicb1" value="${item.codeParam}">${item.codeValue}
                                </label>
                                </#list>
                                <#--动态模式- end -->
                            </div>
                        </div>
                        <#--静态模式-start-->
                        <#assign options=["正常","禁用","失效"]/>
                        <@register.checkbox form="validateAddUnionUnionDemoInfoForm" name="checkboxStaticb1" label="静态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                        <#--静态模式- end -->
                        <#--动态模式-start-->
                        <#assign options=dicCheckbox['application_code,application_code']/>
                        <@register.checkbox form="validateAddUnionUnionDemoInfoForm" name="checkboxDynamicb1" label="动态复选框" options=options value=""
                        class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                        <#--动态模式- end -->
                        <div class="form-group">
                            <label class="col-lg-3 title"><i class="redFont">*</i>创建日期：</label>
                            <div class="col-lg-9">
                                <input id="createDateb1" name="createDateb1"  class="form-control" placeholder="创建日期" type="text"/>
                            </div>
                        </div>
                    </div>
                    <#--添加子表信息-->
                    <div style="width:108px;margin:10px 0px;"><button type="button" class="btn btn-block btn-success" data-toggle="modal" onclick="addUnionUnionDemoInfoSub();">添加子表信息</button></div>
                    <div id="subContent1" class="subContent">
                        <div class="subContentScoll"></div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">提交</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        function addUnionUnionDemoInfoSub(){
            var subNum = $("#validateAddUnionUnionDemoInfoForm .sub1_").length;
            var divStr = '<div id="sub1_'+subNum+'" class="sub1_ sub_" subNum="'+subNum+'">';
                divStr+='<div class="modal-body addList">';
                    divStr+='<div class="form-group closebutton">';
                        divStr+='<label class="col-lg-3 title"></label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<button type="button" class="close" onclick=colseSub("validateAddUnionUnionDemoInfoForm","sub1_'+subNum+'")>&times;</button>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>演示名称：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<input id="demoNmc1_'+subNum+'" name="demoNmc1_'+subNum+'"  class="form-control" placeholder="演示名称" type="text"/>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>创建时间：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<input id="createTimec1_'+subNum+'" name="createTimec1_'+subNum+'"  class="form-control" placeholder="创建时间" type="text"/>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>演示金额：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<input id="demoMoneyc1_'+subNum+'" name="demoMoneyc1_'+subNum+'"  class="form-control" placeholder="演示金额" type="text"/>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>静态选择框：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<select class="form-control select2" id="selectStaticc1_'+subNum+'" name="selectStaticc1_'+subNum+'">';
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
                            divStr+='<select class="form-control select2" id="selectDynamicc1_'+subNum+'" name="selectDynamicc1_'+subNum+'">';
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
                                divStr+='<input type="radio" id="radioStaticc1_'+subNum+'_${key}" name="radioStaticc1_'+subNum+'" value="${key}">${options[key]}';
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
                                divStr+='<input type="radio" id="radioDynamicc1_'+subNum+'_${item.codeParam}" name="radioDynamicc1_'+subNum+'" value="${item.codeParam}">${item.codeValue}';
                                divStr+='</label>';
                            divStr+='</#list>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group addqure">';
                        divStr+='<label class="col-lg-3 title">静态复选框：</label>';
                        divStr+='<div class="checkbox_validateAddUnionUnionDemoInfoForm_checkboxStaticc1_'+subNum+' col-lg-9">';
                            divStr+='<#assign options=["正常","禁用","失效"]/>';
                            divStr+='<#assign idx=0/>';
                            divStr+='<input type="text" id="validateAddUnionUnionDemoInfoForm_checkboxStaticc1_'+subNum+'" name="validateAddUnionUnionDemoInfoForm_checkboxStaticc1_'+subNum+'" style="display:none" value="" >';
                            divStr+='<#list options as item >';
                                divStr+='<label class="checkbox-inline">';
                                    divStr+='<input type="checkbox" class="inline1" id="checkedBox_validateAddUnionUnionDemoInfoForm_checkboxStaticc1_'+subNum+'_${idx}" name="validateAddUnionUnionDemoInfoForm_checkboxStaticc1_'+subNum+'" value="${item}" onclick=flushCheckBox2FieldVal("validateAddUnionUnionDemoInfoForm","checkboxStaticc1_'+subNum+'")>${options[idx]}';
                                divStr+='</label>';
                                divStr+='<#assign idx=idx+1/>';
                            divStr+='</#list>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group addqure">';
                        divStr+='<label class="col-lg-3 title">动态复选框：</label>';
                        divStr+='<div class="checkbox_validateAddUnionUnionDemoInfoForm_checkboxDynamicc1_'+subNum+' col-lg-9">';
                            divStr+='<#assign options=dicCheckbox["application_code,application_code"]/>';
                            divStr+='<#assign idx=0/>';
                            divStr+='<input type="text" id="validateAddUnionUnionDemoInfoForm_checkboxDynamicc1_'+subNum+'" name="validateAddUnionUnionDemoInfoForm_checkboxDynamicc1_'+subNum+'" style="display:none" value="" >';
                            divStr+='<#list options as item >';
                                divStr+='<label class="checkbox-inline">';
                                    divStr+='<input type="checkbox" class="inline1" id="checkedBox_validateAddUnionUnionDemoInfoForm_checkboxDynamicc1_'+subNum+'_${idx}" name="validateAddUnionUnionDemoInfoForm_checkboxDynamicc1_'+subNum+'" value="${item}" onclick=flushCheckBox2FieldVal("validateAddUnionUnionDemoInfoForm","checkboxDynamicc1_'+subNum+'")>${options[idx]}';
                                divStr+='</label>';
                                divStr+='<#assign idx=idx+1/>';
                            divStr+='</#list>';
                        divStr+='</div>';
                    divStr+='</div>';
                    divStr+='<div class="form-group">';
                        divStr+='<label class="col-lg-3 title"><i class="redFont">*</i>创建日期：</label>';
                        divStr+='<div class="col-lg-9">';
                            divStr+='<input id="createDatec1_'+subNum+'" name="createDatec1_'+subNum+'"  class="form-control" placeholder="创建日期" type="text"/>';
                        divStr+='</div>';
                    divStr+='</div>';
                divStr+='</div>';
            divStr+='</div>';
            $("#validateAddUnionUnionDemoInfoForm #subContent1 div:first").append(divStr);
            $('#validateAddUnionUnionDemoInfoForm #createTimec1_'+subNum).ECalendar({
                type:"time",
                stamp : false,
                offset:[0,2],
                format:"yyyy-mm-dd hh:ii:ss",
                skin:1,
                step:1,
                callback:function(v,e){
                    $("#validateAddUnionUnionDemoInfoForm").data('bootstrapValidator').updateStatus("createTimec1_"+subNum,"NOT_VALIDATED",null);
                    $("#validateAddUnionUnionDemoInfoForm").data('bootstrapValidator').validateField("createTimec1_"+subNum);
                }
            });
            $('#validateAddUnionUnionDemoInfoForm #createDatec1_'+subNum).ECalendar({
                type:"date",
                stamp : false,
                offset:[0,2],
                format:"yyyy-mm-dd",
                skin:1,
                callback:function(v,e){
                    $("#validateAddUnionUnionDemoInfoForm").data('bootstrapValidator').updateStatus("createDatec1_"+subNum,"NOT_VALIDATED",null);
                    $("#validateAddUnionUnionDemoInfoForm").data('bootstrapValidator').validateField("createDatec1_"+subNum);
                } //回调函数
            });
            $("#validateAddUnionUnionDemoInfoForm").data('bootstrapValidator').addField('demoNmc1_'+subNum,{
                validators : {"notEmpty":{"message":"演示名称不能为空"},"stringLength":{"min":1,"max":100,"message":"演示名称长度不正确"},"regexp":{"regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$","message":"演示名称只能是中文、英文、数字与下划线"}}
            });
            $("#validateAddUnionUnionDemoInfoForm").data('bootstrapValidator').addField('createTimec1_'+subNum,{
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
            $("#validateAddUnionUnionDemoInfoForm").data('bootstrapValidator').addField('demoMoneyc1_'+subNum,{
                validators : {"notEmpty":{"message":"演示金额不能为空"},"stringLength":{"min":1,"max":100,"message":"演示金额长度不正确"},"regexp":{"regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$","message":"演示金额格式不符"}}
            });
            $("#validateAddUnionUnionDemoInfoForm").data('bootstrapValidator').addField('selectStaticc1_'+subNum,{
                validators : {"notEmpty":{"message":"请选择一个静态选择框"}}
            });
            $("#validateAddUnionUnionDemoInfoForm").data('bootstrapValidator').addField('selectDynamicc1_'+subNum,{
                validators : {"notEmpty":{"message":"请选择一个动态选择框"}}
            });
            $("#validateAddUnionUnionDemoInfoForm").data('bootstrapValidator').addField('radioStaticc1_'+subNum,{
                validators : {"notEmpty":{"message":"请选择一个静态单选按钮"}}
            });
            $("#validateAddUnionUnionDemoInfoForm").data('bootstrapValidator').addField('radioDynamicc1_'+subNum,{
                validators : {"notEmpty":{"message":"请选择一个动态单选按钮"}}
            });
            $("#validateAddUnionUnionDemoInfoForm").data('bootstrapValidator').addField('createDatec1_'+subNum,{
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
        #validateAddUnionUnionDemoInfoForm .modal-content{
            width:800px;
        }
        <#--调整子表宽度-->
        #validateAddUnionUnionDemoInfoForm .sub_ .modal-body{
            width:1600px;
        }
        #validateAddUnionUnionDemoInfoForm .sub_ .modal-body .form-group{float: left;}
        #validateAddUnionUnionDemoInfoForm .sub_ .addList{padding:0; padding: 0 20px;}
        #validateAddUnionUnionDemoInfoForm .addList .addqure{width:14%;}
        #validateAddUnionUnionDemoInfoForm .sub_ .addList .addqure .radio-inline{ width: 33%;float: left;  margin: 0;}
        #validateAddUnionUnionDemoInfoForm .sub_ .addList .addqure .checkbox-inline{ width: 33%;float: left;  margin: 0;}
        #validateAddUnionUnionDemoInfoForm .sub_ .addList .col-lg-9{padding:0px;}
    </style>
</#macro>



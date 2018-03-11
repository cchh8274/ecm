<#import "/component/register.ftl" as register/>
<#macro auditDemoInfoHtml>
<script>
    $(function() {
        $('#auditDemoInfo').on(
        'shown.bs.modal',
        function() {
            $('#validateAuditDemoInfoForm').bootstrapValidator('resetForm', false);
        });
        $("#validateAuditDemoInfoForm #createDate4").ECalendar({
            type:"date",
            stamp : false,
            offset:[0,2],
            format:"yyyy-mm-dd",
            skin:1,
            callback:function(v,e){revalidateDate("validateAuditDemoInfoForm", "createDate4");} //回调函数
        });
        $("#validateAuditDemoInfoForm #createTime4").ECalendar({
            type:"time",
            stamp : false,
            offset:[0,2],
            format:"yyyy-mm-dd hh:ii:ss",
            skin:1,
            step:1,
            callback:function(v,e){revalidateDate("validateAuditDemoInfoForm", "createTime4");} //回调函数
        });
        //审核DEMO表校验
        $('#validateAuditDemoInfoForm').bootstrapValidator({
            fields : {
                demoNm4 : {
                    validators : {"stringLength":{"message":"演示名称长度不正确","min":1,"max":100},"notEmpty":{"message":"演示名称不能为空"},"regexp":{"message":"演示名称只能是中文、英文、数字与下划线","regexp":"^[一-龥A-Za-z0-9_]+$"}}
                },
                demoMoney4 : {
                    validators : {"stringLength":{"message":"演示金额长度不正确","min":1,"max":100},"notEmpty":{"message":"演示金额不能为空"},"regexp":{"message":"演示金额格式不符","regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$"}}
                },
                createDate4 : {
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
                },
                createTime4 : {
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
                },
                 selectStatic4 : {
                     validators : {"notEmpty" : {"message" : "请选择一个静态选择框"}}
                 },
                 selectDynamic4 : {
                     validators : {"notEmpty" : {"message" : "请选择一个动态选择框"}}
                 },
                 radioStatic4 : {
                     validators : {"notEmpty" : {"message" : "请选择一个静态单选按钮"}}
                 },
                 radioDynamic4 : {
                     validators : {"notEmpty" : {"message" : "请选择一个动态单选按钮"}}
                 },
                 netAddress4 : {
                     validators : {"stringLength":{"message":"推送地址长度不正确","min":1,"max":500},"notEmpty":{"message":"推送地址不能为空"},"regexp":{"message":"推送地址只能是合法字符","regexp":"((http|ftp|https)://)(([a-zA-Z0-9._-]+.[a-zA-Z]{2,6})|([0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9&%_./-~-]*)?"}}
                 }
            }
        }).on('success.form.bv', function(e) {
            e.preventDefault();
            auditDemoInfo();
        });
    });
    function showAuditDemoInfoPage(id_key) {
        var url = webUrl + "/demoInfo/queryObject.dhtml";
        var params = {};
        params.id_key = id_key;
        var jsonStr = JSON.stringify(params);
        jsonStr = encodeURIComponent(jsonStr);
        $.ajax({
            type : "POST",
            url : url,
            timeout : 60000,
            dataType : 'json',
            data : "jsonStr=" + jsonStr,
            success : function(data) {
                if (data.code == "success") {
                    $('#auditDemoInfo').modal();
                    $("#validateAuditDemoInfoForm #id_key").val(data.rows[0].id_key);
                    var objInfo = data.rows[0].tblDemoInfo;
                    $("#validateAuditDemoInfoForm #demoId4").val(objInfo.demoId!= null?objInfo.demoId:'');
                    $("#validateAuditDemoInfoForm #demoNm4").val(objInfo.demoNm!= null?objInfo.demoNm:'');
                    $("#validateAuditDemoInfoForm #demoMoney4").val(objInfo.demoMoney!=null?objInfo.demoMoney:'');
                    $("#validateAuditDemoInfoForm #createDate4").val(objInfo.createDate!=null?objInfo.createDate:'');
                    $("#validateAuditDemoInfoForm #createTime4").val(objInfo.createTime!=null?objInfo.createTime:'');
                    $("#validateAuditDemoInfoForm #selectStatic4").val(objInfo.selectStatic != null?objInfo.selectStatic:'');
                    $("#validateAuditDemoInfoForm #selectDynamic4").val(objInfo.selectDynamic!=null?objInfo.selectDynamic:'');
                    //使用原生javascript对radio进行操作，避免浏览器不兼容问题
                    $("#validateAuditDemoInfoForm input[name='radioStatic4'][value='"+(objInfo.radioStatic!=null?objInfo.radioStatic:'')+"']")[0].checked=true;
                    //使用原生javascript对radio进行操作，避免浏览器不兼容问题
                    $("#validateAuditDemoInfoForm input[name='radioDynamic4'][value='"+(objInfo.radioDynamic!=null?objInfo.radioDynamic:'')+"']")[0].checked=true;
                    setCheckBoxVal("validateAuditDemoInfoForm","checkboxStatic4",(objInfo.checkboxStatic!=null?objInfo.checkboxStatic:''));
                    setCheckBoxVal("validateAuditDemoInfoForm","checkboxDynamic4",(objInfo.checkboxDynamic!=null?objInfo.checkboxDynamic: ''));
                    $("#validateAuditDemoInfoForm #netAddress4").val(objInfo.netAddress!=null?objInfo.netAddress:'');
                    $("#validateAuditDemoInfoForm #countNumber4").val(objInfo.countNumber != null ? objInfo.countNumber:'');
                } else {
                    layer.alert(data.message);
                }
            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {
                layer.alert('系统异常，请稍后重试！');
            },
            complete : function(XMLHttpRequest, status) {
                if (status == "timeout") {
                    ajaxTimeoutTest.abort();
                    layer.alert('操作超时！');
                }
            }
        });
    }
    function auditDemoInfo() {
        var url = webUrl + "/demoInfo/edit.dhtml";
        var params = {};
        params.id_key = $("#validateAuditDemoInfoForm #id_key").val();
        params.demoNm = $("#validateAuditDemoInfoForm #demoNm4").val();
        params.demoMoney = $("#validateAuditDemoInfoForm #demoMoney4").val();
        params.createDate = $("#validateAuditDemoInfoForm #createDate4").val();
        params.createTime = $("#validateAuditDemoInfoForm #createTime4").val();
        params.selectStatic = $("#validateAuditDemoInfoForm #selectStatic4").val();
        params.selectDynamic = $("#validateAuditDemoInfoForm #selectDynamic4").val();
        params.radioStatic = $("#validateAuditDemoInfoForm input[name='radioStatic4']:checked").val();
        params.radioDynamic = $("#validateAuditDemoInfoForm input[name='radioDynamic4']:checked").val();
        params.checkboxStatic = getCheckBoxVal("validateAuditDemoInfoForm","checkboxStatic4");
        params.checkboxDynamic = getCheckBoxVal("validateAuditDemoInfoForm","checkboxDynamic4");
        params.netAddress = $("#validateAuditDemoInfoForm #netAddress4").val();
        var jsonStr = JSON.stringify(params);
        jsonStr = encodeURIComponent(jsonStr);
        $.ajax({
            type : "POST",
            url : url,
            timeout : 60000,
            dataType : 'json',
            data : "jsonStr=" + jsonStr,
            success : function(data) {
                if (data.code == "success") {
                    $('#auditDemoInfo').modal('hide');
                    searchDemoInfo('');
                    layer.msg('审核成功', {icon : 1,time : 2000,offset : 'rb'}, function() {});
                    $('#validateAuditDemoInfoForm').bootstrapValidator('resetForm', true);
                } else {
                    layer.alert(data.message);
                    $('#validateAuditDemoInfoForm  button[type="submit"]').attr('disabled', false);
                }
            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {
                layer.alert('系统异常，请稍后重试！');
                $('#validateAuditDemoInfoForm  button[type="submit"]').attr('disabled', false);
            },
            complete : function(XMLHttpRequest, status) {
                if (status == "timeout") {
                    ajaxTimeoutTest.abort();
                    layer.alert('操作超时！');
                    $('#validateAuditDemoInfoForm  button[type="submit"]').attr('disabled', false);
                }
            }
        });
    }

</script>
<div class="modal fade" id="auditDemoInfo" tabindex="-1" role="dialog"
    aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="validateAuditDemoInfoForm" method="post"
                class="form-horizontal">
                <input type="hidden" id="id_key" name="id_key" value="" />
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">审核DEMO表</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-lg-3 title"><i class="redFont">*</i>表ID：</label>
                        <div class="col-lg-9">
                            <input id="demoId4" name="demoId4" class="form-control" placeholder="表ID" type="text" disabled="disabled" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 title"><i class="redFont">*</i>演示名称：</label>
                        <div class="col-lg-9">
                            <input id="demoNm4" name="demoNm4" class="form-control" placeholder="演示名称" type="text" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 title"><i class="redFont">*</i>演示金额：</label>
                        <div class="col-lg-9">
                            <input id="demoMoney4" name="demoMoney4" class="form-control" placeholder="演示金额" type="text" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 title"><i class="redFont">*</i>创建日期：</label>
                        <div class="col-lg-9">
                            <input id="createDate4" name="createDate4" class="form-control" placeholder="创建日期" type="text" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 title"><i class="redFont">*</i>创建时间：</label>
                        <div class="col-lg-9">
                            <input id="createTime4" name="createTime4" class="form-control" placeholder="创建时间" type="text" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 title"><i class="redFont">*</i>静态选择框：</label>
                        <div class="col-lg-9">
                            <select class="form-control select2" id="selectStatic4" name="selectStatic4">
                                <option selected="selected" value="">请选择</option>
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
                            <select class="form-control select2" id="selectDynamic4" name="selectDynamic4">
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
                                    <input type="radio" id="radioStatic4_${key}" name="radioStatic4" value="${key}">${options[key]}
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
                                    <input type="radio" id="radioDynamic4_${item.codeParam}" name="radioDynamic4" value="${item.codeParam}">${item.codeValue}
                                </label>
                            </#list> <#--动态模式- end -->
                        </div>
                    </div>
                    <#--静态模式-start-->
                    <#assign options=["正常","禁用","失效"]/>
                    <@register.checkbox form="validateAuditDemoInfoForm" name="checkboxStatic4" label="静态复选框" options=options value=""
                    class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                    <#--静态模式- end -->
                    <#--动态模式-start-->
                    <#assign options=dicCheckbox['application_code,application_code']/>
                    <@register.checkbox form="validateAuditDemoInfoForm" name="checkboxDynamic4" label="动态复选框" options=options value=""
                    class1="form-group" class2="col-lg-3 title" class3="col-lg-9" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                    <#--动态模式- end -->
                    <div class="form-group">
                        <label class="col-lg-3 title"><i class="redFont">*</i>网址：</label>
                        <div class="col-lg-9">
                            <input id="netAddress4" name="netAddress4" class="form-control" placeholder="网址" type="text" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 title"><i class="redFont">*</i>整数：</label>
                        <div class="col-lg-9">
                            <input id="countNumber4" name="countNumber4" class="form-control" placeholder="整数" type="text" disabled="disabled" />
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">提交审核</button>
                </div>
            </form>
        </div>
    </div>
</div>
</#macro>
<#import "/component/register.ftl" as  register/>
<#import "/uniondemoslavebinfo/uniondemoslavebinfo.ftl" as  uniondemoslavebinfo/>
<#import "/uniondemoslavebinfo/addUnionDemoSlavebInfo.ftl" as  addUnionDemoSlavebInfo/>
<#import "/uniondemoslavebinfo/updateUnionDemoSlavebInfo.ftl" as  updateUnionDemoSlavebInfo/>
<#import "/uniondemoslavebinfo/detailUnionDemoSlavebInfo.ftl" as  detailUnionDemoSlavebInfo/>
<#include "/management/resource.ftl"/>

<@uniondemoslavebinfo.uniondemoslavebinfoHtml/>
<@addUnionDemoSlavebInfo.addUnionDemoSlavebInfoHtml/>
<@detailUnionDemoSlavebInfo.detailUnionDemoSlavebInfoHtml/>
<@updateUnionDemoSlavebInfo.updateUnionDemoSlavebInfoHtml/>

<#macro uniondemoslavebinfoHtml>
<div style="" class="">
    <section class="content-header">
        <h1>
                联表查询DEMO-从表b<small></small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <div class="box">
            <div class="box-header">
                <form id=queryUnionDemoSlavebInfoForm class="form-horizontal form-inline">
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">表ID：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="demoIdb" name="demoIdb">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">表ID：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="forgienId" name="forgienId">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">演示名称：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="demoNmb" name="demoNmb">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">创建时间：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="createTimeb" name="createTimeb">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">演示金额：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="demoMoneyb" name="demoMoneyb">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">静态选择框：</label>
                            <div class="col-md-8">
                                <select class="form-control select2" id="selectStaticb" name="selectStaticb">
                                    <#--静态模式-start-->
                                    <#assign options={"010":"正常","020":"禁用","030":"失效"}/>
                                    <#list options?keys as key >
                                        <option value="${key}">${options[key]}</option>
                                    </#list>
                                    <#--静态模式- end -->
                                </select>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">动态选择框：</label>
                            <div class="col-md-8">
                                <select class="form-control select2" id="selectDynamicb" name="selectDynamicb">
                                    <#--动态模式-start-->
                                    <#assign options=dicList['application_code,application_code']/>
                                    <#list options as item >
                                        <option value="${item.codeParam}">${item.codeValue}</option>
                                    </#list>
                                    <#--动态模式- end -->
                                </select>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">静态单选按钮：</label>
                            <div class="col-md-8">
                                <#--静态模式-start-->
                                <#assign options={"010":"正常","020":"禁用","030":"失效"}/>
                                <#list options?keys as key >
                                <label class="radio-inline">
                                    <input type="radio" id="radioStaticb_${key}" name="radioStaticb" value="${key}">${options[key]}
                                </label>
                                </#list>
                                <#--静态模式- end -->
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">动态单选按钮：</label>
                            <div class="col-md-8">
                                <#--动态模式-start-->
                                <#assign options=dicList['application_code,application_code']/>
                                <#list options as item >
                                <label class="radio-inline">
                                    <input type="radio" id="radioDynamicb_${item.codeParam}" name="radioDynamicb" value="${item.codeParam}">${item.codeValue}
                                </label>
                                </#list>
                                <#--动态模式- end -->
                                <div class="clearfix"></div>
                            </div>
                        </div>
                        <#--静态模式-start-->
                        <#assign options=["正常","禁用","失效"]/>
                        <@register.checkbox form="queryUnionDemoSlavebInfoForm" name="checkboxStaticb" label="静态复选框" options=options value=""
                        class1="col-md-3" class2="queryTitle" class3="col-md-8" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                        <#--静态模式- end -->
                        <#--动态模式-start-->
                        <#assign options=dicCheckbox['application_code,application_code']/>
                        <@register.checkbox form="queryUnionDemoSlavebInfoForm" name="checkboxDynamicb" label="动态复选框" options=options value=""
                        class1="col-md-3" class2="queryTitle" class3="col-md-8" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                        <#--动态模式- end -->
                        <div class="col-md-3">
                            <label class="queryTitle">创建日期：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="createDateb" name="createDateb">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-3">
                            <div class="searchDiv">
                                <button type="button" class="btn btn-info searchBtn" onclick="searchUnionDemoSlavebInfo('')">搜索</button>
                                <button type="button" class="btn btn-info searchBtn" onclick="searchUnionDemoSlavebInfo('','download','download.xls','demoNmb:演示名称,createTimeb:创建时间,countNumberb:整数,demoMoneyb:演示金额,selectStaticb:静态选择框,selectDynamicb:动态选择框,radioStaticb:静态单选按钮,radioDynamicb:动态单选按钮,checkboxStaticb:静态复选框,checkboxDynamicb:动态复选框,createDateb:创建日期')">下载</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <div class="box-body">
                <div style="width:50px;margin:10px 0px;"><button class="btn btn-block btn-success" data-toggle="modal" data-target="#addUnionDemoSlavebInfo">添加</button></div>
                <table id="unionDemoSlavebInfoTbl" class="table table-bordered">
                    <tr id="unionDemoSlavebInfoTR_FIRST">
                        <th></th>
                        <th>序号</th>
                        <th>演示名称</th>
                        <th>创建时间</th>
                        <th>整数</th>
                        <th>演示金额</th>
                        <th>静态选择框</th>
                        <th>动态选择框</th>
                        <th>静态单选按钮</th>
                        <th>动态单选按钮</th>
                        <th>静态复选框</th>
                        <th>动态复选框</th>
                        <th>创建日期</th>
                        <th>操作</th>
                    </tr>
                </table>
                <div id="page1"></div>
            </div>
            <!-- /.box-body -->

            <!--分页 start-->
            <div id="queryUnionDemoSlavebInfo_fy" style="width: 100%;" class="gmPagination gmPagination-mini">
                <div style="float:left;margin: 10px;">
                    <select id="queryUnionDemoSlavebInfopageSize">
                        <option selected="selected">10</option>
                        <option>20</option>
                        <option>50</option>
                    </select>
                </div>
                <div style="margin: 10px; float: right" class="pager clearfix"	id="commonPager">
                    <a href="javascript:void(0);" class="prev disable">&nbsp;&lt;<s	class="icon-prev"></s><i></i></a> 
                    <span class="cur">1</span> <a href="javascript:void(0);" class="next disable">&gt;<s class="icon-next"></s><i></i></a> 
                    <label class="txt-wrap"	for="pagenum">到<input type="text" value="1" bnum="0" class="txt" id="pNum">页</label> 
                    <a class="btn" zdx="nBtn" href="javascript:void(0)">确定</a>
                </div>
            </div>
            <!--分页 end-->

        </div>
        <!-- /.box -->
    </section>
</div>
<div>
    <input type="hidden" id="queryUnionDemoSlavebInfocurrentPage" />
    <input type="hidden" id="queryUnionDemoSlavebInfototalPage" />
</div>
<script type="text/javascript" src="${props('resourceUrl')}/js/uniondemoslavebinfo/uniondemoslavebinfo.js"></script>
</#macro>
<style>
    #unionDemoSlavebInfoTbl tr .btn{display:left;margin-right:5px;padding:2.5px 6px;}
    .title{padding-right:0px;text-align:right;margin:0px;height:34px;line-height:34px;}
    .redFont{color:red;display:inline-block;width:15px;text-align:center;}
    .modal-dialog{margin:165px auto;}
</style>


<#import "/component/register.ftl" as  register/>
<#import "/uniondemosubinfo/uniondemosubinfo.ftl" as  uniondemosubinfo/>
<#import "/uniondemosubinfo/addUnionDemoSubInfo.ftl" as  addUnionDemoSubInfo/>
<#import "/uniondemosubinfo/updateUnionDemoSubInfo.ftl" as  updateUnionDemoSubInfo/>
<#import "/uniondemosubinfo/detailUnionDemoSubInfo.ftl" as  detailUnionDemoSubInfo/>
<#include "/management/resource.ftl"/>

<@uniondemosubinfo.uniondemosubinfoHtml/>
<@addUnionDemoSubInfo.addUnionDemoSubInfoHtml/>
<@detailUnionDemoSubInfo.detailUnionDemoSubInfoHtml/>
<@updateUnionDemoSubInfo.updateUnionDemoSubInfoHtml/>

<#macro uniondemosubinfoHtml>
<div style="" class="">
    <section class="content-header">
        <h1>
                联表查询DEMO-子表<small></small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <div class="box">
            <div class="box-header">
                <form id=queryUnionDemoSubInfoForm class="form-horizontal form-inline">
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">表ID：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="demoIdc" name="demoIdc">
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
                                <input type="text" class="form-control" placeholder="" id="demoNmc" name="demoNmc">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">创建时间：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="createTimec" name="createTimec">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">演示金额：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="demoMoneyc" name="demoMoneyc">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">静态选择框：</label>
                            <div class="col-md-8">
                                <select class="form-control select2" id="selectStaticc" name="selectStaticc">
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
                                <select class="form-control select2" id="selectDynamicc" name="selectDynamicc">
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
                                    <input type="radio" id="radioStaticc_${key}" name="radioStaticc" value="${key}">${options[key]}
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
                                    <input type="radio" id="radioDynamicc_${item.codeParam}" name="radioDynamicc" value="${item.codeParam}">${item.codeValue}
                                </label>
                                </#list>
                                <#--动态模式- end -->
                                <div class="clearfix"></div>
                            </div>
                        </div>
                        <#--静态模式-start-->
                        <#assign options=["正常","禁用","失效"]/>
                        <@register.checkbox form="queryUnionDemoSubInfoForm" name="checkboxStaticc" label="静态复选框" options=options value=""
                        class1="col-md-3" class2="queryTitle" class3="col-md-8" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                        <#--静态模式- end -->
                        <#--动态模式-start-->
                        <#assign options=dicCheckbox['application_code,application_code']/>
                        <@register.checkbox form="queryUnionDemoSubInfoForm" name="checkboxDynamicc" label="动态复选框" options=options value=""
                        class1="col-md-3" class2="queryTitle" class3="col-md-8" class4="checkbox-inline" class5="inline1" readOnly="false"/>
                        <#--动态模式- end -->
                        <div class="col-md-3">
                            <label class="queryTitle">创建日期：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="createDatec" name="createDatec">
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
                                <button type="button" class="btn btn-info searchBtn" onclick="searchUnionDemoSubInfo('')">搜索</button>
                                <button type="button" class="btn btn-info searchBtn" onclick="searchUnionDemoSubInfo('','download','download.xls','demoNmc:演示名称,createTimec:创建时间,countNumberc:整数,demoMoneyc:演示金额,selectStaticc:静态选择框,selectDynamicc:动态选择框,radioStaticc:静态单选按钮,radioDynamicc:动态单选按钮,checkboxStaticc:静态复选框,checkboxDynamicc:动态复选框,createDatec:创建日期')">下载</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <div class="box-body">
                <div style="width:50px;margin:10px 0px;"><button class="btn btn-block btn-success" data-toggle="modal" data-target="#addUnionDemoSubInfo">添加</button></div>
                <table id="unionDemoSubInfoTbl" class="table table-bordered">
                    <tr id="unionDemoSubInfoTR_FIRST">
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
            <div id="queryUnionDemoSubInfo_fy" style="width: 100%;" class="gmPagination gmPagination-mini">
                <div style="float:left;margin: 10px;">
                    <select id="queryUnionDemoSubInfopageSize">
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
    <input type="hidden" id="queryUnionDemoSubInfocurrentPage" />
    <input type="hidden" id="queryUnionDemoSubInfototalPage" />
</div>
<script type="text/javascript" src="${props('resourceUrl')}/js/uniondemosubinfo/uniondemosubinfo.js"></script>
</#macro>
<style>
    #unionDemoSubInfoTbl tr .btn{display:left;margin-right:5px;padding:2.5px 6px;}
    .title{padding-right:0px;text-align:right;margin:0px;height:34px;line-height:34px;}
    .redFont{color:red;display:inline-block;width:15px;text-align:center;}
    .modal-dialog{margin:165px auto;}
</style>


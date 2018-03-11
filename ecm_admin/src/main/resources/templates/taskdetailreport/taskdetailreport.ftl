<#import "/component/register.ftl" as  register/>
<#import "/taskdetailreport/taskdetailreport.ftl" as  taskdetailreport/>
<#import "/taskdetailreport/addTaskDetailReport.ftl" as  addTaskDetailReport/>
<#import "/taskdetailreport/updateTaskDetailReport.ftl" as  updateTaskDetailReport/>
<#import "/taskdetailreport/detailTaskDetailReport.ftl" as  detailTaskDetailReport/>
<#include "/management/resource.ftl"/>

<@taskdetailreport.taskdetailreportHtml/>
<@addTaskDetailReport.addTaskDetailReportHtml/>
<@detailTaskDetailReport.detailTaskDetailReportHtml/>
<@updateTaskDetailReport.updateTaskDetailReportHtml/>

<#macro taskdetailreportHtml>
<div style="" class="">
    <section class="content-header">
        <h1>
                任务执行实例表<small></small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <div class="box">
            <div class="box-header">
                <form id=queryTaskDetailReportForm class="form-horizontal form-inline">
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">中文名称：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="taskCnName" name="taskCnName">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">业务对象名称：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="businessObjName" name="businessObjName">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">注册组：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="registerGroup" name="registerGroup">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="searchDiv">
                                <button type="button" class="btn btn-info searchBtn" onclick="searchTaskDetailReport('')">搜索</button>
                                <button type="button" class="btn btn-info searchBtn" onclick="searchTaskDetailReport('','download','download.xls','taskCnName:中文名称,businessObjName:业务对象名称,registerGroup:注册组,globalTaskName:全局名称,lastBeginTime:上次开始于,lastEndTime:上次结束于,last5AvgCost:五次平均耗时,execNeedCount:应执行次数,execSuccCount:应成功次数')">下载</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <div class="box-body  table-responsive">
                <table id="taskDetailReportTbl" class="table table-bordered">
                    <tr id="taskDetailReportTR_FIRST">
                        <th></th>
                        <th>序号</th>
                        <th>中文名称</th>
                        <th>业务对象名称</th>
                        <th>注册组</th>
                        <th>全局名称</th>
                        <th>上次开始于</th>
                        <th>上次结束于</th>
                        <th>五次平均耗时</th>
                        <th>应执行次数</th>
                        <th>应成功次数</th>
                        <th>操作</th>
                    </tr>
                </table>
                <div id="page1"></div>
            </div>
            <!-- /.box-body -->

            <!--分页 start-->
            <div id="queryTaskDetailReport_fy" style="width: 100%;" class="gmPagination gmPagination-mini">
                <div style="float:left;margin: 10px;">
                    <select id="queryTaskDetailReportpageSize">
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
    <input type="hidden" id="queryTaskDetailReportcurrentPage" />
    <input type="hidden" id="queryTaskDetailReporttotalPage" />
</div>
<script type="text/javascript" src="${props('resourceUrl')}/js/taskdetailreport/taskdetailreport.js"></script>
</#macro>
<style>
    #taskDetailReportTbl tr .btn{display:left;margin-right:5px;padding:2.5px 6px;}
    .title{padding-right:0px;text-align:right;margin:0px;height:34px;line-height:34px;}
    .redFont{color:red;display:inline-block;width:15px;text-align:center;}
    .modal-dialog{margin:165px auto;}
</style>


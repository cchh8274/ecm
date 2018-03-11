<#import "/component/register.ftl" as  register/>
<#import "/taskdetaillog/taskdetaillog.ftl" as  taskdetaillog/>
<#import "/taskdetaillog/addTaskDetailLog.ftl" as  addTaskDetailLog/>
<#import "/taskdetaillog/updateTaskDetailLog.ftl" as  updateTaskDetailLog/>
<#import "/taskdetaillog/detailTaskDetailLog.ftl" as  detailTaskDetailLog/>
<#include "/management/resource.ftl"/>

<@taskdetaillog.taskdetaillogHtml/>
<@addTaskDetailLog.addTaskDetailLogHtml/>
<@detailTaskDetailLog.detailTaskDetailLogHtml/>
<@updateTaskDetailLog.updateTaskDetailLogHtml/>

<#macro taskdetaillogHtml>
<div style="" class="">
    <section class="content-header">
        <h1>
                任务执行日志表<small></small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <div class="box">
            <div class="box-header">
                <form id=queryTaskDetailLogForm class="form-horizontal form-inline">
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
                            <label class="queryTitle">执行结果：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="execResult" name="execResult">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">添加时间：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="createTime" name="createTime">
                            </div>
                        </div>
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-3">
                            <div class="searchDiv">
                                <button type="button" class="btn btn-info searchBtn" onclick="searchTaskDetailLog('')">搜索</button>
                                <button type="button" class="btn btn-info searchBtn" onclick="searchTaskDetailLog('','download','download.xls','taskCnName:中文名称,businessObjName:业务对象名称,registerGroup:注册组,globalTaskName:全局名称,beginTime:开始时间,endTime:结束时间,execResult:执行结果,createTime:添加时间')">下载</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <div class="box-body">
                <table id="taskDetailLogTbl" class="table table-bordered">
                    <tr id="taskDetailLogTR_FIRST">
                        <th></th>
                        <th>序号</th>
                        <th>中文名称</th>
                        <th>业务对象名称</th>
                        <th>注册组</th>
                        <th>全局名称</th>
                        <th>开始时间</th>
                        <th>结束时间</th>
                        <th>执行结果</th>
                        <th>添加时间</th>
                        <th>操作</th>
                    </tr>
                </table>
                <div id="page1"></div>
            </div>
            <!-- /.box-body -->

            <!--分页 start-->
            <div id="queryTaskDetailLog_fy" style="width: 100%;" class="gmPagination gmPagination-mini">
                <div style="float:left;margin: 10px;">
                    <select id="queryTaskDetailLogpageSize">
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
    <input type="hidden" id="queryTaskDetailLogcurrentPage" />
    <input type="hidden" id="queryTaskDetailLogtotalPage" />
</div>
<script type="text/javascript" src="${props('resourceUrl')}/js/taskdetaillog/taskdetaillog.js"></script>
</#macro>
<style>
    #taskDetailLogTbl tr .btn{display:left;margin-right:5px;padding:2.5px 6px;}
    .title{padding-right:0px;text-align:right;margin:0px;height:34px;line-height:34px;}
    .redFont{color:red;display:inline-block;width:15px;text-align:center;}
    .modal-dialog{margin:165px auto;}
</style>


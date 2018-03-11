<#import "/component/register.ftl" as  register/>

<#macro detailTaskDetailReportHtml>
    <div class="modal fade" id="detailTaskDetailReport" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="validateDetailTaskDetailReportForm" method="post" class="form-horizontal">
                    <input type="hidden" id="id_key" name="id_key" value="" />
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">查看任务执行实例表</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-lg-3 title">ID：</label>
                            <div class="col-lg-9">
                                <input id="id2" name="id2"  class="form-control" placeholder="ID" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">中文名称：</label>
                            <div class="col-lg-9">
                                <input id="taskCnName2" name="taskCnName2"  class="form-control" placeholder="中文名称" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">业务对象名称：</label>
                            <div class="col-lg-9">
                                <input id="businessObjName2" name="businessObjName2"  class="form-control" placeholder="业务对象名称" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">注册组：</label>
                            <div class="col-lg-9">
                                <input id="registerGroup2" name="registerGroup2"  class="form-control" placeholder="注册组" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">执行IP：</label>
                            <div class="col-lg-9">
                                <input id="ipInfo2" name="ipInfo2"  class="form-control" placeholder="执行IP" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">全局名称：</label>
                            <div class="col-lg-9">
                                <input id="globalTaskName2" name="globalTaskName2"  class="form-control" placeholder="全局名称" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">全局数量：</label>
                            <div class="col-lg-9">
                                <input id="globalTaskCount2" name="globalTaskCount2"  class="form-control" placeholder="全局数量" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">全局序号：</label>
                            <div class="col-lg-9">
                                <input id="globalTaskIndex2" name="globalTaskIndex2"  class="form-control" placeholder="全局序号" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">上次开始于：</label>
                            <div class="col-lg-9">
                                <input id="lastBeginTime2" name="lastBeginTime2"  class="form-control" placeholder="上次开始于" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">上次结束于：</label>
                            <div class="col-lg-9">
                                <input id="lastEndTime2" name="lastEndTime2"  class="form-control" placeholder="上次结束于" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">十次平均耗时：</label>
                            <div class="col-lg-9">
                                <input id="last10AvgCost2" name="last10AvgCost2"  class="form-control" placeholder="十次平均耗时" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">五次平均耗时：</label>
                            <div class="col-lg-9">
                                <input id="last5AvgCost2" name="last5AvgCost2"  class="form-control" placeholder="五次平均耗时" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">应执行次数：</label>
                            <div class="col-lg-9">
                                <input id="execNeedCount2" name="execNeedCount2"  class="form-control" placeholder="应执行次数" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">应成功次数：</label>
                            <div class="col-lg-9">
                                <input id="execSuccCount2" name="execSuccCount2"  class="form-control" placeholder="应成功次数" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">执行历史记录：</label>
                            <div class="col-lg-9">
                                <input id="execHistory2" name="execHistory2"  class="form-control" placeholder="执行历史记录" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">添加时间：</label>
                            <div class="col-lg-9">
                                <input id="createTime2" name="createTime2"  class="form-control" placeholder="添加时间" type="text" disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 title">更新时间：</label>
                            <div class="col-lg-9">
                                <input id="upTime2" name="upTime2"  class="form-control" placeholder="更新时间" type="text" disabled="disabled"/>
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




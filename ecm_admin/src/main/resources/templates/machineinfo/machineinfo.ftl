<#import "/component/register.ftl" as  register/>
<#import "/machineinfo/machineinfo.ftl" as  machineinfo/>
<#import "/machineinfo/addMachineInfo.ftl" as  addMachineInfo/>
<#import "/machineinfo/updateMachineInfo.ftl" as  updateMachineInfo/>
<#import "/machineinfo/detailMachineInfo.ftl" as  detailMachineInfo/>
<#include "/management/resource.ftl"/>

<@machineinfo.machineinfoHtml/>
<@addMachineInfo.addMachineInfoHtml/>
<@detailMachineInfo.detailMachineInfoHtml/>
<@updateMachineInfo.updateMachineInfoHtml/>

<#macro machineinfoHtml>
<div style="" class="">
    <section class="content-header">
        <h1>
                机器信息表<small></small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <div class="box">
            <div class="box-header">
                <form id=queryMachineInfoForm class="form-horizontal form-inline">
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">id：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="id" name="id">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">机器名称：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="machineName" name="machineName">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">投放位置：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="adress" name="adress">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">是否使用：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="isUse" name="isUse">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">单个名额价格：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="price" name="price">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">总名额：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="totalPlaces" name="totalPlaces">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">剩余名额：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="leftPlace" name="leftPlace">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">已售名额：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="outSalePlace" name="outSalePlace">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">创建时间：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="createTime" name="createTime">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">创建人：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="createUser" name="createUser">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">修改时间：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="updateTime" name="updateTime">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">修改人：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="updateUser" name="updateUser">
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
                                <button type="button" class="btn btn-info searchBtn" onclick="searchMachineInfo('')">搜索</button>
                                <button type="button" class="btn btn-info searchBtn" onclick="searchMachineInfo('','download','download.xls','id:id,machineName:机器名称,adress:投放位置,isUse:是否使用,price:单个名额价格,totalPlaces:总名额,leftPlace:剩余名额,outSalePlace:已售名额,createTime:创建时间,createUser:创建人,updateTime:修改时间,updateUser:修改人')">下载</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <div class="box-body">
                <div style="width:50px;margin:10px 0px;"><button class="btn btn-block btn-success" data-toggle="modal" data-target="#addMachineInfo">添加</button></div>
                <table id="machineInfoTbl" class="table table-bordered">
                    <tr id="machineInfoTR_FIRST">
                        <th></th>
                        <th>序号</th>
                        <th>id</th>
                        <th>机器名称</th>
                        <th>投放位置</th>
                        <th>是否使用</th>
                        <th>单个名额价格</th>
                        <th>总名额</th>
                        <th>剩余名额</th>
                        <th>已售名额</th>
                        <th>创建时间</th>
                        <th>创建人</th>
                        <th>修改时间</th>
                        <th>修改人</th>
                        <th>操作</th>
                    </tr>
                </table>
                <div id="page1"></div>
            </div>
            <!-- /.box-body -->

            <!--分页 start-->
            <div id="queryMachineInfo_fy" style="width: 100%;" class="gmPagination gmPagination-mini">
                <div style="float:left;margin: 10px;">
                    <select id="queryMachineInfopageSize">
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
    <input type="hidden" id="queryMachineInfocurrentPage" />
    <input type="hidden" id="queryMachineInfototalPage" />
</div>
<script type="text/javascript" src="${props('resourceUrl')}/js/machineinfo/machineinfo.js"></script>
</#macro>
<style>
    #machineInfoTbl tr .btn{display:left;margin-right:5px;padding:2.5px 6px;}
    .title{padding-right:0px;text-align:right;margin:0px;height:34px;line-height:34px;}
    .redFont{color:red;display:inline-block;width:15px;text-align:center;}
    .modal-dialog{margin:165px auto;}
</style>


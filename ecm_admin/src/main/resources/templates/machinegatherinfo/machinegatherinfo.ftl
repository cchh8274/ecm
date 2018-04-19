<#import "/component/register.ftl" as  register/>
<#import "/machinegatherinfo/machinegatherinfo.ftl" as  machinegatherinfo/>
<#import "/machinegatherinfo/addMachineGatherInfo.ftl" as  addMachineGatherInfo/>
<#import "/machinegatherinfo/updateMachineGatherInfo.ftl" as  updateMachineGatherInfo/>
<#import "/machinegatherinfo/detailMachineGatherInfo.ftl" as  detailMachineGatherInfo/>
<#include "/management/resource.ftl"/>

<@machinegatherinfo.machinegatherinfoHtml/>
<@addMachineGatherInfo.addMachineGatherInfoHtml/>
<@detailMachineGatherInfo.detailMachineGatherInfoHtml/>
<@updateMachineGatherInfo.updateMachineGatherInfoHtml/>

<#macro machinegatherinfoHtml>
<div style="" class="">
    <section class="content-header">
        <h1>
                用户咖啡机表<small></small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <div class="box">
            <div class="box-header">
                <form id=queryMachineGatherInfoForm class="form-horizontal form-inline">
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">id：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="id" name="id">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">openid：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="openid" name="openid">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">用户名称：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="wxUserName" name="wxUserName">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">区域名称：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="areaId" name="areaId">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">区域ID：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="areId" name="areId">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">大学名称：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="unversityName" name="unversityName">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">大学ID：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="unversityId" name="unversityId">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">购买金额：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="price" name="price">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">购买数量：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="number" name="number">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">购买时间：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="payTime" name="payTime">
                            </div>
                        </div>
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
                    </div>
                    <div class="row dis-top">
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
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-3">
                            <div class="searchDiv">
                                <button type="button" class="btn btn-info searchBtn" onclick="searchMachineGatherInfo('')">搜索</button>
                                <button type="button" class="btn btn-info searchBtn" onclick="searchMachineGatherInfo('','download','download.xls','id:id,openid:openid,wxUserName:用户名称,areaId:区域名称,areId:区域ID,unversityName:大学名称,unversityId:大学ID,price:购买金额,number:购买数量,payTime:购买时间,createTime:创建时间,createUser:创建人,updateTime:修改时间,updateUser:修改人')">下载</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <div class="box-body">
                <div style="width:50px;margin:10px 0px;"><button class="btn btn-block btn-success" data-toggle="modal" data-target="#addMachineGatherInfo">添加</button></div>
                <table id="machineGatherInfoTbl" class="table table-bordered">
                    <tr id="machineGatherInfoTR_FIRST">
                        <th></th>
                        <th>序号</th>
                        <th>id</th>
                        <th>openid</th>
                        <th>用户名称</th>
                        <th>区域名称</th>
                        <th>区域ID</th>
                        <th>大学名称</th>
                        <th>大学ID</th>
                        <th>购买金额</th>
                        <th>购买数量</th>
                        <th>购买时间</th>
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
            <div id="queryMachineGatherInfo_fy" style="width: 100%;" class="gmPagination gmPagination-mini">
                <div style="float:left;margin: 10px;">
                    <select id="queryMachineGatherInfopageSize">
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
    <input type="hidden" id="queryMachineGatherInfocurrentPage" />
    <input type="hidden" id="queryMachineGatherInfototalPage" />
</div>
<script type="text/javascript" src="${props('resourceUrl')}/js/machinegatherinfo/machinegatherinfo.js"></script>
</#macro>
<style>
    #machineGatherInfoTbl tr .btn{display:left;margin-right:5px;padding:2.5px 6px;}
    .title{padding-right:0px;text-align:right;margin:0px;height:34px;line-height:34px;}
    .redFont{color:red;display:inline-block;width:15px;text-align:center;}
    .modal-dialog{margin:165px auto;}
</style>


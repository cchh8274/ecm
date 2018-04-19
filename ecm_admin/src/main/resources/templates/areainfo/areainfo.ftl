<#import "/component/register.ftl" as  register/>
<#import "/areainfo/areainfo.ftl" as  areainfo/>
<#import "/areainfo/addAreaInfo.ftl" as  addAreaInfo/>
<#import "/areainfo/updateAreaInfo.ftl" as  updateAreaInfo/>
<#import "/areainfo/detailAreaInfo.ftl" as  detailAreaInfo/>
<#include "/management/resource.ftl"/>

<@areainfo.areainfoHtml/>
<@addAreaInfo.addAreaInfoHtml/>
<@detailAreaInfo.detailAreaInfoHtml/>
<@updateAreaInfo.updateAreaInfoHtml/>

<#macro areainfoHtml>
<div style="" class="">
    <section class="content-header">
        <h1>
                区域表<small></small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <div class="box">
            <div class="box-header">
                <form id=queryAreaInfoForm class="form-horizontal form-inline">
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">id：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="id" name="id">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">区域名称：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="areaName" name="areaName">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">状态：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="status" name="status">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">启用等级：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="enableLevl" name="enableLevl">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">页面启用状态：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="pageStatus" name="pageStatus">
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
                        <div class="col-md-3">
                            <label class="queryTitle">修改时间：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="updateTime" name="updateTime">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">修改人：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="upUser" name="upUser">
                            </div>
                        </div>
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-3">
                            <div class="searchDiv">
                                <button type="button" class="btn btn-info searchBtn" onclick="searchAreaInfo('')">搜索</button>
                                <button type="button" class="btn btn-info searchBtn" onclick="searchAreaInfo('','download','download.xls','id:id,areaName:区域名称,status:状态,enableLevl:启用等级,pageStatus:页面启用状态,createTime:创建时间,createUser:创建人,updateTime:修改时间,upUser:修改人')">下载</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <div class="box-body">
                <div style="width:50px;margin:10px 0px;"><button class="btn btn-block btn-success" data-toggle="modal" data-target="#addAreaInfo">添加</button></div>
                <table id="areaInfoTbl" class="table table-bordered">
                    <tr id="areaInfoTR_FIRST">
                        <th></th>
                        <th>序号</th>
                        <th>id</th>
                        <th>区域名称</th>
                        <th>状态</th>
                        <th>启用等级</th>
                        <th>页面启用状态</th>
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
            <div id="queryAreaInfo_fy" style="width: 100%;" class="gmPagination gmPagination-mini">
                <div style="float:left;margin: 10px;">
                    <select id="queryAreaInfopageSize">
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
    <input type="hidden" id="queryAreaInfocurrentPage" />
    <input type="hidden" id="queryAreaInfototalPage" />
</div>
<script type="text/javascript" src="${props('resourceUrl')}/js/areainfo/areainfo.js"></script>
</#macro>
<style>
    #areaInfoTbl tr .btn{display:left;margin-right:5px;padding:2.5px 6px;}
    .title{padding-right:0px;text-align:right;margin:0px;height:34px;line-height:34px;}
    .redFont{color:red;display:inline-block;width:15px;text-align:center;}
    .modal-dialog{margin:165px auto;}
</style>


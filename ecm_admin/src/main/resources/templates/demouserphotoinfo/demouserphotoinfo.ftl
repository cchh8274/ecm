<#import "/component/register.ftl" as  register/>
<#import "/demouserphotoinfo/demouserphotoinfo.ftl" as  demouserphotoinfo/>
<#import "/demouserphotoinfo/addDemoUserphotoInfo.ftl" as  addDemoUserphotoInfo/>
<#import "/demouserphotoinfo/updateDemoUserphotoInfo.ftl" as  updateDemoUserphotoInfo/>
<#import "/demouserphotoinfo/detailDemoUserphotoInfo.ftl" as  detailDemoUserphotoInfo/>
<#include "/management/resource.ftl"/>

<@demouserphotoinfo.demouserphotoinfoHtml/>
<@addDemoUserphotoInfo.addDemoUserphotoInfoHtml/>
<@detailDemoUserphotoInfo.detailDemoUserphotoInfoHtml/>
<@updateDemoUserphotoInfo.updateDemoUserphotoInfoHtml/>

<#macro demouserphotoinfoHtml>
<div style="" class="">
    <section class="content-header">
        <h1>
                用户照片表<small></small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <div class="box">
            <div class="box-header">
                <form id=queryDemoUserphotoInfoForm class="form-horizontal form-inline">
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">编号：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="id" name="id">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">用户名称：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="userNm" name="userNm">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="searchDiv">
                                <button type="button" class="btn btn-info searchBtn" onclick="searchDemoUserphotoInfo('')">搜索</button>
                                <button type="button" class="btn btn-info searchBtn" onclick="searchDemoUserphotoInfo('','download','download.xls','id:编号,userNm:用户名称,photo:照片')">下载</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <div class="box-body">
                <div style="width:50px;margin:10px 0px;"><button class="btn btn-block btn-success" data-toggle="modal" data-target="#addDemoUserphotoInfo">添加</button></div>
                <table id="demoUserphotoInfoTbl" class="table table-bordered">
                    <tr id="demoUserphotoInfoTR_FIRST">
                        <th></th>
                        <th>序号</th>
                        <th>编号</th>
                        <th>用户名称</th>
                        <th>照片</th>
                        <th>操作</th>
                    </tr>
                </table>
                <div id="page1"></div>
            </div>
            <!-- /.box-body -->

            <!--分页 start-->
            <div id="queryDemoUserphotoInfo_fy" style="width: 100%;" class="gmPagination gmPagination-mini">
                <div style="float:left;margin: 10px;">
                    <select id="queryDemoUserphotoInfopageSize">
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
    <input type="hidden" id="queryDemoUserphotoInfocurrentPage" />
    <input type="hidden" id="queryDemoUserphotoInfototalPage" />
</div>
<script type="text/javascript" src="${props('resourceUrl')}/js/demouserphotoinfo/demouserphotoinfo.js"></script>
</#macro>
<style>
    #demoUserphotoInfoTbl tr .btn{display:left;margin-right:5px;padding:2.5px 6px;}
    .title{padding-right:0px;text-align:right;margin:0px;height:34px;line-height:34px;}
    .redFont{color:red;display:inline-block;width:15px;text-align:center;}
    .modal-dialog{margin:165px auto;}
</style>


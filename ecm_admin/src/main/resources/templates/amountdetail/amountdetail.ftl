<#import "/component/register.ftl" as  register/>
<#import "/amountdetail/amountdetail.ftl" as  amountdetail/>
<#import "/amountdetail/addAmountDetail.ftl" as  addAmountDetail/>
<#import "/amountdetail/updateAmountDetail.ftl" as  updateAmountDetail/>
<#import "/amountdetail/detailAmountDetail.ftl" as  detailAmountDetail/>
<#include "/management/resource.ftl"/>

<@amountdetail.amountdetailHtml/>
<@addAmountDetail.addAmountDetailHtml/>
<@detailAmountDetail.detailAmountDetailHtml/>
<@updateAmountDetail.updateAmountDetailHtml/>

<#macro amountdetailHtml>
<div style="" class="">
    <section class="content-header">
        <h1>
                账户明细表<small></small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <div class="box">
            <div class="box-header">
                <form id=queryAmountDetailForm class="form-horizontal form-inline">
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">id：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="id" name="id">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">账户ID：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="accountId" name="accountId">
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
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">月份收益：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="earningMonth" name="earningMonth">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">区域ID：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="areaId" name="areaId">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">区域名称：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="areaName" name="areaName">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">是否冻结：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="isFreeze" name="isFreeze">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">收益类型：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="earningType" name="earningType">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">收益金额：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="earningsMoney" name="earningsMoney">
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
                        </div>
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-3">
                            <div class="searchDiv">
                                <button type="button" class="btn btn-info searchBtn" onclick="searchAmountDetail('')">搜索</button>
                                <button type="button" class="btn btn-info searchBtn" onclick="searchAmountDetail('','download','download.xls','id:id,accountId:账户ID,unversityName:大学名称,unversityId:大学ID,earningMonth:月份收益,areaId:区域ID,areaName:区域名称,isFreeze:是否冻结,earningType:收益类型,earningsMoney:收益金额,createTime:创建时间,createUser:创建人')">下载</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <div class="box-body">
                <div style="width:50px;margin:10px 0px;"><button class="btn btn-block btn-success" data-toggle="modal" data-target="#addAmountDetail">添加</button></div>
                <table id="amountDetailTbl" class="table table-bordered">
                    <tr id="amountDetailTR_FIRST">
                        <th></th>
                        <th>序号</th>
                        <th>id</th>
                        <th>账户ID</th>
                        <th>大学名称</th>
                        <th>大学ID</th>
                        <th>月份收益</th>
                        <th>区域ID</th>
                        <th>区域名称</th>
                        <th>是否冻结</th>
                        <th>收益类型</th>
                        <th>收益金额</th>
                        <th>创建时间</th>
                        <th>创建人</th>
                        <th>操作</th>
                    </tr>
                </table>
                <div id="page1"></div>
            </div>
            <!-- /.box-body -->

            <!--分页 start-->
            <div id="queryAmountDetail_fy" style="width: 100%;" class="gmPagination gmPagination-mini">
                <div style="float:left;margin: 10px;">
                    <select id="queryAmountDetailpageSize">
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
    <input type="hidden" id="queryAmountDetailcurrentPage" />
    <input type="hidden" id="queryAmountDetailtotalPage" />
</div>
<script type="text/javascript" src="${props('resourceUrl')}/js/amountdetail/amountdetail.js"></script>
</#macro>
<style>
    #amountDetailTbl tr .btn{display:left;margin-right:5px;padding:2.5px 6px;}
    .title{padding-right:0px;text-align:right;margin:0px;height:34px;line-height:34px;}
    .redFont{color:red;display:inline-block;width:15px;text-align:center;}
    .modal-dialog{margin:165px auto;}
</style>


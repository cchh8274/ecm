<#import "/component/register.ftl" as  register/>
<#import "/earningsinfo/earningsinfo.ftl" as  earningsinfo/>
<#import "/earningsinfo/addEarningsInfo.ftl" as  addEarningsInfo/>
<#import "/earningsinfo/updateEarningsInfo.ftl" as  updateEarningsInfo/>
<#import "/earningsinfo/detailEarningsInfo.ftl" as  detailEarningsInfo/>
<#include "/management/resource.ftl"/>

<@earningsinfo.earningsinfoHtml/>
<@addEarningsInfo.addEarningsInfoHtml/>
<@detailEarningsInfo.detailEarningsInfoHtml/>
<@updateEarningsInfo.updateEarningsInfoHtml/>

<#macro earningsinfoHtml>
<div style="" class="">
    <section class="content-header">
        <h1>
                收益表<small></small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <div class="box">
            <div class="box-header">
                <form id=queryEarningsInfoForm class="form-horizontal form-inline">
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
                            <label class="queryTitle">微信用户：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="wxUserName" name="wxUserName">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">机器ID：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="manicheId" name="manicheId">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
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
                            <label class="queryTitle">机器名称：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="manicheName" name="manicheName">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">收益单价：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="price" name="price">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">收益咖啡机数量：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="coffeeNumber" name="coffeeNumber">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">当月收益总金额：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="tolalMoney" name="tolalMoney">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">收益时间：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="earingMonth" name="earingMonth">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">收益开始时间：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="earningStartTime" name="earningStartTime">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">是否下发收益：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="isEaningStatus" name="isEaningStatus">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">收益下发时间：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="earningSendTime" name="earningSendTime">
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
                                <button type="button" class="btn btn-info searchBtn" onclick="searchEarningsInfo('')">搜索</button>
                                <button type="button" class="btn btn-info searchBtn" onclick="searchEarningsInfo('','download','download.xls','id:id,openid:openid,wxUserName:微信用户,manicheId:机器ID,unversityName:大学名称,unversityId:大学ID,manicheName:机器名称,price:收益单价,coffeeNumber:收益咖啡机数量,tolalMoney:当月收益总金额,earingMonth:收益时间,earningStartTime:收益开始时间,isEaningStatus:是否下发收益,earningSendTime:收益下发时间,createTime:创建时间,createUser:创建人,updateTime:修改时间,updateUser:修改人')">下载</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <div class="box-body">
                <div style="width:50px;margin:10px 0px;"><button class="btn btn-block btn-success" data-toggle="modal" data-target="#addEarningsInfo">添加</button></div>
                <table id="earningsInfoTbl" class="table table-bordered">
                    <tr id="earningsInfoTR_FIRST">
                        <th></th>
                        <th>序号</th>
                        <th>id</th>
                        <th>openid</th>
                        <th>微信用户</th>
                        <th>机器ID</th>
                        <th>大学名称</th>
                        <th>大学ID</th>
                        <th>机器名称</th>
                        <th>收益单价</th>
                        <th>收益咖啡机数量</th>
                        <th>当月收益总金额</th>
                        <th>收益时间</th>
                        <th>收益开始时间</th>
                        <th>是否下发收益</th>
                        <th>收益下发时间</th>
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
            <div id="queryEarningsInfo_fy" style="width: 100%;" class="gmPagination gmPagination-mini">
                <div style="float:left;margin: 10px;">
                    <select id="queryEarningsInfopageSize">
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
    <input type="hidden" id="queryEarningsInfocurrentPage" />
    <input type="hidden" id="queryEarningsInfototalPage" />
</div>
<script type="text/javascript" src="${props('resourceUrl')}/js/earningsinfo/earningsinfo.js"></script>
</#macro>
<style>
    #earningsInfoTbl tr .btn{display:left;margin-right:5px;padding:2.5px 6px;}
    .title{padding-right:0px;text-align:right;margin:0px;height:34px;line-height:34px;}
    .redFont{color:red;display:inline-block;width:15px;text-align:center;}
    .modal-dialog{margin:165px auto;}
</style>


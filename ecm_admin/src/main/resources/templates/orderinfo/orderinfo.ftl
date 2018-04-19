<#import "/component/register.ftl" as  register/>
<#import "/orderinfo/orderinfo.ftl" as  orderinfo/>
<#import "/orderinfo/addOrderInfo.ftl" as  addOrderInfo/>
<#import "/orderinfo/updateOrderInfo.ftl" as  updateOrderInfo/>
<#import "/orderinfo/detailOrderInfo.ftl" as  detailOrderInfo/>
<#include "/management/resource.ftl"/>

<@orderinfo.orderinfoHtml/>
<@addOrderInfo.addOrderInfoHtml/>
<@detailOrderInfo.detailOrderInfoHtml/>
<@updateOrderInfo.updateOrderInfoHtml/>

<#macro orderinfoHtml>
<div style="" class="">
    <section class="content-header">
        <h1>
                订单表<small></small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <div class="box">
            <div class="box-header">
                <form id=queryOrderInfoForm class="form-horizontal form-inline">
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">id：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="id" name="id">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">订单号：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="orderNo" name="orderNo">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">商品描述：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="body" name="body">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">商品详情：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="detail" name="detail">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">名额数量：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="number" name="number">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">名额单价：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="price" name="price">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">总金额：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="totalFee" name="totalFee">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">用户IP地址：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="spbillCreateIp" name="spbillCreateIp">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">交易起始时间：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="payStartTime" name="payStartTime">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">交易结束时间：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="payEndTime" name="payEndTime">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">goods_tag：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="goodsTag" name="goodsTag">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">购买用户ID：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="openid" name="openid">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">用户微信名称：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="userName" name="userName">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">支付完成时间：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="payTime" name="payTime">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">支付状态：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="payStatus" name="payStatus">
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
                            <label class="queryTitle">机器名称：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="manicheName" name="manicheName">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">区域名称：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="areaName" name="areaName">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">区域ID：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="areaId" name="areaId">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">大学名称：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="unversityName" name="unversityName">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">大学ID：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="universityId" name="universityId">
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
                                <input type="text" class="form-control" placeholder="" id="updateUser" name="updateUser">
                            </div>
                        </div>
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-3">
                            <div class="searchDiv">
                                <button type="button" class="btn btn-info searchBtn" onclick="searchOrderInfo('')">搜索</button>
                                <button type="button" class="btn btn-info searchBtn" onclick="searchOrderInfo('','download','download.xls','id:id,orderNo:订单号,body:商品描述,detail:商品详情,number:名额数量,price:名额单价,totalFee:总金额,spbillCreateIp:用户IP地址,payStartTime:交易起始时间,payEndTime:交易结束时间,goodsTag:goods_tag,openid:购买用户ID,userName:用户微信名称,payTime:支付完成时间,payStatus:支付状态,manicheId:机器ID,manicheName:机器名称,areaName:区域名称,areaId:区域ID,unversityName:大学名称,universityId:大学ID,createTime:创建时间,createUser:创建人,updateTime:修改时间,updateUser:修改人')">下载</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <div class="box-body">
                <div style="width:50px;margin:10px 0px;"><button class="btn btn-block btn-success" data-toggle="modal" data-target="#addOrderInfo">添加</button></div>
                <table id="orderInfoTbl" class="table table-bordered">
                    <tr id="orderInfoTR_FIRST">
                        <th></th>
                        <th>序号</th>
                        <th>id</th>
                        <th>订单号</th>
                        <th>商品描述</th>
                        <th>商品详情</th>
                        <th>名额数量</th>
                        <th>名额单价</th>
                        <th>总金额</th>
                        <th>用户IP地址</th>
                        <th>交易起始时间</th>
                        <th>交易结束时间</th>
                        <th>goods_tag</th>
                        <th>购买用户ID</th>
                        <th>用户微信名称</th>
                        <th>支付完成时间</th>
                        <th>支付状态</th>
                        <th>机器ID</th>
                        <th>机器名称</th>
                        <th>区域名称</th>
                        <th>区域ID</th>
                        <th>大学名称</th>
                        <th>大学ID</th>
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
            <div id="queryOrderInfo_fy" style="width: 100%;" class="gmPagination gmPagination-mini">
                <div style="float:left;margin: 10px;">
                    <select id="queryOrderInfopageSize">
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
    <input type="hidden" id="queryOrderInfocurrentPage" />
    <input type="hidden" id="queryOrderInfototalPage" />
</div>
<script type="text/javascript" src="${props('resourceUrl')}/js/orderinfo/orderinfo.js"></script>
</#macro>
<style>
    #orderInfoTbl tr .btn{display:left;margin-right:5px;padding:2.5px 6px;}
    .title{padding-right:0px;text-align:right;margin:0px;height:34px;line-height:34px;}
    .redFont{color:red;display:inline-block;width:15px;text-align:center;}
    .modal-dialog{margin:165px auto;}
</style>


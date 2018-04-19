<#import "/component/register.ftl" as  register/>
<#import "/payresultinfo/payresultinfo.ftl" as  payresultinfo/>
<#import "/payresultinfo/addPayResultInfo.ftl" as  addPayResultInfo/>
<#import "/payresultinfo/updatePayResultInfo.ftl" as  updatePayResultInfo/>
<#import "/payresultinfo/detailPayResultInfo.ftl" as  detailPayResultInfo/>
<#include "/management/resource.ftl"/>

<@payresultinfo.payresultinfoHtml/>
<@addPayResultInfo.addPayResultInfoHtml/>
<@detailPayResultInfo.detailPayResultInfoHtml/>
<@updatePayResultInfo.updatePayResultInfoHtml/>

<#macro payresultinfoHtml>
<div style="" class="">
    <section class="content-header">
        <h1>
                支付结果通知表<small></small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <div class="box">
            <div class="box-header">
                <form id=queryPayResultInfoForm class="form-horizontal form-inline">
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">id：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="id" name="id">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">公众账号ID：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="appid" name="appid">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">商户号：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="mchId" name="mchId">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">设备号：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="deviceInfo" name="deviceInfo">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">随机字符串：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="nonceStr" name="nonceStr">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">签名：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="sign" name="sign">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">签名类型：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="signType" name="signType">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">支付结果：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="resultCode" name="resultCode">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">错误代码：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="errCode" name="errCode">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">错误代码描述：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="errCodeDes" name="errCodeDes">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">用户标识ID：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="openid" name="openid">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">是否关注公众账号：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="isSubscribe" name="isSubscribe">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">交易类型：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="tradeType" name="tradeType">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">付款银行：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="bankType" name="bankType">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">订单金额：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="totalFee" name="totalFee">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">应结订单金额：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="settlementTotalFee" name="settlementTotalFee">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">货币种类：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="feeType" name="feeType">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">现金支付金额：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="cashFee" name="cashFee">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">现金支付货币类型：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="cashFeeType" name="cashFeeType">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">总代金券金额：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="couponFee" name="couponFee">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">代金券使用数量：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="couponCount" name="couponCount">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">代金券类型：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="couponType" name="couponType">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">代金券ID：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="couponId" name="couponId">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">单个代金券支付金额：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="couponFeeOne" name="couponFeeOne">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">微信支付订单号：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="transactionIdtransactionId" name="transactionIdtransactionId">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">商户订单号：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="outTradeNo" name="outTradeNo">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">支付完成时间：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="timeEnd" name="timeEnd">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">创建时间：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="createTime" name="createTime">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">创建人：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="createUser" name="createUser">
                            </div>
                        </div>
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-3">
                            <div class="searchDiv">
                                <button type="button" class="btn btn-info searchBtn" onclick="searchPayResultInfo('')">搜索</button>
                                <button type="button" class="btn btn-info searchBtn" onclick="searchPayResultInfo('','download','download.xls','id:id,appid:公众账号ID,mchId:商户号,deviceInfo:设备号,nonceStr:随机字符串,sign:签名,signType:签名类型,resultCode:支付结果,errCode:错误代码,errCodeDes:错误代码描述,openid:用户标识ID,isSubscribe:是否关注公众账号,tradeType:交易类型,bankType:付款银行,totalFee:订单金额,settlementTotalFee:应结订单金额,feeType:货币种类,cashFee:现金支付金额,cashFeeType:现金支付货币类型,couponFee:总代金券金额,couponCount:代金券使用数量,couponType:代金券类型,couponId:代金券ID,couponFeeOne:单个代金券支付金额,transactionIdtransactionId:微信支付订单号,outTradeNo:商户订单号,timeEnd:支付完成时间,createTime:创建时间,createUser:创建人')">下载</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <div class="box-body">
                <div style="width:50px;margin:10px 0px;"><button class="btn btn-block btn-success" data-toggle="modal" data-target="#addPayResultInfo">添加</button></div>
                <table id="payResultInfoTbl" class="table table-bordered">
                    <tr id="payResultInfoTR_FIRST">
                        <th></th>
                        <th>序号</th>
                        <th>id</th>
                        <th>公众账号ID</th>
                        <th>商户号</th>
                        <th>设备号</th>
                        <th>随机字符串</th>
                        <th>签名</th>
                        <th>签名类型</th>
                        <th>支付结果</th>
                        <th>错误代码</th>
                        <th>错误代码描述</th>
                        <th>用户标识ID</th>
                        <th>是否关注公众账号</th>
                        <th>交易类型</th>
                        <th>付款银行</th>
                        <th>订单金额</th>
                        <th>应结订单金额</th>
                        <th>货币种类</th>
                        <th>现金支付金额</th>
                        <th>现金支付货币类型</th>
                        <th>总代金券金额</th>
                        <th>代金券使用数量</th>
                        <th>代金券类型</th>
                        <th>代金券ID</th>
                        <th>单个代金券支付金额</th>
                        <th>微信支付订单号</th>
                        <th>商户订单号</th>
                        <th>支付完成时间</th>
                        <th>创建时间</th>
                        <th>创建人</th>
                        <th>操作</th>
                    </tr>
                </table>
                <div id="page1"></div>
            </div>
            <!-- /.box-body -->

            <!--分页 start-->
            <div id="queryPayResultInfo_fy" style="width: 100%;" class="gmPagination gmPagination-mini">
                <div style="float:left;margin: 10px;">
                    <select id="queryPayResultInfopageSize">
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
    <input type="hidden" id="queryPayResultInfocurrentPage" />
    <input type="hidden" id="queryPayResultInfototalPage" />
</div>
<script type="text/javascript" src="${props('resourceUrl')}/js/payresultinfo/payresultinfo.js"></script>
</#macro>
<style>
    #payResultInfoTbl tr .btn{display:left;margin-right:5px;padding:2.5px 6px;}
    .title{padding-right:0px;text-align:right;margin:0px;height:34px;line-height:34px;}
    .redFont{color:red;display:inline-block;width:15px;text-align:center;}
    .modal-dialog{margin:165px auto;}
</style>


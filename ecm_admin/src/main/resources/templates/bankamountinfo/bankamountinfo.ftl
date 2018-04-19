<#import "/component/register.ftl" as  register/>
<#import "/bankamountinfo/bankamountinfo.ftl" as  bankamountinfo/>
<#import "/bankamountinfo/addBankamountInfo.ftl" as  addBankamountInfo/>
<#import "/bankamountinfo/updateBankamountInfo.ftl" as  updateBankamountInfo/>
<#import "/bankamountinfo/detailBankamountInfo.ftl" as  detailBankamountInfo/>
<#include "/management/resource.ftl"/>

<@bankamountinfo.bankamountinfoHtml/>
<@addBankamountInfo.addBankamountInfoHtml/>
<@detailBankamountInfo.detailBankamountInfoHtml/>
<@updateBankamountInfo.updateBankamountInfoHtml/>

<#macro bankamountinfoHtml>
<div style="" class="">
    <section class="content-header">
        <h1>
                银行账户表<small></small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <div class="box">
            <div class="box-header">
                <form id=queryBankamountInfoForm class="form-horizontal form-inline">
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">id：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="id" name="id">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">用户名称：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="userName" name="userName">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">身份证号：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="idcard" name="idcard">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">电话：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="phone" name="phone">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">微信用户名称：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="wxName" name="wxName">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">openid：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="openid" name="openid">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">银行账户：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="bankAmountNo" name="bankAmountNo">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">银行名称：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="bankName" name="bankName">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">开户地址：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="bankAdress" name="bankAdress">
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
                                <button type="button" class="btn btn-info searchBtn" onclick="searchBankamountInfo('')">搜索</button>
                                <button type="button" class="btn btn-info searchBtn" onclick="searchBankamountInfo('','download','download.xls','id:id,userName:用户名称,idcard:身份证号,phone:电话,wxName:微信用户名称,openid:openid,bankAmountNo:银行账户,bankName:银行名称,bankAdress:开户地址,createTime:创建时间,createUser:创建人,updateTime:修改时间,updateUser:修改人')">下载</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <div class="box-body">
                <div style="width:50px;margin:10px 0px;"><button class="btn btn-block btn-success" data-toggle="modal" data-target="#addBankamountInfo">添加</button></div>
                <table id="bankamountInfoTbl" class="table table-bordered">
                    <tr id="bankamountInfoTR_FIRST">
                        <th></th>
                        <th>序号</th>
                        <th>id</th>
                        <th>用户名称</th>
                        <th>身份证号</th>
                        <th>电话</th>
                        <th>微信用户名称</th>
                        <th>openid</th>
                        <th>银行账户</th>
                        <th>银行名称</th>
                        <th>开户地址</th>
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
            <div id="queryBankamountInfo_fy" style="width: 100%;" class="gmPagination gmPagination-mini">
                <div style="float:left;margin: 10px;">
                    <select id="queryBankamountInfopageSize">
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
    <input type="hidden" id="queryBankamountInfocurrentPage" />
    <input type="hidden" id="queryBankamountInfototalPage" />
</div>
<script type="text/javascript" src="${props('resourceUrl')}/js/bankamountinfo/bankamountinfo.js"></script>
</#macro>
<style>
    #bankamountInfoTbl tr .btn{display:left;margin-right:5px;padding:2.5px 6px;}
    .title{padding-right:0px;text-align:right;margin:0px;height:34px;line-height:34px;}
    .redFont{color:red;display:inline-block;width:15px;text-align:center;}
    .modal-dialog{margin:165px auto;}
</style>


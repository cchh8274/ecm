<#import "/component/register.ftl" as  register/>
<#import "/reflectinfo/reflectinfo.ftl" as  reflectinfo/>
<#import "/reflectinfo/addReflectInfo.ftl" as  addReflectInfo/>
<#import "/reflectinfo/updateReflectInfo.ftl" as  updateReflectInfo/>
<#import "/reflectinfo/detailReflectInfo.ftl" as  detailReflectInfo/>
<#include "/management/resource.ftl"/>

<@reflectinfo.reflectinfoHtml/>
<@addReflectInfo.addReflectInfoHtml/>
<@detailReflectInfo.detailReflectInfoHtml/>
<@updateReflectInfo.updateReflectInfoHtml/>

<#macro reflectinfoHtml>
<div style="" class="">
    <section class="content-header">
        <h1>
                体现记录表<small></small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <div class="box">
            <div class="box-header">
                <form id=queryReflectInfoForm class="form-horizontal form-inline">
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">id：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="id" name="id">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">体现流水号：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="transNo" name="transNo">
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
                                <input type="text" class="form-control" placeholder="" id="wxUser" name="wxUser">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">体现用户：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="reflectUser" name="reflectUser">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">银行卡号：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="bankCard" name="bankCard">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">银行名称：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="bankName" name="bankName">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">提现金额：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="reflectMoney" name="reflectMoney">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">是否到账：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="isAccount" name="isAccount">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">是否冻结：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="isFreeze" name="isFreeze">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">到账时间：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="accountTime" name="accountTime">
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
                                <button type="button" class="btn btn-info searchBtn" onclick="searchReflectInfo('')">搜索</button>
                                <button type="button" class="btn btn-info searchBtn" onclick="searchReflectInfo('','download','download.xls','id:id,transNo:体现流水号,openid:openid,wxUser:微信用户,reflectUser:体现用户,bankCard:银行卡号,bankName:银行名称,reflectMoney:提现金额,isAccount:是否到账,isFreeze:是否冻结,accountTime:到账时间,createTime:创建时间,createUser:创建人')">下载</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <div class="box-body">
                <div style="width:50px;margin:10px 0px;"><button class="btn btn-block btn-success" data-toggle="modal" data-target="#addReflectInfo">添加</button></div>
                <table id="reflectInfoTbl" class="table table-bordered">
                    <tr id="reflectInfoTR_FIRST">
                        <th></th>
                        <th>序号</th>
                        <th>id</th>
                        <th>体现流水号</th>
                        <th>openid</th>
                        <th>微信用户</th>
                        <th>体现用户</th>
                        <th>银行卡号</th>
                        <th>银行名称</th>
                        <th>提现金额</th>
                        <th>是否到账</th>
                        <th>是否冻结</th>
                        <th>到账时间</th>
                        <th>创建时间</th>
                        <th>创建人</th>
                        <th>操作</th>
                    </tr>
                </table>
                <div id="page1"></div>
            </div>
            <!-- /.box-body -->

            <!--分页 start-->
            <div id="queryReflectInfo_fy" style="width: 100%;" class="gmPagination gmPagination-mini">
                <div style="float:left;margin: 10px;">
                    <select id="queryReflectInfopageSize">
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
    <input type="hidden" id="queryReflectInfocurrentPage" />
    <input type="hidden" id="queryReflectInfototalPage" />
</div>
<script type="text/javascript" src="${props('resourceUrl')}/js/reflectinfo/reflectinfo.js"></script>
</#macro>
<style>
    #reflectInfoTbl tr .btn{display:left;margin-right:5px;padding:2.5px 6px;}
    .title{padding-right:0px;text-align:right;margin:0px;height:34px;line-height:34px;}
    .redFont{color:red;display:inline-block;width:15px;text-align:center;}
    .modal-dialog{margin:165px auto;}
</style>


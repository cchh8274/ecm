<#import "/component/register.ftl" as  register/>
<#import "/wxuserinfo/wxuserinfo.ftl" as  wxuserinfo/>
<#import "/wxuserinfo/addWxUserInfo.ftl" as  addWxUserInfo/>
<#import "/wxuserinfo/updateWxUserInfo.ftl" as  updateWxUserInfo/>
<#import "/wxuserinfo/detailWxUserInfo.ftl" as  detailWxUserInfo/>
<#include "/management/resource.ftl"/>

<@wxuserinfo.wxuserinfoHtml/>
<@addWxUserInfo.addWxUserInfoHtml/>
<@detailWxUserInfo.detailWxUserInfoHtml/>
<@updateWxUserInfo.updateWxUserInfoHtml/>

<#macro wxuserinfoHtml>
<div style="" class="">
    <section class="content-header">
        <h1>
                微信用户表<small></small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <div class="box">
            <div class="box-header">
                <form id=queryWxUserInfoForm class="form-horizontal form-inline">
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">ID：</label>
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
                            <label class="queryTitle">用户的昵称：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="nickname" name="nickname">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">性别：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="sex" name="sex">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">用户所在城市：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="city" name="city">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">用户所在国家：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="country" name="country">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">用户所在省份：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="province" name="province">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">用户的语言：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="language" name="language">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="headimgurl" name="headimgurl">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">用户关注时间：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="subscribeTime" name="subscribeTime">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="unionid" name="unionid">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">公众号运营者对粉丝的备注：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="remark" name="remark">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">用户所在的分组ID：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="groupid" name="groupid">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">用户被打上的标签ID列表：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="tagidList" name="tagidList">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">返回用户关注的渠道来源：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="subscribeScene" name="subscribeScene">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">二维码扫码场景：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="qrScene" name="qrScene">
                            </div>
                        </div>
                    </div>
                    <div class="row dis-top">
                        <div class="col-md-3">
                            <label class="queryTitle">二维码扫码场景描述：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="qrSceneStr" name="qrSceneStr">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">创建时间：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="createtTime" name="createtTime">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="queryTitle">创建人：</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" placeholder="" id="createUser" name="createUser">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="searchDiv">
                                <button type="button" class="btn btn-info searchBtn" onclick="searchWxUserInfo('')">搜索</button>
                                <button type="button" class="btn btn-info searchBtn" onclick="searchWxUserInfo('','download','download.xls','id:ID,openid:openid,nickname:用户的昵称,sex:性别,city:用户所在城市,country:用户所在国家,province:用户所在省份,language:用户的语言,headimgurl:,subscribeTime:用户关注时间,unionid:只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。,remark:公众号运营者对粉丝的备注,groupid:用户所在的分组ID,tagidList:用户被打上的标签ID列表,subscribeScene:返回用户关注的渠道来源,qrScene:二维码扫码场景,qrSceneStr:二维码扫码场景描述,createtTime:创建时间,createUser:创建人')">下载</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <div class="box-body">
                <div style="width:50px;margin:10px 0px;"><button class="btn btn-block btn-success" data-toggle="modal" data-target="#addWxUserInfo">添加</button></div>
                <table id="wxUserInfoTbl" class="table table-bordered">
                    <tr id="wxUserInfoTR_FIRST">
                        <th></th>
                        <th>序号</th>
                        <th>ID</th>
                        <th>openid</th>
                        <th>用户的昵称</th>
                        <th>性别</th>
                        <th>用户所在城市</th>
                        <th>用户所在国家</th>
                        <th>用户所在省份</th>
                        <th>用户的语言</th>
                        <th></th>
                        <th>用户关注时间</th>
                        <th>只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。</th>
                        <th>公众号运营者对粉丝的备注</th>
                        <th>用户所在的分组ID</th>
                        <th>用户被打上的标签ID列表</th>
                        <th>返回用户关注的渠道来源</th>
                        <th>二维码扫码场景</th>
                        <th>二维码扫码场景描述</th>
                        <th>创建时间</th>
                        <th>创建人</th>
                        <th>操作</th>
                    </tr>
                </table>
                <div id="page1"></div>
            </div>
            <!-- /.box-body -->

            <!--分页 start-->
            <div id="queryWxUserInfo_fy" style="width: 100%;" class="gmPagination gmPagination-mini">
                <div style="float:left;margin: 10px;">
                    <select id="queryWxUserInfopageSize">
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
    <input type="hidden" id="queryWxUserInfocurrentPage" />
    <input type="hidden" id="queryWxUserInfototalPage" />
</div>
<script type="text/javascript" src="${props('resourceUrl')}/js/wxuserinfo/wxuserinfo.js"></script>
</#macro>
<style>
    #wxUserInfoTbl tr .btn{display:left;margin-right:5px;padding:2.5px 6px;}
    .title{padding-right:0px;text-align:right;margin:0px;height:34px;line-height:34px;}
    .redFont{color:red;display:inline-block;width:15px;text-align:center;}
    .modal-dialog{margin:165px auto;}
</style>


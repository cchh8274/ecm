<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
    <meta http-equiv="X-UA-Compatible" content="IE=9" />
    <meta name="renderer" content="webkit">
    <title>${systemName!'ECM后台管理系统'}</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${props('resourceUrl')}/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="${props('resourceUrl')}/css/bootstrap/bootstrapValidator.css">

    <link rel="stylesheet" href="${props('resourceUrl')}/css/login/normalize.css" />
    <link rel="stylesheet" href="${props('resourceUrl')}/css/login/demo.css" />
    <link rel="stylesheet" href="${props('resourceUrl')}/css/login/component.css" />
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <style type="text/css">
        html, body, div,p{margin:0;padding:0;font-weight:400;}
        .login-content{background:url('${props('resourceUrl')}/img/login-background_dipper.jpg') no-repeat;width:100%;height:100%;}
        .login-header,.login-footer{width:100%;height:50px;color:#FFF;font-size:12px;line-height:50px;}
        .login-header .logo-img{display:block;float:left;height:50px;width:50px;background:url('${props('resourceUrl')}/img/user-lock.png') no-repeat scroll 0px -5px;}
        .login-header .logo-title{display:block;float:left;height:50px;font-size:20px;font-weight:bold;}
        .login-box{position:fixed;top:50%;left:50%;-webkit-transform:translate3d(-50%,-50%,0);transform:translate3d(-50%,-50%,0);width:500px;height:350px;background:url('${props('resourceUrl')}/img/login-box.png') no-repeat;padding:35px 65px 35px 65px;font-size:14px}
        :root .login-box{top:0px\0;margin:260px 0px 0px -250px\0;}
        
        .userInfo{width:370px;height:70px;overflow:hidden;margin-bottom:0px;}
        .userInfo .colName{float:left;display:inline-block;width:60px;height:40px;margin-bottom:0px;padding:0px;color:#fff;line-height:65px;text-align:left;}
        .userInfo input{float:left;height:40px;width:250px;background:none;border:none;border-bottom:1px solid #fff;color: #fff;padding-top:15px;*padding-top:0px;*line-height:60px;font-size:14px;}
        .userInfo .checkCodeDiv{padding:0px;width:160px;float:left;}
        .userInfo .checkCode{width:160px;}
        .userInfo .checkCodeBtnDiv{padding:0px;width:70px;float:left;margin-left:15px;}
        .userInfo .checkCodeBtn{width:50px;}
        .userInfo .userName{background:url('${props('resourceUrl')}/img/user-lock.png') no-repeat scroll 0px -5px;}
        .userInfo .userPwd{background:url('${props('resourceUrl')}/img/user-lock.png') no-repeat scroll 0px -70px;}
        .userInfo .code-text{float:left;display:inline-block;width:60px;height:40px;color:#fff;line-height:55px;}
        .userInfo .code{background:none;border:1px solid #fff;color:#fff;width:80px;height:32px;line-height:34px;text-align:center;display:block;float:right;letter-spacing:4px;font-size:14px;font-family:Arial;margin-top:8px;border-radius:20px;cursor:pointer;}

        .userInfo .btn-login{width:100%;height:40px;background:none;border:1px solid #fff;color:#fff;-moz-border-radius:20px;-webkit-border-radius:20px;border-radius:20px;}
        .userInfo .help-block{position:absolute;top:40px;left:0px;font-weight:bold;font-size:14px}
    </style>
</head>
<body>
<div class="login-content">
    <div class="login-header">
        <p class="logo-img"></p>
        <p class="logo-title">${systemName!'ECM后台管理系统'}</p>
    </div>
    <div id="large-header" class="large-header">
        <canvas id="demo-canvas"></canvas>
        <form action="loginCheck.dhtml" method="post" id="validateLogin" class="loginform">
            <input type="hidden" name="goUrl" value="${goUrl!''}">
            <input type="hidden" name="checkCodeOld" value="${checkCode!""}">
            <div class="login-box">
                <div class="form-group userInfo">
                    <label class="col-lg-3 colName userName"></label>
                    <div class="col-lg-9 clearfix" style="width:310px;padding:0px;position:relative;">
                        <input type="text" name="userAccount" value='${userAccount!""}'
                               data-bv-message="The username is not valid"

                               data-bv-notempty="true"
                               data-bv-notempty-message="用户名不能为空"

                               data-bv-regexp="true"
                               data-bv-regexp-regexp="[a-zA-Z0-9_\.]+"
                               data-bv-regexp-message="The username can only consist of alphabetical, number, dot and underscore"

                               data-bv-stringlength="true"
                               data-bv-stringlength-min="3"
                               data-bv-stringlength-max="30"
                               data-bv-stringlength-message="用户名在3-30个字符之间"

                                />
                    </div>
                </div>
                <div class="form-group userInfo">
                    <label class="col-lg-3 colName userPwd"></label>
                    <div class="col-lg-9 clearfix" style="width:310px;padding:0px;position:relative;">
                        <input type="password" name="password"
                               data-bv-notempty="true"
                               data-bv-notempty-message="密码不能为空"
                               data-bv-stringlength="true"
                               data-bv-stringlength-min="3"
                               data-bv-stringlength-max="30"
                               data-bv-stringlength-message="密码在3-30个字符之间"
                                />
                    </div>
                </div>
                <div class="form-group userInfo">
                    <label class="col-lg-3 colName">验证码</label>
                    <div class="col-lg-9 clearfix" style="width:310px;padding:0px;position:relative;">
                        <div class="col-lg-6 checkCodeDiv">
                            <input type="text"  name="checkCode" class="checkCode" value="">
                        </div>
                        <div class="col-lg-3 checkCodeBtnDiv">
                            <span id="checkCodeBtn" class="code" onclick="refreskCheckCode()" >${checkCode!""}</span>
                        </div>
                    </div>
                </div>
                <div class="userInfo" style="padding:20px 0px 0px;">
                    <button type="submit" class="btn-login">登录</button>
                </div>
                <span id="messageId" class="code" style="color:red">${message!""}</span>
            </div>
        </form>
        <div class="codrops-demos">@2000-2017  国美在线</div>
    </div>
</div>
<!--<script type="text/javascript" src="${props('resourceUrl')}/js/plugins/jQuery/jQuery-2.1.4.min.js"></script>-->
<script type="text/javascript" src="${props('resourceUrl')}/js/plugins/jQuery/jQuery-1.11.3.min.js"></script>
<script type="text/javascript" src="${props('resourceUrl')}/js/plugins/bootstrap.min.js"></script>
<script type="text/javascript" src="${props('resourceUrl')}/js/plugins/bootstrapValidator.js"></script>
<script type="text/javascript" src="${props('resourceUrl')}/js/login/TweenLite.min.js"></script>
<script type="text/javascript" src="${props('resourceUrl')}/js/login/EasePack.min.js"></script>
<script type="text/javascript" src="${props('resourceUrl')}/js/login/rAF.js"></script>
<script type="text/javascript" src="${props('resourceUrl')}/js/login/login-canvas-001.js"></script>
<script>
    if (!document.addEventListener) {
        // IE6~IE8，因为IE10已经将条件注释干掉了
        document.write('<script src="${props('resourceUrl')}/js/plugins/ieBetter.js"><\/script>');
        document.write('<script src="${props('resourceUrl')}/js/plugins/html5shiv.min.js"><\/script>');
        document.write('<script src="${props('resourceUrl')}/js/plugins/respond.min.js"><\/script>');
        //ie8以下不支持console
        window.console = window.console || (function () {
            var c = {}; c.log = c.warn = c.debug = c.info = c.error = c.time = c.dir = c.profile
                    = c.clear = c.exception = c.trace = c.assert = function () { };
            return c;
        })();
        //动态修改浏览器大小
        function resizeBrosizeOnLoginPage(){
            //修改背景图片高度
            $(".login-content").css("height",document.documentElement.clientHeight);
            //修改登录框位置
            var login_box_top = (document.documentElement.clientHeight-350 )/2;
            var login_box_left = (document.documentElement.clientWidth-500 )/2;
            if(login_box_left>0){
                $(".login-box").css("left",login_box_left);
            }
            if(login_box_top>0){
                $(".login-box").css("top",login_box_top);
            }
        }
        resizeBrosizeOnLoginPage();
        $(window).resize(function(){
            resizeBrosizeOnLoginPage();
        })
    }
    $(function () {
        $('#validateLogin').bootstrapValidator();
    });

    function refreskCheckCode(){
        $.ajax({
            type:"POST",
            url:"${props('resourceUrl')}/login/refreshANewCheckCode.dhtml",
            timeout:10000,
            dataType:'json',
            success:function(data){
                $("#checkCodeBtn").text(data);
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                //alert('您的点击过于频繁！');
            },
            complete : function(XMLHttpRequest,status){
                if(status == "timeout"){
                    ajaxTimeoutTest.abort();
                    alert("获取验证码！");
                }
            }
        });
    }
</script>
</body>
</html>

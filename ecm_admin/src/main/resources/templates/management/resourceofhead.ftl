<#--
resource.ftl和resourceofmenu.ftl在内容上是一致的，区别在于
1、menu.ftl中引用的是resourceofmenu.ftl，内容必须存在
2、每一个独立页面例如sysdic.ftl中引用的是resource.ftl，其中仅当为嵌入模式时，resource.ftl中才会有内容
3、非iframe嵌入模式，使用jqueryLoad加载js时，会导致js加载两次，页面会发生很多js调用两次或以上的BUG
-->
        <!--<script type="text/javascript" src="${props('resourceUrl')}/js/plugins/jQuery/jQuery-2.1.4.min.js"></script>-->
        <script type="text/javascript" src="${props('resourceUrl')}/js/plugins/jQuery/jQuery-1.11.3.min.js"></script>
        <link rel="stylesheet" href="${props('resourceUrl')}/css/bootstrap/font-awesome.min.css">
        <link rel="stylesheet" href="${props('resourceUrl')}/css/bootstrap/AdminLTE.min.css">
        <link rel="stylesheet" href="${props('resourceUrl')}/css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="${props('resourceUrl')}/css/bootstrap/blue.css">
        <!--
        <link rel="stylesheet" href="${props('resourceUrl')}/css/bootstrap/daterangepicker-bs3.css">
        <script type="text/javascript" src="${props('resourceUrl')}/js/plugins/daterangepicker.js"></script>
        -->
        <link rel="stylesheet" href="${props('resourceUrl')}/css/bootstrap/datepicker3.css">
        <link rel="stylesheet" href="${props('resourceUrl')}/css/bootstrap/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" href="${props('resourceUrl')}/css/bootstrap/bootstrapValidator.css">
        <link rel="stylesheet" href="${props('resourceUrl')}/css/ionicons.min.css">
        <link rel="stylesheet" href="${props('resourceUrl')}/css/dataTables.bootstrap.css">
        <link rel="stylesheet" href="${props('resourceUrl')}/css/_all-skins.min.css">
        <link rel="stylesheet" href="${props('resourceUrl')}/css/page.css">
        <link rel="stylesheet" href="${props('resourceUrl')}/css/new.css">
        <link rel="stylesheet" href="${props('resourceUrl')}/css/bootstrap/bootstrap-addtabs.css">
       	<link rel="stylesheet" href="${props('resourceUrl')}/css/jquery-ui.min.css">
        <link rel="stylesheet" href="${props('resourceUrl')}/css/ecalendar.style.css">
        <link rel="stylesheet" href="${props('resourceUrl')}/css/jquery.daterangepicker.css">
        <link rel="stylesheet" href="${props('resourceUrl')}/css/simple-line-icons.css">
        <script>
            if(typeof(webUrl)=='undefined'){
                webUrl="";
            }
        </script>
        <!-- Bootstrap 3.3.5 -->
        <script src="${props('resourceUrl')}/js/plugins/bootstrap.min.js"></script>
        <!-- SlimScroll -->
        <script src="${props('resourceUrl')}/js/plugins/slimScroll/jquery.slimscroll.min.js"></script>
        <!-- FastClick -->
        <script src="${props('resourceUrl')}/js/plugins/fastclick/fastclick.js"></script>
        <!-- AdminLTE App -->
        <script src="${props('resourceUrl')}/js/plugins/dist/app.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="${props('resourceUrl')}/js/plugins/dist/demo.js"></script>
        <script src="${props('resourceUrl')}/js/plugins/iCheck/icheck.min.js"></script>
        <script src="${props('resourceUrl')}/js/pager_v1.0.2.js"></script>

        <script type="text/javascript" src="${props('resourceUrl')}/js/plugins/moment.js"></script>
        <script type="text/javascript" src="${props('resourceUrl')}/js/jquery-ui.min.js"></script>
        <script type="text/javascript" src="${props('resourceUrl')}/js/plugins/bootstrap-datepicker.js"></script>
        <script type="text/javascript" src="${props('resourceUrl')}/js/plugins/bootstrap-datepicker.zh-CN.js"></script>
        <script type="text/javascript" src="${props('resourceUrl')}/js/plugins/bootstrap-datetimepicker.js"></script>
        <script type="text/javascript" src="${props('resourceUrl')}/js/plugins/bootstrap-datetimepicker.zh-CN.js"></script>
        <script type="text/javascript" src="${props('resourceUrl')}/js/plugins/bootstrap-addtabs.js"></script>
        <script type="text/javascript" src="${props('resourceUrl')}/js/layer/layer.js"></script>
        <script type="text/javascript" src="${props('resourceUrl')}/js/plugins/bootstrapValidator.js"></script>
        <script type="text/javascript" src="${props('resourceUrl')}/js/plugins/ecalendar.jquery.min.js"></script>
        <script type="text/javascript" src="${props('resourceUrl')}/js/plugins/jquery.daterangepicker.js"></script>
        <!-- input button power check-->
		<script type="text/javascript" src="${props('resourceUrl')}/js/powercheck.js"></script>
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
            }
        </script>

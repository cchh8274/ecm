$(function(){
    searchUnionDemoSubInfo('');
    $('#queryUnionDemoSubInfopageSize').on('change',function () {
        var currentPage = $("#queryUnionDemoSubInfocurrentPage").val();
        searchUnionDemoSubInfo(currentPage);
    });
    
    //时间框校验函数，时间框在校验失败后，再点击，不会触发校验，因此手工触发
    function revalidateDate(formname,datefieldname){
        if($("#"+formname+"").data('bootstrapValidator')!=null
            && $("#"+formname+"").data('bootstrapValidator').validateField !=null)
        {
            $("#"+formname+"").data('bootstrapValidator').updateStatus(datefieldname,"NOT_VALIDATED",null);
            $("#"+formname+"").data('bootstrapValidator').validateField(datefieldname);
        }
    }
    //在模态框对用户完全可见后，清空所有的校验状态，经验证：
    // show.bs.modal，shown.bs.modal，hide.bs.modal	，hidden.bs.modal仅有  shown.bs.modal在功能上没问题，但是视觉上仍不太满意
    // 理论上说，最合适的是hidden.bs.modal，当模态框关闭时清空，但实际上未能生效，因此使用了shown.bs.modal
    $('#updateUnionDemoSubInfo').on('shown.bs.modal', function () {
        $('#validateUpdateUnionDemoSubInfoForm').bootstrapValidator('resetForm', false);
    });
    $("#queryUnionDemoSubInfoForm #createTimec").ECalendar({
        type:"time",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd hh:ii:ss",
        skin:1,
        step:1,
        callback:function(v,e){revalidateDate("queryUnionDemoSubInfoForm","createTimec");} //回调函数
    });
    $("#validateAddUnionDemoSubInfoForm #createTimec1").ECalendar({
        type:"time",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd hh:ii:ss",
        skin:1,
        step:1,
        callback:function(v,e){revalidateDate("validateAddUnionDemoSubInfoForm","createTimec1");} //回调函数
    });
    $("#validateUpdateUnionDemoSubInfoForm #createTimec3").ECalendar({
        type:"time",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd hh:ii:ss",
        skin:1,
        step:1,
        callback:function(v,e){revalidateDate("validateUpdateUnionDemoSubInfoForm","createTimec3");} //回调函数
    });
    $('#queryUnionDemoSubInfoForm #createDatec').dateRangePicker({
        startOfWeek: 'monday',
        separator : ' 至 ',
        format: 'YYYY-MM-DD',
        autoClose: false
    });
    $("#validateAddUnionDemoSubInfoForm #createDatec1").ECalendar({
        type:"date",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd",
        skin:1,
        callback:function(v,e){revalidateDate("validateAddUnionDemoSubInfoForm","createDatec1");} //回调函数
    });
    $("#validateUpdateUnionDemoSubInfoForm #createDatec3").ECalendar({
        type:"date",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd",
        skin:1,
        callback:function(v,e){revalidateDate("validateUpdateUnionDemoSubInfoForm","createDatec3");} //回调函数
    });

    //增加联表查询DEMO-子表校验
    $('#validateAddUnionDemoSubInfoForm').bootstrapValidator({
        fields : {
            demoNmc1 : {
                validators : {"stringLength":{"message":"演示名称长度不正确","min":1,"max":100},"notEmpty":{"message":"演示名称不能为空"},"regexp":{"message":"演示名称只能是中文、英文、数字与下划线","regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$"}}
            }
            ,
            createTimec1 : {
                validators : {
                    notEmpty : {
                        message : 'XX信息不能为空'
                    },
                    stringLength : {
                        min : 1,
                        max : 100,
                        message : 'XX信息长度不正确'
                    },
                    regexp : {
                        regexp : "^.+$",
                        message : 'XX信息与要求的格式不符'
                    }
                }
            }
            ,
            demoMoneyc1 : {
                validators : {"stringLength":{"message":"演示金额长度不正确","min":1,"max":100},"notEmpty":{"message":"演示金额不能为空"},"regexp":{"message":"演示金额格式不符","regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$"}}
            }
            ,
            selectStaticc1 : {
                validators : {"notEmpty":{"message":"请选择一个静态选择框"}}
            }
            ,
            selectDynamicc1 : {
                validators : {"notEmpty":{"message":"请选择一个动态选择框"}}
            }
            ,
            radioStaticc1 : {
                validators : {"notEmpty":{"message":"请选择一个静态单选按钮"}}
            }
            ,
            radioDynamicc1 : {
                validators : {"notEmpty":{"message":"请选择一个动态单选按钮"}}
            }
            ,
            createDatec1 : {
                validators : {
                    notEmpty : {
                        message : 'XX信息不能为空'
                    },
                    stringLength : {
                        min : 1,
                        max : 100,
                        message : 'XX信息长度不正确'
                    },
                    regexp : {
                        regexp : "^.+$",
                        message : 'XX信息与要求的格式不符'
                    }
                }
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         addUnionDemoSubInfo();
     });

    //修改联表查询DEMO-子表校验
    $('#validateUpdateUnionDemoSubInfoForm').bootstrapValidator({
        fields : {
            demoNmc3 : {
                validators : {"stringLength":{"message":"演示名称长度不正确","min":1,"max":100},"notEmpty":{"message":"演示名称不能为空"},"regexp":{"message":"演示名称只能是中文、英文、数字与下划线","regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$"}}
            }
            ,
            createTimec3 : {
                validators : {
                    notEmpty : {
                        message : 'XX信息不能为空'
                    },
                    stringLength : {
                        min : 1,
                        max : 100,
                        message : 'XX信息长度不正确'
                    },
                    regexp : {
                        regexp : "^.+$",
                        message : 'XX信息与要求的格式不符'
                    }
                }
            }
            ,
            demoMoneyc3 : {
                validators : {"stringLength":{"message":"演示金额长度不正确","min":1,"max":100},"notEmpty":{"message":"演示金额不能为空"},"regexp":{"message":"演示金额格式不符","regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$"}}
            }
            ,
            selectStaticc3 : {
                validators : {"notEmpty":{"message":"请选择一个静态选择框"}}
            }
            ,
            selectDynamicc3 : {
                validators : {"notEmpty":{"message":"请选择一个动态选择框"}}
            }
            ,
            radioStaticc3 : {
                validators : {"notEmpty":{"message":"请选择一个静态单选按钮"}}
            }
            ,
            radioDynamicc3 : {
                validators : {"notEmpty":{"message":"请选择一个动态单选按钮"}}
            }
            ,
            createDatec3 : {
                validators : {
                    notEmpty : {
                        message : 'XX信息不能为空'
                    },
                    stringLength : {
                        min : 1,
                        max : 100,
                        message : 'XX信息长度不正确'
                    },
                    regexp : {
                        regexp : "^.+$",
                        message : 'XX信息与要求的格式不符'
                    }
                }
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         updateUnionDemoSubInfo();
     });
    //查询联表查询DEMO-子表校验
    $('#queryUnionDemoSubInfoForm').bootstrapValidator({
        fields : {
            demoIdc : {
                validators : {"stringLength":{"message":"表ID长度不正确","min":1,"max":100},"regexp":{"message":"表ID与要求的格式不符","regexp":"^[0-9]*$"}}
            }
            ,
            forgienId : {
                validators : {"stringLength":{"message":"表ID长度不正确","min":1,"max":100},"regexp":{"message":"表ID与要求的格式不符","regexp":"^[0-9]*$"}}
            }
            ,
            demoNmc : {
                validators : {"stringLength":{"message":"演示名称长度不正确","min":1,"max":100},"regexp":{"message":"演示名称只能是中文、英文、数字与下划线","regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$"}}
            }
            ,
            createTimec : {
                validators : {"stringLength":{"min":1,"max":100,"message":"XX信息长度不正确"},"regexp":{"regexp":"^.+$","message":"XX信息与要求的格式不符"}}
            }
            ,
            demoMoneyc : {
                validators : {"stringLength":{"message":"演示金额长度不正确","min":1,"max":100},"regexp":{"message":"演示金额格式不符","regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$"}}
            }
            ,
            selectStaticc : {
                validators : {}
            }
            ,
            selectDynamicc : {
                validators : {}
            }
            ,
            radioStaticc : {
                validators : {}
            }
            ,
            radioDynamicc : {
                validators : {}
            }
            ,
            createDatec : {
                validators : {"stringLength":{"min":1,"max":100,"message":"XX信息长度不正确"},"regexp":{"regexp":"^([0-9]{4}-[0-9]{2}-[0-9]{2})( )*至( )*([0-9]{4}-[0-9]{2}-[0-9]{2})$","message":"时间格式不正确"}}
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         console.log("查询校验通过");
     });

});

function searchUnionDemoSubInfo(currentPage,queryType,fileName,exportParam){
    //没有bootstrapvalidator，则返回
    if($('#queryUnionDemoSubInfoForm').data('bootstrapValidator')!=null) {
        //对查询框进行校验
        $('#queryUnionDemoSubInfoForm').data('bootstrapValidator').validate();
        //校验没有通过，则返回
        if(!$('#queryUnionDemoSubInfoForm').data('bootstrapValidator').isValid()){
            return;
        }
        //----个性化校验示例开始
        //if($('#query"+cleanentityClassName+"Form #被验证组件name').val()=='#'){
        //    layer.alert('XX禁止查询')
        //    //第三个参数为，显示的错误信息所属的validator规则
        //    $('#queryUnionDemoSubInfoForm').data('bootstrapValidator').updateStatus('被验证组件name','INVALID','stringLength');
        //    return;
        //}
        //----个性化校验示例结束
    }
    var params ={};
    if(currentPage == "undefined" || currentPage =="" || currentPage == null){
        var currentPage_text = $("#queryUnionDemoSubInfocurrentPage").val();
        if(currentPage_text =="undefined" || currentPage_text =="" || currentPage_text == null){
            currentPage_text = "1";
        }
        params.startIndex = currentPage_text;
    }else{
        params.startIndex = currentPage;
    }

    var pageSize= $("#queryUnionDemoSubInfopageSize").val();
    if(pageSize=="undefined" || pageSize =="" || pageSize == null){
        params.pageSize = "10";
    }else{
        params.pageSize = pageSize;
    }
    if(queryType!=undefined && queryType =='download'){
        params.queryType='download';
        params.exportParam=exportParam;
        params.fileName=fileName;
    }

    params.demoIdc = $("#queryUnionDemoSubInfoForm #demoIdc").val();
    params.forgienId = $("#queryUnionDemoSubInfoForm #forgienId").val();
    params.demoNmc = $("#queryUnionDemoSubInfoForm #demoNmc").val();
    params.createTimec = $("#queryUnionDemoSubInfoForm #createTimec").val();
    params.demoMoneyc = $("#queryUnionDemoSubInfoForm #demoMoneyc").val();
    params.selectStaticc = $("#queryUnionDemoSubInfoForm #selectStaticc").val();
    params.selectDynamicc = $("#queryUnionDemoSubInfoForm #selectDynamicc").val();
    params.radioStaticc = $("#queryUnionDemoSubInfoForm input[name='radioStaticc']:checked").val();
    params.radioDynamicc = $("#queryUnionDemoSubInfoForm input[name='radioDynamicc']:checked").val();
    //对于checkbox复选框，作为查询条件默认注释掉，否则将导致数据查询不出。如有需要，请根据需求放开
    //params.checkboxStaticc = getCheckBoxVal("queryUnionDemoSubInfoForm","checkboxStaticc");
    //对于checkbox复选框，作为查询条件默认注释掉，否则将导致数据查询不出。如有需要，请根据需求放开
    //params.checkboxDynamicc = getCheckBoxVal("queryUnionDemoSubInfoForm","checkboxDynamicc");
    var createDatec_regexp = new RegExp('^([0-9]{4}-[0-9]{2}-[0-9]{2})( )*至( )*([0-9]{4}-[0-9]{2}-[0-9]{2})$');
    var createDatec_value = $("#queryUnionDemoSubInfoForm #createDatec").val();
    if(createDatec_regexp.test(createDatec_value)){
        var cs = createDatec_regexp.exec(createDatec_value);
        params.createDatec_start = cs[1]||'';
        params.createDatec_end = cs[4]||'';
    }
    

    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    jsonStr = encodeURIComponent(jsonStr);
    if(queryType!=undefined && queryType =='download'){
        window.location.href=webUrl+"/unionDemoSubInfo/search.dhtml?jsonStr="+jsonStr+"&v="+Math.random();
        return;
    }
    
    $.ajax({
        type:"POST",
        url:webUrl+"/unionDemoSubInfo/search.dhtml",
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $("#unionDemoSubInfoTR_FIRST").siblings().remove();
                var  resultList=data.rows[0].pageRecords;

                //分页
                $("#queryUnionDemoSubInfocurrentPage").val(data.rows[0].startIndex);
                $("#queryUnionDemoSubInfototalPage").val(data.rows[0].totalPage);
                $("#queryUnionDemoSubInfopageSize").val(data.rows[0].pageSize);
                for(var i=0;i<resultList.length;i++){
                    var unionDemoSubInfoTr = $("<tr class=\"unionDemoSubInfoTr\"></tr>");
                    $("#unionDemoSubInfoTR_FIRST").parent().append(unionDemoSubInfoTr);
                    unionDemoSubInfoTr.append("<td><input style=\"width:23px;\" type=\"checkbox\"/></td><td>"+(i+1)+"</td>")
                    .append("<td>"+resultList[i].demoNmc+"</td>")
                    .append("<td>"+resultList[i].createTimec+"</td>")
                    .append("<td>"+resultList[i].countNumberc+"</td>")
                    .append("<td>"+resultList[i].demoMoneyc+"</td>")
                    .append("<td>"+resultList[i].selectStaticc_name+"</td>")
                    .append("<td>"+resultList[i].selectDynamicc_name+"</td>")
                    .append("<td>"+resultList[i].radioStaticc_name+"</td>")
                    .append("<td>"+resultList[i].radioDynamicc_name+"</td>")
                    .append("<td>"+resultList[i].checkboxStaticc+"</td>")
                    .append("<td>"+resultList[i].checkboxDynamicc+"</td>")
                    .append("<td>"+resultList[i].createDatec+"</td>")
                    .append("<td class=\"operateTbl\"><button class=\"btn btn-default btn-sm\" onclick=\"return editUnionDemoSubInfo('"+resultList[i].demoIdc+"');\"><i class=\"fa fa-edit\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return  delUnionDemoSubInfo('"+resultList[i].demoIdc+"');\"><i class=\"fa fa-trash-o\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return queryUnionDemoSubInfoObject('"+resultList[i].demoIdc+"');\"><i class=\"fa fa-search\"></i></button></td>");
                }
                var currentPage = Number($("#queryUnionDemoSubInfocurrentPage").val());
                var totalPage   = Number($("#queryUnionDemoSubInfototalPage").val());
                var pageSize    = Number($("#queryUnionDemoSubInfopageSize").val());
                $("#queryUnionDemoSubInfo_fy .pager").ucPager({
                    currentPage : currentPage,
                    totalPage : totalPage,
                    pageSize : pageSize,
                    clickCallback: queryUnionDemoSubInfogopage
                });
            }else{
                layer.alert(data.message);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                layer.alert("操作超时！");
            }
        }
    });
}

function queryUnionDemoSubInfogopage(currentPage) {
    searchUnionDemoSubInfo(currentPage);
}

function addUnionDemoSubInfo(){
    var url=webUrl+"/unionDemoSubInfo/insert.dhtml";
    var params={};
    params.demoNmc = $("#validateAddUnionDemoSubInfoForm #demoNmc1").val();
    params.createTimec = $("#validateAddUnionDemoSubInfoForm #createTimec1").val();
    params.demoMoneyc = $("#validateAddUnionDemoSubInfoForm #demoMoneyc1").val();
    params.selectStaticc = $("#validateAddUnionDemoSubInfoForm #selectStaticc1").val();
    params.selectDynamicc = $("#validateAddUnionDemoSubInfoForm #selectDynamicc1").val();
    params.radioStaticc = $("#validateAddUnionDemoSubInfoForm input[name='radioStaticc1']:checked").val();
    params.radioDynamicc = $("#validateAddUnionDemoSubInfoForm input[name='radioDynamicc1']:checked").val();
    params.checkboxStaticc = getCheckBoxVal("validateAddUnionDemoSubInfoForm","checkboxStaticc1");
    params.checkboxDynamicc = getCheckBoxVal("validateAddUnionDemoSubInfoForm","checkboxDynamicc1");
    params.createDatec = $("#validateAddUnionDemoSubInfoForm #createDatec1").val();
    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    $.ajax({
        type:"POST",
        url:url,
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $('#addUnionDemoSubInfo').modal('hide');
                searchUnionDemoSubInfo('');
                layer.msg('添加成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateAddUnionDemoSubInfoForm').bootstrapValidator('resetForm', true);
                setCheckBoxVal("validateAddUnionDemoSubInfoForm","checkboxStaticc1",'00000000000000000000000000000000');
                setCheckBoxVal("validateAddUnionDemoSubInfoForm","checkboxDynamicc1",'00000000000000000000000000000000');
            }else{
                layer.alert(data.message);
                $('#validateAddUnionDemoSubInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
                $('#validateAddUnionDemoSubInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateAddUnionDemoSubInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function updateUnionDemoSubInfo(){
    var url=webUrl+"/unionDemoSubInfo/edit.dhtml";
    var params={};
    params.id_key = $("#validateUpdateUnionDemoSubInfoForm #id_key").val();
    params.demoNmc = $("#validateUpdateUnionDemoSubInfoForm #demoNmc3").val();
    params.createTimec = $("#validateUpdateUnionDemoSubInfoForm #createTimec3").val();
    params.demoMoneyc = $("#validateUpdateUnionDemoSubInfoForm #demoMoneyc3").val();
    params.selectStaticc = $("#validateUpdateUnionDemoSubInfoForm #selectStaticc3").val();
    params.selectDynamicc = $("#validateUpdateUnionDemoSubInfoForm #selectDynamicc3").val();
    params.radioStaticc = $("#validateUpdateUnionDemoSubInfoForm input[name='radioStaticc3']:checked").val();
    params.radioDynamicc = $("#validateUpdateUnionDemoSubInfoForm input[name='radioDynamicc3']:checked").val();
    params.checkboxStaticc = getCheckBoxVal("validateUpdateUnionDemoSubInfoForm","checkboxStaticc3");
    params.checkboxDynamicc = getCheckBoxVal("validateUpdateUnionDemoSubInfoForm","checkboxDynamicc3");
    params.createDatec = $("#validateUpdateUnionDemoSubInfoForm #createDatec3").val();
    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    $.ajax({
        type:"POST",
        url:url,
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $('#updateUnionDemoSubInfo').modal('hide');
                searchUnionDemoSubInfo('');
                layer.msg('修改成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateUpdateUnionDemoSubInfoForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateUpdateUnionDemoSubInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
            $('#validateUpdateUnionDemoSubInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateUpdateUnionDemoSubInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function editUnionDemoSubInfo(id_key){
    var url=webUrl+"/unionDemoSubInfo/queryObject.dhtml";
    var params={};
    params.id_key = id_key;;
    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    $.ajax({
        type:"POST",
        url:url,
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $('#updateUnionDemoSubInfo').modal();
                $("#validateUpdateUnionDemoSubInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblUnionDemoSubInfo;
                $("#validateUpdateUnionDemoSubInfoForm #demoIdc3").val(objInfo.demoIdc!=null?objInfo.demoIdc:'');
                $("#validateUpdateUnionDemoSubInfoForm #forgienId3").val(objInfo.forgienId!=null?objInfo.forgienId:'');
                $("#validateUpdateUnionDemoSubInfoForm #demoNmc3").val(objInfo.demoNmc!=null?objInfo.demoNmc:'');
                $("#validateUpdateUnionDemoSubInfoForm #createTimec3").val(objInfo.createTimec!=null?objInfo.createTimec:'');
                $("#validateUpdateUnionDemoSubInfoForm #countNumberc3").val(objInfo.countNumberc!=null?objInfo.countNumberc:'');
                $("#validateUpdateUnionDemoSubInfoForm #demoMoneyc3").val(objInfo.demoMoneyc!=null?objInfo.demoMoneyc:'');
                $("#validateUpdateUnionDemoSubInfoForm #selectStaticc3").val(objInfo.selectStaticc!=null?objInfo.selectStaticc:'');
                $("#validateUpdateUnionDemoSubInfoForm #selectDynamicc3").val(objInfo.selectDynamicc!=null?objInfo.selectDynamicc:'');
                //使用原生javascript对radio进行操作，避免浏览器不兼容问题
                $("#validateUpdateUnionDemoSubInfoForm input[name='radioStaticc3'][value='"+(objInfo.radioStaticc!=null?objInfo.radioStaticc:'')+"']")[0].checked=true;
                //使用原生javascript对radio进行操作，避免浏览器不兼容问题
                $("#validateUpdateUnionDemoSubInfoForm input[name='radioDynamicc3'][value='"+(objInfo.radioDynamicc!=null?objInfo.radioDynamicc:'')+"']")[0].checked=true;
                setCheckBoxVal("validateUpdateUnionDemoSubInfoForm","checkboxStaticc3",(objInfo.checkboxStaticc!=null?objInfo.checkboxStaticc:''));
                setCheckBoxVal("validateUpdateUnionDemoSubInfoForm","checkboxDynamicc3",(objInfo.checkboxDynamicc!=null?objInfo.checkboxDynamicc:''));
                $("#validateUpdateUnionDemoSubInfoForm #createDatec3").val(objInfo.createDatec!=null?objInfo.createDatec:'');
            }else{
                layer.alert(data.message);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
            }
        }
    });
}

function queryUnionDemoSubInfoObject(id_key){
    var url=webUrl+"/unionDemoSubInfo/queryObject.dhtml";
    var params={};
    params.id_key = id_key;;
    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    $.ajax({
        type:"POST",
        url:url,
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $('#detailUnionDemoSubInfo').modal();
                $("#validateDetailUnionDemoSubInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblUnionDemoSubInfo;
                $("#validateDetailUnionDemoSubInfoForm #demoIdc2").val(objInfo.demoIdc!=null?objInfo.demoIdc:'');
                $("#validateDetailUnionDemoSubInfoForm #forgienId2").val(objInfo.forgienId!=null?objInfo.forgienId:'');
                $("#validateDetailUnionDemoSubInfoForm #demoNmc2").val(objInfo.demoNmc!=null?objInfo.demoNmc:'');
                $("#validateDetailUnionDemoSubInfoForm #createTimec2").val(objInfo.createTimec!=null?objInfo.createTimec:'');
                $("#validateDetailUnionDemoSubInfoForm #countNumberc2").val(objInfo.countNumberc!=null?objInfo.countNumberc:'');
                $("#validateDetailUnionDemoSubInfoForm #demoMoneyc2").val(objInfo.demoMoneyc!=null?objInfo.demoMoneyc:'');
                $("#validateDetailUnionDemoSubInfoForm #selectStaticc2").val(objInfo.selectStaticc_name!=null?objInfo.selectStaticc_name:'');
                $("#validateDetailUnionDemoSubInfoForm #selectDynamicc2").val(objInfo.selectDynamicc_name!=null?objInfo.selectDynamicc_name:'');
                $("#validateDetailUnionDemoSubInfoForm #radioStaticc2").val(objInfo.radioStaticc_name!=null?objInfo.radioStaticc_name:'');
                $("#validateDetailUnionDemoSubInfoForm #radioDynamicc2").val(objInfo.radioDynamicc_name!=null?objInfo.radioDynamicc_name:'');
                setCheckBoxVal("validateDetailUnionDemoSubInfoForm","checkboxStaticc2",(objInfo.checkboxStaticc!=null?objInfo.checkboxStaticc:''));
                setCheckBoxVal("validateDetailUnionDemoSubInfoForm","checkboxDynamicc2",(objInfo.checkboxDynamicc!=null?objInfo.checkboxDynamicc:''));
                $("#validateDetailUnionDemoSubInfoForm #createDatec2").val(objInfo.createDatec!=null?objInfo.createDatec:'');
            }else{
                layer.alert(data.message);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
            }
        }
    });
}
function delUnionDemoSubInfo(id_key){
    layer.confirm('是否删除？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        var url=webUrl+"/unionDemoSubInfo/del.dhtml";
        var params={};
        var currentPage= $("#queryUnionDemoSubInfocurrentPage").val();
        params.id_key = id_key;;
        var jsonStr = JSON.stringify(params);
        jsonStr = encodeURIComponent(jsonStr);
        $.ajax({
            type:"POST",
            url:url,
            timeout:60000,
            dataType:'json',
            data:"jsonStr="+jsonStr,
            success:function(data){
                if(data.code == "success"){
                    layer.msg('删除成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                    searchUnionDemoSubInfo(currentPage);
                }else{
                    layer.alert(data.message);
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                layer.alert('系统异常，请稍后重试！');
            },
            complete : function(XMLHttpRequest,status){
                if(status == "timeout"){
                    ajaxTimeoutTest.abort();
                    alert("操作超时！");
                }
            }
        });
    });
}



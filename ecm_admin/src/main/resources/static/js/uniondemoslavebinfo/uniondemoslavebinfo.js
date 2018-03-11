$(function(){
    searchUnionDemoSlavebInfo('');
    $('#queryUnionDemoSlavebInfopageSize').on('change',function () {
        var currentPage = $("#queryUnionDemoSlavebInfocurrentPage").val();
        searchUnionDemoSlavebInfo(currentPage);
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
    $('#updateUnionDemoSlavebInfo').on('shown.bs.modal', function () {
        $('#validateUpdateUnionDemoSlavebInfoForm').bootstrapValidator('resetForm', false);
    });
    $("#queryUnionDemoSlavebInfoForm #createTimeb").ECalendar({
        type:"time",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd hh:ii:ss",
        skin:1,
        step:1,
        callback:function(v,e){revalidateDate("queryUnionDemoSlavebInfoForm","createTimeb");} //回调函数
    });
    $("#validateAddUnionDemoSlavebInfoForm #createTimeb1").ECalendar({
        type:"time",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd hh:ii:ss",
        skin:1,
        step:1,
        callback:function(v,e){revalidateDate("validateAddUnionDemoSlavebInfoForm","createTimeb1");} //回调函数
    });
    $("#validateUpdateUnionDemoSlavebInfoForm #createTimeb3").ECalendar({
        type:"time",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd hh:ii:ss",
        skin:1,
        step:1,
        callback:function(v,e){revalidateDate("validateUpdateUnionDemoSlavebInfoForm","createTimeb3");} //回调函数
    });
    $('#queryUnionDemoSlavebInfoForm #createDateb').dateRangePicker({
        startOfWeek: 'monday',
        separator : ' 至 ',
        format: 'YYYY-MM-DD',
        autoClose: false
    });
    $("#validateAddUnionDemoSlavebInfoForm #createDateb1").ECalendar({
        type:"date",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd",
        skin:1,
        callback:function(v,e){revalidateDate("validateAddUnionDemoSlavebInfoForm","createDateb1");} //回调函数
    });
    $("#validateUpdateUnionDemoSlavebInfoForm #createDateb3").ECalendar({
        type:"date",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd",
        skin:1,
        callback:function(v,e){revalidateDate("validateUpdateUnionDemoSlavebInfoForm","createDateb3");} //回调函数
    });

    //增加联表查询DEMO-从表b校验
    $('#validateAddUnionDemoSlavebInfoForm').bootstrapValidator({
        fields : {
            demoNmb1 : {
                validators : {"stringLength":{"message":"演示名称长度不正确","min":1,"max":100},"notEmpty":{"message":"演示名称不能为空"},"regexp":{"message":"演示名称只能是中文、英文、数字与下划线","regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$"}}
            }
            ,
            createTimeb1 : {
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
            demoMoneyb1 : {
                validators : {"stringLength":{"message":"演示金额长度不正确","min":1,"max":100},"notEmpty":{"message":"演示金额不能为空"},"regexp":{"message":"演示金额格式不符","regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$"}}
            }
            ,
            selectStaticb1 : {
                validators : {"notEmpty":{"message":"请选择一个静态选择框"}}
            }
            ,
            selectDynamicb1 : {
                validators : {"notEmpty":{"message":"请选择一个动态选择框"}}
            }
            ,
            radioStaticb1 : {
                validators : {"notEmpty":{"message":"请选择一个静态单选按钮"}}
            }
            ,
            radioDynamicb1 : {
                validators : {"notEmpty":{"message":"请选择一个动态单选按钮"}}
            }
            ,
            createDateb1 : {
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
         addUnionDemoSlavebInfo();
     });

    //修改联表查询DEMO-从表b校验
    $('#validateUpdateUnionDemoSlavebInfoForm').bootstrapValidator({
        fields : {
            demoNmb3 : {
                validators : {"stringLength":{"message":"演示名称长度不正确","min":1,"max":100},"notEmpty":{"message":"演示名称不能为空"},"regexp":{"message":"演示名称只能是中文、英文、数字与下划线","regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$"}}
            }
            ,
            createTimeb3 : {
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
            demoMoneyb3 : {
                validators : {"stringLength":{"message":"演示金额长度不正确","min":1,"max":100},"notEmpty":{"message":"演示金额不能为空"},"regexp":{"message":"演示金额格式不符","regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$"}}
            }
            ,
            selectStaticb3 : {
                validators : {"notEmpty":{"message":"请选择一个静态选择框"}}
            }
            ,
            selectDynamicb3 : {
                validators : {"notEmpty":{"message":"请选择一个动态选择框"}}
            }
            ,
            radioStaticb3 : {
                validators : {"notEmpty":{"message":"请选择一个静态单选按钮"}}
            }
            ,
            radioDynamicb3 : {
                validators : {"notEmpty":{"message":"请选择一个动态单选按钮"}}
            }
            ,
            createDateb3 : {
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
         updateUnionDemoSlavebInfo();
     });
    //查询联表查询DEMO-从表b校验
    $('#queryUnionDemoSlavebInfoForm').bootstrapValidator({
        fields : {
            demoIdb : {
                validators : {"stringLength":{"message":"表ID长度不正确","min":1,"max":100},"regexp":{"message":"表ID与要求的格式不符","regexp":"^[0-9]*$"}}
            }
            ,
            forgienId : {
                validators : {"stringLength":{"message":"表ID长度不正确","min":1,"max":100},"regexp":{"message":"表ID与要求的格式不符","regexp":"^[0-9]*$"}}
            }
            ,
            demoNmb : {
                validators : {"stringLength":{"message":"演示名称长度不正确","min":1,"max":100},"regexp":{"message":"演示名称只能是中文、英文、数字与下划线","regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$"}}
            }
            ,
            createTimeb : {
                validators : {"stringLength":{"min":1,"max":100,"message":"XX信息长度不正确"},"regexp":{"regexp":"^.+$","message":"XX信息与要求的格式不符"}}
            }
            ,
            demoMoneyb : {
                validators : {"stringLength":{"message":"演示金额长度不正确","min":1,"max":100},"regexp":{"message":"演示金额格式不符","regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$"}}
            }
            ,
            selectStaticb : {
                validators : {}
            }
            ,
            selectDynamicb : {
                validators : {}
            }
            ,
            radioStaticb : {
                validators : {}
            }
            ,
            radioDynamicb : {
                validators : {}
            }
            ,
            createDateb : {
                validators : {"stringLength":{"min":1,"max":100,"message":"XX信息长度不正确"},"regexp":{"regexp":"^([0-9]{4}-[0-9]{2}-[0-9]{2})( )*至( )*([0-9]{4}-[0-9]{2}-[0-9]{2})$","message":"时间格式不正确"}}
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         console.log("查询校验通过");
     });

});

function searchUnionDemoSlavebInfo(currentPage,queryType,fileName,exportParam){
    //没有bootstrapvalidator，则返回
    if($('#queryUnionDemoSlavebInfoForm').data('bootstrapValidator')!=null) {
        //对查询框进行校验
        $('#queryUnionDemoSlavebInfoForm').data('bootstrapValidator').validate();
        //校验没有通过，则返回
        if(!$('#queryUnionDemoSlavebInfoForm').data('bootstrapValidator').isValid()){
            return;
        }
        //----个性化校验示例开始
        //if($('#query"+cleanentityClassName+"Form #被验证组件name').val()=='#'){
        //    layer.alert('XX禁止查询')
        //    //第三个参数为，显示的错误信息所属的validator规则
        //    $('#queryUnionDemoSlavebInfoForm').data('bootstrapValidator').updateStatus('被验证组件name','INVALID','stringLength');
        //    return;
        //}
        //----个性化校验示例结束
    }
    var params ={};
    if(currentPage == "undefined" || currentPage =="" || currentPage == null){
        var currentPage_text = $("#queryUnionDemoSlavebInfocurrentPage").val();
        if(currentPage_text =="undefined" || currentPage_text =="" || currentPage_text == null){
            currentPage_text = "1";
        }
        params.startIndex = currentPage_text;
    }else{
        params.startIndex = currentPage;
    }

    var pageSize= $("#queryUnionDemoSlavebInfopageSize").val();
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

    params.demoIdb = $("#queryUnionDemoSlavebInfoForm #demoIdb").val();
    params.forgienId = $("#queryUnionDemoSlavebInfoForm #forgienId").val();
    params.demoNmb = $("#queryUnionDemoSlavebInfoForm #demoNmb").val();
    params.createTimeb = $("#queryUnionDemoSlavebInfoForm #createTimeb").val();
    params.demoMoneyb = $("#queryUnionDemoSlavebInfoForm #demoMoneyb").val();
    params.selectStaticb = $("#queryUnionDemoSlavebInfoForm #selectStaticb").val();
    params.selectDynamicb = $("#queryUnionDemoSlavebInfoForm #selectDynamicb").val();
    params.radioStaticb = $("#queryUnionDemoSlavebInfoForm input[name='radioStaticb']:checked").val();
    params.radioDynamicb = $("#queryUnionDemoSlavebInfoForm input[name='radioDynamicb']:checked").val();
    //对于checkbox复选框，作为查询条件默认注释掉，否则将导致数据查询不出。如有需要，请根据需求放开
    //params.checkboxStaticb = getCheckBoxVal("queryUnionDemoSlavebInfoForm","checkboxStaticb");
    //对于checkbox复选框，作为查询条件默认注释掉，否则将导致数据查询不出。如有需要，请根据需求放开
    //params.checkboxDynamicb = getCheckBoxVal("queryUnionDemoSlavebInfoForm","checkboxDynamicb");
    var createDateb_regexp = new RegExp('^([0-9]{4}-[0-9]{2}-[0-9]{2})( )*至( )*([0-9]{4}-[0-9]{2}-[0-9]{2})$');
    var createDateb_value = $("#queryUnionDemoSlavebInfoForm #createDateb").val();
    if(createDateb_regexp.test(createDateb_value)){
        var cs = createDateb_regexp.exec(createDateb_value);
        params.createDateb_start = cs[1]||'';
        params.createDateb_end = cs[4]||'';
    }
    

    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    jsonStr = encodeURIComponent(jsonStr);
    if(queryType!=undefined && queryType =='download'){
        window.location.href=webUrl+"/unionDemoSlavebInfo/search.dhtml?jsonStr="+jsonStr+"&v="+Math.random();
        return;
    }
    
    $.ajax({
        type:"POST",
        url:webUrl+"/unionDemoSlavebInfo/search.dhtml",
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $("#unionDemoSlavebInfoTR_FIRST").siblings().remove();
                var  resultList=data.rows[0].pageRecords;

                //分页
                $("#queryUnionDemoSlavebInfocurrentPage").val(data.rows[0].startIndex);
                $("#queryUnionDemoSlavebInfototalPage").val(data.rows[0].totalPage);
                $("#queryUnionDemoSlavebInfopageSize").val(data.rows[0].pageSize);
                for(var i=0;i<resultList.length;i++){
                    var unionDemoSlavebInfoTr = $("<tr class=\"unionDemoSlavebInfoTr\"></tr>");
                    $("#unionDemoSlavebInfoTR_FIRST").parent().append(unionDemoSlavebInfoTr);
                    unionDemoSlavebInfoTr.append("<td><input style=\"width:23px;\" type=\"checkbox\"/></td><td>"+(i+1)+"</td>")
                    .append("<td>"+resultList[i].demoNmb+"</td>")
                    .append("<td>"+resultList[i].createTimeb+"</td>")
                    .append("<td>"+resultList[i].countNumberb+"</td>")
                    .append("<td>"+resultList[i].demoMoneyb+"</td>")
                    .append("<td>"+resultList[i].selectStaticb_name+"</td>")
                    .append("<td>"+resultList[i].selectDynamicb_name+"</td>")
                    .append("<td>"+resultList[i].radioStaticb_name+"</td>")
                    .append("<td>"+resultList[i].radioDynamicb_name+"</td>")
                    .append("<td>"+resultList[i].checkboxStaticb+"</td>")
                    .append("<td>"+resultList[i].checkboxDynamicb+"</td>")
                    .append("<td>"+resultList[i].createDateb+"</td>")
                    .append("<td class=\"operateTbl\"><button class=\"btn btn-default btn-sm\" onclick=\"return editUnionDemoSlavebInfo('"+resultList[i].demoIdb+"');\"><i class=\"fa fa-edit\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return  delUnionDemoSlavebInfo('"+resultList[i].demoIdb+"');\"><i class=\"fa fa-trash-o\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return queryUnionDemoSlavebInfoObject('"+resultList[i].demoIdb+"');\"><i class=\"fa fa-search\"></i></button></td>");
                }
                var currentPage = Number($("#queryUnionDemoSlavebInfocurrentPage").val());
                var totalPage   = Number($("#queryUnionDemoSlavebInfototalPage").val());
                var pageSize    = Number($("#queryUnionDemoSlavebInfopageSize").val());
                $("#queryUnionDemoSlavebInfo_fy .pager").ucPager({
                    currentPage : currentPage,
                    totalPage : totalPage,
                    pageSize : pageSize,
                    clickCallback: queryUnionDemoSlavebInfogopage
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

function queryUnionDemoSlavebInfogopage(currentPage) {
    searchUnionDemoSlavebInfo(currentPage);
}

function addUnionDemoSlavebInfo(){
    var url=webUrl+"/unionDemoSlavebInfo/insert.dhtml";
    var params={};
    params.demoNmb = $("#validateAddUnionDemoSlavebInfoForm #demoNmb1").val();
    params.createTimeb = $("#validateAddUnionDemoSlavebInfoForm #createTimeb1").val();
    params.demoMoneyb = $("#validateAddUnionDemoSlavebInfoForm #demoMoneyb1").val();
    params.selectStaticb = $("#validateAddUnionDemoSlavebInfoForm #selectStaticb1").val();
    params.selectDynamicb = $("#validateAddUnionDemoSlavebInfoForm #selectDynamicb1").val();
    params.radioStaticb = $("#validateAddUnionDemoSlavebInfoForm input[name='radioStaticb1']:checked").val();
    params.radioDynamicb = $("#validateAddUnionDemoSlavebInfoForm input[name='radioDynamicb1']:checked").val();
    params.checkboxStaticb = getCheckBoxVal("validateAddUnionDemoSlavebInfoForm","checkboxStaticb1");
    params.checkboxDynamicb = getCheckBoxVal("validateAddUnionDemoSlavebInfoForm","checkboxDynamicb1");
    params.createDateb = $("#validateAddUnionDemoSlavebInfoForm #createDateb1").val();
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
                $('#addUnionDemoSlavebInfo').modal('hide');
                searchUnionDemoSlavebInfo('');
                layer.msg('添加成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateAddUnionDemoSlavebInfoForm').bootstrapValidator('resetForm', true);
                setCheckBoxVal("validateAddUnionDemoSlavebInfoForm","checkboxStaticb1",'00000000000000000000000000000000');
                setCheckBoxVal("validateAddUnionDemoSlavebInfoForm","checkboxDynamicb1",'00000000000000000000000000000000');
            }else{
                layer.alert(data.message);
                $('#validateAddUnionDemoSlavebInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
                $('#validateAddUnionDemoSlavebInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateAddUnionDemoSlavebInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function updateUnionDemoSlavebInfo(){
    var url=webUrl+"/unionDemoSlavebInfo/edit.dhtml";
    var params={};
    params.id_key = $("#validateUpdateUnionDemoSlavebInfoForm #id_key").val();
    params.demoNmb = $("#validateUpdateUnionDemoSlavebInfoForm #demoNmb3").val();
    params.createTimeb = $("#validateUpdateUnionDemoSlavebInfoForm #createTimeb3").val();
    params.demoMoneyb = $("#validateUpdateUnionDemoSlavebInfoForm #demoMoneyb3").val();
    params.selectStaticb = $("#validateUpdateUnionDemoSlavebInfoForm #selectStaticb3").val();
    params.selectDynamicb = $("#validateUpdateUnionDemoSlavebInfoForm #selectDynamicb3").val();
    params.radioStaticb = $("#validateUpdateUnionDemoSlavebInfoForm input[name='radioStaticb3']:checked").val();
    params.radioDynamicb = $("#validateUpdateUnionDemoSlavebInfoForm input[name='radioDynamicb3']:checked").val();
    params.checkboxStaticb = getCheckBoxVal("validateUpdateUnionDemoSlavebInfoForm","checkboxStaticb3");
    params.checkboxDynamicb = getCheckBoxVal("validateUpdateUnionDemoSlavebInfoForm","checkboxDynamicb3");
    params.createDateb = $("#validateUpdateUnionDemoSlavebInfoForm #createDateb3").val();
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
                $('#updateUnionDemoSlavebInfo').modal('hide');
                searchUnionDemoSlavebInfo('');
                layer.msg('修改成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateUpdateUnionDemoSlavebInfoForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateUpdateUnionDemoSlavebInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
            $('#validateUpdateUnionDemoSlavebInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateUpdateUnionDemoSlavebInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function editUnionDemoSlavebInfo(id_key){
    var url=webUrl+"/unionDemoSlavebInfo/queryObject.dhtml";
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
                $('#updateUnionDemoSlavebInfo').modal();
                $("#validateUpdateUnionDemoSlavebInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblUnionDemoSlavebInfo;
                $("#validateUpdateUnionDemoSlavebInfoForm #demoIdb3").val(objInfo.demoIdb!=null?objInfo.demoIdb:'');
                $("#validateUpdateUnionDemoSlavebInfoForm #forgienId3").val(objInfo.forgienId!=null?objInfo.forgienId:'');
                $("#validateUpdateUnionDemoSlavebInfoForm #demoNmb3").val(objInfo.demoNmb!=null?objInfo.demoNmb:'');
                $("#validateUpdateUnionDemoSlavebInfoForm #createTimeb3").val(objInfo.createTimeb!=null?objInfo.createTimeb:'');
                $("#validateUpdateUnionDemoSlavebInfoForm #countNumberb3").val(objInfo.countNumberb!=null?objInfo.countNumberb:'');
                $("#validateUpdateUnionDemoSlavebInfoForm #demoMoneyb3").val(objInfo.demoMoneyb!=null?objInfo.demoMoneyb:'');
                $("#validateUpdateUnionDemoSlavebInfoForm #selectStaticb3").val(objInfo.selectStaticb!=null?objInfo.selectStaticb:'');
                $("#validateUpdateUnionDemoSlavebInfoForm #selectDynamicb3").val(objInfo.selectDynamicb!=null?objInfo.selectDynamicb:'');
                //使用原生javascript对radio进行操作，避免浏览器不兼容问题
                $("#validateUpdateUnionDemoSlavebInfoForm input[name='radioStaticb3'][value='"+(objInfo.radioStaticb!=null?objInfo.radioStaticb:'')+"']")[0].checked=true;
                //使用原生javascript对radio进行操作，避免浏览器不兼容问题
                $("#validateUpdateUnionDemoSlavebInfoForm input[name='radioDynamicb3'][value='"+(objInfo.radioDynamicb!=null?objInfo.radioDynamicb:'')+"']")[0].checked=true;
                setCheckBoxVal("validateUpdateUnionDemoSlavebInfoForm","checkboxStaticb3",(objInfo.checkboxStaticb!=null?objInfo.checkboxStaticb:''));
                setCheckBoxVal("validateUpdateUnionDemoSlavebInfoForm","checkboxDynamicb3",(objInfo.checkboxDynamicb!=null?objInfo.checkboxDynamicb:''));
                $("#validateUpdateUnionDemoSlavebInfoForm #createDateb3").val(objInfo.createDateb!=null?objInfo.createDateb:'');
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

function queryUnionDemoSlavebInfoObject(id_key){
    var url=webUrl+"/unionDemoSlavebInfo/queryObject.dhtml";
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
                $('#detailUnionDemoSlavebInfo').modal();
                $("#validateDetailUnionDemoSlavebInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblUnionDemoSlavebInfo;
                $("#validateDetailUnionDemoSlavebInfoForm #demoIdb2").val(objInfo.demoIdb!=null?objInfo.demoIdb:'');
                $("#validateDetailUnionDemoSlavebInfoForm #forgienId2").val(objInfo.forgienId!=null?objInfo.forgienId:'');
                $("#validateDetailUnionDemoSlavebInfoForm #demoNmb2").val(objInfo.demoNmb!=null?objInfo.demoNmb:'');
                $("#validateDetailUnionDemoSlavebInfoForm #createTimeb2").val(objInfo.createTimeb!=null?objInfo.createTimeb:'');
                $("#validateDetailUnionDemoSlavebInfoForm #countNumberb2").val(objInfo.countNumberb!=null?objInfo.countNumberb:'');
                $("#validateDetailUnionDemoSlavebInfoForm #demoMoneyb2").val(objInfo.demoMoneyb!=null?objInfo.demoMoneyb:'');
                $("#validateDetailUnionDemoSlavebInfoForm #selectStaticb2").val(objInfo.selectStaticb_name!=null?objInfo.selectStaticb_name:'');
                $("#validateDetailUnionDemoSlavebInfoForm #selectDynamicb2").val(objInfo.selectDynamicb_name!=null?objInfo.selectDynamicb_name:'');
                $("#validateDetailUnionDemoSlavebInfoForm #radioStaticb2").val(objInfo.radioStaticb_name!=null?objInfo.radioStaticb_name:'');
                $("#validateDetailUnionDemoSlavebInfoForm #radioDynamicb2").val(objInfo.radioDynamicb_name!=null?objInfo.radioDynamicb_name:'');
                setCheckBoxVal("validateDetailUnionDemoSlavebInfoForm","checkboxStaticb2",(objInfo.checkboxStaticb!=null?objInfo.checkboxStaticb:''));
                setCheckBoxVal("validateDetailUnionDemoSlavebInfoForm","checkboxDynamicb2",(objInfo.checkboxDynamicb!=null?objInfo.checkboxDynamicb:''));
                $("#validateDetailUnionDemoSlavebInfoForm #createDateb2").val(objInfo.createDateb!=null?objInfo.createDateb:'');
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
function delUnionDemoSlavebInfo(id_key){
    layer.confirm('是否删除？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        var url=webUrl+"/unionDemoSlavebInfo/del.dhtml";
        var params={};
        var currentPage= $("#queryUnionDemoSlavebInfocurrentPage").val();
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
                    searchUnionDemoSlavebInfo(currentPage);
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



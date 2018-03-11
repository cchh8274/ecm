$(function(){
    searchUnionDemoMainInfo('');
    $('#queryUnionDemoMainInfopageSize').on('change',function () {
        var currentPage = $("#queryUnionDemoMainInfocurrentPage").val();
        searchUnionDemoMainInfo(currentPage);
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
    $('#updateUnionDemoMainInfo').on('shown.bs.modal', function () {
        $('#validateUpdateUnionDemoMainInfoForm').bootstrapValidator('resetForm', false);
    });
    $("#queryUnionDemoMainInfoForm #createTime").ECalendar({
        type:"time",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd hh:ii:ss",
        skin:1,
        step:1,
        callback:function(v,e){revalidateDate("queryUnionDemoMainInfoForm","createTime");} //回调函数
    });
    $("#validateAddUnionDemoMainInfoForm #createTime1").ECalendar({
        type:"time",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd hh:ii:ss",
        skin:1,
        step:1,
        callback:function(v,e){revalidateDate("validateAddUnionDemoMainInfoForm","createTime1");} //回调函数
    });
    $("#validateUpdateUnionDemoMainInfoForm #createTime3").ECalendar({
        type:"time",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd hh:ii:ss",
        skin:1,
        step:1,
        callback:function(v,e){revalidateDate("validateUpdateUnionDemoMainInfoForm","createTime3");} //回调函数
    });
    $('#queryUnionDemoMainInfoForm #createDate').dateRangePicker({
        startOfWeek: 'monday',
        separator : ' 至 ',
        format: 'YYYY-MM-DD',
        autoClose: false
    });
    $("#validateAddUnionDemoMainInfoForm #createDate1").ECalendar({
        type:"date",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd",
        skin:1,
        callback:function(v,e){revalidateDate("validateAddUnionDemoMainInfoForm","createDate1");} //回调函数
    });
    $("#validateUpdateUnionDemoMainInfoForm #createDate3").ECalendar({
        type:"date",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd",
        skin:1,
        callback:function(v,e){revalidateDate("validateUpdateUnionDemoMainInfoForm","createDate3");} //回调函数
    });

    //增加联表查询DEMO-主表校验
    $('#validateAddUnionDemoMainInfoForm').bootstrapValidator({
        fields : {
            demoNm1 : {
                validators : {"stringLength":{"message":"演示名称长度不正确","min":1,"max":100},"notEmpty":{"message":"演示名称不能为空"},"regexp":{"message":"演示名称只能是中文、英文、数字与下划线","regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$"}}
            }
            ,
            createTime1 : {
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
            demoMoney1 : {
                validators : {"stringLength":{"message":"演示金额长度不正确","min":1,"max":100},"notEmpty":{"message":"演示金额不能为空"},"regexp":{"message":"演示金额格式不符","regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$"}}
            }
            ,
            selectStatic1 : {
                validators : {"notEmpty":{"message":"请选择一个静态选择框"}}
            }
            ,
            selectDynamic1 : {
                validators : {"notEmpty":{"message":"请选择一个动态选择框"}}
            }
            ,
            radioStatic1 : {
                validators : {"notEmpty":{"message":"请选择一个静态单选按钮"}}
            }
            ,
            radioDynamic1 : {
                validators : {"notEmpty":{"message":"请选择一个动态单选按钮"}}
            }
            ,
            createDate1 : {
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
         addUnionDemoMainInfo();
     });

    //修改联表查询DEMO-主表校验
    $('#validateUpdateUnionDemoMainInfoForm').bootstrapValidator({
        fields : {
            demoNm3 : {
                validators : {"stringLength":{"message":"演示名称长度不正确","min":1,"max":100},"notEmpty":{"message":"演示名称不能为空"},"regexp":{"message":"演示名称只能是中文、英文、数字与下划线","regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$"}}
            }
            ,
            createTime3 : {
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
            demoMoney3 : {
                validators : {"stringLength":{"message":"演示金额长度不正确","min":1,"max":100},"notEmpty":{"message":"演示金额不能为空"},"regexp":{"message":"演示金额格式不符","regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$"}}
            }
            ,
            selectStatic3 : {
                validators : {"notEmpty":{"message":"请选择一个静态选择框"}}
            }
            ,
            selectDynamic3 : {
                validators : {"notEmpty":{"message":"请选择一个动态选择框"}}
            }
            ,
            radioStatic3 : {
                validators : {"notEmpty":{"message":"请选择一个静态单选按钮"}}
            }
            ,
            radioDynamic3 : {
                validators : {"notEmpty":{"message":"请选择一个动态单选按钮"}}
            }
            ,
            createDate3 : {
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
         updateUnionDemoMainInfo();
     });
    //查询联表查询DEMO-主表校验
    $('#queryUnionDemoMainInfoForm').bootstrapValidator({
        fields : {
            demoId : {
                validators : {"stringLength":{"message":"表ID长度不正确","min":1,"max":100},"regexp":{"message":"表ID与要求的格式不符","regexp":"^[0-9]*$"}}
            }
            ,
            forgienId : {
                validators : {"stringLength":{"message":"表ID长度不正确","min":1,"max":100},"regexp":{"message":"表ID与要求的格式不符","regexp":"^[0-9]*$"}}
            }
            ,
            demoNm : {
                validators : {"stringLength":{"message":"演示名称长度不正确","min":1,"max":100},"regexp":{"message":"演示名称只能是中文、英文、数字与下划线","regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$"}}
            }
            ,
            createTime : {
                validators : {"stringLength":{"min":1,"max":100,"message":"XX信息长度不正确"},"regexp":{"regexp":"^.+$","message":"XX信息与要求的格式不符"}}
            }
            ,
            demoMoney : {
                validators : {"stringLength":{"message":"演示金额长度不正确","min":1,"max":100},"regexp":{"message":"演示金额格式不符","regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$"}}
            }
            ,
            selectStatic : {
                validators : {}
            }
            ,
            selectDynamic : {
                validators : {}
            }
            ,
            radioStatic : {
                validators : {}
            }
            ,
            radioDynamic : {
                validators : {}
            }
            ,
            createDate : {
                validators : {"stringLength":{"min":1,"max":100,"message":"XX信息长度不正确"},"regexp":{"regexp":"^([0-9]{4}-[0-9]{2}-[0-9]{2})( )*至( )*([0-9]{4}-[0-9]{2}-[0-9]{2})$","message":"时间格式不正确"}}
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         console.log("查询校验通过");
     });

});

function searchUnionDemoMainInfo(currentPage,queryType,fileName,exportParam){
    //没有bootstrapvalidator，则返回
    if($('#queryUnionDemoMainInfoForm').data('bootstrapValidator')!=null) {
        //对查询框进行校验
        $('#queryUnionDemoMainInfoForm').data('bootstrapValidator').validate();
        //校验没有通过，则返回
        if(!$('#queryUnionDemoMainInfoForm').data('bootstrapValidator').isValid()){
            return;
        }
        //----个性化校验示例开始
        //if($('#query"+cleanentityClassName+"Form #被验证组件name').val()=='#'){
        //    layer.alert('XX禁止查询')
        //    //第三个参数为，显示的错误信息所属的validator规则
        //    $('#queryUnionDemoMainInfoForm').data('bootstrapValidator').updateStatus('被验证组件name','INVALID','stringLength');
        //    return;
        //}
        //----个性化校验示例结束
    }
    var params ={};
    if(currentPage == "undefined" || currentPage =="" || currentPage == null){
        var currentPage_text = $("#queryUnionDemoMainInfocurrentPage").val();
        if(currentPage_text =="undefined" || currentPage_text =="" || currentPage_text == null){
            currentPage_text = "1";
        }
        params.startIndex = currentPage_text;
    }else{
        params.startIndex = currentPage;
    }

    var pageSize= $("#queryUnionDemoMainInfopageSize").val();
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

    params.demoId = $("#queryUnionDemoMainInfoForm #demoId").val();
    params.forgienId = $("#queryUnionDemoMainInfoForm #forgienId").val();
    params.demoNm = $("#queryUnionDemoMainInfoForm #demoNm").val();
    params.createTime = $("#queryUnionDemoMainInfoForm #createTime").val();
    params.demoMoney = $("#queryUnionDemoMainInfoForm #demoMoney").val();
    params.selectStatic = $("#queryUnionDemoMainInfoForm #selectStatic").val();
    params.selectDynamic = $("#queryUnionDemoMainInfoForm #selectDynamic").val();
    params.radioStatic = $("#queryUnionDemoMainInfoForm input[name='radioStatic']:checked").val();
    params.radioDynamic = $("#queryUnionDemoMainInfoForm input[name='radioDynamic']:checked").val();
    //对于checkbox复选框，作为查询条件默认注释掉，否则将导致数据查询不出。如有需要，请根据需求放开
    //params.checkboxStatic = getCheckBoxVal("queryUnionDemoMainInfoForm","checkboxStatic");
    //对于checkbox复选框，作为查询条件默认注释掉，否则将导致数据查询不出。如有需要，请根据需求放开
    //params.checkboxDynamic = getCheckBoxVal("queryUnionDemoMainInfoForm","checkboxDynamic");
    var createDate_regexp = new RegExp('^([0-9]{4}-[0-9]{2}-[0-9]{2})( )*至( )*([0-9]{4}-[0-9]{2}-[0-9]{2})$');
    var createDate_value = $("#queryUnionDemoMainInfoForm #createDate").val();
    if(createDate_regexp.test(createDate_value)){
        var cs = createDate_regexp.exec(createDate_value);
        params.createDate_start = cs[1]||'';
        params.createDate_end = cs[4]||'';
    }
    

    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    jsonStr = encodeURIComponent(jsonStr);
    if(queryType!=undefined && queryType =='download'){
        window.location.href=webUrl+"/unionDemoMainInfo/search.dhtml?jsonStr="+jsonStr+"&v="+Math.random();
        return;
    }
    
    $.ajax({
        type:"POST",
        url:webUrl+"/unionDemoMainInfo/search.dhtml",
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $("#unionDemoMainInfoTR_FIRST").siblings().remove();
                var  resultList=data.rows[0].pageRecords;

                //分页
                $("#queryUnionDemoMainInfocurrentPage").val(data.rows[0].startIndex);
                $("#queryUnionDemoMainInfototalPage").val(data.rows[0].totalPage);
                $("#queryUnionDemoMainInfopageSize").val(data.rows[0].pageSize);
                for(var i=0;i<resultList.length;i++){
                    var unionDemoMainInfoTr = $("<tr class=\"unionDemoMainInfoTr\"></tr>");
                    $("#unionDemoMainInfoTR_FIRST").parent().append(unionDemoMainInfoTr);
                    unionDemoMainInfoTr.append("<td><input style=\"width:23px;\" type=\"checkbox\"/></td><td>"+(i+1)+"</td>")
                    .append("<td>"+resultList[i].demoNm+"</td>")
                    .append("<td>"+resultList[i].createTime+"</td>")
                    .append("<td>"+resultList[i].countNumber+"</td>")
                    .append("<td>"+resultList[i].demoMoney+"</td>")
                    .append("<td>"+resultList[i].selectStatic_name+"</td>")
                    .append("<td>"+resultList[i].selectDynamic_name+"</td>")
                    .append("<td>"+resultList[i].radioStatic_name+"</td>")
                    .append("<td>"+resultList[i].radioDynamic_name+"</td>")
                    .append("<td>"+resultList[i].checkboxStatic+"</td>")
                    .append("<td>"+resultList[i].checkboxDynamic+"</td>")
                    .append("<td>"+resultList[i].createDate+"</td>")
                    .append("<td class=\"operateTbl\"><button class=\"btn btn-default btn-sm\" onclick=\"return editUnionDemoMainInfo('"+resultList[i].demoId+"');\"><i class=\"fa fa-edit\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return  delUnionDemoMainInfo('"+resultList[i].demoId+"');\"><i class=\"fa fa-trash-o\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return queryUnionDemoMainInfoObject('"+resultList[i].demoId+"');\"><i class=\"fa fa-search\"></i></button></td>");
                }
                var currentPage = Number($("#queryUnionDemoMainInfocurrentPage").val());
                var totalPage   = Number($("#queryUnionDemoMainInfototalPage").val());
                var pageSize    = Number($("#queryUnionDemoMainInfopageSize").val());
                $("#queryUnionDemoMainInfo_fy .pager").ucPager({
                    currentPage : currentPage,
                    totalPage : totalPage,
                    pageSize : pageSize,
                    clickCallback: queryUnionDemoMainInfogopage
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

function queryUnionDemoMainInfogopage(currentPage) {
    searchUnionDemoMainInfo(currentPage);
}

function addUnionDemoMainInfo(){
    var url=webUrl+"/unionDemoMainInfo/insert.dhtml";
    var params={};
    params.demoNm = $("#validateAddUnionDemoMainInfoForm #demoNm1").val();
    params.createTime = $("#validateAddUnionDemoMainInfoForm #createTime1").val();
    params.demoMoney = $("#validateAddUnionDemoMainInfoForm #demoMoney1").val();
    params.selectStatic = $("#validateAddUnionDemoMainInfoForm #selectStatic1").val();
    params.selectDynamic = $("#validateAddUnionDemoMainInfoForm #selectDynamic1").val();
    params.radioStatic = $("#validateAddUnionDemoMainInfoForm input[name='radioStatic1']:checked").val();
    params.radioDynamic = $("#validateAddUnionDemoMainInfoForm input[name='radioDynamic1']:checked").val();
    params.checkboxStatic = getCheckBoxVal("validateAddUnionDemoMainInfoForm","checkboxStatic1");
    params.checkboxDynamic = getCheckBoxVal("validateAddUnionDemoMainInfoForm","checkboxDynamic1");
    params.createDate = $("#validateAddUnionDemoMainInfoForm #createDate1").val();
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
                $('#addUnionDemoMainInfo').modal('hide');
                searchUnionDemoMainInfo('');
                layer.msg('添加成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateAddUnionDemoMainInfoForm').bootstrapValidator('resetForm', true);
                setCheckBoxVal("validateAddUnionDemoMainInfoForm","checkboxStatic1",'00000000000000000000000000000000');
                setCheckBoxVal("validateAddUnionDemoMainInfoForm","checkboxDynamic1",'00000000000000000000000000000000');
            }else{
                layer.alert(data.message);
                $('#validateAddUnionDemoMainInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
                $('#validateAddUnionDemoMainInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateAddUnionDemoMainInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function updateUnionDemoMainInfo(){
    var url=webUrl+"/unionDemoMainInfo/edit.dhtml";
    var params={};
    params.id_key = $("#validateUpdateUnionDemoMainInfoForm #id_key").val();
    params.demoNm = $("#validateUpdateUnionDemoMainInfoForm #demoNm3").val();
    params.createTime = $("#validateUpdateUnionDemoMainInfoForm #createTime3").val();
    params.demoMoney = $("#validateUpdateUnionDemoMainInfoForm #demoMoney3").val();
    params.selectStatic = $("#validateUpdateUnionDemoMainInfoForm #selectStatic3").val();
    params.selectDynamic = $("#validateUpdateUnionDemoMainInfoForm #selectDynamic3").val();
    params.radioStatic = $("#validateUpdateUnionDemoMainInfoForm input[name='radioStatic3']:checked").val();
    params.radioDynamic = $("#validateUpdateUnionDemoMainInfoForm input[name='radioDynamic3']:checked").val();
    params.checkboxStatic = getCheckBoxVal("validateUpdateUnionDemoMainInfoForm","checkboxStatic3");
    params.checkboxDynamic = getCheckBoxVal("validateUpdateUnionDemoMainInfoForm","checkboxDynamic3");
    params.createDate = $("#validateUpdateUnionDemoMainInfoForm #createDate3").val();
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
                $('#updateUnionDemoMainInfo').modal('hide');
                searchUnionDemoMainInfo('');
                layer.msg('修改成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateUpdateUnionDemoMainInfoForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateUpdateUnionDemoMainInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
            $('#validateUpdateUnionDemoMainInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateUpdateUnionDemoMainInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function editUnionDemoMainInfo(id_key){
    var url=webUrl+"/unionDemoMainInfo/queryObject.dhtml";
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
                $('#updateUnionDemoMainInfo').modal();
                $("#validateUpdateUnionDemoMainInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblUnionDemoMainInfo;
                $("#validateUpdateUnionDemoMainInfoForm #demoId3").val(objInfo.demoId!=null?objInfo.demoId:'');
                $("#validateUpdateUnionDemoMainInfoForm #forgienId3").val(objInfo.forgienId!=null?objInfo.forgienId:'');
                $("#validateUpdateUnionDemoMainInfoForm #demoNm3").val(objInfo.demoNm!=null?objInfo.demoNm:'');
                $("#validateUpdateUnionDemoMainInfoForm #createTime3").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateUpdateUnionDemoMainInfoForm #countNumber3").val(objInfo.countNumber!=null?objInfo.countNumber:'');
                $("#validateUpdateUnionDemoMainInfoForm #demoMoney3").val(objInfo.demoMoney!=null?objInfo.demoMoney:'');
                $("#validateUpdateUnionDemoMainInfoForm #selectStatic3").val(objInfo.selectStatic!=null?objInfo.selectStatic:'');
                $("#validateUpdateUnionDemoMainInfoForm #selectDynamic3").val(objInfo.selectDynamic!=null?objInfo.selectDynamic:'');
                //使用原生javascript对radio进行操作，避免浏览器不兼容问题
                $("#validateUpdateUnionDemoMainInfoForm input[name='radioStatic3'][value='"+(objInfo.radioStatic!=null?objInfo.radioStatic:'')+"']")[0].checked=true;
                //使用原生javascript对radio进行操作，避免浏览器不兼容问题
                $("#validateUpdateUnionDemoMainInfoForm input[name='radioDynamic3'][value='"+(objInfo.radioDynamic!=null?objInfo.radioDynamic:'')+"']")[0].checked=true;
                setCheckBoxVal("validateUpdateUnionDemoMainInfoForm","checkboxStatic3",(objInfo.checkboxStatic!=null?objInfo.checkboxStatic:''));
                setCheckBoxVal("validateUpdateUnionDemoMainInfoForm","checkboxDynamic3",(objInfo.checkboxDynamic!=null?objInfo.checkboxDynamic:''));
                $("#validateUpdateUnionDemoMainInfoForm #createDate3").val(objInfo.createDate!=null?objInfo.createDate:'');
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

function queryUnionDemoMainInfoObject(id_key){
    var url=webUrl+"/unionDemoMainInfo/queryObject.dhtml";
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
                $('#detailUnionDemoMainInfo').modal();
                $("#validateDetailUnionDemoMainInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblUnionDemoMainInfo;
                $("#validateDetailUnionDemoMainInfoForm #demoId2").val(objInfo.demoId!=null?objInfo.demoId:'');
                $("#validateDetailUnionDemoMainInfoForm #forgienId2").val(objInfo.forgienId!=null?objInfo.forgienId:'');
                $("#validateDetailUnionDemoMainInfoForm #demoNm2").val(objInfo.demoNm!=null?objInfo.demoNm:'');
                $("#validateDetailUnionDemoMainInfoForm #createTime2").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateDetailUnionDemoMainInfoForm #countNumber2").val(objInfo.countNumber!=null?objInfo.countNumber:'');
                $("#validateDetailUnionDemoMainInfoForm #demoMoney2").val(objInfo.demoMoney!=null?objInfo.demoMoney:'');
                $("#validateDetailUnionDemoMainInfoForm #selectStatic2").val(objInfo.selectStatic_name!=null?objInfo.selectStatic_name:'');
                $("#validateDetailUnionDemoMainInfoForm #selectDynamic2").val(objInfo.selectDynamic_name!=null?objInfo.selectDynamic_name:'');
                $("#validateDetailUnionDemoMainInfoForm #radioStatic2").val(objInfo.radioStatic_name!=null?objInfo.radioStatic_name:'');
                $("#validateDetailUnionDemoMainInfoForm #radioDynamic2").val(objInfo.radioDynamic_name!=null?objInfo.radioDynamic_name:'');
                setCheckBoxVal("validateDetailUnionDemoMainInfoForm","checkboxStatic2",(objInfo.checkboxStatic!=null?objInfo.checkboxStatic:''));
                setCheckBoxVal("validateDetailUnionDemoMainInfoForm","checkboxDynamic2",(objInfo.checkboxDynamic!=null?objInfo.checkboxDynamic:''));
                $("#validateDetailUnionDemoMainInfoForm #createDate2").val(objInfo.createDate!=null?objInfo.createDate:'');
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
function delUnionDemoMainInfo(id_key){
    layer.confirm('是否删除？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        var url=webUrl+"/unionDemoMainInfo/del.dhtml";
        var params={};
        var currentPage= $("#queryUnionDemoMainInfocurrentPage").val();
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
                    searchUnionDemoMainInfo(currentPage);
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



$(function(){
    searchUnionDemoSlaveaInfo('');
    $('#queryUnionDemoSlaveaInfopageSize').on('change',function () {
        var currentPage = $("#queryUnionDemoSlaveaInfocurrentPage").val();
        searchUnionDemoSlaveaInfo(currentPage);
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
    $('#updateUnionDemoSlaveaInfo').on('shown.bs.modal', function () {
        $('#validateUpdateUnionDemoSlaveaInfoForm').bootstrapValidator('resetForm', false);
    });
    $("#queryUnionDemoSlaveaInfoForm #createTimea").ECalendar({
        type:"time",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd hh:ii:ss",
        skin:1,
        step:1,
        callback:function(v,e){revalidateDate("queryUnionDemoSlaveaInfoForm","createTimea");} //回调函数
    });
    $("#validateAddUnionDemoSlaveaInfoForm #createTimea1").ECalendar({
        type:"time",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd hh:ii:ss",
        skin:1,
        step:1,
        callback:function(v,e){revalidateDate("validateAddUnionDemoSlaveaInfoForm","createTimea1");} //回调函数
    });
    $("#validateUpdateUnionDemoSlaveaInfoForm #createTimea3").ECalendar({
        type:"time",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd hh:ii:ss",
        skin:1,
        step:1,
        callback:function(v,e){revalidateDate("validateUpdateUnionDemoSlaveaInfoForm","createTimea3");} //回调函数
    });
    $('#queryUnionDemoSlaveaInfoForm #createDatea').dateRangePicker({
        startOfWeek: 'monday',
        separator : ' 至 ',
        format: 'YYYY-MM-DD',
        autoClose: false
    });
    $("#validateAddUnionDemoSlaveaInfoForm #createDatea1").ECalendar({
        type:"date",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd",
        skin:1,
        callback:function(v,e){revalidateDate("validateAddUnionDemoSlaveaInfoForm","createDatea1");} //回调函数
    });
    $("#validateUpdateUnionDemoSlaveaInfoForm #createDatea3").ECalendar({
        type:"date",
        stamp : false,
        offset:[0,2],
        format:"yyyy-mm-dd",
        skin:1,
        callback:function(v,e){revalidateDate("validateUpdateUnionDemoSlaveaInfoForm","createDatea3");} //回调函数
    });

    //增加联表查询DEMO-从表a校验
    $('#validateAddUnionDemoSlaveaInfoForm').bootstrapValidator({
        fields : {
            demoNma1 : {
                validators : {"stringLength":{"message":"演示名称长度不正确","min":1,"max":100},"notEmpty":{"message":"演示名称不能为空"},"regexp":{"message":"演示名称只能是中文、英文、数字与下划线","regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$"}}
            }
            ,
            createTimea1 : {
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
            demoMoneya1 : {
                validators : {"stringLength":{"message":"演示金额长度不正确","min":1,"max":100},"notEmpty":{"message":"演示金额不能为空"},"regexp":{"message":"演示金额格式不符","regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$"}}
            }
            ,
            selectStatica1 : {
                validators : {"notEmpty":{"message":"请选择一个静态选择框"}}
            }
            ,
            selectDynamica1 : {
                validators : {"notEmpty":{"message":"请选择一个动态选择框"}}
            }
            ,
            radioStatica1 : {
                validators : {"notEmpty":{"message":"请选择一个静态单选按钮"}}
            }
            ,
            radioDynamica1 : {
                validators : {"notEmpty":{"message":"请选择一个动态单选按钮"}}
            }
            ,
            createDatea1 : {
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
         addUnionDemoSlaveaInfo();
     });

    //修改联表查询DEMO-从表a校验
    $('#validateUpdateUnionDemoSlaveaInfoForm').bootstrapValidator({
        fields : {
            demoNma3 : {
                validators : {"stringLength":{"message":"演示名称长度不正确","min":1,"max":100},"notEmpty":{"message":"演示名称不能为空"},"regexp":{"message":"演示名称只能是中文、英文、数字与下划线","regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$"}}
            }
            ,
            createTimea3 : {
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
            demoMoneya3 : {
                validators : {"stringLength":{"message":"演示金额长度不正确","min":1,"max":100},"notEmpty":{"message":"演示金额不能为空"},"regexp":{"message":"演示金额格式不符","regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$"}}
            }
            ,
            selectStatica3 : {
                validators : {"notEmpty":{"message":"请选择一个静态选择框"}}
            }
            ,
            selectDynamica3 : {
                validators : {"notEmpty":{"message":"请选择一个动态选择框"}}
            }
            ,
            radioStatica3 : {
                validators : {"notEmpty":{"message":"请选择一个静态单选按钮"}}
            }
            ,
            radioDynamica3 : {
                validators : {"notEmpty":{"message":"请选择一个动态单选按钮"}}
            }
            ,
            createDatea3 : {
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
         updateUnionDemoSlaveaInfo();
     });
    //查询联表查询DEMO-从表a校验
    $('#queryUnionDemoSlaveaInfoForm').bootstrapValidator({
        fields : {
            demoIda : {
                validators : {"stringLength":{"message":"表ID长度不正确","min":1,"max":100},"regexp":{"message":"表ID与要求的格式不符","regexp":"^[0-9]*$"}}
            }
            ,
            forgienId : {
                validators : {"stringLength":{"message":"表ID长度不正确","min":1,"max":100},"regexp":{"message":"表ID与要求的格式不符","regexp":"^[0-9]*$"}}
            }
            ,
            demoNma : {
                validators : {"stringLength":{"message":"演示名称长度不正确","min":1,"max":100},"regexp":{"message":"演示名称只能是中文、英文、数字与下划线","regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9_]+$"}}
            }
            ,
            createTimea : {
                validators : {"stringLength":{"min":1,"max":100,"message":"XX信息长度不正确"},"regexp":{"regexp":"^.+$","message":"XX信息与要求的格式不符"}}
            }
            ,
            demoMoneya : {
                validators : {"stringLength":{"message":"演示金额长度不正确","min":1,"max":100},"regexp":{"message":"演示金额格式不符","regexp":"^(([1-9][0-9]{0,9})|0)((.[0-9]{1,2})?)$"}}
            }
            ,
            selectStatica : {
                validators : {}
            }
            ,
            selectDynamica : {
                validators : {}
            }
            ,
            radioStatica : {
                validators : {}
            }
            ,
            radioDynamica : {
                validators : {}
            }
            ,
            createDatea : {
                validators : {"stringLength":{"min":1,"max":100,"message":"XX信息长度不正确"},"regexp":{"regexp":"^([0-9]{4}-[0-9]{2}-[0-9]{2})( )*至( )*([0-9]{4}-[0-9]{2}-[0-9]{2})$","message":"时间格式不正确"}}
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         console.log("查询校验通过");
     });

});

function searchUnionDemoSlaveaInfo(currentPage,queryType,fileName,exportParam){
    //没有bootstrapvalidator，则返回
    if($('#queryUnionDemoSlaveaInfoForm').data('bootstrapValidator')!=null) {
        //对查询框进行校验
        $('#queryUnionDemoSlaveaInfoForm').data('bootstrapValidator').validate();
        //校验没有通过，则返回
        if(!$('#queryUnionDemoSlaveaInfoForm').data('bootstrapValidator').isValid()){
            return;
        }
        //----个性化校验示例开始
        //if($('#query"+cleanentityClassName+"Form #被验证组件name').val()=='#'){
        //    layer.alert('XX禁止查询')
        //    //第三个参数为，显示的错误信息所属的validator规则
        //    $('#queryUnionDemoSlaveaInfoForm').data('bootstrapValidator').updateStatus('被验证组件name','INVALID','stringLength');
        //    return;
        //}
        //----个性化校验示例结束
    }
    var params ={};
    if(currentPage == "undefined" || currentPage =="" || currentPage == null){
        var currentPage_text = $("#queryUnionDemoSlaveaInfocurrentPage").val();
        if(currentPage_text =="undefined" || currentPage_text =="" || currentPage_text == null){
            currentPage_text = "1";
        }
        params.startIndex = currentPage_text;
    }else{
        params.startIndex = currentPage;
    }

    var pageSize= $("#queryUnionDemoSlaveaInfopageSize").val();
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

    params.demoIda = $("#queryUnionDemoSlaveaInfoForm #demoIda").val();
    params.forgienId = $("#queryUnionDemoSlaveaInfoForm #forgienId").val();
    params.demoNma = $("#queryUnionDemoSlaveaInfoForm #demoNma").val();
    params.createTimea = $("#queryUnionDemoSlaveaInfoForm #createTimea").val();
    params.demoMoneya = $("#queryUnionDemoSlaveaInfoForm #demoMoneya").val();
    params.selectStatica = $("#queryUnionDemoSlaveaInfoForm #selectStatica").val();
    params.selectDynamica = $("#queryUnionDemoSlaveaInfoForm #selectDynamica").val();
    params.radioStatica = $("#queryUnionDemoSlaveaInfoForm input[name='radioStatica']:checked").val();
    params.radioDynamica = $("#queryUnionDemoSlaveaInfoForm input[name='radioDynamica']:checked").val();
    //对于checkbox复选框，作为查询条件默认注释掉，否则将导致数据查询不出。如有需要，请根据需求放开
    //params.checkboxStatica = getCheckBoxVal("queryUnionDemoSlaveaInfoForm","checkboxStatica");
    //对于checkbox复选框，作为查询条件默认注释掉，否则将导致数据查询不出。如有需要，请根据需求放开
    //params.checkboxDynamica = getCheckBoxVal("queryUnionDemoSlaveaInfoForm","checkboxDynamica");
    var createDatea_regexp = new RegExp('^([0-9]{4}-[0-9]{2}-[0-9]{2})( )*至( )*([0-9]{4}-[0-9]{2}-[0-9]{2})$');
    var createDatea_value = $("#queryUnionDemoSlaveaInfoForm #createDatea").val();
    if(createDatea_regexp.test(createDatea_value)){
        var cs = createDatea_regexp.exec(createDatea_value);
        params.createDatea_start = cs[1]||'';
        params.createDatea_end = cs[4]||'';
    }
    

    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    jsonStr = encodeURIComponent(jsonStr);
    if(queryType!=undefined && queryType =='download'){
        window.location.href=webUrl+"/unionDemoSlaveaInfo/search.dhtml?jsonStr="+jsonStr+"&v="+Math.random();
        return;
    }
    
    $.ajax({
        type:"POST",
        url:webUrl+"/unionDemoSlaveaInfo/search.dhtml",
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $("#unionDemoSlaveaInfoTR_FIRST").siblings().remove();
                var  resultList=data.rows[0].pageRecords;

                //分页
                $("#queryUnionDemoSlaveaInfocurrentPage").val(data.rows[0].startIndex);
                $("#queryUnionDemoSlaveaInfototalPage").val(data.rows[0].totalPage);
                $("#queryUnionDemoSlaveaInfopageSize").val(data.rows[0].pageSize);
                for(var i=0;i<resultList.length;i++){
                    var unionDemoSlaveaInfoTr = $("<tr class=\"unionDemoSlaveaInfoTr\"></tr>");
                    $("#unionDemoSlaveaInfoTR_FIRST").parent().append(unionDemoSlaveaInfoTr);
                    unionDemoSlaveaInfoTr.append("<td><input style=\"width:23px;\" type=\"checkbox\"/></td><td>"+(i+1)+"</td>")
                    .append("<td>"+resultList[i].demoNma+"</td>")
                    .append("<td>"+resultList[i].createTimea+"</td>")
                    .append("<td>"+resultList[i].countNumbera+"</td>")
                    .append("<td>"+resultList[i].demoMoneya+"</td>")
                    .append("<td>"+resultList[i].selectStatica_name+"</td>")
                    .append("<td>"+resultList[i].selectDynamica_name+"</td>")
                    .append("<td>"+resultList[i].radioStatica_name+"</td>")
                    .append("<td>"+resultList[i].radioDynamica_name+"</td>")
                    .append("<td>"+resultList[i].checkboxStatica+"</td>")
                    .append("<td>"+resultList[i].checkboxDynamica+"</td>")
                    .append("<td>"+resultList[i].createDatea+"</td>")
                    .append("<td class=\"operateTbl\"><button class=\"btn btn-default btn-sm\" onclick=\"return editUnionDemoSlaveaInfo('"+resultList[i].demoIda+"');\"><i class=\"fa fa-edit\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return  delUnionDemoSlaveaInfo('"+resultList[i].demoIda+"');\"><i class=\"fa fa-trash-o\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return queryUnionDemoSlaveaInfoObject('"+resultList[i].demoIda+"');\"><i class=\"fa fa-search\"></i></button></td>");
                }
                var currentPage = Number($("#queryUnionDemoSlaveaInfocurrentPage").val());
                var totalPage   = Number($("#queryUnionDemoSlaveaInfototalPage").val());
                var pageSize    = Number($("#queryUnionDemoSlaveaInfopageSize").val());
                $("#queryUnionDemoSlaveaInfo_fy .pager").ucPager({
                    currentPage : currentPage,
                    totalPage : totalPage,
                    pageSize : pageSize,
                    clickCallback: queryUnionDemoSlaveaInfogopage
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

function queryUnionDemoSlaveaInfogopage(currentPage) {
    searchUnionDemoSlaveaInfo(currentPage);
}

function addUnionDemoSlaveaInfo(){
    var url=webUrl+"/unionDemoSlaveaInfo/insert.dhtml";
    var params={};
    params.demoNma = $("#validateAddUnionDemoSlaveaInfoForm #demoNma1").val();
    params.createTimea = $("#validateAddUnionDemoSlaveaInfoForm #createTimea1").val();
    params.demoMoneya = $("#validateAddUnionDemoSlaveaInfoForm #demoMoneya1").val();
    params.selectStatica = $("#validateAddUnionDemoSlaveaInfoForm #selectStatica1").val();
    params.selectDynamica = $("#validateAddUnionDemoSlaveaInfoForm #selectDynamica1").val();
    params.radioStatica = $("#validateAddUnionDemoSlaveaInfoForm input[name='radioStatica1']:checked").val();
    params.radioDynamica = $("#validateAddUnionDemoSlaveaInfoForm input[name='radioDynamica1']:checked").val();
    params.checkboxStatica = getCheckBoxVal("validateAddUnionDemoSlaveaInfoForm","checkboxStatica1");
    params.checkboxDynamica = getCheckBoxVal("validateAddUnionDemoSlaveaInfoForm","checkboxDynamica1");
    params.createDatea = $("#validateAddUnionDemoSlaveaInfoForm #createDatea1").val();
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
                $('#addUnionDemoSlaveaInfo').modal('hide');
                searchUnionDemoSlaveaInfo('');
                layer.msg('添加成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateAddUnionDemoSlaveaInfoForm').bootstrapValidator('resetForm', true);
                setCheckBoxVal("validateAddUnionDemoSlaveaInfoForm","checkboxStatica1",'00000000000000000000000000000000');
                setCheckBoxVal("validateAddUnionDemoSlaveaInfoForm","checkboxDynamica1",'00000000000000000000000000000000');
            }else{
                layer.alert(data.message);
                $('#validateAddUnionDemoSlaveaInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
                $('#validateAddUnionDemoSlaveaInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateAddUnionDemoSlaveaInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function updateUnionDemoSlaveaInfo(){
    var url=webUrl+"/unionDemoSlaveaInfo/edit.dhtml";
    var params={};
    params.id_key = $("#validateUpdateUnionDemoSlaveaInfoForm #id_key").val();
    params.demoNma = $("#validateUpdateUnionDemoSlaveaInfoForm #demoNma3").val();
    params.createTimea = $("#validateUpdateUnionDemoSlaveaInfoForm #createTimea3").val();
    params.demoMoneya = $("#validateUpdateUnionDemoSlaveaInfoForm #demoMoneya3").val();
    params.selectStatica = $("#validateUpdateUnionDemoSlaveaInfoForm #selectStatica3").val();
    params.selectDynamica = $("#validateUpdateUnionDemoSlaveaInfoForm #selectDynamica3").val();
    params.radioStatica = $("#validateUpdateUnionDemoSlaveaInfoForm input[name='radioStatica3']:checked").val();
    params.radioDynamica = $("#validateUpdateUnionDemoSlaveaInfoForm input[name='radioDynamica3']:checked").val();
    params.checkboxStatica = getCheckBoxVal("validateUpdateUnionDemoSlaveaInfoForm","checkboxStatica3");
    params.checkboxDynamica = getCheckBoxVal("validateUpdateUnionDemoSlaveaInfoForm","checkboxDynamica3");
    params.createDatea = $("#validateUpdateUnionDemoSlaveaInfoForm #createDatea3").val();
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
                $('#updateUnionDemoSlaveaInfo').modal('hide');
                searchUnionDemoSlaveaInfo('');
                layer.msg('修改成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateUpdateUnionDemoSlaveaInfoForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateUpdateUnionDemoSlaveaInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
            $('#validateUpdateUnionDemoSlaveaInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateUpdateUnionDemoSlaveaInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function editUnionDemoSlaveaInfo(id_key){
    var url=webUrl+"/unionDemoSlaveaInfo/queryObject.dhtml";
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
                $('#updateUnionDemoSlaveaInfo').modal();
                $("#validateUpdateUnionDemoSlaveaInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblUnionDemoSlaveaInfo;
                $("#validateUpdateUnionDemoSlaveaInfoForm #demoIda3").val(objInfo.demoIda!=null?objInfo.demoIda:'');
                $("#validateUpdateUnionDemoSlaveaInfoForm #forgienId3").val(objInfo.forgienId!=null?objInfo.forgienId:'');
                $("#validateUpdateUnionDemoSlaveaInfoForm #demoNma3").val(objInfo.demoNma!=null?objInfo.demoNma:'');
                $("#validateUpdateUnionDemoSlaveaInfoForm #createTimea3").val(objInfo.createTimea!=null?objInfo.createTimea:'');
                $("#validateUpdateUnionDemoSlaveaInfoForm #countNumbera3").val(objInfo.countNumbera!=null?objInfo.countNumbera:'');
                $("#validateUpdateUnionDemoSlaveaInfoForm #demoMoneya3").val(objInfo.demoMoneya!=null?objInfo.demoMoneya:'');
                $("#validateUpdateUnionDemoSlaveaInfoForm #selectStatica3").val(objInfo.selectStatica!=null?objInfo.selectStatica:'');
                $("#validateUpdateUnionDemoSlaveaInfoForm #selectDynamica3").val(objInfo.selectDynamica!=null?objInfo.selectDynamica:'');
                //使用原生javascript对radio进行操作，避免浏览器不兼容问题
                $("#validateUpdateUnionDemoSlaveaInfoForm input[name='radioStatica3'][value='"+(objInfo.radioStatica!=null?objInfo.radioStatica:'')+"']")[0].checked=true;
                //使用原生javascript对radio进行操作，避免浏览器不兼容问题
                $("#validateUpdateUnionDemoSlaveaInfoForm input[name='radioDynamica3'][value='"+(objInfo.radioDynamica!=null?objInfo.radioDynamica:'')+"']")[0].checked=true;
                setCheckBoxVal("validateUpdateUnionDemoSlaveaInfoForm","checkboxStatica3",(objInfo.checkboxStatica!=null?objInfo.checkboxStatica:''));
                setCheckBoxVal("validateUpdateUnionDemoSlaveaInfoForm","checkboxDynamica3",(objInfo.checkboxDynamica!=null?objInfo.checkboxDynamica:''));
                $("#validateUpdateUnionDemoSlaveaInfoForm #createDatea3").val(objInfo.createDatea!=null?objInfo.createDatea:'');
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

function queryUnionDemoSlaveaInfoObject(id_key){
    var url=webUrl+"/unionDemoSlaveaInfo/queryObject.dhtml";
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
                $('#detailUnionDemoSlaveaInfo').modal();
                $("#validateDetailUnionDemoSlaveaInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblUnionDemoSlaveaInfo;
                $("#validateDetailUnionDemoSlaveaInfoForm #demoIda2").val(objInfo.demoIda!=null?objInfo.demoIda:'');
                $("#validateDetailUnionDemoSlaveaInfoForm #forgienId2").val(objInfo.forgienId!=null?objInfo.forgienId:'');
                $("#validateDetailUnionDemoSlaveaInfoForm #demoNma2").val(objInfo.demoNma!=null?objInfo.demoNma:'');
                $("#validateDetailUnionDemoSlaveaInfoForm #createTimea2").val(objInfo.createTimea!=null?objInfo.createTimea:'');
                $("#validateDetailUnionDemoSlaveaInfoForm #countNumbera2").val(objInfo.countNumbera!=null?objInfo.countNumbera:'');
                $("#validateDetailUnionDemoSlaveaInfoForm #demoMoneya2").val(objInfo.demoMoneya!=null?objInfo.demoMoneya:'');
                $("#validateDetailUnionDemoSlaveaInfoForm #selectStatica2").val(objInfo.selectStatica_name!=null?objInfo.selectStatica_name:'');
                $("#validateDetailUnionDemoSlaveaInfoForm #selectDynamica2").val(objInfo.selectDynamica_name!=null?objInfo.selectDynamica_name:'');
                $("#validateDetailUnionDemoSlaveaInfoForm #radioStatica2").val(objInfo.radioStatica_name!=null?objInfo.radioStatica_name:'');
                $("#validateDetailUnionDemoSlaveaInfoForm #radioDynamica2").val(objInfo.radioDynamica_name!=null?objInfo.radioDynamica_name:'');
                setCheckBoxVal("validateDetailUnionDemoSlaveaInfoForm","checkboxStatica2",(objInfo.checkboxStatica!=null?objInfo.checkboxStatica:''));
                setCheckBoxVal("validateDetailUnionDemoSlaveaInfoForm","checkboxDynamica2",(objInfo.checkboxDynamica!=null?objInfo.checkboxDynamica:''));
                $("#validateDetailUnionDemoSlaveaInfoForm #createDatea2").val(objInfo.createDatea!=null?objInfo.createDatea:'');
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
function delUnionDemoSlaveaInfo(id_key){
    layer.confirm('是否删除？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        var url=webUrl+"/unionDemoSlaveaInfo/del.dhtml";
        var params={};
        var currentPage= $("#queryUnionDemoSlaveaInfocurrentPage").val();
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
                    searchUnionDemoSlaveaInfo(currentPage);
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



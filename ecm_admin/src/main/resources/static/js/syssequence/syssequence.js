$(function(){
    searchSysSequence('');
    $('#querySysSequencepageSize').on('change',function () {
        var currentPage = $("#querySysSequencecurrentPage").val();
        searchSysSequence(currentPage);
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
    $('#updateSysSequence').on('shown.bs.modal', function () {
        $('#validateUpdateSysSequenceForm').bootstrapValidator('resetForm', false);
    });
    $('#querySysSequenceForm #createTime').dateRangePicker({
        startOfWeek: 'monday',
        separator : ' 至 ',
        format: 'YYYY-MM-DD HH:mm:ss',
        autoClose: false,
        time: {
            enabled: true
        }
    });
    $('#querySysSequenceForm #upTime').dateRangePicker({
        startOfWeek: 'monday',
        separator : ' 至 ',
        format: 'YYYY-MM-DD HH:mm:ss',
        autoClose: false,
        time: {
            enabled: true
        }
    });

    //增加系统ID表校验
    $('#validateAddSysSequenceForm').bootstrapValidator({
        fields : {
            keyValue1 : {
                validators : {"stringLength":{"message":"序列Key长度不正确","min":1,"max":32},"notEmpty":{"message":"序列Key不能为空"},"regexp":{"message":"序列Key只能是英文、数字、下划线","regexp":"^[A-Za-z0-9_]+$"}}
            }
            ,
            seqDesc1 : {
                validators : {"stringLength":{"message":"序列描述长度不正确","min":1,"max":20},"notEmpty":{"message":"序列描述不能为空"},"regexp":{"message":"序列描述只能是中文、英文与数字","regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9_]+$"}}
            }
            ,
            top1 : {
                validators : {"stringLength":{"message":"长度不正确","min":0,"max":32},"regexp":{"message":"前后缀只能是英文或数字","regexp":"^[A-Za-z0-9]*$"}}
            }
            ,
            suffix1 : {
                validators : {"stringLength":{"message":"长度不正确","min":0,"max":32},"regexp":{"message":"前后缀只能是英文或数字","regexp":"^[A-Za-z0-9]*$"}}
            }
            ,
            currValue1 : {
                validators : {"stringLength":{"message":"当前值长度不正确","min":1,"max":10},"notEmpty":{"message":"当前值必须填写"},"regexp":{"message":"当前值只能是正整数","regexp":"^[1-9]*[0-9]*$"}}
            }
            ,
            batchSize1 : {
                validators : {"stringLength":{"message":"递增数量长度不正确","min":1,"max":10},"notEmpty":{"message":"递增数量必须填写"},"regexp":{"message":"递增数量只能是正整数","regexp":"^[1-9]*[0-9]*$"}}
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         addSysSequence();
     });

    //修改系统ID表校验
    $('#validateUpdateSysSequenceForm').bootstrapValidator({
        fields : {
            seqDesc3 : {
                validators : {"stringLength":{"message":"序列描述长度不正确","min":1,"max":20},"notEmpty":{"message":"序列描述不能为空"},"regexp":{"message":"序列描述只能是中文、英文与数字","regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9_]+$"}}
            }
            ,
            top3 : {
                validators : {"stringLength":{"message":"长度不正确","min":0,"max":32},"regexp":{"message":"前后缀只能是英文或数字","regexp":"^[A-Za-z0-9]*$"}}
            }
            ,
            suffix3 : {
                validators : {"stringLength":{"message":"长度不正确","min":0,"max":32},"regexp":{"message":"前后缀只能是英文或数字","regexp":"^[A-Za-z0-9]*$"}}
            }
            ,
            currValue3 : {
                validators : {"stringLength":{"message":"当前值长度不正确","min":1,"max":10},"notEmpty":{"message":"当前值必须填写"},"regexp":{"message":"当前值只能是正整数","regexp":"^[1-9]*[0-9]*$"}}
            }
            ,
            batchSize3 : {
                validators : {"stringLength":{"message":"递增数量长度不正确","min":1,"max":10},"notEmpty":{"message":"递增数量必须填写"},"regexp":{"message":"递增数量只能是正整数","regexp":"^[1-9]*[0-9]*$"}}
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         updateSysSequence();
     });
    //查询系统ID表校验
    $('#querySysSequenceForm').bootstrapValidator({
        fields : {
            keyValue : {
                validators : {"stringLength":{"message":"序列Key长度不正确","min":1,"max":32},"regexp":{"message":"序列Key只能是英文、数字、下划线","regexp":"^[A-Za-z0-9_]+$"}}
            }
            ,
            seqDesc : {
                validators : {"stringLength":{"message":"序列描述长度不正确","min":1,"max":20},"regexp":{"message":"序列描述只能是中文、英文与数字","regexp":"^[\\u4E00-\\u9FA5A-Za-z0-9_]+$"}}
            }
            ,
            createTime : {
                validators : {"stringLength":{"min":1,"max":100,"message":"XX信息长度不正确"},"regexp":{"regexp":"^([0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2})( )*至( )*([0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2})$","message":"时间格式不正确"}}
            }
            ,
            upTime : {
                validators : {"stringLength":{"min":1,"max":100,"message":"XX信息长度不正确"},"regexp":{"regexp":"^([0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2})( )*至( )*([0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2})$","message":"时间格式不正确"}}
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         console.log("查询校验通过");
     });

});

function searchSysSequence(currentPage,queryType,fileName,exportParam){
    //没有bootstrapvalidator，则返回
    if($('#querySysSequenceForm').data('bootstrapValidator')!=null) {
        //对查询框进行校验
        $('#querySysSequenceForm').data('bootstrapValidator').validate();
        //校验没有通过，则返回
        if(!$('#querySysSequenceForm').data('bootstrapValidator').isValid()){
            return;
        }
        //----个性化校验示例开始
        //if($('#query"+cleanentityClassName+"Form #被验证组件name').val()=='#'){
        //    layer.alert('XX禁止查询')
        //    //第三个参数为，显示的错误信息所属的validator规则
        //    $('#querySysSequenceForm').data('bootstrapValidator').updateStatus('被验证组件name','INVALID','stringLength');
        //    return;
        //}
        //----个性化校验示例结束
    }
    var params ={};
    if(currentPage == "undefined" || currentPage =="" || currentPage == null){
        var currentPage_text = $("#querySysSequencecurrentPage").val();
        if(currentPage_text =="undefined" || currentPage_text =="" || currentPage_text == null){
            currentPage_text = "1";
        }
        params.startIndex = currentPage_text;
    }else{
        params.startIndex = currentPage;
    }

    var pageSize= $("#querySysSequencepageSize").val();
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

    params.keyValue = $("#querySysSequenceForm #keyValue").val();
    params.seqDesc = $("#querySysSequenceForm #seqDesc").val();
    var createTime_regexp = new RegExp('^([0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2})( )*至( )*([0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2})$');
    var createTime_value = $("#querySysSequenceForm #createTime").val();
    if(createTime_regexp.test(createTime_value)){
        var cs = createTime_regexp.exec(createTime_value);
        params.createTime_start = cs[1]||'';
        params.createTime_end = cs[4]||'';
    }
    
    var upTime_regexp = new RegExp('^([0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2})( )*至( )*([0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2})$');
    var upTime_value = $("#querySysSequenceForm #upTime").val();
    if(upTime_regexp.test(upTime_value)){
        var cs = upTime_regexp.exec(upTime_value);
        params.upTime_start = cs[1]||'';
        params.upTime_end = cs[4]||'';
    }
    

    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    jsonStr = encodeURIComponent(jsonStr);
    if(queryType!=undefined && queryType =='download'){
        window.location.href=webUrl+"/sysSequence/search.dhtml?jsonStr="+jsonStr+"&v="+Math.random();
        return;
    }
    
    $.ajax({
        type:"POST",
        url:webUrl+"/sysSequence/search.dhtml",
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $("#sysSequenceTR_FIRST").siblings().remove();
                var  resultList=data.rows[0].pageRecords;

                //分页
                $("#querySysSequencecurrentPage").val(data.rows[0].startIndex);
                $("#querySysSequencetotalPage").val(data.rows[0].totalPage);
                $("#querySysSequencepageSize").val(data.rows[0].pageSize);
                for(var i=0;i<resultList.length;i++){
                    var sysSequenceTr = $("<tr class=\"sysSequenceTr\"></tr>");
                    $("#sysSequenceTR_FIRST").parent().append(sysSequenceTr);
                    sysSequenceTr.append("<td><input style=\"width:23px;\" type=\"checkbox\"/></td><td>"+(i+1)+"</td>")
                    .append("<td>"+resultList[i].keyValue+"</td>")
                    .append("<td>"+resultList[i].seqDesc+"</td>")
                    .append("<td>"+resultList[i].top+"</td>")
                    .append("<td>"+resultList[i].suffix+"</td>")
                    .append("<td>"+resultList[i].currValue+"</td>")
                    .append("<td>"+resultList[i].batchSize+"</td>")
                    .append("<td>"+resultList[i].createTime+"</td>")
                    .append("<td>"+resultList[i].upTime+"</td>")
                    .append("<td class=\"operateTbl\"><button class=\"btn btn-default btn-sm\" onclick=\"return editSysSequence('"+resultList[i].id+"');\"><i class=\"fa fa-edit\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return  delSysSequence('"+resultList[i].id+"');\"><i class=\"fa fa-trash-o\"></i></button><button class=\"btn btn-default btn-sm\" onclick=\"return querySysSequenceObject('"+resultList[i].id+"');\"><i class=\"fa fa-search\"></i></button></td>");
                }
                var currentPage = Number($("#querySysSequencecurrentPage").val());
                var totalPage   = Number($("#querySysSequencetotalPage").val());
                var pageSize    = Number($("#querySysSequencepageSize").val());
                $("#querySysSequence_fy .pager").ucPager({
                    currentPage : currentPage,
                    totalPage : totalPage,
                    pageSize : pageSize,
                    clickCallback: querySysSequencegopage
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

function querySysSequencegopage(currentPage) {
    searchSysSequence(currentPage);
}

function addSysSequence(){
    var url=webUrl+"/sysSequence/insert.dhtml";
    var params={};
    params.keyValue = $("#validateAddSysSequenceForm #keyValue1").val();
    params.seqDesc = $("#validateAddSysSequenceForm #seqDesc1").val();
    params.top = $("#validateAddSysSequenceForm #top1").val();
    params.suffix = $("#validateAddSysSequenceForm #suffix1").val();
    params.currValue = $("#validateAddSysSequenceForm #currValue1").val();
    params.batchSize = $("#validateAddSysSequenceForm #batchSize1").val();
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
                $('#addSysSequence').modal('hide');
                searchSysSequence('');
                layer.msg('添加成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateAddSysSequenceForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateAddSysSequenceForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
                $('#validateAddSysSequenceForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateAddSysSequenceForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function updateSysSequence(){
    var url=webUrl+"/sysSequence/edit.dhtml";
    var params={};
    params.id_key = $("#validateUpdateSysSequenceForm #id_key").val();
    params.seqDesc = $("#validateUpdateSysSequenceForm #seqDesc3").val();
    params.top = $("#validateUpdateSysSequenceForm #top3").val();
    params.suffix = $("#validateUpdateSysSequenceForm #suffix3").val();
    params.currValue = $("#validateUpdateSysSequenceForm #currValue3").val();
    params.batchSize = $("#validateUpdateSysSequenceForm #batchSize3").val();
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
                $('#updateSysSequence').modal('hide');
                searchSysSequence('');
                layer.msg('修改成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateUpdateSysSequenceForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateUpdateSysSequenceForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
            $('#validateUpdateSysSequenceForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateUpdateSysSequenceForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function editSysSequence(id_key){
    var url=webUrl+"/sysSequence/queryObject.dhtml";
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
                $('#updateSysSequence').modal();
                $("#validateUpdateSysSequenceForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblSysSequence;
                $("#validateUpdateSysSequenceForm #id3").val(objInfo.id!=null?objInfo.id:'');
                $("#validateUpdateSysSequenceForm #keyValue3").val(objInfo.keyValue!=null?objInfo.keyValue:'');
                $("#validateUpdateSysSequenceForm #seqDesc3").val(objInfo.seqDesc!=null?objInfo.seqDesc:'');
                $("#validateUpdateSysSequenceForm #top3").val(objInfo.top!=null?objInfo.top:'');
                $("#validateUpdateSysSequenceForm #suffix3").val(objInfo.suffix!=null?objInfo.suffix:'');
                $("#validateUpdateSysSequenceForm #currValue3").val(objInfo.currValue!=null?objInfo.currValue:'');
                $("#validateUpdateSysSequenceForm #batchSize3").val(objInfo.batchSize!=null?objInfo.batchSize:'');
                $("#validateUpdateSysSequenceForm #createTime3").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateUpdateSysSequenceForm #upTime3").val(objInfo.upTime!=null?objInfo.upTime:'');
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

function querySysSequenceObject(id_key){
    var url=webUrl+"/sysSequence/queryObject.dhtml";
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
                $('#detailSysSequence').modal();
                $("#validateDetailSysSequenceForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblSysSequence;
                $("#validateDetailSysSequenceForm #id2").val(objInfo.id!=null?objInfo.id:'');
                $("#validateDetailSysSequenceForm #keyValue2").val(objInfo.keyValue!=null?objInfo.keyValue:'');
                $("#validateDetailSysSequenceForm #seqDesc2").val(objInfo.seqDesc!=null?objInfo.seqDesc:'');
                $("#validateDetailSysSequenceForm #top2").val(objInfo.top!=null?objInfo.top:'');
                $("#validateDetailSysSequenceForm #suffix2").val(objInfo.suffix!=null?objInfo.suffix:'');
                $("#validateDetailSysSequenceForm #currValue2").val(objInfo.currValue!=null?objInfo.currValue:'');
                $("#validateDetailSysSequenceForm #batchSize2").val(objInfo.batchSize!=null?objInfo.batchSize:'');
                $("#validateDetailSysSequenceForm #createTime2").val(objInfo.createTime!=null?objInfo.createTime:'');
                $("#validateDetailSysSequenceForm #upTime2").val(objInfo.upTime!=null?objInfo.upTime:'');
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
function delSysSequence(id_key){
    layer.confirm('是否删除？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        var url=webUrl+"/sysSequence/del.dhtml";
        var params={};
        var currentPage= $("#querySysSequencecurrentPage").val();
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
                    searchSysSequence(currentPage);
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



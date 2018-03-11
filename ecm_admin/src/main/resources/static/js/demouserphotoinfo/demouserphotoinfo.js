$(function(){
    searchDemoUserphotoInfo('');
    $('#queryDemoUserphotoInfopageSize').on('change',function () {
        var currentPage = $("#queryDemoUserphotoInfocurrentPage").val();
        searchDemoUserphotoInfo(currentPage);
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
    $('#updateDemoUserphotoInfo').on('shown.bs.modal', function () {
        $('#validateUpdateDemoUserphotoInfoForm').bootstrapValidator('resetForm', false);
    });

    //增加用户照片表校验
    $('#validateAddDemoUserphotoInfoForm').bootstrapValidator({
        fields : {
            id1 : {
                validators : {"stringLength":{"message":"长度不正确","min":0,"max":999},"notEmpty":{"message":"不可以为空"},"regexp":{"message":"不符合规则","regexp":"^[0-9]*$"}}
            }
            ,
            userNm1 : {
                validators : {"stringLength":{"message":"长度不正确","min":0,"max":999},"notEmpty":{"message":"不可以为空"},"regexp":{"message":"不符合规则","regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9]*$"}}
            }
            ,
            photo1 : {
                validators : {"notEmpty":{"message":"不可以为空"}}
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         addDemoUserphotoInfo();
     });

    //修改用户照片表校验
    $('#validateUpdateDemoUserphotoInfoForm').bootstrapValidator({
        fields : {
            id3 : {
                validators : {"stringLength":{"message":"长度不正确","min":0,"max":999},"notEmpty":{"message":"不可以为空"},"regexp":{"message":"不符合规则","regexp":"^[0-9]*$"}}
            }
            ,
            userNm3 : {
                validators : {"stringLength":{"message":"长度不正确","min":0,"max":999},"notEmpty":{"message":"不可以为空"},"regexp":{"message":"不符合规则","regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9]*$"}}
            }
            ,
            photo3 : {
                validators : {"notEmpty":{"message":"不可以为空"}}
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         updateDemoUserphotoInfo();
     });
    //查询用户照片表校验
    $('#queryDemoUserphotoInfoForm').bootstrapValidator({
        fields : {
            id : {
                validators : {"stringLength":{"message":"长度不正确","min":0,"max":999},"regexp":{"message":"不符合规则","regexp":"^[0-9]*$"}}
            }
            ,
            userNm : {
                validators : {"stringLength":{"message":"长度不正确","min":0,"max":999},"regexp":{"message":"不符合规则","regexp":"^[\\\\u4E00-\\\\u9FA5A-Za-z0-9]*$"}}
            }
            ,
            photo : {
                validators : {}
            }
        }
     }).on('success.form.bv', function(e) {
         e.preventDefault();
         console.log("查询校验通过");
     });

});

function searchDemoUserphotoInfo(currentPage,queryType,fileName,exportParam){
    //没有bootstrapvalidator，则返回
    if($('#queryDemoUserphotoInfoForm').data('bootstrapValidator')!=null) {
        //对查询框进行校验
        $('#queryDemoUserphotoInfoForm').data('bootstrapValidator').validate();
        //校验没有通过，则返回
        if(!$('#queryDemoUserphotoInfoForm').data('bootstrapValidator').isValid()){
            return;
        }
        //----个性化校验示例开始
        //if($('#query"+cleanentityClassName+"Form #被验证组件name').val()=='#'){
        //    layer.alert('XX禁止查询')
        //    //第三个参数为，显示的错误信息所属的validator规则
        //    $('#queryDemoUserphotoInfoForm').data('bootstrapValidator').updateStatus('被验证组件name','INVALID','stringLength');
        //    return;
        //}
        //----个性化校验示例结束
    }
    var params ={};
    if(currentPage == "undefined" || currentPage =="" || currentPage == null){
        var currentPage_text = $("#queryDemoUserphotoInfocurrentPage").val();
        if(currentPage_text =="undefined" || currentPage_text =="" || currentPage_text == null){
            currentPage_text = "1";
        }
        params.startIndex = currentPage_text;
    }else{
        params.startIndex = currentPage;
    }

    var pageSize= $("#queryDemoUserphotoInfopageSize").val();
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

    params.id = $("#queryDemoUserphotoInfoForm #id").val();
    params.userNm = $("#queryDemoUserphotoInfoForm #userNm").val();

    var jsonStr = JSON.stringify(params);
    jsonStr = encodeURIComponent(jsonStr);
    jsonStr = encodeURIComponent(jsonStr);
    if(queryType!=undefined && queryType =='download'){
        window.location.href=webUrl+"/demoUserphotoInfo/search.dhtml?jsonStr="+jsonStr+"&v="+Math.random();
        return;
    }
    
    $.ajax({
        type:"POST",
        url:webUrl+"/demoUserphotoInfo/search.dhtml",
        timeout:60000,
        dataType:'json',
        data:"jsonStr="+jsonStr,
        success:function(data){
            if(data.code == "success"){
                $("#demoUserphotoInfoTR_FIRST").siblings().remove();
                var  resultList=data.rows[0].pageRecords;

                //分页
                $("#queryDemoUserphotoInfocurrentPage").val(data.rows[0].startIndex);
                $("#queryDemoUserphotoInfototalPage").val(data.rows[0].totalPage);
                $("#queryDemoUserphotoInfopageSize").val(data.rows[0].pageSize);
                for(var i=0;i<resultList.length;i++){
                    var demoUserphotoInfoTr = $("<tr class=\"demoUserphotoInfoTr\"></tr>");
                    $("#demoUserphotoInfoTR_FIRST").parent().append(demoUserphotoInfoTr);
                    demoUserphotoInfoTr.append("<td><input style=\"width:23px;\" type=\"checkbox\"/></td><td>"+(i+1)+"</td>")
                    .append("<td>"+resultList[i].id+"</td>")
                    .append("<td>"+resultList[i].userNm+"</td>")
                    .append("<td>"+resultList[i].photo+"</td>")
                    .append("<td class=\"operateTbl\">" +
                        "<button class=\"btn btn-default btn-sm\" onclick=\"return editDemoUserphotoInfo('"+resultList[i].id+"');\"><i class=\"fa fa-edit\"></i></button>" +
                        "<button class=\"btn btn-default btn-sm\" onclick=\"return  delDemoUserphotoInfo('"+resultList[i].id+"');\"><i class=\"fa fa-trash-o\"></i></button>" +
                        "<button class=\"btn btn-default btn-sm\" onclick=\"return queryDemoUserphotoInfoObject('"+resultList[i].id+"');\"><i class=\"fa fa-search\"></i></button>" +
                        "</td>");
                }
                var currentPage = Number($("#queryDemoUserphotoInfocurrentPage").val());
                var totalPage   = Number($("#queryDemoUserphotoInfototalPage").val());
                var pageSize    = Number($("#queryDemoUserphotoInfopageSize").val());
                $("#queryDemoUserphotoInfo_fy .pager").ucPager({
                    currentPage : currentPage,
                    totalPage : totalPage,
                    pageSize : pageSize,
                    clickCallback: queryDemoUserphotoInfogopage
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

function queryDemoUserphotoInfogopage(currentPage) {
    searchDemoUserphotoInfo(currentPage);
}

function addDemoUserphotoInfo(){
    var url=webUrl+"/demoUserphotoInfo/insert.dhtml";
    var params={};
    params.id = $("#validateAddDemoUserphotoInfoForm #id1").val();
    params.userNm = $("#validateAddDemoUserphotoInfoForm #userNm1").val();
    params.photo = getFileupdownloadVal('validateAddDemoUserphotoInfoForm','photo1');
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
                $('#addDemoUserphotoInfo').modal('hide');
                searchDemoUserphotoInfo('');
                layer.msg('添加成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateAddDemoUserphotoInfoForm').bootstrapValidator('resetForm', true);
                setFileupdownloadVal('validateAddDemoUserphotoInfoForm','photo1','');
            }else{
                layer.alert(data.message);
                $('#validateAddDemoUserphotoInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
                $('#validateAddDemoUserphotoInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateAddDemoUserphotoInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function updateDemoUserphotoInfo(){
    var url=webUrl+"/demoUserphotoInfo/edit.dhtml";
    var params={};
    params.id_key = $("#validateUpdateDemoUserphotoInfoForm #id_key").val();
    params.id = $("#validateUpdateDemoUserphotoInfoForm #id3").val();
    params.userNm = $("#validateUpdateDemoUserphotoInfoForm #userNm3").val();
    params.photo = getFileupdownloadVal('validateUpdateDemoUserphotoInfoForm','photo3');
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
                $('#updateDemoUserphotoInfo').modal('hide');
                searchDemoUserphotoInfo('');
                layer.msg('修改成功', {icon: 1,time: 2000,offset: 'rb' }, function(){});
                $('#validateUpdateDemoUserphotoInfoForm').bootstrapValidator('resetForm', true);
            }else{
                layer.alert(data.message);
                $('#validateUpdateDemoUserphotoInfoForm  button[type="submit"]').attr('disabled',false);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert('系统异常，请稍后重试！');
            $('#validateUpdateDemoUserphotoInfoForm  button[type="submit"]').attr('disabled',false);
        },
        complete : function(XMLHttpRequest,status){
            if(status == "timeout"){
                ajaxTimeoutTest.abort();
                alert("操作超时！");
                $('#validateUpdateDemoUserphotoInfoForm  button[type="submit"]').attr('disabled',false);
            }
        }
    });
}

function editDemoUserphotoInfo(id_key){
    var url=webUrl+"/demoUserphotoInfo/queryObject.dhtml";
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
                $('#updateDemoUserphotoInfo').modal();
                $("#validateUpdateDemoUserphotoInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblDemoUserphotoInfo;
                $("#validateUpdateDemoUserphotoInfoForm #id3").val(objInfo.id!=null?objInfo.id:'');
                $("#validateUpdateDemoUserphotoInfoForm #userNm3").val(objInfo.userNm!=null?objInfo.userNm:'');
                setFileupdownloadVal('validateUpdateDemoUserphotoInfoForm','photo3',objInfo.photo!=null?objInfo.photo:'');
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
// // 在新的页签上展示图片
// function showPhoto(id_key){
//     var url=webUrl+"/file/showImage.dhtml";
//     // window.location.href = url+"?fileNo="+id_key;
//     window.open(url+"?fileNo="+id_key,'_blank');
// }
function queryDemoUserphotoInfoObject(id_key){
    var url=webUrl+"/demoUserphotoInfo/queryObject.dhtml";
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
                $('#detailDemoUserphotoInfo').modal();
                $("#validateDetailDemoUserphotoInfoForm #id_key").val(data.rows[0].id_key);
                var objInfo = data.rows[0].tblDemoUserphotoInfo;
                $("#validateDetailDemoUserphotoInfoForm #id2").val(objInfo.id!=null?objInfo.id:'');
                $("#validateDetailDemoUserphotoInfoForm #userNm2").val(objInfo.userNm!=null?objInfo.userNm:'');
                setFileupdownloadVal('validateDetailDemoUserphotoInfoForm','photo2',objInfo.photo!=null?objInfo.photo:'');
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
function delDemoUserphotoInfo(id_key){
    layer.confirm('是否删除？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        var url=webUrl+"/demoUserphotoInfo/del.dhtml";
        var params={};
        var currentPage= $("#queryDemoUserphotoInfocurrentPage").val();
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
                    searchDemoUserphotoInfo(currentPage);
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



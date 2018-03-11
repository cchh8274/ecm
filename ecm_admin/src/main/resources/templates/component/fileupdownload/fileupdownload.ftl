<#--
    文件上传下载按钮
    form:所属的formId
    name:要提交的Id和Name
    label：要显示的内容
    option：参数：上传按钮可见(1可见，0不可见)、重置按钮是否可见(1可见，0不可见)、查看按钮是否可见(1可见，0不可见)
    value:默认图片id
    storeType：储存类型：f1文件系统，d1数据库系统
-->
<#macro fileupdownload form name label options value
    need
    upload_base_path
    download_base_path
    fileDesc="自动上传文件"
    businessType="010"
    businessNo="010"
    storeType="d1"
    class1="col-md-3"
    class2="col-md-4 control-label"
    class3="col-md-8"
    class4="fileupdownload-inline"
    class5="inline1"
    readOnly="false">
    <div class="fileupdownload_${form}_${name} ${class1}">
        <label class="fileupdownload_${form}_${name} ${class2} "><#if need=='true'><i class="redFont">*</i></#if>${label}：</label>
        <div class="fileupdownload_${form}_${name} ${class3}">
            <#--默认显示选择框-->
            <input type="file"   id="${name}_file" name="upFile" class="btn" style="float:left;width:46%;" >
            <#--
                最终提交的值，由于bootstrap中会将:hidden,displaynone,disabled,readonly的过滤掉不校验，因此此处需要增加一个data-bv-excluded="false"
                作用详见:bootstrapValidator.js 554-556行
            -->
            <input type="text" id="${name}" name="${name}" class="form-control" style="float:left;width:46%;display:none;" value="${value}" data-bv-excluded="false">
            <input type="button" class="btn" id="${name}_fileupdownload_up" style="float:left;width:13%;" <#if options?substring(0,1)=="0">disabled=true</#if> onclick="fileupdownload_up('${form}','${name}','${upload_base_path}','${businessType}','${businessNo}','${fileDesc}','#${form} #${name}_file')" value="上传">
            <input type="button" class="btn" id="${name}_fileupdownload_reset" style="float:left;width:13%;" <#if options?substring(1,2)=="0">disabled=true</#if> onclick="fileupdownload_reset('${form}','${name}')" value="重置">
            <input type="button" class="btn" id="${name}_fileupdownload_clean" style="float:left;width:13%;" <#if options?substring(2,3)=="0">disabled=true</#if> onclick="fileupdownload_clean('${form}','${name}')" value="清空">
            <input type="button" class="btn" id="${name}_fileupdownload_show" style="float:left;width:13%;" <#if options?substring(3,4)=="0">disabled=true</#if> onclick="fileupdownload_show('${form}','${name}')" value="查看">

            <div class="clearfix"></div>
        </div>
    </div>
    <script type="text/javascript" src="${props('resourceUrl')}/js/plugins/ajaxfileupload/ajaxfileupload.js"></script>
    <script>

        function fileupdownload_up(form,name,url,business_type,business_no,file_desc,selectstr){
            var fileStr = $("#"+form +" #"+name+"_file").val();
            if(fileStr ==''){
                layer.alert("请选择文件");
                return;
            }
            //获取文件名称
            var originalFilename = fileStr.substr(fileStr.lastIndexOf("\\")+1);
            if(originalFilename==fileStr){
                var originalFilename = fileStr.substr(fileStr.lastIndexOf("/")+1);
            }
            //拼接URL
            var ajaxFileUploadUrl = url
                    +"?business_type="+encodeURIComponent(business_type)
                    +"&business_no="+encodeURIComponent(business_no)
                    +"&file_desc"+encodeURIComponent(file_desc)
                    +"&store_type=${storeType}"
                    +"&originalFilename="+encodeURIComponent(originalFilename);

            $.ajaxFileUpload({
                url: ajaxFileUploadUrl, //用于文件上传的服务器端请求地址
                secureuri: false, //是否需要安全协议，一般设置为false
                selectorStr: selectstr, //文件上传域的筛选器
                dataType: 'json', //返回值类型 一般设置为json
                success: function(result){
                    if(result.code=='success'){
                        $("#"+form +" #"+name).val(result.othMsg.file_no);
                        $("#"+form +" #"+name).css("display","block");
                        $("#"+form +" #"+name).attr("readonly",true);
                        $("#"+form +" #"+name+"_file").css("display","none");
                        $("#"+form +" #"+name+"_fileupdownload_up").attr("disabled",true);
                        //上传成功后修改状态为验证通过
                        $('#'+form).data('bootstrapValidator').updateStatus(name,'VALID','notEmpty');//NOT_VALIDATED未校验，INVALID无效，VALID有效
                        layer.alert("上传成功:code = "+result.code+"  message = "+result.message + " file_path = "+ result.othMsg.file_path);
                    }else{
                        layer.alert("上传失败");
                    }
                },
                error: function (data, status, e){
                    layer.alert("上传失败["+e+"]");
                }
            });
        }
        function fileupdownload_reset (form,name){
            var resetValue = $("#"+form +" #"+name).attr("resetValue");
            if(typeof resetValue == 'undefined' || resetValue == ''){
                //如果初始值为空，则显示上传按钮
                $("#"+form +" #"+name).val("");
                $("#"+form +" #"+name).css("display","none");
                $("#"+form +" #"+name).attr("readonly",true);
                $("#"+form +" #"+name+"_file").css("display","block");
                $("#"+form +" #"+name+"_fileupdownload_up").attr("disabled",false);
                try{
                    $('#'+form).data('bootstrapValidator').updateStatus(name,'NOT_VALIDATED','notEmpty');//NOT_VALIDATED未校验，INVALID无效，VALID有效
                }catch(e){}
            }else{
                //如果初始值有值
                $("#"+form +" #"+name).val(resetValue);
                $("#"+form +" #"+name).css("display","block");
                $("#"+form +" #"+name).attr("readonly",true);
                $("#"+form +" #"+name+"_file").css("display","none");
                $("#"+form +" #"+name+"_fileupdownload_up").attr("disabled",true);
                try{
                    $('#'+form).data('bootstrapValidator').updateStatus(name,'NOT_VALIDATED','notEmpty');//NOT_VALIDATED未校验，INVALID无效，VALID有效
                }catch(e){}
            }

        }
        function fileupdownload_clean (form,name){
            $("#"+form +" #"+name).val("");
            $("#"+form +" #"+name).css("display","none");
            $("#"+form +" #"+name).attr("readonly",true);
            $("#"+form +" #"+name+"_file").css("display","block");
            $("#"+form +" #"+name+"_fileupdownload_up").attr("disabled",false);
            try{
                $('#'+form).data('bootstrapValidator').updateStatus(name,'NOT_VALIDATED','notEmpty');//NOT_VALIDATED未校验，INVALID无效，VALID有效
            }catch(e){}
        }
        function fileupdownload_show (form,name){
            var fileNo = $("#"+form +" #"+name).val();
            if(fileNo!=''){
                window.open("${download_base_path}?fileNo="+fileNo);
            }else{
                layer.alert("请先上传文件再查看！");
            }
        }

        var getFileupdownloadVal=null;
        var setFileupdownloadVal=null;
        if(getFileupdownloadVal==undefined||getFileupdownloadVal==null){
            getFileupdownloadVal = function(form,name){
                return $("#"+form+" #"+name).val();
            }
        }
        if(setFileupdownloadVal==undefined||setFileupdownloadVal==null){
            setFileupdownloadVal = function(form,name,value){
                if(value == ''){
                    //如果初始值为空，则显示上传按钮
                    $("#"+form +" #"+name).val("");
                    $("#"+form +" #"+name).css("display","none");
                    $("#"+form +" #"+name).attr("readonly",true);
                    $("#"+form +" #"+name+"_file").css("display","block");
                    $("#"+form +" #"+name+"_fileupdownload_up").attr("disabled",false);
                    try{
                        $('#'+form).data('bootstrapValidator').updateStatus(name,'NOT_VALIDATED','notEmpty');//NOT_VALIDATED未校验，INVALID无效，VALID有效
                    }catch(e){}
                }else{
                    //如果初始值有值
                    $("#"+form +" #"+name).val(value);
                    $("#"+form +" #"+name).attr("resetValue",value);//用于恢复默认值
                    $("#"+form +" #"+name).css("display","block");
                    $("#"+form +" #"+name).attr("readonly",true);
                    $("#"+form +" #"+name+"_file").css("display","none");
                    $("#"+form +" #"+name+"_fileupdownload_up").attr("disabled",true);
                    try{
                        $('#'+form).data('bootstrapValidator').updateStatus(name,'NOT_VALIDATED','notEmpty');//NOT_VALIDATED未校验，INVALID无效，VALID有效
                    }catch(e){}
                }
            }
        }

    </script>
</#macro>
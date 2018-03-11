<#import "/component/register.ftl" as  register/>
<script type="text/javascript" src="${props('resourceUrl')}/js/jquery-1.7.1.min.js"></script>
<hr>
FORM模式<br>
<div style="" class="">
    <section class="content-header">
        <h1>
            文件上传Demo<small></small>
        </h1>
    </section>
    <script type="text/javascript" src="${props('resourceUrl')}/js/upload.js"></script>
    <script type="text/javascript" src="${props('resourceUrl')}/js/jquery-form.js"></script>
    <script type="text/javascript">
        function successhand(obj){
            if(obj.code=='success'){
                layer.alert("上传成功:code = "+obj.code+"  message = "+obj.message + " file_path = "+ obj.othMsg.file_path);
            }else{
                layer.alert("上传失败");
            }
        }
    </script>
    <form id="uploadForm" action="${upload_base_path}" method="post" enctype="multipart/form-data">
        <input type="hidden" id="business_type" name="business_type" value="010">
        <input type="hidden" id="business_no" name="business_no" value="00003344">
        <input type="hidden" id="file_desc" name="file_desc" value="好">
        <input type="hidden" id="store_type" name="store_type" value="f1">
        <table>
            <tr>
                <td>
                    <input type="file" name="upFile" id="upFile">
                </td>
            </tr>
        </table>
    </form>
    <input type="button" onclick="upLoad('uploadForm','successhand','f1')" value="提交到文件系统">
    <input type="button" onclick="upLoad('uploadForm','successhand','d1')" value="提交到数据库">
</div>
<hr>
ajax提交模式<br>
<script type="text/javascript" src="${props('resourceUrl')}/js/plugins/ajaxfileupload/ajaxfileupload.js"></script>
<input type="file" name="upFile" id="file1">
<input type="button" onclick="upByAjaxFileupload('/file/upLoad.dhtml','010','020','业务类型','#file1',successfunction)" value="提交upByAjaxFileupload">
<script>
    /**
     * 传入参数，把指定的文件上传到服务器
     * @param url
     * @param business_type
     * @param business_no
     * @param file_desc
     * @param selectstr
     */
    function upByAjaxFileupload(url,business_type,business_no,file_desc,selectstr,succesfunction){
        var ajaxFileUploadUrl = url+"?business_type="+encodeURIComponent(business_type)+"&business_no="+encodeURIComponent(business_no)+"&file_desc"+encodeURIComponent(file_desc);
        $.ajaxFileUpload({
            url: ajaxFileUploadUrl, //用于文件上传的服务器端请求地址
            secureuri: false, //是否需要安全协议，一般设置为false
            selectorStr: selectstr, //文件上传域的筛选器
            dataType: 'json', //返回值类型 一般设置为json
            success: succesfunction ,
            error: function (data, status, e){
                layer.alert("上传失败["+e+"]");
            }
        });
    }
    function successfunction(data){
        layer.alert("上传成功[code="+data.code+"][FileNo="+data.othMsg.file_no+"][fileName="+data.othMsg.fileName+"]");
    }

</script>

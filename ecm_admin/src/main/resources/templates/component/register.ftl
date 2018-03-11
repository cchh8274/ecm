<#--
    模块组建注册表
    还缺乏的模块包括
        筛选框
        select
        树形结构
        文本域
        时间框
        等
    此处有两种实现方式：
        1、指定input，通过jquery方法将该Input变成一个筛选框、复选框、时间框等......
        2、使用ftl，直接在后台生成目标代码
    建议用前者，但是由于时间以及思路的关系，目前用的是后者
-->
<#import "/component/checkbox/checkbox.ftl" as  checkbox_component/>
<#import "/component/fileupdownload/fileupdownload.ftl" as  fileupdownload_component/>

<#macro checkbox form name label options value
    class1="col-md-3"
    class2="col-md-4 control-label"
    class3="col-md-8"
    class4="checkbox-inline"
    class5="inline1" readOnly="false">

    <@checkbox_component.checkbox form=form name=name label=label options=options value=value
    class1=class1
    class2=class2
    class3=class3
    class4=class4
    class5=class5
    readOnly=readOnly/>
</#macro>



<#macro fileupdownload form name label options value
need="true"
upload_base_path="/file/upLoad.dhtml"
download_base_path="/file/downLoad.dhtml"
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
    <@fileupdownload_component.fileupdownload
        form=form name=name label=label options=options value=value
        need=need
        upload_base_path=upload_base_path
        download_base_path=download_base_path
        fileDesc=fileDesc
        businessType=businessType
        businessNo=businessNo
        storeType=storeType
        class1=class1
        class2=class2
        class3=class3
        class4=class4
        class5=class5
        readOnly=class5/>
</#macro>

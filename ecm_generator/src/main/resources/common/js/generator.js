function getInputModel(){
    //String power,String notEmptyMsg,int min,int max,String strLengthMsg,String regExp,String regExpMsg,boolean isMoney,String sequence
    var str = "";
    str +="<span class='sztitle'>权限:</span><input id='power' value='YYYYYY' class='szinput'/><br>";
    str +="<span class='sztitle'>非空校验:</span><input id='notEmptyMsg' value='不可以为空' class='szinput'/><br>";
    str +="<span class='sztitle'>最小长度:</span><input id='min' value='0' class='szinput'/><br>";
    str +="<span class='sztitle'>最大长度:</span><input id='max' value='999' class='szinput'/><br>";
    str +="<span class='sztitle'>长度不正确提示:</span><input id='strLengthMsg' value='长度不正确' class='szinput'/><br>";
    str +="<span class='sztitle'>正则表达式:</span><input id='regExp' value='^[\\\\u4E00-\\\\u9FA5A-Za-z0-9]*$' class='szinput'/><br>";
    str +="<span class='sztitle'>正则表达式错误提示:</span><input id='regExpMsg' value='不符合规则' class='szinput'/><br>";
    str +="<span class='sztitle'>是否是货币:</span><select id='isMoney' class='szselect'><option value='false'>false</option><option value='true'>true</option></select><br>";
    str +="<span class='sztitle'>序列:</span><input id='sequence' value='' class='szinput'/><br>";
    return str;
}
function getDateModel (){
    //String power,boolean autoInsert,boolean autoUpdate,boolean queryRange
    var str = "";
    str +="<span class='sztitle'>权限:</span><input id='power' value='YYYYYY' class='szinput'/><br>";
    str +="<span class='sztitle'>自动插入:</span><select id='autoInsert' class='szselect'><option value='false'>false</option><option value='true'>true</option></select><br>";
    str +="<span class='sztitle'>自动更新:</span><select id='autoUpdate' class='szselect'><option value='false'>false</option><option value='true'>true</option></select><br>";
    str +="<span class='sztitle'>范围查询:</span><select id='queryRange' class='szselect'><option value='true'>true</option><option value='false'>false</option></select><br>";
    return str;
}
function getDatetimeModel (){
    //String power,boolean autoInsert,boolean autoUpdate,boolean queryRange
    var str = "";
    str +="<span class='sztitle'>权限:</span><input id='power' value='YYYYYY' class='szinput'/><br>";
    str +="<span class='sztitle'>自动插入:</span><select id='autoInsert' class='szselect'><option value='false'>false</option><option value='true'>true</option></select><br>";
    str +="<span class='sztitle'>自动更新:</span><select id='autoUpdate' class='szselect'><option value='false'>false</option><option value='true'>true</option></select><br>";
    str +="<span class='sztitle'>范围查询:</span><select id='queryRange' class='szselect'><option value='true'>true</option><option value='false'>false</option></select><br>";
    return str;
}
function getRadioModel(){
    //String power,String notEmptyMsg,String options,String l1Code,String l2Code
    var str = "";
    str +="<span class='sztitle'>权限:</span><input id='power' value='YYYYYY' class='szinput'/><br>";
    str +="<span class='sztitle'>非空校验:</span><input id='notEmptyMsg' value='不可以为空' class='szinput'/><br>";
    str +="<span class='sztitle'>精确OPTIONS:</span><input id='options' value=\"{'010':'票据','020':'固收','030':'众筹'}\" class='szinput'/><br>";
    str +="<span class='sztitle'>l1Code:</span><input id='l1Code' value='如果同时填写options和l1Codel2Code，则以options为准' class='szinput'/><br>";
    str +="<span class='sztitle'>l2Code:</span><input id='l2Code' value='如果同时填写options和l1Codel2Code，则以options为准' class='szinput'/><br>";
    return str;
}
function getSelectModel(){
    //String power,String notEmptyMsg,String options,String l1Code,String l2Code
    var str = "";
    str +="<span class='sztitle'>权限:</span><input id='power' value='YYYYYY' class='szinput'/><br>";
    str +="<span class='sztitle'>非空校验:</span><input id='notEmptyMsg' value='不可以为空' class='szinput'/><br>";
    str +="<span class='sztitle'>精确OPTIONS:</span><input id='options' value=\"{'010':'票据','020':'固收','030':'众筹'}\" class='szinput'/><br>";
    str +="<span class='sztitle'>l1Code:</span><input id='l1Code' value='如果同时填写options和l1Codel2Code，则以options为准' class='szinput'/><br>";
    str +="<span class='sztitle'>l2Code:</span><input id='l2Code' value='如果同时填写options和l1Codel2Code，则以options为准' class='szinput'/><br>";
    return str;
}
function getCheckboxModel(){
    //String power,String notEmptyMsg,String options,String l1Code,String l2Code
    var str = "";
    str +="<span class='sztitle'>权限:</span><input id='power' value='YYYYYY' class='szinput'/><br>";
    str +="<span class='sztitle'>非空校验:</span><input id='notEmptyMsg' value='不可以为空' class='szinput'/><br>";
    str +="<span class='sztitle'>精确OPTIONS:</span><input id='options' value=\"['票据','固收','众筹']\" class='szinput'/><br>";
    str +="<span class='sztitle'>l1Code:</span><input id='l1Code' value='如果同时填写options和l1Codel2Code，则以options为准' class='szinput'/><br>";
    str +="<span class='sztitle'>l2Code:</span><input id='l2Code' value='如果同时填写options和l1Codel2Code，则以options为准' class='szinput'/><br>";
    return str;
}
function getTextareaModel(){
    //String power,String notEmptyMsg,int min,int max,String strLengthMsg,String regExp,String regExpMsg,boolean isMoney,String sequence
    var str = "";
    str +="<span class='sztitle'>权限:</span><input id='power' value='YYYYYY' class='szinput'/><br>";
    str +="<span class='sztitle'>非空校验:</span><input id='notEmptyMsg' value='不可以为空' class='szinput'/><br>";
    str +="<span class='sztitle'>最小长度:</span><input id='min' value='0' class='szinput'/><br>";
    str +="<span class='sztitle'>最大长度:</span><input id='max' value='99999' class='szinput'/><br>";
    str +="<span class='sztitle'>长度不正确提示:</span><input id='strLengthMsg' value='长度不正确' class='szinput'/><br>";
    str +="<span class='sztitle'>正则表达式:</span><input id='regExp' value='^[\\u4E00-\\u9FA5A-Za-z0-9]*$' class='szinput'/><br>";
    str +="<span class='sztitle'>正则表达式错误提示:</span><input id='regExpMsg' value='不符合规则' class='szinput'/><br>";
    return str;
}
function getBlobModel(){
    //String power,String notEmptyMsg,int min,int max,String strLengthMsg,String regExp,String regExpMsg,boolean isMoney,String sequence
    var str = "";
    str +="<span class='sztitle'>权限:</span><input id='power' value='NNYYYY' class='szinput'/><br>";
    str +="<span class='sztitle'>非空校验:</span><input id='notEmptyMsg' value='不可以为空' class='szinput'/><br>";
    str +="<span class='sztitle'>最小字节:</span><input id='min' value='0' class='szinput'/><br>";
    str +="<span class='sztitle'>最大字节:</span><input id='max' value='99999' class='szinput'/><br>";
    str +="<span class='sztitle'>文件大小不正确提示:</span><input id='strLengthMsg' value='文件大小不正确' class='szinput'/><br>";
    return str;
}
function getFileModel(){
    //String power,String notEmptyMsg,int min,int max,String strLengthMsg,String regExp,String regExpMsg,boolean isMoney,String sequence
    var str = "";
    str +="<span class='sztitle'>权限:</span><input id='power' value='YYYYYY' class='szinput'/><br>";
    str +="<span class='sztitle'>非空校验:</span><input id='notEmptyMsg' value='不可以为空' class='szinput'/><br>";
    return str;
}


//工具函数，用以从columnCommentJson中获取指定路径的值
function getInfo(columnCommentJson,str){
    var result = "";
    try{
        result = eval(str);
        if(typeof result == "string" && result.indexOf("\\")>=0){
            //在页面输入\\，传输到后台，后台存入数据库 的过程中,\\是正常的，
            // 而从数据库中取出，网络传输回页面，\\是正常的，
            // 而ajax对结果解析为json时，会丢失一个\，
            // 因此此处对\\增加一个\\
            //此方法在mysql中验证通过，在Oracle和DB2中需要验证
            result = result.replace(/\\/g,"\\\\");
        }
    }catch (e){
        return "";
    }
    return result;
}


function initDefaultAndSetValueBycolumnCommentJson(tableid,i,columnCommentJson){
    $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4)").empty();
    if(columnCommentJson.type=="input"){
        $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4)").empty();
        $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4)").append(getInputModel());
        if(columnCommentJson.attr!=undefined&&columnCommentJson.attr!=null){
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#power").val(getInfo(columnCommentJson,'columnCommentJson.attr.power'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#notEmptyMsg").val(getInfo(columnCommentJson,'columnCommentJson.validate.notEmpty.message'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#min").val(getInfo(columnCommentJson,'columnCommentJson.validate.stringLength.min'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#max").val(getInfo(columnCommentJson,'columnCommentJson.validate.stringLength.max'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#strLengthMsg").val(getInfo(columnCommentJson,'columnCommentJson.validate.stringLength.message'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#regExp").val(getInfo(columnCommentJson,'columnCommentJson.validate.regexp.regexp'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#regExpMsg").val(getInfo(columnCommentJson,'columnCommentJson.validate.regexp.message'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) select#isMoney").val(getInfo(columnCommentJson,'columnCommentJson.attr.isMoney'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#sequence").val(getInfo(columnCommentJson,'columnCommentJson.attr.sequence'));
        }
    }else if(columnCommentJson.type=="date"){
        $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4)").empty();
        $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4)").append(getDateModel());
        if(columnCommentJson.attr!=undefined&&columnCommentJson.attr!=null){
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#power").val(getInfo(columnCommentJson,'columnCommentJson.attr.power'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) select#autoInsert").val(getInfo(columnCommentJson,'columnCommentJson.attr.autoinsert'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) select#autoUpdate").val(getInfo(columnCommentJson,'columnCommentJson.attr.autoupdate'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) select#queryRange").val(getInfo(columnCommentJson,'columnCommentJson.attr.queryrange'));
        }
    }else if(columnCommentJson.type=="datetime"){
        $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4)").empty();
        $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4)").append(getDatetimeModel());
        if(columnCommentJson.attr!=undefined&&columnCommentJson.attr!=null){
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#power").val(getInfo(columnCommentJson,'columnCommentJson.attr.power'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) select#autoInsert").val(getInfo(columnCommentJson,'columnCommentJson.attr.autoinsert'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) select#autoUpdate").val(getInfo(columnCommentJson,'columnCommentJson.attr.autoupdate'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) select#queryRange").val(getInfo(columnCommentJson,'columnCommentJson.attr.queryrange'));
        }
    }else if(columnCommentJson.type=="radio"){
        $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4)").empty();
        $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4)").append(getRadioModel());
        if(columnCommentJson.attr!=undefined&&columnCommentJson.attr!=null){
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input:eq(0)").val(columnCommentJson.attr.power);
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#notEmptyMsg").val(getInfo(columnCommentJson,'columnCommentJson.validate.notEmpty.message'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#options").val(getInfo(columnCommentJson,'columnCommentJson.attr.options')==""?"":JSON.stringify(getInfo(columnCommentJson,'columnCommentJson.attr.options')));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#l1Code").val(getInfo(columnCommentJson,'columnCommentJson.attr.l1Code'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#l2Code").val(getInfo(columnCommentJson,'columnCommentJson.attr.l2Code'));
        }
    }else if(columnCommentJson.type=="select"){
        $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4)").empty();
        $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4)").append(getSelectModel());
        if(columnCommentJson.attr!=undefined&&columnCommentJson.attr!=null){
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input:eq(0)").val(columnCommentJson.attr.power);
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#notEmptyMsg").val(getInfo(columnCommentJson,'columnCommentJson.validate.notEmpty.message'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#options").val(getInfo(columnCommentJson,'columnCommentJson.attr.options')==""?"":JSON.stringify(getInfo(columnCommentJson,'columnCommentJson.attr.options')));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#l1Code").val(getInfo(columnCommentJson,'columnCommentJson.attr.l1Code'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#l2Code").val(getInfo(columnCommentJson,'columnCommentJson.attr.l2Code'));
        }
    }else if(columnCommentJson.type=="checkbox"){
        $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4)").empty();
        $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4)").append(getCheckboxModel());
        if(columnCommentJson.attr!=undefined&&columnCommentJson.attr!=null){
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input:eq(0)").val(columnCommentJson.attr.power);
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#notEmptyMsg").val(getInfo(columnCommentJson,'columnCommentJson.validate.notEmpty.message'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#options").val(getInfo(columnCommentJson,'columnCommentJson.attr.options')==""?"":JSON.stringify(getInfo(columnCommentJson,'columnCommentJson.attr.options')));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#l1Code").val(getInfo(columnCommentJson,'columnCommentJson.attr.l1Code'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#l2Code").val(getInfo(columnCommentJson,'columnCommentJson.attr.l2Code'));
        }
    }else if(columnCommentJson.type=="textarea"){
        $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4)").empty();
        $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4)").append(getTextareaModel());
        if(columnCommentJson.attr!=undefined&&columnCommentJson.attr!=null){
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#power").val(getInfo(columnCommentJson,'columnCommentJson.attr.power'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#notEmptyMsg").val(getInfo(columnCommentJson,'columnCommentJson.validate.notEmpty.message'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#min").val(getInfo(columnCommentJson,'columnCommentJson.validate.stringLength.min'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#max").val(getInfo(columnCommentJson,'columnCommentJson.validate.stringLength.max'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#strLengthMsg").val(getInfo(columnCommentJson,'columnCommentJson.validate.stringLength.message'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#regExp").val(getInfo(columnCommentJson,'columnCommentJson.validate.regexp.regexp'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#regExpMsg").val(getInfo(columnCommentJson,'columnCommentJson.validate.regexp.message'));
        }
    }else if(columnCommentJson.type=="blob"){
        $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4)").empty();
        $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4)").append(getBlobModel());
        if(columnCommentJson.attr!=undefined&&columnCommentJson.attr!=null){
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#power").val(getInfo(columnCommentJson,'columnCommentJson.attr.power'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#notEmptyMsg").val(getInfo(columnCommentJson,'columnCommentJson.validate.notEmpty.message'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#min").val(getInfo(columnCommentJson,'columnCommentJson.validate.stringLength.min'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#max").val(getInfo(columnCommentJson,'columnCommentJson.validate.stringLength.max'));
        }
    }else if(columnCommentJson.type=="file"){
        $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4)").empty();
        $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4)").append(getFileModel());
        if(columnCommentJson.attr!=undefined&&columnCommentJson.attr!=null){
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#power").val(getInfo(columnCommentJson,'columnCommentJson.attr.power'));
            $("#"+tableid+" tr:eq("+(parseInt(i)+1)+") td:eq(4) input#notEmptyMsg").val(getInfo(columnCommentJson,'columnCommentJson.validate.notEmpty.message'));
        }
    }
}

function loadDataToTable(tableid,data,showIsUnion){
    $("#"+tableid+" tr:gt(0)").remove();
    for(var i in data.columnsJsonArray){
        var columnJSON = data.columnsJsonArray[i];
        var columnName = columnJSON["curr.table.column.names"];
        var columnNameTf = columnJSON["curr.table.column.names.tf"];
        var columnCommentAll = columnJSON["curr.table.column.comment.all"];
        var columnComment = columnJSON["curr.table.column.comment"];
        var columnCommentJson = columnJSON["curr.table.column.comment.json"];
        var columnType = columnJSON["curr.table.column.type"];
        var columnTypeColumnSize = columnJSON["curr.table.column.type.column.size"];
        var columnTypeColumnDecimalDigits = columnJSON["curr.table.column.type.column.size.decimal.digits"];
        var isNullAble = columnJSON["isNullAble"];
        if(typeof  columnTypeColumnDecimalDigits =="undefined"){
            columnTypeColumnDecimalDigits=0;
        }
        var content = "<tr class='tr_"+columnName+"'>" +
            "<td>"+columnName+"</td>" +
            "<td><input value='"+columnComment+"'></td>" +
            "<td>"+columnType+"</td>" +
            "<td>";
        content+="<select class='TYPE_SELECT' idx='"+i+"'>";
        content+="<option value=''>未选择</option>";
        var TYPES = ['input','date','datetime','radio','select','checkbox','textarea','blob','file'];
        for(var ii in TYPES){
            content+="<option value='"+TYPES[ii]+"'";
            if(columnCommentJson.type==TYPES[ii]){
                content+="selected='selected'"
            }
            content+=">"+TYPES[ii]+"</option>";
        }
        content+="</select>"
        content+="</td>" +
        "<td></td>" +
        "<td><select id='isPrimaryKey' class='isPrimaryKey'><option value='false'"+(columnJSON.isPrimaryKey=="false"?"selected":"")+">false</option><option value='true' "+(columnJSON.isPrimaryKey=="true"?"selected":"")+">true</option></select></td>" +
        "<td>"+columnTypeColumnSize+"</td>" +
        "<td>"+columnTypeColumnDecimalDigits+"</td>" +
        "<td>"+isNullAble+"</td>" +
        (showIsUnion=='Y'?"<td><select id='showIsUnion' class='showIsUnion'><option value='true' "+(columnJSON.showIsUnion=="true"?"selected":"")+">true</option><option value='false'"+(columnJSON.showIsUnion=="false"?"selected":"")+">false</option></select></td>" :"")+
        "</tr>";
        $("#"+tableid).append(content);
        initDefaultAndSetValueBycolumnCommentJson(tableid,i,columnCommentJson);
    }

}


function getBuildParam(tableid,showIsUnion){
    var buildParam = [];
    $("#"+tableid+" tr:gt(0)").each(function(){
        var column =  $(this).find("td:eq(0)").text();
        var columnName =  $(this).find("td:eq(1) input").val();
        var sqlType = $(this).find("td:eq(2)").text();
        var type = $(this).find("td:eq(3) select").val();
        var isPrimaryKey = $(this).find("td:eq(5) select").val();
        var columnTypeColumnSize = $(this).find("td:eq(6)").text();
        var columnTypeColumnDecimalDigits = $(this).find("td:eq(7)").text();
        var isNullAble = $(this).find("td:eq(8)").text();
        var isUnion = "";
        if(showIsUnion=="Y"){
            isUnion = $(this).find("td:eq(9) select").val();
        }

        var obj = {};
        obj.column = column;
        obj.columnName = columnName;
        obj.sqlType = sqlType;
        obj.type = type;
        obj.isPrimaryKey = isPrimaryKey;
        obj.columnTypeColumnSize = columnTypeColumnSize;
        obj.columnTypeColumnDecimalDigits = columnTypeColumnDecimalDigits;
        obj.isNullAble = isNullAble;
        if(showIsUnion=="Y"){
            obj.isUnion = isUnion;
        }

        $(this).find("td:eq(4) input").each(function(){
            var id = $(this).attr("id");
            var value=$(this).val();
            value = 'BASE64()'+$.base64.encode(encodeURIComponent(value));
            obj[id]=value;
        });
        $(this).find("td:eq(4) select").each(function(){
            var id = $(this).attr("id");
            var value=$(this).val();
            value = 'BASE64()'+$.base64.encode(encodeURIComponent(value));
            obj[id]=value;
        });
        buildParam.push(obj);
    });
    return buildParam;
}
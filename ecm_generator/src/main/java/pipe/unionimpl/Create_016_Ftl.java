package pipe.unionimpl;

import context.Context;
import context.GeneratorJSONProperties;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pipe.Pipe;
import utils.FileUtils;
import utils.FormatUtils;
import utils.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by baolong on 2017/2/27.
 */
public class Create_016_Ftl implements Pipe {
    public void exec(Context c) throws Exception {
        //创建查询页
        exec_create_001_QUERYPAGE(c);
        //创建新增页
        exec_create_002_ADDPAGE(c);
        //创建详情页
        exec_create_003_DETAILPAGE(c);
        //创建修改页
        exec_create_004_UPDATEPAGE(c);
    }

    public void exec_create_001_QUERYPAGE(Context c) throws Exception {
        //创建文件夹
        if(!FileUtils.mkdirs((String) c.get(Context.PATH_FTL))){
            throw new Exception("文件夹["+(String)c.get(Context.PATH_FTL)+"]创建不成功");
        }
        //准备数据
        String tableName = (String)c.get(Context.CURR_TABLE);//tbl_user_info
        String entityClassName = FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(tableName));//TblUserInfo
        String cleanentityClassName = FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(tableName));//UserInfo
        //去掉Tbl的头部
        if(cleanentityClassName.startsWith("Tbl")){
            cleanentityClassName = cleanentityClassName.substring(3);
        }
        entityClassName = "Union"+entityClassName;
        cleanentityClassName = "Union"+cleanentityClassName;

        String cleanentityClassNameFirstSmall = FormatUtils.firstSmall(cleanentityClassName);//userInfo
        String ftldirectory = cleanentityClassName.toLowerCase();//userinfo
        //创建子文件夹
        if(!FileUtils.mkdirs((String) c.get(Context.PATH_FTL) + File.separator + ftldirectory)){
            throw new Exception("文件夹["+(String) c.get(Context.PATH_FTL) + File.separator + ftldirectory + "]创建不成功");
        }
        String ftlname = ftldirectory;
        String fileName = ftlname+".ftl";//文件名与父路径名相同
        File filePath = new File((String)c.get(Context.PATH_FTL) + File.separator+ftldirectory+File.separator+fileName);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath),(String)c.get(Context.FILE_CHARSET)));

        //准备内容
        StringBuilder sb = new StringBuilder();
        sb.append("<#import \"/component/register.ftl\" as  register/>").append("\r\n");
        sb.append("<#import \"/"+ftldirectory+"/"+ftlname+".ftl\" as  "+ftlname+"/>").append("\r\n");
        sb.append("<#import \"/"+ftldirectory + "/add"+cleanentityClassName+".ftl\" as  add"+cleanentityClassName + "/>").append("\r\n");
        sb.append("<#import \"/"+ftldirectory+"/update"+cleanentityClassName+".ftl\" as  update"+cleanentityClassName+"/>").append("\r\n");
        sb.append("<#import \"/"+ftldirectory+"/detail"+cleanentityClassName+".ftl\" as  detail"+cleanentityClassName+"/>").append("\r\n");
        sb.append("<#include \"/management/resource.ftl\"/>").append("\r\n");
        sb.append("").append("\r\n");
        sb.append("<@"+ftlname+"."+ftlname+"Html/>").append("\r\n");
        sb.append("<@add"+cleanentityClassName+".add"+cleanentityClassName+"Html/>").append("\r\n");
        sb.append("<@detail"+cleanentityClassName+".detail"+cleanentityClassName+"Html/>").append("\r\n");
        sb.append("<@update"+cleanentityClassName+".update"+cleanentityClassName+"Html/>").append("\r\n");
        sb.append("").append("\r\n");
        sb.append("<#macro "+ftlname+"Html>").append("\r\n");
        sb.append("<div style=\"\" class=\"\">").append("\r\n");
        sb.append("    <section class=\"content-header\">").append("\r\n");
        sb.append("        <h1>").append("\r\n");
        sb.append("                "+((String)c.get(Context.CURR_TABLE_COMMENT))+"<small></small>").append("\r\n");
        sb.append("        </h1>").append("\r\n");
        sb.append("    </section>").append("\r\n");
        sb.append("    <!-- Main content -->").append("\r\n");
        sb.append("    <section class=\"content\">").append("\r\n");
        sb.append("        <div class=\"box\">").append("\r\n");

        //头部box-header开始
        sb.append("            <div class=\"box-header\">").append("\r\n");
        sb.append("                <form id=query"+cleanentityClassName+"Form class=\"form-horizontal form-inline\">").append("\r\n");
        //此处需要针对数据类型添加查询条件--start
        //行-start
        sb.append("                    <div class=\"row dis-top\">").append("\r\n");

        //遍历字段
        int count = (Integer)c.get(Context.CURR_TABLE_COLUMN_COUNT);//字段总数
        int count_used = 0;//查询字段的数量
        for(int i=0;i<count;i++){
            String column_name = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_NAME)).get(i);
            String column_name_tf = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_NAME_TF)).get(i);
            String column_comment = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT)).get(i);
            String column_comment_all = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT_ALL)).get(i);
            JSONObject column_comment_json = (JSONObject)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT_JSON)).get(i);
            String type = GeneratorJSONProperties.DEFAULT_type;//设置为默认的Type
            try{
                type = column_comment_json.getString(GeneratorJSONProperties.PATH_type);
            }catch (Exception e){
                //e.printStackTrace();
            }
            String power = GeneratorJSONProperties.DEFAULT_power;//设置为默认的权限
            try{
                JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                power = attr.getString(GeneratorJSONProperties.PATH_power);
            }catch (Exception e){
                //e.printStackTrace();
            }
            //如果权限中包含“允许作为查询条件”
            if(power.indexOf("query-condition:Y")>=0){
                //对作为列的查询数量进行递增
                count_used++;
                //列-作为查询条件-start
                if(type.equals(GeneratorJSONProperties.FIELD_type_input)){
                    sb.append("                        <div class=\"col-md-3\">").append("\r\n");
                    sb.append("                            <label class=\"queryTitle\">"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-md-8\">").append("\r\n");
                    sb.append("                                <input type=\"text\" class=\"form-control\" placeholder=\"\" id=\""+column_name_tf+"\" name=\""+column_name_tf+"\">").append("\r\n");
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_date)){
                    sb.append("                        <div class=\"col-md-3\">").append("\r\n");
                    sb.append("                            <label class=\"queryTitle\">"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-md-8\">").append("\r\n");
                    sb.append("                                <input type=\"text\" class=\"form-control\" placeholder=\"\" id=\""+column_name_tf+"\" name=\""+column_name_tf+"\">").append("\r\n");
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_datetime)){
                    sb.append("                        <div class=\"col-md-3\">").append("\r\n");
                    sb.append("                            <label class=\"queryTitle\">"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-md-8\">").append("\r\n");
                    sb.append("                                <input type=\"text\" class=\"form-control\" placeholder=\"\" id=\""+column_name_tf+"\" name=\""+column_name_tf+"\">").append("\r\n");
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_select)){
                    sb.append("                        <div class=\"col-md-3\">").append("\r\n");
                    sb.append("                            <label class=\"queryTitle\">"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-md-8\">").append("\r\n");
                    sb.append("                                <select class=\"form-control select2\" id=\""+column_name_tf+"\" name=\""+column_name_tf+"\">").append("\r\n");
                    //是否有全部查询选择
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object needAll_o = attr.get(GeneratorJSONProperties.PATH_needAll);
                        if(needAll_o!=null  && ((String)needAll_o).trim().equals("true")){
                            sb.append("                                    <option selected=\"selected\" value=\"\">全部</option>").append("\r\n");
                        }
                    }catch (Exception e){
                        //e.printStackTrace();
                        System.out.println("tablename["+tableName+"],columnName["+column_name+"],columnComment_ALL["+column_comment_all+"]--解析SELECT是否含有全部查询按钮needAll异常");
                    }
                    //静态模式
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object options_o = attr.get(GeneratorJSONProperties.PATH_options);
                        if(options_o!=null){
                            sb.append("                                    <#--静态模式-start-->").append("\r\n");
                            sb.append("                                    <#assign options="+((JSONObject)options_o).toString()+"/>").append("\r\n");
                            sb.append("                                    <#list options?keys as key >").append("\r\n");
                            sb.append("                                        <option value=\"${key}\">${options[key]}</option>").append("\r\n");
                            sb.append("                                    </#list>").append("\r\n");
                            sb.append("                                    <#--静态模式- end -->").append("\r\n");
                        }
                    }catch (Exception e){
                        //e.printStackTrace();
                        System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析SELECT-options异常");
                    }
                    //动态模式
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object l1Code = attr.get(GeneratorJSONProperties.PATH_l1Code);
                        Object l2Code = attr.get(GeneratorJSONProperties.PATH_l2Code);
                        if(l1Code!=null&&l2Code!=null){
                            sb.append("                                    <#--动态模式-start-->").append("\r\n");
                            sb.append("                                    <#assign options=dicList['"+l1Code+","+l2Code+"']/>").append("\r\n");
                            sb.append("                                    <#list options as item >").append("\r\n");
                            sb.append("                                        <option value=\"${item.codeParam}\">${item.codeValue}</option>").append("\r\n");
                            sb.append("                                    </#list>").append("\r\n");
                            sb.append("                                    <#--动态模式- end -->").append("\r\n");
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析SELECT-l1Code-l2Code异常");
                    }
                    sb.append("                                </select>").append("\r\n");
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_radio)){
                    sb.append("                        <div class=\"col-md-3\">").append("\r\n");
                    sb.append("                            <label class=\"queryTitle\">"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-md-8\">").append("\r\n");
                    //静态模式
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object options_o = attr.get(GeneratorJSONProperties.PATH_options);
                        if(options_o!=null){
                            sb.append("                                <#--静态模式-start-->").append("\r\n");
                            sb.append("                                <#assign options="+((JSONObject)options_o).toString()+"/>").append("\r\n");
                            sb.append("                                <#list options?keys as key >").append("\r\n");
                            sb.append("                                <label class=\"radio-inline\">").append("\r\n");
                            sb.append("                                    <input type=\"radio\" id=\""+column_name_tf+"_${key}\" name=\""+column_name_tf+"\" value=\"${key}\">${options[key]}").append("\r\n");
                            sb.append("                                </label>").append("\r\n");
                            sb.append("                                </#list>").append("\r\n");
                            sb.append("                                <#--静态模式- end -->").append("\r\n");
                            sb.append("                                <div class=\"clearfix\"></div>").append("\r\n");
                        }
                    }catch (Exception e){
                        //e.printStackTrace();
                        System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析radio-options异常");
                    }
                    //动态模式
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object l1Code = attr.get(GeneratorJSONProperties.PATH_l1Code);
                        Object l2Code = attr.get(GeneratorJSONProperties.PATH_l2Code);
                        if(l1Code!=null&&l2Code!=null){
                            sb.append("                                <#--动态模式-start-->").append("\r\n");
                            sb.append("                                <#assign options=dicList['"+l1Code+","+l2Code+"']/>").append("\r\n");
                            sb.append("                                <#list options as item >").append("\r\n");
                            sb.append("                                <label class=\"radio-inline\">").append("\r\n");
                            sb.append("                                    <input type=\"radio\" id=\""+column_name_tf+"_${item.codeParam}\" name=\""+column_name_tf+"\" value=\"${item.codeParam}\">${item.codeValue}").append("\r\n");
                            sb.append("                                </label>").append("\r\n");
                            sb.append("                                </#list>").append("\r\n");
                            sb.append("                                <#--动态模式- end -->").append("\r\n");
                            sb.append("                                <div class=\"clearfix\"></div>").append("\r\n");
                        }
                    }catch (Exception e){
                        //e.printStackTrace();
                        System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析radio-l1Code-l2Code异常");
                    }
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_checkbox)){
                    //静态模式
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object options_o = attr.get(GeneratorJSONProperties.PATH_options);
                        if(options_o!=null){
                            sb.append("                        <#--静态模式-start-->").append("\r\n");
                            sb.append("                        <#assign options="+((JSONArray)options_o).toString()+"/>").append("\r\n");
                            sb.append("                        <@register.checkbox form=\"query"+cleanentityClassName+"Form\" name=\""+column_name_tf+"\" label=\""+column_comment+"\" options=options value=\"\"").append("\r\n");
                            sb.append("                        class1=\"col-md-3\" " +
                                    "class2=\"queryTitle\" " +
                                    "class3=\"col-md-8\" " +
                                    "class4=\"checkbox-inline\" " +
                                    "class5=\"inline1\" " +
                                    "readOnly=\"false\"/>").append("\r\n");
                            sb.append("                        <#--静态模式- end -->").append("\r\n");
                        }
                    }catch (Exception e){
                        //e.printStackTrace();
                        System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析checkbox-options异常");
                    }
                    //动态模式
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object l1Code = attr.get(GeneratorJSONProperties.PATH_l1Code);
                        Object l2Code = attr.get(GeneratorJSONProperties.PATH_l2Code);
                        if(l1Code!=null&&l2Code!=null){
                            sb.append("                        <#--动态模式-start-->").append("\r\n");
                            sb.append("                        <#assign options=dicCheckbox['"+l1Code+","+l2Code+"']/>").append("\r\n");
                            sb.append("                        <@register.checkbox form=\"query"+cleanentityClassName+"Form\" name=\""+column_name_tf+"\" label=\""+column_comment+"\" options=options value=\"\"").append("\r\n");
                            sb.append("                        class1=\"col-md-3\" " +
                                    "class2=\"queryTitle\" " +
                                    "class3=\"col-md-8\" " +
                                    "class4=\"checkbox-inline\" " +
                                    "class5=\"inline1\" " +
                                    "readOnly=\"false\"/>").append("\r\n");
                            sb.append("                        <#--动态模式- end -->").append("\r\n");
                        }
                    }catch (Exception e){
                        //e.printStackTrace();
                        System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析checkbox-l1Code-l2Code异常");
                    }
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_textarea)){
                    sb.append("                        <div class=\"col-md-3\">").append("\r\n");
                    sb.append("                            <label class=\"queryTitle\">"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-md-8\">").append("\r\n");
                    sb.append("                                <input type=\"text\" class=\"form-control\" placeholder=\"\" id=\""+column_name_tf+"\" name=\""+column_name_tf+"\">").append("\r\n");
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                //列-作为查询条件-end
                //如果是当前数量已经是第四个，并且不是0，并且不是最后一个，则显示一个换行
                if(count_used%4==0 && count_used>0 && (count_used <=count)){
                    sb.append("                    </div>").append("\r\n");
                    sb.append("                    <div class=\"row dis-top\">").append("\r\n");
                }
            }
        }
        //插入查询按钮//count为列的总数，count_used为已作为查询条件的列的总数
        for(int i=0;i<(4-1-count_used%4);i++){
            sb.append("                        <div class=\"col-md-3\">").append("\r\n");
            sb.append("                        </div>").append("\r\n");
        }
        //添加查询按钮
        sb.append("                        <div class=\"col-md-3\">").append("\r\n");
        sb.append("                            <div class=\"searchDiv\">").append("\r\n");
        sb.append("                                <button type=\"button\" class=\"btn btn-info searchBtn\" onclick=\"search"+cleanentityClassName+"('')\">搜索</button>").append("\r\n");
        String downloadStr = "";
        //生成下载字符串
        for(int i=0;i<count;i++){
            String column_name = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_NAME)).get(i);
            String column_name_tf = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_NAME_TF)).get(i);
            String column_comment = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT)).get(i);
            String column_comment_all = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT_ALL)).get(i);
            JSONObject column_comment_json = (JSONObject)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT_JSON)).get(i);
            String type = GeneratorJSONProperties.DEFAULT_type;//设置为默认的Type
            try{
                type = column_comment_json.getString(GeneratorJSONProperties.PATH_type);
            }catch (Exception e){
                //e.printStackTrace();
            }
            String power = GeneratorJSONProperties.DEFAULT_power;//设置为默认的权限
            try{
                JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                power = attr.getString(GeneratorJSONProperties.PATH_power);
            }catch (Exception e){
                //e.printStackTrace();
            }
            //如果权限中包含“允许作为查询条件”
            if(power.indexOf("query-result:Y")>=0){
                if(StringUtils.isNotEmpty(downloadStr)){
                    downloadStr+=",";
                }
                downloadStr+=column_name_tf+":"+column_comment;
            }
        }
        sb.append("                                <button type=\"button\" class=\"btn btn-info searchBtn\" onclick=\"search"+cleanentityClassName+"('','download','download.xls','"
                +downloadStr
                +"')\">下载</button>").append("\r\n");


        sb.append("                            </div>").append("\r\n");
        sb.append("                        </div>").append("\r\n");

        sb.append("                    </div>").append("\r\n");
        //行-end
        //此处需要针对数据类型添加查询条件--end
        sb.append("                </form>").append("\r\n");
        sb.append("            </div>").append("\r\n");
        sb.append("").append("\r\n");
        //头部box-header结束

        //查询结果-box-body开始
        sb.append("            <div class=\"box-body table-responsive\">").append("\r\n");
        sb.append("                <div style=\"width:50px;margin:10px 0px;\"><button class=\"btn btn-block btn-success\" data-toggle=\"modal\" data-target=\"#add"+cleanentityClassName+"\">添加</button></div>").append("\r\n");
        sb.append("                <table id=\""+cleanentityClassNameFirstSmall+"Tbl\" class=\"table table-bordered\">").append("\r\n");
        sb.append("                    <tr id=\""+cleanentityClassNameFirstSmall+"TR_FIRST\">").append("\r\n");
        sb.append("                        <th></th>").append("\r\n");
        sb.append("                        <th>序号</th>").append("\r\n");

        for(int i=0;i<count;i++){
            String column_name = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_NAME)).get(i);
            String column_name_tf = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_NAME_TF)).get(i);
            String column_comment = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT)).get(i);
            String column_comment_all = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT_ALL)).get(i);
            JSONObject column_comment_json = (JSONObject)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT_JSON)).get(i);
            String type = GeneratorJSONProperties.DEFAULT_type;//设置为默认的Type
            try{
                type = column_comment_json.getString(GeneratorJSONProperties.PATH_type);
            }catch (Exception e){
                //e.printStackTrace();
            }
            String power = GeneratorJSONProperties.DEFAULT_power;//设置为默认的权限
            try{
                JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                power = attr.getString(GeneratorJSONProperties.PATH_power);
            }catch (Exception e){
                //e.printStackTrace();
            }
            //如果权限中包含“允许作为查询条件”
            if(power.indexOf("query-result:Y")>=0){
                //列-作为查询条件-start
                sb.append("                        <th>"+column_comment+"</th>").append("\r\n");
                //列-作为查询条件-end
            }
        }
        sb.append("                        <th>操作</th>").append("\r\n");
        sb.append("                    </tr>").append("\r\n");
        sb.append("                </table>").append("\r\n");
        sb.append("                <div id=\"page1\"></div>").append("\r\n");
        sb.append("            </div>").append("\r\n");
        sb.append("            <!-- /.box-body -->").append("\r\n");
        //查询结果-box-body结束

        //分页-start
        sb.append("").append("\r\n");
        sb.append("            <!--分页 start-->").append("\r\n");
        sb.append("            <div id=\"query"+cleanentityClassName+"_fy\" style=\"width: 100%;\" class=\"gmPagination gmPagination-mini\">").append("\r\n");
        sb.append("                <div style=\"float:left;margin: 10px;\">").append("\r\n");
        sb.append("                    <select id=\"query"+cleanentityClassName+"pageSize\">").append("\r\n");
        sb.append("                        <option selected=\"selected\">10</option>").append("\r\n");
        sb.append("                        <option>20</option>").append("\r\n");
        sb.append("                        <option>50</option>").append("\r\n");
        sb.append("                    </select>").append("\r\n");
        sb.append("                </div>").append("\r\n");
        sb.append("                <div style=\"margin: 10px; float: right\" class=\"pager clearfix\"\tid=\"commonPager\">").append("\r\n");
        sb.append("                    <a href=\"javascript:void(0);\" class=\"prev disable\">&nbsp;&lt;<s\tclass=\"icon-prev\"></s><i></i></a> ").append("\r\n");
        sb.append("                    <span class=\"cur\">1</span> <a href=\"javascript:void(0);\" class=\"next disable\">&gt;<s class=\"icon-next\"></s><i></i></a> ").append("\r\n");
        sb.append("                    <label class=\"txt-wrap\"\tfor=\"pagenum\">到<input type=\"text\" value=\"1\" bnum=\"0\" class=\"txt\" id=\"pNum\">页</label> ").append("\r\n");
        sb.append("                    <a class=\"btn\" zdx=\"nBtn\" href=\"javascript:void(0)\">确定</a>").append("\r\n");
        sb.append("                </div>").append("\r\n");
        sb.append("            </div>").append("\r\n");
        sb.append("            <!--分页 end-->").append("\r\n");
        sb.append("").append("\r\n");
        //分页-end


        sb.append("        </div>").append("\r\n");//box-DIV的结尾
        sb.append("        <!-- /.box -->").append("\r\n");
        sb.append("    </section>").append("\r\n");
        sb.append("</div>").append("\r\n");
        sb.append("<div>").append("\r\n");
        sb.append("    <input type=\"hidden\" id=\"query"+cleanentityClassName+"currentPage\" />").append("\r\n");
        sb.append("    <input type=\"hidden\" id=\"query"+cleanentityClassName+"totalPage\" />").append("\r\n");
        sb.append("</div>").append("\r\n");


        sb.append("<script type=\"text/javascript\" src=\"${props('resourceUrl')}/js/"+ftldirectory+"/"+ftldirectory+".js\"></script>").append("\r\n");
        sb.append("</#macro>").append("\r\n");
        sb.append("<style>").append("\r\n");
        sb.append("    #"+cleanentityClassNameFirstSmall+"Tbl tr .btn{display:left;margin-right:5px;padding:2.5px 6px;}").append("\r\n");
        sb.append("    .title{padding-right:0px;text-align:right;margin:0px;height:34px;line-height:34px;}").append("\r\n");
        sb.append("    .redFont{color:red;display:inline-block;width:15px;text-align:center;}").append("\r\n");
        sb.append("    .modal-dialog{margin:165px auto;}").append("\r\n");
        sb.append("</style>").append("\r\n");

        pw.println(sb.toString());
        pw.close();
    }

    public void exec_create_002_ADDPAGE(Context c) throws Exception {
        //创建文件夹
        if(!FileUtils.mkdirs((String) c.get(Context.PATH_FTL))){
            throw new Exception("文件夹["+(String)c.get(Context.PATH_FTL)+"]创建不成功");
        }
        //准备数据
        String tableName = (String)c.get(Context.CURR_TABLE);//tbl_user_info
        String entityClassName = FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(tableName));//TblUserInfo
        String cleanentityClassName = FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(tableName));//UserInfo
        //去掉Tbl的头部
        if(cleanentityClassName.startsWith("Tbl")){
            cleanentityClassName = cleanentityClassName.substring(3);
        }
        entityClassName = "Union"+entityClassName;
        cleanentityClassName = "Union"+cleanentityClassName;

        String cleanentityClassNameFirstSmall = FormatUtils.firstSmall(cleanentityClassName);//userInfo
        String ftldirectory = cleanentityClassName.toLowerCase();//userinfo
        //创建子文件夹
        if(!FileUtils.mkdirs((String) c.get(Context.PATH_FTL) + File.separator + ftldirectory)){
            throw new Exception("文件夹["+(String) c.get(Context.PATH_FTL) + File.separator + ftldirectory + "]创建不成功");
        }
        String ftlname = "add"+cleanentityClassName;
        String fileName = ftlname+".ftl";//文件名与父路径名相同
        File filePath = new File((String)c.get(Context.PATH_FTL) + File.separator+ftldirectory+File.separator+fileName);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath),(String)c.get(Context.FILE_CHARSET)));

        //准备内容
        StringBuilder sb = new StringBuilder();//主体
        StringBuilder sb_script = new StringBuilder();//js初始化操作
        StringBuilder sb_script_validate = new StringBuilder();//js校验函数
        String hasSlaveTables = (String)c.get(Context.HAS_SLAVE_TABLES);
        String hasSubTable = (String)c.get(Context.HAS_SUB_TABLE);
        sb.append("<#import \"/component/register.ftl\" as  register/>").append("\r\n");
        sb.append("").append("\r\n");
        sb.append("<#macro add"+cleanentityClassName+"Html>").append("\r\n");
        sb.append("    <div class=\"modal fade\" id=\"add"+cleanentityClassName+"\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">").append("\r\n");
        sb.append("        <div class=\"modal-dialog\">").append("\r\n");
        sb.append("            <div class=\"modal-content\">").append("\r\n");
        sb.append("                <form id=\"validateAdd"+cleanentityClassName+"Form\" method=\"post\" class=\"form-horizontal\">").append("\r\n");
        sb.append("                    <div class=\"modal-header\">").append("\r\n");
        sb.append("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>").append("\r\n");
        sb.append("                        <h4 class=\"modal-title\" id=\"myModalLabel\">新增"+((String)c.get(Context.CURR_TABLE_COMMENT))+"</h4>").append("\r\n");
        sb.append("                    </div>").append("\r\n");
        sb.append("                    <div class=\"modal-body\">").append("\r\n");

        //字段遍历开始
        int count = (Integer)c.get(Context.CURR_TABLE_COLUMN_COUNT);//字段总数
        for(int i=0;i<count;i++){
            String column_name = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_NAME)).get(i);
            String column_name_tf = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_NAME_TF)).get(i);
            String column_comment = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT)).get(i);
            String column_comment_all = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT_ALL)).get(i);
            JSONObject column_comment_json = (JSONObject)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT_JSON)).get(i);
            String type = GeneratorJSONProperties.DEFAULT_type;//设置为默认的Type
            try{
                type = column_comment_json.getString(GeneratorJSONProperties.PATH_type);
            }catch (Exception e){
                //e.printStackTrace();
            }
            String power = GeneratorJSONProperties.DEFAULT_power;//设置为默认的权限
            try{
                JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                power = attr.getString(GeneratorJSONProperties.PATH_power);
            }catch (Exception e){
                //e.printStackTrace();
            }
            //如果权限中包含“允许作为增加”
            if(power.indexOf("add:Y")>=0){
                //列-作为查询条件-start
                if(type.equals(GeneratorJSONProperties.FIELD_type_input)){
                    sb.append("                        <div class=\"form-group\">").append("\r\n");
                    sb.append("                            <label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-lg-9\">").append("\r\n");
                    sb.append("                                <input id=\""+column_name_tf+"1\" name=\""+column_name_tf+"1\"  class=\"form-control\" placeholder=\""+column_comment+"\" type=\"text\"/>").append("\r\n");
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_date)){
                    sb.append("                        <div class=\"form-group\">").append("\r\n");
                    sb.append("                            <label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-lg-9\">").append("\r\n");
                    sb.append("                                <input id=\""+column_name_tf+"1\" name=\""+column_name_tf+"1\"  class=\"form-control\" placeholder=\""+column_comment+"\" type=\"text\"/>").append("\r\n");
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_datetime)){
                    sb.append("                        <div class=\"form-group\">").append("\r\n");
                    sb.append("                            <label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-lg-9\">").append("\r\n");
                    sb.append("                                <input id=\""+column_name_tf+"1\" name=\""+column_name_tf+"1\"  class=\"form-control\" placeholder=\""+column_comment+"\" type=\"text\"/>").append("\r\n");
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_select)){
                    sb.append("                        <div class=\"form-group\">").append("\r\n");
                    sb.append("                            <label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-lg-9\">").append("\r\n");
                    sb.append("                                <select class=\"form-control select2\" id=\""+column_name_tf+"1\" name=\""+column_name_tf+"1\">").append("\r\n");
                    //是否有全部查询选择
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object needAll_o = attr.get(GeneratorJSONProperties.PATH_needAll);
                        if(needAll_o!=null  && ((String)needAll_o).trim().equals("true")){
                            sb.append("                                    <option selected=\"selected\" value=\"\">全部</option>").append("\r\n");
                        }
                    }catch (Exception e){
                        //e.printStackTrace();
                        System.out.println("tablename["+tableName+"],columnName["+column_name+"],columnComment_ALL["+column_comment_all+"]--解析SELECT是否含有全部查询按钮needAll异常");
                    }
                    //静态模式
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object options_o = attr.get(GeneratorJSONProperties.PATH_options);
                        if(options_o!=null){
                            sb.append("                                    <#--静态模式-start-->").append("\r\n");
                            sb.append("                                    <#assign options="+((JSONObject)options_o).toString()+"/>").append("\r\n");
                            sb.append("                                    <#list options?keys as key >").append("\r\n");
                            sb.append("                                        <option value=\"${key}\">${options[key]}</option>").append("\r\n");
                            sb.append("                                    </#list>").append("\r\n");
                            sb.append("                                    <#--静态模式- end -->").append("\r\n");
                        }
                    }catch (Exception e){
                        //e.printStackTrace();
                        System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析SELECT-options异常");
                    }
                    //动态模式
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object l1Code = attr.get(GeneratorJSONProperties.PATH_l1Code);
                        Object l2Code = attr.get(GeneratorJSONProperties.PATH_l2Code);
                        if(l1Code!=null&&l2Code!=null){
                            sb.append("                                    <#--动态模式-start-->").append("\r\n");
                            sb.append("                                    <#assign options=dicList['"+l1Code+","+l2Code+"']/>").append("\r\n");
                            sb.append("                                    <#list options as item >").append("\r\n");
                            sb.append("                                        <option value=\"${item.codeParam}\">${item.codeValue}</option>").append("\r\n");
                            sb.append("                                    </#list>").append("\r\n");
                            sb.append("                                    <#--动态模式- end -->").append("\r\n");
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析SELECT-l1Code-l2Code异常");
                    }
                    sb.append("                                </select>").append("\r\n");
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_radio)){
                    sb.append("                        <div class=\"form-group\">").append("\r\n");
                    sb.append("                            <label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-lg-9\">").append("\r\n");
                    //静态模式
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object options_o = attr.get(GeneratorJSONProperties.PATH_options);
                        if(options_o!=null){
                            sb.append("                                <#--静态模式-start-->").append("\r\n");
                            sb.append("                                <#assign options="+((JSONObject)options_o).toString()+"/>").append("\r\n");
                            sb.append("                                <#list options?keys as key >").append("\r\n");
                            sb.append("                                <label class=\"radio-inline\">").append("\r\n");
                            sb.append("                                    <input type=\"radio\" id=\""+column_name_tf+"1_${key}\" name=\""+column_name_tf+"1\" value=\"${key}\">${options[key]}").append("\r\n");
                            sb.append("                                </label>").append("\r\n");
                            sb.append("                                </#list>").append("\r\n");
                            sb.append("                                <#--静态模式- end -->").append("\r\n");
                        }
                    }catch (Exception e){
                        //e.printStackTrace();
                        System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析radio-options异常");
                    }
                    //动态模式
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object l1Code = attr.get(GeneratorJSONProperties.PATH_l1Code);
                        Object l2Code = attr.get(GeneratorJSONProperties.PATH_l2Code);
                        if(l1Code!=null&&l2Code!=null){
                            sb.append("                                <#--动态模式-start-->").append("\r\n");
                            sb.append("                                <#assign options=dicList['"+l1Code+","+l2Code+"']/>").append("\r\n");
                            sb.append("                                <#list options as item >").append("\r\n");
                            sb.append("                                <label class=\"radio-inline\">").append("\r\n");
                            sb.append("                                    <input type=\"radio\" id=\""+column_name_tf+"1_${item.codeParam}\" name=\""+column_name_tf+"1\" value=\"${item.codeParam}\">${item.codeValue}").append("\r\n");
                            sb.append("                                </label>").append("\r\n");
                            sb.append("                                </#list>").append("\r\n");
                            sb.append("                                <#--动态模式- end -->").append("\r\n");
                        }
                    }catch (Exception e){
                        //e.printStackTrace();
                        System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析radio-l1Code-l2Code异常");
                    }
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_checkbox)){
                    //静态模式
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object options_o = attr.get(GeneratorJSONProperties.PATH_options);
                        if(options_o!=null){
                            sb.append("                        <#--静态模式-start-->").append("\r\n");
                            sb.append("                        <#assign options="+((JSONArray)options_o).toString()+"/>").append("\r\n");
                            sb.append("                        <@register.checkbox form=\"validateAdd"+cleanentityClassName+"Form\" name=\""+column_name_tf+"1\" label=\""+column_comment+"\" options=options value=\"\"").append("\r\n");
                            sb.append("                        class1=\"form-group\" " +
                                    "class2=\"col-lg-3 title\" " +
                                    "class3=\"col-lg-9\" " +
                                    "class4=\"checkbox-inline\" " +
                                    "class5=\"inline1\" " +
                                    "readOnly=\"false\"/>").append("\r\n");
                            sb.append("                        <#--静态模式- end -->").append("\r\n");
                        }
                    }catch (Exception e){
                        //e.printStackTrace();
                        System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析checkbox-options异常");
                    }
                    //动态模式
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object l1Code = attr.get(GeneratorJSONProperties.PATH_l1Code);
                        Object l2Code = attr.get(GeneratorJSONProperties.PATH_l2Code);
                        if(l1Code!=null&&l2Code!=null){
                            sb.append("                        <#--动态模式-start-->").append("\r\n");
                            sb.append("                        <#assign options=dicCheckbox['"+l1Code+","+l2Code+"']/>").append("\r\n");
                            sb.append("                        <@register.checkbox form=\"validateAdd"+cleanentityClassName+"Form\" name=\""+column_name_tf+"1\" label=\""+column_comment+"\" options=options value=\"\"").append("\r\n");
                            sb.append("                        class1=\"form-group\" " +
                                    "class2=\"col-lg-3 title\" " +
                                    "class3=\"col-lg-9\" " +
                                    "class4=\"checkbox-inline\" " +
                                    "class5=\"inline1\" " +
                                    "readOnly=\"false\"/>").append("\r\n");
                            sb.append("                        <#--动态模式- end -->").append("\r\n");
                        }
                    }catch (Exception e){
                        //e.printStackTrace();
                        System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析checkbox-l1Code-l2Code异常");
                    }
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_textarea)){
                    sb.append("                        <div class=\"form-group\">").append("\r\n");
                    sb.append("                            <label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-lg-9\">").append("\r\n");
                    sb.append("                                <textarea id=\""+column_name_tf+"1\" name=\""+column_name_tf+"1\"  class=\"form-control\" placeholder=\""+column_comment+"\" type=\"text\"></textarea>").append("\r\n");
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_file)){
                    sb.append("                        <#assign options=\"1111\"/>").append("\r\n");
                    sb.append("                        <@register.fileupdownload form=\"validateAdd"+cleanentityClassName+"Form\" name=\""+column_name_tf+"1\" label=\""+column_comment+"\" options=options value=\"\"").append("\r\n");
                    sb.append("                        need=\"true\" upload_base_path=\"/file/upLoad.dhtml\" download_base_path=\"/file/downLoad.dhtml\" fileDesc=\""+cleanentityClassName+"-"+column_name_tf+"-"+column_comment+"\"").append("\r\n");
                    sb.append("                        businessType=\"010\" businessNo=\"010\" class1=\"form-group\" class2=\"col-lg-3 title\" class3=\"col-lg-9\" class4=\"checkbox-inline\" class5=\"inline1\" readOnly=\"false\"/>").append("\r\n");
                }
            }
        }
        //字段遍历结束
        sb.append("                    </div>").append("\r\n");

        if(hasSubTable.equalsIgnoreCase("true")){
            //如果有子表
            sb.append("                    <#--添加子表信息-->").append("\r\n");
            sb.append("                    <div style=\"width:108px;margin:10px 0px;\"><button type=\"button\" class=\"btn btn-block btn-success\" data-toggle=\"modal\" onclick=\"add"+cleanentityClassName+"Sub();\">添加子表信息</button></div>").append("\r\n");
            sb.append("                    <div id=\"subContent1\" class=\"subContent\">").append("\r\n");
            sb.append("                        <div class=\"subContentScoll\"></div>").append("\r\n");
            sb.append("                    </div>").append("\r\n");
        }

        sb.append("                    <div class=\"modal-footer\">").append("\r\n");
        sb.append("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭</button>").append("\r\n");
        sb.append("                        <button type=\"submit\" class=\"btn btn-primary\">提交</button>").append("\r\n");
        sb.append("                    </div>").append("\r\n");
        sb.append("                </form>").append("\r\n");
        sb.append("            </div>").append("\r\n");
        sb.append("        </div>").append("\r\n");
        sb.append("    </div>").append("\r\n");
        //##ADD页面的js函数
        if(hasSubTable.equalsIgnoreCase("true")) {
            sb.append("    <script type=\"text/javascript\">").append("\r\n");
            sb.append("        function add" + cleanentityClassName + "Sub(){").append("\r\n");
            sb.append("            var subNum = $(\"#validateAdd" + cleanentityClassName + "Form .sub1_\").length;").append("\r\n");
            sb.append("            var divStr = '<div id=\"sub1_'+subNum+'\" class=\"sub1_ sub_\" subNum=\"'+subNum+'\">';").append("\r\n");
            sb.append("                divStr+='<div class=\"modal-body addList\">';").append("\r\n");
            sb.append("                    divStr+='<div class=\"form-group closebutton\">';").append("\r\n");
            sb.append("                        divStr+='<label class=\"col-lg-3 title\"></label>';").append("\r\n");
            sb.append("                        divStr+='<div class=\"col-lg-9\">';").append("\r\n");
            sb.append("                            divStr+='<button type=\"button\" class=\"close\" onclick=colseSub(\"validateAdd" + cleanentityClassName + "Form\",\"sub1_'+subNum+'\")>&times;</button>';").append("\r\n");
            sb.append("                        divStr+='</div>';").append("\r\n");
            sb.append("                    divStr+='</div>';").append("\r\n");
            //添加子表开始
            //字段遍历开始
            int count_sub = (Integer) c.get(Context.CURR_SUB_TABLE_COLUMN_COUNT);//字段总数
            for (int i = 0; i < count_sub; i++) {
                String column_name = (String) ((List) c.get(Context.CURR_SUB_TABLE_COLUMNS_NAME)).get(i);
                String column_name_tf = (String) ((List) c.get(Context.CURR_SUB_TABLE_COLUMNS_NAME_TF)).get(i);
                String column_comment = (String) ((List) c.get(Context.CURR_SUB_TABLE_COLUMNS_COMMENT)).get(i);
                String column_comment_all = (String) ((List) c.get(Context.CURR_SUB_TABLE_COLUMNS_COMMENT_ALL)).get(i);
                JSONObject column_comment_json = (JSONObject) ((List) c.get(Context.CURR_SUB_TABLE_COLUMNS_COMMENT_JSON)).get(i);
                String type = GeneratorJSONProperties.DEFAULT_type;//设置为默认的Type
                try {
                    type = column_comment_json.getString(GeneratorJSONProperties.PATH_type);
                } catch (Exception e) {
                    //e.printStackTrace();
                }
                String power = GeneratorJSONProperties.DEFAULT_power;//设置为默认的权限
                try {
                    JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                    power = attr.getString(GeneratorJSONProperties.PATH_power);
                } catch (Exception e) {
                    //e.printStackTrace();
                }
                String validators = GeneratorJSONProperties.DEFAULT_validators;
                try {
                    Object validate_comment = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_validate);
                    if (validate_comment != null && !((JSONObject) validate_comment).isNullObject()) {
                        validators = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_validate).toString();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析validate异常");
                }
                //如果权限中包含“允许作为增加”
                if (power.indexOf("add:Y") >= 0) {
                    //列-作为查询条件-start
                    if (type.equals(GeneratorJSONProperties.FIELD_type_input)) {
                        sb.append("                    divStr+='<div class=\"form-group\">';").append("\r\n");
                        sb.append("                        divStr+='<label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>" + column_comment + "：</label>';").append("\r\n");
                        sb.append("                        divStr+='<div class=\"col-lg-9\">';").append("\r\n");
                        sb.append("                            divStr+='<input id=\"" + column_name_tf + "1_'+subNum+'\" name=\"" + column_name_tf + "1_'+subNum+'\"  class=\"form-control\" placeholder=\"" + column_comment + "\" type=\"text\"/>';").append("\r\n");
                        sb.append("                        divStr+='</div>';").append("\r\n");
                        sb.append("                    divStr+='</div>';").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_date)) {
                        sb.append("                    divStr+='<div class=\"form-group\">';").append("\r\n");
                        sb.append("                        divStr+='<label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>" + column_comment + "：</label>';").append("\r\n");
                        sb.append("                        divStr+='<div class=\"col-lg-9\">';").append("\r\n");
                        sb.append("                            divStr+='<input id=\"" + column_name_tf + "1_'+subNum+'\" name=\"" + column_name_tf + "1_'+subNum+'\"  class=\"form-control\" placeholder=\"" + column_comment + "\" type=\"text\"/>';").append("\r\n");
                        sb.append("                        divStr+='</div>';").append("\r\n");
                        sb.append("                    divStr+='</div>';").append("\r\n");
                        sb_script.append("            $('#validateAdd" + cleanentityClassName + "Form #" + column_name_tf + "1_'+subNum).ECalendar({").append("\r\n");
                        sb_script.append("                type:\"date\",").append("\r\n");
                        sb_script.append("                stamp : false,").append("\r\n");
                        sb_script.append("                offset:[0,2],").append("\r\n");
                        sb_script.append("                format:\"yyyy-mm-dd\",").append("\r\n");
                        sb_script.append("                skin:1,").append("\r\n");
                        sb_script.append("                callback:function(v,e){").append("\r\n");
                        sb_script.append("                    $(\"#validateAdd" + cleanentityClassName + "Form\").data('bootstrapValidator').updateStatus(\"" + column_name_tf + "1_\"+subNum,\"NOT_VALIDATED\",null);").append("\r\n");
                        sb_script.append("                    $(\"#validateAdd" + cleanentityClassName + "Form\").data('bootstrapValidator').validateField(\"" + column_name_tf + "1_\"+subNum);").append("\r\n");
                        sb_script.append("                }").append("\r\n");
                        sb_script.append("            });").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_datetime)) {
                        sb.append("                    divStr+='<div class=\"form-group\">';").append("\r\n");
                        sb.append("                        divStr+='<label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>" + column_comment + "：</label>';").append("\r\n");
                        sb.append("                        divStr+='<div class=\"col-lg-9\">';").append("\r\n");
                        sb.append("                            divStr+='<input id=\"" + column_name_tf + "1_'+subNum+'\" name=\"" + column_name_tf + "1_'+subNum+'\"  class=\"form-control\" placeholder=\"" + column_comment + "\" type=\"text\"/>';").append("\r\n");
                        sb.append("                        divStr+='</div>';").append("\r\n");
                        sb.append("                    divStr+='</div>';").append("\r\n");
                        sb_script.append("            $('#validateAdd" + cleanentityClassName + "Form #" + column_name_tf + "1_'+subNum).ECalendar({").append("\r\n");
                        sb_script.append("                type:\"time\",").append("\r\n");
                        sb_script.append("                stamp : false,").append("\r\n");
                        sb_script.append("                offset:[0,2],").append("\r\n");
                        sb_script.append("                format:\"yyyy-mm-dd hh:ii:ss\",").append("\r\n");
                        sb_script.append("                skin:1,").append("\r\n");
                        sb_script.append("                step:1,").append("\r\n");
                        sb_script.append("                callback:function(v,e){").append("\r\n");
                        sb_script.append("                    $(\"#validateAdd" + cleanentityClassName + "Form\").data('bootstrapValidator').updateStatus(\"" + column_name_tf + "1_\"+subNum,\"NOT_VALIDATED\",null);").append("\r\n");
                        sb_script.append("                    $(\"#validateAdd" + cleanentityClassName + "Form\").data('bootstrapValidator').validateField(\"" + column_name_tf + "1_\"+subNum);").append("\r\n");
                        sb_script.append("                }").append("\r\n");
                        sb_script.append("            });").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_select)) {
                        sb.append("                    divStr+='<div class=\"form-group\">';").append("\r\n");
                        sb.append("                        divStr+='<label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>" + column_comment + "：</label>';").append("\r\n");
                        sb.append("                        divStr+='<div class=\"col-lg-9\">';").append("\r\n");
                        sb.append("                            divStr+='<select class=\"form-control select2\" id=\"" + column_name_tf + "1_'+subNum+'\" name=\"" + column_name_tf + "1_'+subNum+'\">';").append("\r\n");
                        //静态模式
                        try {
                            JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                            Object options_o = attr.get(GeneratorJSONProperties.PATH_options);
                            if (options_o != null) {
                                sb.append("                                divStr+='<#assign options=" + ((JSONObject) options_o).toString() + "/>';").append("\r\n");
                                sb.append("                                divStr+='<#list options?keys as key >';").append("\r\n");
                                sb.append("                                    divStr+='<option value=\"${key}\">${options[key]}</option>';").append("\r\n");
                                sb.append("                                divStr+='</#list>';").append("\r\n");
                            }
                        } catch (Exception e) {
                            //e.printStackTrace();
                            System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析SELECT-options异常");
                        }
                        //动态模式
                        try {
                            JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                            Object l1Code = attr.get(GeneratorJSONProperties.PATH_l1Code);
                            Object l2Code = attr.get(GeneratorJSONProperties.PATH_l2Code);
                            if (l1Code != null && l2Code != null) {
                                //TODO  这种写法很不正规，属于“偶然碰对的写法”，将来需要优化
                                sb.append("                                divStr+='<#assign options=dicList['" + l1Code + "," + l2Code + "']/>';").append("\r\n");
                                sb.append("                                divStr+='<#list options as item >';").append("\r\n");
                                sb.append("                                    divStr+='<option value=\"${item.codeParam}\">${item.codeValue}</option>';").append("\r\n");
                                sb.append("                                divStr+='</#list>';").append("\r\n");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析SELECT-l1Code-l2Code异常");
                        }
                        sb.append("                            divStr+='</select>';").append("\r\n");
                        sb.append("                        divStr+='</div>';").append("\r\n");
                        sb.append("                    divStr+='</div>';").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_radio)) {
                        sb.append("                    divStr+='<div class=\"form-group addqure\">';").append("\r\n");
                        sb.append("                        divStr+='<label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>" + column_comment + "：</label>';").append("\r\n");
                        sb.append("                        divStr+='<div class=\"col-lg-9\">';").append("\r\n");
                        //静态模式
                        try {
                            JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                            Object options_o = attr.get(GeneratorJSONProperties.PATH_options);
                            if (options_o != null) {
                                sb.append("                            divStr+='<#assign options=" + ((JSONObject) options_o).toString() + "/>';").append("\r\n");
                                sb.append("                            divStr+='<#list options?keys as key >';").append("\r\n");
                                sb.append("                                divStr+='<label class=\"radio-inline\">';").append("\r\n");
                                sb.append("                                divStr+='<input type=\"radio\" id=\"" + column_name_tf + "1_'+subNum+'_${key}\" name=\"" + column_name_tf + "1_'+subNum+'\" value=\"${key}\">${options[key]}';").append("\r\n");
                                sb.append("                                divStr+='</label>';").append("\r\n");
                                sb.append("                            divStr+='</#list>';").append("\r\n");
                            }
                        } catch (Exception e) {
                            //e.printStackTrace();
                            System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析radio-options异常");
                        }
                        //动态模式
                        try {
                            JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                            Object l1Code = attr.get(GeneratorJSONProperties.PATH_l1Code);
                            Object l2Code = attr.get(GeneratorJSONProperties.PATH_l2Code);
                            if (l1Code != null && l2Code != null) {
                                sb.append("                            divStr+='<#assign options=dicList[\"" + l1Code + "," + l2Code + "\"]/>';").append("\r\n");
                                sb.append("                            divStr+='<#list options as item >';").append("\r\n");
                                sb.append("                                divStr+='<label class=\"radio-inline\">';").append("\r\n");
                                sb.append("                                divStr+='<input type=\"radio\" id=\"" + column_name_tf + "1_'+subNum+'_${item.codeParam}\" name=\"" + column_name_tf + "1_'+subNum+'\" value=\"${item.codeParam}\">${item.codeValue}';").append("\r\n");
                                sb.append("                                divStr+='</label>';").append("\r\n");
                                sb.append("                            divStr+='</#list>';").append("\r\n");
                            }
                        } catch (Exception e) {
                            //e.printStackTrace();
                            System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析radio-l1Code-l2Code异常");
                        }
                        sb.append("                        divStr+='</div>';").append("\r\n");
                        sb.append("                    divStr+='</div>';").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_checkbox)) {
                        sb.append("                    divStr+='<div class=\"form-group addqure\">';").append("\r\n");
                        sb.append("                        divStr+='<label class=\"col-lg-3 title\">" + column_comment + "：</label>';").append("\r\n");
                        sb.append("                        divStr+='<div class=\"checkbox_validateAdd" + cleanentityClassName + "Form_" + column_name_tf + "1_'+subNum+' col-lg-9\">';").append("\r\n");

                        //静态模式
                        try {
                            JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                            Object options_o = attr.get(GeneratorJSONProperties.PATH_options);
                            if (options_o != null) {
                                sb.append("                            divStr+='<#assign options=" + ((JSONArray) options_o).toString() + "/>';").append("\r\n");
                                sb.append("                            divStr+='<#assign idx=0/>';").append("\r\n");
                                sb.append("                            divStr+='<input type=\"text\" id=\"validateAdd" + cleanentityClassName + "Form_" + column_name_tf + "1_'+subNum+'\" name=\"validateAdd" + cleanentityClassName + "Form_" + column_name_tf + "1_'+subNum+'\" style=\"display:none\" value=\"\" >';").append("\r\n");
                                sb.append("                            divStr+='<#list options as item >';").append("\r\n");
                                sb.append("                                divStr+='<label class=\"checkbox-inline\">';").append("\r\n");
                                sb.append("                                    divStr+='<input type=\"checkbox\" class=\"inline1\" id=\"checkedBox_validateAdd" + cleanentityClassName + "Form_" + column_name_tf + "1_'+subNum+'_${idx}\" name=\"validateAdd" + cleanentityClassName + "Form_" + column_name_tf + "1_'+subNum+'\" value=\"${item}\" onclick=flushCheckBox2FieldVal(\"validateAdd" + cleanentityClassName + "Form\",\"" + column_name_tf + "1_'+subNum+'\")>${options[idx]}';").append("\r\n");
                                sb.append("                                divStr+='</label>';").append("\r\n");
                                sb.append("                                divStr+='<#assign idx=idx+1/>';").append("\r\n");
                                sb.append("                            divStr+='</#list>';").append("\r\n");
                            }
                        } catch (Exception e) {
                            //e.printStackTrace();
                            System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析checkbox-options异常");
                        }
                        //动态模式
                        try {
                            JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                            Object l1Code = attr.get(GeneratorJSONProperties.PATH_l1Code);
                            Object l2Code = attr.get(GeneratorJSONProperties.PATH_l2Code);
                            if (l1Code != null && l2Code != null) {
                                sb.append("                            divStr+='<#assign options=dicCheckbox[\"" + l1Code + "," + l2Code + "\"]/>';").append("\r\n");
                                sb.append("                            divStr+='<#assign idx=0/>';").append("\r\n");
                                sb.append("                            divStr+='<input type=\"text\" id=\"validateAdd" + cleanentityClassName + "Form_" + column_name_tf + "1_'+subNum+'\" name=\"validateAdd" + cleanentityClassName + "Form_" + column_name_tf + "1_'+subNum+'\" style=\"display:none\" value=\"\" >';").append("\r\n");
                                sb.append("                            divStr+='<#list options as item >';").append("\r\n");
                                sb.append("                                divStr+='<label class=\"checkbox-inline\">';").append("\r\n");
                                sb.append("                                    divStr+='<input type=\"checkbox\" class=\"inline1\" id=\"checkedBox_validateAdd" + cleanentityClassName + "Form_" + column_name_tf + "1_'+subNum+'_${idx}\" name=\"validateAdd" + cleanentityClassName + "Form_" + column_name_tf + "1_'+subNum+'\" value=\"${item}\" onclick=flushCheckBox2FieldVal(\"validateAdd" + cleanentityClassName + "Form\",\"" + column_name_tf + "1_'+subNum+'\")>${options[idx]}';").append("\r\n");
                                sb.append("                                divStr+='</label>';").append("\r\n");
                                sb.append("                                divStr+='<#assign idx=idx+1/>';").append("\r\n");
                                sb.append("                            divStr+='</#list>';").append("\r\n");
                            }
                        } catch (Exception e) {
                            //e.printStackTrace();
                            System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析checkbox-l1Code-l2Code异常");
                        }

                        sb.append("                        divStr+='</div>';").append("\r\n");
                        sb.append("                    divStr+='</div>';").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_textarea)) {
                        throw new RuntimeException("子表不允许有文本域，影响样式！");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_file)) {
                        throw new RuntimeException("子表不允许有文件，影响样式！");
                    }
                    if (!type.equals(GeneratorJSONProperties.FIELD_type_checkbox)) {
                        //非checkbox才需要validate
                        if (StringUtils.isNotEmpty(validators) && !validators.trim().equals("{}")) {
                            //如果有校验函数，则将校验函数写入,
                            sb_script_validate.append("            $(\"#validateAdd" + cleanentityClassName + "Form\").data('bootstrapValidator').addField('" + column_name_tf + "1_'+subNum,{").append("\r\n");
                            sb_script_validate.append("                validators : " + validators).append("\r\n");
                            sb_script_validate.append("            });").append("\r\n");
                        } else {
                            //如果校验函数为空或为空JSON，则写入默认校验函数
                            sb_script_validate.append("            $(\"#validateAdd" + cleanentityClassName + "Form\").data('bootstrapValidator').addField('" + column_name_tf + "1_'+subNum,{").append("\r\n");
                            sb_script_validate.append("                validators : " + GeneratorJSONProperties.DEFAULT_validators).append("\r\n");
                            sb_script_validate.append("            });").append("\r\n");
                        }
                    }
                }
            }
            sb.append("                divStr+='</div>';").append("\r\n");
            sb.append("            divStr+='</div>';").append("\r\n");
            sb.append("            $(\"#validateAdd" + cleanentityClassName + "Form #subContent1 div:first\").append(divStr);").append("\r\n");
            sb.append(sb_script).append("\r\n");
            sb.append(sb_script_validate).append("\r\n");
            sb.append("        }").append("\r\n");
            sb.append("    </script>").append("\r\n");
        }
        sb.append("    <style>").append("\r\n");
        sb.append("        <#--一下代码用于覆盖new.css中的样式-->").append("\r\n");
        sb.append("        <#--调整弹出框宽度-->").append("\r\n");
        sb.append("        #validateAdd"+cleanentityClassName+"Form .modal-content{").append("\r\n");
        sb.append("            width:800px;").append("\r\n");
        sb.append("        }").append("\r\n");
        sb.append("        <#--调整子表宽度-->").append("\r\n");
        sb.append("        #validateAdd"+cleanentityClassName+"Form .sub_ .modal-body{").append("\r\n");
        sb.append("            width:1600px;").append("\r\n");
        sb.append("        }").append("\r\n");
        sb.append("        #validateAdd"+cleanentityClassName+"Form .sub_ .modal-body .form-group{float: left;}").append("\r\n");
        sb.append("        #validateAdd"+cleanentityClassName+"Form .sub_ .addList{padding:0; padding: 0 20px;}").append("\r\n");
        sb.append("        #validateAdd"+cleanentityClassName+"Form .addList .addqure{width:14%;}").append("\r\n");
        sb.append("        #validateAdd"+cleanentityClassName+"Form .sub_ .addList .addqure .radio-inline{ width: 33%;float: left;  margin: 0;}").append("\r\n");
        sb.append("        #validateAdd"+cleanentityClassName+"Form .sub_ .addList .addqure .checkbox-inline{ width: 33%;float: left;  margin: 0;}").append("\r\n");
        sb.append("        #validateAdd"+cleanentityClassName+"Form .sub_ .addList .col-lg-9{padding:0px;}").append("\r\n");
        sb.append("    </style>").append("\r\n");

        sb.append("</#macro>").append("\r\n");
        sb.append("").append("\r\n");
        pw.println(sb.toString());
        pw.close();
    }

    public void exec_create_003_DETAILPAGE(Context c) throws Exception {
        //创建文件夹
        if(!FileUtils.mkdirs((String) c.get(Context.PATH_FTL))){
            throw new Exception("文件夹["+(String)c.get(Context.PATH_FTL)+"]创建不成功");
        }
        //准备数据
        String tableName = (String)c.get(Context.CURR_TABLE);//tbl_user_info
        String entityClassName = FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(tableName));//TblUserInfo
        String cleanentityClassName = FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(tableName));//UserInfo
        //去掉Tbl的头部
        if(cleanentityClassName.startsWith("Tbl")){
            cleanentityClassName = cleanentityClassName.substring(3);
        }
        entityClassName = "Union"+entityClassName;
        cleanentityClassName = "Union"+cleanentityClassName;

        String cleanentityClassNameFirstSmall = FormatUtils.firstSmall(cleanentityClassName);//userInfo
        String ftldirectory = cleanentityClassName.toLowerCase();//userinfo
        //创建子文件夹
        if(!FileUtils.mkdirs((String) c.get(Context.PATH_FTL) + File.separator + ftldirectory)){
            throw new Exception("文件夹["+(String) c.get(Context.PATH_FTL) + File.separator + ftldirectory + "]创建不成功");
        }
        String ftlname = "detail"+cleanentityClassName;
        //String controllerPath = FormatUtils.firstSmall(cleanentityClassName);
        //String logicClassName = cleanentityClassName + "Logic";
        //String logicVarName = FormatUtils.firstSmall(cleanentityClassName + "Logic");
        String fileName = ftlname+".ftl";//文件名与父路径名相同
        File filePath = new File((String)c.get(Context.PATH_FTL) + File.separator+ftldirectory+File.separator+fileName);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath),(String)c.get(Context.FILE_CHARSET)));

        //准备内容
        StringBuilder sb = new StringBuilder();
        String hasSlaveTables = (String)c.get(Context.HAS_SLAVE_TABLES);
        String hasSubTable = (String)c.get(Context.HAS_SUB_TABLE);
        sb.append("<#import \"/component/register.ftl\" as  register/>").append("\r\n");
        sb.append("").append("\r\n");
        sb.append("<#macro detail"+cleanentityClassName+"Html>").append("\r\n");
        sb.append("    <div class=\"modal fade\" id=\"detail"+cleanentityClassName+"\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">").append("\r\n");
        sb.append("        <div class=\"modal-dialog\">").append("\r\n");
        sb.append("            <div class=\"modal-content\">").append("\r\n");
        sb.append("                <form id=\"validateDetail"+cleanentityClassName+"Form\" method=\"post\" class=\"form-horizontal\">").append("\r\n");
        sb.append("                    <input type=\"hidden\" id=\"id_key\" name=\"id_key\" value=\"\" />").append("\r\n");
        sb.append("                    <div class=\"modal-header\">").append("\r\n");
        sb.append("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>").append("\r\n");
        sb.append("                        <h4 class=\"modal-title\" id=\"myModalLabel\">查看"+((String)c.get(Context.CURR_TABLE_COMMENT))+"</h4>").append("\r\n");
        sb.append("                    </div>").append("\r\n");
        sb.append("                    <div class=\"modal-body\">").append("\r\n");

        //字段遍历开始
        int count = (Integer)c.get(Context.CURR_TABLE_COLUMN_COUNT);//字段总数
        for(int i=0;i<count;i++){
            String column_name = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_NAME)).get(i);
            String column_name_tf = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_NAME_TF)).get(i);
            String column_comment = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT)).get(i);
            String column_comment_all = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT_ALL)).get(i);
            JSONObject column_comment_json = (JSONObject)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT_JSON)).get(i);
            String type = GeneratorJSONProperties.DEFAULT_type;//设置为默认的Type
            try{
                type = column_comment_json.getString(GeneratorJSONProperties.PATH_type);
            }catch (Exception e){
                //e.printStackTrace();
            }
            String power = GeneratorJSONProperties.DEFAULT_power;//设置为默认的权限
            try{
                JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                power = attr.getString(GeneratorJSONProperties.PATH_power);
            }catch (Exception e){
                //e.printStackTrace();
            }
            //如果权限中包含“允许作为增加”
            if(power.indexOf("detail:Y")>=0){
                //列-作为查询条件-start
                if(type.equals(GeneratorJSONProperties.FIELD_type_input)){
                    sb.append("                        <div class=\"form-group\">").append("\r\n");
                    sb.append("                            <label class=\"col-lg-3 title\">"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-lg-9\">").append("\r\n");
                    sb.append("                                <input id=\""+column_name_tf+"2\" name=\""+column_name_tf+"2\"  class=\"form-control\" placeholder=\""+column_comment+"\" type=\"text\" disabled=\"disabled\"/>").append("\r\n");
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_date)){
                    sb.append("                        <div class=\"form-group\">").append("\r\n");
                    sb.append("                            <label class=\"col-lg-3 title\">"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-lg-9\">").append("\r\n");
                    sb.append("                                <input id=\""+column_name_tf+"2\" name=\""+column_name_tf+"2\"  class=\"form-control\" placeholder=\""+column_comment+"\" type=\"text\" disabled=\"disabled\"/>").append("\r\n");
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_datetime)){
                    sb.append("                        <div class=\"form-group\">").append("\r\n");
                    sb.append("                            <label class=\"col-lg-3 title\">"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-lg-9\">").append("\r\n");
                    sb.append("                                <input id=\""+column_name_tf+"2\" name=\""+column_name_tf+"2\"  class=\"form-control\" placeholder=\""+column_comment+"\" type=\"text\" disabled=\"disabled\"/>").append("\r\n");
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_select)){
                    sb.append("                        <div class=\"form-group\">").append("\r\n");
                    sb.append("                            <label class=\"col-lg-3 title\">"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-lg-9\">").append("\r\n");
                    sb.append("                                <input id=\""+column_name_tf+"2\" name=\""+column_name_tf+"2\"  class=\"form-control\" placeholder=\""+column_comment+"\" type=\"text\" disabled=\"disabled\"/>").append("\r\n");
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_radio)){
                    sb.append("                        <div class=\"form-group\">").append("\r\n");
                    sb.append("                            <label class=\"col-lg-3 title\">"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-lg-9\">").append("\r\n");
                    sb.append("                                <input id=\""+column_name_tf+"2\" name=\""+column_name_tf+"2\"  class=\"form-control\" placeholder=\""+column_comment+"\" type=\"text\" disabled=\"disabled\"/>").append("\r\n");
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_checkbox)){
                    //静态模式
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object options_o = attr.get(GeneratorJSONProperties.PATH_options);
                        if(options_o!=null){
                            sb.append("                        <#--静态模式-start-->").append("\r\n");
                            sb.append("                        <#assign options="+((JSONArray)options_o).toString()+"/>").append("\r\n");
                            sb.append("                        <@register.checkbox form=\"validateDetail"+cleanentityClassName+"Form\" name=\""+column_name_tf+"2\" label=\""+column_comment+"\" options=options value=\"\"").append("\r\n");
                            sb.append("                        class1=\"form-group\" " +
                                    "class2=\"col-lg-3 title\" " +
                                    "class3=\"col-lg-9\" " +
                                    "class4=\"checkbox-inline\" " +
                                    "class5=\"inline1\" " +
                                    "readOnly=\"true\"/>").append("\r\n");
                            sb.append("                        <#--静态模式- end -->").append("\r\n");
                        }
                    }catch (Exception e){
                        //e.printStackTrace();
                        System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析checkbox-options异常");
                    }
                    //动态模式
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object l1Code = attr.get(GeneratorJSONProperties.PATH_l1Code);
                        Object l2Code = attr.get(GeneratorJSONProperties.PATH_l2Code);
                        if(l1Code!=null&&l2Code!=null){
                            sb.append("                        <#--动态模式-start-->").append("\r\n");
                            sb.append("                        <#assign options=dicCheckbox['"+l1Code+","+l2Code+"']/>").append("\r\n");
                            sb.append("                        <@register.checkbox form=\"validateDetail"+cleanentityClassName+"Form\" name=\""+column_name_tf+"2\" label=\""+column_comment+"\" options=options value=\"\"").append("\r\n");
                            sb.append("                        class1=\"form-group\" " +
                                    "class2=\"col-lg-3 title\" " +
                                    "class3=\"col-lg-9\" " +
                                    "class4=\"checkbox-inline\" " +
                                    "class5=\"inline1\" " +
                                    "readOnly=\"true\"/>").append("\r\n");
                            sb.append("                        <#--动态模式- end -->").append("\r\n");
                        }
                    }catch (Exception e){
                        //e.printStackTrace();
                        System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析checkbox-l1Code-l2Code异常");
                    }
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_textarea)){
                    sb.append("                        <div class=\"form-group\">").append("\r\n");
                    sb.append("                            <label class=\"col-lg-3 title\">"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-lg-9\">").append("\r\n");
                    sb.append("                                <textarea id=\""+column_name_tf+"2\" name=\""+column_name_tf+"2\"  class=\"form-control\" placeholder=\""+column_comment+"\" type=\"text\" disabled=\"disabled\"></textarea>").append("\r\n");
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_file)){
                    sb.append("                        <#assign options=\"0001\"/>").append("\r\n");
                    sb.append("                        <@register.fileupdownload form=\"validateDetail"+cleanentityClassName+"Form\" name=\""+column_name_tf+"2\" label=\""+column_comment+"\" options=options value=\"\"").append("\r\n");
                    sb.append("                        need=\"true\" upload_base_path=\"/file/upLoad.dhtml\" download_base_path=\"/file/downLoad.dhtml\" fileDesc=\""+cleanentityClassName+"-"+column_name_tf+"-"+column_comment+"\"").append("\r\n");
                    sb.append("                        businessType=\"010\" businessNo=\"010\" class1=\"form-group\" class2=\"col-lg-3 title\" class3=\"col-lg-9\" class4=\"checkbox-inline\" class5=\"inline1\" readOnly=\"false\"/>").append("\r\n");
                }
            }
        }
        //字段遍历结束

        sb.append("                    </div>").append("\r\n");

        if(hasSubTable.equalsIgnoreCase("true")) {
            sb.append("                    <div class=\"modal-header\">").append("\r\n");
            sb.append("                        <h4 class=\"modal-title\" id=\"myModalLabel\">查看联表查询DEMO-子表</h4>").append("\r\n");
            sb.append("                    </div>").append("\r\n");
            sb.append("                    <div id=\"subContent2\" class=\"subContent\">").append("\r\n");
            sb.append("                        <div class=\"subContentScoll\">").append("\r\n");
            sb.append("                        </div>").append("\r\n");
            sb.append("                    </div>").append("\r\n");
        }

        sb.append("                    <div class=\"modal-footer\">").append("\r\n");
        sb.append("                        <button type=\"button\" class=\"btn btn-default\" onclick =\"closeModel()\" data-dismiss=\"modal\">关闭</button>").append("\r\n");
        sb.append("                    </div>").append("\r\n");
        sb.append("                </form>").append("\r\n");
        sb.append("            </div>").append("\r\n");
        sb.append("        </div>").append("\r\n");
        sb.append("    </div>").append("\r\n");


        //##DETAIL页面的js函数
        if(hasSubTable.equalsIgnoreCase("true")) {
            sb.append("    <script type=\"text/javascript\">").append("\r\n");
            sb.append("        function detail" + cleanentityClassName + "Sub(type){").append("\r\n");
            sb.append("            var subNum = $(\"#validateDetail" + cleanentityClassName + "Form .sub2_\").length;").append("\r\n");
            sb.append("            var divStr = '<div id=\"sub2_'+subNum+'\" class=\"sub2_ sub_\" subNum=\"'+subNum+'\">';").append("\r\n");
            sb.append("                divStr+='<div class=\"modal-body addList\">';").append("\r\n");
            //添加子表开始
            //字段遍历开始
            int count_sub = (Integer) c.get(Context.CURR_SUB_TABLE_COLUMN_COUNT);//字段总数
            for (int i = 0; i < count_sub; i++) {
                String column_name = (String) ((List) c.get(Context.CURR_SUB_TABLE_COLUMNS_NAME)).get(i);
                String column_name_tf = (String) ((List) c.get(Context.CURR_SUB_TABLE_COLUMNS_NAME_TF)).get(i);
                String column_comment = (String) ((List) c.get(Context.CURR_SUB_TABLE_COLUMNS_COMMENT)).get(i);
                String column_comment_all = (String) ((List) c.get(Context.CURR_SUB_TABLE_COLUMNS_COMMENT_ALL)).get(i);
                JSONObject column_comment_json = (JSONObject) ((List) c.get(Context.CURR_SUB_TABLE_COLUMNS_COMMENT_JSON)).get(i);
                String type = GeneratorJSONProperties.DEFAULT_type;//设置为默认的Type
                try {
                    type = column_comment_json.getString(GeneratorJSONProperties.PATH_type);
                } catch (Exception e) {
                    //e.printStackTrace();
                }
                String power = GeneratorJSONProperties.DEFAULT_power;//设置为默认的权限
                try {
                    JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                    power = attr.getString(GeneratorJSONProperties.PATH_power);
                } catch (Exception e) {
                    //e.printStackTrace();
                }
                String validators = GeneratorJSONProperties.DEFAULT_validators;
                try {
                    Object validate_comment = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_validate);
                    if (validate_comment != null && !((JSONObject) validate_comment).isNullObject()) {
                        validators = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_validate).toString();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析validate异常");
                }
                //如果权限中包含“允许作为增加”
                if (power.indexOf("detail:Y") >= 0) {
                    //列-作为查询条件-start
                    if (type.equals(GeneratorJSONProperties.FIELD_type_input)) {
                        sb.append("                    divStr+='<div class=\"form-group\">';").append("\r\n");
                        sb.append("                        divStr+='<label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>" + column_comment + "：</label>';").append("\r\n");
                        sb.append("                        divStr+='<div class=\"col-lg-9\">';").append("\r\n");
                        sb.append("                            divStr+='<input id=\"" + column_name_tf + "2_'+subNum+'\" name=\"" + column_name_tf + "2_'+subNum+'\"  class=\"form-control\" placeholder=\"" + column_comment + "\" readonly=\"readonly\" type=\"text\"/>';").append("\r\n");
                        sb.append("                        divStr+='</div>';").append("\r\n");
                        sb.append("                    divStr+='</div>';").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_date)) {
                        sb.append("                    divStr+='<div class=\"form-group\">';").append("\r\n");
                        sb.append("                        divStr+='<label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>" + column_comment + "：</label>';").append("\r\n");
                        sb.append("                        divStr+='<div class=\"col-lg-9\">';").append("\r\n");
                        sb.append("                            divStr+='<input id=\"" + column_name_tf + "2_'+subNum+'\" name=\"" + column_name_tf + "2_'+subNum+'\"  class=\"form-control\" placeholder=\"" + column_comment + "\" readonly=\"readonly\" type=\"text\"/>';").append("\r\n");
                        sb.append("                        divStr+='</div>';").append("\r\n");
                        sb.append("                    divStr+='</div>';").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_datetime)) {
                        sb.append("                    divStr+='<div class=\"form-group\">';").append("\r\n");
                        sb.append("                        divStr+='<label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>" + column_comment + "：</label>';").append("\r\n");
                        sb.append("                        divStr+='<div class=\"col-lg-9\">';").append("\r\n");
                        sb.append("                            divStr+='<input id=\"" + column_name_tf + "2_'+subNum+'\" name=\"" + column_name_tf + "2_'+subNum+'\"  class=\"form-control\" placeholder=\"" + column_comment + "\" readonly=\"readonly\" type=\"text\"/>';").append("\r\n");
                        sb.append("                        divStr+='</div>';").append("\r\n");
                        sb.append("                    divStr+='</div>';").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_select)) {
                        sb.append("                    divStr+='<div class=\"form-group\">';").append("\r\n");
                        sb.append("                        divStr+='<label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>" + column_comment + "：</label>';").append("\r\n");
                        sb.append("                        divStr+='<div class=\"col-lg-9\">';").append("\r\n");
                        sb.append("                            divStr+='<input type=\"text\" id=\"" + column_name_tf + "2_'+subNum+'\"  class=\"form-control\" name=\"" + column_name_tf + "2_'+subNum+'\" readonly=\"readonly\"  disabled=\"disabled\"/>';").append("\r\n");
                        sb.append("                        divStr+='</div>';").append("\r\n");
                        sb.append("                    divStr+='</div>';").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_radio)) {
                        sb.append("                    divStr+='<div class=\"form-group\">';").append("\r\n");
                        sb.append("                        divStr+='<label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>" + column_comment + "：</label>';").append("\r\n");
                        sb.append("                        divStr+='<div class=\"col-lg-9\">';").append("\r\n");
                        sb.append("                            divStr+='<input type=\"text\" id=\"" + column_name_tf + "2_'+subNum+'\"  class=\"form-control\" name=\"" + column_name_tf + "2_'+subNum+'\" readonly=\"readonly\"  disabled=\"disabled\"/>';").append("\r\n");
                        sb.append("                        divStr+='</div>';").append("\r\n");
                        sb.append("                    divStr+='</div>';").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_checkbox)) {
                        sb.append("                    divStr+='<div class=\"form-group addqure\">';").append("\r\n");
                        sb.append("                        divStr+='<label class=\"col-lg-3 title\">" + column_comment + "：</label>';").append("\r\n");
                        sb.append("                        divStr+='<div class=\"checkbox_validateDetail" + cleanentityClassName + "Form_" + column_name_tf + "2_'+subNum+' col-lg-9\">';").append("\r\n");

                        //静态模式
                        try {
                            JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                            Object options_o = attr.get(GeneratorJSONProperties.PATH_options);
                            if (options_o != null) {
                                sb.append("                            divStr+='<#assign options=" + ((JSONArray) options_o).toString() + "/>';").append("\r\n");
                                sb.append("                            divStr+='<#assign idx=0/>';").append("\r\n");
                                sb.append("                            divStr+='<input type=\"text\" id=\"validateDetail" + cleanentityClassName + "Form_" + column_name_tf + "2_'+subNum+'\" name=\"validateDetail" + cleanentityClassName + "Form_" + column_name_tf + "2_'+subNum+'\" style=\"display:none\" value=\"\" >';").append("\r\n");
                                sb.append("                            divStr+='<#list options as item >';").append("\r\n");
                                sb.append("                                divStr+='<label class=\"checkbox-inline\">';").append("\r\n");
                                sb.append("                                    divStr+='<input type=\"checkbox\" class=\"inline1\" id=\"checkedBox_validateDetail" + cleanentityClassName + "Form_" + column_name_tf + "2_'+subNum+'_${idx}\" name=\"validateDetail" + cleanentityClassName + "Form_" + column_name_tf + "2_'+subNum+'\" value=\"${item}\" onclick=\"return false;\">${options[idx]}';").append("\r\n");
                                sb.append("                                divStr+='</label>';").append("\r\n");
                                sb.append("                                divStr+='<#assign idx=idx+1/>';").append("\r\n");
                                sb.append("                            divStr+='</#list>';").append("\r\n");
                            }
                        } catch (Exception e) {
                            //e.printStackTrace();
                            System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析checkbox-options异常");
                        }
                        //动态模式
                        try {
                            JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                            Object l1Code = attr.get(GeneratorJSONProperties.PATH_l1Code);
                            Object l2Code = attr.get(GeneratorJSONProperties.PATH_l2Code);
                            if (l1Code != null && l2Code != null) {
                                sb.append("                            divStr+='<#assign options=dicCheckbox[\"" + l1Code + "," + l2Code + "\"]/>';").append("\r\n");
                                sb.append("                            divStr+='<#assign idx=0/>';").append("\r\n");
                                sb.append("                            divStr+='<input type=\"text\" id=\"validateDetail" + cleanentityClassName + "Form_" + column_name_tf + "2_'+subNum+'\" name=\"validateDetail" + cleanentityClassName + "Form_" + column_name_tf + "2_'+subNum+'\" style=\"display:none\" value=\"\" >';").append("\r\n");
                                sb.append("                            divStr+='<#list options as item >';").append("\r\n");
                                sb.append("                                divStr+='<label class=\"checkbox-inline\">';").append("\r\n");
                                sb.append("                                    divStr+='<input type=\"checkbox\" class=\"inline1\" id=\"checkedBox_validateDetail" + cleanentityClassName + "Form_" + column_name_tf + "2_'+subNum+'_${idx}\" name=\"validateDetail" + cleanentityClassName + "Form_" + column_name_tf + "2_'+subNum+'\" value=\"${item}\" onclick=\"return false;\">${options[idx]}';").append("\r\n");
                                sb.append("                                divStr+='</label>';").append("\r\n");
                                sb.append("                                divStr+='<#assign idx=idx+1/>';").append("\r\n");
                                sb.append("                            divStr+='</#list>';").append("\r\n");
                            }
                        } catch (Exception e) {
                            //e.printStackTrace();
                            System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析checkbox-l1Code-l2Code异常");
                        }

                        sb.append("                        divStr+='</div>';").append("\r\n");
                        sb.append("                    divStr+='</div>';").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_textarea)) {
                        throw new RuntimeException("子表不允许有文本域，影响样式！");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_file)) {
                        throw new RuntimeException("子表不允许有文件，影响样式！");
                    }
                }
            }
            sb.append("                divStr+='</div>';").append("\r\n");
            sb.append("            divStr+='</div>';").append("\r\n");
            sb.append("            $(\"#validateDetail" + cleanentityClassName + "Form #subContent2 div:first\").append(divStr);").append("\r\n");
            sb.append("        }").append("\r\n");
            sb.append("    </script>").append("\r\n");
        }
        sb.append("    <style>").append("\r\n");
        sb.append("        <#--一下代码用于覆盖new.css中的样式-->").append("\r\n");
        sb.append("        <#--调整弹出框宽度-->").append("\r\n");
        sb.append("        #validateDetail"+cleanentityClassName+"Form .modal-content{").append("\r\n");
        sb.append("            width:800px;").append("\r\n");
        sb.append("        }").append("\r\n");
        sb.append("        <#--调整子表宽度-->").append("\r\n");
        sb.append("        #validateDetail"+cleanentityClassName+"Form .sub_ .modal-body{").append("\r\n");
        sb.append("            width:1600px;").append("\r\n");
        sb.append("        }").append("\r\n");
        sb.append("        #validateDetail"+cleanentityClassName+"Form .sub_ .modal-body .form-group{float: left;}").append("\r\n");
        sb.append("        #validateDetail"+cleanentityClassName+"Form .sub_ .addList{padding:0; padding: 0 20px;}").append("\r\n");
        sb.append("        #validateDetail"+cleanentityClassName+"Form .addList .addqure{width:14%;}").append("\r\n");
        sb.append("        #validateDetail"+cleanentityClassName+"Form .sub_ .addList .addqure .radio-inline{ width: 33%;float: left;  margin: 0;}").append("\r\n");
        sb.append("        #validateDetail"+cleanentityClassName+"Form .sub_ .addList .addqure .checkbox-inline{ width: 33%;float: left;  margin: 0;}").append("\r\n");
        sb.append("        #validateDetail"+cleanentityClassName+"Form .sub_ .addList .col-lg-9{padding:0px;}").append("\r\n");
        sb.append("    </style>").append("\r\n");


        sb.append("</#macro>").append("\r\n");
        sb.append("").append("\r\n");
        sb.append("").append("\r\n");


        pw.println(sb.toString());
        pw.close();
    }

    public void exec_create_004_UPDATEPAGE(Context c) throws Exception {
        //创建文件夹
        if(!FileUtils.mkdirs((String) c.get(Context.PATH_FTL))){
            throw new Exception("文件夹["+(String)c.get(Context.PATH_FTL)+"]创建不成功");
        }
        //准备数据
        String tableName = (String)c.get(Context.CURR_TABLE);//tbl_user_info
        String entityClassName = FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(tableName));//TblUserInfo
        String cleanentityClassName = FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(tableName));//UserInfo
        //去掉Tbl的头部
        if(cleanentityClassName.startsWith("Tbl")){
            cleanentityClassName = cleanentityClassName.substring(3);
        }
        entityClassName = "Union"+entityClassName;
        cleanentityClassName = "Union"+cleanentityClassName;

        String cleanentityClassNameFirstSmall = FormatUtils.firstSmall(cleanentityClassName);//userInfo
        String ftldirectory = cleanentityClassName.toLowerCase();//userinfo
        //创建子文件夹
        if(!FileUtils.mkdirs((String) c.get(Context.PATH_FTL) + File.separator + ftldirectory)){
            throw new Exception("文件夹["+(String) c.get(Context.PATH_FTL) + File.separator + ftldirectory + "]创建不成功");
        }
        String ftlname = "update"+cleanentityClassName;
        //String controllerPath = FormatUtils.firstSmall(cleanentityClassName);
        //String logicClassName = cleanentityClassName + "Logic";
        //String logicVarName = FormatUtils.firstSmall(cleanentityClassName + "Logic");
        String fileName = ftlname+".ftl";//文件名与父路径名相同
        File filePath = new File((String)c.get(Context.PATH_FTL) + File.separator+ftldirectory+File.separator+fileName);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath),(String)c.get(Context.FILE_CHARSET)));

        //准备内容
        StringBuilder sb = new StringBuilder();
        StringBuilder sb_script = new StringBuilder();//js初始化操作
        StringBuilder sb_script_validate = new StringBuilder();//js校验函数
        String hasSlaveTables = (String)c.get(Context.HAS_SLAVE_TABLES);
        String hasSubTable = (String)c.get(Context.HAS_SUB_TABLE);
        sb.append("<#import \"/component/register.ftl\" as  register/>").append("\r\n");
        sb.append("").append("\r\n");
        sb.append("<#macro update"+cleanentityClassName+"Html>").append("\r\n");
        sb.append("    <div class=\"modal fade\" id=\"update"+cleanentityClassName+"\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">").append("\r\n");
        sb.append("        <div class=\"modal-dialog\">").append("\r\n");
        sb.append("            <div class=\"modal-content\">").append("\r\n");
        sb.append("                <form id=\"validateUpdate"+cleanentityClassName+"Form\" method=\"post\" class=\"form-horizontal\">").append("\r\n");
        sb.append("                    <input type=\"hidden\" id=\"id_key\" name=\"id_key\" value=\"\" />").append("\r\n");
        sb.append("                    <div class=\"modal-header\">").append("\r\n");
        sb.append("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>").append("\r\n");
        sb.append("                        <h4 class=\"modal-title\" id=\"myModalLabel\">修改"+((String)c.get(Context.CURR_TABLE_COMMENT))+"</h4>").append("\r\n");
        sb.append("                    </div>").append("\r\n");
        sb.append("                    <div class=\"modal-body\">").append("\r\n");

        //字段遍历开始
        int count = (Integer)c.get(Context.CURR_TABLE_COLUMN_COUNT);//字段总数
        for(int i=0;i<count;i++){
            String column_name = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_NAME)).get(i);
            String column_name_tf = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_NAME_TF)).get(i);
            String column_comment = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT)).get(i);
            String column_comment_all = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT_ALL)).get(i);
            JSONObject column_comment_json = (JSONObject)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT_JSON)).get(i);
            String type = GeneratorJSONProperties.DEFAULT_type;//设置为默认的Type
            try{
                type = column_comment_json.getString(GeneratorJSONProperties.PATH_type);
            }catch (Exception e){
                //e.printStackTrace();
            }
            String power = GeneratorJSONProperties.DEFAULT_power;//设置为默认的权限
            try{
                JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                power = attr.getString(GeneratorJSONProperties.PATH_power);
            }catch (Exception e){
                //e.printStackTrace();
            }
            String isPrimaryKey = GeneratorJSONProperties.DEFAULT_isPrimarykey;
            try{
                JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                isPrimaryKey = attr.getString(GeneratorJSONProperties.PATH_isPrimarykey);
            }catch (Exception e){
                //e.printStackTrace();
            }
            //如果权限中包含“允许作为增加”主键一定会显示
            if(power.indexOf("update-show:Y")>=0||power.indexOf("update-update:Y")>=0||isPrimaryKey.equalsIgnoreCase("true")){
                boolean canupdate = false;//默认不可修改
                if(power.indexOf("update-update:Y")>=0)canupdate=true;
                if(isPrimaryKey.equalsIgnoreCase("true"))canupdate=false;//主键不可修改
                //列-作为查询条件-start
                if(type.equals(GeneratorJSONProperties.FIELD_type_input)){
                    sb.append("                        <div class=\"form-group\">").append("\r\n");
                    sb.append("                            <label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-lg-9\">").append("\r\n");
                    sb.append("                                <input id=\""+column_name_tf+"3\" name=\""+column_name_tf+"3\"  class=\"form-control\" placeholder=\""+column_comment+"\" type=\"text\""+(canupdate?"":" disabled=\"disabled\"")+"/>").append("\r\n");
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_date)){
                    sb.append("                        <div class=\"form-group\">").append("\r\n");
                    sb.append("                            <label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-lg-9\">").append("\r\n");
                    sb.append("                                <input id=\""+column_name_tf+"3\" name=\""+column_name_tf+"3\"  class=\"form-control\" placeholder=\""+column_comment+"\" type=\"text\""+(canupdate?"":" disabled=\"disabled\"")+"/>").append("\r\n");
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_datetime)){
                    sb.append("                        <div class=\"form-group\">").append("\r\n");
                    sb.append("                            <label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-lg-9\">").append("\r\n");
                    sb.append("                                <input id=\""+column_name_tf+"3\" name=\""+column_name_tf+"3\"  class=\"form-control\" placeholder=\""+column_comment+"\" type=\"text\""+(canupdate?"":" disabled=\"disabled\"")+"/>").append("\r\n");
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_select)){
                    sb.append("                        <div class=\"form-group\">").append("\r\n");
                    sb.append("                            <label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-lg-9\">").append("\r\n");
                    sb.append("                                <select class=\"form-control select2\" id=\""+column_name_tf+"3\" name=\""+column_name_tf+"3\""+(canupdate?"":" disabled=\"disabled\"")+">").append("\r\n");
                    //是否有全部查询选择
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object needAll_o = attr.get(GeneratorJSONProperties.PATH_needAll);
                        if(needAll_o!=null  && ((String)needAll_o).trim().equals("true")){
                            sb.append("                                    <option selected=\"selected\" value=\"\">全部</option>").append("\r\n");
                        }
                    }catch (Exception e){
                        //e.printStackTrace();
                        System.out.println("tablename["+tableName+"],columnName["+column_name+"],columnComment_ALL["+column_comment_all+"]--解析SELECT是否含有全部查询按钮needAll异常");
                    }
                    //静态模式
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object options_o = attr.get(GeneratorJSONProperties.PATH_options);
                        if(options_o!=null){
                            sb.append("                                    <#--静态模式-start-->").append("\r\n");
                            sb.append("                                    <#assign options="+((JSONObject)options_o).toString()+"/>").append("\r\n");
                            sb.append("                                    <#list options?keys as key >").append("\r\n");
                            sb.append("                                        <option value=\"${key}\">${options[key]}</option>").append("\r\n");
                            sb.append("                                    </#list>").append("\r\n");
                            sb.append("                                    <#--静态模式- end -->").append("\r\n");
                        }
                    }catch (Exception e){
                        //e.printStackTrace();
                        System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析SELECT-options异常");
                    }
                    //动态模式
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object l1Code = attr.get(GeneratorJSONProperties.PATH_l1Code);
                        Object l2Code = attr.get(GeneratorJSONProperties.PATH_l2Code);
                        if(l1Code!=null&&l2Code!=null){
                            sb.append("                                    <#--动态模式-start-->").append("\r\n");
                            sb.append("                                    <#assign options=dicList['"+l1Code+","+l2Code+"']/>").append("\r\n");
                            sb.append("                                    <#list options as item >").append("\r\n");
                            sb.append("                                        <option value=\"${item.codeParam}\">${item.codeValue}</option>").append("\r\n");
                            sb.append("                                    </#list>").append("\r\n");
                            sb.append("                                    <#--动态模式- end -->").append("\r\n");
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析SELECT-l1Code-l2Code异常");
                    }
                    sb.append("                                </select>").append("\r\n");
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_radio)){
                    sb.append("                        <div class=\"form-group\">").append("\r\n");
                    sb.append("                            <label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-lg-9\">").append("\r\n");
                    //静态模式
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object options_o = attr.get(GeneratorJSONProperties.PATH_options);
                        if(options_o!=null){
                            sb.append("                                <#--静态模式-start-->").append("\r\n");
                            sb.append("                                <#assign options="+((JSONObject)options_o).toString()+"/>").append("\r\n");
                            sb.append("                                <#list options?keys as key >").append("\r\n");
                            sb.append("                                <label class=\"radio-inline\">").append("\r\n");
                            sb.append("                                    <input type=\"radio\" id=\""+column_name_tf+"3_${key}\" name=\""+column_name_tf+"3\" value=\"${key}\""+(canupdate?"":" disabled=\"disabled\"")+">${options[key]}").append("\r\n");
                            sb.append("                                </label>").append("\r\n");
                            sb.append("                                </#list>").append("\r\n");
                            sb.append("                                <#--静态模式- end -->").append("\r\n");
                        }
                    }catch (Exception e){
                        //e.printStackTrace();
                        System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析radio-options异常");
                    }
                    //动态模式
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object l1Code = attr.get(GeneratorJSONProperties.PATH_l1Code);
                        Object l2Code = attr.get(GeneratorJSONProperties.PATH_l2Code);
                        if(l1Code!=null&&l2Code!=null){
                            sb.append("                                <#--动态模式-start-->").append("\r\n");
                            sb.append("                                <#assign options=dicList['"+l1Code+","+l2Code+"']/>").append("\r\n");
                            sb.append("                                <#list options as item >").append("\r\n");
                            sb.append("                                <label class=\"radio-inline\">").append("\r\n");
                            sb.append("                                    <input type=\"radio\" id=\""+column_name_tf+"3_${item.codeParam}\" name=\""+column_name_tf+"3\" value=\"${item.codeParam}\""+(canupdate?"":" disabled=\"disabled\"")+">${item.codeValue}").append("\r\n");
                            sb.append("                                </label>").append("\r\n");
                            sb.append("                                </#list>").append("\r\n");
                            sb.append("                                <#--动态模式- end -->").append("\r\n");
                        }
                    }catch (Exception e){
                        //e.printStackTrace();
                        System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析radio-l1Code-l2Code异常");
                    }
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_checkbox)){
                    //静态模式
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object options_o = attr.get(GeneratorJSONProperties.PATH_options);
                        if(options_o!=null){
                            sb.append("                        <#--静态模式-start-->").append("\r\n");
                            sb.append("                        <#assign options="+((JSONArray)options_o).toString()+"/>").append("\r\n");
                            sb.append("                        <@register.checkbox form=\"validateUpdate"+cleanentityClassName+"Form\" name=\""+column_name_tf+"3\" label=\""+column_comment+"\" options=options value=\"\"").append("\r\n");
                            sb.append("                        class1=\"form-group\" " +
                                    "class2=\"col-lg-3 title\" " +
                                    "class3=\"col-lg-9\" " +
                                    "class4=\"checkbox-inline\" " +
                                    "class5=\"inline1\" " +
                                    "readOnly=\""+(canupdate?"false":"true")+"\"/>").append("\r\n");
                            sb.append("                        <#--静态模式- end -->").append("\r\n");
                        }
                    }catch (Exception e){
                        //e.printStackTrace();
                        System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析checkbox-options异常");
                    }
                    //动态模式
                    try{
                        JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                        Object l1Code = attr.get(GeneratorJSONProperties.PATH_l1Code);
                        Object l2Code = attr.get(GeneratorJSONProperties.PATH_l2Code);
                        if(l1Code!=null&&l2Code!=null){
                            sb.append("                        <#--动态模式-start-->").append("\r\n");
                            sb.append("                        <#assign options=dicCheckbox['"+l1Code+","+l2Code+"']/>").append("\r\n");
                            sb.append("                        <@register.checkbox form=\"validateUpdate"+cleanentityClassName+"Form\" name=\""+column_name_tf+"3\" label=\""+column_comment+"\" options=options value=\"\"").append("\r\n");
                            sb.append("                        class1=\"form-group\" " +
                                    "class2=\"col-lg-3 title\" " +
                                    "class3=\"col-lg-9\" " +
                                    "class4=\"checkbox-inline\" " +
                                    "class5=\"inline1\" " +
                                    "readOnly=\""+(canupdate?"false":"true")+"\"/>").append("\r\n");
                            sb.append("                        <#--动态模式- end -->").append("\r\n");
                        }
                    }catch (Exception e){
                        //e.printStackTrace();
                        System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析checkbox-l1Code-l2Code异常");
                    }
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_textarea)){
                    sb.append("                        <div class=\"form-group\">").append("\r\n");
                    sb.append("                            <label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>"+column_comment+"：</label>").append("\r\n");
                    sb.append("                            <div class=\"col-lg-9\">").append("\r\n");
                    sb.append("                                <textarea id=\""+column_name_tf+"3\" name=\""+column_name_tf+"3\"  class=\"form-control\" placeholder=\""+column_comment+"\" type=\"text\""+(canupdate?"":" disabled=\"disabled\"")+"></textarea>").append("\r\n");
                    sb.append("                            </div>").append("\r\n");
                    sb.append("                        </div>").append("\r\n");
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_file)){
                    sb.append("                        <#assign options=\"1111\"/>").append("\r\n");
                    sb.append("                        <@register.fileupdownload form=\"validateUpdate"+cleanentityClassName+"Form\" name=\""+column_name_tf+"3\" label=\""+column_comment+"\" options=options value=\"\"").append("\r\n");
                    sb.append("                        need=\"true\" upload_base_path=\"/file/upLoad.dhtml\" download_base_path=\"/file/downLoad.dhtml\" fileDesc=\""+cleanentityClassName+"-"+column_name_tf+"-"+column_comment+"\"").append("\r\n");
                    sb.append("                        businessType=\"010\" businessNo=\"010\" class1=\"form-group\" class2=\"col-lg-3 title\" class3=\"col-lg-9\" class4=\"checkbox-inline\" class5=\"inline1\" readOnly=\"false\"/>").append("\r\n");
                }
            }
        }
        //字段遍历结束

        sb.append("                    </div>").append("\r\n");
        if(hasSubTable.equalsIgnoreCase("true")) {
            sb.append("                    <#--添加子表信息-->").append("\r\n");
            sb.append("                    <div style=\"width:108px;margin:10px 0px;\"><button type=\"button\" class=\"btn btn-block btn-success\" data-toggle=\"modal\" onclick=\"update" + cleanentityClassName + "Sub();\">添加子表信息</button></div>").append("\r\n");
            sb.append("                    <div id=\"subContent3\" class=\"subContent\">").append("\r\n");
            sb.append("                        <div class=\"subContentScoll\"></div>").append("\r\n");
            sb.append("                    </div>").append("\r\n");
        }
        sb.append("                    <div class=\"modal-footer\">").append("\r\n");
        sb.append("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭</button>").append("\r\n");
        sb.append("                        <button type=\"submit\" class=\"btn btn-primary\">提交更改</button>").append("\r\n");
        sb.append("                    </div>").append("\r\n");
        sb.append("                </form>").append("\r\n");
        sb.append("            </div>").append("\r\n");
        sb.append("        </div>").append("\r\n");
        sb.append("    </div>").append("\r\n");

        //##UPDATE页面的js函数
        if(hasSubTable.equalsIgnoreCase("true")) {
            sb.append("    <script type=\"text/javascript\">").append("\r\n");
            sb.append("        function update" + cleanentityClassName + "Sub(){").append("\r\n");
            sb.append("            var subNum = $(\"#validateUpdate" + cleanentityClassName + "Form .sub3_\").length;").append("\r\n");
            sb.append("            var divStr = '<div id=\"sub3_'+subNum+'\" class=\"sub3_ sub_\" subNum=\"'+subNum+'\">';").append("\r\n");
            sb.append("                divStr+='<div class=\"modal-body addList\">';").append("\r\n");
            sb.append("                    divStr+='<div class=\"form-group closebutton\">';").append("\r\n");
            sb.append("                        divStr+='<label class=\"col-lg-3 title\"></label>';").append("\r\n");
            sb.append("                        divStr+='<div class=\"col-lg-9\">';").append("\r\n");
            sb.append("                            divStr+='<button type=\"button\" class=\"close\" onclick=colseSub(\"validateUpdate" + cleanentityClassName + "Form\",\"sub3_'+subNum+'\")>&times;</button>';").append("\r\n");
            sb.append("                        divStr+='</div>';").append("\r\n");
            sb.append("                    divStr+='</div>';").append("\r\n");
            //添加子表开始
            //字段遍历开始
            int count_sub = (Integer) c.get(Context.CURR_SUB_TABLE_COLUMN_COUNT);//字段总数
            for (int i = 0; i < count_sub; i++) {
                String column_name = (String) ((List) c.get(Context.CURR_SUB_TABLE_COLUMNS_NAME)).get(i);
                String column_name_tf = (String) ((List) c.get(Context.CURR_SUB_TABLE_COLUMNS_NAME_TF)).get(i);
                String column_comment = (String) ((List) c.get(Context.CURR_SUB_TABLE_COLUMNS_COMMENT)).get(i);
                String column_comment_all = (String) ((List) c.get(Context.CURR_SUB_TABLE_COLUMNS_COMMENT_ALL)).get(i);
                JSONObject column_comment_json = (JSONObject) ((List) c.get(Context.CURR_SUB_TABLE_COLUMNS_COMMENT_JSON)).get(i);
                String type = GeneratorJSONProperties.DEFAULT_type;//设置为默认的Type
                try {
                    type = column_comment_json.getString(GeneratorJSONProperties.PATH_type);
                } catch (Exception e) {
                    //e.printStackTrace();
                }
                String power = GeneratorJSONProperties.DEFAULT_power;//设置为默认的权限
                try {
                    JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                    power = attr.getString(GeneratorJSONProperties.PATH_power);
                } catch (Exception e) {
                    //e.printStackTrace();
                }
                String validators = GeneratorJSONProperties.DEFAULT_validators;
                try {
                    Object validate_comment = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_validate);
                    if (validate_comment != null && !((JSONObject) validate_comment).isNullObject()) {
                        validators = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_validate).toString();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析validate异常");
                }
                //如果权限中包含“允许作为增加”
                if (power.indexOf("update:Y") >= 0) {
                    //列-作为查询条件-start
                    if (type.equals(GeneratorJSONProperties.FIELD_type_input)) {
                        sb.append("                    divStr+='<div class=\"form-group\">';").append("\r\n");
                        sb.append("                        divStr+='<label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>" + column_comment + "：</label>';").append("\r\n");
                        sb.append("                        divStr+='<div class=\"col-lg-9\">';").append("\r\n");
                        sb.append("                            divStr+='<input id=\"" + column_name_tf + "3_'+subNum+'\" name=\"" + column_name_tf + "3_'+subNum+'\"  class=\"form-control\" placeholder=\"" + column_comment + "\" type=\"text\"/>';").append("\r\n");
                        sb.append("                        divStr+='</div>';").append("\r\n");
                        sb.append("                    divStr+='</div>';").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_date)) {
                        sb.append("                    divStr+='<div class=\"form-group\">';").append("\r\n");
                        sb.append("                        divStr+='<label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>" + column_comment + "：</label>';").append("\r\n");
                        sb.append("                        divStr+='<div class=\"col-lg-9\">';").append("\r\n");
                        sb.append("                            divStr+='<input id=\"" + column_name_tf + "3_'+subNum+'\" name=\"" + column_name_tf + "3_'+subNum+'\"  class=\"form-control\" placeholder=\"" + column_comment + "\" type=\"text\"/>';").append("\r\n");
                        sb.append("                        divStr+='</div>';").append("\r\n");
                        sb.append("                    divStr+='</div>';").append("\r\n");
                        sb_script.append("            $('#validateUpdate" + cleanentityClassName + "Form #" + column_name_tf + "3_'+subNum).ECalendar({").append("\r\n");
                        sb_script.append("                type:\"date\",").append("\r\n");
                        sb_script.append("                stamp : false,").append("\r\n");
                        sb_script.append("                offset:[0,2],").append("\r\n");
                        sb_script.append("                format:\"yyyy-mm-dd\",").append("\r\n");
                        sb_script.append("                skin:1,").append("\r\n");
                        sb_script.append("                callback:function(v,e){").append("\r\n");
                        sb_script.append("                    $(\"#validateUpdate" + cleanentityClassName + "Form\").data('bootstrapValidator').updateStatus(\"" + column_name_tf + "3_\"+subNum,\"NOT_VALIDATED\",null);").append("\r\n");
                        sb_script.append("                    $(\"#validateUpdate" + cleanentityClassName + "Form\").data('bootstrapValidator').validateField(\"" + column_name_tf + "3_\"+subNum);").append("\r\n");
                        sb_script.append("                }").append("\r\n");
                        sb_script.append("            });").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_datetime)) {
                        sb.append("                    divStr+='<div class=\"form-group\">';").append("\r\n");
                        sb.append("                        divStr+='<label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>" + column_comment + "：</label>';").append("\r\n");
                        sb.append("                        divStr+='<div class=\"col-lg-9\">';").append("\r\n");
                        sb.append("                            divStr+='<input id=\"" + column_name_tf + "3_'+subNum+'\" name=\"" + column_name_tf + "3_'+subNum+'\"  class=\"form-control\" placeholder=\"" + column_comment + "\" type=\"text\"/>';").append("\r\n");
                        sb.append("                        divStr+='</div>';").append("\r\n");
                        sb.append("                    divStr+='</div>';").append("\r\n");
                        sb_script.append("            $('#validateUpdate" + cleanentityClassName + "Form #" + column_name_tf + "3_'+subNum).ECalendar({").append("\r\n");
                        sb_script.append("                type:\"time\",").append("\r\n");
                        sb_script.append("                stamp : false,").append("\r\n");
                        sb_script.append("                offset:[0,2],").append("\r\n");
                        sb_script.append("                format:\"yyyy-mm-dd hh:ii:ss\",").append("\r\n");
                        sb_script.append("                skin:1,").append("\r\n");
                        sb_script.append("                step:1,").append("\r\n");
                        sb_script.append("                callback:function(v,e){").append("\r\n");
                        sb_script.append("                    $(\"#validateUpdate" + cleanentityClassName + "Form\").data('bootstrapValidator').updateStatus(\"" + column_name_tf + "3_\"+subNum,\"NOT_VALIDATED\",null);").append("\r\n");
                        sb_script.append("                    $(\"#validateUpdate" + cleanentityClassName + "Form\").data('bootstrapValidator').validateField(\"" + column_name_tf + "3_\"+subNum);").append("\r\n");
                        sb_script.append("                }").append("\r\n");
                        sb_script.append("            });").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_select)) {
                        sb.append("                    divStr+='<div class=\"form-group\">';").append("\r\n");
                        sb.append("                        divStr+='<label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>" + column_comment + "：</label>';").append("\r\n");
                        sb.append("                        divStr+='<div class=\"col-lg-9\">';").append("\r\n");
                        sb.append("                            divStr+='<select class=\"form-control select2\" id=\"" + column_name_tf + "3_'+subNum+'\" name=\"" + column_name_tf + "3_'+subNum+'\">';").append("\r\n");
                        //静态模式
                        try {
                            JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                            Object options_o = attr.get(GeneratorJSONProperties.PATH_options);
                            if (options_o != null) {
                                sb.append("                                divStr+='<#assign options=" + ((JSONObject) options_o).toString() + "/>';").append("\r\n");
                                sb.append("                                divStr+='<#list options?keys as key >';").append("\r\n");
                                sb.append("                                    divStr+='<option value=\"${key}\">${options[key]}</option>';").append("\r\n");
                                sb.append("                                divStr+='</#list>';").append("\r\n");
                            }
                        } catch (Exception e) {
                            //e.printStackTrace();
                            System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析SELECT-options异常");
                        }
                        //动态模式
                        try {
                            JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                            Object l1Code = attr.get(GeneratorJSONProperties.PATH_l1Code);
                            Object l2Code = attr.get(GeneratorJSONProperties.PATH_l2Code);
                            if (l1Code != null && l2Code != null) {
                                //TODO  这种写法很不正规，属于“偶然碰对的写法”，将来需要优化
                                sb.append("                                divStr+='<#assign options=dicList['" + l1Code + "," + l2Code + "']/>';").append("\r\n");
                                sb.append("                                divStr+='<#list options as item >';").append("\r\n");
                                sb.append("                                    divStr+='<option value=\"${item.codeParam}\">${item.codeValue}</option>';").append("\r\n");
                                sb.append("                                divStr+='</#list>';").append("\r\n");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析SELECT-l1Code-l2Code异常");
                        }
                        sb.append("                            divStr+='</select>';").append("\r\n");
                        sb.append("                        divStr+='</div>';").append("\r\n");
                        sb.append("                    divStr+='</div>';").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_radio)) {
                        sb.append("                    divStr+='<div class=\"form-group addqure\">';").append("\r\n");
                        sb.append("                        divStr+='<label class=\"col-lg-3 title\"><i class=\"redFont\">*</i>" + column_comment + "：</label>';").append("\r\n");
                        sb.append("                        divStr+='<div class=\"col-lg-9\">';").append("\r\n");
                        //静态模式
                        try {
                            JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                            Object options_o = attr.get(GeneratorJSONProperties.PATH_options);
                            if (options_o != null) {
                                sb.append("                            divStr+='<#assign options=" + ((JSONObject) options_o).toString() + "/>';").append("\r\n");
                                sb.append("                            divStr+='<#list options?keys as key >';").append("\r\n");
                                sb.append("                                divStr+='<label class=\"radio-inline\">';").append("\r\n");
                                sb.append("                                divStr+='<input type=\"radio\" id=\"" + column_name_tf + "3_'+subNum+'_${key}\" name=\"" + column_name_tf + "3_'+subNum+'\" value=\"${key}\">${options[key]}';").append("\r\n");
                                sb.append("                                divStr+='</label>';").append("\r\n");
                                sb.append("                            divStr+='</#list>';").append("\r\n");
                            }
                        } catch (Exception e) {
                            //e.printStackTrace();
                            System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析radio-options异常");
                        }
                        //动态模式
                        try {
                            JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                            Object l1Code = attr.get(GeneratorJSONProperties.PATH_l1Code);
                            Object l2Code = attr.get(GeneratorJSONProperties.PATH_l2Code);
                            if (l1Code != null && l2Code != null) {
                                sb.append("                            divStr+='<#assign options=dicList[\"" + l1Code + "," + l2Code + "\"]/>';").append("\r\n");
                                sb.append("                            divStr+='<#list options as item >';").append("\r\n");
                                sb.append("                                divStr+='<label class=\"radio-inline\">';").append("\r\n");
                                sb.append("                                divStr+='<input type=\"radio\" id=\"" + column_name_tf + "3_'+subNum+'_${item.codeParam}\" name=\"" + column_name_tf + "3_'+subNum+'\" value=\"${item.codeParam}\">${item.codeValue}';").append("\r\n");
                                sb.append("                                divStr+='</label>';").append("\r\n");
                                sb.append("                            divStr+='</#list>';").append("\r\n");
                            }
                        } catch (Exception e) {
                            //e.printStackTrace();
                            System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析radio-l1Code-l2Code异常");
                        }
                        sb.append("                        divStr+='</div>';").append("\r\n");
                        sb.append("                    divStr+='</div>';").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_checkbox)) {
                        sb.append("                    divStr+='<div class=\"form-group addqure\">';").append("\r\n");
                        sb.append("                        divStr+='<label class=\"col-lg-3 title\">" + column_comment + "：</label>';").append("\r\n");
                        sb.append("                        divStr+='<div class=\"checkbox_validateUpdate" + cleanentityClassName + "Form_" + column_name_tf + "3_'+subNum+' col-lg-9\">';").append("\r\n");

                        //静态模式
                        try {
                            JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                            Object options_o = attr.get(GeneratorJSONProperties.PATH_options);
                            if (options_o != null) {
                                sb.append("                            divStr+='<#assign options=" + ((JSONArray) options_o).toString() + "/>';").append("\r\n");
                                sb.append("                            divStr+='<#assign idx=0/>';").append("\r\n");
                                sb.append("                            divStr+='<input type=\"text\" id=\"validateUpdate" + cleanentityClassName + "Form_" + column_name_tf + "3_'+subNum+'\" name=\"validateUpdate" + cleanentityClassName + "Form_" + column_name_tf + "3_'+subNum+'\" style=\"display:none\" value=\"\" >';").append("\r\n");
                                sb.append("                            divStr+='<#list options as item >';").append("\r\n");
                                sb.append("                                divStr+='<label class=\"checkbox-inline\">';").append("\r\n");
                                sb.append("                                    divStr+='<input type=\"checkbox\" class=\"inline1\" id=\"checkedBox_validateUpdate" + cleanentityClassName + "Form_" + column_name_tf + "3_'+subNum+'_${idx}\" name=\"validateUpdate" + cleanentityClassName + "Form_" + column_name_tf + "3_'+subNum+'\" value=\"${item}\" onclick=flushCheckBox2FieldVal(\"validateUpdate" + cleanentityClassName + "Form\",\"" + column_name_tf + "3_'+subNum+'\")>${options[idx]}';").append("\r\n");
                                sb.append("                                divStr+='</label>';").append("\r\n");
                                sb.append("                                divStr+='<#assign idx=idx+1/>';").append("\r\n");
                                sb.append("                            divStr+='</#list>';").append("\r\n");
                            }
                        } catch (Exception e) {
                            //e.printStackTrace();
                            System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析checkbox-options异常");
                        }
                        //动态模式
                        try {
                            JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                            Object l1Code = attr.get(GeneratorJSONProperties.PATH_l1Code);
                            Object l2Code = attr.get(GeneratorJSONProperties.PATH_l2Code);
                            if (l1Code != null && l2Code != null) {
                                sb.append("                            divStr+='<#assign options=dicCheckbox[\"" + l1Code + "," + l2Code + "\"]/>';").append("\r\n");
                                sb.append("                            divStr+='<#assign idx=0/>';").append("\r\n");
                                sb.append("                            divStr+='<input type=\"text\" id=\"validateUpdate" + cleanentityClassName + "Form_" + column_name_tf + "3_'+subNum+'\" name=\"validateUpdate" + cleanentityClassName + "Form_" + column_name_tf + "3_'+subNum+'\" style=\"display:none\" value=\"\" >';").append("\r\n");
                                sb.append("                            divStr+='<#list options as item >';").append("\r\n");
                                sb.append("                                divStr+='<label class=\"checkbox-inline\">';").append("\r\n");
                                sb.append("                                    divStr+='<input type=\"checkbox\" class=\"inline1\" id=\"checkedBox_validateUpdate" + cleanentityClassName + "Form_" + column_name_tf + "3_'+subNum+'_${idx}\" name=\"validateUpdate" + cleanentityClassName + "Form_" + column_name_tf + "3_'+subNum+'\" value=\"${item}\" onclick=flushCheckBox2FieldVal(\"validateUpdate" + cleanentityClassName + "Form\",\"" + column_name_tf + "3_'+subNum+'\")>${options[idx]}';").append("\r\n");
                                sb.append("                                divStr+='</label>';").append("\r\n");
                                sb.append("                                divStr+='<#assign idx=idx+1/>';").append("\r\n");
                                sb.append("                            divStr+='</#list>';").append("\r\n");
                            }
                        } catch (Exception e) {
                            //e.printStackTrace();
                            System.out.println("tablename[" + tableName + "],columnName[" + column_name + "],columnComment_ALL[" + column_comment_all + "]--解析checkbox-l1Code-l2Code异常");
                        }

                        sb.append("                        divStr+='</div>';").append("\r\n");
                        sb.append("                    divStr+='</div>';").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_textarea)) {
                        throw new RuntimeException("子表不允许有文本域，影响样式！");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_file)) {
                        throw new RuntimeException("子表不允许有文件，影响样式！");
                    }
                    if (!type.equals(GeneratorJSONProperties.FIELD_type_checkbox)) {
                        //非checkbox才需要validate
                        if (StringUtils.isNotEmpty(validators) && !validators.trim().equals("{}")) {
                            //如果有校验函数，则将校验函数写入,
                            sb_script_validate.append("            $(\"#validateUpdate" + cleanentityClassName + "Form\").data('bootstrapValidator').addField('" + column_name_tf + "3_'+subNum,{").append("\r\n");
                            sb_script_validate.append("                validators : " + validators).append("\r\n");
                            sb_script_validate.append("            });").append("\r\n");
                        } else {
                            //如果校验函数为空或为空JSON，则写入默认校验函数
                            sb_script_validate.append("            $(\"#validateUpdate" + cleanentityClassName + "Form\").data('bootstrapValidator').addField('" + column_name_tf + "3_'+subNum,{").append("\r\n");
                            sb_script_validate.append("                validators : " + GeneratorJSONProperties.DEFAULT_validators).append("\r\n");
                            sb_script_validate.append("            });").append("\r\n");
                        }
                    }
                }
            }
            sb.append("                divStr+='</div>';").append("\r\n");
            sb.append("            divStr+='</div>';").append("\r\n");
            sb.append("            $(\"#validateUpdate" + cleanentityClassName + "Form #subContent3 div:first\").append(divStr);").append("\r\n");
            sb.append(sb_script).append("\r\n");
            sb.append(sb_script_validate).append("\r\n");
            sb.append("        }").append("\r\n");
            sb.append("    </script>").append("\r\n");
        }
        sb.append("    <style>").append("\r\n");
        sb.append("        <#--一下代码用于覆盖new.css中的样式-->").append("\r\n");
        sb.append("        <#--调整弹出框宽度-->").append("\r\n");
        sb.append("        #validateUpdate"+cleanentityClassName+"Form .modal-content{").append("\r\n");
        sb.append("            width:800px;").append("\r\n");
        sb.append("        }").append("\r\n");
        sb.append("        <#--调整子表宽度-->").append("\r\n");
        sb.append("        #validateUpdate"+cleanentityClassName+"Form .sub_ .modal-body{").append("\r\n");
        sb.append("            width:1600px;").append("\r\n");
        sb.append("        }").append("\r\n");
        sb.append("        #validateUpdate"+cleanentityClassName+"Form .sub_ .modal-body .form-group{float: left;}").append("\r\n");
        sb.append("        #validateUpdate"+cleanentityClassName+"Form .sub_ .addList{padding:0; padding: 0 20px;}").append("\r\n");
        sb.append("        #validateUpdate"+cleanentityClassName+"Form .addList .addqure{width:14%;}").append("\r\n");
        sb.append("        #validateUpdate"+cleanentityClassName+"Form .sub_ .addList .addqure .radio-inline{ width: 33%;float: left;  margin: 0;}").append("\r\n");
        sb.append("        #validateUpdate"+cleanentityClassName+"Form .sub_ .addList .addqure .checkbox-inline{ width: 33%;float: left;  margin: 0;}").append("\r\n");
        sb.append("        #validateUpdate"+cleanentityClassName+"Form .sub_ .addList .col-lg-9{padding:0px;}").append("\r\n");
        sb.append("    </style>").append("\r\n");
        sb.append("</#macro>").append("\r\n");
        sb.append("").append("\r\n");
        sb.append("").append("\r\n");
        pw.println(sb.toString());
        pw.close();
    }
}

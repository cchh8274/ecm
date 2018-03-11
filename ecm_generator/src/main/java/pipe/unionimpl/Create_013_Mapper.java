package pipe.unionimpl;

import context.Context;
import context.GeneratorJSONProperties;
import exec.Generator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pipe.Pipe;
import pipe.impl.meta.SQLTYPE;
import pipe.impl.meta.TableInfoMetaCreater;
import sun.misc.BASE64Decoder;
import utils.FileUtils;
import utils.FormatUtils;
import utils.StringUtils;
import utils.TypeUtils;

import java.io.*;
import java.net.URLDecoder;
import java.util.List;

/**
 * Created by baolong on 2017/2/27.
 */
public class Create_013_Mapper implements Pipe {

    /**
     * 数据库类型，可以填写MYSQL或者ORACLE
     */
    public String DBTYPE = "MYSQL";
    /**
     * 设置生成的queryforpage的默认类型为true
     */
    public String DEFAULT_QUERY_FORPAGE_like = "true";


    public Create_013_Mapper() {

    }

    public Create_013_Mapper(String DBTYPE, String DEFAULT_QUERY_FORPAGE_like) {
        this.DBTYPE = DBTYPE;
        this.DEFAULT_QUERY_FORPAGE_like = DEFAULT_QUERY_FORPAGE_like;
    }

    public void exec(Context c) throws Exception {
        //创建文件夹
        if(!FileUtils.mkdirs((String) c.get(Context.PATH_MAPPER))){
            throw new Exception("文件夹["+(String)c.get(Context.PATH_MAPPER)+"]创建不成功");
        }
        String tableName = (String)c.get(Context.CURR_TABLE);
        String entityClassName = FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(tableName));
        String daoClassName = "Union"+FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(tableName))+"Mapper";
        String mapperXmlName = "Union"+FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(tableName))+"Mapper";
        String fileName = mapperXmlName+".xml";
        File entityFile = new File((String)c.get(Context.PATH_MAPPER) + File.separator+fileName);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(entityFile),(String)c.get(Context.FILE_CHARSET)));

        String packageDao = (String)c.get(Context.PACKAGE_DAO);
        String packageEntity = (String)c.get(Context.PACKAGE_ENTITY);

        //准备内容
        //************************************************************************************************************
        //头部
        //************************************************************************************************************
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append("\r\n");
        sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">").append("\r\n");
        sb.append("<mapper namespace=\""+packageDao+"."+daoClassName+"\">").append("\r\n");



        //************************************************************************************************************
        //resultMap
        //************************************************************************************************************
        //增加参数
        int count = (Integer)c.get(Context.CURR_TABLE_COLUMN_COUNT);
        List<String> primaryKeyColumn = (List<String>)c.get(Context.CURR_TABLE_PRIMARYKEY_COLUMN);




        //************************************************************************************************************
        //queryForPage    queryForPage分页查询
        //参数有两种情况：
        //    1、传递countFlag=Y标记,则返回的是计数
        //    2、传递countFlag=N标记、limitStart、limitSize,则返回的是分页结果,字段未驼峰化
        //根据DEFAULT_QUERY_FORPAGE_like去判断，是否生成like的查询，或者标准的等于型查询
        //************************************************************************************************************
        if(DBTYPE.equals("MYSQL")||DBTYPE.equals("SQLITE")){
            sb.append("    <select id=\"queryForPage\" parameterType=\"java.util.HashMap\" resultType=\"java.util.HashMap\">").append("\r\n");
            sb.append("        <if test=\"countFlag != null and countFlag == 'Y'.toString() \">").append("\r\n");
            sb.append("        select count(1) as TOTALCOUNT from (").append("\r\n");
            sb.append("        </if>").append("\r\n").append("\r\n").append("\r\n");

            sb.append("        select").append("\r\n");
            //查询条件
            String base_column_list ="";
            for(int i=0;i<count;i++){
                String column_name = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_NAME)).get(i);
                String column_name_tf = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_NAME_TF)).get(i);
                String column_comment = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT)).get(i);
                String column_type = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_TYPE)).get(i);
                String column_size = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_TYPE_COLUMN_SIZE)).get(i);
                String decimal_digits = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_TYPE_COLUMN_DECIMAL_DIGITS)).get(i);
                if(StringUtils.isNotEmpty(base_column_list))base_column_list=base_column_list+",\r\n";
                base_column_list = base_column_list + "            " + column_name;
            }
            sb.append(base_column_list).append("\r\n");


            sb.append("        from\r\n");
            List<String> tablesNameList = (List<String>)c.get(Context.UNION_QUERY_TABLES_TABLENAME_LIST);
            List<String> tablesAliasList = (List<String>)c.get(Context.UNION_QUERY_TABLES_TABLEALIAS_LIST);
            String tablesListStr = "";

            for(int i=0;i<tablesNameList.size();i++){
                String tablesName = tablesNameList.get(i);
                String tablesAlias =tablesAliasList.get(i);
                if(StringUtils.isNotEmpty(tablesListStr)){
                    tablesListStr = tablesListStr+",\r\n";
                }
                tablesListStr +="            ";
                tablesListStr+=(tablesName+" "+tablesAlias);
            }
            sb.append(tablesListStr);
            sb.append("\r\n");


            sb.append("        where 1=1").append("\r\n");

            for(Object slaveTable : ((JSONObject) c.get("jsonParam")).getJSONArray("slaveTables")){
                String slaveTableName = ((JSONObject)slaveTable).getString("slaveTableName");
                String slaveTableAlias = ((JSONObject)slaveTable).getString("slaveTableAlias");
                String slaveTableWhere = ((JSONObject)slaveTable).getString("slaveTableWhere");
                //从表关联条件
                sb.append("            and "+slaveTableWhere).append("\r\n");
            }

            //子表关联条件不需要子表关联条件
            //sb.append("            and "+((JSONObject) c.get("jsonParam")).getString("subTableWhere")).append("\r\n");
            for(int i=0;i<count;i++){
                String column_name = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_NAME)).get(i);
                String column_name_tf = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_NAME_TF)).get(i);
                String column_comment = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT)).get(i);
                String column_comment_all = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT_ALL)).get(i);
                String column_type = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_TYPE)).get(i);
                String column_size = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_TYPE_COLUMN_SIZE)).get(i);
                String decimal_digits = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_TYPE_COLUMN_DECIMAL_DIGITS)).get(i);
                JSONObject column_comment_json = (JSONObject)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT_JSON)).get(i);
                String type = GeneratorJSONProperties.DEFAULT_type;//设置为默认的Type
                try{
                    type = column_comment_json.getString(GeneratorJSONProperties.PATH_type);
                }catch (Exception e){
                    //e.printStackTrace();
                }
                //如果默认标志为true，并且字段类型为input，并且类型是VARCHAR型的，则生成like型的字段。
                String MAPPERJDBCTYPE = TypeUtils.transDBType2MapperJDBCType(column_type, column_size, decimal_digits);
                if(DEFAULT_QUERY_FORPAGE_like.equals("true")&&type.equals(GeneratorJSONProperties.FIELD_type_input)&&MAPPERJDBCTYPE.indexOf("CHAR")>0){
                    sb.append("        <if test=\""+column_name_tf+" != null and "+column_name_tf+" != '' \">").append("\r\n");
                    if(DBTYPE.equals("MYSQL")){
                        sb.append("            and "+column_name+" like CONCAT(#{"+column_name_tf+",jdbcType="+MAPPERJDBCTYPE+"},'%')").append("\r\n");
                    }else if(DBTYPE.equals("SQLITE")){
                        sb.append("            and "+column_name+" like #{"+column_name_tf+",jdbcType="+MAPPERJDBCTYPE+"||'%')").append("\r\n");
                    }
                    sb.append("        </if>").append("\r\n");
                    continue;
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_date)||type.equals(GeneratorJSONProperties.FIELD_type_datetime)){
                    //如果是date或者datetime类型，则先写默认条件
                    sb.append("        <if test=\""+column_name_tf+" != null and "+column_name_tf+" != '' \">").append("\r\n");
                    sb.append("            and "+column_name+" = #{"+column_name_tf+",jdbcType="+MAPPERJDBCTYPE+"}").append("\r\n");
                    sb.append("        </if>").append("\r\n");
                    //判断是否有queryrange标志
                    {
                        try{
                            JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                            Object queryrange_o = attr.get(GeneratorJSONProperties.PATH_queryrange);
                            if(queryrange_o!=null  && ((String)queryrange_o).trim().equals("true")){
                                //如果有queryrange条件，则增加_start和_end查询，闭区间
                                sb.append("        <if test=\""+column_name_tf+"_start != null and "+column_name_tf+"_start != '' \">").append("\r\n");
                                sb.append("            and "+column_name+" &gt;= #{"+column_name_tf+"_start,jdbcType="+MAPPERJDBCTYPE+"}").append("\r\n");
                                sb.append("        </if>").append("\r\n");
                                sb.append("        <if test=\""+column_name_tf+"_end != null and "+column_name_tf+"_end != '' \">").append("\r\n");
                                sb.append("            and "+column_name+" &lt;= #{"+column_name_tf+"_end,jdbcType="+MAPPERJDBCTYPE+"}").append("\r\n");
                                sb.append("        </if>").append("\r\n");
                            }
                        }catch (Exception e){
                            //e.printStackTrace();
                            System.out.println("tablename["+tableName+"],columnName["+column_name+"],columnComment_ALL["+column_comment_all+"]--解析DATE或者DATETIME是否含有queryrange异常");
                        }
                    }
                    //判断是否有queryrange标志结束
                    continue;
                }
                sb.append("        <if test=\""+column_name_tf+" != null and "+column_name_tf+" != '' \">").append("\r\n");
                sb.append("            and "+column_name+" = #{"+column_name_tf+",jdbcType="+MAPPERJDBCTYPE+"}").append("\r\n");
                sb.append("        </if>").append("\r\n");
            }
            sb.append("").append("\r\n").append("\r\n");

            sb.append("        <if test=\"countFlag != null and countFlag == 'N'.toString() \">").append("\r\n");
            sb.append("        limit #{limitStart,jdbcType=DECIMAL},#{limitSize,jdbcType=DECIMAL}").append("\r\n");
            sb.append("        </if>").append("\r\n");
            sb.append("        <if test=\"countFlag != null and countFlag == 'Y'.toString() \">").append("\r\n");
            sb.append("        ) as TMP_COUNT_TABLE").append("\r\n");
            sb.append("        </if>").append("\r\n");

            sb.append("    </select>").append("\r\n");
        }else if(DBTYPE.equals("ORACLE")){
            sb.append("    <select id=\"queryForPage\" parameterType=\"java.util.HashMap\" resultType=\"java.util.HashMap\">").append("\r\n");
            sb.append("        <if test=\"countFlag != null and countFlag == 'Y'.toString() \">").append("\r\n");
            sb.append("        select count(1) as TOTALCOUNT from (").append("\r\n");
            sb.append("        </if>").append("\r\n");
            sb.append("        <if test=\"countFlag != null and countFlag == 'N'.toString() \">").append("\r\n");
            sb.append("        <![CDATA[ select * from ( select interTable.*,rownum rn from ( ]]>").append("\r\n");
            sb.append("        </if>").append("\r\n").append("\r\n");

            sb.append("        select").append("\r\n");
            sb.append("        <include refid=\"Base_Column_List\" />").append("\r\n");
            sb.append("        from\r\n");
            List<String> tablesNameList = (List<String>)c.get(Context.UNION_QUERY_TABLES_TABLENAME_LIST);
            List<String> tablesAliasList = (List<String>)c.get(Context.UNION_QUERY_TABLES_TABLEALIAS_LIST);
            String tablesListStr = "";

            for(int i=0;i<tablesNameList.size();i++){
                String tablesName = tablesNameList.get(i);
                String tablesAlias =tablesAliasList.get(i);
                if(StringUtils.isNotEmpty(tablesListStr)){
                    tablesListStr = tablesListStr+",\r\n";
                }
                tablesListStr +="            ";
                tablesListStr+=(tablesName+" "+tablesAlias);
            }
            sb.append(tablesListStr);
            sb.append("\r\n");


            sb.append("        where 1=1").append("\r\n");

            for(Object slaveTable : ((JSONObject) c.get("jsonParam")).getJSONArray("slaveTables")){
                String slaveTableName = ((JSONObject)slaveTable).getString("slaveTableName");
                String slaveTableAlias = ((JSONObject)slaveTable).getString("slaveTableAlias");
                String slaveTableWhere = ((JSONObject)slaveTable).getString("slaveTableWhere");
                //从表关联条件
                sb.append("            and "+slaveTableWhere).append("\r\n");
            }

            for(int i=0;i<count;i++){
                String column_name = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_NAME)).get(i);
                String column_name_tf = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_NAME_TF)).get(i);
                String column_comment = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT)).get(i);
                String column_comment_all = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT_ALL)).get(i);
                String column_type = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_TYPE)).get(i);
                String column_size = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_TYPE_COLUMN_SIZE)).get(i);
                String decimal_digits = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_TYPE_COLUMN_DECIMAL_DIGITS)).get(i);
                JSONObject column_comment_json = (JSONObject)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT_JSON)).get(i);
                String type = GeneratorJSONProperties.DEFAULT_type;//设置为默认的Type
                try{
                    type = column_comment_json.getString(GeneratorJSONProperties.PATH_type);
                }catch (Exception e){
                    //e.printStackTrace();
                }
                //如果默认标志为true，并且字段类型为input，并且类型是VARCHAR型的，则生成like型的字段。
                String MAPPERJDBCTYPE = TypeUtils.transDBType2MapperJDBCType(column_type, column_size, decimal_digits);
                if(DEFAULT_QUERY_FORPAGE_like.equals("true")&&type.equals(GeneratorJSONProperties.FIELD_type_input)&&MAPPERJDBCTYPE.indexOf("CHAR")>0){
                    sb.append("        <if test=\""+column_name_tf+" != null and "+column_name_tf+" != '' \">").append("\r\n");
                    sb.append("            and "+column_name+" like CONCAT(#{"+column_name_tf+",jdbcType="+MAPPERJDBCTYPE+"},'%')").append("\r\n");
                    sb.append("        </if>").append("\r\n");
                    continue;
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_date)||type.equals(GeneratorJSONProperties.FIELD_type_datetime)){
                    //如果是date或者datetime类型，则先写默认条件
                    sb.append("        <if test=\""+column_name_tf+" != null and "+column_name_tf+" != '' \">").append("\r\n");
                    sb.append("            and "+column_name+" = #{"+column_name_tf+",jdbcType="+MAPPERJDBCTYPE+"}").append("\r\n");
                    sb.append("        </if>").append("\r\n");
                    //判断是否有queryrange标志
                    {
                        try{
                            JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                            Object queryrange_o = attr.get(GeneratorJSONProperties.PATH_queryrange);
                            if(queryrange_o!=null  && ((String)queryrange_o).trim().equals("true")){
                                //如果有queryrange条件，则增加_start和_end查询，闭区间
                                sb.append("        <if test=\""+column_name_tf+"_start != null and "+column_name_tf+"_start != '' \">").append("\r\n");
                                sb.append("            and "+column_name+" &gt;= #{"+column_name_tf+"_start,jdbcType="+MAPPERJDBCTYPE+"}").append("\r\n");
                                sb.append("        </if>").append("\r\n");
                                sb.append("        <if test=\""+column_name_tf+"_end != null and "+column_name_tf+"_end != '' \">").append("\r\n");
                                sb.append("            and "+column_name+" &lt;= #{"+column_name_tf+"_end,jdbcType="+MAPPERJDBCTYPE+"}").append("\r\n");
                                sb.append("        </if>").append("\r\n");
                            }
                        }catch (Exception e){
                            //e.printStackTrace();
                            System.out.println("tablename["+tableName+"],columnName["+column_name+"],columnComment_ALL["+column_comment_all+"]--解析DATE或者DATETIME是否含有queryrange异常");
                        }
                    }
                    //判断是否有queryrange标志结束
                    continue;
                }
                sb.append("        <if test=\""+column_name_tf+" != null and "+column_name_tf+" != '' \">").append("\r\n");
                sb.append("            and "+column_name+" = #{"+column_name_tf+",jdbcType="+MAPPERJDBCTYPE+"}").append("\r\n");
                sb.append("        </if>").append("\r\n");
            }
            sb.append("").append("\r\n").append("\r\n");
            //MYSQL从0开始,ORACLE从1开始，而dao层统一从0开始，因此此处为limitStart<outerTable.rn<=limitStart+limitSize
            sb.append("        <if test=\"countFlag != null and countFlag == 'N'.toString() \">").append("\r\n");
            sb.append("        ) interTable where rownum &lt;= #{limitStart,jdbcType=DECIMAL}+#{limitSize,jdbcType=DECIMAL}").append("\r\n");
            sb.append("        </if>").append("\r\n");
            sb.append("        <if test=\"countFlag != null and countFlag == 'N'.toString() \">").append("\r\n");
            sb.append("        ) outerTable where outerTable.rn > #{limitStart,jdbcType=DECIMAL}").append("\r\n");
            sb.append("        </if>").append("\r\n");
            sb.append("        <if test=\"countFlag != null and countFlag == 'Y'.toString() \">").append("\r\n");
            sb.append("        ) TMP_COUNT_TABLE").append("\r\n");
            sb.append("        </if>").append("\r\n");

            sb.append("    </select>").append("\r\n");
        }else if(DBTYPE.equals("DB2")){
            sb.append("    <select id=\"queryForPage\" parameterType=\"java.util.HashMap\" resultType=\"java.util.HashMap\">").append("\r\n");
            sb.append("        <if test=\"countFlag != null and countFlag == 'Y'.toString() \">").append("\r\n");
            sb.append("        select count(1) as TOTALCOUNT from (").append("\r\n");
            sb.append("        </if>").append("\r\n");
            sb.append("        <if test=\"countFlag != null and countFlag == 'N'.toString() \">").append("\r\n");
            //默认主键作为排序字段，因此此处需要获取主键列表
            String perimarkKeys = "";
            for(int i=0;i<count;i++) {
                String column_name = (String) ((List) c.get(Context.CURR_TABLE_COLUMNS_NAME)).get(i);
                String column_name_tf = (String) ((List) c.get(Context.CURR_TABLE_COLUMNS_NAME_TF)).get(i);
                String column_comment = (String) ((List) c.get(Context.CURR_TABLE_COLUMNS_COMMENT)).get(i);
                String column_comment_all = (String) ((List) c.get(Context.CURR_TABLE_COLUMNS_COMMENT_ALL)).get(i);
                String column_type = (String) ((List) c.get(Context.CURR_TABLE_COLUMNS_TYPE)).get(i);
                String column_size = (String) ((List) c.get(Context.CURR_TABLE_COLUMNS_TYPE_COLUMN_SIZE)).get(i);
                String decimal_digits = (String) ((List) c.get(Context.CURR_TABLE_COLUMNS_TYPE_COLUMN_DECIMAL_DIGITS)).get(i);
                JSONObject column_comment_json = (JSONObject) ((List) c.get(Context.CURR_TABLE_COLUMNS_COMMENT_JSON)).get(i);
                String type = GeneratorJSONProperties.DEFAULT_type;//设置为默认的Type
                boolean isPrimaryKey = false;
                for (String primaryKeyColumnName : primaryKeyColumn) {
                    if (primaryKeyColumnName.equals(column_name)) {
                        isPrimaryKey = true;
                        if(StringUtils.isEmpty(perimarkKeys)){
                            perimarkKeys+=column_name;
                        }else{
                            perimarkKeys+=(","+column_name);
                        }
                        break;
                    }
                }
            }

            sb.append("        <![CDATA[ select * from ( select interTable.*,ROW_NUMBER() OVER ( ORDER BY "+perimarkKeys+" ) as ROWNUM from ( ]]>").append("\r\n");
            sb.append("        </if>").append("\r\n").append("\r\n");

            sb.append("        select").append("\r\n");
            sb.append("        <include refid=\"Base_Column_List\" />").append("\r\n");
            sb.append("        from\r\n");
            List<String> tablesNameList = (List<String>)c.get(Context.UNION_QUERY_TABLES_TABLENAME_LIST);
            List<String> tablesAliasList = (List<String>)c.get(Context.UNION_QUERY_TABLES_TABLEALIAS_LIST);
            String tablesListStr = "";

            for(int i=0;i<tablesNameList.size();i++){
                String tablesName = tablesNameList.get(i);
                String tablesAlias =tablesAliasList.get(i);
                if(StringUtils.isNotEmpty(tablesListStr)){
                    tablesListStr = tablesListStr+",\r\n";
                }
                tablesListStr +="            ";
                tablesListStr+=(tablesName+" "+tablesAlias);
            }
            sb.append(tablesListStr);
            sb.append("\r\n");


            sb.append("        where 1=1").append("\r\n");

            for(Object slaveTable : ((JSONObject) c.get("jsonParam")).getJSONArray("slaveTables")){
                String slaveTableName = ((JSONObject)slaveTable).getString("slaveTableName");
                String slaveTableAlias = ((JSONObject)slaveTable).getString("slaveTableAlias");
                String slaveTableWhere = ((JSONObject)slaveTable).getString("slaveTableWhere");
                //从表关联条件
                sb.append("            and "+slaveTableWhere).append("\r\n");
            }
            for(int i=0;i<count;i++){
                String column_name = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_NAME)).get(i);
                String column_name_tf = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_NAME_TF)).get(i);
                String column_comment = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT)).get(i);
                String column_comment_all = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT_ALL)).get(i);
                String column_type = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_TYPE)).get(i);
                String column_size = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_TYPE_COLUMN_SIZE)).get(i);
                String decimal_digits = (String)((List)c.get(Context.CURR_TABLE_COLUMNS_TYPE_COLUMN_DECIMAL_DIGITS)).get(i);
                JSONObject column_comment_json = (JSONObject)((List)c.get(Context.CURR_TABLE_COLUMNS_COMMENT_JSON)).get(i);
                String type = GeneratorJSONProperties.DEFAULT_type;//设置为默认的Type
                try{
                    type = column_comment_json.getString(GeneratorJSONProperties.PATH_type);
                }catch (Exception e){
                    //e.printStackTrace();
                }
                //如果默认标志为true，并且字段类型为input，并且类型是VARCHAR型的，则生成like型的字段。
                String MAPPERJDBCTYPE = TypeUtils.transDBType2MapperJDBCType(column_type, column_size, decimal_digits);
                if(DEFAULT_QUERY_FORPAGE_like.equals("true")&&type.equals(GeneratorJSONProperties.FIELD_type_input)&&MAPPERJDBCTYPE.indexOf("CHAR")>0){
                    sb.append("        <if test=\""+column_name_tf+" != null and "+column_name_tf+" != '' \">").append("\r\n");
                    sb.append("            and "+column_name+" like CONCAT(#{"+column_name_tf+",jdbcType="+MAPPERJDBCTYPE+"},'%')").append("\r\n");
                    sb.append("        </if>").append("\r\n");
                    continue;
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_date)||type.equals(GeneratorJSONProperties.FIELD_type_datetime)){
                    //如果是date或者datetime类型，则先写默认条件
                    sb.append("        <if test=\""+column_name_tf+" != null and "+column_name_tf+" != '' \">").append("\r\n");
                    sb.append("            and "+column_name+" = #{"+column_name_tf+",jdbcType="+MAPPERJDBCTYPE+"}").append("\r\n");
                    sb.append("        </if>").append("\r\n");
                    //判断是否有queryrange标志
                    {
                        try{
                            JSONObject attr = column_comment_json.getJSONObject(GeneratorJSONProperties.PATH_attr);
                            Object queryrange_o = attr.get(GeneratorJSONProperties.PATH_queryrange);
                            if(queryrange_o!=null  && ((String)queryrange_o).trim().equals("true")){
                                //如果有queryrange条件，则增加_start和_end查询，闭区间
                                sb.append("        <if test=\""+column_name_tf+"_start != null and "+column_name_tf+"_start != '' \">").append("\r\n");
                                sb.append("            and "+column_name+" &gt;= #{"+column_name_tf+"_start,jdbcType="+MAPPERJDBCTYPE+"}").append("\r\n");
                                sb.append("        </if>").append("\r\n");
                                sb.append("        <if test=\""+column_name_tf+"_end != null and "+column_name_tf+"_end != '' \">").append("\r\n");
                                sb.append("            and "+column_name+" &lt;= #{"+column_name_tf+"_end,jdbcType="+MAPPERJDBCTYPE+"}").append("\r\n");
                                sb.append("        </if>").append("\r\n");
                            }
                        }catch (Exception e){
                            //e.printStackTrace();
                            System.out.println("tablename["+tableName+"],columnName["+column_name+"],columnComment_ALL["+column_comment_all+"]--解析DATE或者DATETIME是否含有queryrange异常");
                        }
                    }
                    //判断是否有queryrange标志结束
                    continue;
                }
                sb.append("        <if test=\""+column_name_tf+" != null and "+column_name_tf+" != '' \">").append("\r\n");
                sb.append("            and "+column_name+" = #{"+column_name_tf+",jdbcType="+MAPPERJDBCTYPE+"}").append("\r\n");
                sb.append("        </if>").append("\r\n");
            }
            sb.append("").append("\r\n").append("\r\n");
            //MYSQL从0开始,ORACLE从1开始,DB2从1开始，而dao层统一从0开始，因此此处为limitStart<interTable.ROWNUM<=limitStart+limitSize
            sb.append("        <if test=\"countFlag != null and countFlag == 'N'.toString() \">").append("\r\n");
            sb.append("        ) interTable )where ROWNUM &gt;#{limitStart,jdbcType=DECIMAL} and ROWNUM &lt;= #{limitStart,jdbcType=DECIMAL}+#{limitSize,jdbcType=DECIMAL} ").append("\r\n");
            sb.append("        </if>").append("\r\n");
            sb.append("        <if test=\"countFlag != null and countFlag == 'Y'.toString() \">").append("\r\n");
            sb.append("        ) TMP_COUNT_TABLE").append("\r\n");
            sb.append("        </if>").append("\r\n");

            sb.append("    </select>").append("\r\n");
        }else{
            throw new RuntimeException("不支持的数据库");
        }

        sb.append("").append("\r\n");


        sb.append("</mapper>").append("\r\n");
        pw.println(sb.toString());
        pw.close();

    }
}

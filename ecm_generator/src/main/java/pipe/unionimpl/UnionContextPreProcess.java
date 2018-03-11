package pipe.unionimpl;

import context.Context;
import context.GeneratorJSONProperties;
import exec.Generator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pipe.impl.meta.SQLTYPE;
import pipe.impl.meta.TableInfoMetaCreater;
import sun.misc.BASE64Decoder;
import utils.FormatUtils;
import utils.StringUtils;

import java.io.IOException;
import java.net.URLDecoder;

/**
 * Created by kanmars on 17-3-3.
 */
public class UnionContextPreProcess {
    public static String getInfoOrBase64Msg(JSONObject jsonObject, String name){
        String result = null;
        try{
            result = jsonObject.getString(name);
            if(result.startsWith("BASE64()")){
                result = new String(new BASE64Decoder().decodeBuffer(result.substring(8)),"utf-8");
                result = URLDecoder.decode(result,"utf-8");
                jsonObject.put(name,result);
            }
        }catch (Exception e){
        }
        return result;
    }

    /**
     * 预处理
     * @param c
     * @param needSub  是否需要子表字段，在查询页面，unionMapper中，仅需要主表与从表的字段
     * @throws IOException
     */
    public static Context preProcess(Context c,boolean needSub) throws IOException {
        Context result = new Context();
        result.put("jsonParam",(JSONObject) c.get("jsonParam"));
        c=result;
        JSONObject json = (JSONObject) c.get("jsonParam");
        String dbDriverInfo = json.getString("dbDriverInfo");
        String basePath = json.getString("basePath");
        String businessName = json.getString("businessName");
        String businessCnName = json.getString("businessCnName");
        String mainTableName = json.getString("mainTableName");
        String mainTableAlias = json.getString("mainTableAlias");
        JSONArray mainTableProperties = json.getJSONArray("mainTableProperties");
        JSONArray slaveTables = json.getJSONArray("slaveTables");
        String subTableName = json.getString("subTableName");
        String subTableAlias = json.getString("subTableAlias");
        String subTableWhere = json.getString("subTableWhere");
        JSONArray subTableProperties = json.getJSONArray("subTableProperties");
        String hasSlaveTables = json.getString("hasSlaveTables");//是否有从表
        String hasSubTable = json.getString("hasSubTable");//是否有子表


        //设置基础包名
        Generator.preProcess(c, basePath);
        //初始化参数
        c.put(Context.CURR_TABLE, businessName);
        c.put(Context.CURR_TABLE_COMMENT, businessCnName);
        c.put(Context.FILE_CHARSET, "utf-8");

        //创建表信息
        TableInfoMetaCreater tic = new TableInfoMetaCreater();
        c.put(Context.UNION_QUERY_TABLES_MAIN_TABLENAME, mainTableName);

        for(Object o : mainTableProperties){
            JSONObject columnInfo = (JSONObject)o;
            String column = getInfoOrBase64Msg(columnInfo, "column");
            String columnName = getInfoOrBase64Msg(columnInfo, "columnName");
            String sqlType = getInfoOrBase64Msg(columnInfo, "sqlType");
            String type = getInfoOrBase64Msg(columnInfo, "type");
            String isPrimaryKey = getInfoOrBase64Msg(columnInfo, "isPrimaryKey");
            String columnTypeColumnSize = getInfoOrBase64Msg(columnInfo, "columnTypeColumnSize");
            String columnTypeColumnDecimalDigits = getInfoOrBase64Msg(columnInfo, "columnTypeColumnDecimalDigits");
            String isNullAble = getInfoOrBase64Msg(columnInfo, "isNullAble");
            String isUnion = getInfoOrBase64Msg(columnInfo, "isUnion");
            String power = getInfoOrBase64Msg(columnInfo, "power");
            String notEmptyMsg = getInfoOrBase64Msg(columnInfo, "notEmptyMsg");
            String min = getInfoOrBase64Msg(columnInfo, "min");
            String max = getInfoOrBase64Msg(columnInfo, "max");
            String strLengthMsg = getInfoOrBase64Msg(columnInfo, "strLengthMsg");
            String regexp_str = getInfoOrBase64Msg(columnInfo, "regExp");
            String regExpMsg = getInfoOrBase64Msg(columnInfo, "regExpMsg");
            String sequence = getInfoOrBase64Msg(columnInfo, "sequence");
            String isMoney = getInfoOrBase64Msg(columnInfo, "isMoney");
            String autoInsert = getInfoOrBase64Msg(columnInfo, "autoInsert");
            String autoUpdate = getInfoOrBase64Msg(columnInfo, "autoUpdate");
            String queryRange = getInfoOrBase64Msg(columnInfo, "queryRange");
            String options = getInfoOrBase64Msg(columnInfo, "options");
            String l1Code = getInfoOrBase64Msg(columnInfo, "l1Code");
            String l2Code = getInfoOrBase64Msg(columnInfo, "l2Code");
            String formatter = "yyyy-mm-dd hh:ii:ss;yyyy-MM-dd HH:mm:ss";
            if(type.equals(GeneratorJSONProperties.FIELD_type_date)){
                formatter = GeneratorJSONProperties.DEFAULT_formatter_char8;
            }
            if(type.equals(GeneratorJSONProperties.FIELD_type_datetime)){
                formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
            }
            if(isUnion.equalsIgnoreCase("true")){
                //如果是联合查询的字段，在Create_013_Mapper中需要放入字段列表
                JSONObject columnJSON = new JSONObject();
                columnJSON.put(GeneratorJSONProperties.PATH_type,type);
                JSONObject attr = new JSONObject();
                if(StringUtils.isNotEmpty(power))attr.put(GeneratorJSONProperties.PATH_power,power);
                if(StringUtils.isNotEmpty(sequence))attr.put(GeneratorJSONProperties.PATH_sequence,sequence);
                if(StringUtils.isNotEmpty(isPrimaryKey)){
                    attr.put(GeneratorJSONProperties.PATH_isPrimarykey,isPrimaryKey);
                    if(isPrimaryKey.trim().equalsIgnoreCase("true")){
                        c.addtoList(Context.CURR_TABLE_PRIMARYKEY_COLUMN,mainTableAlias+"."+column);
                    }
                }else{
                    attr.put(GeneratorJSONProperties.PATH_isPrimarykey,GeneratorJSONProperties.DEFAULT_isPrimarykey);
                }
                if(StringUtils.isNotEmpty(isMoney))attr.put(GeneratorJSONProperties.PATH_ismoney,isMoney);
                if(StringUtils.isNotEmpty(autoInsert)){attr.put(GeneratorJSONProperties.PATH_autoinsert,autoInsert);attr.put(GeneratorJSONProperties.PATH_formatter,formatter);}
                if(StringUtils.isNotEmpty(autoUpdate))attr.put(GeneratorJSONProperties.PATH_autoupdate,autoUpdate);
                if(StringUtils.isNotEmpty(queryRange))attr.put(GeneratorJSONProperties.PATH_queryrange,queryRange);
                if(StringUtils.isNotEmpty(autoInsert))attr.put(GeneratorJSONProperties.PATH_autoinsert,autoInsert);
                if(StringUtils.isNotEmpty(options))attr.put(GeneratorJSONProperties.PATH_options,options);
                if(StringUtils.isNotEmpty(l1Code))attr.put(GeneratorJSONProperties.PATH_l1Code,l1Code);
                if(StringUtils.isNotEmpty(l2Code))attr.put(GeneratorJSONProperties.PATH_l2Code,l2Code);
                columnJSON.put(GeneratorJSONProperties.PATH_attr,attr);

                JSONObject validate = new JSONObject();
                boolean needNotEmpty = false;
                boolean needStringLength = false;
                boolean needregexp = false;
                JSONObject notEmpty = new JSONObject();
                if(StringUtils.isNotEmpty(notEmptyMsg)){notEmpty.put("message",notEmptyMsg);needNotEmpty=true;}
                JSONObject stringLength = new JSONObject();
                if(StringUtils.isNotEmpty(min)){stringLength.put("min",Integer.parseInt(min));needStringLength=true;}
                if(StringUtils.isNotEmpty(max)){stringLength.put("max",Integer.parseInt(max));needStringLength=true;}
                if(StringUtils.isNotEmpty(strLengthMsg)){stringLength.put("message",strLengthMsg);needStringLength=true;}
                JSONObject regexpobj = new JSONObject();
                if(StringUtils.isNotEmpty(regexp_str)){regexpobj.put("regexp",regexp_str);needregexp=true;}
                if(StringUtils.isNotEmpty(regExpMsg)){regexpobj.put("message",regExpMsg);needregexp=true;}
                if(needNotEmpty==true)validate.put("notEmpty",notEmpty);
                if(needStringLength==true)validate.put("stringLength",stringLength);
                if(needregexp==true)validate.put("regexp",regexpobj);
                columnJSON.put(GeneratorJSONProperties.PATH_validate,validate);


                tic.addColumn(businessName, column, columnName, Boolean.getBoolean(isPrimaryKey), SQLTYPE.getSqlType(sqlType), columnTypeColumnSize, columnTypeColumnDecimalDigits,columnJSON);
                c.addtoList(Context.CURR_TABLE_COLUMNS_NAME,mainTableAlias+"."+column);//增加别名
                c.addtoList(Context.CURR_TABLE_COLUMNS_NAME_TF, FormatUtils.formatDBNameToVarName(column));
                c.addtoList(Context.CURR_TABLE_COLUMNS_COMMENT_ALL,columnName);
                c.addtoList(Context.CURR_TABLE_COLUMNS_COMMENT,columnName);
                c.addtoList(Context.CURR_TABLE_COLUMNS_COMMENT_JSON,columnJSON);
                c.addtoList(Context.CURR_TABLE_COLUMNS_TYPE,sqlType);
                c.addtoList(Context.CURR_TABLE_COLUMNS_TYPE_COLUMN_SIZE,columnTypeColumnSize);
                c.addtoList(Context.CURR_TABLE_COLUMNS_TYPE_COLUMN_DECIMAL_DIGITS,columnTypeColumnDecimalDigits);
            }
        }
        c.addtoList(Context.UNION_QUERY_TABLES_TABLENAME_LIST, mainTableName);
        c.addtoList(Context.UNION_QUERY_TABLES_TABLEALIAS_LIST, mainTableAlias);
        c.put(Context.HAS_SLAVE_TABLES,hasSlaveTables);
        if(hasSlaveTables.equalsIgnoreCase("true"))for(Object slaveTable_i : slaveTables){
            JSONObject slaveTable = (JSONObject)slaveTable_i;
            String slaveTableName = slaveTable.getString("slaveTableName");
            String slaveTableAlias = slaveTable.getString("slaveTableAlias");
            String slaveTableWhere = slaveTable.getString("slaveTableWhere");
            for(Object o:((JSONObject)slaveTable).getJSONArray("buildParam")){
                JSONObject columnInfo = (JSONObject)o;
                String column = getInfoOrBase64Msg(columnInfo, "column");//增加别名
                String columnName = getInfoOrBase64Msg(columnInfo, "columnName");
                String sqlType = getInfoOrBase64Msg(columnInfo, "sqlType");
                String type = getInfoOrBase64Msg(columnInfo, "type");
                String isPrimaryKey = getInfoOrBase64Msg(columnInfo, "isPrimaryKey");
                String columnTypeColumnSize = getInfoOrBase64Msg(columnInfo, "columnTypeColumnSize");
                String columnTypeColumnDecimalDigits = getInfoOrBase64Msg(columnInfo, "columnTypeColumnDecimalDigits");
                String isNullAble = getInfoOrBase64Msg(columnInfo, "isNullAble");
                String isUnion = getInfoOrBase64Msg(columnInfo, "isUnion");
                String power = getInfoOrBase64Msg(columnInfo, "power");
                String notEmptyMsg = getInfoOrBase64Msg(columnInfo, "notEmptyMsg");
                String min = getInfoOrBase64Msg(columnInfo, "min");
                String max = getInfoOrBase64Msg(columnInfo, "max");
                String strLengthMsg = getInfoOrBase64Msg(columnInfo, "strLengthMsg");
                String regexp_str = getInfoOrBase64Msg(columnInfo, "regExp");
                String regExpMsg = getInfoOrBase64Msg(columnInfo, "regExpMsg");
                String sequence = getInfoOrBase64Msg(columnInfo, "sequence");
                String isMoney = getInfoOrBase64Msg(columnInfo, "isMoney");
                String autoInsert = getInfoOrBase64Msg(columnInfo, "autoInsert");
                String autoUpdate = getInfoOrBase64Msg(columnInfo, "autoUpdate");
                String queryRange = getInfoOrBase64Msg(columnInfo, "queryRange");
                String options = getInfoOrBase64Msg(columnInfo, "options");
                String l1Code = getInfoOrBase64Msg(columnInfo, "l1Code");
                String l2Code = getInfoOrBase64Msg(columnInfo, "l2Code");
                String formatter = "yyyy-mm-dd hh:ii:ss;yyyy-MM-dd HH:mm:ss";
                if(type.equals(GeneratorJSONProperties.FIELD_type_date)){
                    formatter = GeneratorJSONProperties.DEFAULT_formatter_char8;
                }
                if(type.equals(GeneratorJSONProperties.FIELD_type_datetime)){
                    formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                }


                if(isUnion.equalsIgnoreCase("true")){

                    JSONObject columnJSON = new JSONObject();
                    columnJSON.put(GeneratorJSONProperties.PATH_type,type);
                    JSONObject attr = new JSONObject();
                    if(StringUtils.isNotEmpty(power))attr.put(GeneratorJSONProperties.PATH_power,power);
                    if(StringUtils.isNotEmpty(sequence))attr.put(GeneratorJSONProperties.PATH_sequence,sequence);
                    if(StringUtils.isNotEmpty(isPrimaryKey)){
                        attr.put(GeneratorJSONProperties.PATH_isPrimarykey,isPrimaryKey);
                        if(isPrimaryKey.trim().equalsIgnoreCase("true")){
                            c.addtoList(Context.CURR_TABLE_PRIMARYKEY_COLUMN,mainTableAlias+"."+column);
                        }
                    }else{
                        attr.put(GeneratorJSONProperties.PATH_isPrimarykey,GeneratorJSONProperties.DEFAULT_isPrimarykey);
                    }
                    if(StringUtils.isNotEmpty(isMoney))attr.put(GeneratorJSONProperties.PATH_ismoney,isMoney);
                    if(StringUtils.isNotEmpty(autoInsert)){attr.put(GeneratorJSONProperties.PATH_autoinsert,autoInsert);attr.put(GeneratorJSONProperties.PATH_formatter,formatter);}
                    if(StringUtils.isNotEmpty(autoUpdate))attr.put(GeneratorJSONProperties.PATH_autoupdate,autoUpdate);
                    if(StringUtils.isNotEmpty(queryRange))attr.put(GeneratorJSONProperties.PATH_queryrange,queryRange);
                    if(StringUtils.isNotEmpty(autoInsert))attr.put(GeneratorJSONProperties.PATH_autoinsert,autoInsert);
                    if(StringUtils.isNotEmpty(options))attr.put(GeneratorJSONProperties.PATH_options,options);
                    if(StringUtils.isNotEmpty(l1Code))attr.put(GeneratorJSONProperties.PATH_l1Code,l1Code);
                    if(StringUtils.isNotEmpty(l2Code))attr.put(GeneratorJSONProperties.PATH_l2Code,l2Code);
                    columnJSON.put(GeneratorJSONProperties.PATH_attr,attr);

                    JSONObject validate = new JSONObject();
                    boolean needNotEmpty = false;
                    boolean needStringLength = false;
                    boolean needregexp = false;
                    JSONObject notEmpty = new JSONObject();
                    if(StringUtils.isNotEmpty(notEmptyMsg)){notEmpty.put("message",notEmptyMsg);needNotEmpty=true;}
                    JSONObject stringLength = new JSONObject();
                    if(StringUtils.isNotEmpty(min)){stringLength.put("min",Integer.parseInt(min));needStringLength=true;}
                    if(StringUtils.isNotEmpty(max)){stringLength.put("max",Integer.parseInt(max));needStringLength=true;}
                    if(StringUtils.isNotEmpty(strLengthMsg)){stringLength.put("message",strLengthMsg);needStringLength=true;}
                    JSONObject regexpobj = new JSONObject();
                    if(StringUtils.isNotEmpty(regexp_str)){regexpobj.put("regexp",regexp_str);needregexp=true;}
                    if(StringUtils.isNotEmpty(regExpMsg)){regexpobj.put("message",regExpMsg);needregexp=true;}
                    if(needNotEmpty==true)validate.put("notEmpty",notEmpty);
                    if(needStringLength==true)validate.put("stringLength",stringLength);
                    if(needregexp==true)validate.put("regexp",regexpobj);
                    columnJSON.put(GeneratorJSONProperties.PATH_validate,validate);

                    //如果是联合查询的字段，在Create_013_Mapper中需要放入字段列表
                    tic.addColumn(businessName,column,columnName,Boolean.getBoolean(isPrimaryKey), SQLTYPE.getSqlType(sqlType),columnTypeColumnSize,columnTypeColumnDecimalDigits,columnJSON);
                    c.addtoList(Context.CURR_TABLE_COLUMNS_NAME,slaveTableAlias+"."+column);//增加别名
                    c.addtoList(Context.CURR_TABLE_COLUMNS_NAME_TF,FormatUtils.formatDBNameToVarName(column));
                    c.addtoList(Context.CURR_TABLE_COLUMNS_COMMENT_ALL,columnName);
                    c.addtoList(Context.CURR_TABLE_COLUMNS_COMMENT,columnName);
                    c.addtoList(Context.CURR_TABLE_COLUMNS_COMMENT_JSON,columnJSON);
                    c.addtoList(Context.CURR_TABLE_COLUMNS_TYPE,sqlType);
                    c.addtoList(Context.CURR_TABLE_COLUMNS_TYPE_COLUMN_SIZE,columnTypeColumnSize);
                    c.addtoList(Context.CURR_TABLE_COLUMNS_TYPE_COLUMN_DECIMAL_DIGITS, columnTypeColumnDecimalDigits);
                }
            }
            c.addtoList(Context.UNION_QUERY_TABLES_TABLENAME_LIST, slaveTableName);
            c.addtoList(Context.UNION_QUERY_TABLES_TABLEALIAS_LIST, slaveTableAlias);
            c.addtoList(Context.UNION_QUERY_TABLES_SLAVE_TABLENAMES, slaveTableName);
        }

        c.put(Context.UNION_QUERY_TABLES_SUB_TABLENAME, subTableName);

        c.put(Context.HAS_SUB_TABLE,hasSubTable);
        if(needSub) {
            //在联合查询中不需要增加sub表，因此sub直接跳过
            //如果需要全部字段，则需要增加sub表
            TableInfoMetaCreater subtic = new TableInfoMetaCreater();
            if (hasSubTable.equalsIgnoreCase("true")) {
                for (Object o : subTableProperties) {
                    JSONObject columnInfo = (JSONObject) o;
                    String column = getInfoOrBase64Msg(columnInfo, "column");
                    String columnName = getInfoOrBase64Msg(columnInfo, "columnName");
                    String sqlType = getInfoOrBase64Msg(columnInfo, "sqlType");
                    String type = getInfoOrBase64Msg(columnInfo, "type");
                    String isPrimaryKey = getInfoOrBase64Msg(columnInfo, "isPrimaryKey");
                    String columnTypeColumnSize = getInfoOrBase64Msg(columnInfo, "columnTypeColumnSize");
                    String columnTypeColumnDecimalDigits = getInfoOrBase64Msg(columnInfo, "columnTypeColumnDecimalDigits");
                    String isNullAble = getInfoOrBase64Msg(columnInfo, "isNullAble");
                    String isUnion = getInfoOrBase64Msg(columnInfo, "isUnion");
                    String power = getInfoOrBase64Msg(columnInfo, "power");
                    String notEmptyMsg = getInfoOrBase64Msg(columnInfo, "notEmptyMsg");
                    String min = getInfoOrBase64Msg(columnInfo, "min");
                    String max = getInfoOrBase64Msg(columnInfo, "max");
                    String strLengthMsg = getInfoOrBase64Msg(columnInfo, "strLengthMsg");
                    String regexp_str = getInfoOrBase64Msg(columnInfo, "regExp");
                    String regExpMsg = getInfoOrBase64Msg(columnInfo, "regExpMsg");
                    String sequence = getInfoOrBase64Msg(columnInfo, "sequence");
                    String isMoney = getInfoOrBase64Msg(columnInfo, "isMoney");
                    String autoInsert = getInfoOrBase64Msg(columnInfo, "autoInsert");
                    String autoUpdate = getInfoOrBase64Msg(columnInfo, "autoUpdate");
                    String queryRange = getInfoOrBase64Msg(columnInfo, "queryRange");
                    String options = getInfoOrBase64Msg(columnInfo, "options");
                    String l1Code = getInfoOrBase64Msg(columnInfo, "l1Code");
                    String l2Code = getInfoOrBase64Msg(columnInfo, "l2Code");
                    String formatter = "yyyy-mm-dd hh:ii:ss;yyyy-MM-dd HH:mm:ss";
                    if (type.equals(GeneratorJSONProperties.FIELD_type_date)) {
                        formatter = GeneratorJSONProperties.DEFAULT_formatter_char8;
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_datetime)) {
                        formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                    }


                    //如果是联合查询的字段，在Create_013_Mapper中需要放入字段列表
                    JSONObject columnJSON = new JSONObject();
                    columnJSON.put(GeneratorJSONProperties.PATH_type, type);

                    JSONObject attr = new JSONObject();
                    if (StringUtils.isNotEmpty(power)) attr.put(GeneratorJSONProperties.PATH_power, power);
                    if (StringUtils.isNotEmpty(sequence)) attr.put(GeneratorJSONProperties.PATH_sequence, sequence);
                    if (StringUtils.isNotEmpty(isPrimaryKey)) {
                        attr.put(GeneratorJSONProperties.PATH_isPrimarykey, isPrimaryKey);
                        if (isPrimaryKey.trim().equalsIgnoreCase("true")) {
                            c.addtoList(Context.CURR_TABLE_PRIMARYKEY_COLUMN, mainTableAlias + "." + column);
                        }
                    } else {
                        attr.put(GeneratorJSONProperties.PATH_isPrimarykey, GeneratorJSONProperties.DEFAULT_isPrimarykey);
                    }
                    if (StringUtils.isNotEmpty(isMoney)) attr.put(GeneratorJSONProperties.PATH_ismoney, isMoney);
                    if (StringUtils.isNotEmpty(autoInsert)) {
                        attr.put(GeneratorJSONProperties.PATH_autoinsert, autoInsert);
                        attr.put(GeneratorJSONProperties.PATH_formatter, formatter);
                    }
                    if (StringUtils.isNotEmpty(autoUpdate))
                        attr.put(GeneratorJSONProperties.PATH_autoupdate, autoUpdate);
                    if (StringUtils.isNotEmpty(queryRange))
                        attr.put(GeneratorJSONProperties.PATH_queryrange, queryRange);
                    if (StringUtils.isNotEmpty(autoInsert))
                        attr.put(GeneratorJSONProperties.PATH_autoinsert, autoInsert);
                    if (StringUtils.isNotEmpty(options)) attr.put(GeneratorJSONProperties.PATH_options, options);
                    if (StringUtils.isNotEmpty(l1Code)) attr.put(GeneratorJSONProperties.PATH_l1Code, l1Code);
                    if (StringUtils.isNotEmpty(l2Code)) attr.put(GeneratorJSONProperties.PATH_l2Code, l2Code);
                    columnJSON.put(GeneratorJSONProperties.PATH_attr, attr);

                    JSONObject validate = new JSONObject();
                    boolean needNotEmpty = false;
                    boolean needStringLength = false;
                    boolean needregexp = false;
                    JSONObject notEmpty = new JSONObject();
                    if (StringUtils.isNotEmpty(notEmptyMsg)) {
                        notEmpty.put("message", notEmptyMsg);
                        needNotEmpty = true;
                    }
                    JSONObject stringLength = new JSONObject();
                    if (StringUtils.isNotEmpty(min)) {
                        stringLength.put("min", Integer.parseInt(min));
                        needStringLength = true;
                    }
                    if (StringUtils.isNotEmpty(max)) {
                        stringLength.put("max", Integer.parseInt(max));
                        needStringLength = true;
                    }
                    if (StringUtils.isNotEmpty(strLengthMsg)) {
                        stringLength.put("message", strLengthMsg);
                        needStringLength = true;
                    }
                    JSONObject regexpobj = new JSONObject();
                    if (StringUtils.isNotEmpty(regexp_str)) {
                        regexpobj.put("regexp", regexp_str);
                        needregexp = true;
                    }
                    if (StringUtils.isNotEmpty(regExpMsg)) {
                        regexpobj.put("message", regExpMsg);
                        needregexp = true;
                    }
                    if (needNotEmpty == true) validate.put("notEmpty", notEmpty);
                    if (needStringLength == true) validate.put("stringLength", stringLength);
                    if (needregexp == true) validate.put("regexp", regexpobj);
                    columnJSON.put(GeneratorJSONProperties.PATH_validate, validate);


                    subtic.addColumn(businessName, column, columnName, Boolean.getBoolean(isPrimaryKey), SQLTYPE.getSqlType(sqlType), columnTypeColumnSize, columnTypeColumnDecimalDigits, columnJSON);
                    c.addtoList(Context.CURR_SUB_TABLE_COLUMNS_NAME, subTableAlias + "." + column);//增加别名
                    c.addtoList(Context.CURR_SUB_TABLE_COLUMNS_NAME_TF, FormatUtils.formatDBNameToVarName(column));
                    c.addtoList(Context.CURR_SUB_TABLE_COLUMNS_COMMENT_ALL, columnName);
                    c.addtoList(Context.CURR_SUB_TABLE_COLUMNS_COMMENT, columnName);
                    c.addtoList(Context.CURR_SUB_TABLE_COLUMNS_COMMENT_JSON, columnJSON);
                    c.addtoList(Context.CURR_SUB_TABLE_COLUMNS_TYPE, sqlType);
                    c.addtoList(Context.CURR_SUB_TABLE_COLUMNS_TYPE_COLUMN_SIZE, columnTypeColumnSize);
                    c.addtoList(Context.CURR_SUB_TABLE_COLUMNS_TYPE_COLUMN_DECIMAL_DIGITS, columnTypeColumnDecimalDigits);
                }
                c.put(Context.CURR_SUB_TABLE_COLUMN_COUNT, subtic.getColumnCount(businessName));
            }
//这两个字段主要用于生成Mapper，而在Mapper中不需要sub，因此注释掉
//            c.addtoList(Context.UNION_QUERY_TABLES_TABLENAME_LIST, subTableName);
//            c.addtoList(Context.UNION_QUERY_TABLES_TABLEALIAS_LIST, subTableAlias);
        }

        c.put(Context.CURR_TABLE_COLUMN_COUNT, tic.getColumnCount(businessName));

        return result;
    }
}

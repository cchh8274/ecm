package pipe.unionimpl;

import context.Context;
import context.GeneratorJSONProperties;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pipe.Pipe;
import utils.FileUtils;
import utils.FormatUtils;
import utils.StringUtils;
import utils.TypeUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by baolong on 2017/2/27.
 */
public class Create_014_LogicImpl implements Pipe {
    public void exec(Context c) throws Exception {

        String pathLogic = (String) c.get(Context.PATH_LOGIC);
        String pathLogicImpl = (String)c.get(Context.PATH_LOGIC) + File.separator + "impl";

        //创建文件夹
        if(!FileUtils.mkdirs(pathLogic)){
            throw new Exception("文件夹["+pathLogic+"]创建不成功");
        }
        if(!FileUtils.mkdirs(pathLogicImpl)){
            throw new Exception("文件夹[" + pathLogicImpl + "]创建不成功");
        }
        String tableName = (String)c.get(Context.CURR_TABLE);
        String entityClassName = FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(tableName));
        String cleanentityClassName = FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(tableName));
        //去掉Tbl的头部
        if(cleanentityClassName.startsWith("Tbl")){
            cleanentityClassName = cleanentityClassName.substring(3);
        }

        entityClassName = "Union"+entityClassName;
        cleanentityClassName = "Union"+cleanentityClassName;

        String className = cleanentityClassName+"LogicImpl";
        String fileName = className+".java";
        File logicImplFile = new File(pathLogicImpl + File.separator + fileName);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(logicImplFile),(String)c.get(Context.FILE_CHARSET)));

        //准备内容
        StringBuilder sb = new StringBuilder();
        sb.append("/**\r\n * ecm Generator \r\n */\r\n");
        sb.append("package "+(String)c.get(Context.PACKAGE_LOGIC)+".impl;").append("\r\n").append("\r\n").append("\r\n");
        //增加import
        sb.append("import java.util.HashMap;").append("\r\n");
        sb.append("import java.util.List;").append("\r\n");
        sb.append("import java.util.Map;").append("\r\n").append("\r\n");

        sb.append("import net.sf.json.JSONObject;").append("\r\n").append("\r\n");


        sb.append("import org.springframework.beans.factory.annotation.Autowired;").append("\r\n");
        sb.append("import org.springframework.stereotype.Service;").append("\r\n");
        sb.append("import org.springframework.transaction.annotation.Propagation;").append("\r\n");
        sb.append("import org.springframework.transaction.annotation.Transactional;").append("\r\n").append("\r\n");


        sb.append("import cn.com.xbase.frame.logger.HLogger;").append("\r\n");
        sb.append("import cn.com.xbase.frame.logger.LoggerManager;").append("\r\n");
        sb.append("import cn.com.xbase.frame.util.MapObjTransUtils;").append("\r\n");
        sb.append("import cn.com.xbase.frame.util.DateUtils;").append("\r\n");
        sb.append("import cn.kanmars.ecm.util.PageQueryUtil;").append("\r\n");
        sb.append("import cn.kanmars.ecm.util.SysSequenceUtils;").append("\r\n");

        sb.append("import " + (String) c.get(Context.PACKAGE_DAO) + "." + entityClassName + "Mapper;").append("\r\n");


        String mainTableName = (String)c.get(Context.UNION_QUERY_TABLES_MAIN_TABLENAME);
        List<String> slaveTableNames = (List)c.get(Context.UNION_QUERY_TABLES_SLAVE_TABLENAMES);
        String subTableName = (String)c.get(Context.UNION_QUERY_TABLES_SUB_TABLENAME);
        String hasSlaveTables = (String)c.get(Context.HAS_SLAVE_TABLES);
        String hasSubTable = (String)c.get(Context.HAS_SUB_TABLE);

        //主表
        sb.append("import " + (String) c.get(Context.PACKAGE_ENTITY) + "." + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(mainTableName)) + ";").append("\r\n");
        sb.append("import " + (String) c.get(Context.PACKAGE_DAO) + "." + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(mainTableName)) + "Mapper;").append("\r\n");
        //从表
        if(hasSlaveTables.equalsIgnoreCase("true")) {
            for(String slaveTable : slaveTableNames){
                sb.append("import " + (String) c.get(Context.PACKAGE_ENTITY) + "." + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(slaveTable)) + ";").append("\r\n");
                sb.append("import " + (String) c.get(Context.PACKAGE_DAO) + "." + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(slaveTable)) + "Mapper;").append("\r\n");
            }
        }
        //子表
        if(hasSubTable.equalsIgnoreCase("true")){
            sb.append("import " + (String) c.get(Context.PACKAGE_ENTITY) + "." + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(subTableName)) + ";").append("\r\n");
            sb.append("import " + (String) c.get(Context.PACKAGE_DAO) + "." + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(subTableName)) + "Mapper;").append("\r\n");
        }

        //增加类注释
        sb.append("/**").append("\r\n");
        sb.append(" * "+(String)c.get(Context.CURR_TABLE_COMMENT)).append("\r\n");
        sb.append(" * "+(String)c.get(Context.CURR_TABLE)).append("\r\n");
        sb.append(" */").append("\r\n");

        //增加注解
        List<String> annotation_entity_list = (List)c.get(Context.ANNOTATION_LOGIC);
        annotation_entity_list = new ArrayList(new HashSet(annotation_entity_list));//去重
        if(annotation_entity_list!=null){
            for (String s : annotation_entity_list){
                sb.append("@"+s).append("\r\n");
            }
        }

        //增加类名
        sb.append("public class " + className + " ");
        String extendsClass = (String)c.get(Context.EXTENDS_LOGIC);
        if(!StringUtils.isEmpty(extendsClass)){
            sb.append("extends " + extendsClass+ " ");
        }

        //增加接口
        sb.append("implements " + (String) c.get(Context.PACKAGE_LOGIC) + "." + cleanentityClassName + "Logic");//cn.kanmars.ecm.admin.logic.UserInfoLogic
        List<String> implements_entity_list = (List)c.get(Context.IMPLEMENTS_LOGIC);
        if(implements_entity_list!=null){
            for (int i=0;i<implements_entity_list.size();i++){
                sb.append("," + implements_entity_list.get(i));
            }
        }

        sb.append("{").append("\r\n").append("\r\n");

        sb.append("    protected HLogger logger = LoggerManager.getLoger(\""+ className + "\");").append("\r\n").append("\r\n");



        sb.append("    @Autowired").append("\r\n");
        sb.append("    private " + entityClassName + "Mapper "+FormatUtils.firstSmall(entityClassName)+"Mapper;").append("\r\n");
        //主表
        sb.append("    @Autowired").append("\r\n");
        sb.append("    private " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(mainTableName)) + "Mapper "+FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName))+"Mapper;").append("\r\n");
        //从表
        if(hasSlaveTables.equalsIgnoreCase("true")) {
            for(String slaveTable : slaveTableNames){
                sb.append("    @Autowired").append("\r\n");
                sb.append("    private " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(slaveTable)) + "Mapper "+FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTable))+"Mapper;").append("\r\n");
            }
        }
        //子表
        if(hasSubTable.equalsIgnoreCase("true")){
            sb.append("    @Autowired").append("\r\n");
            sb.append("    private " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(subTableName)) + "Mapper "+FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName))+"Mapper;").append("\r\n");
        }



        //########################################################INSERT###########################################################################################################
        {
            // insert语句
            sb.append("    /*").append("\r\n");
            sb.append("     * 新增信息").append("\r\n");
            sb.append("     */").append("\r\n");
            sb.append("    @Transactional(value=\"ecm-txManager\",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)").append("\r\n");
            sb.append("    public void insert" + cleanentityClassName + "(HashMap paramMap) throws Exception {").append("\r\n");
            sb.append("        logger.debug(\"insert" + cleanentityClassName + ":start\");").append("\r\n");
            sb.append("        logger.debug(\"传入参数:paramMap[\"+paramMap+\"]\");").append("\r\n");
            sb.append("        int count =0;").append("\r\n");


            int pkidx = 0;
            {
                sb.append("        " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(mainTableName)) + " " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + " = new " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(mainTableName)) + "();").append("\r\n");
                sb.append("        MapObjTransUtils.mapToObj(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + ", paramMap);").append("\r\n");
                JSONArray mainTableProperties = ((JSONObject) c.get("jsonParam")).getJSONArray("mainTableProperties");
                //------------------------------主表insert开始
                for (Object column_obj : mainTableProperties) {
                    //主键
                    JSONObject columnInfo = (JSONObject) column_obj;
                    String column = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "column");
                    String columnName = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnName");
                    String sqlType = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sqlType");
                    String type = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "type");
                    String isPrimaryKey = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isPrimaryKey");
                    String columnTypeColumnSize = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnSize");
                    String columnTypeColumnDecimalDigits = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnDecimalDigits");
                    String isNullAble = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isNullAble");
                    String isUnion = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isUnion");
                    String power = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "power");
                    String notEmptyMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "notEmptyMsg");
                    String min = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "min");
                    String max = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "max");
                    String strLengthMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "strLengthMsg");
                    String regexp_str = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExp");
                    String regExpMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExpMsg");
                    String sequence = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sequence");
                    String isMoney = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isMoney");
                    String autoInsert = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoInsert");
                    String autoUpdate = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoUpdate");
                    String queryRange = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "queryRange");
                    String formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                    if (type.equals(GeneratorJSONProperties.FIELD_type_date)) {
                        formatter = GeneratorJSONProperties.DEFAULT_formatter_char8;
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_datetime)) {
                        formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                    }

                    if (new Boolean(isPrimaryKey) && StringUtils.isNotEmpty(sequence)) {
                        sb.append("        String pk" + pkidx + " = SysSequenceUtils.generateStringId(\"" + sequence + "\");").append("\r\n");
                        sb.append("        " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(column)) + "(");
                        sb.append(TypeUtils.transStringVar2JavaType(sqlType, columnTypeColumnSize, columnTypeColumnDecimalDigits, "pk" + pkidx));
                        sb.append(");").append("").append("\r\n");
                        pkidx++;
                    }
                }
                for (Object column_obj : mainTableProperties) {
                    //时间
                    JSONObject columnInfo = (JSONObject) column_obj;
                    String column = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "column");
                    String columnName = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnName");
                    String sqlType = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sqlType");
                    String type = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "type");
                    String isPrimaryKey = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isPrimaryKey");
                    String columnTypeColumnSize = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnSize");
                    String columnTypeColumnDecimalDigits = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnDecimalDigits");
                    String isNullAble = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isNullAble");
                    String isUnion = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isUnion");
                    String power = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "power");
                    String notEmptyMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "notEmptyMsg");
                    String min = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "min");
                    String max = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "max");
                    String strLengthMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "strLengthMsg");
                    String regexp_str = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExp");
                    String regExpMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExpMsg");
                    String sequence = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sequence");
                    String isMoney = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isMoney");
                    String autoInsert = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoInsert");
                    String autoUpdate = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoUpdate");
                    String queryRange = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "queryRange");
                    String formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                    if (type.equals(GeneratorJSONProperties.FIELD_type_date)) {
                        formatter = GeneratorJSONProperties.DEFAULT_formatter_char8;
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_datetime)) {
                        formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                    }

                    if (type.equals(GeneratorJSONProperties.FIELD_type_date) && new Boolean(autoInsert)) {
                        sb.append("        " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(column)) + "(");
                        sb.append("DateUtils.getCurrDate()");
                        sb.append(");").append("").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_datetime) && new Boolean(autoInsert)) {
                        sb.append("        " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(column)) + "(");
                        sb.append("DateUtils.getCurrDateTime()");
                        sb.append(");").append("").append("\r\n");
                    }
                }

                sb.append("        count = " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + "Mapper.insert(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + ");").append("\r\n");
                sb.append("        logger.debug(\"操作["+mainTableName+"]结果:count[\"+count+\"]\");").append("\r\n");
                sb.append("        if(count<=0){").append("\r\n");
                sb.append("            throw new Exception(\"插入主表[" + mainTableName + "]异常!\");").append("\r\n");
                sb.append("        }").append("\r\n");
                //------------------------------主表insert结束
            }


            if(hasSlaveTables.equalsIgnoreCase("true")) {
                //------------------------------从表insert开始

                JSONArray slaveTables = ((JSONObject) c.get("jsonParam")).getJSONArray("slaveTables");

                for (Object slaveTable_obj : slaveTables) {
                    JSONObject slaveTable = (JSONObject) slaveTable_obj;
                    String slaveTableName = slaveTable.getString("slaveTableName");
                    String slaveTableAlias = slaveTable.getString("slaveTableAlias").trim();
                    String slaveTableWhere = slaveTable.getString("slaveTableWhere").trim();
                    JSONArray slaveTableProperties = ((JSONObject) slaveTable).getJSONArray("buildParam");

                    sb.append("        " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(slaveTableName)) + " " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + " = new " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(slaveTableName)) + "();").append("\r\n");
                    sb.append("        MapObjTransUtils.mapToObj(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + ", paramMap);").append("\r\n");

                    for (Object column_obj : slaveTableProperties) {
                        //主键
                        JSONObject columnInfo = (JSONObject) column_obj;
                        String column = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "column");
                        String columnName = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnName");
                        String sqlType = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sqlType");
                        String type = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "type");
                        String isPrimaryKey = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isPrimaryKey");
                        String columnTypeColumnSize = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnSize");
                        String columnTypeColumnDecimalDigits = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnDecimalDigits");
                        String isNullAble = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isNullAble");
                        String isUnion = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isUnion");
                        String power = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "power");
                        String notEmptyMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "notEmptyMsg");
                        String min = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "min");
                        String max = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "max");
                        String strLengthMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "strLengthMsg");
                        String regexp_str = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExp");
                        String regExpMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExpMsg");
                        String sequence = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sequence");
                        String isMoney = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isMoney");
                        String autoInsert = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoInsert");
                        String autoUpdate = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoUpdate");
                        String queryRange = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "queryRange");
                        String formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                        if (type.equals(GeneratorJSONProperties.FIELD_type_date)) {
                            formatter = GeneratorJSONProperties.DEFAULT_formatter_char8;
                        }
                        if (type.equals(GeneratorJSONProperties.FIELD_type_datetime)) {
                            formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                        }

                        if (new Boolean(isPrimaryKey) && StringUtils.isNotEmpty(sequence)) {
                            sb.append("        String pk" + pkidx + " = SysSequenceUtils.generateStringId(\"" + sequence + "\");").append("\r\n");
                            sb.append("        " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(column)) + "(");
                            sb.append(TypeUtils.transStringVar2JavaType(sqlType, columnTypeColumnSize, columnTypeColumnDecimalDigits, "pk" + pkidx));
                            sb.append(");").append("").append("\r\n");
                            pkidx++;
                        }
                    }
                    for (Object column_obj : slaveTableProperties) {
                        //时间
                        JSONObject columnInfo = (JSONObject) column_obj;
                        String column = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "column");
                        String columnName = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnName");
                        String sqlType = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sqlType");
                        String type = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "type");
                        String isPrimaryKey = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isPrimaryKey");
                        String columnTypeColumnSize = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnSize");
                        String columnTypeColumnDecimalDigits = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnDecimalDigits");
                        String isNullAble = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isNullAble");
                        String isUnion = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isUnion");
                        String power = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "power");
                        String notEmptyMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "notEmptyMsg");
                        String min = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "min");
                        String max = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "max");
                        String strLengthMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "strLengthMsg");
                        String regexp_str = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExp");
                        String regExpMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExpMsg");
                        String sequence = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sequence");
                        String isMoney = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isMoney");
                        String autoInsert = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoInsert");
                        String autoUpdate = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoUpdate");
                        String queryRange = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "queryRange");
                        String formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                        if (type.equals(GeneratorJSONProperties.FIELD_type_date)) {
                            formatter = GeneratorJSONProperties.DEFAULT_formatter_char8;
                        }
                        if (type.equals(GeneratorJSONProperties.FIELD_type_datetime)) {
                            formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                        }

                        if (type.equals(GeneratorJSONProperties.FIELD_type_date) && new Boolean(autoInsert)) {
                            sb.append("        " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(column)) + "(");
                            sb.append("DateUtils.getCurrDate()");
                            sb.append(");").append("").append("\r\n");
                        }
                        if (type.equals(GeneratorJSONProperties.FIELD_type_datetime) && new Boolean(autoInsert)) {
                            sb.append("        " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(column)) + "(");
                            sb.append("DateUtils.getCurrDateTime()");
                            sb.append(");").append("").append("\r\n");
                        }
                    }

                    {
                        //增加关联字段
                        if(!slaveTableWhere.startsWith(slaveTableAlias)){
                            slaveTableWhere = slaveTableWhere.split("=")[1]+"="+slaveTableWhere.split("=")[0];//设置slavetable在关联条件中放在前面
                        }
                        //获取到关联表名称
                        String othAlias = slaveTableWhere.split("=")[1].split("\\.")[0];
                        String othColumn = slaveTableWhere.split("=")[1].split("\\.")[1];
                        String othTable = "";
                        {
                            String mainTableAlias = ((JSONObject) c.get("jsonParam")).getString("mainTableAlias");
                            if(othAlias.equals(mainTableAlias)){
                                othTable =  ((JSONObject) c.get("jsonParam")).getString("mainTableName");
                            }
                        }
                        {
                            for (Object slaveTable_obj_2 : slaveTables) {
                                JSONObject slaveTable_2 = (JSONObject) slaveTable_obj_2;
                                String slaveTableName_2 = slaveTable_2.getString("slaveTableName");
                                String slaveTableAlias_2 = slaveTable_2.getString("slaveTableAlias");
                                String slaveTableWhere_2 = slaveTable_2.getString("slaveTableWhere");
                                if(othAlias.equals(slaveTableAlias_2)){
                                    othTable =  slaveTableName_2;
                                }
                            }
                        }
                        if(othAlias.equals(slaveTableAlias)){
                            throw new Exception("从表的关联条件不能是从表自己！");
                        }
                        sb.append("        " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(slaveTableWhere.split("=")[0].replace(slaveTableAlias + ".", "").trim())) + "(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(othTable)) + ".get" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(othColumn)) + "());").append("\r\n");
                    }

                    sb.append("        count = " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + "Mapper.insert(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + ");").append("\r\n");
                    sb.append("        logger.debug(\"操作["+slaveTableName+"]结果:count[\"+count+\"]\");").append("\r\n");
                    sb.append("        if(count<=0){").append("\r\n");
                    sb.append("            throw new Exception(\"插入从表[" + slaveTableName + "]异常!\");").append("\r\n");
                    sb.append("        }").append("\r\n");
                }
                //------------------------------从表insert结束
            }

            if(hasSubTable.equalsIgnoreCase("true")) {
                //------------------------------子表insert开始
                JSONArray subTableProperties = ((JSONObject) c.get("jsonParam")).getJSONArray("subTableProperties");
                sb.append("        List list = (List) paramMap.get(PageQueryUtil.SUBARRAY);").append("\r\n");
                sb.append("        for (int i = 0; i < list.size(); i++) {").append("\r\n");
                sb.append("            HashMap<String, Object> recordsMap = (HashMap<String, Object>) list.get(i);").append("\r\n");
                sb.append("            " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(subTableName)) + " " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + " = new " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(subTableName)) + "();").append("\r\n");
                sb.append("            MapObjTransUtils.mapToObj(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + ", recordsMap);").append("\r\n");

                for (Object column_obj : subTableProperties) {
                    //主键
                    JSONObject columnInfo = (JSONObject) column_obj;
                    String column = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "column");
                    String columnName = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnName");
                    String sqlType = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sqlType");
                    String type = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "type");
                    String isPrimaryKey = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isPrimaryKey");
                    String columnTypeColumnSize = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnSize");
                    String columnTypeColumnDecimalDigits = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnDecimalDigits");
                    String isNullAble = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isNullAble");
                    String isUnion = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isUnion");
                    String power = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "power");
                    String notEmptyMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "notEmptyMsg");
                    String min = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "min");
                    String max = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "max");
                    String strLengthMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "strLengthMsg");
                    String regexp_str = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExp");
                    String regExpMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExpMsg");
                    String sequence = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sequence");
                    String isMoney = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isMoney");
                    String autoInsert = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoInsert");
                    String autoUpdate = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoUpdate");
                    String queryRange = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "queryRange");
                    String formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                    if (type.equals(GeneratorJSONProperties.FIELD_type_date)) {
                        formatter = GeneratorJSONProperties.DEFAULT_formatter_char8;
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_datetime)) {
                        formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                    }

                    if (new Boolean(isPrimaryKey) && StringUtils.isNotEmpty(sequence)) {
                        sb.append("            String pk" + pkidx + " = SysSequenceUtils.generateStringId(\"" + sequence + "\");").append("\r\n");
                        sb.append("            " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(column)) + "(");
                        sb.append(TypeUtils.transStringVar2JavaType(sqlType, columnTypeColumnSize, columnTypeColumnDecimalDigits, "pk" + pkidx));
                        sb.append(");").append("").append("\r\n");
                        pkidx++;
                    }
                }

                for (Object column_obj : subTableProperties) {
                    //时间
                    JSONObject columnInfo = (JSONObject) column_obj;
                    String column = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "column");
                    String columnName = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnName");
                    String sqlType = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sqlType");
                    String type = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "type");
                    String isPrimaryKey = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isPrimaryKey");
                    String columnTypeColumnSize = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnSize");
                    String columnTypeColumnDecimalDigits = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnDecimalDigits");
                    String isNullAble = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isNullAble");
                    String isUnion = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isUnion");
                    String power = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "power");
                    String notEmptyMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "notEmptyMsg");
                    String min = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "min");
                    String max = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "max");
                    String strLengthMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "strLengthMsg");
                    String regexp_str = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExp");
                    String regExpMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExpMsg");
                    String sequence = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sequence");
                    String isMoney = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isMoney");
                    String autoInsert = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoInsert");
                    String autoUpdate = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoUpdate");
                    String queryRange = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "queryRange");
                    String formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                    if (type.equals(GeneratorJSONProperties.FIELD_type_date)) {
                        formatter = GeneratorJSONProperties.DEFAULT_formatter_char8;
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_datetime)) {
                        formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                    }

                    if (type.equals(GeneratorJSONProperties.FIELD_type_date) && new Boolean(autoInsert)) {
                        sb.append("            " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(column)) + "(");
                        sb.append("DateUtils.getCurrDate()");
                        sb.append(");").append("").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_datetime) && new Boolean(autoInsert)) {
                        sb.append("            " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(column)) + "(");
                        sb.append("DateUtils.getCurrDateTime()");
                        sb.append(");").append("").append("\r\n");
                    }
                }

                {
                    //增加子表关联
                    String subTableAlias = ((JSONObject) c.get("jsonParam")).getString("subTableAlias");
                    String subTableWhere = ((JSONObject) c.get("jsonParam")).getString("subTableWhere");
                    subTableWhere = subTableWhere.trim();
                    if (!subTableWhere.startsWith(subTableAlias)) {
                        subTableWhere = subTableWhere.split("=")[1] + "=" + subTableWhere.split("=")[0];//设置subtable在关联条件中放在前面
                    }
                    //获取到关联表名称
                    String othAlias = subTableWhere.split("=")[1].split("\\.")[0];
                    String othColumn = subTableWhere.split("=")[1].split("\\.")[1];
                    String othTable = "";
                    {
                        String mainTableAlias = ((JSONObject) c.get("jsonParam")).getString("mainTableAlias");
                        if (othAlias.equals(mainTableAlias)) {
                            othTable = ((JSONObject) c.get("jsonParam")).getString("mainTableName");
                        }
                    }
                    {
                        JSONArray slaveTables = ((JSONObject) c.get("jsonParam")).getJSONArray("slaveTables");
                        for (Object slaveTable_obj : slaveTables) {
                            JSONObject slaveTable = (JSONObject) slaveTable_obj;
                            String slaveTableName = slaveTable.getString("slaveTableName");
                            String slaveTableAlias = slaveTable.getString("slaveTableAlias");
                            String slaveTableWhere = slaveTable.getString("slaveTableWhere");
                            if (othAlias.equals(slaveTableAlias)) {
                                othTable = slaveTableName;
                            }
                        }
                    }
                    if (othAlias.equals(subTableAlias)) {
                        throw new Exception("从表的关联条件不能是从表自己！");
                    }
                    sb.append("            " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(subTableWhere.split("=")[0].replace(subTableAlias + ".", "").trim())) + "(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(othTable)) + ".get" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(othColumn)) + "());").append("\r\n");
                }

                sb.append("            count = " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + "Mapper.insert(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + ");").append("\r\n");
                sb.append("            logger.debug(\"操作["+subTableName+"]结果:count[\"+count+\"]\");").append("\r\n");
                sb.append("            if(count<=0){").append("\r\n");
                sb.append("                throw new Exception(\"插入子表[" + subTableName + "]异常!\");").append("\r\n");
                sb.append("            }").append("\r\n");
                sb.append("        }").append("\r\n");
                //------------------------------子表insert结束
            }
            sb.append("        logger.debug(\"insert" + cleanentityClassName + ":end\");").append("\r\n");
            sb.append("    }").append("\r\n");
        }


        //########################################################UPDATE###########################################################################################################
        {
            sb.append("    /*").append("\r\n");
            sb.append("     * 修改信息").append("\r\n");
            sb.append("     */").append("\r\n");
            sb.append("    @Transactional(value=\"ecm-txManager\",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)").append("\r\n");
            sb.append("    public void update" + cleanentityClassName + "(HashMap paramMap) throws Exception {").append("\r\n");
            sb.append("        logger.debug(\"update" + cleanentityClassName + ":start\");").append("\r\n");
            sb.append("        logger.debug(\"传入参数:paramMap[\"+paramMap+\"]\");").append("\r\n");
            sb.append("        int count =0;").append("\r\n");
            {
                //主表修改
                sb.append("        " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(mainTableName)) + " " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + " = new " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(mainTableName)) + "();").append("\r\n");
                sb.append("        MapObjTransUtils.mapToObj(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + ", paramMap);").append("\r\n");
                JSONArray mainTableProperties = ((JSONObject) c.get("jsonParam")).getJSONArray("mainTableProperties");
                //------------------------------主表设置主键开始
                sb.append("        String id_key = (String)paramMap.get(\"id_key\");").append("\r\n");
                int maintableIdKeyIdx = 0;
                for (Object column_obj : mainTableProperties) {
                    //主键
                    JSONObject columnInfo = (JSONObject) column_obj;
                    String column = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "column");
                    String columnName = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnName");
                    String sqlType = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sqlType");
                    String type = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "type");
                    String isPrimaryKey = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isPrimaryKey");
                    String columnTypeColumnSize = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnSize");
                    String columnTypeColumnDecimalDigits = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnDecimalDigits");
                    String isNullAble = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isNullAble");
                    String isUnion = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isUnion");
                    String power = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "power");
                    String notEmptyMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "notEmptyMsg");
                    String min = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "min");
                    String max = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "max");
                    String strLengthMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "strLengthMsg");
                    String regexp_str = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExp");
                    String regExpMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExpMsg");
                    String sequence = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sequence");
                    String isMoney = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isMoney");
                    String autoInsert = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoInsert");
                    String autoUpdate = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoUpdate");
                    String queryRange = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "queryRange");
                    String formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                    if (type.equals(GeneratorJSONProperties.FIELD_type_date)) {
                        formatter = GeneratorJSONProperties.DEFAULT_formatter_char8;
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_datetime)) {
                        formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                    }

                    if (new Boolean(isPrimaryKey) && StringUtils.isNotEmpty(sequence)) {
                        sb.append("        " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(column)) + "(" + TypeUtils.transStringVar2JavaType(sqlType, columnTypeColumnSize, columnTypeColumnDecimalDigits, "id_key")).append(");\r\n");
                        maintableIdKeyIdx++;
                    }
                }

                //设置自动更新的字段
                for (Object column_obj : mainTableProperties) {
                    //时间
                    JSONObject columnInfo = (JSONObject) column_obj;
                    String column = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "column");
                    String columnName = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnName");
                    String sqlType = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sqlType");
                    String type = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "type");
                    String isPrimaryKey = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isPrimaryKey");
                    String columnTypeColumnSize = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnSize");
                    String columnTypeColumnDecimalDigits = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnDecimalDigits");
                    String isNullAble = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isNullAble");
                    String isUnion = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isUnion");
                    String power = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "power");
                    String notEmptyMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "notEmptyMsg");
                    String min = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "min");
                    String max = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "max");
                    String strLengthMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "strLengthMsg");
                    String regexp_str = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExp");
                    String regExpMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExpMsg");
                    String sequence = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sequence");
                    String isMoney = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isMoney");
                    String autoInsert = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoInsert");
                    String autoUpdate = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoUpdate");
                    String queryRange = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "queryRange");
                    String formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                    if (type.equals(GeneratorJSONProperties.FIELD_type_date)) {
                        formatter = GeneratorJSONProperties.DEFAULT_formatter_char8;
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_datetime)) {
                        formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                    }

                    if (type.equals(GeneratorJSONProperties.FIELD_type_date) && new Boolean(autoUpdate)) {
                        sb.append("        " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(column)) + "(");
                        sb.append("DateUtils.getCurrDate()");
                        sb.append(");").append("").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_datetime) && new Boolean(autoUpdate)) {
                        sb.append("        " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(column)) + "(");
                        sb.append("DateUtils.getCurrDateTime()");
                        sb.append(");").append("").append("\r\n");
                    }
                }

                sb.append("        count = " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + "Mapper.updateByPrimaryKey(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + ");").append("\r\n");
                sb.append("        logger.debug(\"操作["+mainTableName+"]结果:count[\"+count+\"]\");").append("\r\n");
                sb.append("        if(count<=0){").append("\r\n");
                sb.append("            throw new Exception(\"修改主表[" + mainTableName + "]异常!\");").append("\r\n");
                sb.append("        }").append("\r\n");
            }


            if(hasSlaveTables.equalsIgnoreCase("true")) {
                //从表修改
                JSONArray slaveTables = ((JSONObject) c.get("jsonParam")).getJSONArray("slaveTables");
                for (Object slaveTable_obj : slaveTables) {
                    JSONObject slaveTable = (JSONObject) slaveTable_obj;
                    String slaveTableName = slaveTable.getString("slaveTableName");
                    String slaveTableAlias = slaveTable.getString("slaveTableAlias");
                    String slaveTableWhere = slaveTable.getString("slaveTableWhere");
                    JSONArray slaveTableProperties = ((JSONObject) slaveTable).getJSONArray("buildParam");

                    sb.append("        " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(slaveTableName)) + " " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + " = new " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(slaveTableName)) + "();").append("\r\n");
                    sb.append("        MapObjTransUtils.mapToObj(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + ", paramMap);").append("\r\n");

                    //设置自动更新的字段
                    for (Object column_obj : slaveTableProperties) {
                        //时间
                        JSONObject columnInfo = (JSONObject) column_obj;
                        String column = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "column");
                        String columnName = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnName");
                        String sqlType = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sqlType");
                        String type = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "type");
                        String isPrimaryKey = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isPrimaryKey");
                        String columnTypeColumnSize = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnSize");
                        String columnTypeColumnDecimalDigits = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnDecimalDigits");
                        String isNullAble = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isNullAble");
                        String isUnion = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isUnion");
                        String power = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "power");
                        String notEmptyMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "notEmptyMsg");
                        String min = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "min");
                        String max = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "max");
                        String strLengthMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "strLengthMsg");
                        String regexp_str = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExp");
                        String regExpMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExpMsg");
                        String sequence = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sequence");
                        String isMoney = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isMoney");
                        String autoInsert = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoInsert");
                        String autoUpdate = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoUpdate");
                        String queryRange = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "queryRange");
                        String formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                        if (type.equals(GeneratorJSONProperties.FIELD_type_date)) {
                            formatter = GeneratorJSONProperties.DEFAULT_formatter_char8;
                        }
                        if (type.equals(GeneratorJSONProperties.FIELD_type_datetime)) {
                            formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                        }

                        if (type.equals(GeneratorJSONProperties.FIELD_type_date) && new Boolean(autoUpdate)) {
                            sb.append("        " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(column)) + "(");
                            sb.append("DateUtils.getCurrDate()");
                            sb.append(");").append("").append("\r\n");
                        }
                        if (type.equals(GeneratorJSONProperties.FIELD_type_datetime) && new Boolean(autoUpdate)) {
                            sb.append("        " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(column)) + "(");
                            sb.append("DateUtils.getCurrDateTime()");
                            sb.append(");").append("").append("\r\n");
                        }
                    }

                    sb.append("        count = " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + "Mapper.updateByPrimaryKey(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + ");").append("\r\n");
                    sb.append("        logger.debug(\"操作["+slaveTableName+"]结果:count[\"+count+\"]\");").append("\r\n");
                    sb.append("        if(count<=0){").append("\r\n");
                    sb.append("            throw new Exception(\"修改从表[" + slaveTableName + "]异常!\");").append("\r\n");
                    sb.append("        }").append("\r\n");
                }
                //从表修改
            }


            if(hasSubTable.equalsIgnoreCase("true")) {
                //子表修改
                sb.append("        //先删除子表数据  重新添加").append("\r\n");
                sb.append("        " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(subTableName)) + " " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + "_tmp = new " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(subTableName)) + "();").append("\r\n");
                //根据关联条件，修改此处的字段
                //获取到主表的alias，輔表的alias，从表的alias自动赋值
//                String subTableName = ((JSONObject) c.get("jsonParam")).getJSONArray("slaveTables");
                String subTableAlias = ((JSONObject) c.get("jsonParam")).getString("subTableAlias");
                String subTableWhere = ((JSONObject) c.get("jsonParam")).getString("subTableWhere");
                subTableWhere = subTableWhere.trim();
                if(!subTableWhere.startsWith(subTableAlias)){
                    subTableWhere = subTableWhere.split("=")[1]+"="+subTableWhere.split("=")[0];//设置subtable在关联条件中放在前面
                }
                //获取到关联表名称
                String othAlias = subTableWhere.split("=")[1].split("\\.")[0];
                String othColumn = subTableWhere.split("=")[1].split("\\.")[1];
                String othTable = "";
                {
                    String mainTableAlias = ((JSONObject) c.get("jsonParam")).getString("mainTableAlias");
                    if(othAlias.equals(mainTableAlias)){
                        othTable =  ((JSONObject) c.get("jsonParam")).getString("mainTableName");
                    }
                }
                {
                    JSONArray slaveTables = ((JSONObject) c.get("jsonParam")).getJSONArray("slaveTables");
                    for (Object slaveTable_obj : slaveTables) {
                        JSONObject slaveTable = (JSONObject) slaveTable_obj;
                        String slaveTableName = slaveTable.getString("slaveTableName");
                        String slaveTableAlias = slaveTable.getString("slaveTableAlias");
                        String slaveTableWhere = slaveTable.getString("slaveTableWhere");
                        if(othAlias.equals(slaveTableAlias)){
                            othTable =  slaveTableName;
                        }
                    }
                }
                if(othAlias.equals(subTableAlias)){
                    throw new Exception("子表的关联条件不能是子表自己！");
                }
                sb.append("        " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + "_tmp.set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(subTableWhere.split("=")[0].replace(subTableAlias + ".", "").trim())) + "(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(othTable)) + ".get" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(othColumn)) + "());").append("\r\n");
                sb.append("        int delCount = " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + "Mapper.delete(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + "_tmp);").append("\r\n");
                sb.append("        logger.debug(\"删除["+subTableName+"]结果:count[\"+delCount+\"]\");").append("\r\n");


                JSONArray subTableProperties = ((JSONObject) c.get("jsonParam")).getJSONArray("subTableProperties");
                sb.append("        List list = (List) paramMap.get(PageQueryUtil.SUBARRAY);").append("\r\n");
                sb.append("        for (int i = 0; i < list.size(); i++) {").append("\r\n");
                sb.append("            HashMap<String, Object> recordsMap = (HashMap<String, Object>) list.get(i);").append("\r\n");
                sb.append("            " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(subTableName)) + " " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + " = new " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(subTableName)) + "();").append("\r\n");
                sb.append("            MapObjTransUtils.mapToObj(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + ", recordsMap);").append("\r\n");
                int pkidx = 0;
                for (Object column_obj : subTableProperties) {
                    //主键
                    JSONObject columnInfo = (JSONObject) column_obj;
                    String column = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "column");
                    String columnName = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnName");
                    String sqlType = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sqlType");
                    String type = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "type");
                    String isPrimaryKey = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isPrimaryKey");
                    String columnTypeColumnSize = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnSize");
                    String columnTypeColumnDecimalDigits = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnDecimalDigits");
                    String isNullAble = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isNullAble");
                    String isUnion = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isUnion");
                    String power = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "power");
                    String notEmptyMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "notEmptyMsg");
                    String min = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "min");
                    String max = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "max");
                    String strLengthMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "strLengthMsg");
                    String regexp_str = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExp");
                    String regExpMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExpMsg");
                    String sequence = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sequence");
                    String isMoney = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isMoney");
                    String autoInsert = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoInsert");
                    String autoUpdate = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoUpdate");
                    String queryRange = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "queryRange");
                    String formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                    if (type.equals(GeneratorJSONProperties.FIELD_type_date)) {
                        formatter = GeneratorJSONProperties.DEFAULT_formatter_char8;
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_datetime)) {
                        formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                    }

                    if (new Boolean(isPrimaryKey) && StringUtils.isNotEmpty(sequence)) {
                        sb.append("            String pk" + pkidx + " = SysSequenceUtils.generateStringId(\"" + sequence + "\");").append("\r\n");
                        sb.append("            " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(column)) + "(");
                        sb.append(TypeUtils.transStringVar2JavaType(sqlType, columnTypeColumnSize, columnTypeColumnDecimalDigits, "pk" + pkidx));
                        sb.append(");").append("").append("\r\n");
                        pkidx++;
                    }
                }

                for (Object column_obj : subTableProperties) {
                    //时间
                    JSONObject columnInfo = (JSONObject) column_obj;
                    String column = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "column");
                    String columnName = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnName");
                    String sqlType = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sqlType");
                    String type = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "type");
                    String isPrimaryKey = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isPrimaryKey");
                    String columnTypeColumnSize = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnSize");
                    String columnTypeColumnDecimalDigits = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnDecimalDigits");
                    String isNullAble = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isNullAble");
                    String isUnion = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isUnion");
                    String power = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "power");
                    String notEmptyMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "notEmptyMsg");
                    String min = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "min");
                    String max = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "max");
                    String strLengthMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "strLengthMsg");
                    String regexp_str = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExp");
                    String regExpMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExpMsg");
                    String sequence = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sequence");
                    String isMoney = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isMoney");
                    String autoInsert = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoInsert");
                    String autoUpdate = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoUpdate");
                    String queryRange = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "queryRange");
                    String formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                    if (type.equals(GeneratorJSONProperties.FIELD_type_date)) {
                        formatter = GeneratorJSONProperties.DEFAULT_formatter_char8;
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_datetime)) {
                        formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                    }

                    if (type.equals(GeneratorJSONProperties.FIELD_type_date) && new Boolean(autoInsert)) {
                        sb.append("            " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(column)) + "(");
                        sb.append("DateUtils.getCurrDate()");
                        sb.append(");").append("").append("\r\n");
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_datetime) && new Boolean(autoInsert)) {
                        sb.append("            " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(column)) + "(");
                        sb.append("DateUtils.getCurrDateTime()");
                        sb.append(");").append("").append("\r\n");
                    }
                }
                //增加关联字段设置
                sb.append("            " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(subTableWhere.split("=")[0].replace(subTableAlias + ".", "").trim())) + "(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(othTable)) + ".get" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(othColumn)) + "());").append("\r\n");

                sb.append("            count = " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + "Mapper.insert(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + ");").append("\r\n");
                sb.append("            logger.debug(\"操作["+subTableName+"]结果:count[\"+count+\"]\");").append("\r\n");
                sb.append("            if(count<=0){").append("\r\n");
                sb.append("                throw new Exception(\"插入子表[" + subTableName + "]异常!\");").append("\r\n");
                sb.append("            }").append("\r\n");
                sb.append("        }").append("\r\n");
                sb.append("").append("\r\n");
            }
            sb.append("        logger.debug(\"update" + cleanentityClassName + ":end\");").append("\r\n");
            sb.append("    }").append("\r\n");
        }

        //########################################################DELETE###########################################################################################################
        {
            sb.append("    /*").append("\r\n");
            sb.append("     * 删除信息").append("\r\n");
            sb.append("     */").append("\r\n");
            sb.append("    @Transactional(value=\"ecm-txManager\",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)").append("\r\n");
            sb.append("    public void delete" + cleanentityClassName + "(HashMap paramMap) throws Exception {").append("\r\n");
            sb.append("        logger.debug(\"delete" + cleanentityClassName + ":start\");").append("\r\n");
            sb.append("        logger.debug(\"传入参数:paramMap[\"+paramMap+\"]\");").append("\r\n");
            sb.append("        String id_keys = (String)paramMap.get(\"id_key\");").append("\r\n");
            sb.append("        int count = 0;").append("\r\n");
            sb.append("        for(String id_key:id_keys.split(\";\")){").append("\r\n");





            {
                //主表删除
                sb.append("            " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(mainTableName)) + " " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + " = new " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(mainTableName)) + "();").append("\r\n");

                JSONArray mainTableProperties = ((JSONObject) c.get("jsonParam")).getJSONArray("mainTableProperties");
                //------------------------------主表设置主键开始
                int maintableIdKeyIdx = 0;
                for (Object column_obj : mainTableProperties) {
                    //主键
                    JSONObject columnInfo = (JSONObject) column_obj;
                    String column = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "column");
                    String columnName = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnName");
                    String sqlType = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sqlType");
                    String type = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "type");
                    String isPrimaryKey = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isPrimaryKey");
                    String columnTypeColumnSize = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnSize");
                    String columnTypeColumnDecimalDigits = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnDecimalDigits");
                    String isNullAble = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isNullAble");
                    String isUnion = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isUnion");
                    String power = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "power");
                    String notEmptyMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "notEmptyMsg");
                    String min = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "min");
                    String max = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "max");
                    String strLengthMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "strLengthMsg");
                    String regexp_str = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExp");
                    String regExpMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExpMsg");
                    String sequence = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sequence");
                    String isMoney = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isMoney");
                    String autoInsert = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoInsert");
                    String autoUpdate = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoUpdate");
                    String queryRange = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "queryRange");
                    String formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                    if (type.equals(GeneratorJSONProperties.FIELD_type_date)) {
                        formatter = GeneratorJSONProperties.DEFAULT_formatter_char8;
                    }
                    if (type.equals(GeneratorJSONProperties.FIELD_type_datetime)) {
                        formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                    }

                    if (new Boolean(isPrimaryKey) && StringUtils.isNotEmpty(sequence)) {
                        sb.append("            " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(column)) + "(" + TypeUtils.transStringVar2JavaType(sqlType, columnTypeColumnSize, columnTypeColumnDecimalDigits, "id_key.split(\",\")[" + maintableIdKeyIdx + "]")).append(");\r\n");
                        maintableIdKeyIdx++;
                    }
                }
                sb.append("            //此处查询代码，功能为为了自动生成时，自动生成关联查询条件；如果确认此处代码无用，可以删除").append("\r\n");
                sb.append("            "+FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName))+" = " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + "Mapper.select(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + ");").append("\r\n");
                sb.append("            count = " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + "Mapper.delete(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + ");").append("\r\n");
                sb.append("            logger.debug(\"操作["+mainTableName+"]结果:count[\"+count+\"]\");").append("\r\n");
                sb.append("            if(count<=0){").append("\r\n");
                sb.append("                throw new Exception(\"删除主表[" + mainTableName + "]异常!\");").append("\r\n");
                sb.append("            }").append("\r\n");
            }
            if(hasSlaveTables.equalsIgnoreCase("true")) {
                //从表删除
                JSONArray slaveTables = ((JSONObject) c.get("jsonParam")).getJSONArray("slaveTables");
                for (Object slaveTable_obj : slaveTables) {
                    JSONObject slaveTable = (JSONObject) slaveTable_obj;
                    String slaveTableName = slaveTable.getString("slaveTableName");
                    String slaveTableAlias = slaveTable.getString("slaveTableAlias");
                    String slaveTableWhere = slaveTable.getString("slaveTableWhere");
                    JSONArray slaveTableProperties = ((JSONObject) slaveTable).getJSONArray("buildParam");

                    sb.append("            " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(slaveTableName)) + " " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + " = new " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(slaveTableName)) + "();").append("\r\n");
                    {
                        //增加关联字段
                        if(!slaveTableWhere.startsWith(slaveTableAlias)){
                            slaveTableWhere = slaveTableWhere.split("=")[1]+"="+slaveTableWhere.split("=")[0];//设置slavetable在关联条件中放在前面
                        }
                        //获取到关联表名称
                        String othAlias = slaveTableWhere.split("=")[1].split("\\.")[0];
                        String othColumn = slaveTableWhere.split("=")[1].split("\\.")[1];
                        String othTable = "";
                        {
                            String mainTableAlias = ((JSONObject) c.get("jsonParam")).getString("mainTableAlias");
                            if(othAlias.equals(mainTableAlias)){
                                othTable =  ((JSONObject) c.get("jsonParam")).getString("mainTableName");
                            }
                        }
                        {
                            for (Object slaveTable_obj_2 : slaveTables) {
                                JSONObject slaveTable_2 = (JSONObject) slaveTable_obj_2;
                                String slaveTableName_2 = slaveTable_2.getString("slaveTableName");
                                String slaveTableAlias_2 = slaveTable_2.getString("slaveTableAlias");
                                String slaveTableWhere_2 = slaveTable_2.getString("slaveTableWhere");
                                if(othAlias.equals(slaveTableAlias_2)){
                                    othTable =  slaveTableName_2;
                                }
                            }
                        }
                        if(othAlias.equals(slaveTableAlias)){
                            throw new Exception("从表的关联条件不能是从表自己！");
                        }
                        sb.append("            " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(slaveTableWhere.split("=")[0].replace(slaveTableAlias + ".", "").trim())) + "(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(othTable)) + ".get" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(othColumn)) + "());").append("\r\n");
                        sb.append("            //此处查询代码，功能为为了自动生成时，自动生成关联查询条件；如果确认此处代码无用，可以删除").append("\r\n");
                        sb.append("            "+FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName))+" = " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + "Mapper.select(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + ");").append("\r\n");

                    }

                    sb.append("            count = " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + "Mapper.delete(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + ");").append("\r\n");
                    sb.append("            logger.debug(\"操作["+slaveTableName+"]结果:count[\"+count+\"]\");").append("\r\n");
                }
            }


            if(hasSubTable.equalsIgnoreCase("true")) {
                //子表删除
                sb.append("            " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(subTableName)) + " " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + " = new " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(subTableName)) + "();").append("\r\n");

                {
                    //增加子表关联
                    String subTableAlias = ((JSONObject) c.get("jsonParam")).getString("subTableAlias");
                    String subTableWhere = ((JSONObject) c.get("jsonParam")).getString("subTableWhere");
                    subTableWhere = subTableWhere.trim();
                    if (!subTableWhere.startsWith(subTableAlias)) {
                        subTableWhere = subTableWhere.split("=")[1] + "=" + subTableWhere.split("=")[0];//设置subtable在关联条件中放在前面
                    }
                    //获取到关联表名称
                    String othAlias = subTableWhere.split("=")[1].split("\\.")[0];
                    String othColumn = subTableWhere.split("=")[1].split("\\.")[1];
                    String othTable = "";
                    {
                        String mainTableAlias = ((JSONObject) c.get("jsonParam")).getString("mainTableAlias");
                        if (othAlias.equals(mainTableAlias)) {
                            othTable = ((JSONObject) c.get("jsonParam")).getString("mainTableName");
                        }
                    }
                    {
                        JSONArray slaveTables = ((JSONObject) c.get("jsonParam")).getJSONArray("slaveTables");
                        for (Object slaveTable_obj : slaveTables) {
                            JSONObject slaveTable = (JSONObject) slaveTable_obj;
                            String slaveTableName = slaveTable.getString("slaveTableName");
                            String slaveTableAlias = slaveTable.getString("slaveTableAlias");
                            String slaveTableWhere = slaveTable.getString("slaveTableWhere");
                            if (othAlias.equals(slaveTableAlias)) {
                                othTable = slaveTableName;
                            }
                        }
                    }
                    if (othAlias.equals(subTableAlias)) {
                        throw new Exception("从表的关联条件不能是从表自己！");
                    }
                    sb.append("            " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(subTableWhere.split("=")[0].replace(subTableAlias + ".", "").trim())) + "(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(othTable)) + ".get" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(othColumn)) + "());").append("\r\n");
                }

                sb.append("            count = " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + "Mapper.delete(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + ");").append("\r\n");
                sb.append("            logger.debug(\"操作["+subTableName+"]结果:count[\"+count+\"]\");").append("\r\n");
            }
            sb.append("        }").append("\r\n");
            sb.append("        logger.debug(\"delete" + cleanentityClassName + ":end\");").append("\r\n");
            sb.append("    }").append("\r\n");
        }


        //########################################################querypage###########################################################################################################
        sb.append("    /*").append("\r\n");
        sb.append("     * 查询信息queryPage").append("\r\n");
        sb.append("     */").append("\r\n");
        sb.append("    public HashMap queryPage" + cleanentityClassName + "(HashMap paramMap) throws Exception {").append("\r\n");
        sb.append("        logger.debug(\"queryPage"+cleanentityClassName+ ":start\");").append("\r\n");
        sb.append("        logger.debug(\"传入参数:paramMap:\" + paramMap);").append("\r\n");
        sb.append("        String startIndex_s = (String)paramMap.get(\"startIndex\");").append("\r\n");
        sb.append("        String pageSize_s =  (String)paramMap.get(\"pageSize\");").append("\r\n");
        sb.append("        int startIndex = 1;").append("\r\n");
        sb.append("        int pageSize = 10;").append("\r\n");
        sb.append("        try{").append("\r\n");
        sb.append("            startIndex = Integer.parseInt(startIndex_s);").append("\r\n");
        sb.append("            pageSize = Integer.parseInt(pageSize_s);").append("\r\n");
        sb.append("        }catch(Exception e){").append("\r\n");
        sb.append("            logger.error(\"startIndex和pageSize解析异常\",e);").append("\r\n");
        sb.append("        }").append("\r\n");
        sb.append("        HashMap result = PageQueryUtil.pageQuery(" + FormatUtils.firstSmall(entityClassName) + "Mapper, startIndex, pageSize, paramMap);").append("\r\n");
        sb.append("        logger.debug(\"查询结果:result:\" + result);").append("\r\n");
        sb.append("        logger.debug(\"queryPage"+cleanentityClassName+ ":end\");").append("\r\n");
        sb.append("        return result;").append("\r\n");
        sb.append("    }").append("\r\n");

        //########################################################query###########################################################################################################
        sb.append("    /*").append("\r\n");
        sb.append("     * 查询信息query").append("\r\n");
        sb.append("     */").append("\r\n");
        sb.append("    public HashMap query" + cleanentityClassName + "(HashMap paramMap) throws Exception {").append("\r\n");
        sb.append("        logger.debug(\"query"+cleanentityClassName+ ":start\");").append("\r\n");
        sb.append("        logger.debug(\"传入参数:paramMap:\" + paramMap);").append("\r\n");
        sb.append("        HashMap<String,Object> resultMap = new HashMap<String,Object>();").append("\r\n");


        {
            //主表查询
            sb.append("        String id_key = (String)paramMap.get(\"id_key\");").append("\r\n");
            sb.append("        " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(mainTableName)) + " " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + " = new " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(mainTableName)) + "();").append("\r\n");
            sb.append("        MapObjTransUtils.mapToObj(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + ", paramMap);").append("\r\n");
            JSONArray mainTableProperties = ((JSONObject) c.get("jsonParam")).getJSONArray("mainTableProperties");
            int maintableIdKeyIdx = 0;
            for (Object column_obj : mainTableProperties) {
                //主键
                JSONObject columnInfo = (JSONObject) column_obj;
                String column = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "column");
                String columnName = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnName");
                String sqlType = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sqlType");
                String type = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "type");
                String isPrimaryKey = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isPrimaryKey");
                String columnTypeColumnSize = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnSize");
                String columnTypeColumnDecimalDigits = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "columnTypeColumnDecimalDigits");
                String isNullAble = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isNullAble");
                String isUnion = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isUnion");
                String power = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "power");
                String notEmptyMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "notEmptyMsg");
                String min = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "min");
                String max = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "max");
                String strLengthMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "strLengthMsg");
                String regexp_str = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExp");
                String regExpMsg = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "regExpMsg");
                String sequence = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "sequence");
                String isMoney = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "isMoney");
                String autoInsert = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoInsert");
                String autoUpdate = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "autoUpdate");
                String queryRange = UnionContextPreProcess.getInfoOrBase64Msg(columnInfo, "queryRange");
                String formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                if (type.equals(GeneratorJSONProperties.FIELD_type_date)) {
                    formatter = GeneratorJSONProperties.DEFAULT_formatter_char8;
                }
                if (type.equals(GeneratorJSONProperties.FIELD_type_datetime)) {
                    formatter = GeneratorJSONProperties.DEFAULT_formatter_char14;
                }

                if (new Boolean(isPrimaryKey) && StringUtils.isNotEmpty(sequence)) {
                    sb.append("        " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(column)) + "(" + TypeUtils.transStringVar2JavaType(sqlType, columnTypeColumnSize, columnTypeColumnDecimalDigits, "id_key.split(\",\")[" + maintableIdKeyIdx + "]")).append(");\r\n");
                    maintableIdKeyIdx++;
                }
            }
            sb.append("        " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + " = " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + "Mapper.select(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + ");").append("\r\n");
            sb.append("        logger.debug(\"查询结果:" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + ":\" + (" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + " != null ? JSONObject.fromObject(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + ").toString() : \"null\"));").append("\r\n");
            sb.append("        if(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName)) + "==null){").append("\r\n");
            sb.append("            throw new Exception(\"未查询到指定的主表[" + mainTableName + "]信息\");").append("\r\n");
            sb.append("        }").append("\r\n");
            sb.append("        resultMap.putAll(MapObjTransUtils.objectToMap("+FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(mainTableName))+"));").append("\r\n").append("\r\n");
        }


        if(hasSlaveTables.equalsIgnoreCase("true")) {
            //从表查询
            JSONArray slaveTables = ((JSONObject) c.get("jsonParam")).getJSONArray("slaveTables");
            for (Object slaveTable_obj : slaveTables) {
                JSONObject slaveTable = (JSONObject) slaveTable_obj;
                String slaveTableName = slaveTable.getString("slaveTableName");
                String slaveTableAlias = slaveTable.getString("slaveTableAlias");
                String slaveTableWhere = slaveTable.getString("slaveTableWhere");
                JSONArray slaveTableProperties = ((JSONObject) slaveTable).getJSONArray("buildParam");

                sb.append("        " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(slaveTableName)) + " " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + " = new " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(slaveTableName)) + "();").append("\r\n");
                sb.append("        MapObjTransUtils.mapToObj(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + ", paramMap);").append("\r\n");

                {
                    //增加关联字段
                    if(!slaveTableWhere.startsWith(slaveTableAlias)){
                        slaveTableWhere = slaveTableWhere.split("=")[1]+"="+slaveTableWhere.split("=")[0];//设置slavetable在关联条件中放在前面
                    }
                    //获取到关联表名称
                    String othAlias = slaveTableWhere.split("=")[1].split("\\.")[0];
                    String othColumn = slaveTableWhere.split("=")[1].split("\\.")[1];
                    String othTable = "";
                    {
                        String mainTableAlias = ((JSONObject) c.get("jsonParam")).getString("mainTableAlias");
                        if(othAlias.equals(mainTableAlias)){
                            othTable =  ((JSONObject) c.get("jsonParam")).getString("mainTableName");
                        }
                    }
                    {
                        for (Object slaveTable_obj_2 : slaveTables) {
                            JSONObject slaveTable_2 = (JSONObject) slaveTable_obj_2;
                            String slaveTableName_2 = slaveTable_2.getString("slaveTableName");
                            String slaveTableAlias_2 = slaveTable_2.getString("slaveTableAlias");
                            String slaveTableWhere_2 = slaveTable_2.getString("slaveTableWhere");
                            if(othAlias.equals(slaveTableAlias_2)){
                                othTable =  slaveTableName_2;
                            }
                        }
                    }
                    if(othAlias.equals(slaveTableAlias)){
                        throw new Exception("从表的关联条件不能是从表自己！");
                    }
                    sb.append("        " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(slaveTableWhere.split("=")[0].replace(slaveTableAlias + ".", "").trim())) + "(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(othTable)) + ".get" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(othColumn)) + "());").append("\r\n");
                }


                sb.append("        " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + "=" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + "Mapper.select(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + ");").append("\r\n");
                sb.append("        logger.debug(\"查询结果:"+FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName))+":\" + ("+FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName))+" != null ? JSONObject.fromObject("+FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName))+").toString() : \"null\"));").append("\r\n");
                sb.append("        if("+FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName))+"==null){").append("\r\n");
                sb.append("            throw new Exception(\"未查询到指定的从表["+slaveTableName+"]信息\");").append("\r\n");
                sb.append("        }").append("\r\n");
                sb.append("        resultMap.putAll(MapObjTransUtils.objectToMap(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(slaveTableName)) + "));").append("\r\n").append("\r\n");

            }
            //从表查询
        }

        if(hasSubTable.equalsIgnoreCase("true")) {
            //子表查询
            sb.append("        " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(subTableName)) + " " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + " = new " + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(subTableName)) + "();").append("\r\n");
            sb.append("        MapObjTransUtils.mapToObj(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + ", paramMap);").append("\r\n");


            {
                //增加子表关联
                String subTableAlias = ((JSONObject) c.get("jsonParam")).getString("subTableAlias");
                String subTableWhere = ((JSONObject) c.get("jsonParam")).getString("subTableWhere");
                subTableWhere = subTableWhere.trim();
                if(!subTableWhere.startsWith(subTableAlias)){
                    subTableWhere = subTableWhere.split("=")[1]+"="+subTableWhere.split("=")[0];//设置slavetable在关联条件中放在前面
                }
                //获取到关联表名称
                String othAlias = subTableWhere.split("=")[1].split("\\.")[0];
                String othColumn = subTableWhere.split("=")[1].split("\\.")[1];
                String othTable = "";
                {
                    String mainTableAlias = ((JSONObject) c.get("jsonParam")).getString("mainTableAlias");
                    if (othAlias.equals(mainTableAlias)) {
                        othTable = ((JSONObject) c.get("jsonParam")).getString("mainTableName");
                    }
                }
                {
                    JSONArray slaveTables = ((JSONObject) c.get("jsonParam")).getJSONArray("slaveTables");
                    for (Object slaveTable_obj : slaveTables) {
                        JSONObject slaveTable = (JSONObject) slaveTable_obj;
                        String slaveTableName = slaveTable.getString("slaveTableName");
                        String slaveTableAlias = slaveTable.getString("slaveTableAlias");
                        String slaveTableWhere = slaveTable.getString("slaveTableWhere");
                        if (othAlias.equals(slaveTableAlias)) {
                            othTable = slaveTableName;
                        }
                    }
                }
                if (othAlias.equals(subTableAlias)) {
                    throw new Exception("子表的关联条件不能是子表自己！");
                }
                sb.append("        " + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + ".set" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(subTableWhere.split("=")[0].replace(subTableAlias + ".", "").trim())) + "(" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(othTable)) + ".get" + FormatUtils.firstBig(FormatUtils.formatDBNameToVarName(othColumn)) + "());").append("\r\n");
            }


            sb.append("        List<HashMap<String,Object>> list =" + FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName)) + "Mapper.queryListMap(MapObjTransUtils.objectToMap("+FormatUtils.firstSmall(FormatUtils.formatDBNameToVarName(subTableName))+"));").append("\r\n");
            sb.append("        list = PageQueryUtil.formatHashMapKeyInList(list);").append("\r\n");
            sb.append("        logger.debug(\"查询到子表:\"+list.size()+\"条\");").append("\r\n");
            sb.append("        resultMap.put(PageQueryUtil.PAGERECORDS,list);").append("\r\n").append("\r\n");
        }

        sb.append("        logger.debug(\"查询结果:[\"+resultMap+\"]\");").append("\r\n");
        sb.append("        logger.debug(\"query"+cleanentityClassName+ ":end\");").append("\r\n");
        sb.append("        return resultMap;").append("\r\n");
        sb.append("    }").append("\r\n");


        sb.append("}").append("\r\n");
        pw.println(sb.toString());
        pw.close();
    }
}

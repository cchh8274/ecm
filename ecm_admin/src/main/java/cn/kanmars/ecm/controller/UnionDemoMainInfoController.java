/**
 * ecm Generator 
 */
package cn.kanmars.ecm.controller;


import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.com.xbase.frame.util.DateFormatUtils;
import cn.com.xbase.frame.util.MapObjTransUtils;
import cn.com.xbase.frame.util.MoneyFormatUtils;
import cn.com.xbase.frame.util.StringUtils;
import cn.com.xbase.frame.util.DateUtils;
import cn.com.xbase.frame.interceptor.OperationLogDescription;
import cn.kanmars.ecm.util.SysSequenceUtils;
import cn.kanmars.ecm.util.SysDicUtils;
import cn.kanmars.ecm.base.AdvancedAjaxBaseController;
import cn.kanmars.ecm.logic.UnionDemoMainInfoLogic;
import cn.kanmars.ecm.entity.TblUnionDemoMainInfo;
import cn.kanmars.ecm.util.PageQueryUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;


/**
 * UnionDemoMainInfoController
 * tbl_union_demo_main_info
 * 联表查询DEMO-主表
 * 方法如下
 * queryObject 根据id_key查询一个对象，查询结果作为JSONArray放入结果中，用于查看详情、修改查询,联合主键用逗号分割
 * insert 插入一个数据
 * edit 修改一个数据
 * del 根据id_key删除一个对象，多个id时用分号分割,联合主键用逗号分割
 * search 根据查询的条件，分页查询或者响应一个下载的Excel。
 *     如果传入queryType=download，则必须传入exportParam导出参数，fileName文件名
 *     如果传入queryType=query，则必须传入startIndex开始页数，和pageSize每页页数
 * beferLogic 针对insert,edit,search等含多个入参的操作使用，在logic前使用，用于把页面上的参数转化为数据库格式
 * afterLogic 针对queryObject,search等含有多个出参的操作使用，在logic后使用，用于把数据库输出转化为页面格式
 * beforeExport 针对search进行导出预处理，设置开始页数为1，设置最大数量为Integer.MAXVALUE
 * export 针对search进行导出
 * 
 */
@Controller
@RequestMapping("/unionDemoMainInfo")
public class UnionDemoMainInfoController extends AdvancedAjaxBaseController  {

    protected HLogger logger = LoggerManager.getLoger("UnionDemoMainInfoController");

    @Autowired
    private UnionDemoMainInfoLogic unionDemoMainInfoLogic;

    @RequestMapping("/unionDemoMainInfoView.dhtml")
    public String init() {
        return "uniondemomaininfo/uniondemomaininfo";
    }

    @RequestMapping("/queryObject.dhtml")
    public void queryObject(HttpServletRequest request, HttpServletResponse response) {
        logger.info("queryObject:start");
        String requestJson = request.getParameter("jsonStr");
        JSONObject jsonObject = JSONObject.fromObject(requestJson);

        logger.info("传入参数:jsonObject:" + jsonObject);
        TblUnionDemoMainInfo tblUnionDemoMainInfo = new TblUnionDemoMainInfo();
        tblUnionDemoMainInfo.setDemoId(Long.parseLong(jsonObject.get("id_key").toString()));// 联合主键用逗号分割

        try {
            tblUnionDemoMainInfo = unionDemoMainInfoLogic.queryUnionDemoMainInfo(tblUnionDemoMainInfo);
            logger.info("查询结果:tblUnionDemoMainInfo:" + (tblUnionDemoMainInfo != null ? JSONObject.fromObject(tblUnionDemoMainInfo).toString() : "null"));
            Map result = new HashMap();
            Map tblUnionDemoMainInfo_map = afterLogic(request, JSONObject.fromObject(tblUnionDemoMainInfo));
            result.put("tblUnionDemoMainInfo", tblUnionDemoMainInfo_map);
            result.put("id_key",jsonObject.get("id_key").toString());
            ajaxJsonMessage(request, response, result, QUERY);
        } catch (Exception e) {
            logger.error("处理失败", e);
            ajaxJsonMessage(request, response, ERROR, "操作异常,请联系管理员！", QUERY);
        }
        logger.info("queryObject:end");
    }

    @RequestMapping("/insert.dhtml")
    @OperationLogDescription(operationName="插入",operationApp = "ecm-admin")
    public void insert(HttpServletRequest request, HttpServletResponse response) {
        logger.info("insert:start");
        String requestJson = request.getParameter("jsonStr");
        try {
            JSONObject jsonObject = JSONObject.fromObject(requestJson);
            // logic前处理，格式转化：页面->数据库层
            HashMap<String, Object> paramMap = new HashMap<String, Object>();
            paramMap = beferLogic(request, jsonObject);
            TblUnionDemoMainInfo tblUnionDemoMainInfo = new TblUnionDemoMainInfo();
            try {
                MapObjTransUtils.mapToObj(tblUnionDemoMainInfo, paramMap);
            } catch (Exception e) {
                logger.error("对象转化异常", e);
            }
            tblUnionDemoMainInfo.setCreateTime(DateUtils.getCurrDateTime());
            try {
                String pk0 = SysSequenceUtils.generateStringId("tbl_demo_info");
                tblUnionDemoMainInfo.setDemoId(Long.parseLong(pk0));// 联合主键用逗号分割
                String pk1 = SysSequenceUtils.generateStringId("tbl_demo_info");
            } catch (Exception e) {
                logger.error("对象转化异常", e);
            }
            logger.info("传入参数:tblUnionDemoMainInfo:" + JSONObject.fromObject(tblUnionDemoMainInfo).toString());
            int count = unionDemoMainInfoLogic.insertUnionDemoMainInfo(tblUnionDemoMainInfo);
            logger.info("成功数量[" + count + "]");
            ajaxJsonMessage(request, response, SUCCESS, SUCCESS_TXT, SAVE);
        } catch (Exception e) {
            logger.error("处理失败", e);
            ajaxJsonMessage(request, response, ERROR, "操作异常,请联系管理员！", SAVE);
        }
        logger.info("insert:end");
    }

    @RequestMapping("/edit.dhtml")
    @OperationLogDescription(operationName="修改",operationApp = "ecm-admin")
    public void edit(HttpServletRequest request, HttpServletResponse response) {
        logger.info("edit:start");
        String requestJson = request.getParameter("jsonStr");
        try {
            JSONObject jsonObject = JSONObject.fromObject(requestJson);
            // logic前处理，格式转化：页面->数据库层
            HashMap<String, Object> paramMap = new HashMap<String, Object>();
            paramMap = beferLogic(request, jsonObject);
            TblUnionDemoMainInfo tblUnionDemoMainInfo = new TblUnionDemoMainInfo();
            try {
                MapObjTransUtils.mapToObj(tblUnionDemoMainInfo, paramMap);
            } catch (Exception e) {
                logger.error("对象转化异常", e);
            }
            tblUnionDemoMainInfo.setCreateTime(DateUtils.getCurrDateTime());

            //为对象设置主键开始
            tblUnionDemoMainInfo.setDemoId(Long.parseLong(jsonObject.get("id_key").toString()));// 联合主键用逗号分割
            //为对象设置主键结束

            logger.info("传入参数:tblUnionDemoMainInfo:" + JSONObject.fromObject(tblUnionDemoMainInfo).toString());
            int count = unionDemoMainInfoLogic.updateUnionDemoMainInfo(tblUnionDemoMainInfo);
            if (count == 0) {
                logger.info("修改失败:修改数量为0");
                ajaxJsonMessage(request, response, ERROR, EDIT_FAIL_TXT, EDIT);
            } else {
                logger.info("修改成功:修改数量为" + count);
                ajaxJsonMessage(request, response, SUCCESS, EDIT_SUCCESS_TXT, EDIT);
            }
        } catch (Exception e) {
            logger.error("处理失败", e);
            ajaxJsonMessage(request, response, ERROR, "操作异常,请联系管理员！", SAVE);
        }
        logger.info("edit:end");
    }

    @RequestMapping("/del.dhtml")
    @OperationLogDescription(operationName="删除",operationApp = "ecm-admin")
    public void del(HttpServletRequest request, HttpServletResponse response) {
        logger.info("del:start");
        String requestJson = request.getParameter("jsonStr");
        JSONObject jsonObject = JSONObject.fromObject(requestJson);

        logger.info("传入参数:jsonObject:" + jsonObject);
        int count = 0;
        try {
            String id_key = jsonObject.get("id_key").toString().trim();
            // 循环删除
            for (String s : id_key.split(";")) { // 多个主键用分号分割
                logger.info("尝试删除:" + s);
                TblUnionDemoMainInfo tblUnionDemoMainInfo = new TblUnionDemoMainInfo();
                tblUnionDemoMainInfo.setDemoId(Long.parseLong(s));// 联合主键用逗号分割
                try {
                    count += unionDemoMainInfoLogic.deleteUnionDemoMainInfo(tblUnionDemoMainInfo);
                } catch(Exception e) {
                    logger.error("删除[" + s +"]失败，执行下一个", e);
                }

            }
            if (count == 0) {
                logger.info("删除失败:删除数量为0");
                ajaxJsonMessage(request, response, ERROR, DEL_FAIL_TXT, DEL);
            } else {
                logger.info("删除成功:删除数量为" + count);
                ajaxJsonMessage(request, response, SUCCESS, DEL_SUCCESS_TXT, DEL);
            }
        } catch (Exception e) {
            logger.error("处理失败，影响数据[" + count + "]", e);
            ajaxJsonMessage(request, response, ERROR, "操作异常,请联系管理员！", DEL);
        }
        logger.info("del:end");
    }

    @RequestMapping("/search.dhtml")
    public void search(HttpServletRequest request, HttpServletResponse response) {
        logger.info("search:start");
        String requestJson = request.getParameter("jsonStr");
        try {
            requestJson = URLDecoder.decode(requestJson, "utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("URLDecoderError", e);
        }
        logger.info("requestJson:" + requestJson);
        JSONObject jsonObject = JSONObject.fromObject(requestJson);
        logger.info("jsonObject:" + jsonObject.toString());
        try {
            // 参数预处理
            HashMap<String, Object> paramMap = new HashMap<String, Object>();
            paramMap = beferLogic(request, jsonObject);
            paramMap = beforeExport(request, paramMap);

            logger.info("查询参数:paramMap:" + paramMap);
            paramMap = unionDemoMainInfoLogic.queryPageUnionDemoMainInfo(paramMap);

            logger.info("查询结果:paramMap:" + paramMap);
            paramMap = (HashMap<String, Object>) afterLogic(request, paramMap);

            logger.info("传出结果:paramMap:" + paramMap);
            // 输出模式
            String queryType = (String)jsonObject.get("queryType");
            if (StringUtils.isEmpty(queryType) || !queryType.equals("download")) {
                // 正常输出模式
                ajaxJsonMessage(request, response, paramMap, QUERY);
            } else {
                // 导出模式
                export(request, response, paramMap);
                return;
            }
        } catch (Exception e) {
            logger.error("处理失败", e);
            ajaxJsonMessage(request, response, ERROR, "操作异常,请联系管理员！", QUERY);
        }
        logger.info("search:end");
    }

    /**
     * logic后处理，格式转化：数据库层->页面，入口为单个或者列表
     * 操作原理为对原对象进行修改，不生成新对象
     * 
     * @param request
     * @param obj
     * @return
     */
    protected Map<String, Object> afterLogic(HttpServletRequest request, Map<String, Object> obj) throws Exception {
        List<HashMap<String, Object>> records = (List<HashMap<String, Object>>) obj.get(PageQueryUtil.PAGERECORDS);
        if (records != null) {
            // 如果是分页的查询，则对每一个结果进行处理
            for (HashMap<String, Object> cell_of_list : records) {
                afterLogicpreCell(request, cell_of_list);
            }
        } else {
            // 如果是单个查询，则直接对查询结果进行处理
            afterLogicpreCell(request, obj);
        }
        return obj;
    }

    /**
     * logic前处理，格式转化：页面->数据库层，功能为将obj中的对象生成为一个HashMap<String,Object>对象
     * 生成的对象为全新的对象
     * 如果对此方法进行修改，请“增量式”的修改，尽量避免对原代码造成不必要影响
     * 前处理默认规则：金额、日期从数据库层面定义。金钱根据input.attr中是否有"ismoney":"true"来判断
     *          金额、日期为直接替换
     * @param request
     * @param obj
     * @return
     */
    protected HashMap<String, Object> beferLogic(HttpServletRequest request, Map<String, Object> obj) throws Exception {
        HashMap<String, Object> result = new HashMap<String, Object>();
        for (Map.Entry<String, Object> e : obj.entrySet()) {
            String key = e.getKey();
            String value = e.getValue().toString();
            result.put(key, value);
            if (key.equals("createTime") && StringUtils.isNotEmpty(value)) {
                try {
                    java.text.SimpleDateFormat sdf_page = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    java.text.SimpleDateFormat sdf_db = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
                    String dbDateStr=sdf_db.format(sdf_page.parse(value));
                    result.put("createTime", dbDateStr);
                } catch(Exception ex) {
                    logger.error("格式转化失败["+key+"]["+value+"]", ex);
                    throw new Exception("格式转化失败["+key+"]["+value+"]");
                }
            }
            if (key.equals("createDate") && StringUtils.isNotEmpty(value)) {
                try {
                    java.text.SimpleDateFormat sdf_page = new java.text.SimpleDateFormat("yyyy-MM-dd");
                    java.text.SimpleDateFormat sdf_db = new java.text.SimpleDateFormat("yyyyMMdd");
                    String dbDateStr=sdf_db.format(sdf_page.parse(value));
                    result.put("createDate", dbDateStr);
                } catch(Exception ex) {
                    logger.error("格式转化失败["+key+"]["+value+"]", ex);
                    throw new Exception("格式转化失败["+key+"]["+value+"]");
                }
            }
            if (key.equals("createDate_start") && StringUtils.isNotEmpty(value)) {
                try {
                    java.text.SimpleDateFormat sdf_page = new java.text.SimpleDateFormat("yyyy-MM-dd");
                    java.text.SimpleDateFormat sdf_db = new java.text.SimpleDateFormat("yyyyMMdd");
                    String dbDateStr=sdf_db.format(sdf_page.parse(value));
                    result.put("createDate_start", dbDateStr);
                } catch(Exception ex) {
                    logger.error("格式转化失败["+key+"]["+value+"]", ex);
                    throw new Exception("格式转化失败["+key+"]["+value+"]");
                }
            }
            if (key.equals("createDate_end") && StringUtils.isNotEmpty(value)) {
                try {
                    java.text.SimpleDateFormat sdf_page = new java.text.SimpleDateFormat("yyyy-MM-dd");
                    java.text.SimpleDateFormat sdf_db = new java.text.SimpleDateFormat("yyyyMMdd");
                    String dbDateStr=sdf_db.format(sdf_page.parse(value));
                    result.put("createDate_end", dbDateStr);
                } catch(Exception ex) {
                    logger.error("格式转化失败["+key+"]["+value+"]", ex);
                    throw new Exception("格式转化失败["+key+"]["+value+"]");
                }
            }
            //*********************************************************
            //可在此处增加对格式的转换
            //*********************************************************
        }
        return result;
    }

    /**
     * logic后处理，格式转化：数据库层->页面
     * 操作原理为对原对象进行修改，不生成新对象
     * 如果对此方法进行修改，请“增量式”的修改，尽量避免对原代码造成不必要影响
     * 后处理默认规则：金额、日期、select、radio从数据库层面定义。金钱根据input.attr中是否有"ismoney":"true"来判断
     *          金额、日期为直接替换 、select、radio通过新字段转义
     * @param request
     * @param result
     * @return
     */
    private Map<String, Object> afterLogicpreCell(HttpServletRequest request, Map<String, Object> result) throws Exception {
            if (result.keySet().contains("demoId")) {
                String key = "demoId";
                Object value = result.get(key);
                if(value != null){
                    //Long和BigDecimal转化为字符串，防止javascript不支持大数异常
                    result.put(key, value.toString());
                }
            }
            if (result.keySet().contains("forgienId")) {
                String key = "forgienId";
                Object value = result.get(key);
                if(value != null){
                    //Long和BigDecimal转化为字符串，防止javascript不支持大数异常
                    result.put(key, value.toString());
                }
            }
            if (result.keySet().contains("createTime")) {
                String key = "createTime";
                Object value = result.get(key);
                if(StringUtils.isNotEmpty((String)value)){
                    try {
                        java.text.SimpleDateFormat sdf_page = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        java.text.SimpleDateFormat sdf_db = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
                        String pageDateStr=sdf_page.format(sdf_db.parse((String)value));
                        result.put(key, pageDateStr);
                    } catch(Exception ex) {
                        logger.error("格式转化失败["+key+"]["+value+"]", ex);
                        throw new Exception("格式转化失败["+key+"]["+value+"]");
                    }
                }
            }
            if (result.keySet().contains("selectStatic")) {
                String key = "selectStatic";
                Object value = result.get(key);
                if(value!=null&&StringUtils.isNotEmpty(value.toString())){
                    try {
                        String selectStatic_name = null;
                        JSONObject json = JSONObject.fromObject("{'010':'正常','020':'禁用','030':'失效'}");
                        selectStatic_name = json.get(value.toString())==null?value.toString():(String)json.get(value.toString());
                        result.put("selectStatic_name", selectStatic_name);
                    } catch(Exception ex) {
                        logger.error("格式转化失败["+key+"]["+value+"]", ex);
                        throw new Exception("格式转化失败["+key+"]["+value+"]");
                    }
                }
            }
            if (result.keySet().contains("selectDynamic")) {
                String key = "selectDynamic";
                Object value = result.get(key);
                if(value!=null&&StringUtils.isNotEmpty(value.toString())){
                    try {
                        String selectDynamic_name = null;
                        selectDynamic_name = SysDicUtils.getValue("application_code","application_code",value.toString());
                        result.put("selectDynamic_name", selectDynamic_name);
                    } catch(Exception ex) {
                        logger.error("格式转化失败["+key+"]["+value+"]", ex);
                        throw new Exception("格式转化失败["+key+"]["+value+"]");
                    }
                }
            }
            if (result.keySet().contains("radioStatic")) {
                String key = "radioStatic";
                Object value = result.get(key);
                if(value!=null&&StringUtils.isNotEmpty(value.toString())){
                    try {
                        String radioStatic_name = null;
                        JSONObject json = JSONObject.fromObject("{'010':'正常','020':'禁用','030':'失效'}");
                        radioStatic_name = json.get(value.toString())==null?value.toString():(String)json.get(value.toString());
                        result.put("radioStatic_name", radioStatic_name);
                    } catch(Exception ex) {
                        logger.error("格式转化失败["+key+"]["+value+"]", ex);
                        throw new Exception("格式转化失败["+key+"]["+value+"]");
                    }
                }
            }
            if (result.keySet().contains("radioDynamic")) {
                String key = "radioDynamic";
                Object value = result.get(key);
                if(value!=null&&StringUtils.isNotEmpty(value.toString())){
                    try {
                        String radioDynamic_name = null;
                        radioDynamic_name = SysDicUtils.getValue("application_code","application_code",value.toString());
                        result.put("radioDynamic_name", radioDynamic_name);
                    } catch(Exception ex) {
                        logger.error("格式转化失败["+key+"]["+value+"]", ex);
                        throw new Exception("格式转化失败["+key+"]["+value+"]");
                    }
                }
            }
            if (result.keySet().contains("createDate")) {
                String key = "createDate";
                Object value = result.get(key);
                if(StringUtils.isNotEmpty((String)value)){
                    try {
                        java.text.SimpleDateFormat sdf_page = new java.text.SimpleDateFormat("yyyy-MM-dd");
                        java.text.SimpleDateFormat sdf_db = new java.text.SimpleDateFormat("yyyyMMdd");
                        String pageDateStr=sdf_page.format(sdf_db.parse((String)value));
                        result.put(key, pageDateStr);
                    } catch(Exception ex) {
                        logger.error("格式转化失败["+key+"]["+value+"]", ex);
                        throw new Exception("格式转化失败["+key+"]["+value+"]");
                    }
                }
            }
            //*********************************************************
            //可在此处增加对格式的转换
            //*********************************************************
        return result;
    }
}


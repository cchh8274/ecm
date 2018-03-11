package web.generatorunion;

import context.Context;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import pipe.impl.A_GetTableInfo;
import pipe.unionimpl.*;
import sun.misc.BASE64Decoder;
import utils.FormatUtils;
import web.AbstractProcessor;
import web.generator.GeneratorProcessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by baolong on 2017/2/26.
 */
public class GeneratorUnion extends AbstractProcessor {

    public void process(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String type = httpServletRequest.getParameter("type");
        if (type.equals("queryColumnsInfo")) {
            //使用相同的代码处理数据库查询
            new GeneratorProcessor().exec_a_01_selectDBINFO(httpServletRequest, httpServletResponse);
        } else if (type.equals("buildfile")) {
            buildfile(httpServletRequest, httpServletResponse);
        } else {
            System.out.println("不支持的type[" + type + "]");
        }
    }

    public void buildfile(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            String buildParam = httpServletRequest.getParameter("buildParam");

            JSONObject json = JSONObject.fromObject(buildParam);
            String dbDriverInfo = json.getString("dbDriverInfo");
            try {
                dbDriverInfo = new String(new BASE64Decoder().decodeBuffer(dbDriverInfo), "utf-8");
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            String basePath = json.getString("basePath");
            try {
                basePath = new String(new BASE64Decoder().decodeBuffer(basePath), "utf-8");
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            String businessName = json.getString("businessName");
            String businessCnName = json.getString("businessCnName");
            String mainTableName = json.getString("mainTableName");
            String mainTableAlias = json.getString("mainTableAlias");
            JSONArray mainTableProperties = json.getJSONArray("mainTableProperties");
            JSONArray slaveTables = new JSONArray();
            try{
                slaveTables = json.getJSONArray("slaveTables");
            }catch (Exception e){
                System.out.println("无从表数据");
            }
            String subTableName = "";
            String subTableAlias = "";
            String subTableWhere = "";
            JSONArray subTableProperties = new JSONArray();
            try{
                subTableName = json.getString("subTableName");
                subTableAlias = json.getString("subTableAlias");
                subTableWhere = json.getString("subTableWhere");
                subTableProperties = json.getJSONArray("subTableProperties");
            }catch (Exception e){
                System.out.println("无子表数据");
            }

            JSONObject jsonParam = new JSONObject();
            jsonParam.put("dbDriverInfo", dbDriverInfo);
            jsonParam.put("basePath", basePath);
            jsonParam.put("businessName", businessName);
            jsonParam.put("businessCnName", businessCnName);
            jsonParam.put("mainTableName", mainTableName);
            jsonParam.put("mainTableAlias", mainTableAlias);
            jsonParam.put("mainTableProperties", mainTableProperties);
            jsonParam.put("slaveTables", slaveTables);
            jsonParam.put("subTableName", subTableName);
            jsonParam.put("subTableAlias", subTableAlias);
            jsonParam.put("subTableWhere", subTableWhere);
            jsonParam.put("subTableProperties", subTableProperties);
            if(slaveTables.size()!=0){
                jsonParam.put("hasSlaveTables", "true");
            }else{
                jsonParam.put("hasSlaveTables", "false");
            }
            if(StringUtils.isNotEmpty(subTableName)){
                jsonParam.put("hasSubTable", "true");
            }else{
                jsonParam.put("hasSubTable", "false");
            }

            Context c = new Context();

            c.put("jsonParam", jsonParam);

            //预处理
            try {
                new Create_012_Dao().exec(UnionContextPreProcess.preProcess(c, false));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                new Create_013_Mapper("MYSQL", "true").exec(UnionContextPreProcess.preProcess(c, false));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                new Create_014_Logic().exec(UnionContextPreProcess.preProcess(c, true));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                new Create_014_LogicImpl().exec(UnionContextPreProcess.preProcess(c, true));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                new Create_015_Controller().exec(UnionContextPreProcess.preProcess(c, true));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                new Create_016_Ftl().exec(UnionContextPreProcess.preProcess(c, true));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                new Create_017_Js().exec(UnionContextPreProcess.preProcess(c, true));
            } catch (Exception e) {
                e.printStackTrace();
            }
            JSONObject result = new JSONObject();
            result.put("resCode", "0000");
            result.put("resDesc", "成功");
            try {
                httpServletResponse.getOutputStream().write(result.toString().getBytes("utf-8"));
                httpServletResponse.getOutputStream().flush();
                httpServletResponse.getOutputStream().close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JSONObject result = new JSONObject();
            result.put("resCode", "0002");
            result.put("resDesc", e.getMessage());
            try {
                httpServletResponse.getOutputStream().write(result.toString().getBytes("utf-8"));
                httpServletResponse.getOutputStream().flush();
                httpServletResponse.getOutputStream().close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}

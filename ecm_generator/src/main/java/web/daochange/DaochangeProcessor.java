package web.daochange;

import exec.DBTypeTrans;
import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;
import web.AbstractProcessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * Created by kanmars on 2017/8/28.
 */
public class DaochangeProcessor extends AbstractProcessor {
    public void process(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        String mapperpath = httpServletRequest.getParameter("mapperpath");
        String daochangetype = httpServletRequest.getParameter("daochangetype");
        try {
            mapperpath = URLDecoder.decode(new String(new BASE64Decoder().decodeBuffer(mapperpath),"utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        String mode = "";
        if(daochangetype.equalsIgnoreCase("1")){
            mode = DBTypeTrans.MODE_MYSQL_TO_ORACLE;
        }else if(daochangetype.equalsIgnoreCase("2")){
            mode = DBTypeTrans.MODE_MYSQL_TO_DB2;
        }else if(daochangetype.equalsIgnoreCase("3")){
            mode = DBTypeTrans.MODE_MYSQL_TO_SQLITE;
        }else if(daochangetype.equalsIgnoreCase("4")){
            mode = DBTypeTrans.MODE_ORACLE_TO_MYSQL;
        }else if(daochangetype.equalsIgnoreCase("5")){
            mode = DBTypeTrans.MODE_DB2_TO_MYSQL;
        }else if(daochangetype.equalsIgnoreCase("6")){
            mode = DBTypeTrans.MODE_SQLITE_TO_MYSQL;
        }
        try {
            DBTypeTrans.dbTypeTrans(mapperpath,mode);
            JSONObject result = new JSONObject();
            result.put("resCode","0000");
            result.put("resDesc", "成功");
            try {
                httpServletResponse.getOutputStream().write(result.toString().getBytes("utf-8"));
                httpServletResponse.getOutputStream().flush();
                httpServletResponse.getOutputStream().close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } catch (IOException e) {
            JSONObject result = new JSONObject();
            result.put("resCode","0002");
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

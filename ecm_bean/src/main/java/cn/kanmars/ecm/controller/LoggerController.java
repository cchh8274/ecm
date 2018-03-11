package cn.kanmars.ecm.controller;

import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Level;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by baolong on 2017/2/8.
 */
@Controller
@RequestMapping("/logger")
public class LoggerController {
    protected HLogger logger = LoggerManager.getLoger("LoggerController");

    @RequestMapping("/logger.dhtml")
    public void logger(HttpServletRequest request, HttpServletResponse response) {
        logger.info("LoggerController.logger-start");
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.getWriter().write("<html><head><title>日志级别切换器</title></head><body>" +
                    "<a href=\"changelevel.dhtml?level=error\" target=\"_blank\">error</a><br>" +
                    "<a href=\"changelevel.dhtml?level=warn\" target=\"_blank\">warn</a><br>" +
                    "<a href=\"changelevel.dhtml?level=info\" target=\"_blank\">info</a><br>" +
                    "<a href=\"changelevel.dhtml?level=debug\" target=\"_blank\">debug</a><br>" +
                    "<a href=\"changelevel.dhtml?level=trace\" target=\"_blank\">trace</a><br>" +
                    "<a href=\"changelevel.dhtml?level=fatal\" target=\"_blank\">fatal</a><br>" +
                    "</body></html>");
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("LoggerController.logger-end");
    }

    @RequestMapping("/changelevel.dhtml")
    public void changellevel(HttpServletRequest request, HttpServletResponse response) {
        logger.info("LoggerController.changelevel-start");
        String level_s = request.getParameter("level");
        logger.info("change to ["+level_s+"]");
        HLogger.changeRuntiomeLogLevel(Level.toLevel(level_s));
        HLogger.changeRuntiomeRootLevel(Level.toLevel(level_s));
        ajaxJsonMessage(request, response, "SUCCESS", "日志级别更新为["+level_s+"]成功！", "EDIT");
        logger.info("LoggerController.changelevel-end");
    }

    @RequestMapping("/showlevel.dhtml")
    public void showlevel(HttpServletRequest request, HttpServletResponse response) {
        logger.info("LoggerController.showlevel-start");

        logger.error("异常日志level=error，number=3");
        logger.warn("警告日志level=warn，number=4");
        logger.info("信息日志level=info，number=6");
        logger.debug("调试日志level=debug，number=7");
        logger.trace("跟踪日志level=trace，number=7");
        logger.fatal("导致系统崩溃级别的日志level=fatal,number=0");

        logger.info("LoggerController.showlevel-end");
    }

    private String ajax(HttpServletRequest request, HttpServletResponse response,String content, String type) {
        try {
            logger.debug(content);
            response.setContentType(type + ";charset=UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.getWriter().write(content);
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String ajaxJsonMessage(HttpServletRequest request, HttpServletResponse response,String code, String message, String type) {
        JSONObject jo = new JSONObject();
        jo.put("code", code);
        jo.put("message", message);
        jo.put("type", type);
        return ajax(request,response,jo.toString(), "text/html");
    }
}


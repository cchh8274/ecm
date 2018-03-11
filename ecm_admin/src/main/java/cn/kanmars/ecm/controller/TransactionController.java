package cn.kanmars.ecm.controller;

import cn.com.xbase.frame.controller.BaseController;
import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.kanmars.ecm.logic.TransactionLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by baolong on 2016/1/12.
 */
@Controller
@RequestMapping("/trans")
public class TransactionController extends BaseController {

    protected HLogger logger = LoggerManager.getLoger("TransactionController");
    @Autowired
    private TransactionLogic transactionLogic;

    @RequestMapping("/t")
    public String t(Model model,HttpServletRequest request, HttpServletResponse response) {
        try {
            transactionLogic.exec();
        } catch (Exception e) {
            logger.error("异常信息",e);
        }
        return "";
    }
}

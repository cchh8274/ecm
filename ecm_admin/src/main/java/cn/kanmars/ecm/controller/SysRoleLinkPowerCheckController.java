/**
 * ecm Generator
 */
package cn.kanmars.ecm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.xbase.frame.interceptor.UserLoginBean;
import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.kanmars.ecm.base.AdvancedAjaxBaseController;
import cn.kanmars.ecm.logic.SysRoleLinkPowerCheckLogic;

/**
 * SysRoleLinkPowerCheckController
 */
@Controller
@RequestMapping("/roleLinkPower")
public class SysRoleLinkPowerCheckController extends AdvancedAjaxBaseController {

	protected HLogger logger = LoggerManager.getLoger("SysroleInfoController");

	@Autowired
	private SysRoleLinkPowerCheckLogic sysRoleLinkPowerCheckLogic;

	@RequestMapping("/check.dhtml")
	public void powerCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// userID
		UserLoginBean user = (UserLoginBean) request.getSession().getAttribute("user");
		String userNo = user.getUserId();

		// urls
		String requestJson = request.getParameter("jsonStr");
		JSONObject jsonObject = JSONObject.fromObject(requestJson);
		String urls = jsonObject.get("urlsParam").toString();

		try {
			String responseStr = sysRoleLinkPowerCheckLogic.querySysRoleLinkPower(userNo, urls);
			ajaxJsonMessage(request, response, responseStr, SUCCESS, requestJson);
			logger.debug("responseStr是：：：：：：：：：" + responseStr);
		} catch (Exception e) {
			logger.error("处理失败", e);
			ajaxJsonMessage(request, response, ERROR, "操作异常,请联系管理员！", QUERY);
		}

	}

}

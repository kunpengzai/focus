package com.jarvis.focus.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jarvis.focus.utils.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.focus.dto.FocusUserSessionBean;
import com.jarvis.focus.entity.FocusUser;
import com.jarvis.focus.service.FocusUserService;
import com.jarvis.focus.utils.Constants;

/**
 * 
 * @author Jia Qianpeng
 * 2015-12-25
 */

@Controller
@RequestMapping ("/focuslogin/")
public class LoginController {
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Resource
	private FocusUserService focusUserService;

	@RequestMapping ("login")
	public String login(Model model, HttpServletRequest request, String notifyUrl) {
		if (StringUtils.isNotEmpty(notifyUrl)) {
			model.addAttribute("notifyUrl", notifyUrl);
		}
		return "/focuslogin/login";
	}
	
	@RequestMapping ("relogin")
	public String relogin(Model model, HttpServletRequest request, String notifyUrl) {
		if (StringUtils.isNotEmpty(notifyUrl)) {
			model.addAttribute("notifyUrl", notifyUrl);
		}
		return "/focuslogin/login";
	}
	
	@RequestMapping ("logout")
	public String logout(Model model,HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute(Constants.SYS_USER_INF_IN_SESSION);
		request.getSession().invalidate();
		return "/focuslogin/login";
	}
	
	@RequestMapping ("loginCheck")
	public String loginCheck(Model model, String username, String password, String notifyUrl, 
			HttpServletRequest request) {
		try {
			if (!request.getMethod().equals("POST")) {
				model.addAttribute("error_msg", "不支持的方法提交！");
				return gotoLogin(model, notifyUrl);
			}
			if (StringUtils.isBlank(StringUtils.trimToEmpty(username))) {
				model.addAttribute("error_msg", "请输入账号！");
				return gotoLogin(model, notifyUrl);
			} 
			if (StringUtils.isBlank(StringUtils.trimToEmpty(password))) {
				model.addAttribute("error_msg", "请输入密码！");
				return gotoLogin(model, notifyUrl);
			}
			FocusUser iUser = focusUserService.getByCredentials(username, password);
			if (iUser == null || iUser.getId() == null) {
				model.addAttribute("error_msg", "账号或密码错误！");
				return gotoLogin(model, notifyUrl);
			} else {
			    FocusUserSessionBean iUserBean = new FocusUserSessionBean();
			    iUserBean.setFocusUserId(iUser.getId());
			    iUserBean.setUsername(iUser.getUsername());
			    request.getSession(true).setAttribute(Constants.SYS_USER_INF_IN_SESSION, iUserBean);
				String ip = CommonUtils.getRemoteAddr(request);
				focusUserService.increaseLonginUserNum(iUser.getId(), ip);
			}
		} catch (Throwable e) {  
			log.error("登陆错误", e);
			request.setAttribute("error", "登录异常，请联系管理员！");
			return gotoLogin(model, notifyUrl);
		}
		if (StringUtils.isNotEmpty(notifyUrl)) {
			return "redirect:"+notifyUrl;
		}
		return "redirect:/fm/member-list.htm";
	}
	
	private String gotoLogin(Model model, String notifyUrl) {
		if (StringUtils.isNotEmpty(notifyUrl)) {
			model.addAttribute("notifyUrl", notifyUrl);
		}
		return "/focuslogin/login";
	}
}

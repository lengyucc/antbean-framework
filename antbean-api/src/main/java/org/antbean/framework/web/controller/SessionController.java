package org.antbean.framework.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
	private static final String LOGINED_USERNAME_KEY = "logined-username";

	@RequestMapping("/login")
	public Object login(HttpServletRequest request, String username) {
		String loginedUsername = (String) request.getSession().getAttribute(LOGINED_USERNAME_KEY);
		if (StringUtils.isNotBlank(loginedUsername)) {
			return "已登录: " + loginedUsername;
		}
		request.getSession().setAttribute(LOGINED_USERNAME_KEY, username);
		return "登录成功";
	}

	@RequestMapping("/logout")
	public Object logout(HttpServletRequest request) {
		String loginedUsername = (String) request.getSession().getAttribute(LOGINED_USERNAME_KEY);
		if (StringUtils.isBlank(loginedUsername)) {
			return "已登出";
		}
		request.getSession().removeAttribute(LOGINED_USERNAME_KEY);
		return "登出成功: " + loginedUsername;
	}

	@RequestMapping("/home")
	public Object home(HttpServletRequest request) {
		String loginedUsername = (String) request.getSession().getAttribute(LOGINED_USERNAME_KEY);
		if (StringUtils.isNotBlank(loginedUsername)) {
			return "欢迎您, " + loginedUsername + ".";
		}
		return "当前无用户登录.";
	}
}

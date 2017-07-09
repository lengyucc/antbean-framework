package org.antbean.framework.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.AccessLog;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@Autowired
	RemoteIpFilter remoteIpFilter;

	@RequestMapping("/answer")
	public Object answer(String name) {
		System.out.println(name);
		return "Hello " + name;
	}

	@RequestMapping("/hello")
	public Object hello() {
		return "Hello World";
	}

	@RequestMapping("/ip")
	public Object getIp(@RequestAttribute(AccessLog.REMOTE_ADDR_ATTRIBUTE) String ip) {
		return ip;
	}
	
	@RequestMapping("/session")
	public Object session(HttpServletRequest request) {
		request.getSession().setAttribute("time", System.currentTimeMillis());
		return "ok";
	}
	
	@RequestMapping("/getsession")
	public Object getSession(HttpServletRequest request) {
		return request.getSession().getAttribute("time");
	}
}
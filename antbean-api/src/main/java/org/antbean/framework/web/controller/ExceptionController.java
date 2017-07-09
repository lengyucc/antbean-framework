package org.antbean.framework.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.antbean.common.exception.ServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
	
	@RequestMapping("/e")
	public void e(HttpServletResponse response) throws IOException {
		System.out.println(response.getCharacterEncoding());
		response.getWriter().println("哈哈哈哈哈");
	}

	@RequestMapping("/e1")
	public Object e1() {
		throw new ServiceException("服务异常");
	}

	@RequestMapping("/e2")
	public Object e2() {
		throw new IllegalArgumentException();
	}
	
//	@ExceptionHandler
//	public Object exceptionHandler(Exception e) {
//		return "系统异常";
//	}
}

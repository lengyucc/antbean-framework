package com.antbean.framework.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antbean.framework.common.exception.ServiceException;

@RestController
public class ExceptionController {
	@RequestMapping("/e1")
	public Object e1() {
		throw new ServiceException("服务异常");
	}

	@RequestMapping("/e2")
	public Object e2() {
		throw new IllegalArgumentException();
	}
}

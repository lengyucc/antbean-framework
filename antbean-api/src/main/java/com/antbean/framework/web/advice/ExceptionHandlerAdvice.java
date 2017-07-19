package com.antbean.framework.web.advice;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.antbean.framework.common.exception.ServiceException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
	@ExceptionHandler(ServiceException.class)
	public Object exception(ServiceException e, WebRequest request) {
		return "ServiceException: " + e.getCode() + ", " + e.getMessage();
	}

	@ExceptionHandler(BindException.class)
	public Object exception(BindException e, WebRequest request) {
		System.out.println("=========================================");
		for (ObjectError error : e.getAllErrors()) {
			System.out.println(error.getDefaultMessage());
		}
		System.out.println("=========================================");
		return "参数异常:" + e.getAllErrors().get(0).getDefaultMessage();
	}

	@ExceptionHandler(Exception.class)
	public Object exception(Exception e, WebRequest request) {
		return "未知系统异常";
	}
}

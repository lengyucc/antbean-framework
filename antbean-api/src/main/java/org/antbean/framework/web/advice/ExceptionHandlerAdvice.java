package org.antbean.framework.web.advice;

import org.antbean.common.exception.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	public Object exception(ServiceException e, WebRequest request) {
		return "ServiceException: " + e.getCode() + ", " + e.getMessage();
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object exception(Exception e, WebRequest request) {
		return "未知系统异常";
	}
}

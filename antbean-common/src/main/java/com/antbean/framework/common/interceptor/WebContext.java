package com.antbean.framework.common.interceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WebContext {
	private static ThreadLocal<HttpServletRequest> request = new ThreadLocal<HttpServletRequest>();
	private static ThreadLocal<HttpServletResponse> response = new ThreadLocal<HttpServletResponse>();

	protected static void setRequest(HttpServletRequest req) {
		request.set(req);
	}

	protected static void setResponse(HttpServletResponse res) {
		response.set(res);
	}

	protected static void removeRequest() {
		request.remove();
	}

	protected static void removeResponse() {
		response.remove();
	}

	public static HttpServletRequest getRequest() {
		return request.get();
	}

	public static HttpSession getSession() {
		return request.get().getSession();
	}

	public static ServletContext getServletContext() {
		return request.get().getServletContext();
	}

	public static HttpServletResponse getResponse() {
		return response.get();
	}
}

package org.antbean.framework.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {
	protected String name;

	public MyFilter(String name) {
		this.name = name;
		System.out.println(name + "创建");
	}

	@Override
	public void destroy() {
		System.out.println(name + "销毁");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println(name + "执行前");
		chain.doFilter(request, response);
		System.out.println(name + "执行后");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println(name + "初始化");
		// String tag = config.getInitParameter("tag");
		// System.out.println(tag);
	}
}
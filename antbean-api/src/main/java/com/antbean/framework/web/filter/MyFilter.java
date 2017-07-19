package com.antbean.framework.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class MyFilter extends OncePerRequestFilter {
	String name;

	public MyFilter(String name) {
		super();
		this.name = name;
		
		System.out.println("------------------------ filter被创建");
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println(name + "执行前");
		filterChain.doFilter(request, response);
		System.out.println(name + "执行后");
	}
}
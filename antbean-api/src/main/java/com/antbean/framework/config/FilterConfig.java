package com.antbean.framework.config;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.antbean.framework.common.filter.XssFilter;
import com.antbean.framework.web.filter.MyFilter;

@Configuration
public class FilterConfig {

	@Autowired
	ServerProperties serverProperties;

	@Bean
	public RemoteIpFilter remoteIpFilter() {
		return new RemoteIpFilter();
	}

	@Bean
	public FilterRegistrationBean xssFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setName("xssFilter");
		registration.setFilter(new XssFilter());
		registration.addUrlPatterns(serverProperties.getServletPath());
		registration.setOrder(0);
		return registration;
	}

	@Bean
	public FilterRegistrationBean f1() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setName("f1");
		registration.setFilter(new MyFilter("F1"));
		registration.addUrlPatterns(serverProperties.getServletPath());
		registration.setOrder(1);
		return registration;
	}

	@Bean
	public FilterRegistrationBean f2() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setName("f2");
		registration.setFilter(new MyFilter("F2"));
		registration.addUrlPatterns(serverProperties.getServletPath());
		registration.setOrder(2);
		return registration;
	}
}

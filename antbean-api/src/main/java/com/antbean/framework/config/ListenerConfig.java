package com.antbean.framework.config;

import javax.servlet.ServletContextListener;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.antbean.framework.web.listener.MyServletContextListener;

@Configuration
public class ListenerConfig {
	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> servletContextListener() {
		return new ServletListenerRegistrationBean<ServletContextListener>(new MyServletContextListener());
	}
}

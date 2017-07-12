package com.antbean.framework;

import javax.servlet.Filter;
import javax.servlet.ServletContextListener;

import com.antbean.framework.web.filter.MyFilter;
import com.antbean.framework.web.filter.XssFilter;
import com.antbean.framework.web.listener.MyServletContextListener;
import org.apache.catalina.filters.RemoteIpFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
@EnableCaching
@MapperScan("com.antbean.framework.dal.mapper")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> servletContextListener() {
		return new ServletListenerRegistrationBean<ServletContextListener>(new MyServletContextListener());
	}

	/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ filter配置 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
	/*
	 * 配置filter的两种方式: 1.注册一个实现Filter接口的bean 2.注册FilterRegistrationBean
	 * 
	 * 使用FilterRegistrationBean方式配置的filter会最先执行；
	 * 多个FilterRegistrationBean按配置先后顺序执行，多个filter同理
	 */

	@Bean
	public RemoteIpFilter remoteIpFilter() {
		return new RemoteIpFilter();
	}

	@Bean
	public Filter xssFilter() {
		return new XssFilter();
	}

	@Bean
	public Filter testFilter() {
		return new MyFilter("F1");
	}

	// @Bean
	// public FilterRegistrationBean testFilterRegistration() {
	// FilterRegistrationBean registration = new FilterRegistrationBean();
	// registration.setFilter(new XssFilter());
	// registration.addUrlPatterns("/*");
	// registration.setOrder(1);
	// return registration;
	// }
	/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ filter配置 ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
}
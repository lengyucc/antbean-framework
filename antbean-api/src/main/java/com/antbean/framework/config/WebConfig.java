package com.antbean.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.antbean.framework.common.interceptor.TokenInterceptor;

@Configuration
@EnableRedisHttpSession
public class WebConfig extends WebMvcConfigurerAdapter {

	// 文件上传解析器
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(1000000);
		return commonsMultipartResolver;
	}

	// 设置拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new WebContentInterceptor());
		 registry.addInterceptor(new TokenInterceptor());
	}
}

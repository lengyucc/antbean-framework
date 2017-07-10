package com.antbean.framework;

import javax.servlet.Filter;

import com.antbean.framework.web.filter.MyFilter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan
public class FilterConfig {
	@Bean
	public Filter testFilter() {
		return new MyFilter("F2");
	}
}

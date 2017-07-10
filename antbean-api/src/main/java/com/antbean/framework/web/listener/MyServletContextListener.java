package com.antbean.framework.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("-----------> context inited");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("-----------> context destoryed");
	}
}

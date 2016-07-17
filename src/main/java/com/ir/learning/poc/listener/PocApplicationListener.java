package com.ir.learning.poc.listener;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

@Component
public class PocApplicationListener implements ApplicationContextAware, ApplicationListener<ApplicationContextEvent> {
	
	private static final Logger LOGGER = Logger.getLogger(PocApplicationListener.class);
	
	private ApplicationContext applicationContext;

	public void onApplicationEvent(ApplicationContextEvent event) {
		
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for(String beanName : beanDefinitionNames) {
			if(!beanName.contains("scopedTarget")) {
				String beanClassName = applicationContext.getBean(beanName).getClass().toString();
				LOGGER.debug(beanClassName);
			}
		}
		
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}

}

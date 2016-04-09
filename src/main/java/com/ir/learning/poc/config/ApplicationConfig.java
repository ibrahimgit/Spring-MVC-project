package com.ir.learning.poc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ir.learning.poc.domainmodel.Department;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.ir.learning.poc")
@ImportResource("classpath:poc-context.xml") //@Configuration class-centric use of XML with @ImportResource
//@PropertySource("classpath:application.properties")
public class ApplicationConfig {
	
	@Bean
	public Department department() {
		return new Department();
	}

}

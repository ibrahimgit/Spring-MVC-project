package com.ir.learning.poc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ir.learning.poc.domainmodel.Department;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.ir.learning.poc")
@ImportResource("classpath:poc-context.xml") //@Configuration class-centric use of XML with @ImportResource
//@PropertySource("classpath:application.properties")
public class ApplicationConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("Home");
		registry.addViewController("/login").setViewName("login");
	}
	
	@Override //This is mandatory for view resolver
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp();
	}
	
	/*@Bean // This is not required as this is default view resolver bean for dispatcher servlet
	public InternalResourceViewResolver viewResolver(){
		System.out.println("viewResolver");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}*/
	
	
	/*@Bean
	public ClassLoaderTemplateResolver templateResolver() {
		ClassLoaderTemplateResolver result = new ClassLoaderTemplateResolver();
		result.setPrefix("views/");
		result.setSuffix(".html");
		result.setTemplateMode("HTML5");
		return result;
	}*/
	
	@Bean
	public Department department() {
		return new Department();
	}

}

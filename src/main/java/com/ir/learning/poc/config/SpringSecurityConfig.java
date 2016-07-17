package com.ir.learning.poc.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final Logger LOGGER = Logger.getLogger(SpringSecurityConfig.class);
	
	/*@Autowired
	public void configureSecurity(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("*******************configureSecurity********************");
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		
	}*/
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		LOGGER.debug("*******************configureSecurity********************");
		//super.configure(auth);
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		super.configure(http);
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin().loginPage("/login").permitAll()/*.and().httpBasic()*/;
	}

}

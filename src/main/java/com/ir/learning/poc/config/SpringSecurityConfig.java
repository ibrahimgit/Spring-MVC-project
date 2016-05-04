package com.ir.learning.poc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*@Autowired
	public void configureSecurity(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("*******************configureSecurity********************");
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		
	}*/
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("*******************configureSecurity********************");
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

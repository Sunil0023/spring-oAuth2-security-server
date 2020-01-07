package com.sunil.server.testnewserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@Configuration
public class EmployeeSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Override
	public void configure(WebSecurity web) throws Exception {
		
		System.out.println("In EmployeeSecurityConfiguration Class");
		System.out.println("In configure(WebSecurity web) method");
		
		web.ignoring().antMatchers("/resources/**");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		System.out.println("In EmployeeSecurityConfiguration Class");
		System.out.println("In configure(HttpSecurity http) method");
		
		http	
		.authorizeRequests()
		.antMatchers("/")
		.permitAll()
		.antMatchers("/user/getEmployeesList")
		.hasAnyRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.permitAll()
		.and()
		.logout()
		.permitAll();

		http.csrf().disable();

	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		
		System.out.println("In EmployeeSecurityConfiguration Class");
		System.out.println("In configure(AuthenticationManagerBuilder authenticationMgr) method");
		
		authenticationMgr.inMemoryAuthentication()
		.withUser("admin")
		.password(passwordEncoder().encode("admin"))
		.authorities("ROLE_ADMIN");
	}

}

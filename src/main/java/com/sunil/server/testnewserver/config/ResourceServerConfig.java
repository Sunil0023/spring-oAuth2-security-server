package com.sunil.server.testnewserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		System.out.println("In ResourceServerConfig Class");
		System.out.println("In configure(HttpSecurity http) method");
	
		http.requestMatchers()
			.antMatchers("/user/getEmployeesList/**")
			.and()
			.authorizeRequests()
			.anyRequest()
			.access("#oauth2.hasScope('read')");
	}
}

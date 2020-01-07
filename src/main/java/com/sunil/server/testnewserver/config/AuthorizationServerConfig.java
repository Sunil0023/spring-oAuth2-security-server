package com.sunil.server.testnewserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

	private final PasswordEncoder passwordEncoder;
    
    public AuthorizationServerConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		System.out.println("In AuthorizationServerConfig Class");
		System.out.println("In configure(ClientDetailsServiceConfigurer clients) method");
		
		clients
				.inMemory()
				.withClient("javainuse")//javainuse
				.secret(passwordEncoder.encode("secret"))
				.authorizedGrantTypes("authorization_code")
				.scopes("read")
				.redirectUris("http://localhost:8090/showEmployees")//redirect_Uri where to go after successful Login
				.authorities("CLIENT");
	}
}

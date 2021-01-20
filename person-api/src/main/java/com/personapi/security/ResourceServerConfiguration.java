package com.personapi.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

/**
 * The Class ResourceServerConfiguration.
 *
 * @author Bharathidasan
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	 /** The Constant RESOURCE_ID. */
 	private static final String RESOURCE_ID = "person-api";

	    @Override
	    public void configure(ResourceServerSecurityConfigurer resources) {
	        resources.resourceId(RESOURCE_ID).stateless(false);
	    }

	    @Override
	    public void configure(HttpSecurity http) throws Exception {
	        http.
	        anonymous().disable()
	        .requestMatchers().antMatchers("/api/person/**")
	        .and().authorizeRequests()
	        .antMatchers("/api/person/**").access("hasRole('ADMIN')")
	        .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	    }
}


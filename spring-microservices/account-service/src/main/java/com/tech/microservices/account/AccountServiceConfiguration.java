/**
 * 
 */
package com.tech.microservices.account;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
/**
 * @author manickamb
 *
 */
@Configuration
@ComponentScan("com.tech.microservices")
public class AccountServiceConfiguration {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builderObj) {
	  return  builderObj.build();
	}

}

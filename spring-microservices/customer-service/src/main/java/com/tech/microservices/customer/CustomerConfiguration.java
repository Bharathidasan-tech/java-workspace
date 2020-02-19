/**
 * 
 */
package com.tech.microservices.customer;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author manickamb
 *
 */
@Configuration
@ComponentScan("com.tech.microservices.customer")
public class CustomerConfiguration {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builderObj) {
	  return  builderObj.build();
	}

}

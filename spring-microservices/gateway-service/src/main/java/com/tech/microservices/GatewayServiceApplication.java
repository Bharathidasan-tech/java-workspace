package com.tech.microservices;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableZuulProxy
@RestController
public class GatewayServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(GatewayServiceApplication.class).web(WebApplicationType.SERVLET).run(args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builderObj) {
	  return  builderObj.build();
	}
	
	

}

package com.springbatchexample1;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchExample1Application
{

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBatchExample1Application.class, args);
	}
}

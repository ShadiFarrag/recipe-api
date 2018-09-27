package com.altimetrik.recipeExercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AltimetrikRecipeApplication {

		
	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		return restTemplate;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AltimetrikRecipeApplication.class, args);
		System.out.println("Starting: Altimetrik Recipe Application");
	}
}

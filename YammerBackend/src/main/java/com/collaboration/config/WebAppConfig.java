package com.collaboration.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc 
@ComponentScan(basePackages="com.collaboration")

public class WebAppConfig extends WebMvcConfigurerAdapter {
	
	public WebAppConfig(){
		 System.out.println("WebAppConfig class is loaded and instantiated");
	 }
	@Bean
	public CommonsMultipartResolver multipartResolver()
	{
		return new CommonsMultipartResolver();
	}
	
	

}

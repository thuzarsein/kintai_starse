package com.starse.kintai;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class ConfigAboutWeb implements WebMvcConfigurer{
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("/home"); 
		registry.addViewController("/").setViewName("/home");		
		registry.addViewController("/sign-in").setViewName("/sign-in");
	    registry.addViewController("/sign-up").setViewName("/sign-up"); 
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/static/");
	}
}

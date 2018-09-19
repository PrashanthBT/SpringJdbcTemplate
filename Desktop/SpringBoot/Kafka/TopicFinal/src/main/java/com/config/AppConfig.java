package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.controller")
@EnableWebMvc
public class AppConfig
{

	@Bean
	public ViewResolver getResolver()
	{
		InternalResourceViewResolver view=new InternalResourceViewResolver();
		view.setPrefix("/WEB-INF/");
		view.setSuffix(".jsp");
		return view;
	}
}

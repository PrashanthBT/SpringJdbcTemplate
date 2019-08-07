package com.spring.jdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.spring.jdbc")
/* @PropertySource("classpath:resources/dashboardQueries.properties") */
@PropertySources({
    @PropertySource("classpath:resources/dashboardQueries.properties"),
    @PropertySource("classpath:resources/database.properties"),
    @PropertySource("classpath:resources/log4j.properties")
})
public class DashConfig {

	@Autowired
	private Environment env;
	@Bean
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate template=new JdbcTemplate();
		template.setDataSource(dataSource());
		return  template;
	}
	@Bean
	public DriverManagerDataSource dataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setDriverClassName(env.getProperty("jdbc.driverClassname"));
		System.out.println("username::"+env.getProperty("jdbc.username"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		return ds;
	}
}

package com.board.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

//TODO Config apikey properties 설정.
@Configuration
@ComponentScan(basePackages = {"com.board.*"})
@PropertySource("classpath:apikey.properties")
public class ApiKey {
//	@Autowired
//	private static Environment env;
//	@Bean
//	public static String getApiKey() {
//		return new String(env.getProperty("apikey"));
//	}
	@Value("${apikey.value}")
	private static String api;
	
	public static String getApiKey() {
		return api;
	}
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
	
}

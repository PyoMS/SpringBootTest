package com.board.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//TODO Config apikey properties 설정.
@Component
@PropertySource("classpath:application_APIKEY.properties")
public class ApiKey {
	
	private String API;
	
	@Autowired
	public ApiKey(@Value("${api-key}")String apikey) {
		this.API = apikey;
	}

	public String getAPI() {
		return API;
	}
}

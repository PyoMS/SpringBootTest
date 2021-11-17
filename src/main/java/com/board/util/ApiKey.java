package com.board.util;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.stereotype.Component;

//TODO property 파일 테스트 중
@Component
//@PropertySource("classpath:apikey.properties")
public class ApiKey {
	
//	@Value("${apikey}")
//	private static String apikey;

	public static String getApikey() throws Exception {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		ConfigurableEnvironment env = ctx.getEnvironment();
		
		MutablePropertySources prop = env.getPropertySources();
		
		prop.addLast(new ResourcePropertySource("classpath:apikey.properties"));
		
		// 프로퍼티 정보 얻기
		String api = env.getProperty("api");
		String key = env.getProperty("key");
		
		System.out.println(api + " : " + key);
		
		return key;
	}
	
}

package com.board.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class BoardApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}
	
	@Override protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BoardApplication.class); 
	}

//	@Bean
//	public WebClient getWebClientBuilder(){
//	    return   WebClient.builder().exchangeStrategies(ExchangeStrategies.builder()
//	            .codecs(configurer -> configurer
//	                      .defaultCodecs()
//	                      .maxInMemorySize(-1))
//	                    .build())
//	                  .build();
//	}

}

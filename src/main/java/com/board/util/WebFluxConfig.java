package com.board.util;

import org.springframework.boot.web.codec.CodecCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebFluxConfig implements WebFluxConfigurer{
	@Override 
	public void configureHttpMessageCodecs(ServerCodecConfigurer configurer) {
		configurer.defaultCodecs().maxInMemorySize(-1); 
	} 
	
	@Bean 
	public CodecCustomizer maxInMemorySizeCodecCustomizer() { 
		return (configurer) -> configurer.defaultCodecs().maxInMemorySize(-1); 
	}
	
	@Bean
	public WebClient getWebClientBuilder(){
	    return   WebClient.builder().exchangeStrategies(ExchangeStrategies.builder()
	            .codecs(configurer -> configurer
	                      .defaultCodecs()
	                      .maxInMemorySize(-1))
	                    .build())
	                  .build();
	}

}

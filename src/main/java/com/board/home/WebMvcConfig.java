package com.board.home;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
/* Time, in seconds, to have the browser cache static resources (one week). */
private static final int BROWSER_CACHE_CONTROL = 604800;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 registry
		  .addResourceHandler("/images/**")
		  .addResourceLocations("/images/")
		  .setCachePeriod(BROWSER_CACHE_CONTROL);
		 
		 registry
		 .addResourceHandler("/webjars/**")
		 .addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
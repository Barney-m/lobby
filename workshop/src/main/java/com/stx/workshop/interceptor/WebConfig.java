package com.stx.workshop.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
    LoggerInterceptor loggerInterceptor;

	@Autowired
    StxAuthInterceptor stxAuthInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(loggerInterceptor).addPathPatterns("/**");
	    registry.addInterceptor(stxAuthInterceptor).addPathPatterns("/**");
	}
}

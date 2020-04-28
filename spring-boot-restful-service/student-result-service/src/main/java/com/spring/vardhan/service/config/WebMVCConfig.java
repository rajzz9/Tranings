package com.spring.vardhan.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer{

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		UrlPathHelper urlHelper = new UrlPathHelper();
		urlHelper.setRemoveSemicolonContent(true);
		configurer.setUrlPathHelper(urlHelper);
	}
	
}

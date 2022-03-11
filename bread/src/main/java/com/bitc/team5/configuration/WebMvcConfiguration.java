package com.bitc.team5.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
	
	

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setDefaultEncoding("UTF-8");
		commonsMultipartResolver.setMaxUploadSizePerFile(5 * 1024 * 1024);
		
		return commonsMultipartResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		
	
		
		registry.addResourceHandler("/img/**").addResourceLocations("file:///c:/img/");
		
		//addResourceHandler : 스프링부트에서 확인할 폴더 위치 설정 
		// add ResourceLocations 실제 시스템의 폴더위치 , 윈도우 시스템의 경우 file:///경로' 형태로 사용
				// 리눅스 시스템의 겨우 ;file:/경로 형태로 사용, root에서 시작하는 전체 경로
		registry.addResourceHandler("/img2/**").addResourceLocations("file:///c:/java404/");
			// 뒤의 경로는 앞의 img폴더로 이해한다
	}

}

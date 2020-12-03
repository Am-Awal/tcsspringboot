package com.tcs.springbootemployee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.tcs.springbootemployee.interceptor.AdminInterceptor;
import com.tcs.springbootemployee.interceptor.GuestInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("com.tcs.springbootemployee")
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new GuestInterceptor()).addPathPatterns("/guest");
		registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin");
		super.addInterceptors(registry);
	}
	
	
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

}

package com.tcs.employeeservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.tcs.employeeservice.interceptor.AdminInterceptor;
import com.tcs.employeeservice.interceptor.GuestInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("com.tcs.employeeservice")
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

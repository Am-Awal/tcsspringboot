
package com.tcs.springbootmvcdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.tcs.springbootmvcdemo.interceptor.AdminInterceptor;
import com.tcs.springbootmvcdemo.interceptor.GuestInterceptor;

@Configuration
@EnableWebMvc // it activates the mvc env (@requestbody, controller, response body, requestmapping, @valid, ...)
@ComponentScan("com.tcs.mvcdemo")
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

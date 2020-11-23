package com.tcs.springbootdemo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication // This @ is combo of:
// 1. @SpringBootConfigration ======@Configuration in earlier versions

// 2. @ EnableAutoConfiguration
// here it enables spring boot to auto configure the application context.
// it automatically creates and registers beans based on both the included jars in the class path & beans defined by us.
// Spring MVC ===> Spring web jar and tomcat server plugin
// when spring web starter ===> it will include the tomcat server and mvc based config
// to exclude names autoconfig we want to skip==> specify that list to @enableautoconfiguration


// 3. @ComponentScan

public class SpringbootdemoApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringbootdemoApplication.class, args);
		
		String [] beanNames = applicationContext.getBeanDefinitionNames();
		
		Arrays.sort(beanNames);
		
		for(String beanName: beanNames) {
			System.out.println(beanName);
		}
	}

}

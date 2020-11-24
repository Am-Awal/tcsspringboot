package com.tcs.springbootdemo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tcs.springbootdemo.model.Book;
import com.tcs.springbootdemo.model.Page;
import com.tcs.springbootdemo.repository.BookRepository;
import com.tcs.springbootdemo.repository.PageRepository;
import com.tcs.springbootdemo.model.Product;
import com.tcs.springbootdemo.service.ProductService;

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
		ApplicationContext context = SpringApplication.run(SpringbootdemoApplication.class, args);
		
//		String [] beanNames = applicationContext.getBeanDefinitionNames();
//		
//		Arrays.sort(beanNames);
//		
//		for(String beanName: beanNames) {
//			System.out.println(beanName);
		
//		}
//		ProductService productService = context.getBean(ProductService.class);
//
//		
//
//		String result1 = productService.createProduct(new Product(1, "laptop", "i5 10th gen", 1003.0f, "mac laptop"));
//		String result2 = productService.createProduct(new Product(2, "laptop", "i5 10th gen", 2003.0f, "laptop"));
//		String result3 = productService.createProduct(new Product(3, "laptop", "i5 10th gen", 3003.0f, "mac laptop"));
//		String result4 = productService.createProduct(new Product(4, "laptop", "i5 10th gen", 4003.0f, "laptop"));
//		String result5 = productService.createProduct(new Product(5, "laptop", "i5 10th gen", 5003.0f, "mac laptop"));
//		String result6 = productService.createProduct(new Product(6, "laptop", "i5 10th gen", 6003.0f, "laptop"));
//		String result7 = productService.createProduct(new Product(7, "laptop", "i5 10th gen", 7003.0f, "laptop"));
//		String result10 = productService.createProduct(new Product(10, "laptop", "i5 10th gen", 8003.0f, "laptop"));
//		String result9 = productService.createProduct(new Product(9, "laptop", "i5 10th gen", 9003.0f, "laptop"));
//		
//		System.out.println(result1);
//		System.out.println(result2);
//		System.out.println(result3);
//		System.out.println(result4);
//		System.out.println(result5);
//		System.out.println(result6);
//		System.out.println(result7);
//		System.out.println(result10);
//		System.out.println(result9);
//		
//		
//		Optional<List<Product>> optional = productService.findByPriceGreaterThan(5000.0f);
//		
//		if(optional.isPresent()) {
//			List<Product> products = optional.get();
//			products.forEach(p-> {System.out.println(p);} );
//			
//		}else {
//			System.out.println("problem");
//		}
		
		
		BookRepository bookRepository = context.getBean(BookRepository.class);
		PageRepository pageRepository = context.getBean(PageRepository.class);
		
		Book book = new Book(0,"Java","James","Java001",null);
		bookRepository.save(book);
		
		pageRepository.save(new Page(123,1,"Introduction","intro",book));
		pageRepository.save(new Page(111,1,"Introduction to java 8","intro to java 8",book));
		pageRepository.save(new Page(112,1,"Introduction to collection","intro to collection",book));
		//context.close();
		System.out.println(book.getPages());
	}

}

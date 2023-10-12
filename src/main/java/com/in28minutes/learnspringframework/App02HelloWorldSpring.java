package com.in28minutes.learnspringframework;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
	public static void main(String[] args) {
		//1: Launch Spring Context
		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		
		//2: Configure the things that we want spring to manage - 
		//HelloWorldConfiguration - @Configuration
		//name - @Bean
		
		//3: Retrieving beans managed by spring
		System.out.println(context.getBean("name"));
		System.out.println(context.getBean("age"));
		System.out.println(context.getBean("person")); //here toString method will 
		//automatically called in @Configuration by record
		System.out.println(context.getBean("person2MethodCall"));
		System.out.println(context.getBean("person3Parameters"));
		System.out.println(context.getBean("address_call"));
		System.out.println(context.getBean(Address.class)); //type of the @Bean
		
		//printing all beans
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
	}
	
}

package com.in28minutes.learnspringframework.examples.f1;


import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	private SomeDependency someDependency;
	
	public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency = someDependency;
		System.out.println("All Dependencie are ready...");
	}
	
	@PostConstruct
	public void initialize() {
		someDependency.getReady();
	}
	
	@PreDestroy 
	public void cleanup() {
		System.out.println("Cleanup...");
	}
}

@Component
class SomeDependency {
	public void getReady() {
		System.out.println("Some Logic using Dependency...");
	}
}

@Configuration
@ComponentScan // by default it will scan present package which is ...ecamples.a1;
public class PrePostAnnotationsContextLauncherApplication {
	

	public static void main(String[] args) {
		try(var context = 
				new AnnotationConfigApplicationContext
					(PrePostAnnotationsContextLauncherApplication.class)){
			
//			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
		}
	
	}

}

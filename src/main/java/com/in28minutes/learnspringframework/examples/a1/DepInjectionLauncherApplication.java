package com.in28minutes.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// Note : Three ways to Autowiring are : 
//		using Field reflection, using Setters, using Constructor

@Component
class YourBusinessClass {
	Dependency1 dependency1;
	Dependency2 dependency2;
	
	@Autowired
	// @Autowired annotation is not mandatory in case of Constructor Dependency Injection	
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor Injection - YourBusinessClass");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

//	@Autowired  // using setter
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Setter Injection - setDependency1");
//		this.dependency1 = dependency1;
//	}
//
//	@Autowired  // using setter
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("Setter Injection - setDependency2");
//		this.dependency2 = dependency2;
//	}

	@Override
	public String toString() {
		return "YourBusinessClass [dependency1=" + dependency1 + ", dependency2=" + dependency2 + "]";
	}
	
}

@Component
class Dependency1 {
	
}

@Component
class Dependency2 {
	
}

@Configuration
@ComponentScan // by default it will scan present package which is ...ecamples.a1;
public class DepInjectionLauncherApplication {
	

	public static void main(String[] args) {
		try(var context = 
				new AnnotationConfigApplicationContext
					(DepInjectionLauncherApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			
			System.out.println(context.getBean(YourBusinessClass.class));
			
		}
	
	}

}

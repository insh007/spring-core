package com.in28minutes.learnspringframework.examples.c1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Note: In this activity we did not create any object explicitly although objects are
//managing and creating by Spring Framework and That's the power of Spring Framework. Now
// we don't need to manage and create objects explicitly :)

@Configuration
@ComponentScan // by default it will scan present package which is ...ecamples.a1;
public class RealWorldSpringContextLauncherApplication {
	

	public static void main(String[] args) {
		try(var context = 
				new AnnotationConfigApplicationContext
					(RealWorldSpringContextLauncherApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
			
		}
	
	}

}

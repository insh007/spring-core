package com.in28minutes.learnspringframework.examples.g1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

/*Note : Here we are Using Jakarta Context and Dependency Injection (CDI) which is the
 * alternative to do the same we already done using Spring Annotations
 * 		@Component ~ @Named
 * 		@Autowired ~ @Inject
*/

//@Component
@Named
class BusinessService {
	private DataService dataService;
	
//	@Autowired
	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("Setter Injection...");
		this.dataService = dataService;
	}
	
	public DataService getDataService() {
		return dataService;
	}	
}

//@Component
@Named
class DataService {
	
}

@Configuration
@ComponentScan // by default it will scan present package which is ...ecamples.a1;
public class CDIContextLauncherApplication {
	

	public static void main(String[] args) {
		try(var context = 
				new AnnotationConfigApplicationContext
					(CDIContextLauncherApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			context.getBean(BusinessService.class).getDataService();
		}
	
	}

}

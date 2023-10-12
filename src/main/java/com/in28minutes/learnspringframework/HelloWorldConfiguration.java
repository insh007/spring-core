package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Eliminate verbosity in creating Java Beans
//Public accessor methods, constructor, 
//equals, hashcode and toString are automatically created. 
//Released in JDK 16.

record Person(String name, int age, Address address) {};
record Address(String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {

	@Bean
	public String name() {
		return "Ranga";
	}
	
	@Bean
	public int age() {
		return 22;
	}
	
	@Bean 
	public Person person() {
		return new Person("Ravi", 25, new Address("California", "US"));
//		return person;
	}
	
	// by calling methods directly
	@Bean 
	public Person person2MethodCall() {
		return new Person(name(), age(), address());
	}
	
	//by adding parameters
	@Bean
	public Person person3Parameters(String name, int age, Address address_call) {
		return new Person(name, age, address_call);
	}
	
	@Bean (name = "address_call")
	public Address address() {
		return new Address("Bhoor", "BSR");
	}
}

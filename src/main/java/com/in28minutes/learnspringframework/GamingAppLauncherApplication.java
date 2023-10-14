package com.in28minutes.learnspringframework;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;


@Configuration
@ComponentScan ("com.in28minutes.learnspringframework.game")
public class GamingAppLauncherApplication {
	
	//NOTE: Now Spring creating the object for PacmanGame by using @Component in PacmanGame
	// class and @ComponentScan in this class
	//Earlier we creating object using below Bean
//	@Bean
//	public GamingConsole game() {
//		var game = new PacmanGame();
//		return game;
//	}
	
	// we can manage and create GameRunner instance using spring by using @Component in
	// GameRunner and @ComponentScan in this class
//	@Bean						// game(object) is autowirid creating by Spring  
//	public GameRunner gameRunner(GamingConsole game) {
//		System.out.println("parameter "+game);
//		var gameRunner = new GameRunner(game);
//		return gameRunner;
//		
//	}

	public static void main(String[] args) {
		try(var context = 
				new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)){
			
			context.getBean(GamingConsole.class).up();
			
			context.getBean(GameRunner.class).run();
		}
	
	}

}

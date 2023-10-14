package com.in28minutes.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
//	private MarioGame game;
//	private SuperContraGame game;
	
	private GamingConsole game;
	
	// @Primary Game class methods will run 
//	public GameRunner(GamingConsole game) {
//		this.game = game;
//	}
	
	// use @Qualifier
	// Now SuperContraGame method will run using @Qualifier
	public GameRunner(@Qualifier ("SuperContraGameQualifier") GamingConsole game) {
		this.game = game;
	}
	
	public void run() {
		System.out.println("Running game: "+game);
		game.up();
		game.down();
		game.left();
		game.right();
	}
}

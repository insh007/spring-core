package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;
import com.in28minutes.learnspringframework.game.PacmanGame;
import com.in28minutes.learnspringframework.game.GameRunner;

// Example of Tight Coupling

public class App01GamingBasicJava {

	public static void main(String[] args) {
		
//		var game = new MarioGame();
//		var game = new SuperContraGame();
		var game = new PacmanGame();  // Object creation
		
		var gameRunner = new GameRunner(game);
		// Object creation + Wiring of Dependencies
		// Game is a Dependency of GameRunner 
		gameRunner.run();
	}

}

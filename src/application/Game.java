package application;
import controller.Controller;

/**
 * The game.
 * Run this main to play the game.
 * @author Manos Chatzakis
 *
 */
public class Game {

	public static void main(String[] args) {
		System.out.println("Application started.");
		Controller c = new Controller();
		c.beginNewGame();
	}

}

package model.square;

import java.awt.Color;

import model.player.Player;

/**
 * <b>This class simulate a home square of the board.</b>
 * Home Squares have two versions: 1 home square for the first player, and 1 home square for the second player.
 * So these squares are characterized by their color(red and yellow) and the player allowed to access them.
 * @author Manos Chatzakis
 *
 */
public class HomeSquare extends Square{

	Player player; //The played allowed to get in the home position.
	
	/**
	 * <b>Constructor:</b>
	 * Generates a home square for a specific player.</br>
	 * <b>PostCondition:</b> Creates a home square.
	 * @param color The color of the square(red or yellow).
	 * @param player The player allowed to access the square.
	 */
	public HomeSquare(Color color,Player player) {
		super(color);
		this.player = player;
	}
	
	public String toString() {
		return super.toString() + "HomeSquare";
	}

}

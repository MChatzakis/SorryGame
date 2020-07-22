package model.square;

import java.awt.Color;

import model.player.Player;

/**
 * <b>This class simulates a start square.</b>
 * Start squares are the positions in which every pawn is placed at the beggining of the game.
 * They have specific color (red of white) and the player which starts from every start square.
 * @author Manos Chatzakis
 *
 */
public class StartSquare extends Square{
	
	Player player; //The player to start from this start square.
	
	/**
	 * <b>Constructor:</b>
	 * Generates a new start square with a color for a player.</br>
	 * <b>PostCondition:</b> Creates a start square and initializing color and fields.</br>
	 * @param color The color (red or yellow).
	 * @param player The player to start from this square.
	 */
	public StartSquare(Color color, Player player) {
		super(color);
		this.player = player;
	}
	
	public String toString() {
		return super.toString() + "StartSquare";
	}

}

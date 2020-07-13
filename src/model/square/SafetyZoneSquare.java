package model.square;

import java.awt.Color;

import model.player.Player;

/**
 * <b>This class simulates the safety zone squares of the sorry game.</b>
 * These are the five squares before the home square.
 * They have color while they can host only one player of the game.
 * @author Manos Chatzakis
 *
 */
public class SafetyZoneSquare extends Square{

	Player player; //The player allowed to enter the safety zone.
	
	/**
	 * <b>Constructor:</b>
	 * Generates the safety zone squares.</br>
	 * <b>PostCondition:</b> Creates a safety zone square with color.
	 * @param color the color(red or yellow)
	 * @param player The played allowed to enter.
	 */
	public SafetyZoneSquare(Color color,Player player) {
		super(color);
		this.player = player;
	}

	public String toString() {
		return super.toString() + "SafetyZoneSquare";
	}
	
}

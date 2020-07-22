 package model.player;

import java.awt.Color;
import model.pawn.Pawn;

/**
 * <b>This class simulates a player of the Sorry! board game.</b></br>
 * All players have a standard color, a pawn, and the "fold" decision.
 * Also there is a turn between the players of the game.
 * A player wins when his two pawns have reached the home square.
 * @author Manos Chatzakis
 *
 */
public class Player {
	
	private String name; //The name of the player.
	private Color color; //The color of the player.
	private Pawn pawn1; //The first pawn of the player.
	private Pawn pawn2; //The second pawn of the player.
	private boolean turn; //A variable to decide the turn.
	
	/** 
	 * <b>Constructor:</b>
	 * Generates a new player.</br>
	 * <b>PostCondition:</b> Creates a new player and initializes his fields.
	 * @param name The desired name.
	 * @param color The desired color.
	 * @param pawn1 The first pawn of the player.
	 * @param pawn2 The second pawn of the player.
	 */
	public Player(String name,Color color,Pawn pawn1,Pawn pawn2) {
		System.out.println("Player generated.");
		this.name = name;
		this.color = color;
		this.pawn1 = pawn1;
		this.pawn2 = pawn2;
		this.turn = false;
	}

	/**
	 * <b>Accessor:</b>
	 * This method returns the name of the player.</br>
	 * <b>PostCondition:</b> Returns the name of the player.
	 * @return The player's name (String).
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method sets the name of the player.</br>
	 * <b>PostCondition:</b> Sets a new name for the player.</br>
	 * @param name The players name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method returns the color of the player.</br>
	 * <b>PostCondition:</b> Returns the color of the player.</br>
	 * @return The color of the player (color).
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method sets the color of the player.</br>
	 * <b>PostCondition:</b> Sets a new color for the player.</br>
	 * @param color the color of the player.
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method gets the one pawn of the player.</br>
	 * <b>PostCondition:</b> Returns the first pawn of the player.</br>
	 * @return The first pawn (Pawn).
	 */
	public Pawn getPawn1() {
		return pawn1;
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method returns the second pawn of the player. </br>
	 * <b>PostCondition:</b> Returns the second pawn of the player.
	 * @return The second pawn (Pawn).
	 */
	public Pawn getPawn2() {
		return pawn2;
	}
	
	/**
	 * <b>Transformer:</b>
	 * Method to initialize both pawns of the player. </br>
	 * @param pawn1 The first pawn.
	 * @param pawn2 The second pawn.
	 */
	public void setPawns(Pawn pawn1,Pawn pawn2) {
		this.pawn1 = pawn1;
		this.pawn2 = pawn2;
	}
	
	/**
	 * <b>Transformer:</b>
	 * Method to set the turn between the two players. </br>
	 * <b>PostCondition:</b> Sets the turn.
	 * @param turn The turn.
	 */
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	
	/**
	 * <b>Observer:</b>
	 * Method to get if the player has played or is his turn.</br>
	 * <b>PostCondition:</b> Returns if a player has played or not.</br>
	 * @return True if the player has played, else false.
	 */
	public boolean hasPlayed() {
		return turn;
	}
	
	/**
	 * <b>Observer:</b>
	 * Method to find out if both of the pawns of the player are at home square.</br>
	 * <b>PostCondition:</b> Returns if the player has won or not.</br>
	 * @return A boolean flag about if the player has won.
	 */
	public boolean hasWon() {
		return (pawn1.isInHome() && pawn2.isInHome());
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method represents the player's choice not to play a round.</br>
	 * <b>PostCondition:</b> Changes the turn between the two players.</br>
	 */
	public void fold() {
		this.turn = false;
	} 
	
	/**
	 * <b>Observer:</b>
	 * Method to find out if a pawn belongs to the player.</br>
	 * <b>PostCondition:</b> Returns if the player has this pawn or not.</br>
	 * @param p The pawn
	 * @return True if he has this pawn, otherwise false..
	 */
	public boolean isHisPawn(Pawn p) {
		return (p==pawn1 || p==pawn2);
	}
	
	/**
	 * <b>Observer:</b>
	 * Method to find out if both of the the player has any pawn in start.</br>
	 * <b>PostCondition:</b> Returns if the player has pawn in start not.</br>
	 * @return True if he has a pawn in start, otherwise false.
	 */
	public boolean hasPawnInStart() {
		return (pawn1.isInStart() || pawn2.isInStart());
	}
	
	/**
	 * <b>Observer:</b>
	 * Method to find out if both of the the player has both pawns in start.</br>
	 * <b>PostCondition:</b> Returns if the player has both pawns in start not.</br>
	 * @return True if he has both pawns in start, otherwise false.
	 */
	public boolean hasBothPawnsInStart() {
		return (pawn1.isInStart() && pawn2.isInStart());
	}
	
	@Override
	public String toString() {
		String col;
		if(color == Color.RED) col = "(R)";
		else col = "(Y)";
		return name + " "+ col ;
	}
	

}

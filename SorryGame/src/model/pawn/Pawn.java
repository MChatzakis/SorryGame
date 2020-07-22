package model.pawn;

import java.awt.Color;

/**
 * <b>This class simulates a pawn of the board game.</b></br>
 * Pawns have color and position and they are enabled on not based on their position.</br>
 * Pawns may move with the cards and specific squares.
 * @author Manos Chatzakis
 *
 */
public class Pawn {
		
	private boolean enabled; //Boolean variable to enable or disable the pawn.
	private int position; //The position on the board.
	private int homePosition; //The home position.
	private Color color; //The color of the pawn.
	
	/**
	 * <b>Constructor:</b>
	 * Generates a new pawn.</br>
	 * <b>PostCondition:</b> Creates a new pawn and initializes it's color and starting position.</br>
	 * @param color The color of the pawn.
	 * @param homePosition The position of it's home square.
	 */
	public Pawn(Color color,int homePosition) {
		System.out.println("Pawn generated.");
		this.color = color;
		this.enabled = true;
		this.homePosition = homePosition;
		this.position = -1;
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method sets the position of the pawn.</br>
	 * <b>PostCondition:</b> Sets the position of the pawn.</br>
	 * @param position the position to transfer the pawn.
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method returns the current position of the pawn.</br>
	 * <b>PostCondition:</b> Returns the current position of the pawn.</br>
	 * @return The pawn's current position (int).
	 */
	public int getPosition() {
		return position;
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method returns the home position of the pawn.</br>
	 * <b>PostCondition:</b> Returns the home position of the pawn.</br>
	 * @return The pawn's home position (int).
	 */
	public int getHomePosition() {
		return homePosition;
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method returns the color of the pawn.</br>
	 * <b>PostCondition:</b> Returns the color of the pawn.
	 * @return The paws's color (color).
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method sets the color of the pawn.</br>
	 * <b>PostCondition:</b> Sets the color of the pawn.
	 * @param color The desired color.
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * <b>Observer:</b>
	 * This method provides info about if the pawn is in the starting position or not.</br>
	 * <b>PostCondition:</b> Returns if the pawn is in start.
	 * @return True if the pawn is in start or not.
	 */
	public boolean isInStart() {
		return position == -1;
	}
	
	/**
	 * <b>Observer:</b>
	 * This method provides info about if the pawn is in home or not.</br>
	 * <b>PostCondition:</b> Returns if the pawn is in it's home.
	 * @return True if the pawn is in home,else false.
	 */
	public boolean isInHome() {
		int boardPosition = position%72;
		return (boardPosition == 23 || boardPosition == 59); //or return boardPosition == homePosition
	}
	
	/**
	 * <b>Observer:</b>
	 * Method to provide info about if the pawn is in the safety zone.</br>
	 * <b>PostCondition:</b> Return if the pawn is in safety zone or not.</br>
	 * @return True if the pawn is in safety zone,else false.
	 */
	public boolean isInSafetyZone() {
		int boardPosition = position%72;
		return ((boardPosition>=18 && boardPosition<=22) || (boardPosition>=54 && boardPosition<=58));
	}
	
	/**
	 * <b>Observer:</b>
	 * Method to provide info about if the pawn is in some kind of safety zone such as home,start or safety zone.</br>
	 * <b>PostCondition:</b> Returns if the pawn is protected.
	 * @return True if the pawn is protected,else false.
	 */
	public boolean isProtected() {
		return (isInSafetyZone() || isInHome() || isInStart());
	}
	
	/**
	 * <b>Observer:</b>
	 * Method to provide info about if the pawn is enabled or not.</br>
	 * <b>PostCondition:</b> Returns if the pawn is enabled or not.</br>
	 * @return True if the pawn is enabled,else false.
	 */
	public boolean isEnabled() {
		return enabled;
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method disables the pawn. Use this method only if the pawn is in home.</br>
	 * <b>PreCondition:</b> The pawn have reached the home square.</br>
	 * <b>PostCondition:</b> Disables the pawn.</br>
	 */
	public void disablePawn() {
		this.enabled = false;
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method changes the position of the pawn in the board. Use this method only if the new position is allowed.</br>
	 * <b>PreCondition:</b> The new position is valid by the rules of the game.</br>
	 * <b>PostCondition:</b> Transfers the pawn to a new position.
	 * @param position The new position.
	 */
	public void changePosition(int position) {
		this.position+=position%72;
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method sends the pawn to start.</br>
	 * <b>PostCondition:</b> Transfers the pawn to start.
	 */
	public void sendToStart() {
		position = -1;
	}
	
	@Override
	public String toString() {
		return "Pawn with ending position: "+ this.getHomePosition();
	}
	
}

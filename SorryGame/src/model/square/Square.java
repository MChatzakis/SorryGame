package model.square;

import java.awt.Color;

import model.pawn.Pawn;

/**
 * <b>This class simulates a square of the board.</b>
 * All squares have a specific on the board, can be occupied or not
 * by a pawn and have a standard color.
 * @author Manos Chatzakis
 *
 */
public abstract class Square {
	
	private Pawn pawn; //The pawn on the square.
	private Color color; //The color of the square.
	private boolean occupied; //A boolean flag to see if the square is occupied by a pawn.
	
	/**
	 * <b>Constructor:</b>
	 * Creates a square with a color and a position.</br>
	 * <b>PostCondition:</b> Creates a new square with a specific color.</br>
	 * @param color The color of the square.
	 */
	public Square(Color color) {
		this.color = color;
		this.occupied = false;
	}
	
	/**
	 * <b>Observer:</b>
	 * This method is used to see if the square is occupied.</br>
	 * <b>PostCondition:<\b> Returns if the square is occupied or not.<\br>
	 * @return True if there is a pawn on it, false otherwise.
	 */
	public boolean isOccupied() {
		return occupied;	
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method is used to set occupation state.</br>
	 * <b>PostCondition:</b> Sets occupation state.</br>
	 * @param occupied The occupation state.
	 */
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method is used to set a color for the square.</br>
	 * <b>PostCondition:</b> Sets the color of the square.</br>
	 * @param color The color to set.
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method gets the color of the square.</br>
	 * <b>PostCondition:</b> Returns the color of the square.
	 * @return The color (color).
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method gets the pawn which is on the square. Use this method only when the square has a pawn on it.</br>
	 * <b>PreCondition:</b> The square should have a pawn on it.</br>
	 * <b>PostCondition:</b> Returns the pawn which is on the square. 
	 * @return The pawn
	 */
	public Pawn getPawn(){
		return pawn;
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method sets the pawn of the square.</br>
	 * <b>PostCondition:</b> Sets the pawn on the square. </br>
	 * @param pawn The pawn on the square
	 */
	public void setPawn(Pawn pawn) {
		this.pawn = pawn;
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method is used to set the square to occupied state and declare the pawn on this position.</br>
	 * <b>PostCondition:</b> Sets occupation state and the pawn. </br>
	 * @param pawn The pawn on the square.
	 */
	public void occupy(Pawn pawn) {
		this.occupied = true;
		this.pawn = pawn;
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method clears the square of a pawn.</br>
	 * <b>PostCondition:</b> Makes the square empty.
	 */
	public void disOccupy() {
		this.occupied = false;
		this.pawn = null;
	}
	
	@Override
	public String toString() {
		return "Square kind: ";
		
	}
}

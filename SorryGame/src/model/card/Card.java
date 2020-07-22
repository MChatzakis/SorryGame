package model.card;

import model.board.Board;
import model.pawn.Pawn;

/**
 * <b>This class simulates a card of the board.</b>
 * All the cards have a name, an image, and the ability to move a pawn to another position of the board.
 * @author Manos Chatzakis
 *
 */
public abstract class Card {
	
	private String name; //The name of the card.
	private String image; //The path of the image for the card.
	
	/**
	 * <b>Constructor:</b>
	 * Generates a card.</br>
	 * <b>PostCondition:</b> Creates a new card with imagePath and name.</br>
	 * @param name The name of the card.
	 * @param image The path of the image.
	 */
	public Card(String name,String image) {
		this.name = name;
		this.image = image;
	}

	/**
	 * <b>Transformer:</b>
	 * This method sets the name of the card.</br>
	 * <b>PostCondition:</b> Sets the name of card.</br>
	 * @param name The name of the card.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method returns the name of the card.</br>
	 * <b>PostCondition:</b> Returns the name of the card.</br>
	 * @return The name of the card(String).
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method sets the image path of the card.</br>
	 * <b>PostCondition:</b> Sets the image path of the card.</br>
	 * @param image The path of the image.
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method gets the path of the image of the card.</b>
	 * <b>PostCondition:</b> Returns the path of the image.
	 * @return The path of the image(String).
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method moves the pawn to the indicated position of the board, based on the current card.
	 * PreCondition: The move should be valid according to the rules.</br>
	 * PostCondition: Changes the position of the board.</br>
	 * @param pawn The pawn to be moved.
	 * @param board The current board.
	 */
	abstract public boolean movePawn(Pawn pawn,Board board);
	
	
	abstract public boolean isValidMove(Pawn pawn,Board board);
	
	@Override
	public String toString() {
		return "Card: "+name;
	}
}

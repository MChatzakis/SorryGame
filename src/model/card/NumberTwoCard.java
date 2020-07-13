package model.card;

/**
 * <b>This class simulates the number two card.</b>
 * Number two card allows the player to start from the start square.
 * Also lets the player move clockwise two positions.
 * When a player gets a number two card, he may play again.
 * @author Manos Chatzakis
 *
 */
public class NumberTwoCard extends NumberCard{

	/**
	 * <b>Constructor:</b>
	 * Generates a number two card.</br>
	 * <b>PostCondition:</b> Creates a number two card.</br>
	 * @param image The path of the image.
	 */
	public NumberTwoCard(String image) {
		super(2, "Two", image);
	}

}

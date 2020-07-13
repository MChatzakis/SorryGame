package model.card;

/**
 * <b>This class simulates the number 4 card.</b>
 * Number 4 card moves the player 4 units counterclockwise.
 * With number 4 card players should not start from the starting square.
 * @author Manos Chatzakis
 *
 */
public class NumberFourCard extends NumberCard{

	/**
	 * <b>Constructor:</b>
	 * Generates a number four card.</br>
	 * <b>PostCondition:</b> Creates a number four card with value name and image.</br>
	 * @param image The path of the image.
	 */
	public NumberFourCard(String image) {
		super(-4,"Four", image);
	}

}

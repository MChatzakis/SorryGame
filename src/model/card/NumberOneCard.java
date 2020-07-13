package model.card;

/**
 * <b>This class simulates the number one card of the game.</b>
 * With this card the player can start from start square, or move his pawn clockwise by one position at a time.
 * It has value 1, an image and a name.
 * @author Manos Chatzakis
 *
 */
public class NumberOneCard extends NumberCard{

	/**
	 * <b>Constructor:</b>
	 * Generates a new number one card.</br>
	 * <b>PostCondition:</b> Creates a number one card.</br>
	 * @param image The path of the image for the number one card.
	 */
	public NumberOneCard(String image) {
		super(1, "One", image);
	}

	
}

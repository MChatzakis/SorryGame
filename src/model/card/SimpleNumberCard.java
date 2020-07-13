package model.card;

/**
 * <b>This class simulates a simple number card of the game.</b>
 * Simple number cards move the players pawn value units clockwise.
 * With these cards players should not move from the starting square.
 * @author Manos Chatzakis
 *
 */
public class SimpleNumberCard extends NumberCard{

	/**
	 * <b>Constructor:</b>
	 * Generates a new simple card.</br>
	 * <b>PostCondition:</b> Creates a simple number card with value name and image.</br>
	 * @param value The value of the card.
	 * @param name The name of the card.
	 * @param image The path of the image.
	 */
	public SimpleNumberCard(int value,String name,String image) {
		super(value,name,image);
	}
	
}

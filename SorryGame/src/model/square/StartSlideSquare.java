package model.square;

import java.awt.Color;

/**
 * <b>This class simulates the head of a slide square.<b>
 * Only pawns stepped on the head of the slide may move to the end of the slide.
 * So, only instances of start slide squares can move pawns.
 * @author Manos Chatzakis
 *
 */
public class StartSlideSquare extends SlideSquare{
	
	/**
	 * <b>Constructor:</b>
	 * Generates the start of the slide square.
	 * <b>PostCondition:</b> Creates a starting slide square and initializes it's fields.
	 * @param color The color of the slide square.
	 * @param size The size(4 or 5 units).
	 */
	public StartSlideSquare(Color color, int size) {
		super(color,size);
	}
	
	public String toString() {
		return super.toString() + "StartSlideSquare";
	}
	
	
}

package model.square;

import java.awt.Color;

/**
 * <b>This class simulates the final square of a slide.</b>
 * @author Manos Chatzakis
 *
 */
public class EndSlideSquare extends SlideSquare{

	/**
	 * <b>Constructor:</b>
	 * Generates the final squares of a slide.</br>
	 * <b>PostCondition:</b> Creates a new end slide square with a specific color.
	 * @param color The color of the slide.
	 * @param size The size of the slide.
	 */
	public EndSlideSquare(Color color,int size) {
		super(color,size);
	}

	public String toString() {
		return super.toString() + "EndSlideSquare";
	}
	
}

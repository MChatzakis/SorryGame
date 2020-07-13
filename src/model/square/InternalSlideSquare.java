package model.square;

import java.awt.Color;

/**
 * <b>This class simulates the internal slides of the slide.</b>
 * They do not have a special feature, they just have the same color.
 * @author Manos Chatzakis
 *
 */
public class InternalSlideSquare extends SlideSquare{

	/**
	 * <b>Constructor<\b>
	 * Generates internal squares of the slide.</br>
	 * PostCondition:
	 * @param color The color of the slide.
	 * @param size The size of the slide.
	 */
	public InternalSlideSquare(Color color  ,int size) {
		super(color,size);
	}

	public String toString() {
		return super.toString() + "InternalSlideSquare";
	}

}

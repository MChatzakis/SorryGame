package model.square;

import java.awt.Color;

/**
 * <b>This class simulates a simple square of the board.</b>
 * Simple squares are just simple positions of the board that a pawn can stay.
 * All simple squares have white color (the color will be set when the squares are initialized).
 * @author Manos Chatzakis
 *
 */
public class SimpleSquare extends Square{

	/**
	 * <b>Constructor:</b>
	 * Generates a simple square to a position and a color(color will be white).</br>
	 * <b>PostCondition:</b> Creates a new simple square.
	 * @param color The default (white) color.
	 */
	public SimpleSquare(Color color) {
		super(color);
	}

	public String toString() {
		return super.toString() + "SimpleSquare";
	}
	
}

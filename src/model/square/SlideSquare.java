package model.square;

import java.awt.Color;

/**
 * <b>This class simulates the slide squares that the board has.</b>
 * All slide squares have color but they also have a specific image(This will be added in view package).
 * Slides may differ: They have specidic size.
 * If a pawn steps on the head of a different color's size, it moves to the end of the slide.
 * @author Manos Chatzakis
 *
 */
public abstract class SlideSquare extends Square{

	/**
	 * NOTICE: All instances of the same slide square must have the same color.
	 */
	
	int size; //The size of the slide.
	
	/**
	 * <b>Constructor:</b>
	 * Generates a new slide square. Only specific colors are allowed.</br>
	 * <b>PostCondition:</b> Creates a new slide square with color and size.</br>
	 * @param color The color of the square(red, blue, yellow, green).
	 * @param size The size of the slide.
	 */
	public SlideSquare(Color color,int size) {
		super(color);
		this.size = size;
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method returns the size of the slide square.</br>
	 * <b>PostCondition:</b> Returns the size of the slide square.
	 * @return The size(int).
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method sets the size of the slide square.
	 * <b>PostCondition:</b> Sets the size of the slide square.
	 * @param size The desired size.
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
}

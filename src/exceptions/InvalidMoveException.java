package exceptions;

/**
 * A simple exception to handle invalid moves.
 * @author Manos Chatzakis
 *
 */
public class InvalidMoveException extends RuntimeException{

	public InvalidMoveException() {
		super();
		System.out.println("This move is not valid.");
	}

}

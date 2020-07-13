package exceptions;

/**
 * A simple exception to handle invalid disable of a pawn.
 * @author Manos Chatzakis
 *
 */
public class NotValidDisableException extends RuntimeException{
	
	public NotValidDisableException(String s) {
		super();
		System.out.println("Disable is not allowed yet.");
	}
}

package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <b>This class contain a method to take the current date and time in a desired format.</b></br> 
 * It is made to give specific and unique names to files containing the progress of a game.
 * @author Manos Chatzakis
 *
 */
public class CurrentDate {
	
	/**
	 * This method returns a string containing the current adte and time in the desired format to be used for naming a file.
	 * @return A string providing info about the current date and time.
	 */
	public static String getDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	
}

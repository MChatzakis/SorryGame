package utilities;

import java.util.Random;

/**
 * <b>Random generator</b>
 * @author Manos Chatzakis
 *
 */
public class RandomGenerator {

	/**
     * Finds and returns a random integer number
     *
     * @param min the minimum value of the integer
     * @param max the maximum value of the integer
     * @return the random integer
     */
    public static int getRandom(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;   
    }
	
	public static void main(String[] args) {
		System.out.println(getRandom(0,1));
	}

}

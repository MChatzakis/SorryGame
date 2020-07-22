package utilities;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * <b>This class is designed to provide a readable solution for showing messages using dialogs.</b>
 * @author Manos Chatzakis
 *
 */
public class PopMessage {
	
	/**
	 * This method shows popUp messages.
	 * @param s The text of the message.
	 */
	public static void show(String s) {
		JOptionPane.showMessageDialog(new JFrame(), s, "Dialog",JOptionPane.WARNING_MESSAGE);
	}
}

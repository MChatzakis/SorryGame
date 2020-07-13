package model.card;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.board.Board;
import model.pawn.Pawn;

/**
 * <b>This class simulates a number ten card.</b>
 * With this card player can move 10 positions clockwise or 1 position counterclockwise.
 * Player must select one of the two options, if possible.
 * @author Manos Chatzakis
 *
 */
public class NumberTenCard extends NumberCard{

	/**
	 * <b>Constructor:</b>
	 * Generates a new number 10 card.</br>
	 * <b>PostCondition:</b> Creates a number ten card with value, name and image.</br>
	 * @param image The path of the image.
	 */
	public NumberTenCard(String image) {
		super(10, "Ten", image);
	}

	@Override
	public boolean movePawn(Pawn pawn, Board board) {
		
		this.setValue(Integer.parseInt(JOptionPane.showInputDialog(new JFrame(""),"Move front or back?(10/-1)")));
		
		if(this.getValue() != 10 && this.getValue() != -1) {
			JOptionPane.showInputDialog(new JFrame(""),"Wrong Input, try again.");
			return false;
		}
		
		//Seeting the proper value to the card and the using the classic move pawn.
		return super.movePawn(pawn, board);
	}
}

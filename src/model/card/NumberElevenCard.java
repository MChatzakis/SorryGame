package model.card;

import model.board.Board;
import model.pawn.Pawn;
import model.square.Square;

/**
 * <b>This class simulates a number eleven card.</b>
 * With this card player can move eleven positions clockwise or swap his pawn with an enemy pawn(if possible).
 * The player is not obligated to make a move.
 * @author Manos Chatzakis
 *
 */
public class NumberElevenCard extends NumberCard{

	/**
	 * <b>Constructor:</b>
	 * Generates a number 11 card.</br>
	 * <b>PostCondition:</b> Creates a new number eleven card with value, name and image.</br>
	 * @param image The path of the image/
	 */
	public NumberElevenCard(String image) {
		super(11, "Eleven", image);
	}

	/**
	 * <b>Transformer:</b>
	 * This method swaps the positions of pawn1, pawn2.
	 * <b>PreCondition:</b> The swap is valid, according to the rules.</br>
	 * <b>PostCondition:</b> Swaps the positions of pawn1 and pawn2.
	 * @param pawn1 The pawn of the player.
	 * @param pawn2 The pawn of the enemy player.
	 * @param board The current board.
	 */
	public boolean movePawn(Pawn pawn1, Pawn pawn2, Board board) {
		
		
		/**
		 * NOTE: This edition of move pawn is made for the case of swapping.
		 * The selection between the cases is done inside the controller.
		 */
		
		boolean valid1 = (!pawn1.isProtected());
		boolean valid2 = (!pawn2.isProtected());
		
		if(valid1 && valid2) { //If swap is possible.
	
			//Getting the positions normilized.
			int pos1 = pawn1.getPosition()%72;
			int pos2 = pawn2.getPosition()%72;
			
			//Getting the squares of the pawns.
			Square s1 = board.getSquare(pos1);
			Square s2 = board.getSquare(pos2);
			
			//Occupying the squares with reversed pawns.
			s1.occupy(pawn2);
			s2.occupy(pawn1);
			
			//Moving the pawns to their new positions.
			pawn1.setPosition(pos2);
			pawn2.setPosition(pos1);
						
			return true;
		}
		
		return false;
	}

}

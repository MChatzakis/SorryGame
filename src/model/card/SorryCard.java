package model.card;

import model.board.Board;
import model.pawn.Pawn;
import model.square.Square;

/**
 * <b>This class simulates the "sorry" card of the board game.</b>
 * Sorry cards only have an image, and they move the player's pawn to the position of an enemy pawn,
 * while the enemy pawn returns to his starting square.
 * The above is done only if these moves are possible.
 * @author Manos Chatzakis
 *
 */
public class SorryCard extends Card{

	/**
	 * <b>Constructor:</b>
	 * Generates a new sorry card.</br>
	 * <b>PostCondition:</b> Creates a new sorry card with name and image.</br>
	 * @param name The name of the card, etc sorry.
	 * @param image The path of the image that sorry cards have.
	 */
	public SorryCard(String image) {
		super("Sorry",image);
	}
	
	/**
	 * <b>Observer:</b>
	 * This method checks if the pawn1 can be transfered to the pawn2 position.</br>
	 * <b>PostCondition:</b> Returns is the move is valid or not.
	 * @param pawn1 The pawn of the player.
	 * @param pawn2 The pawn of the enemy player.
	 * @param board The board with the squares.
	 * @return True or false if the move is valid or not.
	 */
	public boolean isValidMove(Pawn pawn1,Pawn pawn2,Board board){
		
		//Check for pawn validation is transfered to the controller.
		
		if(pawn1.isInStart() && (!pawn2.isProtected())) { //According to the rules
			return true;
		}
		return false;
	}
	
	/**
	 * This is move pawn version for sorry cards. Same as move pawn of card.
	 * @param pawn1
	 * @param pawn2
	 * @return True if the move has been made, else false.
	 */
	public boolean movePawn(Pawn pawn1,Pawn pawn2, Board board) {
		if(!isValidMove(pawn1,pawn2,board)) return false;
		Square s = board.getSquare(pawn2.getPosition()%72);
		int tmpPos = pawn2.getPosition();
		pawn2.sendToStart();
		pawn1.setPosition(tmpPos);
		s.occupy(pawn1);
		return true;
	}
	
	
	
	/**Just to be okay with the compiler**/
	
	@Override
	public boolean movePawn(Pawn pawn, Board board) {
		return false;
	}

	@Override
	public boolean isValidMove(Pawn pawn, Board board) {
		return false;
	}
	
}

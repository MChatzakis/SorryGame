package model.card;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.board.Board;
import model.pawn.Pawn;

/**
 * <b>This class simulates the number seven card from the game.<b>
 * With this card player can move both of his pawns.
 * With number seven cards players may not start from the start square or move backwards.
 * @author Manos Chatzakis
 *
 */
public class NumberSevenCard extends NumberCard{

	/**
	 * <b>Constructor:</b>
	 * Generates a new number seven card.</br>
	 * <b>PostCondition:</b> Creates a number seven card with value name and image.</br>
	 * @param image The path of the image for the card.
	 */
	public NumberSevenCard(String image) {
		super(7, "Seven", image);
	}

	/**
	 * <b>Transformer:</b>
	 * This method represents the choice of the player to move both pawns.
	 * <b>PreCondition:</b> Both pawns are the pawns of the player and the sum of position1 and position2 is 7.<br>
	 * <b>PostCondition:</b> The pawn1 and pawn2 are moved to new positions.</br>
	 * @param pawn1 The first pawn.
	 * @param pawn2 The second pawn.
	 * @param board The Board.
	 */
	public boolean movePawn(Pawn pawn1,Pawn pawn2,Board board) {
		
		int position1 = Integer.parseInt(JOptionPane.showInputDialog(new JFrame(""),"Number seven card. Enter positions for your first pawn!."));
		int position2 = Integer.parseInt(JOptionPane.showInputDialog(new JFrame(""),"Number seven card. Enter positions for yout second pawn!."));
		
		if(position1+position2 != 7) {
			//System.out.println("Your desired positions do not sum to seven!");
			return false;
		}
	
		if(!isValidMove(pawn1,board,position1) || !isValidMove(pawn2,board,position2)) { //Both move should be valid to make a move!
			return false; 
		}
		
		this.setValue(position1); //Setting the value.
		if(position1!=0) super.movePawn(pawn1, board);//movePawn(pawn1,position1,board);
		this.setValue(position2); //Resetting the value.
		if(position2!=0) super.movePawn(pawn2, board);//movePawn(pawn2,position2,board);

		return true;
	}
	

	public boolean isValidMove(Pawn pawn, Board board,int position) {
		this.setValue(position); //Setting the value to position.
		return super.isValidMove(pawn, board); //Using the old isValidMove as a move check with a card with number "position".
	}
 
}

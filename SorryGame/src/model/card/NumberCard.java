package model.card;

import java.awt.Color;

import model.board.Board;
import model.pawn.Pawn;
import model.square.HomeSquare;
import model.square.SafetyZoneSquare;
import model.square.Square;

/**
 * <b>This abstract class simulates the cards of the board game that contain a number.</b>
 * These cards, plus to the name and the image have a value.
 * Also, some cards of this kind may move the pawns clockwise or counterclockwise.
 * @author Manos Chatzakis
 *
 */
public abstract class NumberCard extends Card{
	
	private int value; // The value of the card.
	
	/**
	 * <b>Constructor:</b>
	 * Generates a new number card.</br>
	 * <b>PostCondition:</b> Creates a number card with name value an image path.</br>
	 * @param value The card's value.
	 * @param name The name of the card.
	 * @param image The path of the image for the card.
	 */
	public NumberCard(int value,String name,String image) {
		super(name, image);
		this.value = value;
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method sets the value of the card.</br>
	 * <b>PostCondition:</b> Sets the value of the card and set moves to 1(clockwise movement).
	 * @param value The desired value.
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method gets the value of this card.</br>
	 * <b>PostCondition:</b> Returns the value of the card.
	 * @return The value of the card (int).
	 */
	public int getValue() {
		return value;
	}
	
	@Override
	public boolean isValidMove(Pawn pawn, Board board) {
		
		int pos = pawn.getPosition()%72; //Getting the position normalized, to avoid getting out of bounds. 
		
		if(value == 0) return true; //This is added for the case of number seven card with a pawn unavailable.
		
		if(pawn.isInHome())	return false; //If the pawn is in home its disabled and no moves allowed.
		
		if(pawn.isInStart()) { //If the pawn is in start:
			
			if(value!=1 && value!=2 || this instanceof NumberSevenCard) return false; //Only with no 1 and 2 cards it may begin.
			
			if(pawn.getColor() == Color.RED) {
				if(board.isOccupied(pos+26)) { //If the next position is occupied:
				//	System.out.println("Is occupied next position!");
					Pawn comparePawn = board.getOccupationPawn(pos+26); //Getting the pawn of the previous position to compare it with the current pawn.
					if(comparePawn.getColor() == pawn.getColor()) {
						//System.out.println("Is the same color");
						return false; //If the other pawn is the same color as the current one move is not allowed.
					}
				}
			}
			
			if(pawn.getColor() == Color.YELLOW) {
				if(board.isOccupied(pos+62)) { //Same as the previous algorithm but for the yellow side.
				//	System.out.println("Is occupied next position!");
					Pawn comparePawn = board.getOccupationPawn(pos+62);
					if(comparePawn.getColor() == pawn.getColor()) {
				//		System.out.println("Is the same color");
						return false;
					}
				}
			}
			
			return true;
		}
		
		/*
		 * There is a (small perc) case that the new position is negative.
		 * So a normalization is needed.
		 */
		int cmp = pos + value;
	    //System.out.println(cmp);
		if(cmp<0) {
			pos = 72 + cmp; //normalized position.
		}
	    //System.out.println(pos);
		
		if((pos < pawn.getHomePosition()) && (pos+value>pawn.getHomePosition())) { //Checking if the pawn passes its home position after the move.
			//System.out.println("By making this move, you will surpass start!");
			return false;
		}
		
		if(board.isOccupied(pos+value)) { //Checking if the next position to move the pawn contains another pawn.
		//	System.out.println("Not valid!"+ pos+value);
			Pawn comparePawn = board.getOccupationPawn(pos+value); 
			if(comparePawn.getColor() == pawn.getColor()) { //If the other pawn is the same color, move is invalid.
				//	System.out.println("Is the same color");
					return false;
			}
		}
		
		//If all the cases are okay, then the move is valid:
		return true;
	}
		
	@Override
	public boolean movePawn(Pawn pawn, Board board) {
		
		if(!isValidMove(pawn,board)) return false; //Checking if the move is valid, and if it is, proceed.
		
		Square s; //The currents pawn square and the next position of the pawn square(double use).
		
		if(!pawn.isInStart()) { //If the pawn in in a normal or safety zone position:
			s = board.getSquare(pawn.getPosition());
			s.disOccupy(); //Disoccupy the current square.
		}
		
		if(pawn.isInStart()) { //If the pawn is in start making sure the new positions will follow the rules of the game.
			if(pawn.getColor() == Color.RED) pawn.setPosition(25);
			else pawn.setPosition(61);
		}
		else { //Else the pawn's position is increment based on the card kind.
			int newPos = followTheRules(pawn,board,this.value);
			//Normalize the new value if needed.
			int tmp = pawn.getPosition() + newPos;
			if(tmp<0) {
				newPos = 72+tmp;
			}
			pawn.changePosition(newPos); //Increment the position.
		}
		
		if(pawn.isInHome()) pawn.disablePawn(); //If the pawn in in home after the move, disable is needed.
		else { //If its not, then we occupy the new square with the current pawn.
			s = board.getSquare(pawn.getPosition());
			if(s.isOccupied()) { //If another pawn is in there, that means that its an enemy pawn, so its sent to its start.
				Pawn enemyPawn = s.getPawn();
				enemyPawn.sendToStart();
			}
			s.occupy(pawn); //Occupy the square.
		}
		return true; //Move complete.
	}

	/**
	 * <b>Transformer:</b>
	 * This method adjusts how a pawn should move if a safety zone occurs,
	 * based on the game's rules.</br>
	 * <b>PostCondition:</b> Returns the position the pawn should move.
	 * @param pawn The pawn to move.
	 * @param board The board with the squares.
	 * @param value The value of the card.
	 * @return The new position as an int.
	 */
	int followTheRules(Pawn pawn, Board board,int value) {
		int newPos = value; 
		if(newPos>=0) { //If the value is >=0, the pawn can enter its safety zone.
			for(int i = 1; i<=value; i++) { //If a safety zone occurs during the move:
				if(board.getSquare(pawn.getPosition() +i) instanceof SafetyZoneSquare){
					if((board.getSquare(pawn.getPosition() + newPos).getColor() != pawn.getColor())) { //If its the pawn's safety zone its okay, but if its the enemy zone then
						return newPos+6; //the move is incremented by six units, in order to continue the game normally.
					}
				}
			}
		}
		
		else { //But if the value is < 0 that means that the pawn will move backwards, so under no circumstances it can enter a safety zone.
			if(!(board.getSquare(pawn.getPosition()) instanceof SafetyZoneSquare)){ 
				//System.out.println("blablabla");
				if((board.getSquare(pawn.getPosition() + newPos) instanceof SafetyZoneSquare) || (board.getSquare(pawn.getPosition() + newPos) instanceof HomeSquare)) {
					//System.out.println("cccc");
					return newPos-6;
				}
			}
		}
		return newPos;
	}
}

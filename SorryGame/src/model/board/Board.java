package model.board;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import model.card.Card;
import model.card.NumberElevenCard;
import model.card.NumberFourCard;
import model.card.NumberOneCard;
import model.card.NumberSevenCard;
import model.card.NumberTenCard;
import model.card.NumberTwoCard;
import model.card.SimpleNumberCard;
import model.card.SorryCard;
import model.pawn.Pawn;
import model.player.Player;
import model.square.EndSlideSquare;
import model.square.HomeSquare;
import model.square.InternalSlideSquare;
import model.square.SafetyZoneSquare;
import model.square.SimpleSquare;
import model.square.SlideSquare;
import model.square.Square;
import model.square.StartSlideSquare;

/**
 * <b>This class simulates the board(deck) of the game.</b></br>
 * Board has all the cards, the pawns, the players, and the squares.
 * @author Manos Chatzakis
 *
 */
public class Board {

	private ArrayList<Card>cards; //The cards.
	private ArrayList<Card>playedCards; //The cards that have been played.
	
	private Square [] squares; //The possible pawn position on the board.

	private Card lastCardOpened; //The last card opened.
	
	/**
	 * <b>Constructor:</b>
	 * Generates the board.</br>
	 * <b>PostCondition:</b> Creates an instance of a board.
	 */
	public Board() {
		System.out.println("Board generated.");
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method initializes the board.</br>
	 * <b>PostCondition:</b> Initializes the board.
	 */
	public void initialize() {
		cards = new ArrayList<Card>();
		squares = new Square[72];
		playedCards = new ArrayList<Card>();
		initializeCards();
		initializeSquares();
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method initializes the squares of the board.</br>
	 * <b>PostCondition:</b> Initializes the squares.
	 */
	public void initializeSquares() {
		for(int i=0; i<72; i++) {
			if(i==0 || (i>=5)&&(i<=8) || (i>=14&&i<=15) ||
					(i>=26 && i<=29) || (i>=35 && i<=36) ||
						(i>=41 && i<=44) || (i>=50 && i<=51) ||
							(i>=62 && i<=65) || (i==71)) {
				squares[i] = new SimpleSquare(Color.WHITE);
			}
			
			if(i == 16 || i==17 || i==24 || i==25 || (i>=30&&i<=34) ) {
				if(i==16) squares[i] = new StartSlideSquare(Color.RED, 4);
				else if(i==30) squares[i] = new StartSlideSquare(Color.RED, 5);
				else if(i==17) squares[i] = new InternalSlideSquare(Color.RED,4);
				else if(i==25) squares[i] = new EndSlideSquare(Color.RED, 4);
				else if(i==34) squares[i] = new EndSlideSquare(Color.RED, 5);
				else if(i==24) squares[i] = new InternalSlideSquare(Color.RED,4);
				else if(i>=31&&i<=33) squares[i] = new InternalSlideSquare(Color.RED,5);
			}
			
			if((i>=37&&i<=40)||(i>=45 && i<=49)){
				if(i==37) squares[i] = new StartSlideSquare(Color.BLUE, 4);
				else if (i==45) squares[i] = new StartSlideSquare(Color.BLUE, 5);
				else if(i==38 || i==39) squares[i] = new InternalSlideSquare(Color.BLUE, 4);
				else if(i>=46 && i<=48) squares[i] = new InternalSlideSquare(Color.BLUE, 5);
				else if(i == 40) squares[i] = new EndSlideSquare(Color.BLUE, 4);
				else if(i==49) squares[i] = new EndSlideSquare(Color.RED, 5);
			}
			
			if(i == 52 || i==53 || i==60 || i==61 || (i>=66 && i<=70)) {
				if(i == 52) squares[i] = new StartSlideSquare(Color.YELLOW, 4);
				else if(i==66) squares[i] = new StartSlideSquare(Color.YELLOW, 5);
				else if(i==70) squares[i] = new EndSlideSquare(Color.YELLOW, 5);
				else if (i==61)	squares[i] = new EndSlideSquare(Color.YELLOW, 4);
				else if(i==53 || i==60) squares[i] = new InternalSlideSquare(Color.YELLOW, 4);
				else if (i>=67 && i<=69) squares[i] = new InternalSlideSquare(Color.YELLOW, 5);
			}
			
			if((i>=1 && i<=4) || (i>=9 && i<=13)){
				if(i==1) squares[i] = new StartSlideSquare(Color.GREEN, 4);
				else if(i==9) squares[i] = new StartSlideSquare(Color.GREEN, 5);
				else if(i==4) squares[i] = new EndSlideSquare(Color.GREEN, 4);
				else if(i==13) squares[i] = new EndSlideSquare(Color.GREEN, 5);
				else if(i==2 || i==3) squares[i] = new InternalSlideSquare(Color.GREEN, 4);
				else if(i>=10 || i<=12) squares[i] = new InternalSlideSquare(Color.GREEN, 5);
			}
			
			if(i>=18 && i<=23) {
				squares[i] = new SafetyZoneSquare(Color.RED, null);
				if(i==23) {
					squares[i] = new HomeSquare(Color.RED,null);
				}
			}
			
			if(i>=54 && i<=59) {
				squares[i] = new SafetyZoneSquare(Color.YELLOW, null);
				if(i==59) {
					squares[i] = new HomeSquare(Color.YELLOW,null);
				}
			}
			
		}
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method initializes the cards of the board.</b>
	 * <b>PostCondition:</b> Initializes the cards.
	 */
	public void initializeCards() {
		for(int i=0; i<4; i++) 
			cards.add(new NumberOneCard("/images/cards/card1.png")); 
		for(int i=0; i<4; i++) 	
			cards.add(new NumberTwoCard("/images/cards/card2.png")); 
		for(int i=0; i<4; i++) 
			cards.add(new SimpleNumberCard(3,"Three","/images/cards/card3.png")); 
		for(int i=0; i<4; i++) 
			cards.add(new NumberFourCard("/images/cards/card4.png")); 
		for(int i=0; i<4; i++) 	
			cards.add(new SimpleNumberCard(5,"Five","/images/cards/card5.png")); 
		for(int i=0; i<4; i++) 	
			cards.add(new NumberSevenCard("/images/cards/card7.png")); 
		for(int i=0; i<4; i++) 	
			cards.add(new SimpleNumberCard(8,"Eight","/images/cards/card8.png"));
		for(int i=0; i<4; i++) 	
			cards.add(new NumberTenCard("/images/cards/card10.png"));
		for(int i=0; i<4; i++) 	
			cards.add(new NumberElevenCard("/images/cards/card11.png"));
		for(int i=0; i<4; i++) 	
			cards.add(new SimpleNumberCard(12,"Twelve","/images/cards/card12.png")); 
		for(int i=0; i<4; i++) 	
			cards.add(new SorryCard("/images/cards/cardSorry.png")); 	 
		suffleCards();
		
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method draws a card for the player.</br>
	 * <b>PostCondition:</b> Gives a card to the player.
	 * @param player The player who takes a card.
	 */
	public Card takeCard(Player player) {
		Card card = cards.get(0);
		player.setTurn(false);
		removeCard();
		if(!areCardsLeft()) {
			reInitializeCards();
			suffleCards();
		}
	//	System.out.println(card);
		return card;
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method returns how many cards are left.</br>
	 * <b>PostCondition:</b> Returns how many cards are left.
	 * @return The number of the cards left(int).
	 */
	public int cardsLeft() {
		return cards.size();
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method applies the slide rule of the game.
	 * <b>PostCondition: </b> If its valid, the pawn is moved to slide end.
	 * @param pos The square position.
	 */
	public void slideEffect(int pos) {
		if(pos==-1) return;
		pos = pos%72;
		if(squares[pos] instanceof StartSlideSquare) {
			if(squares[pos].isOccupied()) {
				Pawn pawn = squares[pos].getPawn();
				
				if(pawn.getColor() == squares[pos].getColor()) {
					//System.out.println("Not the same color");
					return;
				}
				
				squares[pos].disOccupy();
				
				int size = ((SlideSquare) squares[pos]).getSize();
				
				for(int i=1; i<size; i++) {
					
					if(squares[pos+i] instanceof SafetyZoneSquare) {
						i+=6;
						size+=6;
					}
					
					if(squares[pos+i].isOccupied()) {
						Pawn pawnToRemove = squares[pos+i].getPawn();
						pawnToRemove.sendToStart();
					}
				}
				
				pawn.setPosition(pos+size-1);
				squares[pos+size-1].occupy(pawn);
			}
		}
	}
	
	/**
	 * <b>Observer:</b>
	 * This method checks if there are any cards remaining in the stack.</br>
	 * <b>PostCondition:</b> Returns if there are cards left in the stack.
	 * @return True if there are cards left, false otherwise.
	 */
	public boolean areCardsLeft() {
		return cards.size()!=0;
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method shuffles the cards of of the deck.</br>
	 * <b>PostConidition:</b> Shuffles the cards.
	 */
	public void suffleCards() {
		Collections.shuffle(cards);
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method transfers all the cards back to the cards array list and shuffles them.</br>
	 * <b>PreCondition:</b> All the cards have been played.
	 * <b>PostCondition:</b> Transfers all the cards back to the card list.
	 */
	public void reInitializeCards(){
		
		System.out.println(playedCards.size());
		System.out.println(cards.size());
		
	//	int size = playedCards.size()-1;
		for(int i=0; i<playedCards.size(); i++) {
			cards.add(playedCards.get(i));
			System.out.println(cards.get(i));
		//	playedCards.remove(i);
		}
		
		playedCards = new ArrayList<>();//ArrayList<Card>playedCard
		
		suffleCards();
	}
	
	/**
	 * <b>Transformer:</b>
	 * Sets the last opened card to the card the player has selected.</br>
	 * <b>PostCondition:</b> Sets the last card opened.
	 * @param c The card to be set as last card opened.
	 */
	public void setLastCardOpened(Card c) {
		lastCardOpened = c;
	}
	
	/**
	 * <b>Accessor:</b>
	 * Get's the last card opened.</br>
	 * <b>PostCondition:</b> Returns the last card opened.
	 * @return The card opened last.
	 */
	public Card getLastCardOpened() {
		return lastCardOpened;
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method deletes a component of the first list and puts it in the second.</br>
	 * <b>PostConditions:</b> Removes a card from the card list and puts in in the second list. 
	 */
	public void removeCard() {		
		playedCards.add(cards.get(0));
		cards.remove(0);
	}
	
	/**
	 * <b>Observer:</b>
	 * This method checks if both pawns of the player are in home position.</br>
	 * <b>PostCondition:</b> Returns if the player has won.
	 * @param player The player we want to check if has won.
	 * @return True if the player has won, false otherwise.
	 */
	public boolean hasPlayerWon(Player player) {
		return player.hasWon();
	}
	
	/**
	 * <b>Observer:</b>
	 * This method is used when a player wants to go fold.</br>
	 * It checks whether or not fold is a valid move.</br>
	 * <b>PostCondition:</b> Returns if the fold request is valid.
	 * @param player The player who wants to fold.
	 * @return True if the fold is acceptable, false else.
	 */
	/*	
	 * 
	 * THIS HAS BEEN TRANSFERED TO CONTROLLER!
	 * 
	 * public boolean isValidFold(Pawn pawn,Card card) {
	 */
		/*int pos = pawn.getPosition();
		
		if(card instanceof NumberTenCard) {
			if(pos > 0) {
				Square s = getSquare(pos-1);
			}
		}
		return true;	
	}
	 */
	
	
	/**
	 * <b>Transformer:</b> 
	 * This method checks who player last and decides the turn of the next round.</br>
	 * <b>PostCondition:</b> Decides the turn.
	 * @param player1 The player 1 of the game.
	 * @param player2 The player 2 of the game.
	 */
	public Player decideTurn(Player player1,Player player2) {
		if(player1.hasPlayed()) {
			player2.setTurn(true);
			player1.setTurn(false);
			return player1;
		}
		else {
			player1.setTurn(true);
			player2.setTurn(false);
			return player2;
		}
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method returns the cards of the board.</br>
	 * <b>PostCondition:</b> Returns the card list. 
	 * @return An arrayList with the cards of the board.
	 */
	public ArrayList<Card> getCards(){
		return cards;
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method returns the squares of the board.</br>
	 * <b>PostCondition:</b> Returns the squares of the board.
	 * @return An arrayList with the squares of the board.
	 */
	public Square [] getSquares(){
		return squares;
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method returns the played cards of the board.</br>
	 * <b>PostCondition:</b> Returns the played cards of the board.
	 * @return An arrayList with the cards of the board.
	 */
	public ArrayList<Card> getPlayedcards(){
		return playedCards;
	}
	
	/**
	 * <b>Accessor</b>
	 * This method prints the cards of the game.</br>
	 * <b>PostCondition:</b>Prints the cards</br>
	 */
	public void printCards() {
		for(int i = 0; i<cards.size(); i++) {
			System.out.println(cards.get(i));
		}
		System.out.println("Total cards :"+cards.size());
	}

	/**
	 * Prints the squares.
	 */
	public void printSquares() {
		for(int i=0; i<squares.length; i++) {
			System.out.println((i)+" "+squares[i]);
		}
		
	}
	
	/**
	 * <b>Observer:</b>
	 * This method provides info about if a square of the board is occupied.
	 * (Made to increase the readability of the code).</br>
	 * <b>PostCondition:</b> Returns if a position of the board is occupied by a pawn or not.
	 * @param pos The position of the square to see if its occupied.
	 * @return True if the square is occupied, otherwise false.
	 */
	public boolean isOccupied(int pos) {
		
		if(pos<0) {
			pos = 72-pos; //new
		}
		
		if(squares[pos%72].isOccupied()) {
			return true;
		}
		return false;
	}
	
	/**
	 * <b>Accessor:</b>
	 * Returns the pawn of a square.</br>
	 * <b>PostCondition:</b> Returns the pawn of the square.
	 * @param pos The position of the square.
	 * @return The pawn on the square.
	 */
	public Pawn getOccupationPawn(int pos) {
		
		if(pos<0) {
			pos = 72-pos; //new
		}
		
		return squares[pos%72].getPawn();
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method returns the square with positions pos.
	 * @param pos
	 * @return
	 */
	public Square getSquare(int pos) {
		
		if(pos<0) {
			pos = 72-pos;
		}
		
		return squares[pos%72];
	}
	
	/**
	 * Main here made for testing reasons.
	 * 
	 */
	public static void main(String [] args) {
		Board b = new Board();
		b.initialize();
		b.printCards();
		b.printSquares();
	}

	
}

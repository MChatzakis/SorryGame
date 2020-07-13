package test;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import model.board.Board;
import model.card.Card;
import model.card.NumberOneCard;
import model.card.NumberTwoCard;
import model.card.SimpleNumberCard;
import model.pawn.Pawn;

/**
 * This class contains some basic tests for the pawn movement.</br>
 * There was no need to use exceptions, as wrong moves are part of the game.</br>
 * Run this to check that the methods are working properly.
 * @author Manos Chatzakis
 *
 */
class BasicPlayTesting {
	
	Board board;
	Pawn pawn;
	Pawn friendlyPawn;
	Pawn enemyPawn;
	
	/**
	 * <b>Constructor:</b> 
	 * Initializes the basic fields.
	 */
	public BasicPlayTesting() {
		board = new Board();
		board.initialize();
		pawn = new Pawn(Color.RED, 23);
		friendlyPawn = new Pawn(Color.RED,23);
		enemyPawn = new Pawn(Color.YELLOW,50);
	}
	
	@Test
	void startPawnFromStartWithInvalidCard() {
		Card card = new SimpleNumberCard(3, "Three", null);
		assertEquals(false,card.movePawn(pawn, board));
	}
	
	@Test
	void startPawnFromStartWithValidCard() {
		Card card = new NumberTwoCard(null);
		assertEquals(true,card.movePawn(pawn, board));
		assertEquals(false,card.movePawn(friendlyPawn, board));
	} 
	
	@Test
	void friendlyPawnCollision(){
		Card card = new NumberTwoCard(null);
		Card card1 = new NumberOneCard(null);
		assertEquals(true,card.movePawn(pawn, board));
		assertEquals(true,card1.movePawn(pawn, board));
		assertEquals(true,card.movePawn(friendlyPawn, board));
		assertEquals(false,card1.movePawn(friendlyPawn, board));
	} 
	
	@Test
	void enemyPawnCollision() {
		Card card = new NumberOneCard(null);
		enemyPawn.setPosition(30);
		pawn.setPosition(31);
		assertEquals(true,card.movePawn(pawn, board)); //32
		assertEquals(true,card.movePawn(enemyPawn, board)); //31
		assertEquals(true,card.movePawn(enemyPawn, board));
		assertEquals(32,enemyPawn.getPosition());
		assertEquals(-1,pawn.getPosition());
		assertEquals(true,pawn.isInStart());
	}
	
	@Test
	void homeReachingCase() {
		Card card = new SimpleNumberCard(5,"Five",null);
		pawn.setPosition(18);
		assertEquals(true,card.movePawn(pawn, board));
		//System.out.println(pawn.getPosition());
		assertEquals(true,pawn.isInHome());
		assertEquals(false,pawn.isEnabled());
	}
}

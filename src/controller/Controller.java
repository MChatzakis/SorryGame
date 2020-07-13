package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import model.board.Board;
import model.card.Card;
import model.card.NumberElevenCard;
import model.card.NumberSevenCard;
import model.card.NumberTenCard;
import model.card.NumberTwoCard;
import model.card.SorryCard;
import model.pawn.Pawn;
import model.player.Player;
import model.square.Square;
import utilities.FileHandler;
import utilities.PopMessage;
import utilities.RandomGenerator;
import view.GameMenu;
import view.View;

/**
 * <b>The controller communicates with both the view and the board and makes the game playable</b>
 * @author Manos Chatzakis
 *
 */
public class Controller {
	
	Board board; //The board.
	View view; //The graphics.
	
	Player [] player; //The players.
	Player currentPlayer; //The player who has the turn. 

	Pawn [] pawn; //The pawns.
	
	Card currentCard; //The current card opened.
	
	boolean roundEnded = true; //A boolean flag, to indicate when a round is finished.
	
	/**
	 * <b>Constructor:</b>
	 * Generates the controller.</br>
	 * <b>PostCondition:</b> Creates the controller.</br>
	 */
	public Controller() {
		System.out.println("Controller generated.");		
	}
	
	/**
	 * <b>Transformer:</b>
	 * Initializes the board.</br>
	 * <b>PostCondition:</b> Initializes the board of the game.
	 */
	public void initializeBoard() {
		board = new Board();
		board.initialize();
	}
	
	/**
	 * <b>Transformer:</b>
	 * Creates the graphics.</br>
	 * <b>PostCondition:</b> Creates the graphics of the game.
	 */
	public void initializeGraphics() {
		view = new View();
		view.createGraphics();
	}
	
	/**
	 * <b>Transformer:</b>
	 * Initializes the players.</br>
	 * <b>PostCondition:</b> Initializes the players of the game.
	 */
	public void initializePlayers() {	
		player = new Player[2];
		player[0] = new Player(JOptionPane.showInputDialog(new JFrame(""),"Name of player 1.","Player1"), Color.RED, pawn[0], pawn[1]);
		player[1] = new Player(JOptionPane.showInputDialog(new JFrame(""),"Name of player 2.","Player2"), Color.YELLOW, pawn[2], pawn[3]);
		//deciding the first turn:
		int randomPlayer = RandomGenerator.getRandom(0, 1);
		player[randomPlayer].setTurn(true);
		currentPlayer = player[randomPlayer];
	}
	
	/**
	 * <b>Transformer:</b>
	 * Initializes the pawns.</br>
	 * <b>PostCondition:</b> Initializes the pawns of the game.
	 */
	public void initializePawns() {
		pawn = new Pawn[4];
		for(int i=0; i<4; i++) {
			if(i==0 || i==1) pawn[i] = new Pawn(Color.RED,23);
			else pawn[i] = new Pawn(Color.YELLOW,59);
		}
	}
	
	/**
	 * <b>Transformer:</b>
	 * Begins a new game, by initializing all the fields.</br>
	 * <b>PostCondition:</b> Starts the new game.
	 */
	public void beginNewGame() {
		initializeBoard();
		initializeGraphics();
		initializePawns();
		initializePlayers();
		/*if(currentPlayer == player[1]) {
			view.updateInfoBox("\nTurn: "+player[1]);
		}
		else {
			view.updateInfoBox("\nTurn: "+player[0]);
		}*/
		view.updateInfoBox("\nTurn: "+currentPlayer);
		createListeners();
		createMenuListeners();
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method is used to continue the a previous game.</br>
	 * <b>PostCondition:</b> Continues a previous game session.
	 */
	public void continueSavedGame() {
		initializeBoard();
		initializeGraphics();
		initializePawns();
		player = new Player[2];
		player[0] = new Player("Player1", Color.RED, pawn[0], pawn[1]);
		player[1] = new Player("Player2", Color.YELLOW, pawn[2], pawn[3]);
		createListeners();
		createMenuListeners();
	}
	
	/**
	 * <b>Transformers:</b>
	 * This method sets listeners to the JButtons of the graphics.</br>
	 * <b>PostCondition:</b> Sets listeners to JButtons.</br>
	 */
	public void createListeners() {
		
		JButton stack = view.getStackOfCards();
		JButton fold = view.getFold();
		
		JButton [] pawns = view.getPawns();
		
		stack.addMouseListener(new ButtonListener());
        fold.addMouseListener(new ButtonListener());
		
        for(int i=0; i<4; i++) {
        	pawns[i].addMouseListener(new ButtonListener());
        }	
	}
	
	/**
	 * <b>Transformers:</b>
	 * This method sets and creates listeners to the items of the menu bar.</br>
	 * <b>PostCondition:</b> Sets and create listeners to the game menu items.</br>
	 */
	public void createMenuListeners() {
		GameMenu tmpMenu = view.getGameMenu();
		JMenuItem newGame = tmpMenu.getNewGame();
		newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	view.dispose();
            	beginNewGame();
            }});
		
		JMenuItem saveGame = tmpMenu.getSaveGame();
		saveGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(roundEnded) {
            		int [] info = new int[5];
            		infoSaver(info);
            		FileHandler.saveInfoToFile(info,player[0].getName(),player[1].getName());
            	}
            	else {
            		PopMessage.show("Play the round and then save!");
            	}
            }});
		
		JMenuItem loadGame = tmpMenu.getContinueGame();
		loadGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	view.dispose();
            	continueSavedGame();
            	loadAndApplyInfo();
            }});
		
		JMenuItem exitGame = tmpMenu.getExitGame();
		exitGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	PopMessage.show("Now the game will close.");
            	System.exit(0);
            }});
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method checks and moves the pawn.</br>
	 * <b>PostCondition:</b> Returns true and moves the pawn if possible, else return false..</br> 
	 * @param pawn The pawn to be moved.
	 * @return True if the move is possible and the pawn is moved, false otherwise.
	 */
	public boolean checkAndMovePawn(Pawn pawn) {
		return currentCard.movePawn(pawn, board);
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method checks and moves multiple pawns.</br>
	 * <b>PostCondition:</b> Returns true and moves the pawns if possible, else return false..</br> 
	 * @param pawn1 The pawn to be moved.
	 * @param pawn2 The other pawn to be moved
	 * @return True if the move is possible and the pawn is moved, false otherwise.
	 */
	public boolean checkAndMovePawns(Pawn pawn1,Pawn pawn2) {
		
		if(currentCard instanceof SorryCard) {
			return ((SorryCard)currentCard).movePawn(pawn1, pawn2, board);			
		}
		
		if(currentCard instanceof NumberElevenCard) {
			return ((NumberElevenCard)currentCard).movePawn(pawn1, pawn2, board);
		}
		
		if(currentCard instanceof NumberSevenCard) {
			return ((NumberSevenCard)currentCard).movePawn(pawn1, pawn2, board);
		}
		
		return false;
	
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method sets the currentCard.</br>
	 * <b>PostCondition:</b> Sets the card opened.
	 * @param c The last card opened.
	 */
	public void setCurrentCard(Player player) {
		currentCard = board.takeCard(player);
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method decides the turn.</br>
	 * <b>PostCondition:</b> Decides the turn.</br>
	 */
	public void decideTurn() {
		currentPlayer = board.decideTurn(player[0], player[1]);
	}
	
	/**
	 * <b>(Observer:)</b>
	 * This method checks if there is a winner.</br>
	 * <b>PostCondition:</b> Checks if there is a winner.</br>
	 * @param player The player intended to win.
	 */
	public void checkWinner() {
		if(currentPlayer.hasWon()) {
			view.showWinningMessage(currentPlayer+" won the game!");
			PopMessage.show("Game will now close.");
			PopMessage.show(currentPlayer+" won the game!");
			System.exit(0);
		}
	}
		
	/**
	 * <b>Accessor:</b>
	 * This method gets the current's game info in order to save them.</br>
	 * <b>PostCondition:</b> The current's game info is saved.
	 * @param info An array to store the positions of the pawns and the turn.
	 */
	public void infoSaver(int [] info) {		
		for(int i=0; i<4; i++) {
			info[i] = pawn[i].getPosition()%72;
		}
		
		if(currentPlayer == player[0]) {
			info[4] = 1; //reversed
		}
		else {
			info[4] = 0; //reversed
		} 
		
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method loads and applies the data of a previously saved game in order to continue playing..</br>
	 * <b>PostCondition:</b> The game is continued from the same section.</br>
	 */
	public void loadAndApplyInfo() {
		
		String [] posNames = new String[7];
		int [] info = new int[5];
		
		FileHandler.retrieveInfoFromFile(posNames);
		
		for(int i = 0; i<4; i++) {
			info[i] = Integer.parseInt(posNames[i]);
		}
		
		for(int i=0; i<4; i++) {
			Square s = board.getSquare(info[i]);
			pawn[i].setPosition(info[i]);
			if(pawn[i].isInHome()) pawn[i].disablePawn();
			if(!pawn[i].isInHome() && pawn[i].isInStart()) s.occupy(pawn[i]);
		}
		
		player[0].setName(posNames[5]);
		player[1].setName(posNames[6]);
		
		player[info[4]].setTurn(true);
		currentPlayer = player[info[4]];
		view.updatePawn(pawn);
	}
	
	/**
	 * <b>This class contains methods to be used when the buttons of the game are clicked.</b>
	 *
	 */
	private class ButtonListener implements MouseListener{
		
		boolean moveMade = false; //A boolean flag to indicate when a pawn is clicked or not.
		
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton curr = (JButton) e.getSource();
			
			if(curr == view.getStackOfCards()) {
				view.refresh();
				if(roundEnded) { //If a move has been made.
					if(!(currentCard instanceof NumberTwoCard)) decideTurn(); //The turn is decided upon a card opening.
            		setCurrentCard(currentPlayer); //setting the opened card.
            		//Updating the graphics:
            		view.clearInfoBox();
            		view.updateInfoBox(currentCard+"\nAvailable Cards: "+ board.cardsLeft()+"\n"); 
            		view.updateInfoBox("Turn: "+currentPlayer);
            		view.updateLastCardOpened(currentCard);
            		roundEnded = false;
				}
				else {
					PopMessage.show("Round is not finished yet.");
				}
			}
			
			if(curr == view.getFold()) {
				foldPressed();
			}
			
			if(curr == view.getPawn(0)) {
				pressedPawn(0);
			}
		
			if(curr == view.getPawn(1)) {
				pressedPawn(1);
			}
			
			if(curr == view.getPawn(2)) {
            	pressedPawn(2);
			}

			if(curr == view.getPawn(3)) {
				pressedPawn(3);
			}
			
		}
		
		/**
		 * <b>Observer:</b>
		 * This method indicates if a fold request from a player is valid or not.</br>
		 * <b>PostCondition:</b> True if the fold is possible, else false.
		 * @return True if fold is valid, false otherwise.
		 */
		public boolean isValidFold() {
			
			if(currentCard instanceof NumberElevenCard) {
				return true;
			}
			
			Pawn pawn1 = currentPlayer.getPawn1();
			Pawn pawn2 = currentPlayer.getPawn2();
			
			//Checking if the fold is valid based on the kind of the card.
			if(currentCard instanceof SorryCard) {
				int enemyCount = 0;
				for(int i=0; i<4; i++) {
					if(pawn[i]!= pawn1 && pawn[i]!= pawn2) {
						if(pawn[i].isProtected()) enemyCount++;
					}
				}		
			//	System.out.println(enemyCount);		
				if(currentPlayer.hasPawnInStart() && enemyCount<2) {
					return false;
				}	
				return true;
			}
			else if(currentCard instanceof NumberSevenCard) {
					for(int i=0; i<=7; i++) { //every possible duet of moves.
						if(((NumberSevenCard) currentCard).isValidMove(pawn1, board, i) && ((NumberSevenCard) currentCard).isValidMove(pawn2, board, 7-i)){ //((NumberSevenCard) currentCard).isValidMove(pawn1, board, i)) && (NumberSevenCard)currentCard).isValidMove(pawn2, board, i))
							return false;
						}
					}	
					return true;
			}
			else if(currentCard instanceof NumberTenCard) {
				((NumberTenCard) currentCard).setValue(10);
				if((currentCard.isValidMove(pawn1, board)|| currentCard.isValidMove(pawn2, board))){
					return false;
				}
				else {
					((NumberTenCard) currentCard).setValue(-1);
					if((currentCard.isValidMove(pawn1, board)|| currentCard.isValidMove(pawn2, board))) {
						return false;
					}
				}
				return true;
			}
			else {
				if(currentCard.isValidMove(pawn1, board)|| currentCard.isValidMove(pawn2, board)) {
					return false;
				}
			}
			return true;
		}
		
		/**
		 * <b>Transformer:</b>
		 * This method is called upon a fold request.
		 * If the fold is true, it changes the turn.</br>
		 * <b>PostCondition:</b> Changes the turn if the fold is valid.
		 */
		public void foldPressed() {
			if(isValidFold()) {
				roundEnded = true;
				view.updateInfoBox("\n"+currentPlayer + " folded. Open card.");
			}
			else {
				PopMessage.show("Invalid Fold");
			}
		}

		/**
		 * <b>Transformer:</b>
		 * This method is called when a pawn is pressed.
		 * It's responsible for changing the pawn's position if possible.</br>
		 * <b>PostCondition:</b> Changes the pawns position.
		 * @param index The index of the pawn to choose from the pawn array.
		 */
		public void pressedPawn(int index) {
			
			Pawn pawn1 = currentPlayer.getPawn1();
			Pawn pawn2 = currentPlayer.getPawn2();
			
			if(!currentPlayer.isHisPawn(pawn[index])) { //Check if the pawn selected is valid.
        		PopMessage.show("This pawn does not belong to you.");
        		return;
        	} 
			
			if(!pawn[index].isEnabled()) { //Check if the pawn selected is valid.
				PopMessage.show("Unavailable pawn.");
			}
			
        	if(!roundEnded || !moveMade) {
        		
        		if(currentCard instanceof SorryCard) {
        			sorryCardAlg(index); //If sorry cards occurs.
        		}
        		
        		else if(currentCard instanceof NumberElevenCard) {
        			elevenCardAlg(index); //If eleven card occurs.
        		}
        		
        		else if(currentCard instanceof NumberSevenCard) {
        			sevenCardAlg(index); //If seven card occurs.
        		}
        		
        		else { //If normal card occurs.
        			if(checkAndMovePawn(pawn[index])) {
        				roundEnded = true;
        				moveMade = true;
        				
        			}
        			else {
        				moveMade = false;
        				PopMessage.show("Invalid Move");
        				//throw new InvalidMoveException();
        			}
        		}
        		if(roundEnded && moveMade) {
        			view.updateInfoBox("\n" +currentPlayer + " played.\nDraw a new card to continue.");
        			/*System.out.println("  ---DEBUG---");
        			System.out.println("Pawn "+ (index+1) + " Position: "+pawn[index].getPosition());
        			System.out.println("Is in safety zone: "+ pawn[index].isInSafetyZone());
        			System.out.println("Is in home: "+ pawn[index].isInHome());
        			System.out.println("Is in start: "+ pawn[index].isInStart());
        			System.out.println("Is enabled: "+ pawn[index].isEnabled());
        			System.out.println("---DEBUG_ENDED---");*/
        		}
        	//	board.slideEffect((pawn[index].getPosition())%72);
        		board.slideEffect((pawn1.getPosition())%72);
    			board.slideEffect((pawn2.getPosition())%72);
        		view.updatePawn(pawn);
        		checkWinner();     		
        	}
        	else{
        		 PopMessage.show("Open a new card.");
        	}
   
   		}
		
		/**
		 * Algorithm to be used when a sorry card occurs.
		 * @param index The index of the pawn.
		 */
		public void sorryCardAlg(int index) {
			
			if(!pawn[index].isInStart()) {
				PopMessage.show("The pawn is not in start.");
			}
		
			String enemyPawn = JOptionPane.showInputDialog(new JFrame("SorryCard Occurred!"),"Select Enemy Pawn(0,1,2,3).");
			int index1 = Integer.parseInt(enemyPawn);
		
			if(currentPlayer.isHisPawn(pawn[index1])|| pawn[index1].isProtected()) {
				PopMessage.show("Move unavailable.");
			}
			else {
				if(checkAndMovePawns(pawn[index],pawn[index1])) {
					roundEnded = true;
					moveMade = true;
				}	
				else {
					moveMade = false;
					PopMessage.show("Invalid Move");
				}
			}
		}
		
		/**
		 * Algorithm to be used when an eleven card occurs.
		 * @param index The index of the pawn.
		 */
		public void elevenCardAlg(int index) {
			
			String option = JOptionPane.showInputDialog(new JFrame("Eleven Card Occurred!"),"Press 1 to move 11 positions front, 2 to swap with enemy.");

			int op = Integer.parseInt(option);
			
			if(op == 1) {
    			if(checkAndMovePawn(pawn[index])) {
    				roundEnded = true;
    				moveMade = true;
    			}
    			else moveMade = false;
			}
			
			else if(op == 2){
				String enemyPawn = JOptionPane.showInputDialog(new JFrame("Eleven Occurred!"),"Select Enemy Pawn(0,1,2,3).");
				int index1 = Integer.parseInt(enemyPawn);
				
				if(currentPlayer.isHisPawn(pawn[index1])) {
					PopMessage.show("Swapping with own pawns is not allowed");
				}
				else {
					if(checkAndMovePawns(pawn[index],pawn[index1])) {
						roundEnded = true;
						moveMade = true;
					}	
					else {
						moveMade = false;
						PopMessage.show("Invalid Move");
					}
				}
			}
		}
		
		/**
		 * Algorithm to be used when a seven card occurs.
		 * @param index The index of the pawn.
		 */
		public void sevenCardAlg(int index) {
		
			Pawn pawn1 = currentPlayer.getPawn1();
			Pawn pawn2 = currentPlayer.getPawn2();
			
			
			if(!currentPlayer.isHisPawn(pawn[index])) {
				PopMessage.show("Wrong pawn");
				return;
			}
			
			if(checkAndMovePawns(pawn1,pawn2)) {
				roundEnded = true;
				moveMade = true;
			}	
			else {
				moveMade = false;
				PopMessage.show("Invalid Move");
			}
			
			
			
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
		}	
	}
	
	public static void main (String [] args) {
		System.out.println("Application started.");
		Controller c = new Controller();
		c.beginNewGame();
 	}
	
}

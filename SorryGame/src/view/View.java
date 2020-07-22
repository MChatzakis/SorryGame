package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import model.card.Card;
import model.pawn.Pawn;
import utilities.PopMessage;


/**
 * <b>This class generates the graphics of the board game.</b></br>
 * This GUI should have the board with the squares, the stack of the cards, the played card,
 * a fold button and an info box to provide info about the game and the turn.</br>
 * Also, this class contains methods to update the graphics.
 * @author Manos Chatzakis
 *
 */
public class View extends JFrame{
	
	private JLabel [] positions; //The possible positions on the board.
	private JLabel [] startingPositions; //The starting positions of the pawns.
	private JLabel [] homePositions;  //The home positions of the home.
	
	private JButton[] Pawn; //The pawns of the players. 
	
	private JButton stackOfCards; //The unopened cards.
	private JButton openedCard; //The card currently opened.
	private JButton fold; //The fold button.
	
	private JPanel mainBoard; //The main board, containing the squares.
	private JPanel backPanel; //The background. This is the base green panel.
	
	private JTextArea infoBox; //The info box to provide info about the game.
	
	private GameMenu gameMenu; //The menu bar.
	
	/**
	 * <b>Constructor:</b>
	 * Generates the graphics of the game.</br>
	 * <b>PostCondition:</b> Creates the main frame.
	 */
	public View() {		
		System.out.println("Graphic UI generated.");
	}
	
	/**
	 * <b>Accessor:</b>
	 * Returns the game menu bar.</br>
	 * <b>PostCondition:</b> The game menu bar is returned.
	 * @return The gameMenu bar.
	 */
	public GameMenu getGameMenu() {
		return gameMenu;
	}

	/**
	 * <b>Transformer:</b>
	 * This method sets the game menu.</br>
	 * <b>PostCondition:</b> The game menu is setted.
	 * @param gameMenu The game menu
	 */
	public void setGameMenu(GameMenu gameMenu) {
		this.gameMenu = gameMenu;
	}

	/**
	 * <b>Transformer:</b>
	 * This method combines all methods that generate every simple part of the graphics
	 * to create the basic graphical UI of the game.</br>
	 * <b>PostCondition:</b> The graphics are created.
	 */
	public void createGraphics() {
		setWindowParameters();
		createMainBoard();
		createBackPanel();
		initializePositions();
		createStartingPositions();
		createHomePositions();
		createFoldButton();
		createLastCardPlayed();
		createStackOfCards();
		createSlides();
		createInfoBox("Game started.");
		createPawns();
		createGameMenu();
		setVisible(true);
		add(backPanel);
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method sets the parameters of the frame.</br>
	 * <b>PostCondition:</b> The main frame is generated.
	 */
	public void setWindowParameters() {
		this.setBounds(100, 100, 1000, 670);
		this.setResizable(false);
		this.setTitle("Sorry!");
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method initializes the game menu and adds it to the main frame.
	 * <b>PostCondition:</b> Adds the menu bar to the frame.
	 */
	public void createGameMenu() {
		gameMenu = new GameMenu();
		this.setJMenuBar(gameMenu);
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method generates the slide squares.</br>
	 * <b>PostCondition:</b> Creates the slides.
	 */
	public void createSlides() {
		
		positions[16].setBackground(Color.RED);positions[16].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/redSlideStart.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		positions[17].setBackground(Color.RED);positions[17].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/redSlideMedium.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		positions[24].setBackground(Color.RED);positions[24].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/redSlideMedium.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		positions[25].setBackground(Color.RED);positions[25].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/redSlideEnd.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		
		positions[52].setBackground(Color.YELLOW);positions[52].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/YellowSlideStart.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		positions[53].setBackground(Color.YELLOW);positions[53].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/YellowSlideMedium.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		positions[60].setBackground(Color.YELLOW);positions[60].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/YellowSlideMedium.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		positions[61].setBackground(Color.YELLOW);positions[61].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/YellowSlideEnd.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		
		for(int i=30; i<35; i++) {
			positions[i].setBackground(Color.RED);
			if(i==30) positions[i].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/redSlideStart.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
			else if(i==34) positions[i].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/redSlideEnd.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
			else positions[i].setIcon(  new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/redSlideMedium.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));;
		}
		for(int i=37; i<41; i++) {
			positions[i].setBackground(Color.BLUE);
			if(i==37)positions[i].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/BlueSlideStart.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
			else if(i == 40)positions[i].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/BlueSlideEnd.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
			else 	positions[i].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/BlueSlideMedium.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		}
		for(int i=45; i<50; i++) {
			positions[i].setBackground(Color.BLUE);
			if(i==45) positions[i].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/BlueSlideStart.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
			else if(i==49) positions[i].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/BlueSlideEnd.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
			else positions[i].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/BlueSlideMedium.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		}
		for(int i=66; i<71; i++) {
			positions[i].setBackground(Color.YELLOW);
			if(i==66) positions[i].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/YellowSlideStart.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
			else if(i==70) positions[i].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/YellowSlideEnd.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
			else positions[i].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/YellowSlideMedium.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		}
		for(int i=1; i<5; i++) {
			positions[i].setBackground(Color.GREEN);
			if(i==1) positions[i].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/GreenSlideStart.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
			else if(i==4) positions[i].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/GreenSlideEnd.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
			else positions[i].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/GreenSlideMedium.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		}
		for(int i=9; i<14; i++) {
			positions[i].setBackground(Color.GREEN);
			if(i==9) positions[i].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/GreenSlideStart.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
			else if(i==13) positions[i].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images//slides/GreenSlideEnd.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
			else positions[i].setIcon( new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/slides/GreenSlideMedium.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		} 
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method creates the starting positions of the pawns.</br>
	 * <b>PostCondition:</b> Creates the start positions.
	 */
	public void createStartingPositions() {
		startingPositions = new JLabel[4];
		
		JLabel [] backGround = new JLabel[2];
		
		for(int i=0; i<2; i++) { 
			backGround[i] = new JLabel("Start",SwingConstants.CENTER);
			backGround[i].setOpaque(true);
			backGround[i].setBackground(Color.WHITE);
			backGround[i].setFont(new Font("Monospaced", Font.PLAIN, 18));
			if(i==0) {
				backGround[i].setBounds(positions[25].getX()-(22), positions[25].getY()+36, 78, 60);
				backGround[i].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
				backGround[i].setForeground(Color.RED);
			}
			if(i==1) {
				backGround[i].setBounds(positions[61].getX()-22, positions[61].getY()-60, 78, 60);
				backGround[i].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
				backGround[i].setForeground(Color.YELLOW);

			}
			mainBoard.add(backGround[i],0);
		}
		
		
		for(int i=0; i<4; i++) {
			startingPositions[i] = new JLabel();
			if(i == 0 || i == 1) {
				if(i == 0) startingPositions[i].setBounds(positions[25].getX()-(22)+3, positions[25].getY()+36 + (30-18), 36, 36);
				else startingPositions[i].setBounds(positions[25].getX()-(22)+3+36, positions[25].getY()+36 + (30-18), 36, 36);
			}
			
			else {
				if(i==2) startingPositions[i].setBounds(positions[61].getX()-22 + 3, positions[61].getY()-60 +30-18, 36, 36);
				else startingPositions[i].setBounds(positions[61].getX()-22 + 3 + 36, positions[61].getY()-60 +30-18, 36, 36);
			}

			startingPositions[i].setBackground(Color.RED);
			mainBoard.add(startingPositions[i],0);
		}
		
	}

	/**
	 * <b>Transformer:</b>
	 * This method creates the home positions of the pawns.</br>
	 * <b>PostCondition:</b> Creates the home positions.
	 */
	public void createHomePositions() {
		
		homePositions = new JLabel[4];
		
		for(int i=0; i<4; i++) {
			homePositions[i] = new JLabel();
			if(i == 0 || i == 1) {
				if(i==0) homePositions[i].setBounds(positions[22].getX(), positions[22].getY()+ 36 + 4, 36, 36);
				else homePositions[i].setBounds(positions[22].getX(), positions[22].getY()+ 2*36 + 4, 36, 36);
			}
			else {
				if(i==2) homePositions[i].setBounds(positions[58].getX(), positions[58].getY()- 36 - 4, 36, 36);
				else homePositions[i].setBounds(positions[58].getX(), positions[58].getY()- 2* 36 - 4, 36, 36);
			}
			homePositions[i].setOpaque(false);
			mainBoard.add(homePositions[i],0);
			homePositions[i].setBackground(Color.BLUE);
		}
		
		
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method creates the background of the game.</br>
	 * <b>PostCondition:</b> Creates the background panel.
	 */
	public void createBackPanel() {
		backPanel = new JPanel(null);
		ImageIcon ii = new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/background.png")).getImage());
		JLabel backgroundPic = new JLabel();
		backgroundPic.setSize(1000, 655);
		backgroundPic.setIcon(ii);
		backPanel.add(mainBoard);
		backPanel.add(backgroundPic);
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method creates the board.</br>
	 * <b>PostCondition:</b> Generates the main board.
	 */
	public void createMainBoard() {
		mainBoard = new JPanel(null);
		mainBoard.setBounds(10, 30, 576, 576);
		JLabel sorry = new JLabel(""); 
		ImageIcon ii = new ImageIcon(new ImageIcon(mainBoard.getClass().getResource("/images/sorryImage.png")).getImage().getScaledInstance(240, 100, 0));
		sorry.setBounds(288-120, 288-50,240,100);
		sorry.setOpaque(true);
		sorry.setIcon(ii);
		mainBoard.add(sorry,0);
		mainBoard.setBackground(Color.CYAN);
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method initializes the pawns of the game.</br>
	 * <b>PostCondition:</b> Initializes the pawns.
	 */
	public void createPawns() {
		
		Pawn = new JButton[4];
		
		for(int i=0; i<4; i++) {
			Pawn[i] = new JButton();
			Pawn[i].setSize(36, 36);
			if(i == 0 || i == 1) {
				Pawn[i].setBackground(Color.RED);
				Pawn[i].setIcon(new ImageIcon(new ImageIcon(mainBoard.getClass().getResource("/images/pawns/redPawn"+(i+1)+".png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
				
			}
			else {
				Pawn[i].setBackground(Color.YELLOW);
				Pawn[i].setIcon(new ImageIcon(new ImageIcon(mainBoard.getClass().getResource("/images/pawns/yellowPawn"+(i-1)+".png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
			}
			startingPositions[i].add(Pawn[i],0);
			
		}
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method creates the button to take a card from the stack.</br>
	 * <b>PostCondition:</b> Creates the stack of cards.
	 */
	public void createStackOfCards() {
		stackOfCards = new JButton("Cards");
		stackOfCards.setBounds(620, 50, 140, 220);
		stackOfCards.setIcon(new ImageIcon(new ImageIcon(backPanel.getClass().getResource("/images/cards/backCard.png")).getImage().getScaledInstance(150, 220, Image.SCALE_SMOOTH)));
		backPanel.add(stackOfCards,0);
		
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method creates the label to place the card that is selected from the stack.</b>
	 * <b>PostCondition:</b> Creates the last played card.
	 */
	public void createLastCardPlayed() {
			openedCard = new JButton("PlayedCards");
			openedCard.setBounds(800, 50, 140, 220);
			openedCard.setOpaque(false);
			openedCard.setContentAreaFilled(false);
			//openedCard.setBorderPainted(false);
			backPanel.add(openedCard,0);
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method creates the squares and adds them to the board.</br>
	 * <b>PostCondition:</b> Generates the board squares.
	 */
	public void initializePositions() {
		
		positions  = new JLabel[72];
		
		for(int i=0; i<16; i++) {
			positions[i] = new JLabel("");
			positions[i].setBackground(Color.WHITE);
			positions[i].setBounds(0, 540-(36*i),36, 36);
			positions[i].setOpaque(true);
			positions[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); //	positions[i].setBounds(0,540 - 36- 36*(i-58),36, 36);
			mainBoard.add(positions[i]);
		}
		
		for(int i=16; i<18; i++) {
			positions[i] = new JLabel("");
			positions[i].setBackground(Color.WHITE);
			positions[i].setBounds(36+36*(i-16), 0,36, 36);
			positions[i].setOpaque(true);
			positions[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); //	positions[i].setBounds(0,540 - 36- 36*(i-58),36, 36);
			mainBoard.add(positions[i]);
		}
		
		for(int i=18; i<24; i++) {
			positions[i] = new JLabel("");
			positions[i].setBackground(Color.RED);
			if(i==23) {
				positions[i] = new JLabel("Home",SwingConstants.CENTER);
				positions[i].setFont(new Font("Monospaced", Font.PLAIN, 18));
				positions[i].setForeground(Color.RED);
				positions[i].setBounds(2*36 - 18,36+36*(i-18),72, 80);
				positions[i].setBackground(Color.WHITE);
				positions[i].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			}
			else {
				positions[i].setBounds(2*36,36+36*(i-18),36, 36);
				positions[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			}
			positions[i].setOpaque(true);
			mainBoard.add(positions[i]);
		}
		
		for(int i=24; i<37; i++) {
			positions[i] = new JLabel("");
			positions[i].setBackground(Color.WHITE);
			positions[i].setBounds(3*36+36*(i-24), 0,36, 36);
			positions[i].setOpaque(true);
			positions[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			mainBoard.add(positions[i]);
		}
		
		for(int i=37; i<52; i++) {
			positions[i] = new JLabel("");
			positions[i].setBackground(Color.WHITE);
			positions[i].setBounds(540,36+36*(i-37),36, 36);
			positions[i].setOpaque(true);
			positions[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			mainBoard.add(positions[i]);
		}
		
		for(int i=52; i<54; i++) {
			positions[i] = new JLabel("");
			positions[i].setBackground(Color.WHITE);
			positions[i].setBounds(540 -36- 36*(i-52),540,36, 36);
			positions[i].setOpaque(true);
			positions[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			mainBoard.add(positions[i]);
		}
		
		for(int i=54; i<60; i++) {
			positions[i] = new JLabel("");
			positions[i].setBackground(Color.YELLOW);
			if (i == 59) {
				positions[i] = new JLabel("Home",SwingConstants.CENTER);
				positions[i].setFont(new Font("Monospaced", Font.PLAIN, 18));
				positions[i].setForeground(Color.YELLOW);
				positions[i].setBounds(576 - (3*36)-36+18, 576 - 2*36 - 36*  (i - 54)-36-8,72, 80);
				positions[i].setBackground(Color.WHITE);
				positions[i].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
			}
			else {
				positions[i].setBounds(576 - (3*36), 576 - 2*36 - 36*  (i - 54),36, 36);
				positions[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			}
			positions[i].setOpaque(true);
			mainBoard.add(positions[i]);
		}
		
		for(int i=60; i<72; i++) {
			positions[i] = new JLabel("");
			positions[i].setBackground(Color.WHITE);
			positions[i].setBounds(540 -3*36- 36*(i-60),540,36, 36);
			positions[i].setOpaque(true);
			positions[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			mainBoard.add(positions[i]);
		}
}
	
	/**
	 * <b>Transformer:</b>
	 * This method creates an info box with a desired starting message.</br>
	 * <b>PostCondition:</b> Creates the info box.
	 * @param message The starting message.
	 */
	public void createInfoBox(String message) {
		infoBox = new JTextArea(message);
		infoBox.setBounds(620,450,320,140);
		infoBox.setEditable(false);
		infoBox.setFont(new Font("Serif", Font.PLAIN, 20));
		backPanel.add(infoBox,0);	
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method creates the fold button.</br>
	 * <b>PostCondition:</b> Creates the fold button.
	 */
	public void createFoldButton() {
		fold = new JButton("Fold");
		fold.setBackground(Color.RED);
		fold.setBounds(620, 310, 320, 60);
		backPanel.add(fold,0);
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method updates the message displayed in the info box.</br>
	 * <b>PostCondition:</b> Updates info box with new message.
	 * @param newMessage The new message to be displayed.
	 */
	public void updateInfoBox(String newMessage) {
		infoBox.append(newMessage);
		refresh();
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method clears the log of the info box.</br>
	 * <b>PostCondition:</b> Clears the info box.
	 */
	public void clearInfoBox() {
		infoBox.setText("");
		refresh();
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method updates the frame moving the pawns to their new positions..</br>
	 * <b>PostCondition:</b> Updates the position of the pawns.
	 * @param pawn The array of the pawns of the game.
	 */
	public void updatePawn(Pawn [] pawn) {
		
		int [] position = new int[4];
		
		for(int i=0; i<4; i++) {
			position[i] = pawn[i].getPosition()%72;
			if(position[i] == -1) {
				startingPositions[i].add(Pawn[i]);
			}
			else if(position[i] == 23 || position[i] == 59) {
				homePositions[i].add(Pawn[i]);
			}
			else {
				positions[position[i]].add(Pawn[i]);
			}
		}		
		refresh();
	}
	
	/**
	 * <b>Transformer:</b>
	 * This method updates the last card played.</br>
	 * <b>PostCondition:</b> Updates the last card opened.
	 * @param c The last card opened.
	 */
	public void updateLastCardOpened(Card c) {
		openedCard.setIcon(new ImageIcon(new ImageIcon(backPanel.getClass().getResource(c.getImage())).getImage().getScaledInstance(150, 230, Image.SCALE_SMOOTH))); 
		refresh();
	}
	
	/**
	 * Shows a winning message.
	 * <b>PostCondition:</b> Displays a dialog with winning message.
	 * @param winningMessage The message to display.
	 */
	public void showWinningMessage(String winningMessage) {
		PopMessage.show("Game Ended.");
	}
	
	/**
	 * This method is used to refresh the frame.
	 * <b>PostCondition:</b> Refreshes the frame.
	 */
	public void refresh() {
		 SwingUtilities.updateComponentTreeUI(this);	
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method returns the stackOfCards button.</br>
	 * <b>PostCondition:</b> Returns the stackOfCards button.
	 * @return The stackOfCards.
	 */
	public JButton getStackOfCards() {
		return stackOfCards;
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method returns the openedCard button.</br>
	 * <b>PostCondition:</b> Returns the openedCard button.
	 * @return The openedCard.
	 */
	public JButton getOpenedCard() {
		return openedCard;
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method returns a pawn button.</br>
	 * <b>PostCondition:</b> Returns a pawn button.
	 * @return The pawn.
	 */
	public JButton getPawn(int index) {
		return Pawn[index];
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method returns the pawns</br>
	 * <b>PostCondition:</b> Returns the pawns.
	 * @return The pawns.
	 */
	public JButton [] getPawns() {
		return Pawn;
	}
	
	/**
	 * <b>Accessor:</b>
	 * This method returns the fold button.</br>
	 * <b>PostCondition:</b> Returns the fold button.
	 * @return The fold.
	 */
	public JButton getFold() {
		return fold;
	}
	
	/*
	 * A simple main for testing reasons.
	 */
	public static void main(String [] args) {
		View v = new View();
		v.createGraphics();
	}
}

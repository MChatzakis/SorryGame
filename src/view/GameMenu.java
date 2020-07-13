package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *<b> This class creates a menu bar to give the player option to save, restart
 * or continue a previous game.</b>
 * @author Manos Chatzakis
 *
 */
public class GameMenu extends JMenuBar{

	private JMenu saveMenu; //The basic save menu.
	private JMenu about; //The about menu
	 
	private JMenuItem newGame; //New game option.
	private JMenuItem saveGame; //Save game option.
	private JMenuItem continueGame; //Continue game option.
	private JMenuItem exitGame; //Exit game option.
	
	/**
	 * <b>Constructor:</b>
	 * Generates the game menu bar.</br>
	 * <b>PostCondition:</b> Creates the menu bar.
	 */
	public GameMenu() {
		
		super();
		
		createItems();
		createSaveMenu();
		createAboutMenu();
		
		this.add(saveMenu);
		this.add(about);
		
	}

	/**
	 * <b>Transformer:</b>
	 * This method initializes the items of the menu.</br>
	 * <b>PostCondition:</b> Initializes the items of the menu bar.
	 */
	public void createItems(){
		newGame = new JMenuItem("New Game");
		saveGame= new JMenuItem("Save Game");
		continueGame = new JMenuItem("Continue Previous Game");
		exitGame = new JMenuItem("Exit Game");
	}
	
	/**
	 * <b>Transformer:</b>
	 * Creates the save menu.</br>
	 * <b>PostCondition:</b> Creates the save menu.
	 */
	public void createSaveMenu() {
		saveMenu = new JMenu("Game");
		saveMenu.add(newGame);
		saveMenu.add(saveGame);
		saveMenu.add(continueGame);
	}
	
	/**
	 * <b>Transformer:</b>
	 * Creates the about menu.</br>
	 * <b>PostCondition:</b> Creates the about menu.
	 */
	public void createAboutMenu() {
		about = new JMenu("About");
		about.add(exitGame);
	}
	
	
	/*
	 * Setters and getters are following.
	 * No further documentation is required.
	 */
		
	public JMenuItem getNewGame() {
		return newGame;
	}

	public void setNewGame(JMenuItem newGame) {
		this.newGame = newGame;
	}

	public JMenuItem getSaveGame() {
		return saveGame;
	}

	public void setSaveGame(JMenuItem saveGame) {
		this.saveGame = saveGame;
	}

	public JMenuItem getContinueGame() {
		return continueGame;
	}

	public void setContinueGame(JMenuItem continueGame) {
		this.continueGame = continueGame;
	}

	public JMenuItem getExitGame() {
		return exitGame;
	}

	public void setExitGame(JMenuItem exitGame) {
		this.exitGame = exitGame;
	}
	
}

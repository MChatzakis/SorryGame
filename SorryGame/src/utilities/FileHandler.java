package utilities;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 * <b>This class is designed to save and retrieve files containing the progress of a game.</b>
 * @author Manos Chatzakis
 *
 */
public class FileHandler {

	/**
	 * A simple GUI to select the file(to continue a game).
	 * @return The path of the file as a string.
	 */
	public static String fileSelectionGUI() {
		
		String filepath="";
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.setDialogTitle("Select a file");
		int userSelection = fileChooser.showSaveDialog(null);
		
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			filepath = file.getAbsolutePath();
			System.out.println("The path of the selected file is: " + filepath);
		}
		
		return filepath; //It returns a string in order to use it easily while creating a file
	}
	
	/**
	 * A simple GUI to select a folder to save the current game progress.
	 * @return The filepath of the folder as a string.
	 */
	public static String folderSelectionGUI() {
		
		String filepath="";
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setDialogTitle("Select a folder");
		
		int userSelection = fileChooser.showSaveDialog(null);
		
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			filepath = file.getAbsolutePath();
			System.out.println("The path of the selected folder is: " + filepath);
		}
		
		return filepath; //It also returns(and prints) the path of the folder selected
	}

	/**
	 * This method saves current's game info in a specific file.
	 * @param info An array with the positions of the pawns and the turn.
	 * @param name1 The name of player 1.
	 * @param name2 The name of player 2.
	 */
	public static void saveInfoToFile(int [] info,String name1,String name2) {
		try {
			
			File file = new File(folderSelectionGUI()+"/"+CurrentDate.getDate()+"SORRYGAME.txt");
			FileWriter fw = new FileWriter(file);    
			
			for(int i=0; i<info.length; i++) {
				fw.write(info[i]+"\n");
			}
		   
			fw.write(name1+"\n");
			fw.write(name2);
			
			fw.close();
		}
		
		catch(Exception e) {
			System.out.println("Could not save the file:!\n"+e); //Exception handling
		}
	}

	/**
	 * This method retrieves the current game progress of game, by selecting the file which the progress is saved in.
	 * @param info An array of strings to save the info, so that the controller handles them properly.
	 */
	public static void retrieveInfoFromFile(String [] info) {
		try {
			
			File file = new File(fileSelectionGUI());

			Scanner in = new Scanner(file);	
			String word = new String();
			
			int i=0;
			
			while(in.hasNext()) {
				word = in.next();
				info[i] =(word);
				i++;
			}
			
			in.close();
			
			}
			catch(Exception e) {
				System.out.println("Could not retrieve info from file:\n"+e); //Just a normal exception handling method
			}	
	}
}

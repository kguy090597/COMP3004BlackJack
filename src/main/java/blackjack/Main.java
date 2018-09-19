package blackjack;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main class that controls if the game is console or file input
 * 
 * @author Kevin Guy
 * Date: September 17th, 2018
 */
public class Main {

	/**
	 * The main method that launches the game based on user entered input
	 * 
	 * @param args The arguments
	 */
	public static void main(String[] args) {
		//Takes in user input
		BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in)); 
		//The file input from the user to be used
		File file;
		//The user input
	    String input = "";
	    
	    while(true) {
	    	//Gets user input
			try {
				System.out.print("C for console or F for file input\n> ");
				input = myReader.readLine();
			} catch (IOException e) {
				System.out.println("input error occurred");
			} 
			
			//If input is a C then it's console input and launches console controller
			if (input.toUpperCase().equals("C")) {
				new ConsoleController().start();
				break;
			}
			//If input is an F then it's file input and launches file controller
			else if (input.toUpperCase().equals("F")) {
				//Gets the file to be used
				try {
					System.out.print("File location\n> ");
					input = myReader.readLine();
					file = new File(input);
					if(file.exists()) {
						new FileController(file).start();
						break;
					}
					else {
						System.out.println("File does not exist\n");
					}
				} catch (IOException e) {
					System.out.println("input error occurred\n");
				} 
			}
    }
	}
}

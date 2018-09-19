package blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Console Controller class that controls the game based on console inputs
 * 
 * @author Kevin Guy
 * Date: September 17th, 2018
 */
public class ConsoleController {

	//The player
	private Player player;
	//The dealer
	private Dealer dealer;
	
	/**
	 * The constructor for the controller class that initializes the dealer and player
	 */
	ConsoleController(){
		dealer = new Dealer();
		player = new Player();
		
	}
	
	/**
	 * The method that starts the game
	 */
	public void start() {
		//The buffered reader that reads the user input
		BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in)); 
		//Dealer shuffles the deck
		dealer.shuffleDeck();
		
		//Gives the player their first two cards
		player.hit(dealer.giveCard());
		player.hit(dealer.giveCard());
		
		//Gives the dealer their first two cards
		dealer.hit(dealer.giveCard());
		dealer.hit(dealer.giveCard());
		
		System.out.println("DEALER HAND: "+ dealer.firstInHand()+ " __ --> "+dealer.getHand().getHand().get(0).getValue());
		System.out.println("PLAYER HAND: "+ player.printHand() +" --> "+player.getHand().sumHand());
		
		//Loops until the game is over
		while (true) {
			
			//If the dealer has a blackjack off the start
			if(dealer.getHand().isBlackJack()) {
				System.out.println("Dealer wins with BlackJack");
				System.out.println("DEALER HAND: "+ dealer.printHand()+" --> "+dealer.getHand().sumHand());
				break;
			}
			//If the player has a blackjack
			else if (player.getHand().isBlackJack()) {
				System.out.println("Player wins with BlackJack");
				break;
			}
			//If the player busts
			else if (player.getHand().isOver()) {
				System.out.println("Player bust. Dealer wins");
				break;
			}
			else {
			    System.out.print("H for hit or S for stay\n> ");
	
			    String input = "";
			    //Grabs user input
				try {
					input = myReader.readLine();
				} catch (IOException e) {
					System.out.println("input error occurred");
					break;
				} 
				//Checks if input is hit or stay
				if (input.toUpperCase().equals("H")) {
					playerAction();
				}
				else if (input.toUpperCase().equals("S")) {
					System.out.println("Player has chosen to Stand");
					dealerAction();
					break;
				}
				else {
					System.out.println("Unrecognized command\n");
				}
			}
		}
	}
	
	/**
	 * What happens on the player action
	 */
	private void playerAction() {
		
		System.out.println("Player has Hit");
		//Player hits
		player.hit(dealer.giveCard());
		
		System.out.println("DEALER HAND: "+ dealer.firstInHand()+ " __ --> "+dealer.getHand().getHand().get(0).getValue());
		System.out.println("PLAYER HAND: "+ player.printHand() +" --> "+player.getHand().sumHand());
	}
	
	/**
	 * What happens on the dealer action
	 */
	private void dealerAction() {
		
		System.out.println("DEALER HAND: "+ dealer.printHand()+" --> "+dealer.getHand().sumHand());
		System.out.println("PLAYER HAND: "+ player.printHand() +" --> "+player.getHand().sumHand());
		
		//Dealer hits while the hand is a soft 17 or if the hand is 16 or less
		while(dealer.getHand().isSoft17() || dealer.getHand().sumHand() <= 16) {
			
			System.out.println("Dealer has Hit");
			dealer.hit(dealer.giveCard());
			
			System.out.println("DEALER HAND: "+ dealer.printHand()+" --> "+dealer.getHand().sumHand());
			System.out.println("PLAYER HAND: "+ player.printHand() +" --> "+player.getHand().sumHand());
		}
		
		//If dealer has a blackjack
		if (dealer.getHand().isBlackJack()) {
			System.out.println("Dealer wins with BlackJack");
		}
		//If dealer busts
		else if (dealer.getHand().isOver()) {
			System.out.println("Dealer bust. Player wins");
		}
		//If player total is greater than dealer total
		else if (player.getHand().sumHand() > dealer.getHand().sumHand()) {
			System.out.println("Player wins with higher sum");
		}
		//If dealer total is less than player total
		else {
			System.out.println("Dealer wins with higher sum");
		}
	}
}

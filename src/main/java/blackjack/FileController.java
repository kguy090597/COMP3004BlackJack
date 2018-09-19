package blackjack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * File Controller class that controls the game based on file inputs
 * 
 * @author Kevin Guy
 * Date: September 17th, 2018
 */
public class FileController {
	
	//The player
	private Player player;
	//The dealer
	private Dealer dealer;
	//The file used for input
	private File file;
	//The cards that were used during the game
	private ArrayList<Card> usedCards;
	
	/**
	 * The constructor that initializes the dealer and player classes and sets the file
	 * 
	 * @param file The file that is used for testing
	 */
	FileController(File file){
		this.dealer = new Dealer();
		this.player = new Player();
		this.file = file;
		this.usedCards = new ArrayList<Card>();
	}
	
	/**
	 * Checks to see if the input card has already been played
	 * 
	 * @param card The card that is being checked
	 * 
	 * @return true if the card has been played, false otherwise
	 */
	private boolean cardAlreadyPlayed(Card card) {
		for(int i = 0; i < usedCards.size(); i++) {
			if (usedCards.get(i).getRank().equals(card.getRank()) && usedCards.get(i).getSuit().equals(card.getSuit())) {
				return true;
			}
			else {
				continue;
			}
		}
		return false;
	}
	
	/**
	 * Returns the card that is created from the input
	 * 
	 * @param input The card suit and rank input from the file
	 * 
	 * @return The valid card or null if the input is not a valid card
	 */
	private Card getValidCard(String input) {
		if(input.length() >= 2) {
			String suit = ""+input.charAt(0);
			String rank = ""+input.substring(1);
			Card card = new Card(suit, rank);
			if(card.getRank() == null || card.getSuit() == null) {
				return null;
			}
			else if (cardAlreadyPlayed(card)) {
				return null;
			}
			else {
				return card;
			}
		}
		else {
			return null;
		}
	}
	
	/**
	 * Calls the player hit method if the card is valid
	 * 
	 * @param card The card that will be hit
	 */
	private void playerHit(Card card) {
		if(card!=null) {
			player.hit(card);
			usedCards.add(card);
		}
		else {
			System.out.println("Invalid card detected");
		}
	}
	
	/**
	 * Calls the dealer hit method if the card is valid
	 * 
	 * @param card The card that will be hit
	 */
	private void dealerHit(Card card) {
		if(card!=null) {
			dealer.hit(card);
			usedCards.add(card);
		}
		else {
			System.out.println("Invalid card detected");
		}
	}
	
	/**
	 * The method that starts the game
	 */
	public void start() {
		
		//T=he input from the file
		String input = "";
		//The list of cards and commands from the file
		String[] commands;
		//The card from the file
		Card card;
		//The current command number from the file
		int commandNumber = 0;
		
		//Reads input from the file
		try{
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			input = bufferedReader.readLine();
			System.out.println(input);
		} catch (IOException e) {
			System.out.println("There was a problem reading the file");
			return;
		}
		//Splits the command by spaces (" ")
		commands = input.split("\\s+");
		
		//Gives the player their first two cards
		card = getValidCard(commands[commandNumber++]);
		playerHit(card);
		card = getValidCard(commands[commandNumber++]);
		playerHit(card);
		
		//Gives the dealer their first two cards
		card = getValidCard(commands[commandNumber++]);
		dealerHit(card);
		card = getValidCard(commands[commandNumber++]);
		dealerHit(card);
		
		//Loops until the game is over
		while (true) {
			
			System.out.println("DEALER HAND: "+ dealer.firstInHand()+ " __ --> "+dealer.getHand().getHand().get(0).getValue());
			System.out.println("PLAYER HAND: "+ player.printHand() +" --> "+player.getHand().sumHand());
			
			//If there are still commands
			if(commandNumber <= commands.length) {
				//Checks to see if dealer got blackjack from start
				if(dealer.getHand().isBlackJack()) {
					System.out.println("Dealer wins with BlackJack");
					System.out.println("DEALER HAND: "+ dealer.printHand()+" --> "+dealer.getHand().sumHand());
					break;
				}
				//Checks to see if player got blackjack
				else if (player.getHand().isBlackJack()) {
					System.out.println("Player wins with BlackJack");
					break;
				}
				//If player has bust
				else if (player.getHand().isOver()) {
					System.out.println("Player bust. Dealer wins");
					break;
				}
				else {
					input = commands[commandNumber++];
					
					if (input.toUpperCase().equals("H")) {
						System.out.println("Player has Hit");
						card = getValidCard(commands[commandNumber++]);
						playerAction(card);
					}
					else if (input.toUpperCase().equals("S")) {
						System.out.println("Player has chosen to Stand");
						dealerAction(commands,commandNumber);
						break;
					}
				}
			}
			//No more commands/cards
			else {
				break;
			}
		}
	}

	
	/**
	 * The dealer's actions
	 * 
	 * @param commands The commands/cards from the file
	 * @param commandNumber The current command/card number
	 */
	private void dealerAction(String[] commands, int commandNumber) {
		Card card;
		System.out.println("DEALER HAND: "+ dealer.printHand()+" --> "+dealer.getHand().sumHand());
		System.out.println("PLAYER HAND: "+ player.printHand() +" --> "+player.getHand().sumHand());
		
		//If the dealer has a soft 17 or hand is 16 or less and there are  commands left
		while((dealer.getHand().isSoft17() || dealer.getHand().sumHand() <= 16) && commandNumber <= commands.length) {
			//The card to be hit
			card = getValidCard(commands[commandNumber++]);
			System.out.println("Dealer has Hit");
			//The dealer hits
			dealerHit(card);
			
			System.out.println("DEALER HAND: "+ dealer.printHand()+" --> "+dealer.getHand().sumHand());
			System.out.println("PLAYER HAND: "+ player.printHand() +" --> "+player.getHand().sumHand());
		}
		//If the dealer has a blackjack
		if (dealer.getHand().isBlackJack()) {
			System.out.println("Dealer wins with BlackJack");
		}
		//If the dealer busts
		else if (dealer.getHand().isOver()) {
			System.out.println("Dealer bust. Player wins");
		}
		//If the player's score is greater than the dealer's score
		else if (player.getHand().sumHand() > dealer.getHand().sumHand()) {
			System.out.println("Player wins with higher sum");
		}
		//If the dealer's score is greater than the player's score
		else {
			System.out.println("Dealer wins with higher sum");
		}
		
	}

	/**
	 * The player's action
	 * 
	 * @param card The card to be hit by the player
	 */
	private void playerAction(Card card) {
		playerHit(card);	
	}
}

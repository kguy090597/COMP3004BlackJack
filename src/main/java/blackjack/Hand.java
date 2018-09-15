package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Hand class that contains the cards in the hand
 * 
 * @author Kevin Guy
 * Date: September 15th, 2018
 */
public class Hand {

	//The list containing the cards in the hand
	private ArrayList<Card> hand;
	
	/**
	 * The constructor class for the Hand class
	 */
	Hand(){
		hand = new ArrayList<Card>();
	}
	
	/**
	 * Adds a card to the hand
	 * 
	 * @param card The card to be added to the hand
	 */
	public void add(Card card) {
		hand.add(card);
	}
	
	/**
	 * Returns the hand as a string with cards separated by spaces (" ")
	 */
	public String toString() {
		String cards = "";
		for (int i = 0; i < hand.size(); i++) {
			cards += hand.get(i).toString() + " ";
		}
		return cards.trim();
	}
}

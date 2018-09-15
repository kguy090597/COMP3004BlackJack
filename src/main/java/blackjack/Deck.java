package blackjack;

import java.util.ArrayList;
import java.util.Random;

/**
 * Deck class that contains a list of cards
 * 
 * @author Kevin Guy
 * Date: September 15th, 2018
 */
public class Deck {

	//The deck containing the cards
	private ArrayList<Card> deck;
	//The acceptable suits for the cards
	private static String[] suits = new String[] {"H","D","S","C"};
	//The acceptable ranks for the cards
	private static String[] ranks = new String[] {"1","2","3","4","5","6","7","8","9","J","Q","K","A"};
	
	/**
	 * The constructor for the Deck class that initializes the deck with 52 cards
	 */
	Deck(){
		deck = new ArrayList<Card>();
		initDeck();
	}
	
	/**
	 * Private method that initializes the deck with 52 cards. 13 from each of the 4 suits
	 */
	private void initDeck() {
		for(int suit = 0; suit < suits.length; suit++) {
			for(int rank = 0; rank < ranks.length; rank++) {
				deck.add(new Card(suits[suit], ranks[rank]));
			}
		}
	}
	
	/**
	 * Shuffle method switches indexes of two random cards 208 times
	 */
	public void shuffle() {
		 Random r = new Random();
		 Card temp;
		 for(int i=0; i<208; i++) {
		    int index1 = r.nextInt(deck.size()-1);
		    int index2 = r.nextInt(deck.size()-1);
		    temp = deck.get(index2);
		    deck.set(index2, deck.get(index1));
		    deck.set(index1, temp);
		 }
	}
	
	/**
	 * Removes the first card in the deck and returns it
	 * 
	 * @return The first card in the deck
	 */
	public Card takeOffTop() {
		if(sizeOfDeck()==0) {
			return null;
		}
		return deck.remove(0);
	}
	
	/**
	 * Returns the current size of the deck
	 * 
	 * @return the current size of the deck
	 */
	public int sizeOfDeck() {
		return deck.size();
	}
	
	/**
	 * Returns the deck as a string with each card separated by a space (" ")
	 */
	public String toString() {
		String cards = "";
		for (int i = 0; i < deck.size(); i++) {
			cards += deck.get(i).toString() + " ";
		}
		return cards.trim();
	}
}

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
	 * Sorts the cards in the hand by value from lowest to highest to help with summation
	 * 
	 * @param hand The hand that is to be sorted
	 */
	private void sort(ArrayList<Card> hand) {
		Comparator<Card> compare = (Card a, Card b) -> {
		    return a.getValue() - (b.getValue());
		};
		Collections.sort(hand, compare);
	}
	
	/**
	 * Returns whether or not the hand has a blackjack
	 * 
	 * @return true if hand == 21 or false otherwise
	 */
	public boolean isBlackJack() {
		return sumHand() == 21;
	}
	
	/**
	 * Returns whether or not the hand is over 21
	 * 
	 * @return true if hand > 21 or false otherwise
	 */
	public boolean isOver() {
		return sumHand() > 21;
	}
	
	/**
	 * Adds up all the cards in the hand and returns the value
	 * 
	 * @return The value of all the cards in the hand
	 */
	public int sumHand() {
		//The temporary hand so the real hand order does not change
		ArrayList<Card> tmpHand = hand;
		//Sorts the temporary hand
		sort(tmpHand);
		//Keeps track of the total sum
		int sum = 0;
		//Boolean indicating if an ace was previously added
		boolean prevAce = false;
		
		//loops through the hand and adds the value to the sum
		for(int i = 0; i < tmpHand.size(); i++) {
			//if the last card in the hand is an ace
			if(tmpHand.get(i).getRank().equals("A") && i == tmpHand.size() - 1) {
				//checks to see if an ace was played previously and a blackjack can be achieved by the ace value being 1
				if (sum + 1 == 21 && prevAce) {
					sum += 1;
				}
				//checks to see if an ace has been played previously and if the sum would be greater than 21 if the ace value was 11
				else if(sum + 11 > 21 && prevAce) {
					//subtracts 10 from the sum so the previous ace is considered a value of 1
					sum -= 10;
					sum += 1;
				}
				//checks to see if the sum would be greater than 21 if the ace value was 11
				else if (sum + 11 > 21) {
					sum += 1;
				}
				else {
					sum += tmpHand.get(i).getValue();
				}
			}
			//if the ace is not the last card in the hand
			else if (tmpHand.get(i).getRank().equals("A")) {
				//checks to see if the sum would be greater than 21 if the ace value was 11
				if (sum + 11 > 21) {
					sum += 1;
				}
				else {
					sum += tmpHand.get(i).getValue();
				}
				prevAce = true;
			}
			else {
				sum += tmpHand.get(i).getValue();
			}
		}
		return sum;
	}
	
	/**
	 * Returns whether or not the hand is a soft 17 (Ace is 11 and other cards sum to 6)
	 * 
	 * @return whether or not the hand is a soft 17
	 */
	public boolean isSoft17() {
		//The temporary hand so the real hand order does not change
		ArrayList<Card> tmpHand = hand;
		//The temporary sum that adds up the cards that aren't Aces
		int tmpSum = 0;
		//Sorts the temporary hand by value (from least to greatest)
		sort(tmpHand);
		//Checks if the sum is 17
		if (sumHand()==17) {
			//Goes through the cards in the hand
			for (int i = 0; i < tmpHand.size(); i++) {
				//Checks to see if the card is an Ace
				if(tmpHand.get(i).getRank().equals("A")) {
					//If the sum of the cards before the Ace are 6 then it is a soft 17
					if(tmpSum==6) {
						return true;
					}
					//Sum of cards that aren't Aces is not 6
					else {
						return false;
					}
				}
				else {
					tmpSum+=tmpHand.get(i).getValue();
				}
			}
		}
		//Sum of hand is not 17
		else {
			return false;
		}
		return false;
	}
	
	/**
	 * Returns the cards in the hand as a list
	 * 
	 * @return the cards in the hand
	 */
	public ArrayList<Card> getHand(){
		return hand;
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

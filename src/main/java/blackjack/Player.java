package blackjack;

/**
 * Hand class that contains the cards in the hand
 * 
 * @author Kevin Guy
 * Date: September 17th, 2018
 */
public class Player {

	//The hand of the player
	private Hand hand;
	
	/**
	 * The constructor of the player class
	 */
	Player(){
		this.hand = new Hand();
	}
	
	/**
	 * Adds a card to the Player's hand
	 * 
	 * @param card The card to be added to the Player's hand
	 */
	public void hit(Card card){
		this.hand.add(card);
	}
	
	/**
	 * Whether or not the Player's hand is a BlackJack
	 * 
	 * @return true if blackjack, false otherwise
	 */
	public boolean hasBlackJack() {
		return hand.isBlackJack();
	}
	
	/**
	 * Whether or not the Player's hand is a Bust
	 * 
	 * @return true if bust, false otherwise
	 */
	public boolean hasBust() {
		return hand.isOver();
	}
	
	/**
	 * Returns the hand as a string for printing
	 * 
	 * @return The hand as a string with cards separated by a space (" ")
	 */
	public String printHand() {
		return hand.toString();
	}
	
	/**
	 * Returns the hand as a whole
	 * 
	 * @return the hand as a whole
	 */
	public Hand getHand() {
		return hand;
	}
}

package blackjack;

/**
 * Dealer class that acts as the Dealer in the game
 * 
 * @author Kevin Guy
 * Date: September 17th, 2018
 */
public class Dealer {

	//The deck that the dealer deals out of
	private Deck deck;
	//The hand of the dealer
	private Hand hand;
	
	/**
	 * The constructor for the dealer class
	 */
	Dealer(){
		deck = new Deck();
		hand = new Hand();
	}
	
	/**
	 * Shuffles the deck
	 */
	public void shuffleDeck() {
		deck.shuffle();
	}
	
	/**
	 * Adds a card to the Dealer's hand
	 * 
	 * @param card The card to be added to the Dealer's hand
	 */
	public void hit(Card card) {
		hand.add(card);
	}
	
	/**
	 * Takes a card from the top of the deck to deal out
	 * 
	 * @return The card that will be dealt
	 */
	public Card giveCard() {
		return deck.takeOffTop();
	}
	
	/**
	 * Whether or not the Dealer's hand is a BlackJack
	 * 
	 * @return true if blackjack, false otherwise
	 */
	public boolean hasBlackJack() {
		return hand.isBlackJack();
	}
	
	/**
	 * Whether or not the Dealer's hand is a Bust
	 * 
	 * @return true if bust, false otherwise
	 */
	public boolean hasBust() {
		return hand.isOver();
	}
	
	/**
	 * Returns the first card in the dealer's hand as a String
	 * 
	 * @return The first card in the dealer's hand
	 */
	public String firstInHand() {
		return hand.getHand().get(0).toString();
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

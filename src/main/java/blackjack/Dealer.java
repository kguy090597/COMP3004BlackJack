package blackjack;

public class Dealer {

	private Deck deck;
	private Hand hand;
	
	Dealer(){
		deck = new Deck();
		hand = new Hand();
	}
	
	public void shuffleDeck() {
		deck.shuffle();
	}
	
	public void hit(Card card) {
		hand.add(card);
	}
	
	public Card giveCard() {
		return deck.takeOffTop();
	}
	
	public boolean hasBlackJack() {
		return hand.isBlackJack();
	}
	
	public boolean hasBust() {
		return hand.isOver();
	}
	
	public String firstInHand() {
		return hand.getHand().get(0).toString();
	}
	
	public String printHand() {
		return hand.toString();
	}
	
	public Hand getHand() {
		return hand;
	}
	
}

package blackjack;

public class Player {

	private Hand hand;
	
	Player(){
		this.hand = new Hand();
	}
	
	public void hit(Card card){
		this.hand.add(card);
	}
	
	public boolean hasBlackJack() {
		return hand.isBlackJack();
	}
	
	public boolean hasBust() {
		return hand.isOver();
	}
	
	public String printHand() {
		return hand.toString();
	}
	
	public Hand getHand() {
		return hand;
	}
}

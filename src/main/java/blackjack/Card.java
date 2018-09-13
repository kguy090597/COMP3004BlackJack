package blackjack;


/**
 * Card class that contains a rank, value, and suit
 * 
 * @author Kevin Guy
 * Date: September 12th, 2018
 */
public class Card {
	//The value of the card to be used in the game
	private int value;
	//The suit of the card
	private int suit;
	//The rank of the card
	private int rank;
	//The acceptable suits for the cards
	private static String[] suits = new String[] {"H","D","S","C"};
	//The acceptable ranks for the cards
	private static String[] ranks = new String[] {"1","2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	
	/**
	 * The constructor for the card
	 * @param suit The suit of the card
	 * @param rank The rank of the card
	 */
	Card(String suit, String rank){
		this.suit = verifySuit(suit);
		this.value = verifyValue(rank);
		this.rank = verifyRank(rank);
	}

	/**
	 * Makes sure that the input for the suit is acceptable
	 * @param suit The suit that will be compared to the acceptable inputs
	 * @return The index of the suit in the suits array or -1 if invalid
	 */
	private int verifySuit(String suit) {
		for(int i = 0; i < suits.length; i++){
			if (suit.toUpperCase().equals(suits[i])){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Gets the value of the card based on the rank of the card
	 * @param rank The rank that will be compared to the acceptable inputs
	 * @return The value of the card or -1 if invalid
	 */
	private int verifyValue(String rank) {
		for(int i = 0; i < ranks.length; i++){
			if (rank.toUpperCase().equals(ranks[i]) && i>=10){
				return 10;
			}
			else if (rank.toUpperCase().equals(ranks[i])){
				return i+1;
			}
		}
		return -1;
	}
	
	/**
	 * Makes sure that the input for the rank is acceptable
	 * @param rank The rank that will be compared to the acceptable inputs
	 * @return The index of the rank in the suits array
	 */
	private int verifyRank(String rank) {
		for(int i = 0; i < ranks.length; i++){
			if (rank.toUpperCase().equals(ranks[i])){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Returns the suit of the card
	 * @return The suit of the card or null if it is an invalid suit
	 */
	public String getSuit() {
		if(suit<0) {
			return "null";
		}
		return suits[suit];
	}
	
	/**
	 * Returns the value of the card
	 * @return The value of the card 
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Returns the rank of the card
	 * @return The rank of the card or null if it is an invalid rank
	 */
	public String getRank() {
		if(rank<0) {
			return "null";
		}
		return ranks[rank];
	}
	
	/**
	 * Returns the class information as a readable String
	 */
	public String toString() {
		return getSuit()+getRank();
	}
	
}

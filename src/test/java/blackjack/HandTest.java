package blackjack;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HandTest {

	@Test
	public void testAdd() {
		Hand hand = new Hand();
		Card card1 = new Card("S","A");
		Card card2 = new Card("S","1");
		Card card3 = new Card("S","2");
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals("SA S1 S2", hand.toString());
	}
	
	@Test
	public void testHand() {
		Hand hand = new Hand();
		Card card1 = new Card("S","A");
		Card card2 = new Card("S","1");
		Card card3 = new Card("S","2");
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(14,hand.sumHand());
		assertEquals(false,hand.isBlackJack());
	}
	
	@Test
	public void testHand21() {
		Hand hand = new Hand();
		Card card1 = new Card("S","A");
		Card card2 = new Card("S","J");
		Card card3 = new Card("S","Q");
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(21,hand.sumHand());
		assertEquals(true,hand.isBlackJack());
	}
	
	@Test
	public void testHandTwoAces() {
		Hand hand = new Hand();
		Card card1 = new Card("S","A");
		Card card2 = new Card("H","A");
		Card card3 = new Card("S","J");
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(12,hand.sumHand());
		assertEquals(false,hand.isBlackJack());
	}
	
	@Test
	public void testHandFourAces() {
		Hand hand = new Hand();
		Card card1 = new Card("S","A");
		Card card2 = new Card("H","A");
		Card card3 = new Card("C","A");
		Card card4 = new Card("D","A");
		Card card5 = new Card("S","9");
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		hand.add(card4);
		hand.add(card5);
		assertEquals(13,hand.sumHand());
		assertEquals(false,hand.isBlackJack());
	}
	
	@Test
	public void testHandFourAces21() {
		Hand hand = new Hand();
		Card card1 = new Card("S","A");
		Card card2 = new Card("H","A");
		Card card3 = new Card("C","A");
		Card card4 = new Card("D","A");
		Card card5 = new Card("S","7");
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		hand.add(card4);
		hand.add(card5);
		assertEquals(21,hand.sumHand());
		assertEquals(true,hand.isBlackJack());
	}
	
	@Test
	public void testSumHandTwoAces21() {
		Hand hand = new Hand();
		Card card1 = new Card("S","A");
		Card card2 = new Card("H","A");
		Card card3 = new Card("S","9");
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(21,hand.sumHand());
		assertEquals(true,hand.isBlackJack());
	}
	
	@Test
	public void testHandOver() {
		Hand hand = new Hand();
		Card card1 = new Card("S","9");
		Card card2 = new Card("H","9");
		Card card3 = new Card("D","9");
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(27,hand.sumHand());
		assertEquals(false,hand.isBlackJack());
		assertEquals(true,hand.isOver());
	}
	
	

}

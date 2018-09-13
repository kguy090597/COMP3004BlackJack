package blackjack;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CardTest {

	@Test
	public void testCreateAceOfSpades() {
		Card card = new Card("S","A");
		assertEquals("S", card.getSuit());
		assertEquals(10, card.getValue());
		assertEquals("A", card.getRank());
	}
	
	@Test
	public void testCreate0OfSpades() {
		Card card = new Card("S","0");
		assertEquals("S", card.getSuit());
		assertEquals(-1, card.getValue());
		assertEquals("null", card.getRank());
	}
	
	@Test
	public void testCreate10OfHearts() {
		Card card = new Card("H","10");
		assertEquals("H", card.getSuit());
		assertEquals(10, card.getValue());
		assertEquals("10", card.getRank());
	}
	
	@Test
	public void testCreate5OfDiamonds() {
		Card card = new Card("D","5");
		assertEquals("D", card.getSuit());
		assertEquals(5, card.getValue());
		assertEquals("5", card.getRank());
	}
	
	@Test
	public void testCreateJackOfClubs() {
		Card card = new Card("C","J");
		assertEquals("C", card.getSuit());
		assertEquals(10, card.getValue());
		assertEquals("J", card.getRank());
	}
	
	@Test
	public void testCreateJackOfKangaroo() {
		Card card = new Card("K","J");
		assertEquals("null", card.getSuit());
		assertEquals(10, card.getValue());
		assertEquals("J", card.getRank());
	}

}

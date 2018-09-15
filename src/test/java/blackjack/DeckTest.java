package blackjack;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DeckTest {

	@Test
	public void testInitialization() {
		Deck deck = new Deck();
	}
	
	@Test
	public void testShuffle() {
		Deck deck = new Deck();
		Deck tmpDeck = new Deck();
		assertEquals(deck.toString(),tmpDeck.toString());
		deck.shuffle();
		tmpDeck.shuffle();
		assertNotEquals(deck.toString(),tmpDeck.toString());
	}
	
	@Test
	public void testTakeOffTop() {
		Deck deck = new Deck();
		assertEquals(52,deck.SizeOfDeck());
		Card card = deck.takeOffTop();
		assertEquals("H1",card.toString());
		assertEquals(51,deck.SizeOfDeck());
	}

}

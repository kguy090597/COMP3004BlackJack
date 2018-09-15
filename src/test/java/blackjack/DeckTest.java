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
		assertNotEquals(deck.toString(),tmpDeck.toString());
	}

}

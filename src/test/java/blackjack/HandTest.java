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
	
}

package blackjack;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileControllerTest {

	@Test
	public void testFile1() {
		System.out.println("EXPECTED DEALER WIN AT START");
		new FileController(new File("./test1.txt")).start();
		System.out.println("\n");
	}
	
	@Test
	public void testFile2() {
		System.out.println("EXPECTED DEALER BUST AND PLAYER WIN");
		new FileController(new File("./test2.txt")).start();
		System.out.println("\n");
	}
	
	@Test
	public void testFile3() {
		System.out.println("EXPECTED PLAYER WIN WITH HIGHER VALUE");
		new FileController(new File("./test3.txt")).start();
		System.out.println("\n");
	}
	
	@Test
	public void testFile4() {
		System.out.println("EXPECTED PLAYER BUST AND DEALER WIN");
		new FileController(new File("./test4.txt")).start();
		System.out.println("\n");
	}
	
	@Test
	public void testFile5() {
		System.out.println("EXPECTED DEALER SOFT 17 HIT AND PLAYER WIN");
		new FileController(new File("./test5.txt")).start();
		System.out.println("\n");
	}
	
	@Test
	public void testFile6() {
		System.out.println("EXPECTED PLAYER WIN AT START");
		new FileController(new File("./test6.txt")).start();
		System.out.println("\n");
	}
	
	@Test
	public void testFile7() {
		System.out.println("EXPECTED PLAYER BLACKJACK");
		new FileController(new File("./test7.txt")).start();
		System.out.println("\n");
	}
	
	@Test
	public void testFile8() {
		System.out.println("EXPECTED DEALER BLACKJACK");
		new FileController(new File("./test8.txt")).start();
		System.out.println("\n");
	}
	
	@Test
	public void testFile9() {
		System.out.println("EXPECTED DEALER WIN WITH HIGHER VALUE");
		new FileController(new File("./test9.txt")).start();
		System.out.println("\n");
	}
	
	@Test
	public void testFile10() {
		System.out.println("INCORRECT CARDS");
		new FileController(new File("./test10.txt")).start();
		System.out.println("\n");
	}
}

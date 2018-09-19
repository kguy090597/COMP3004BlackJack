package blackjack;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileControllerTest {

	@Test
	public void testFile1() {
		new FileController(new File("./test1.txt")).start();
		System.out.println("\n");
	}
	
	@Test
	public void testFile2() {
		new FileController(new File("./test2.txt")).start();
		System.out.println("\n");
	}
	
	@Test
	public void testFile3() {
		new FileController(new File("./test3.txt")).start();
		System.out.println("\n");
	}
	
}

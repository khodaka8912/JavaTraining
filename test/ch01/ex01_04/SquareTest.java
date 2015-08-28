package ch01.ex01_04;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import ch01.ex01_04.Square;

public class SquareTest {

	private BufferedReader reader;

	@Before
	public void setUp() throws Exception {
		PipedInputStream pin = new PipedInputStream();
		reader = new BufferedReader(new InputStreamReader(pin));
		System.setOut(new PrintStream(new PipedOutputStream(pin)));
	}

	@Test
	public void testMain() throws IOException {
		Square.main(null);
		assertEquals(reader.readLine(), "Square");
		for (int i = 1; i <= 10; i++) {
			assertEquals(i * i, Integer.parseInt(reader.readLine()));
		}
	}

}

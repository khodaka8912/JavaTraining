package ch01.ex01_03;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import ch01.ex01_03.Fibonacci;

public class FiconacciTest {

	private BufferedReader reader;

	@Before
	public void setUp() throws Exception {
		PipedInputStream pin = new PipedInputStream();
		reader = new BufferedReader(new InputStreamReader(pin));
		System.setOut(new PrintStream(new PipedOutputStream(pin)));
	}

	@Test
	public void testMain() throws IOException {
		Fibonacci.main(null);
		assertEquals(reader.readLine(), "Fibonacci");
		int lo = Integer.parseInt(reader.readLine());
		assertEquals(1, lo);
		int hi = Integer.parseInt(reader.readLine());
		assertEquals(1, hi);
		int next;
		while (lo + hi > 50) {
			next = Integer.parseInt(reader.readLine());
			assertEquals(lo + hi, next);
			lo = hi;
			hi = next;
		}
	}

}

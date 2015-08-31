package ch01.ex01_06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import ch01.ex01_03.Fibonacci;

public class FibonacciTest {

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
		assertThat(reader.readLine(), is("Fibonacci"));
		int lo = Integer.parseInt(reader.readLine());
		assertThat(lo, is(1));
		int hi = Integer.parseInt(reader.readLine());
		assertThat(hi, is(1));
		int next;
		while (lo + hi > 50) {
			next = Integer.parseInt(reader.readLine());
			assertThat(next, is(lo + hi));
			lo = hi;
			hi = next;
		}
	}

}

package ch01.ex01_09;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class FiconacciTest {

	private BufferedReader reader;

	@Before
	public void setUp() throws Exception {
		PipedInputStream pin = new PipedInputStream();
		reader = new BufferedReader(new InputStreamReader(pin));
		System.setOut(new PrintStream(new PipedOutputStream(pin)));
	}

	@Test
	public void testFibonacci() {
		assertThat(new Fibonacci(), is(notNullValue()));
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
		for (int i = 2; i < Fibonacci.MAX_LENGTH; i++) {
			next = Integer.parseInt(reader.readLine());
			assertThat(next, is(lo + hi));
			lo = hi;
			hi = next;
		}
	}

}

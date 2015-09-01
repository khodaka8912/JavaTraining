package ch01.ex01_10;

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

public class ImprovedFibonacciTest {

	private BufferedReader reader;

	@Before
	public void setUp() throws Exception {
		PipedInputStream pin = new PipedInputStream();
		reader = new BufferedReader(new InputStreamReader(pin));
		System.setOut(new PrintStream(new PipedOutputStream(pin)));
	}

	@Test
	public void testImprovedFibonacci() {
		assertThat(new ImprovedFibonacci(), is(notNullValue()));
	}

	@Test
	public void testMain() throws IOException {
		ImprovedFibonacci.main(null);
		int lo = 1;
		int hi = 1;
		assertThat(reader.readLine(), is("1: " + lo));
		for (int i = 2; i <= ImprovedFibonacci.MAX_INDEX; i++) {
			String mark = hi % 2 == 0 ? " *" : "";
			assertThat(reader.readLine(), is(i + ": " + hi + mark));
			hi = hi + lo;
			lo = hi - lo;
		}
	}

}

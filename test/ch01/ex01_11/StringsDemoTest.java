package ch01.ex01_11;

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

public class StringsDemoTest {

	private BufferedReader reader;

	@Before
	public void setUp() throws Exception {
		PipedInputStream pin = new PipedInputStream();
		reader = new BufferedReader(new InputStreamReader(pin));
		System.setOut(new PrintStream(new PipedOutputStream(pin)));
	}

	@Test
	public void testHelloWorld() {
		assertThat(new StringsDemo(), is(notNullValue()));
	}

	@Test
	public void testMain() throws IOException {
		StringsDemo.main(null);
		String expected = "Name = Hodaka Watanabe (Ricoh Co, Ltd.)";
		assertThat(reader.readLine(), is(expected));
	}
}

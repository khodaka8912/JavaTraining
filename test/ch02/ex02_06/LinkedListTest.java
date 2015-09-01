package ch02.ex02_06;

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

public class LinkedListTest {

	private LinkedList linkedList;

	private BufferedReader reader;

	@Before
	public void setUp() throws Exception {
		PipedInputStream pin = new PipedInputStream();
		reader = new BufferedReader(new InputStreamReader(pin));
		System.setOut(new PrintStream(new PipedOutputStream(pin)));
		linkedList = new LinkedList(new Object());
	}

	@Test
	public void testLinkedList() {
		Object element = "element";
		LinkedList list = new LinkedList(element);
		assertThat(list, is(notNullValue()));
		assertThat(list.getElement(), is(element));
	}

	@Test
	public void testMain() throws IOException {
		LinkedList.main(null);

		for (int i = 0; i < 3; i++) {
			assertThat(reader.readLine(), is(startsWith("ch02.ex02_06.Vehicle")));
		}
	}

	@Test
	public void testSetNext() {
		LinkedList next = new LinkedList(new Object());
		linkedList.setNext(next);
		assertThat(linkedList.getNext(), is(next));
	}

}

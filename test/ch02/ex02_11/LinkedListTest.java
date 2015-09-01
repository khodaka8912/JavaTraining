package ch02.ex02_11;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

	private LinkedList linkedList;

	@Before
	public void setUp() throws Exception {
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
	public void testLinkedList2() {
		Object element = "element";
		LinkedList before = new LinkedList(new Object());
		LinkedList list = new LinkedList(element, before);
		assertThat(list, is(notNullValue()));
		assertThat(list.getElement(), is(element));
		assertThat(before.getNext(), is(list));
	}

	@Test
	public void testSetNext() {
		LinkedList next = new LinkedList(new Object());
		linkedList.setNext(next);
		assertThat(linkedList.getNext(), is(next));
	}

	@Test
	public void testToString() {
		LinkedList list = new LinkedList("value1");
		list.setNext(new LinkedList("value2"));
		String expected = "value1,value2,";
		assertThat(list.toString(), is(expected));
	}

}

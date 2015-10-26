package ch04.ex04_03;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedListImpleTest {

	private LinkedListImpl linkedListImpl;

	@Before
	public void setUp() throws Exception {
		linkedListImpl = new LinkedListImpl(new Object());
	}

	@Test
	public void testLinkedListImpl() {
		Object element = "element";
		LinkedListImpl list = new LinkedListImpl(element);
		assertThat(list, is(notNullValue()));
		assertThat(list.getElement(), is(element));
	}

	@Test
	public void testLinkedListImpl2() {
		Object element = "element";
		LinkedListImpl before = new LinkedListImpl(new Object());
		LinkedList list = new LinkedListImpl(element, before);
		assertThat(list, is(notNullValue()));
		assertThat(list.getElement(), is(element));
		assertThat(before.getNext(), is(list));
	}

	@Test
	public void testSetNext() {
		LinkedList next = new LinkedListImpl(new Object());
		linkedListImpl.setNext(next);
		assertThat(linkedListImpl.getNext(), is(next));
	}

	@Test
	public void testToString() {
		LinkedListImpl list = new LinkedListImpl("value1");
		list.setNext(new LinkedListImpl("value2"));
		String expected = "value1,value2,";
		assertThat(list.toString(), is(expected));
	}

	@Test
	public void testAsLinkedListImpl1() {
		Object[] objs = { new Object(), new Object(), new Object() };
		LinkedList list = LinkedListImpl.asLinkedList(objs[0], objs[1], objs[2]);
		assertThat(list, is(notNullValue()));
		for (int i = 0; i < 3; i++) {
			assertThat(list.getElement(), is(objs[i]));
			list = list.getNext();
		}
		assertThat(list, is(nullValue()));
	}

	@Test
	public void testAsLinkedListImpl2() {
		LinkedListImpl list = LinkedListImpl.asLinkedList(new Object[0]);
		assertThat(list, is(nullValue()));
	}

	@Test(expected = NullPointerException.class)
	public void testAsLinkedListImpl3() {
		LinkedListImpl.asLinkedList((Object[]) null);
	}

	@Test
	public void testLength() {
		assertThat(linkedListImpl.length(), is(1));
		linkedListImpl.setNext(new LinkedListImpl(new Object()));
		assertThat(linkedListImpl.length(), is(2));
	}

}

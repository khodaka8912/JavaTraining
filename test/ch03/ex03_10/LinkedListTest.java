package ch03.ex03_10;

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

	@Test
	public void testAsLinkedList1() {
		Object[] objs = { new Object(), new Object(), new Object() };
		LinkedList list = LinkedList.asLinkedList(objs[0], objs[1], objs[2]);
		assertThat(list, is(notNullValue()));
		for (int i = 0; i < 3; i++) {
			assertThat(list.getElement(), is(objs[i]));
			list = list.getNext();
		}
		assertThat(list, is(nullValue()));
	}

	@Test
	public void testAsLinkedList2() {
		LinkedList list = LinkedList.asLinkedList(new Object[0]);
		assertThat(list, is(nullValue()));
	}

	@Test(expected = NullPointerException.class)
	public void testAsLinkedList3() {
		LinkedList.asLinkedList((Object[]) null);
	}

	@Test
	public void testLength() {
		assertThat(linkedList.length(), is(1));
		linkedList.setNext(new LinkedList(new Object()));
		assertThat(linkedList.length(), is(2));
	}

	@Test
	public void testClone() {
		LinkedList list = new LinkedList(new Object());
		LinkedList second = new LinkedList(new Object(), list);
		LinkedList third = new LinkedList(new Object(), second);
		LinkedList cloneList = list.clone();

		int length = cloneList.length();
		assertThat(length, is(list.length()));

		LinkedList org = list;
		LinkedList copy = cloneList;
		for (int i = 0; i < length - 1; i++) {
			assertThat(copy.getElement(), is(org.getElement()));
			assertThat(copy.getNext(), is(not(org.getNext())));
			org = org.getNext();
			copy = copy.getNext();
		}
		assertThat(copy.getElement(), is(org.getElement()));
		assertThat(copy.getNext(), is(nullValue()));
	}

}

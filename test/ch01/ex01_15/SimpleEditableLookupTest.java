package ch01.ex01_15;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SimpleEditableLookupTest {

	private SimpleEditableLookup target;
	private Object value1;

	@Before
	public void setUp() throws Exception {
		target = new SimpleEditableLookup(3);
		value1 = "value1";
		target.add("name1", value1);
		target.add("name2", new Object());
	}

	@Test
	public void testSimpleEditableLookup() {
		SimpleEditableLookup instance = new SimpleEditableLookup();
		assertThat(instance, is(notNullValue()));
	}

	@Test
	public void testSimpleEditableLookupInt1() {
		SimpleEditableLookup instance = new SimpleEditableLookup(0);
		assertThat(instance, is(notNullValue()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSimpleEditableLookupInt2() {
		new SimpleEditableLookup(-1);
	}

	@Test
	public void testFind1() {
		assertThat(target.find("name1"), is(value1));
	}

	@Test
	public void testFind2() {
		assertThat(target.find("name10"), is(nullValue()));
	}

	@Test
	public void testAdd1() {
		Object value2 = new Object();
		target.add("name3", value2);
		assertThat(target.find("name3"), is(value2));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAdd2() {
		target.add("name2", "value2");
		target.add("name3", "value3");
	}

	@Test
	public void testRemove1() {
		assertThat(target.remove("name1"), is(true));
		assertThat(target.find("name1"), is(nullValue()));
	}

	@Test
	public void testRemove2() {
		assertThat(target.remove("name10"), is(false));
	}

}

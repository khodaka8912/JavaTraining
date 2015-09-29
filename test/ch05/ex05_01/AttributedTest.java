package ch05.ex05_01;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import ch05.ex05_01.Attributed.Attr;

public class AttributedTest {

	@Test
	public void testAttrString() {
		Attr target = new Attr("name");
		assertThat(target.getName(), is("name"));
	}

	@Test
	public void testAttrStringObject() {
		Attr target = new Attr("name", "value");
		assertThat(target.getName(), is("name"));
		assertThat(target.getValue(), is((Object) "value"));
	}

	@Test
	public void testSetValue() {
		Attr target = new Attr("");
		Object obj = new Object();
		target.setValue(obj);
		assertThat(target.getValue(), is(obj));
	}

	@Test
	public void testToString() {
		Attr target = new Attr("name", "value");
		assertThat(target.toString(), is("name='value'"));
	}

}

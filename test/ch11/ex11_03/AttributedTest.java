package ch11.ex11_03;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import ch11.ex11_02.Attr;

public class AttributedTest {

	@Test
	public void testAttrString() {
		Attr<String> target = new Attr<>("name");
		assertThat(target.getName(), is("name"));
	}

	@Test
	public void testAttrStringObject() {
		Attr<String> target = new Attr<>("name", "value");
		assertThat(target.getName(), is("name"));
		assertThat(target.getValue(), is((Object)"value"));
	}

	@Test
	public void testSetValue() {
		Attr<Object> target = new Attr<>("");
		Object obj = new Object();
		target.setValue(obj);
		assertThat(target.getValue(), is(obj));
	}

	@Test
	public void testToString() {
		Attr<String> target = new Attr<>("name", "value");		
		assertThat(target.toString(), is("name='value'"));		
	}

}

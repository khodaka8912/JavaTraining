package ch13.ex13_02;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilityTest {

	@Test
	public void testNumOfContains1() {
		int result = StringUtility.numOfContains("the test of num of ct", 't');
		assertThat(result, is(4));
	}
	
	@Test
	public void testNumOfContains2() {
		int result = StringUtility.numOfContains("the test of num of ct", 'a');
		assertThat(result, is(0));
	}

	@Test
	public void testNumOfContainsString1() {
		int result = StringUtility.numOfContains("the test of num of ct test the test", "test");
		assertThat(result, is(3));
	}
	
	@Test
	public void testNumOfContainsString2() {
		int result = StringUtility.numOfContains("the test of num of ct test the test", "foo");
		assertThat(result, is(0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNumOfContainsString3() {
		StringUtility.numOfContains("the test of num of ct test the test", "");
	}
}

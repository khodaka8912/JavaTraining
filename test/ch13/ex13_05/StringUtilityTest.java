package ch13.ex13_05;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilityTest {

	@Test
	public void testGetCommaSeparated() {
		String test = "abc1234567-def72_1234567890123456789876543210end";
		String result = StringUtility.getCommaSeparated(test);
		String expected = "abc1,234,567-def72_1,234,567,890,123,456,789,876,543,210end";
		assertThat(result, is(expected));
	}

}

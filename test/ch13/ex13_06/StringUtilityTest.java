package ch13.ex13_06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilityTest {

	@Test
	public void testGetCommaSeparated() {
		String test = "abc1234567-def321_1234567890123456789876543210end";
		String result = StringUtility.getSeparatedWith(test, '$', 4);
		String expected = "abc123$4567-def321_1234$5678$9012$3456$7898$7654$3210end";
		assertThat(result, is(expected));
	}

}

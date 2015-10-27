package ch10.ex10_04;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void testReplaceEscSequences() {
		String str = "\\ \"Hello\"\n\t\r\f\'World\'b\b \\";
		String expected = "\\\\ \\\"Hello\\\"\\n\\t\\r\\f\\'World\\'b\\b \\\\";
		assertThat(StringUtils.replaceEscSequences(str), is(expected));
	}

}

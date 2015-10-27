package ch09.ex09_02;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class BitCheckerTest {

	@Test
	public void testBitCount() {
		assertThat(BitChecker.bitCount(0), is(0));
		assertThat(BitChecker.bitCount(-1), is(32));
	}

	@Test
	public void testBitCount2() {
		assertThat(BitChecker.bitCount2(0), is(0));
		assertThat(BitChecker.bitCount2(-1), is(32));
	}

	@Test
	public void testBitCount3() {
		assertThat(BitChecker.bitCount3(0), is(0));
		assertThat(BitChecker.bitCount3(-1), is(32));
	}

}

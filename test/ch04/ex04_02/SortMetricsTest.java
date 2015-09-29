package ch04.ex04_02;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SortMetricsTest {

	SortMetrics target;

	@Before
	public void setUp() throws Exception {
		target = new SortMetrics();
	}

	@Test
	public void testInit() {
		target.compareCnt = target.probeCnt = target.swapCnt = 10;
		target.init();
		assertThat(target.compareCnt, is(0L));
		assertThat(target.probeCnt, is(0L));
		assertThat(target.swapCnt, is(0L));
	}

	@Test
	public void testToString() {
		String str = target.toString();
		assertThat(str, is("0 probes 0 compares 0 swaps"));
	}

	@Test
	public void testClone() {
		SortMetrics clone = target.clone();
		assertThat(clone, is(not(sameInstance(target))));
	}

}

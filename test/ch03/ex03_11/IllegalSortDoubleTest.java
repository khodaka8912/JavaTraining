package ch03.ex03_11;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class IllegalSortDoubleTest {

	@Test
	public void testIllegalSort() {
		double[] testData = { 0.3, 1.3e-2, 7.9, 3.17 };
		double[] sortedData = { 1.3e-2, 0.3, 3.17, 7.9 };
		SortDouble bsort = new IllegalSortDouble();
		SortMetrics metrics = bsort.sort(testData);
		assertThat(metrics.compareCnt, is(0L));
		assertThat(metrics.probeCnt, is(0L));
		assertThat(metrics.swapCnt, is(0L));
		assertThat(Arrays.equals(testData, sortedData), is(true));
	}
}

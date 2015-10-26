package ch03.ex03_11;

import org.junit.Test;

public class IllegalFixedSortDoubleTest {

	@Test(expected = IllegalStateException.class)
	public void testIllegalSort() {
		double[] testData = { 0.3, 1.3e-2, 7.9, 3.17 };
		FixedSortDouble bsort = new IllegalFixedSortDouble();
		SortMetrics metrics = bsort.sort(testData);
	}
}

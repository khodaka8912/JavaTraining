package ch03.ex03_12;

import java.util.Comparator;

/**
 * オブジェクトのソートを測定する
 * 
 * @author hwatanabe
 *
 */
abstract class SortHarness {
	private Object[] values;
	private final SortMetrics curMetrics = new SortMetrics();
	/** オブジェクトの順序を比較するComparator */
	private Comparator<Object> comparator;
	
	public final SortMetrics sort(Object[] data, Comparator<Object> comparator) {
		values = data;
		this.comparator = comparator;		
		curMetrics.init();
		doSort();
		return getMetrics();
	}
	
	public final SortMetrics getMetrics() {
		return curMetrics.clone();
	}
	
	protected final int getDataLength() {
		return values.length;
	}
	
	protected final Object probe(int i) {
		curMetrics.probeCnt++;
		return values[i];
	}
	
	protected final int compare(int i, int j) {
		curMetrics.compareCnt++;
		return comparator.compare(values[i], values[j]);
	}
	
	protected final void swap(int i, int j) {
		curMetrics.swapCnt++ ;
		Object tmp = values [i];
		values [i] = values [j] ;
		values[j] = tmp;
	}
	
	protected abstract void doSort();
}

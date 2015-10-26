package ch03.ex03_11;

/**
 * 不正なMetrics操作を行うSortDouble
 * 
 * @author hwatanabe
 *
 */
class IllegalFixedSortDouble extends FixedSortDouble {

	boolean hasSorted;

	/**
	 * ソート後にsortを呼び出し、Metricsを初期化する不正ソート
	 */
	@Override
	protected void doSort() {
		if (hasSorted) {
			// ソート後の呼び出しは無視
			return;
		}
		simpleSort();
		hasSorted = true;
		sort(null);
	}

	private void simpleSort() {
		for (int i = 0; i < getDataLength(); i++) {
			for (int j = i + 1; j < getDataLength(); j++) {
				if (compare(i, j) > 0) {
					swap(i, j);
				}
			}
		}
	}
}

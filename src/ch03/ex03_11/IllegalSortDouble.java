package ch03.ex03_11;

/**
 * 不正なMetrics操作を行うSortDouble
 * @author hwatanabe
 *
 */
class IllegalSortDouble extends SortDouble {

	/**
	 * カウントをオーバーフローさせる
	 */
	@Override
	protected void doSort() {
		// sort...
		
		for (long i = 0; i < Long.MAX_VALUE; i++) {
			probe(0);
		}
	}
}

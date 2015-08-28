package ch01.ex01_13;

public class ImprovedFibonacci {
	
	static final int MAX_INDEX = 9;
	static final String FORMAT = "%d: %d%s\n";
	
	/**
	 * 偶数要素に'*'を付けて、フィボナッチ数列の
	 *　最初の方の要素を表示する
	 */
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		
		System.out.printf(FORMAT, 0, lo, "");
		for (int i = 1; i < MAX_INDEX; i++) {
			String mark = hi % 2 == 0 ? " *" : "";
			System.out.printf(FORMAT, i + 1, hi, mark);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}

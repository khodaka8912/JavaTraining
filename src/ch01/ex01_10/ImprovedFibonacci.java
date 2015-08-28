package ch01.ex01_10;

public class ImprovedFibonacci {
	
	static final int MAX_INDEX = 9;
	
	/**
	 * 偶数要素に'*'を付けて、フィボナッチ数列の
	 *　最初の方の要素を表示する
	 */
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		EvenOddNumber[] fiboArray = new EvenOddNumber[MAX_INDEX];
		
		fiboArray[0] = new EvenOddNumber(lo);
		for (int i = 1; i < MAX_INDEX; i++) {
			fiboArray[i] = new EvenOddNumber(hi);
			hi = lo + hi;
			lo = hi - lo;
		}
		
		for (int i = 0; i < MAX_INDEX; i++) {
			String mark = fiboArray[i].isEven ? " *" : "";
			System.out.println(i + 1 + ": " + fiboArray[i].value + mark);
		}
	}
	
	private static class EvenOddNumber {
		final int value;
		final boolean isEven;
		
		public EvenOddNumber(int value) {
			this.value = value;
			this.isEven = value % 2 == 0;
		}
	}
}

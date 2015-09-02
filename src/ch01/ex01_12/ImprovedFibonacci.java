package ch01.ex01_12;

/**
 * 改良版フィボナッチ数列の表示
 * @author hwatanabe
 *
 */
public class ImprovedFibonacci {
	
	static final int MAX_INDEX = 9;
	
	/**
	 * 偶数要素に'*'を付けて、フィボナッチ数列の
	 *　最初の方の要素を表示する
	 */
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String[] fiboStrArray = new String[MAX_INDEX];
		
		fiboStrArray[0] = "1: " + lo;
		for (int i = 1; i < MAX_INDEX; i++) {
			String mark = hi % 2 == 0 ? " *" : "";
			fiboStrArray[i] = i + 1 + ": " + hi + mark;
			hi = lo + hi;
			lo = hi - lo;
		}
		
		for (String str : fiboStrArray) {
			System.out.println(str);
		}
	}
}

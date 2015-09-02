package ch01.ex01_09;

/**
 * フィボナッチ数列の表示
 * @author hwatanabe
 *
 */
public class Fibonacci {

	static final int MAX_LENGTH = 9;

	/** MAX_LENGTHまでのフィボナッチ数列を表示する */
	public static void main(String[] args) {
		System.out.println("Fibonacci");
		int lo = 1;
		int hi = 1;
		int[] fiboArray = new int[MAX_LENGTH];
		fiboArray[0] = lo;
		for (int i = 1; i < MAX_LENGTH; i++) {
			fiboArray[i] = hi;
			hi = lo + hi; // 新しいhi
			lo = hi - lo; // 新しいloは、(合計 - 古いlo) すなわち、古いhi
		}
		for (int n : fiboArray) {
			System.out.println(n);
		}
	}
}

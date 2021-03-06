package ch01.ex01_03;

/**
 * フィボナッチ数列の表示
 * @author hwatanabe
 *
 */
public class Fibonacci {
	/** 値が50未満のフィボナッチ数列を表示する */
	public static void main(String[] args) {
		System.out.println("Fibonacci"); // タイトル
		int lo = 1;
		int hi = 1;
		System.out.println(lo);
		while (hi < 50) {
			System.out.println(hi);
			hi = lo + hi; // 新しいhi
			lo = hi - lo; /* 新しいloは、(合計 - 古いlo)
							  すなわち、古いhi */
		}
	}
}

package ch10.ex10_04;

/**
 * 平方数列の表示
 * 
 * @author hwatanabe
 *
 */
public class Square {
	/** 1から10までの平方数を表示する */
	public static void main(String[] args) {
		System.out.println("Square");
		int i = 1;
		while (i <= 10) {
			System.out.println(i * i);
			i++;
		}
	}
}

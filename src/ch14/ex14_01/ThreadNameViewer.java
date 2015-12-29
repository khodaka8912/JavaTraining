package ch14.ex14_01;

/**
 * mainの実行スレッドの名前を表示する
 * @author hodaka
 *
 */
public class ThreadNameViewer {
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
	}

}

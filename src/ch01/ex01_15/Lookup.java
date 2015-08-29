package ch01.ex01_15;

public interface Lookup {
	/** nameと関連付けされた値を返す
	 * そのような値がなければ、nullを返す  */
	Object find(String name);
}

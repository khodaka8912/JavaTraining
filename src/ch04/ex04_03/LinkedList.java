package ch04.ex04_03;

/**
 * Objectを保持するリンクリスト
 * @author hwatanabe
 *
 */
interface LinkedList {
	/**
	 * 次のLinkedListを取得する
	 * 
	 * @return
	 */
	LinkedList getNext();
	
	/**
	 * 次のLinkedListを設定する
	 * @return
	 */
	void setNext(LinkedList next);
	
	/**
	 * LinkedListが保持する要素を取得する
	 * @return
	 */
	Object getElement();
	
	/**
	 * LinkedListの長さを取得する
	 * 
	 * @return
	 */
	int length();

}

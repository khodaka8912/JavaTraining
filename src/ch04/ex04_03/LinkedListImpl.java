package ch04.ex04_03;

import java.util.Objects;

/**
 * リンクリスト
 * @author hwatanabe
 *
 */
public class LinkedListImpl implements LinkedList {

	private final Object element;
	/** 次の要素への参照 */
	private LinkedList next;

	public LinkedListImpl(Object element) {
		this.element = element;
	}

	/**
	 * 前の要素に連結したLinkedListを生成
	 * 
	 * @param element
	 *            格納するオブジェクト
	 * @param before
	 *            前の要素
	 */
	public LinkedListImpl(Object element, LinkedListImpl before) {
		this(element);
		if (before != null) {
			before.setNext(this);
		}
	}

	public Object getElement() {
		return element;
	}

	public LinkedList getNext() {
		return next;
	}

	public void setNext(LinkedList next) {
		this.next = next;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		LinkedList list = this;
		while (list != null) {
			sb.append(list.getElement()).append(",");
			list = list.getNext();
		}
		return sb.toString();
	}

	/**
	 * Objectの可変長引数（配列）をLinkedListに変換する
	 * 
	 * @param objects
	 *            変換するオブジェクト列
	 * @return 変換されたLinkedList
	 */
	public static LinkedListImpl asLinkedList(Object... objects) {
		Objects.requireNonNull(objects);
		LinkedListImpl list = null;
		LinkedListImpl before = null;
		for (Object obj : objects) {
			before = new LinkedListImpl(obj, before);
			if (list == null) {
				list = before;
			}
		}
		return list;
	}

	/**
	 * list内に内包された要素の数を返す
	 * 
	 * @return 要素の数
	 */
	public int length() {
		int i = 0;
		LinkedList list = this;
		while (list != null) {
			i++;
			list = list.getNext();
		}
		return i;
	}
}

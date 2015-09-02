package ch02.ex02_08;

public class LinkedList {

	private final Object element;
	/** 次の要素への参照 */
	private LinkedList next;

	public LinkedList(Object element) {
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
	public LinkedList(Object element, LinkedList before) {
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
}

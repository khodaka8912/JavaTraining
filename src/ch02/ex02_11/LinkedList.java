package ch02.ex02_11;

public class LinkedList {

	private final Object element;
	/** 次の要素への参照 */
	private LinkedList next;

	public LinkedList(Object element) {
		this.element = element;
	}

	/**
	 * LinkedListを生成し、前の要素に連結する
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
}

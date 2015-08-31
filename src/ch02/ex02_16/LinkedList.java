package ch02.ex02_16;

public class LinkedList {
	
	private final Object element;
	/** 次の要素への参照 */
	private LinkedList next;
	
	public LinkedList(Object element) {
		this.element = element;
	}
	
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
		while(list != null) {
			sb.append(list.getElement());
			list = list.getNext();
		}
		return sb.toString();
	}
	
	/**
	 * list内に内包された要素の数を返す
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

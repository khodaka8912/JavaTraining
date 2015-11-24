package ch12.ex12_01;

import java.util.Objects;

/**
 * リンクリスト
 * 
 * @author hwatanabe
 *
 */
public class LinkedList<E> implements Cloneable {

	private E element;
	/** 次の要素への参照 */
	private LinkedList<E> next;

	public LinkedList(E element) {
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
	public LinkedList(E element, LinkedList<E> before) {
		this(element);
		if (before != null) {
			before.setNext(this);
		}
	}

	public E getElement() {
		return element;
	}

	public LinkedList<E> getNext() {
		return next;
	}

	public void setNext(LinkedList<E> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		LinkedList<E> list = this;
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
	public static <E> LinkedList<E> asLinkedList(E... objects) {
		Objects.requireNonNull(objects);
		LinkedList<E> list = null;
		LinkedList<E> before = null;
		for (E obj : objects) {
			before = new LinkedList<>(obj, before);
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
		LinkedList<E> list = this;
		while (list != null) {
			i++;
			list = list.getNext();
		}
		return i;
	}

	@Override
	public LinkedList<E> clone() {
		LinkedList<E> list = null;
		try {
			list = (LinkedList<E>) super.clone();
			list.next = list.next.clone();
		} catch (CloneNotSupportedException e) {
		}
		return list;
	}
	
	public LinkedList<E> find(E target) throws ObjectNotFoundException {
		for (LinkedList<E> list = this; list != null; list = list.next) {
			if (Objects.equals(target, list.element)) {
				return list;
			}
		}
		throw new ObjectNotFoundException(target.toString());
	}
}

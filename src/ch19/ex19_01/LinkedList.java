package ch19.ex19_01;

import java.util.Objects;

/**
 * 単方向のリンクリスト。
 * 
 * @author hwatanabe
 *
 */
public class LinkedList {

	/** この要素の値 */
	private final Object element;
	/** 次の要素への参照 */
	private LinkedList next;

	/**
	 * 
	 * @param element
	 *            この要素に格納する値
	 */
	public LinkedList(Object element) {
		this.element = element;
	}

	/**
	 * 指定した要素の次に連結したLinkedListを生成
	 * 
	 * @param element
	 *            格納する値
	 * @param before
	 *            前の要素
	 */
	public LinkedList(Object element, LinkedList before) {
		this(element);
		if (before != null) {
			before.setNext(this);
		}
	}

	/**
	 * 要素の値を取得する。
	 * 
	 * @return この要素に格納された値
	 */
	public Object getElement() {
		return element;
	}

	/**
	 * この要素に連結された次の要素を取得する。
	 * 
	 * @return 次の要素。次がない場合はnull。
	 */
	public LinkedList getNext() {
		return next;
	}

	/**
	 * 指定した値をこの要素の次に連結する。
	 * すでに連結している場合は上書きする。
	 * @param next 連結する要素
	 */
	public void setNext(LinkedList next) {
		this.next = next;
	}

	/**
	 * リストの要素の各値ををカンマ区切りでつなげて文字列にする。
	 */
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
	public static LinkedList asLinkedList(Object... objects) {
		Objects.requireNonNull(objects);
		LinkedList list = null;
		LinkedList before = null;
		for (Object obj : objects) {
			before = new LinkedList(obj, before);
			if (list == null) {
				list = before;
			}
		}
		return list;
	}

	/**
	 * list内に内包された要素の数を返す。
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

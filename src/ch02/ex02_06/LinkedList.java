package ch02.ex02_06;

/**
 * リンクリスト
 * @author hwatanabe
 *
 */
public class LinkedList {

	/** Vehicleを格納したリストを作成 */
	public static void main(String[] args) {
		Vehicle vehicle1 = new Vehicle();
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setOwner("owner1");
		vehicle2.setSpeed(100);
		vehicle2.setDirection(1.0);
		Vehicle vehicle3 = new Vehicle();
		vehicle3.setOwner("owner2");
		vehicle3.setSpeed(50);
		vehicle3.setDirection(5.0);

		LinkedList list1 = new LinkedList(vehicle1);
		LinkedList list2 = new LinkedList(vehicle2);
		LinkedList list3 = new LinkedList(vehicle3);
		list1.setNext(list2);
		list2.setNext(list3);

		LinkedList list = list1;
		while (list != null) {
			System.out.println(list.getElement());
			list = list.getNext();
		}
	}

	private final Object element;
	/** 次の要素への参照 */
	private LinkedList next;

	public LinkedList(Object element) {
		this.element = element;
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

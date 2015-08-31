package ch02.ex02_06;

import ch02.ex02_05.Vehicle;

public class LinkedList {
	
	public static void main(String[] args) {
		Vehicle vehicle1 = new Vehicle();
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setOwner("owner1");
		vehicle2.setSpeed(100);
		vehicle2.setDirection(1.0);
		Vehicle vehicle3 = new Vehicle();
		vehicle3.setOwner("owner2");
		vehicle3.setSpeed(50);
		vehicle3.setDirection(-2.0);
		
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
	
	private Object element;
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

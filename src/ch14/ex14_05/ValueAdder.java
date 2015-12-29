package ch14.ex14_05;

import java.util.concurrent.atomic.AtomicInteger;

public class ValueAdder {
	private static volatile AtomicInteger value;

	public ValueAdder(int initialValue) {
		value.set(initialValue);
	}

	public ValueAdder() {
		this(0);
	}

	public static void add(int delta) {
		int result = value.addAndGet(delta);
		System.out.println(Thread.currentThread().getName() + ": value=" + result);
	}

	public static int getValue() {
		return value.get();
	}

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			public void run() {
				for(;;) {
					ValueAdder.add(1);
					try {
						Thread.sleep(50);
					} catch (InterruptedException ignore) {
					}
				}
			}
		};

		new Thread(runnable).start();
		new Thread(runnable).start();
		new Thread(runnable).start();
	}

}

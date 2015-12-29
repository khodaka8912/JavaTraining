package ch14.ex14_04;

public class ValueAdder {
	private static int value;

	public ValueAdder(int initialValue) {
		value = initialValue;
	}

	public ValueAdder() {
		this(0);
	}

	public static synchronized void add(int delta) {
		value += delta;
		System.out.println(Thread.currentThread().getName() + ": value=" + value);
	}

	public static synchronized int getValue() {
		return value;
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

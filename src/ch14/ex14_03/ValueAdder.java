package ch14.ex14_03;

public class ValueAdder {
	private int value;

	public ValueAdder(int initialValue) {
		value = initialValue;
	}

	public ValueAdder() {
		this(0);
	}

	public synchronized void add(int value) {
		this.value += value;
		System.out.println(Thread.currentThread().getName() + ": value=" + this.value);
	}

	public synchronized int getValue() {
		return value;
	}

	public static void main(String[] args) {
		final ValueAdder valueAdder = new ValueAdder();

		Runnable runnable = new Runnable() {
			public void run() {
				for(;;) {
					valueAdder.add(1);
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

package ch14.ex14_06;

public class StopWatch {

	private static final int INTERVAL = 15;
	// private static final int INTERVAL = 7;

	private final Thread timerThread;
	private final Thread messageThread;

	private static class Timer implements Runnable {

		private Object listener;
		private int count;

		public Timer(Object listener) {
			this.listener = listener;
		}

		public void run() {
			for(;;) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ignore) {
				}
				count++;
				System.out.println(count + " seconds elapsed.");
				synchronized (listener) {
					listener.notifyAll();					
				}
			}
		}

	}

	private static class Messenger implements Runnable {

		/** メッセージ表示間隔 */
		private int interval;
		/** 表示メッセージ */
		private String message;
		
		public Messenger(int interval) {
			this("Hello", interval);
		}

		public Messenger(String message, int interval) {
			this.message = message;
			this.interval = interval;
		}

		public void run() {
			for(;;) {
				showMessage();
			}
		}
		
		private synchronized void showMessage() {
			int count = 0;
			while(count != interval) {
				try {
					wait();
				} catch (InterruptedException ignore) {
				}
				count++;
			}
			System.out.println(message);	
		}
	}

	public StopWatch(int interval) {
		final Messenger messenger = new Messenger(interval);
		messageThread = new Thread(messenger);
		timerThread = new Thread(new Timer(messenger));
	}

	public void start() {
		messageThread.start();
		timerThread.start();
	}

	public static void main(String[] args) {
		new StopWatch(INTERVAL).start();
	}
}

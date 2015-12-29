package ch14.ex14_02;

import java.util.LinkedList;
import java.util.List;

public class PrintServer implements Runnable {
	private final PrintQueue requests = new PrintQueue();

	private final long threadId;

	public PrintServer() {
		Thread printThread = new Thread(this);
		threadId = printThread.getId();
		printThread.start();
	}

	private static class PrintQueue {

		List<PrintJob> queue = new LinkedList<>();

		public void add(PrintJob job) {
			queue.add(job);
		}

		public PrintJob remove() {
			return queue.remove(0);
		}
	}

	private static class PrintJob {

	}

	public void print(PrintJob job) {
		requests.add(job);
	}

	@Override
	public void run() {
		if (Thread.currentThread().getId() != threadId) {
			throw new IllegalStateException("Must be invoked by the thread created in constractor.");
		}
		for (;;) {
			realPrint(requests.remove());
		}
	}

	public void realPrint(PrintJob job) {
		// 実際の印刷処理
	}

}

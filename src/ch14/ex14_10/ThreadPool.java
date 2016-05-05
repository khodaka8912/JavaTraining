/*
 * Copyright (C) 2012, 2013 RICOH Co., Ltd. All rights reserved.
 */
package ch14.ex14_10;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Simple Thread Pool class.
 *
 * This class can be used to dispatch an Runnable object to
 * be exectued by a thread.
 *
 * [Instruction]
 *  Implement one constructor and three methods.
 *  Don't forget to write a Test program to test this class. 
 *  Pay attention to @throws tags in the javadoc.
 *  If needed, you can put "synchronized" keyword to methods.
 *  All classes for implementation must be private inside this class.
 *  Don't use java.util.concurrent package.
 */
public class ThreadPool {

	private final TaskQueue queue;
	private final WorkerThread[] workerThreads;

	//	private final int queueSize;

	private volatile boolean started;
	private volatile boolean stopped;

	/**
	 * Constructs ThreadPool.
	 *
	 * @param queueSize the max size of queue
	 * @param numberOfThreads the number of threads in this pool.
	 *
	 * @throws IllegalArgumentException if either queueSize or numberOfThreads
	 *         is less than 1
	 */
	public ThreadPool(int queueSize, int numberOfThreads) {
		if (queueSize < 1) {
			throw new IllegalArgumentException("queueSize must be larger than 0.");
		}
		if (numberOfThreads < 1) {
			throw new IllegalArgumentException("numberOfThreads must be larger than 0.");
		}
		queue = new TaskQueue(queueSize);
		workerThreads = new WorkerThread[numberOfThreads];
		for (int i = 0; i < numberOfThreads; i++) {
			workerThreads[i] = new WorkerThread();
		}
	}

	/**
	 * Starts threads.
	 *
	 * @throws IllegalStateException if threads has been already started.
	 */
	public void start() {
		if (started) {
			throw new IllegalStateException("ThreadPool has already been started.");
		}
		for (Thread thread : workerThreads) {
			thread.start();
		}
		started = true;
	}   

	/**
	 * Stop all threads and wait for their terminations.
	 *
	 * @throws IllegalStateException if threads has not been started.
	 */
	public void stop() {
		if (!started) {
			throw new IllegalStateException("ThreadPool must be started before stop.");
		}
		stopped = true;
		for (WorkerThread thread : workerThreads) {
			thread.requestStop();
			try {
				thread.join();
			} catch (InterruptedException e) {
			}
		}
	}

	/**
	 * Executes the specified Runnable object, using a thread in the pool.
	 * run() method will be invoked in the thread. If the queue is full, then
	 * this method invocation will be blocked until the queue is not full.
	 * 
	 * @param runnable Runnable object whose run() method will be invoked.
	 *
	 * @throws NullPointerException if runnable is null.
	 * @throws IllegalStateException if this pool has not been started yet.
	 */
	public synchronized void dispatch(Runnable runnable) {
		Objects.requireNonNull(runnable, "runnable must not be null.");
		if (!started) {
			throw new IllegalStateException("ThreadPool must be started before dispatch.");
		}
		queue.add(runnable);
	}

	private class WorkerThread extends Thread {

		private volatile boolean stopped;

		@Override
		public void run() {
			while (!stopped) {
				Runnable task = queue.poll();
				if (task != null) {
					task.run();
				}
			}
		}

		public void requestStop() {
			stopped = true;
			queue.notifyStop();
		}
	}

	private static class TaskQueue {
		private final int size;
		private LinkedList<Runnable> queue = new LinkedList<>();

		TaskQueue(int size) {
			this.size = size;
		}

		synchronized void add(Runnable runnable) {
			while (queue.size() >= size) {
				try {
					wait();
				} catch (InterruptedException e) {
					return;
				}
			}
			queue.add(runnable);
			notifyAll();
		}

		synchronized Runnable poll() {
			if (queue.isEmpty()) {
				try {
					wait();
				} catch (InterruptedException e) {
					return null;
				}
			}
			Runnable runnable = queue.poll();
			notifyAll();
			return runnable;
		}

		synchronized void notifyStop() {
			notifyAll();
		}
	}
}

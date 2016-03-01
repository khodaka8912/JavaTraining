package ch17.ex17_01;

import java.util.ArrayList;
import java.util.List;

public final class MemoryChecker {

	private static List<Object> list;

	public static void main(String[] args) throws InterruptedException {
		showMemory("after startup");
		
		createObjects(100000);
		showMemory("after create objects-");
		
		releaseObjects();
		fullGC();
		showMemory("after GC");
	}

	private static void createObjects(int num) {
		if (list == null) {
			list = new ArrayList<>();
		}
		for (int i = 0; i < num; i++) {
			list.add(new Object());
		}
	}

	private static void releaseObjects() {
		if (list == null) {
			return;
		}
		list.clear();
		list = null;
	}

	public static void fullGC() {
		Runtime rt = Runtime.getRuntime();
		long isFree = rt.freeMemory();
		long wasFree;
		do {
			wasFree = isFree;
			rt.runFinalization();
			rt.gc();
			isFree = rt.freeMemory();
		} while (isFree > wasFree);
	}

	/**
	 * システムメモリの利用状況を表示する。
	 * @param message 同時に表示するメッセージ
	 */
	public static void showMemory(String message) {
		Runtime rt = Runtime.getRuntime();
		long freeMemory = rt.freeMemory();
		long totalMemory = rt.totalMemory();
		long maxMemory = rt.maxMemory();
		System.out.println("--" + message + "--");
		System.out.println("free: " + freeMemory + "/ total: " + totalMemory + " (max: "
				+ maxMemory + ")");
	}

}

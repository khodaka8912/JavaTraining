package ch17.ex17_05;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public final class ResourceManager {
	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs;
	final Thread reaper;
	boolean shutdown = false;

	public ResourceManager() {
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>, Resource>();
		reaper = new ReaperThread();
		reaper.start();

		// ... リソースの初期化 ...
	}

	public synchronized void shutdown() {
		if (!shutdown) {
			shutdown = true;
			// すべての割り当てられたりソースを解放する
			Reference<?> ref = null;
			Resource res = null;
			for (Entry<Reference<?>, Resource> entry : refs.entrySet()) {
				ref = entry.getKey();
				res = entry.getValue();
				synchronized (ResourceManager.this) {
					refs.remove(ref);
				}
				res.release();
				ref.clear();
			}
		}
	}

	public synchronized Resource getResource(Object key) {
		if (shutdown)
			throw new IllegalStateException();
		Resource res = new ResourceImpl(key);
		Reference<?> ref = new PhantomReference<Object>(key, queue);
		refs.put(ref, res);
		return res;
	}

	class ReaperThread extends Thread {
		public void run() {
			// 割り込まれるまで実行
			while (true) {
				try {
					Reference<?> ref = queue.remove();
					Resource res = null;
					synchronized (ResourceManager.this) {
						res = refs.get(ref);
						refs.remove(ref);
					}
					res.release();
					ref.clear();
				} catch (InterruptedException ex) {

				}
			}
		}
	}

	private static class ResourceImpl implements Resource {
		Object key;
		boolean needsRelease = false;

		ResourceImpl(Object key) {
			Objects.requireNonNull(key, "key must not be null.");
			this.key = key;

			// ... 外部リソースの設定 ...

			needsRelease = true;
		}

		public void use(Object key, Object... args) {
			if (key != this.key)
				throw new IllegalArgumentException("wrong key");

			// ... リソースの使用 ...
		}

		public synchronized void release() {
			if (needsRelease) {
				needsRelease = false;

				// ... リソースの解放 ...
			}
		}
	}
}
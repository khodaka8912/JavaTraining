package ch21.ex21_02;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

class DataHandler {
	private WeakHashMap<File, byte[]> fileDataCache; // 読み込んだファイルとデータのキャッシュ
	
	DataHandler() {
		fileDataCache = new WeakHashMap<>();
	}

	byte[] readFile(File file) {
		byte[] data;
		// データを記憶しているか調べる
		data = fileDataCache.get(file);
		if (data != null)
			return data;
		// 記憶していないので、読み込む
		data = readBytesFromFile(file);
		fileDataCache.put(file, data);
		return data;
	}
	
	byte[] readBytesFromFile(File file) {
		throw new AssertionError("Stub!!");
	}
}
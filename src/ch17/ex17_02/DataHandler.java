package ch17.ex17_02;

import java.io.File;
import java.lang.ref.WeakReference;

class DataHandler {
	private WeakReference<File> lastFile; // 最後に読んだファイル
	private WeakReference<byte[]> lastData; // (おそらく) 最後のデータ

	byte[] readFile(File file) {
		byte[] data;
		// データを記憶しているか調べる
		if (file.equals(lastFile.get())) {
			data = lastData.get();
			if (data != null)
				return data;
		}
		// 記憶していないので、読み込む
		data = readBytesFromFile(file);
		lastFile = new WeakReference<File>(file);
		lastData = new WeakReference<byte[]>(data);
		return data;
	}
	
	byte[] readBytesFromFile(File file) {
		throw new AssertionError("Stub!!");
	}
}
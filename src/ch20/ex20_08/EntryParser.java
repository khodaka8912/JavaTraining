package ch20.ex20_08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EntryParser {

	private final String filePath;
	private List<Long> cacheList;

	private static final String SEPARATOR = "%%";

	public EntryParser(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * エントリー開始位置のテーブルファイルを作成
	 * @throws IOException
	 */
	public void createTableFile() throws IOException {
		List<Long> entryList = new ArrayList<>();
		try (RandomAccessFile in = new RandomAccessFile(new File(filePath), "r")) {
			long head = in.getFilePointer();
			String line = in.readLine();
			if (line.startsWith(SEPARATOR)) {
				entryList.add(in.getFilePointer());
			} else {
				entryList.add(head);
			}
			while ((line = in.readLine()) != null) {
				if (line.startsWith(SEPARATOR)) {
					entryList.add(in.getFilePointer());
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Source File Not Found.");
			return;
		} catch (IOException e) {
			System.out.println("IOException has occured.");
			return;
		}
		File tableFile = new File(filePath + ".table");
		tableFile.createNewFile();
		try (FileWriter out = new FileWriter(tableFile)) {
			for (Long entry : entryList) {
				out.write(entry.toString());
				out.write(System.lineSeparator());
			}
		}
	}

	/**
	 * 
	 * @throws IOException
	 */
	public void showEntryRandom() throws IOException {
		File tableFile = new File(filePath + ".table");
		if (cacheList == null) {
			if (!tableFile.exists()) {
				createTableFile();
			}
			cacheList = Files.readAllLines(tableFile.toPath()).stream().map(Long::parseLong)
					.collect(Collectors.toList());
		}
		int i = (int) (Math.random() * cacheList.size());
		try (RandomAccessFile in = new RandomAccessFile(new File(filePath), "r")) {
			in.seek(cacheList.get(i));
			String line;
			while ((line = in.readLine()) != null) {
				if (line.startsWith(SEPARATOR)) {
					break;
				}
				System.out.println(line);
			}
		}
	}
	
	/**
	 * test.txtのエントリーをランダムに10回」表示する
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String filePath = "src\\ch20\\ex20_08\\test.txt";
		EntryParser parser = new EntryParser(filePath);
		parser.createTableFile();
		parser = new EntryParser(filePath);
		for (int i = 0; i < 10; i++) {
			parser.showEntryRandom();
		}
	}

}

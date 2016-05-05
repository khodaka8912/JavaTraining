package ch20.ex20_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {

	/**
	 * 指定したファイル内の単語の各出現回数を表示する
	 * 
	 * @param file
	 */
	public static void showWordCounts(File file) {
		Map<String, Integer> wordCountMap = new HashMap<>();
		try (FileReader reader = new FileReader(file)) {
			StreamTokenizer in = new StreamTokenizer(reader);
			while (in.nextToken() != StreamTokenizer.TT_EOF) {
				if (in.ttype == StreamTokenizer.TT_WORD) {
					String word = in.sval;
					Integer current = wordCountMap.get(word);
					wordCountMap.put(word, current == null ? 1 : current + 1);
				}
			}
			wordCountMap.entrySet().stream().map(e -> e.getKey() + ":" + e.getValue()).forEach(System.out::println);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *  てすと てすと てすと
	 * @param args
	 */
	public static void main(String[] args) {
		showWordCounts(new File("src\\ch20\\ex20_10\\test.txt"));
		showWordCounts(new File("src\\ch20\\ex20_10\\WordCounter.java"));
	}
}

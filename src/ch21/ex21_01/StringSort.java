package ch21.ex21_01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class StringSort {
	
	public static List<String> createSortedLines(File file) {
		try (BufferedReader in = new BufferedReader(new FileReader(file))) {
			LinkedList<String> sortedList = new LinkedList<>();
			String line;
			while ((line = in.readLine()) != null) {
				int index = 0;
				for (String sorted : sortedList) {
					if (line.compareTo(sorted) < 0) {
						sortedList.add(index, line);
						break;
					}
					index++;
				}
				if (index == sortedList.size()) {
					sortedList.addLast(line);
				}
			}
			return sortedList;
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	public static void main(String[] args) {
		String filePath = "src\\ch21\\ex21_01\\test.txt";
		List<String> sortedList = createSortedLines(new File(filePath));
		sortedList.forEach(System.out::println);
	}

}

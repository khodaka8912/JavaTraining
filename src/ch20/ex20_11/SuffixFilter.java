package ch20.ex20_11;

import java.io.File;
import java.io.FilenameFilter;

public class SuffixFilter {
	
	/**
	 * 指定されたディレクトリ内のsuffixで終わるファイル/フォルダを列挙する
	 * 
	 * @param dir
	 * @param suffix
	 */
	public static void showFilteredList(File dir, String suffix) {
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException("dir must be a directory");
		}
		
		FilenameFilter filter = (f,s) -> s.endsWith(suffix);
		File[] list = dir.listFiles(filter);
		System.out.println("Dir: " + dir.getName() + " (suffix : " + suffix + ")");
		for (File file : list) {
			System.out.println("- " + file.getName());
		}
	}
	
	public static void main(String[] args) {
		showFilteredList(new File("src\\ch20\\ex20_11"), "txt");
		showFilteredList(new File("src\\ch20\\ex20_11"), "org");
	}

}

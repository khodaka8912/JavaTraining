package ch20.ex20_05;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FindWord {

	private static final boolean DEBUG = true;

	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			if (DEBUG) {
				args = new String[2];
				args[0] = "String";
				args[1] = "src\\ch20\\ex20_05\\FindWord.java";
			} else {
				throw new IllegalArgumentException("need word and file");
			}
		}
		String word = args[0];
		LineNumberReader in = new LineNumberReader(new FileReader(args[1]));
		String line;
		while ((line = in.readLine()) != null) {
			if (line.contains(word)) {
				System.out.println(in.getLineNumber() + " " + line);
			}
		}
	}
}

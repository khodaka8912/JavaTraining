package ch23.ex23_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {

	private static final String[] SAMPLE_COMMAND = {"ipconfig", "/all"};

	public static void main(String[] args){
		List<String> outputs;
		try {
			if (args == null || args.length == 0) {
				outputs = exec(SAMPLE_COMMAND);
			} else {
				outputs = exec(args);
			}
			outputs.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<String> exec(String... cmdArray) throws IOException {
		Process child = Runtime.getRuntime().exec(cmdArray);
		List<String> lines = new ArrayList<String>();
		InputStreamReader in = new InputStreamReader(child.getInputStream(), Charset.forName("Shift-JIS"));
		try (LineNumberReader reader = new LineNumberReader(in)) {
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(String.format("%3d ", reader.getLineNumber()) + line);
			}
		}
		// コマンドが失敗したか
		try {
			if (child.waitFor() != 0) { // 失敗
				throw new IOException("The process was returned : "
						+ child.exitValue());
			}
		} catch (InterruptedException e) {
			throw new IOException(e);
		}
		return lines;
	}
}

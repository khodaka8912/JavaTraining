package ch22.ex22_07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class CSVReader {

	/**
	 * 
	 * @param source
	 * @param cells
	 * @return
	 * @throws IOException
	 *             if input format is invalid or fail to read source.
	 * @throws IllegalArgumentException
	 *             if cellNum is negative or 0.
	 */
	public static List<String[]> readCSVTable(Readable source, int cellNum) throws IOException {
		if (cellNum <= 0) {
			throw new IllegalArgumentException("cells must be positive");
		}
		Scanner in = new Scanner(source);
		List<String[]> vals = new ArrayList<>();
		StringBuilder exp = new StringBuilder().append("^(.*)");
		for (int i = 1; i < cellNum; i++) {
			exp.append(",(.*)");
		}
		Pattern pat = Pattern.compile(exp.toString(), Pattern.MULTILINE);
		while (in.hasNextLine()) {
			String line = in.findInLine(pat);
			if (line != null) {
				String[] cells = new String[cellNum];
				MatchResult match = in.match();
				for (int i = 0; i < cellNum; i++)
					cells[i] = match.group(i + 1);
				vals.add(cells);
				in.nextLine();// 改行を読み飛ばし
			} else {
				throw new IOException("input format error");
			}
		}
		IOException ex = in.ioException();
		if (ex != null)
			throw ex;

		return vals;
	}
}

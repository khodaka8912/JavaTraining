package ch22.ex22_08;

import java.io.IOException;
import java.io.StringReader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class CSVReader {

	/**
	 * read CSV table from source as number of cells is cellNum.
	 * @param source CSV source to read
	 * @param cellNum number of cell
	 * @return List of string array 
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
		StringBuilder exp = new StringBuilder().append("^([^,]*)");
		for (int i = 1; i < cellNum; i++) {
			exp.append(",([^,]*)");
		}
		exp.append("$");
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
				line = in.nextLine();
				if (!line.equals(""))
					throw new IOException("input format error : " + line);
			}
		}
		IOException ex = in.ioException();
		if (ex != null)
			throw ex;

		return vals;
	}

	
	private static final String TEST_CSV = "abc,def,ghi,jkl\nmn,op,qr,st\nu,,,v\n";
	private static final String TEST_FAILURE1 = "abc_def_ghi_jkl";	
	private static final String TEST_FAILURE2 = "ab,cd,ef,gh,ij,kl";

	public static void main(String[] args) {
		Readable r = new StringReader(TEST_CSV);
		try {
			List<String[]> read = readCSVTable(r, 4);
			read.forEach(s -> System.out.println(Arrays.toString(s)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			readCSVTable(new StringReader(TEST_FAILURE1), 4);
		} catch (IOException e) {
			System.out.println("failure1 ok");
		}
		try {
			readCSVTable(new StringReader(TEST_FAILURE2), 4);
		} catch (IOException e) {
			System.out.println("failure2 ok");
		}
		
	}
}

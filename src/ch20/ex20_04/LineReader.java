package ch20.ex20_04;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class LineReader extends FilterReader {

	public LineReader(Reader in) {
		super(in);
	}
	
	/**
	 * 
	 * @return
	 * @throws IOException 
	 */
	public String readLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        String lineSeparator = System.lineSeparator();
        int b;
        while ((b = super.read()) != -1) {
        	sb.append((char) b);
        	if (sb.toString().endsWith(lineSeparator)) {
        		return sb.toString();
        	}
        }

        return null;
	}

}

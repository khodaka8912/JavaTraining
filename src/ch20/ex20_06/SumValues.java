package ch20.ex20_06;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SumValues {

	static enum Operator {
		ADD, SUB, SET;
	}

	private static void sumValues(Reader source) throws IOException {
		StreamTokenizer in = new StreamTokenizer(source);
		Map<String, Double> nameValues = new HashMap<>();
		String name = null;
		Operator ope = null;
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			switch (in.ttype) {
			case StreamTokenizer.TT_WORD:
				name = in.sval;
				break;
			case '+':
				ope = Operator.ADD;
				break;
			case '-':
				ope = Operator.SUB;
				break;
			case '=':
				ope = Operator.SET;
				break;
			case StreamTokenizer.TT_NUMBER:
				if (name == null || ope == null) {
					throw new IOException();
				}
				Double value = nameValues.get(name);
				if (value == null) {
					value = 0.0;
				}
				switch (ope) {
				case ADD:
					value += in.nval;
					break;
				case SUB:
					value -= in.nval;
					break;
				case SET:
					value = in.nval;
					break;
				default:
					break;
				}
				nameValues.put(name, value);
				name = null;
				ope = null;
				break;
			default:
				break;
			}
		}
		Set<Entry<String, Double>> results = nameValues.entrySet();
		for (Entry<String, Double> result : results) {
			System.out.println(result.getKey() + "=" + result.getValue());
		}
	}

	public static void main(String[] args) throws IOException {
		sumValues(new FileReader("src\\ch20\\ex20_06\\test.txt"));
	}

}

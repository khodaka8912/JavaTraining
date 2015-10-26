package ch10.ex10_01;

public class StringUtils {

	private StringUtils() {
	}

	public static String replaceEscSequences(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '\n') {
				sb.append("\\n");
			} else if (c == '\t') {
				sb.append("\\t");
			} else if (c == '\b') {
				sb.append("\\b");
			} else if (c == '\r') {
				sb.append("\\r");
			} else if (c == '\f') {
				sb.append("\\f");
			} else if (c == '\\') {
				sb.append("\\\\");
			} else if (c == '\'') {
				sb.append("\\'");
			} else if (c == '\"') {
				sb.append("\\\"");
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "\\ \"Hello\"\n\t\r\f\'World\'b\b \\";
		System.out.println(str);
		System.out.println("--");
		System.out.println(replaceEscSequences(str));
	}

}

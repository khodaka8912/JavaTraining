package ch10.ex10_04;

public class StringUtils {

	private StringUtils() {
	}

	public static String replaceEscSequences(String str) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < str.length()) {
			char c = str.charAt(i);
			switch (c) {
			case '\n':
				sb.append("\\n");
				break;
			case '\t':
				sb.append("\\t");
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\r':
				sb.append("\\r");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\\':
				sb.append("\\\\");
				break;
			case '\'':
				sb.append("\\'");
				break;
			case '\"':
				sb.append("\\\"");
				break;
			default:
				sb.append(c);
				break;
			}
			i++;
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

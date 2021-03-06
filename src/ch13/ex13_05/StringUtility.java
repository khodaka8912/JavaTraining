package ch13.ex13_05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtility {
	
	/**
	 * 文字列中の10進数をカンマで3桁毎に区切る
	 * @param src 対象の文字列
	 * @return 10進数の数字が3桁ごとにカンマで区切られた文字列
	 */
	public static String getCommaSeparated(String src) {
		StringBuffer result = new StringBuffer();
		Matcher matcher = Pattern.compile("\\d+").matcher(src);
		while(matcher.find()) {
			StringBuffer sb = new StringBuffer().append(matcher.group());
			for (int i = sb.length(); i > 3; i -= 3) {
				sb.insert(i - 3, ',');
			}
//			String replace = String.format("%1$,d", Long.parseLong(matcher.group()));
			matcher.appendReplacement(result, sb.toString());
		}
		matcher.appendTail(result);
		return result.toString();
	}
	
	public static void main(String[] args) {
		String test = "abc1234567-def72_1234567890123456789876543210end";
		System.out.println(getCommaSeparated(test));
	}

}

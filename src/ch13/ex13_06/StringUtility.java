package ch13.ex13_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtility {
	
	/**
	 * 文字列中の10進数を指定した区切り文字、桁数で区切る
	 * @param src 対象の文字列
	 * @param separator 区切り文字
	 * @param digit 区切る桁数
	 * @return 10進数の数字が区切られた文字列
	 */
	public static String getSeparatedWith(String src, char separator, int digit) {
		StringBuffer result = new StringBuffer();
		Matcher matcher = Pattern.compile("\\d+").matcher(src);
		while(matcher.find()) {
			StringBuffer sb = new StringBuffer().append(matcher.group());
			for (int i = sb.length() - digit; i > 0; i -= digit) {
				sb.insert(i, "\\" + separator);
			}
			matcher.appendReplacement(result, sb.toString());
		}
		matcher.appendTail(result);
		return result.toString();
	}
	
	public static void main(String[] args) {
		String test = "abc1234567-def72_1234567890123456789876543210end";
		System.out.println(getSeparatedWith(test, '#', 5));
	}

}

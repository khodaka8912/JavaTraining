package ch13.ex13_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * 
 * @author hodaka
 *
 */
public class StringUtility {

	/**
	 * 文字列中に指定された文字が出現する回数を数える
	 * 
	 * @param src
	 *            文字列
	 * @param ch
	 *            回数を数える文字
	 * @return src中にchが出現する回数
	 * @throws NullPointerException
	 *             srcがnull
	 */
	public static int numOfContains(String src, char ch) {
		Objects.requireNonNull(src, "Source string must not be null.");
		int count = 0;
		int index = -1;
		while ((index = src.indexOf(ch, index + 1)) != -1) {
			count++;
		}
		return count;
	}

	/**
	 * 文字列中に指定された文字が出現する回数を数える
	 * 
	 * @param src
	 *            文字列
	 * @param ch
	 *            回数を数える文字
	 * @return src中にchが出現する回数
	 * @throws NullPointerException
	 *             srcまたはtargetがnull
	 * @throws IllegalArgumentException
	 *             targetが空文字列
	 */
	public static int numOfContains(String src, String target) {
		Objects.requireNonNull(src, "Source string must not be null.");
		Objects.requireNonNull(target, "Target string must not be null.");
		if (target.isEmpty()) {
			throw new IllegalArgumentException("Target string must not be empty.");
		}
		int length = target.length();
		int index = -length;
		int count = 0;
		while ((index = src.indexOf(target, index + length)) != -1) {
			count++;
		}
		return count;
	}

	/**
	 * 文字列中から指定した文字で区切られた文字列の配列を取り出す
	 * 
	 * @param from
	 *            対象の文字列
	 * @param start
	 *            開始区切り文字
	 * @param end
	 *            終了区切り文字
	 * @return 区切られた文字列の配列
	 */
	public static String[] delimitedStrings(String from, char start, int end) {
		int startPos = 0;
		int endPos = 0;
		ArrayList<String> delimitedList = new ArrayList<>();
		while ((startPos = from.indexOf(start, endPos)) != -1) {
			endPos = from.indexOf(end, startPos + 1);
			if (endPos < 0) {
				delimitedList.add(from.substring(startPos, from.length()));
				break;
			} else {
				delimitedList.add(from.substring(startPos, endPos + 1));
			}
		}

		if (delimitedList.isEmpty()) {
			return null;
		}
		return delimitedList.toArray(new String[delimitedList.size()]);
	}

	public static void main(String[] args) {
		System.out.println(numOfContains("the test of num of ct", 't'));
		System.out.println(numOfContains("the test of num of ct test the test", "test"));
		System.out.println(Arrays.toString(delimitedStrings("the <test> of <num> of ct test <the> test", '<', '>')));
	}

}

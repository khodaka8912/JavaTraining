package ch13.ex13_02;

import java.util.Objects;

/**
 * 
 * @author hodaka
 *
 */
public class StringUtility {
	
	/**
	 * 文字列中に指定された文字が出現する回数を数える
	 * @param src 文字列
	 * @param ch 回数を数える文字
	 * @return src中にchが出現する回数
	 * @throws NullPointerException srcがnull
	 */
	public static int numOfContains(String src, int ch) {
		Objects.requireNonNull(src, "Source string must not be null.");
		int count = 0;
		int index = -1;
		while((index = src.indexOf(ch, index + 1)) != -1) {
			count++;
		}
		return count;
	}
	
	/**
	 * 文字列中に指定された文字が出現する回数を数える
	 * @param src 文字列
	 * @param ch 回数を数える文字
	 * @return src中にchが出現する回数
	 * @throws NullPointerException srcまたはtargetがnull
	 * @throws IllegalArgumentException targetが空文字列
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
		while((index = src.indexOf(target, index + length)) != -1) {
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(numOfContains("the test of num of ct", 't'));
		System.out.println(numOfContains("the test of num of ct test the test", "test"));
		System.out.println(numOfContains("the test of num of ct test the test", ""));
	}

}

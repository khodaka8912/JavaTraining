package ch13.ex13_01;

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
	
	public static void main(String[] args) {
		System.out.println(numOfContains("the test of num of ct", 't'));
	}

}

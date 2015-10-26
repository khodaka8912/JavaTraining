package ch10.ex10_05;

import java.util.ArrayList;
import java.util.List;

public class CharUtils {

	private CharUtils() {
	}

	public static List<Character> getCharsBetween(char start, char end) {
		List<Character> charList = new ArrayList<>();
		for (char c = start; c <= end; c++) {
			charList.add(c);
		}
		return charList;
	}

	public static void main(String[] args) {
		List<Character> charList = getCharsBetween('a', 'z');
		for (Character c : charList) {
			System.out.print(c + ",");
		}
	}

}

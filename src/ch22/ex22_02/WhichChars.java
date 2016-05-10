package ch22.ex22_02;

import java.util.HashSet;
import java.util.Set;

public class WhichChars {
	private Set<Character> used = new HashSet<>();

	public WhichChars(String str) {
		str.chars().forEach(i -> used.add((char) i));
	}

	@Override
	public String toString() {
		StringBuilder desc = new StringBuilder("[");
		used.forEach(c -> desc.append(c));
		return desc.append("]").toString();
	}

	public static void main(String[] args) {
		System.out.println(new WhichChars("Hello, World!!"));
	}
}
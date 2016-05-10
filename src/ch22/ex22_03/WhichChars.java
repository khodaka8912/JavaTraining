package ch22.ex22_03;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class WhichChars {
	private Map<Byte, BitSet> used = new HashMap<>();

	public WhichChars(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			Byte upper = (byte) (c >> 8);
			BitSet lowerSet = used.get(upper);
			if (lowerSet == null) {
				lowerSet = new BitSet();
				used.put(upper, lowerSet);
			}
			lowerSet.set(c & 0xff);
		}
	}

	@Override
	public String toString() {
		StringBuilder desc = new StringBuilder("[");
		for (Entry<Byte, BitSet> entry : used.entrySet()) {
			Byte upper = entry.getKey();
			BitSet lowerSet = entry.getValue();
			for (int i = lowerSet.nextSetBit(0); i >= 0; i = lowerSet.nextSetBit(i + 1)) {
				desc.append((char) (upper << 8 | i));
			}
		}
		return desc.append("]").toString();
	}

	public static void main(String[] args) {
		System.out.println(new WhichChars("Hello, World!!"));
	}
}
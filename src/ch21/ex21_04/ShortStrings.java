package ch21.ex21_04;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ShortStrings implements ListIterator<String> {
	ListIterator<String> strings; // 元の文字列
	private String nextShort; // 次が不明ならばnull
	private int nextIndex; // 不明ならば-2
	private String prevShort; // 前が不明ならばnull
	private int prevIndex; // 不明ならば-2
	private final int maxLen; // この長さ以下の文字列だけを返す
	private String current;

	public ShortStrings(ListIterator<String> strings, int maxLen) {
		this.strings = strings;
		this.maxLen = maxLen;
		nextShort = null;
		nextIndex = -2;
		prevShort = null;
		prevIndex = -2;
		current = null;
	}

	@Override
	public boolean hasNext() {
		if (nextShort != null) // すでに見つけている
			return true;
		int currentIndex = strings.previousIndex();
		boolean hasNext = false;
		while (strings.hasNext()) {
			nextIndex = strings.nextIndex();
			nextShort = strings.next();
			if (nextShort.length() <= maxLen) {
				hasNext = true;
				break;
			}
		}
		if (!hasNext) {
			nextShort = null;
			nextIndex = strings.nextIndex();
			while (strings.previousIndex() == currentIndex) {
				strings.previous();
			}
		}
		return hasNext;
	}

	@Override
	public String next() {
		if (nextShort == null && !hasNext())
			throw new NoSuchElementException();
		current = nextShort;
		clear();
		return current;
	}

	@Override
	public boolean hasPrevious() {
		if (prevShort != null) // すでに見つけている
			return true;
		int currentIndex = strings.nextIndex();
		boolean hasPrevious = false;
		while (strings.hasPrevious()) {
			prevIndex = strings.previousIndex();
			prevShort = strings.previous();
			if (prevShort.length() <= maxLen) {
				hasPrevious = true;
				break;
			}
		}
		if (!hasPrevious) {
			prevShort = null;
			prevIndex = strings.previousIndex();
			while (strings.nextIndex() == currentIndex) {
				strings.next();
			}
		}
		return hasPrevious;
	}

	@Override
	public String previous() {
		if (prevShort == null && !hasPrevious())
			throw new NoSuchElementException();
		current = prevShort;
		clear();
		return current;
	}

	@Override
	public int nextIndex() {
		if (nextIndex == -2) {
			hasNext();
		}
		return nextIndex;
	}

	@Override
	public int previousIndex() {
		if (prevIndex == -2) {
			hasPrevious();
		}
		return prevIndex;
	}

	@Override
	public void remove() {
		if (current == null) {
			throw new IllegalStateException("next or previous is not called before.");
		}
		strings.remove();
	}

	@Override
	public void set(String e) {
		strings.set(e);
	}

	@Override
	public void add(String e) {
		strings.add(e);
	}

	private void clear() {
		prevShort = null;
		prevIndex = -2;
		nextShort = null;
		nextIndex = -2;
	}
}

package ch01.ex01_15;

import java.util.Objects;

/**
 * 配列による編集可能検索テーブルの実装
 * @author hwatanabe
 *
 */
public class SimpleEditableLookup implements EditableLookup {

	private String[] names;
	private Object[] values;
	private int length = 0;

	public SimpleEditableLookup() {
		names = new String[100];
		values = new Object[100];
	}

	/**
	 * コンストラクタ
	 * @param initialSize 配列の容量
	 */
	public SimpleEditableLookup(int initialSize) {
		if (initialSize < 0) {
			throw new IllegalArgumentException("size must not be negative");
		}
		names = new String[initialSize];
		values = new Object[initialSize];
	}

	@Override
	public Object find(String name) {
		for (int i = 0; i < length; i++) {
			if (Objects.equals(names[i], name)) {
				return values[i];
			}
		}
		return null;
	}

	/**
	 * @throws IndexOutOfBoundsException
	 *             テーブルの容量を超える場合
	 */
	@Override
	public void add(String name, Object value) {
		if (length >= names.length) {
			throw new IndexOutOfBoundsException();
		}
		names[length] = name;
		values[length] = value;
		length++;
	}

	@Override
	public boolean remove(String name) {
		for (int i = 0; i < length; i++) {
			if (Objects.equals(names[i], name)) {
				for (int j = i; j < length - 1; j++) {
					names[j] = names[j + 1];
					values[j] = values[j + 1];
				}
				length--;
				return true;
			}
		}
		return false;
	}
}

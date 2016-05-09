package ch21.ex21_03;

import java.lang.ref.WeakReference;
import java.util.HashMap;

public class WeakValueMap <K, V> {
	private HashMap<K, WeakReference<V>> map;

}

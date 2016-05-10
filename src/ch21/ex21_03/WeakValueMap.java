package ch21.ex21_03;

import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class WeakValueMap<K, V> implements Map<K, V> {
	private final HashMap<K, WeakReference<V>> map;

	public WeakValueMap() {
		map = new HashMap<>();
	}

	public WeakValueMap(int initialCapacity) {
		map = new HashMap<>(initialCapacity);
	}

	public WeakValueMap(Map<? extends K, ? extends V> m) {
		map = new HashMap<>();
		m.entrySet().forEach(e -> map.put(e.getKey(), new WeakReference<V>(e.getValue())));
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		for (WeakReference<V> valueRef : map.values()) {
			if (Objects.equals(value, valueRef.get())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public V get(Object key) {
		WeakReference<V> valueRef = map.get(key);
		return valueRef == null ? null : valueRef.get();
	}

	@Override
	public V put(K key, V value) {
		WeakReference<V> valueRef = map.put(key, new WeakReference<V>(value));
		return valueRef == null ? null : valueRef.get();
	}

	@Override
	public V remove(Object key) {
		WeakReference<V> valueRef = map.remove(key);
		return valueRef == null ? null : valueRef.get();
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		m.forEach((k, v) -> map.put(k, new WeakReference<V>(v)));
	}

	@Override
	public void clear() {
		map.values().forEach(r -> r.clear());
		map.clear();
	}

	@Override
	public Set<K> keySet() {
		return map.keySet();
	}

	@Override
	public Collection<V> values() {
		return map.values().stream().filter(r -> !r.isEnqueued()).map(r -> r.get())
				.collect(Collectors.toList());
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return map.entrySet().stream().filter(e -> !e.getValue().isEnqueued())
				.map(e -> new AbstractMap.SimpleEntry<K, V>(e.getKey(), e.getValue().get()))
				.collect(Collectors.toSet());
	}

}

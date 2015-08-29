package ch01.ex01_15;

import java.util.HashMap;
import java.util.Map;

public class SimpleEditableLookup implements EditableLookup {
	
	private Map<String, Object> nameValueMap = new HashMap<>();

	@Override
	public Object find(String name) {
		return nameValueMap.get(name);
	}

	@Override
	public void add(String name, Object element) {
		nameValueMap.put(name, element);
	}

	@Override
	public boolean remove(String name) {
		if (nameValueMap.remove(name) != null) {
			return true;
		} else {
			return false;	
		}
	}

}

package ch24.ex24_01;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ResourceBundle;


public class GlobalRes_es extends ResourceBundle {
	
	private static final Hashtable<String, String> resourceMap = new Hashtable<>();
	
	static {
		resourceMap.put(GlobalRes.HELLO, "Hola");
		resourceMap.put(GlobalRes.GOODBYE, "adiós");
	}

	@Override
	protected Object handleGetObject(String key) {
		return resourceMap.get(key);
	}

	@Override
	public Enumeration<String> getKeys() {
		return resourceMap.keys();
	}

}

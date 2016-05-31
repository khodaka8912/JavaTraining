package ch22.ex22_04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

public class AttributedImpl extends Observable implements Attributed {
	
	private Map<String, Attr> attrMap = new HashMap<>();

	@Override
	public void add(Attr newAttr) {
		attrMap.put(newAttr.getName(), newAttr);
		setChanged();
		notifyObservers(new ChangeInfo(Action.ADDED, newAttr));
	}

	@Override
	public Attr find(String attrName) {
		return attrMap.get(attrName);
	}

	@Override
	public Attr remove(String attrName) {
		Attr attr = attrMap.remove(attrName);
		setChanged();
		notifyObservers(new ChangeInfo(Action.REMOVED, attr));
		return attr;
	}

	@Override
	public Iterator<Attr> attrs() {
		return attrMap.values().iterator();
	}
	
	static enum Action {
		ADDED, REMOVED;
	}
	
	static class ChangeInfo {
		final Action action;
		final Attr attr;
		
		ChangeInfo(Action action, Attr attr) {
			this.action  =action;
			this.attr = attr;
		}
	}

}

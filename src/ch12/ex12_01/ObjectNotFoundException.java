package ch12.ex12_01;

public class ObjectNotFoundException extends Exception {
	
	private final String name;
	
	public ObjectNotFoundException(String name) {
		this(name, "Object named" + name + " not found.");
	}
	
	public ObjectNotFoundException(String name, String msg) {
		this(name, msg, null);
	}
	
	public ObjectNotFoundException(String name, Throwable t) {
		this(name, "Object named" + name + " not found.", t);
	}
	
	public ObjectNotFoundException(String name, String msg, Throwable t) {
		super(msg, t);
		this.name = name;
	}

}

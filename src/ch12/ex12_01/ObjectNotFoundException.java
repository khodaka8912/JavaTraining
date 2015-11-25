package ch12.ex12_01;

public class ObjectNotFoundException extends Exception {
	
	private final Object target;
	
	public ObjectNotFoundException(Object target) {
		this(target, "Object \"" + target + "\" not found.");
	}
	
	public ObjectNotFoundException(Object target, String msg) {
		this(target, msg, null);
	}
	
	public ObjectNotFoundException(Object target, Throwable t) {
		this(target, "Object \"" + target + "\" not found.", t);
	}
	
	public ObjectNotFoundException(Object target, String msg, Throwable t) {
		super(msg, t);
		this.target = target;
	}
	
	public Object getTarget() {
		return target;
	}

}

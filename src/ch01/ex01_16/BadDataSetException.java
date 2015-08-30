package ch01.ex01_16;

import java.io.IOException;

public class BadDataSetException extends Exception {

	private final String setName;
	
	public BadDataSetException(String setName, IOException cause) {
		super(cause);
		this.setName = setName;
	}
	
	public String getSetName() {
		return setName;
	}
}

package ch01.ex01_14;

import java.io.OutputStream;

public class Walkman {
	
	private static int nextSerial = 0;
	
	private final int serial;
	
	private OutputStream earphone;
	private Object tape;
	
	public Walkman() {
		serial = nextSerial++;
	}
	
	public void play() {
		if (earphone != null && tape != null) {
			// TODOs
		}
	}
	
	public int getSerial() {
		return serial;
	}
	
	public Object getTape() {
		return tape;
	}
	
	public void setTape(Object tape) {
		this.tape = tape;
	}
	
	public OutputStream getEarphone() {
		return earphone;
	}
	
	public void setEarphone(OutputStream earphone) {
		this.earphone = earphone;
	}

}

package ch01.ex01_14;

import java.io.OutputStream;

public class WalkmanDuo extends Walkman {
	
	private OutputStream secondEarphone;
	
	public OutputStream getSecondEarphone() {
		return secondEarphone;
	}
	
	public void setSecondEarphone(OutputStream earphone) {
		secondEarphone = earphone;
	}

}

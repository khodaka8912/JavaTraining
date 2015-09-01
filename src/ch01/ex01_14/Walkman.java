package ch01.ex01_14;

public class Walkman {

	private static int nextSerial = 0;

	private final int serial;

	private Object earphone;
	private Object tape;

	public Walkman() {
		serial = nextSerial++;
	}

	public void play() {
		if (earphone != null && tape != null) {
			// PlayMusic
		}
	}

	public void stop() {

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

	public Object getEarphone() {
		return earphone;
	}

	public void setEarphone(Object earphone) {
		this.earphone = earphone;
	}

}

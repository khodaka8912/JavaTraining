package ch01.ex01_14;

/**
 * ウォークマン
 * @author hwatanabe
 *
 */
public class Walkman {

	private static int nextSerial = 0;

	private final int serial;

	private Object earphone;
	private Object tape;

	private boolean isPlaying;

	public Walkman() {
		serial = nextSerial++;
	}

	/**
	 * テープがあれば再生する
	 * 
	 * @return true 再生開始 false 再生しない
	 */
	public boolean play() {
		if (tape != null) {
			isPlaying = true;
			if (earphone != null) {
				// play music with earphone
			}
		}
		return isPlaying;
	}

	public void stop() {
		isPlaying = false;
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

	public boolean isPlaying() {
		return isPlaying;
	}

}

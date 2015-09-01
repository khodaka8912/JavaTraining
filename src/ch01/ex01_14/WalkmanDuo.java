package ch01.ex01_14;

public class WalkmanDuo extends Walkman {

	private Object secondEarphone;

	@Override
	public void play() {
		super.play();
		if (secondEarphone != null) {
			// play music with second earphone
		}
	}

	public Object getSecondEarphone() {
		return secondEarphone;
	}

	public void setSecondEarphone(Object earphone) {
		secondEarphone = earphone;
	}

}

package ch04.ex04_01;

/**
 * 電池による動力源
 * 
 * @author hwatanabe
 *
 */
class Battery implements EnergySource {

	private int boltage;

	private final int boltageThretthold;

	public Battery(int thretthold) {
		this.boltageThretthold = thretthold;
	}

	@Override
	public boolean empty() {
		return getBoltage() < boltageThretthold;
	}

	public int getBoltage() {
		return boltage;
	}

	public void setBoltage(int boltage) {
		this.boltage = boltage;
	}

}

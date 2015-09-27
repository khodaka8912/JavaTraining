package ch03.ex03_06;

class Battery extends EnergySource {
	
	private int boltage;
	
	private final int boltageThretthold;
	
	public Battery(int thretthold) {
		this.boltageThretthold = thretthold;
	}

	@Override
	public boolean empty() {
		return getBoltage() > boltageThretthold;
	}
	
	public int getBoltage() {
		return boltage;
	}

}

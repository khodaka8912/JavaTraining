package ch04.ex04_01;

/**
 * 燃料による動力源
 * 
 * @author hwatanabe
 *
 */
class GasTank implements EnergySource {

	private int gas;

	public void addGas(int gas) {
		this.gas += gas;
	}

	@Override
	public boolean empty() {
		return getGas() == 0;
	}

	public int getGas() {
		return gas;
	}

}

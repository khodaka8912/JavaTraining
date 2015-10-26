package ch03.ex03_09;

class Garage implements Cloneable {

	private final Vehicle[] vehicles;

	private int currentVehicleNum;

	public Garage(int size) {
		vehicles = new Vehicle[size];
	}

	public void setVehicle(int index, Vehicle vehicle) {
		vehicles[index] = vehicle;
	}

	public Vehicle getVehicle(int index) {
		return vehicles[index];
	}

	public int getSize() {
		return vehicles.length;
	}

	public Vehicle[] getVehicles() {
		return vehicles;
	}

	@Override
	public Garage clone() {
		Garage g = new Garage(vehicles.length);
		for (int i = 0; i < vehicles.length; i++) {
			if (vehicles[i] != null) {
				g.setVehicle(i, vehicles[i].clone());
			} else {
				g.setVehicle(i, null);
			}
		}
		return g;
	}

	public static void main(String[] args) {
		Garage g1 = new Garage(10);
		g1.setVehicle(0, new Vehicle());
		Garage g2 = g1.clone();
		if (g2 == g1 || g2.vehicles == g1.vehicles || g2.getSize() != g1.getSize()) {
			throw new AssertionError("clone failed");
		}
		System.out.println("Clone completed.");
	}
}

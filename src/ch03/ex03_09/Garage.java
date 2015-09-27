package ch03.ex03_09;

class Garage implements Cloneable {
	
	private final Vehicle[] vehicles;
	
	private int currentVehicleNum;
	
	public Garage(int size) {
		vehicles = new Vehicle[size];
	}
	
	public void addVehicle(Vehicle vehicle) {
		vehicles[currentVehicleNum++] = vehicle;
	}
	
	public int getSize() {
		return vehicles.length;
	}
	
	@Override
	public Garage clone() {
		return new Garage(getSize());
	}
	
	public static void main(String[] args) {
		Garage g1 = new Garage(10);
		g1.addVehicle(new Vehicle());
		Garage g2 = g1.clone();
		if (g2 == g1 || g2.vehicles == g1.vehicles || g2.getSize() != g1.getSize()) {
			throw new AssertionError("clone failed");
		}
		System.out.println("Clone completed.");
	}
}

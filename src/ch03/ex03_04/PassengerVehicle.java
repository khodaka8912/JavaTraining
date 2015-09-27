package ch03.ex03_04;

class PassengerVehicle extends Vehicle {
	/** 座席数 */
	private final int seatNum;
	/** 座っている人数 */
	private int passengerNum;

	public PassengerVehicle(int seatNum) {
		super();
		this.seatNum = seatNum;
	}

	public PassengerVehicle(String owner, int seatNum) {
		super(owner);
		this.seatNum = seatNum;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setPassengerNum(int passengerNum) {
		this.passengerNum = passengerNum;
	}

	public int getPassengerNum() {
		return passengerNum;
	}
}

package ch03.ex03_08;

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

	/**
	 * コピーコンストラクタ
	 * 
	 * @param org
	 *            コピー元
	 */
	public PassengerVehicle(PassengerVehicle org) {
		this(org.getOwner(), org.getSeatNum());
	}

	@Override
	public PassengerVehicle clone() {
		return new PassengerVehicle(this);
	}
}

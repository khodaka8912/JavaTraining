package ch02.ex02_18;

public class Vehicle {

	public static void main(String[] args) {
		if (args.length != 1) {
			throw new IllegalArgumentException("length of args must be 2");
		}
		Vehicle vehicle = new Vehicle(args[0]);
		System.out.println(vehicle);
	}

	/** 現在のスピード[km/h] */
	private int speed = 0;
	/** 現在の方向（角度）[rad] */
	private double direction = 0.0;
	/** 角度の最大値 */
	public static final double DIR_MAX = Math.PI * 2;
	/** 角度の最小値 */
	public static final double DIR_MIN = 0.0;
	/** 左折の定数値 */
	public static final int TURN_LEFT = 0;
	/** 右折の定数値 */
	public static final int TURN_RIGHT = 1;
	/** 次の識別番号 */
	private static long nextID = 0;
	/** ID番号 */
	private final long idNum;

	/** 所有者の名前 */
	private String owner;

	public Vehicle() {
		idNum = nextID++;
	}

	public Vehicle(String owner) {
		this();
		this.owner = owner;
	}

	public int getSpeed() {
		return speed;
	}

	public void changeSpeed(int speed) {
		if (speed < 0) {
			throw new IllegalArgumentException("speed must not be negative");
		}
		this.speed = speed;
	}

	public void stop() {
		speed = 0;
	}

	public double getDirection() {
		return direction;
	}

	public void setDirection(double direction) {
		if (direction >= DIR_MAX || direction < DIR_MIN) {
			throw new IllegalArgumentException("direction out of range(-π to π)");
		}
		this.direction = direction;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public long getID() {
		return idNum;
	}

	public static long getMaxID() {
		return nextID - 1;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id = ").append(idNum).append("\n").append("owner = ").append(owner).append("\n").append("speed = ")
				.append(speed).append("\n").append("direction = ").append(direction);
		return sb.toString();
	}

	/**
	 * 指定した角度だけ旋回する
	 * 
	 * @param angle
	 *            旋回角度[rad]
	 */
	public void turn(double angle) {
		direction = (direction + angle) % DIR_MAX;
		if (direction < DIR_MIN) {
			direction += DIR_MAX;
		}
	}

	/**
	 * 右折または左折する
	 * 
	 * @param turnDirection
	 *            Vehicle.TURN_LEFTまたはVehicle.TURN_RIGHT
	 */
	public void turn(int turnDirection) {
		switch (turnDirection) {
		case TURN_LEFT:
			turn(Math.PI * 0.5);
			break;
		case TURN_RIGHT:
			turn(-Math.PI * 0.5);
			break;
		default:
			throw new IllegalArgumentException("direction must be TURN_LEFT or TURN_RIGHT");
		}
	}
}

package ch02.ex02_06;

public class Vehicle {
	
	/** 現在のスピード[km/h] */
	private int speed = 0;
	/** 現在の方向（角度）[rad] */
	private double direction = 0.0;
	/** 角度の最大値 */
	public static final double DIR_MAX = Math.PI;
	/** 角度の最小値 */
	public static final double DIR_MIN = -Math.PI;
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

	public void setSpeed(int speed) {
		if (speed < 0) {
			throw new IllegalArgumentException("speed must not be negative");
		}
		this.speed = speed;
	}

	public double getDirection() {
		return direction;
	}

	public void setDirection(double direction) {
		if (direction > DIR_MAX || direction < DIR_MIN) {
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
}
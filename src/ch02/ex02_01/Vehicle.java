package ch02.ex02_01;

/**
 * 乗り物クラス
 * 
 * @author hwatanabe
 *
 */
public class Vehicle {
	/** 現在のスピード [km/h] */
	private int speed = 0;
	/** 現在の方向（角度）[rad] */
	private double direction = 0.0;
	/** 角度の最大値 */
	private static final double DIR_MAX = Math.PI * 2;
	/** 角度の最小値 */
	private static final double DIR_MIN = 0.0;
	/** 所有者の名前 */
	private String owner;

	public Vehicle() {
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

	/**
	 * set direction
	 * 
	 * @param direction
	 *            設定する方向
	 * @throws IllegalArgumentException
	 *             directionが0未満または2π以上
	 */
	public void setDirection(double direction) {
		if (direction >= DIR_MAX || direction < DIR_MIN) {
			throw new IllegalArgumentException("direction out of range(0 to 2π)");
		}
		this.direction = direction;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}

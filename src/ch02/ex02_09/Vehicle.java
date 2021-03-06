package ch02.ex02_09;

/**
 * 乗り物クラス
 * 
 * @author hwatanabe
 *
 */
public class Vehicle {

	/** 複数のVehicleを作成・表示 */
	public static void main(String[] args) {
		Vehicle vehicle1 = new Vehicle();
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setOwner("owner1");
		vehicle2.setSpeed(100);
		vehicle2.setDirection(1.0);
		Vehicle vehicle3 = new Vehicle();
		vehicle3.setOwner("owner2");
		vehicle3.setSpeed(50);
		vehicle3.setDirection(5.0);
		Vehicle[] vehicles = { vehicle1, vehicle2, vehicle3 };

		for (Vehicle v : vehicles) {
			System.out.println("id = " + v.getID());
			System.out.println("owner = " + v.getOwner());
			System.out.println("speed = " + v.getSpeed());
			System.out.println("direction = " + v.getDirection());
			System.out.println("-----");
		}

	}

	/** 現在のスピード[km/h] */
	private int speed = 0;
	/** 現在の方向（角度）[rad] */
	private double direction = 0.0;
	/** 角度の最大値 */
	public static final double DIR_MAX = Math.PI * 2;
	/** 角度の最小値 */
	public static final double DIR_MIN = 0.0;
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

	public long getID() {
		return idNum;
	}

	public static long getMaxID() {
		return nextID - 1;
	}
}

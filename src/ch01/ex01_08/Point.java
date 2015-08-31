package ch01.ex01_08;

public class Point {
	public double x, y;
	
	public static Point origin = new Point();
	
	public void clear() {
		x = 0.0;
		y = 0.0;
	}
	
	public double distance(Point that) {
		double xdiff = x - that.x;
		double ydiff = y - that.y;
		return Math.sqrt(xdiff * xdiff + ydiff * ydiff);
	}
	
	/**
	 * move to target coordinate
	 * @param x target x-coordinate
	 * @param y target y-coordinate
	 */
	public void move(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * move to target point
	 * @param target target point to move
	 */
	public void move(Point target) {
		x = target.x;
		y = target.y;
	}
}

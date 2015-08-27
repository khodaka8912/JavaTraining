package chapter01.p1_8;

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
		return Math.sqrt(xdiff * xdiff + ydiff + ydiff);
	}
	
	public void move(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * move to target point
	 * @param target targt point to which this point move
	 */
	public void move(Point target) {
		x = target.x;
		y = target.y;
	}
}

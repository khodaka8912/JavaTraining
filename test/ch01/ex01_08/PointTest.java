package ch01.ex01_08;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PointTest {
	
	private Point point;
	
	@Before
	public void setUp() {
		point = new Point();
	}

	@Test
	public void testPoint() {
		assertThat(point, is(notNullValue()));
	}
	
	@Test
	public void testClear() {
		point.x = 2.0;
		point.y = -1.0;
		point.clear();
		assertThat(point.x, is(0.0));
		assertThat(point.y, is(0.0));
	}
	
	@Test
	public void testDistance() {
		Point that = new Point();
		that.x = 5.0;
		that.y = 4.0;
		point.x = 0.3;
		point.y = -1.0;
		double distance = Math.sqrt((5.0-0.3)*(5.0-0.3)+(4.0+1.0)*(4.0+1.0));
		assertThat(point.distance(that), is(distance));
	}
	
	@Test
	public void testOrigin() {
		assertThat(Point.origin.x, is(0.0));
		assertThat(Point.origin.y, is(0.0));
	}
	
	@Test
	public void testMoveDouble() {
		double x = 1.0;
		double y = -2.5;
		point.move(x, y);
		assertThat(point.x, is(x));
		assertThat(point.y, is(y));
	}
	
	@Test
	public void testMovePoint() {
		Point target = new Point();
		target.x = 3.0;
		target.y = 5.0;
		point.move(target);
		assertThat(point.x, is(target.x));
		assertThat(point.y, is(target.y));
	}

}

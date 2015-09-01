package ch02.ex02_01;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.xpath.internal.operations.And;

public class VehicleTest {
	
	private Vehicle vehicle;

	@Before
	public void setUp() throws Exception {
		vehicle = new Vehicle();
	}

	@Test
	public void testVehicle() {
		assertThat(new Vehicle(), is(notNullValue()));
	}
	
	@Test
	public void testSetDirection1() {
		vehicle.setDirection(0.0);
		assertThat(vehicle.getDirection(), is(0.0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetDirection2() {
		vehicle.setDirection(-0.1);
	}

	@Test
	public void testSetDirection3() {
		double dir = Math.PI * 1.9;
		vehicle.setDirection(dir);
		assertThat(vehicle.getDirection(), is(dir));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetDirection4() {
		vehicle.setDirection(Math.PI * 2);
	}
}

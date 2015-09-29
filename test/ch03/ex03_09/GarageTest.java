package ch03.ex03_09;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GarageTest {

	private Garage target;

	@Before
	public void setUp() throws Exception {
		target = new Garage(10);
	}

	@Test
	public void testGarage() {
		assertThat(target.getSize(), is(10));
	}

	@Test
	public void testSetVehicle() {
		Vehicle v = new Vehicle();
		target.setVehicle(1, v);
		assertThat(target.getVehicle(1), is(v));
	}

	@Test
	public void testClone() {
		Garage g1 = new Garage(10);
		g1.setVehicle(0, new Vehicle());
		Garage g2 = g1.clone();
		assertThat(g2, is(not(g1)));
		assertThat(g2.getVehicles(), is(not(g1.getVehicles())));
		assertThat(g2.getSize(), is(g1.getSize()));
	}

}

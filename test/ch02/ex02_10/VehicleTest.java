package ch02.ex02_10;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class VehicleTest {

	private Vehicle vehicle;

	private BufferedReader reader;

	@Before
	public void setUp() throws Exception {
		PipedInputStream pin = new PipedInputStream();
		reader = new BufferedReader(new InputStreamReader(pin));
		System.setOut(new PrintStream(new PipedOutputStream(pin)));
		vehicle = new Vehicle();
	}

	@Test
	public void testVehicle() {
		assertThat(new Vehicle(), is(notNullValue()));
	}

	@Test
	public void testMain() throws IOException {
		Vehicle.main(null);
		long maxID = new Vehicle().getID();
		long[] ids = { maxID - 3, maxID - 2, maxID - 1 };
		String[] owners = { "null", "owner1", "owner2" };
		int[] speeds = { 0, 100, 50 };
		double[] directions = { 0.0, 1.0, 5.0 };

		for (int i = 0; i < 3; i++) {
			assertThat(reader.readLine(), is("id = " + ids[i]));
			assertThat(reader.readLine(), is("owner = " + owners[i]));
			assertThat(reader.readLine(), is("speed = " + speeds[i]));
			assertThat(reader.readLine(), is("direction = " + directions[i]));
			assertThat(reader.readLine(), is("-----"));
		}
	}

	@Test
	public void testSetDirection1() {
		vehicle.setDirection(0.0);
		assertThat(vehicle.getDirection(), is(0.0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetDirection2() {
		vehicle.setDirection(-0.1);
	}

	@Test
	public void testSetDirection3() {
		double dir = Math.PI * 1.9;
		vehicle.setDirection(dir);
		assertThat(vehicle.getDirection(), is(dir));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetDirection4() {
		vehicle.setDirection(Math.PI * 2);
	}

	@Test
	public void testSetSpeed1() {
		vehicle.setSpeed(1);
		assertThat(vehicle.getSpeed(), is(1));
		vehicle.setSpeed(0);
		assertThat(vehicle.getSpeed(), is(0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetSpeed2() {
		vehicle.setSpeed(-1);
	}

	@Test
	public void testID() {
		Vehicle v1 = new Vehicle();
		Vehicle v2 = new Vehicle();
		assertThat(v1.getID(), is(not(v2.getID())));
	}

	@Test
	public void testOwner() {
		vehicle.setOwner("owner01");
		assertThat(vehicle.getOwner(), is("owner01"));
	}

	@Test
	public void testGetMaxID() {
		Vehicle latest = new Vehicle();
		assertThat(Vehicle.getMaxID(), is(latest.getID()));
	}

	@Test
	public void testToString() {
		String expected = "id = " + vehicle.getID() + "\n" + "owner = " + vehicle.getOwner() + "\n" + "speed = "
				+ vehicle.getSpeed() + "\n" + "direction = " + vehicle.getDirection();
		assertThat(vehicle.toString(), is(expected));
	}
}

package ch02.ex02_18;

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
		vehicle.setDirection(1.0);
	}

	@Test
	public void testVehicle() {
		assertThat(new Vehicle(), is(notNullValue()));
	}

	@Test
	public void testMain1() throws IOException {
		Vehicle.main(new String[] { "argOwner" });
		assertThat(reader.readLine(), is(startsWith("id = ")));
		assertThat(reader.readLine(), is("owner = " + "argOwner"));
		assertThat(reader.readLine(), is("speed = " + 0));
		assertThat(reader.readLine(), is("direction = " + 0.0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMain2() throws IOException {
		Vehicle.main(new String[0]);
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
	public void testChangeSpeed1() {
		vehicle.changeSpeed(1);
		assertThat(vehicle.getSpeed(), is(1));
		vehicle.changeSpeed(0);
		assertThat(vehicle.getSpeed(), is(0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testChangeSpeed2() {
		vehicle.changeSpeed(-1);
	}

	@Test
	public void testStop() {
		vehicle.changeSpeed(100);
		vehicle.stop();
		assertThat(vehicle.getSpeed(), is(0));
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

	@Test
	public void testTurnDoube1() {
		double before = vehicle.getDirection();
		vehicle.turn(2.5);
		assertThat(vehicle.getDirection(), is(before + 2.5));
	}

	@Test
	public void testTurnDouble2() {
		double before = vehicle.getDirection();
		vehicle.turn(4 * Math.PI);
		assertThat(vehicle.getDirection(), is(before));
	}

	@Test
	public void testTurnDouble3() {
		double before = vehicle.getDirection();
		vehicle.turn(-5.0);
		assertThat(vehicle.getDirection(), is(before - 5.0 + 2 * Math.PI));
	}

	@Test
	public void testTurnInt1() {
		double before = vehicle.getDirection();
		vehicle.turn(Vehicle.TURN_LEFT);
		assertThat(vehicle.getDirection(), is(before + Math.PI * 0.5));
	}

	@Test
	public void testTurnInt2() {
		double before = vehicle.getDirection();
		vehicle.turn(Vehicle.TURN_RIGHT);
		assertThat(vehicle.getDirection(), is(before - Math.PI * 0.5 + 2 * Math.PI));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTurnInt3() {
		vehicle.turn(-1);
	}
}

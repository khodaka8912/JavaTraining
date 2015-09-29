package ch03.ex03_04;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PassengerVehicleTest {

	private PassengerVehicle vehicle;

	@Before
	public void setUp() throws Exception {
		vehicle = new PassengerVehicle(0);
	}

	@Test
	public void testPassengerVehicle() {
		PassengerVehicle target = new PassengerVehicle(3);
		assertThat(target.getSeatNum(), is(3));
	}
	
	@Test
	public void testPassengerVehicle2() {
		PassengerVehicle target = new PassengerVehicle("owner", 1);
		assertThat(target.getOwner(), is("owner"));
		assertThat(target.getSeatNum(), is(1));
	}
	
	@Test
	public void testPassengerNum() {
		PassengerVehicle target = new PassengerVehicle(5);
		target.setPassengerNum(2);
		assertThat(target.getPassengerNum(), is(2));		
	}
}
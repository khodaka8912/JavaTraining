package ch04.ex04_01;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class BatteryTest {

	@Test
	public void testEmpty() {
		Battery target = new Battery(1);
		assertThat(target.empty(), is(true));
	}
	
	@Test
	public void testEmpty2() {
		Battery target = new Battery(1);
		target.setBoltage(2);
		assertThat(target.empty(), is(false));
	}
	
	@Test
	public void testBoltage() {
		Battery target = new Battery(1);
		target.setBoltage(2);
		assertThat(target.getBoltage(), is(2));		
	}

	@Test
	public void testBattery() {
		assertThat(new Battery(0), is(notNullValue()));
	}

}

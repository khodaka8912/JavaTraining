package ch04.ex04_01;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class GasTankTest {

	@Test
	public void testEmpty() {
		assertThat(new GasTank().empty(), is(true));
	}
	
	@Test
	public void testEmpty2() {
		GasTank target = new GasTank();
		target.addGas(1);
		assertThat(target.empty(), is(false));
	}

	@Test
	public void testAddGas() {
		GasTank target = new GasTank();
		target.addGas(5);
		assertThat(target.getGas(), is(5));
	}

}

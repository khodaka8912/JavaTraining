package ch01.ex01_14;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WalkmanDuoTest {

	private WalkmanDuo duo;

	@Before
	public void setUp() throws Exception {
		duo = new WalkmanDuo();
	}

	@Test
	public void testWalkmanDuo() {
		assertThat(new WalkmanDuo(), is(instanceOf(Walkman.class)));
	}

	@Test
	public void testPlay1() {
		duo.setTape("tape1");
		assertThat(duo.play(), is(true));
	}

	@Test
	public void testPlay2() {
		duo.setTape(null);
		assertThat(duo.play(), is(false));
	}

	@Test
	public void testSecondEarphone() {
		Object second = new Object();
		duo.setSecondEarphone(second);
		assertThat(duo.getSecondEarphone(), is(second));
	}

}

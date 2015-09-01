package ch01.ex01_14;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WalkmanTest {

	private Walkman walkman;

	@Before
	public void setUp() throws Exception {
		walkman = new Walkman();
	}

	@Test
	public void testWalkman() {
		assertThat(new Walkman(), is(notNullValue()));
	}

	@Test
	public void testPlay1() {
		walkman.setTape("tape1");
		assertThat(walkman.play(), is(true));
	}

	@Test
	public void testPlay2() {
		walkman.setTape(null);
		assertThat(walkman.play(), is(false));
	}

	@Test
	public void testStop() {
		walkman.setTape("tape1");
		walkman.play();
		walkman.stop();
		assertThat(walkman.isPlaying(), is(false));
	}

	@Test
	public void testSerial() {
		Walkman w1 = new Walkman();
		Walkman w2 = new Walkman();
		assertThat(w1.getSerial(), is(not(w2.getSerial())));
	}

	@Test
	public void testTape() {
		Object tape = new Object();
		walkman.setTape(tape);
		assertThat(walkman.getTape(), is(tape));
	}

	@Test
	public void testEarphone() {
		Object earphone = new Object();
		walkman.setEarphone(earphone);
		assertThat(walkman.getEarphone(), is(earphone));
	}

}

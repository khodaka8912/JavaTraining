package ch06.ex06_04;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class SignalColorTest {

	@Test
	public void testSignalColor() {
		assertThat(SignalColor.GREEN.getColor(), is(Color.GREEN));
		assertThat(SignalColor.YELLOW.getColor(), is(Color.YELLOW));
		assertThat(SignalColor.RED.getColor(), is(Color.RED));
	}

}

package ch03.ex03_02;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class XTest {

	@Test
	public void testX() {
		X x = new X();
		assertThat(x.fullMask, is(x.xMask));
	}
	
	@Test
	public void testMask() {
		X x = new X();
		int masked = x.mask(0xf0f0);
		assertThat(masked, is(0x00f0));
	}
}

package ch03.ex03_05;

import static org.junit.Assert.*;

import org.junit.Test;

import jdk.Exported;

public class LoopBenchmarkTest {

	@Test
	public void testMain() {
		LoopBenchmark.main(new String[]{"3", "5"});
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMain2() {
		LoopBenchmark.main(new String[]{"3"});
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMain3() {
		LoopBenchmark.main(new String[]{"3", "5", "7"});
	}
	@Test
	public void testLoopBenchmark() {
		new LoopBenchmark(10);
	}

}

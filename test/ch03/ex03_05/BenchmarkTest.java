package ch03.ex03_05;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class BenchmarkTest {
	
	private int count;

	@Test
	public void testRepeat() {
		count = 0;
		Benchmark b = new Benchmark() {
			@Override
			void benchmark() {
				count++;	
			}			
		};
		b.repeat(100);
		assertThat(count, is(100));
	}

}

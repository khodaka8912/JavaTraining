package ch03.ex03_03;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class YTest {

	@Test
	public void testY() {
		Y y = new Y();
		assertThat(y.fullMask, is(y.xMask | y.yMask));
	}

}

package ch01.ex01_16;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class BadDataSetExceptionTest {

	@Test
	public void testBadDataSetException() {
		IOException cause = new IOException();
		BadDataSetException e = new BadDataSetException("set1", cause);
		assertThat(e, is(notNullValue()));
		assertThat(e.getSetName(), is("set1"));
		assertThat(e.getCause(), is((Throwable) cause));
	}
}

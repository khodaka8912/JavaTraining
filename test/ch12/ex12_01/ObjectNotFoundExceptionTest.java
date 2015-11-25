package ch12.ex12_01;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class ObjectNotFoundExceptionTest {
	
	private Object target = "target";

	@Test
	public void testObjectNotFoundExceptionObject() {
		ObjectNotFoundException e = new ObjectNotFoundException(target);
		assertThat(e.getTarget(), is(target));
		assertThat(e.getMessage(), is(notNullValue()));
	}

	@Test
	public void testObjectNotFoundExceptionObjectString() {
		String message = "not found";
		ObjectNotFoundException e = new ObjectNotFoundException(target, message);
		assertThat(e.getTarget(), is(target));
		assertThat(e.getMessage(), is(message));
	}

	@Test
	public void testObjectNotFoundExceptionObjectThrowable() {
		Throwable cause = new Throwable();
		ObjectNotFoundException e = new ObjectNotFoundException(target, cause);
		assertThat(e.getTarget(), is(target));
		assertThat(e.getMessage(), is(notNullValue()));
		assertThat(e.getCause(), is(cause));
	}

	@Test
	public void testObjectNotFoundExceptionObjectStringThrowable() {
		String message = "not found";
		Throwable cause = new Throwable();
		ObjectNotFoundException e = new ObjectNotFoundException(target, message, cause);
		assertThat(e.getTarget(), is(target));
		assertThat(e.getMessage(), is(message));
		assertThat(e.getCause(), is(cause));
	}

}

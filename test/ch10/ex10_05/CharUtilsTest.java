package ch10.ex10_05;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CharUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetCharsBetween() {
		List<Character> expected = Arrays.asList('c', 'd', 'e', 'f', 'g');
		assertThat(CharUtils.getCharsBetween('c', 'g'), is(expected));
	}

}

package ch10.ex10_03;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DaysTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsWeekDay() {
		assertThat(Days.isWeekDay(Day.MONDAY), is(true));
		assertThat(Days.isWeekDay(Day.FRIDAY), is(true));
		assertThat(Days.isWeekDay(Day.SATURDAY), is(false));
		assertThat(Days.isWeekDay(Day.SUNDAY), is(false));
	}

	@Test
	public void testIsWeekDay2() {
		assertThat(Days.isWeekDay2(Day.MONDAY), is(true));
		assertThat(Days.isWeekDay2(Day.FRIDAY), is(true));
		assertThat(Days.isWeekDay2(Day.SATURDAY), is(false));
		assertThat(Days.isWeekDay2(Day.SUNDAY), is(false));
	}

}

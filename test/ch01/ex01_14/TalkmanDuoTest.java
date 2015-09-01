package ch01.ex01_14;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TalkmanDuoTest {

	private TalkmanDuo talkman;

	@Before
	public void setUp() throws Exception {
		talkman = new TalkmanDuo();
	}

	@Test
	public void testTalkmanDuo() {
		assertThat(new TalkmanDuo(), is(instanceOf(WalkmanDuo.class)));
	}

	@Test
	public void testTalk() {
		talkman.talk();
	}

}

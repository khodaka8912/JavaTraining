package ch24.ex24_01;

import java.util.Locale;

import org.junit.Test;

public class GlobalHelloTest {

	@Test
	public void testDefault() {
		Locale.setDefault(Locale.ROOT);
		System.out.println("-- Default --");
		GlobalHello.main(new String[0]);
		GlobalHello.main(new String[1]);
	}
	
	@Test
	public void testJa() {
		Locale.setDefault(Locale.JAPANESE);
		System.out.println("-- ja --");
		GlobalHello.main(new String[0]);
		GlobalHello.main(new String[1]);
	}
	
	@Test
	public void testZh() {
		Locale.setDefault(Locale.CHINESE);
		System.out.println("-- zh --");
		GlobalHello.main(new String[0]);
		GlobalHello.main(new String[1]);
	}
	
	@Test
	public void testEs() {
		Locale.setDefault(new Locale("es", "ES"));
		System.out.println("-- es --");
		GlobalHello.main(new String[0]);
		GlobalHello.main(new String[1]);
	}

}

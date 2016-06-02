package ch24.ex24_02;

import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class CurrencyViewer {

	private static final List<Locale> LOCALES = Arrays.asList(Locale.JAPAN, Locale.KOREA, Locale.CHINA,
			Locale.FRANCE, Locale.GERMANY, Locale.US);

	private static final List<String> CURRENCY_CODES = Arrays.asList("JPY", "KRW", "CNY", "EUR", "NZD", "USD");

	public static void main(String[] args) {
		LOCALES.forEach(l -> {
			System.out.println(l);
			StringBuilder sb = new StringBuilder();
			CURRENCY_CODES.forEach(c -> {
				sb.append(Currency.getInstance(c).getSymbol(l)).append(" ");
			});
			System.out.println(sb);
		});
	}
}
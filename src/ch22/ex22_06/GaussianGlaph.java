package ch22.ex22_06;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GaussianGlaph {
	
	private static final double HISTOGRAM_SIZE = 0.1;
	private static final double GLAPH_MIN = -3.0;
	private static final double GLAPH_MAX = 3.0;
	
	public static void showGlaph(long iterateNum) {
		Random r = new Random();
		Map<Integer, Integer> histogram = new HashMap<>();
		for (long i = 0; i < iterateNum; i++) {
			double d = r.nextGaussian();
			int index = (int) Math.round(d / HISTOGRAM_SIZE);
			Integer count = histogram.get(index);
			if (count == null) {
				count = 0;
			}
			histogram.put(index, count + 1);
		}
		int index_min = (int) (GLAPH_MIN / HISTOGRAM_SIZE);
		int index_max = (int) (GLAPH_MAX / HISTOGRAM_SIZE);
		for (int i = index_min; i <= index_max; i++) {
			Integer count = histogram.get(i);
			StringBuilder sb = new StringBuilder().append(String.format("%.1f ", i * HISTOGRAM_SIZE));
			if (count == null) {
				count = 0;
			}
			for (int j = 0; j < count; j++) {
				sb.append("*");
			}
			System.out.println(sb);
		}
	}
	
	public static void main(String[] args) {
		showGlaph(10000);
	}

}

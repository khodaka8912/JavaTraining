package ch22.ex22_05;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GaussianGlaph {
	
	private static final double HISTOGRAM_SIZE = 0.01;
	
	public static void showGlaph(long iterateNum) {
		Random r = new Random();
		Map<Integer, Integer> histogram = new HashMap<>();
		for (long i = 0; i < iterateNum; i++) {
			double d = r.nextGaussian();
			int index = (int)(d / HISTOGRAM_SIZE);
			Integer count = histogram.get(index);
			if (count == null) {
				count = 0;
			}
			histogram.put(index, count + 1);
		}
		for (int i = 0; i < 1.0 / HISTOGRAM_SIZE; i++) {
			Integer count = histogram.get(i);
			if (count == null) {
				count = 0;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
	}

}

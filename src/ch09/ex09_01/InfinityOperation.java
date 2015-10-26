package ch09.ex09_01;

class InfinityOperation {
	static final double P = Double.POSITIVE_INFINITY;
	static final double N = Double.NEGATIVE_INFINITY;

	public static void main(String[] args) {
		System.out.println("+∞　+ +∞ = " + (P + P));
		System.out.println("+∞　+ -∞ = " + (P + N));
		System.out.println("-∞　+ -∞ = " + (N + N));
		System.out.println("+∞　- +∞ = " + (P - P));
		System.out.println("+∞　- -∞ = " + (P - N));
		System.out.println("-∞　- +∞ = " + (N - P));
		System.out.println("-∞　- -∞ = " + (N - N));
		System.out.println("+∞　* +∞ = " + (P * P));
		System.out.println("+∞　* -∞ = " + (P * N));
		System.out.println("-∞　* -∞ = " + (N * N));
		System.out.println("+∞　/ +∞ = " + (P / P));
		System.out.println("+∞　/ -∞ = " + (P / N));
		System.out.println("-∞　/ +∞ = " + (N / P));
		System.out.println("-∞　/ -∞ = " + (N / N));
	}
}

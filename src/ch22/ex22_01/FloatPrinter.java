package ch22.ex22_01;

public class FloatPrinter {
	private static final int LINE_WIDTH = 80;

	public static void showFloats(float[] floats, int cols) {
		if (cols > 8) {
			cols = 8;
		}
		int width = LINE_WIDTH / cols;
		int count = 0;
		for (float f : floats) {
			System.out.printf("%1$ " + width + ".4g", f);
			count++;
			if (count == cols) {
				System.out.println();
				count = 0;
			}
		}
	}

	public static void main(String[] args) {
		showFloats(new float[] { 3.515f, 1092f, 897.33f, -111f, -1.0839f, 0.0387f, 22.9892f, 3.515f,
				-1092f, 897.33f, 111f, 128037219837f, 1.0839f, -0.0387f, 22.9892f }, 5);
	}
}

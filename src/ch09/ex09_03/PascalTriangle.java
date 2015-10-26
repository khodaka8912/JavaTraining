package ch09.ex09_03;

/**
 * パスカルの三角形
 * 
 * @author hwatanabe
 *
 */
public class PascalTriangle {
	/** デフォルトの段数 */
	private static final int DEFAULT_DEPTH = 12;

	private final int[][] triangle;

	/**
	 * パスカルの三角形を生成する。
	 * 
	 * @param depth
	 *            段数
	 */
	public PascalTriangle(int depth) {
		triangle = new int[depth][];
		for (int i = 0; i < depth; i++) {
			int[] row = new int[i + 1];
			for (int j = 0; j < row.length; j++) {
				row[j] = (j == 0 || j == i) ? 1 : triangle[i - 1][j - 1] + triangle[i - 1][j];
			}
			triangle[i] = row;
		}
	}

	/**
	 * デフォルトの段数でパスカルの三角形を生成する。
	 */
	public PascalTriangle() {
		this(DEFAULT_DEPTH);
	}

	/**
	 * パスカルの三角形を整形して表示する。
	 */
	public void show() {
		int[] bottom = triangle[triangle.length - 1];
		int maxLength = Integer.toString(bottom[bottom.length / 2]).length();
		StringBuilder sb;
		for (int[] row : triangle) {
			sb = new StringBuilder();
			int indentNum = (triangle.length - row.length) * (maxLength + 1) / 2;
			if (indentNum != 0) {
				sb.append(String.format("%" + indentNum + "s", ""));
			}
			for (int num : row) {
				sb.append(String.format("%1$" + maxLength + "d ", num));
			}
			System.out.println(sb);
		}
	}

	public int[][] getTriangle() {
		return triangle;
	}

	public static void main(String[] args) {
		PascalTriangle pt = new PascalTriangle(20);
		// PascalTriangle pt = new PascalTriangle(20);
		pt.show();
	}
}

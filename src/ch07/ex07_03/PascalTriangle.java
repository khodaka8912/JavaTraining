package ch07.ex07_03;

public class PascalTriangle {
	
	private static int defaultDepth = 12;
	
	public static int[][] makeTriangle(int depth) {
		int[][] triangle = new int[depth][];
		for (int i = 0; i < depth; i++) {
			int[] row = new int[i + 1];
			for (int j = 0; j < row.length; j++) {
				if (j == 0 || j == row.length - 1) {
					row[j] = 1;
				} else {
					row[j] = triangle[i-1][j-1] + triangle[i-1][j];
				}
			}
			triangle[i] = row;
		}
		return triangle;
	}
	
	public static int[][] makeTriangle() {
		return makeTriangle(defaultDepth);
	}

	public static void showIntMatrix(int[][] matrix) {
		StringBuilder sb;
		for (int i = 0; i < matrix.length; i++) {
			sb = new StringBuilder();
			int spaceNum = matrix.length - i;
			for (int j = 0; j < spaceNum; j++) {
				sb.append(" ");
			}
			for (int num : matrix[i]) {
				sb.append(num).append(" ");
			}
			System.out.println(sb);
		}
	}
	
	public static void main(String[] args) {
		int[][] triangle = makeTriangle();
		showIntMatrix(triangle);
	}
}

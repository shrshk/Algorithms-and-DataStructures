package leetcode30DayChallenge.may;

public class PossibleTriangles {
	public int countTriangles(int[] x, int[] y) {
		int[][] points = new int[x.length][y.length];

		for (int i = 0; i < x.length; i++) {
			points[i] = new int[] { x[i], y[i] };
		}

		return countPoints(points, points.length);

	}

	private boolean isPossible(int x1, int y1, int x2, int y2, int x3, int y3) {
		int det = ((x2 - x1) * (y3 - y1)) - (y2 - y1) * (x3 - x1);
		return Math.abs(det) != 0;
	}

	private int countPoints(int[][] Point, int n) {
		int result = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				for (int k = j + 1; k < n; k++) {
					boolean isPossible = isPossible(Point[i][0], Point[i][1], Point[j][0], Point[j][1], Point[k][0],
							Point[k][1]);
					if (isPossible) {
						result = result + 1;
					}
				}

		return result;
	}

	public static void main(String[] args) {
		int[] x = new int[] { 0, 0, 1, 1 };
		int[] y = new int[] { 0, 1, 1, 0 };
		System.out.println(new PossibleTriangles().countTriangles(x, y));
	}
}

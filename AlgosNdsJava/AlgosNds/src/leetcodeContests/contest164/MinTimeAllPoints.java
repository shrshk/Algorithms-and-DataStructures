package leetcodeContests.contest164;

public class MinTimeAllPoints {
	public int minTimeToVisitAllPoints(int[][] points) {
		int res = 0;
		for (int i = 1; i < points.length; i++) {
			int[] curr = points[i];
			int[] prev = points[i - 1];
			int xDist = Math.abs(curr[0] - prev[0]);
			int yDist = Math.abs(curr[1] - prev[1]);
			res += Math.max(xDist, yDist);
		}

		return res;
	}

	public static void main(String[] args) {
		// [[1,1],[3,4],[-1,0]]
		System.out
				.println(new MinTimeAllPoints().minTimeToVisitAllPoints(new int[][] { { 1, 1 }, { 3, 4 }, { -1, 0 } }));
	}
}

package coinbasePrep;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class UniquePaths2 {
	// bfs doesn't work as obstacles block going to some nodes.
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// 0,0 0,1
		Set<int[]> allCoordinates = new HashSet<>();
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] != 1)
					allCoordinates.add(new int[] { i, j });
			}
		}

		//

		return 0;
	}
	
	public int uniquePathsWithObstaclesDP(int[][] obstacleGrid) {
	    int width = obstacleGrid[0].length;
	    int[] dp = new int[width];
	    dp[0] = 1;
	    for (int[] row : obstacleGrid) {
	        for (int j = 0; j < width; j++) {
	            if (row[j] == 1)
	                dp[j] = 0;
	            else if (j > 0)
	                dp[j] += dp[j - 1];
	        }
	    }
	    return dp[width - 1];
	}

	public static void printAllPaths(LinkedList<Integer>[] list, int src, int dest) {
		Queue<LinkedList<Integer>> paths = new LinkedList<>();
		Queue<Integer> path = new LinkedList<>();
		path.add(src);
		paths.add((LinkedList<Integer>) path);

		while (!paths.isEmpty()) {
			LinkedList<Integer> currPath = paths.poll();
			int i = currPath.get(currPath.size() - 1);

			if (i == dest) {
				printPath(currPath);
			}
			for (Integer x : list[i]) {
				if (!isVisited(currPath, x)) {
					LinkedList<Integer> newPath = new LinkedList<>(currPath);
					newPath.add(x);
					paths.add(newPath);
				}
			}

		}
	}

	private static void printPath(LinkedList<Integer> currPath) {

		System.out.println(currPath.toString());
	}

	private static boolean isVisited(LinkedList<Integer> currPath, Integer x) {

		for (Integer i : currPath) {
			if (i == x)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] obstacleGrid = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		System.out.println(new UniquePaths2().uniquePathsWithObstacles(obstacleGrid));
	}
}

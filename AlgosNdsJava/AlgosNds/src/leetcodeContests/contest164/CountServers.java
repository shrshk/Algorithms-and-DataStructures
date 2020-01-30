package leetcodeContests.contest164;

import java.util.ArrayDeque;
import java.util.Queue;

public class CountServers {
	public int countServerss(int[][] grid) {
		// steps
		// for every server call bfs maintain a visited grid
		// try and hit a non visited server, if hit count servers and itself
		int m = grid.length;
		int n = grid[0].length;
		int count = 0;
		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				count = bfs(new int[] { i, j }, grid, visited, count, m, n);
					
			}
		}

		return count;
	}
	
	public int countServers(int[][] grid) {
		int m = grid.length;
        int n = grid[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        int total=0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j]==1) {
                    rowCount[i]++;
                    colCount[j]++;
                    total++;
                }
            }
        }
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j]==1) {
                    if(rowCount[i]==1 && colCount[j]==1) {
                        total--;
                    }
                }
            }
        }
        
        return total;
        
	}

	private int bfs(int[] loc, int[][] grid, boolean[][] visited, int count, int m, int n) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(loc);
		int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		int tempCount = 0;
		while (!q.isEmpty()) {
			int[] current = q.poll();
			int currX = current[0];
			int currY = current[1];
			if (visited[currX][currY])
				continue;
			visited[currX][currY] = true;
			for (int[] dir : dirs) {
				int x = currX + dir[0];
				int y = currY + dir[1];

				if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y]) {
					if (grid[x][y] == 1) {
						q.add(new int[]{x,y});
						tempCount++;
					} else {
						visited[x][y] = true;
					}
					
				}

			}

		}

		if (tempCount > 0) {
			count = count + tempCount + 1;
		}
		
		return count;

	}

	public static void main(String[] args) {
		// [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
		// [[1,0,0,1,0],[0,0,0,0,0],[0,0,0,1,0]]
		System.out.println(new CountServers()
				.countServers(new int[][] { { 1, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } }));
//		System.out.println(new CountServers()
//				.countServers(new int[][] { { 1, 0 }, { 1, 1}}));
	}
}

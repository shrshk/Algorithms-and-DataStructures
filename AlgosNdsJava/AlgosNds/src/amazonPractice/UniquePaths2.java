package amazonPractice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class UniquePaths2 {
	
	// not working 
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // run bfs 
        // avoid obstacles
        // everytime dest is reached inc count
        // return once all vertices are explored 
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});
        int count = 0;
        int[][] dirs = new int[][]{{0,1},{1,0}};
        if (m==1 && n==1) {
        	count = obstacleGrid[0][0] == 1 ? 0 : 1;
        	return count;
        }        	
        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int currentX = cell[0];
            int currentY = cell[1];      

            for (int[] dir: dirs) {
                int x = currentX + dir[0];
                int y = currentY + dir[1];                             
                
                if (obstacleGrid[currentX][currentY] == 1 || x<0 || y<0 || x>=m || y>=n || obstacleGrid[x][y] == 1 || visited[x][y])
                    continue;
                if (x==m-1 && y==n-1) {
                	count++;
                } else {
                	visited[x][y] = true;
                }                    
                
                q.add(new int[]{x,y});
                
            }
        }
        
        return count;
        
    }
	
	public static void main(String[] args) {
		int[][] obstacleGrid = new int[3][3];
		for (int[] x: obstacleGrid)
			Arrays.fill(x, 0);
		obstacleGrid[1][1] = 1;
		int[][] oneElementZero = new int[][]{{1}};
		int[][] oneElementOne = new int[][]{{1,0}};
		// System.out.println(new UniquePaths2().uniquePathsWithObstacles(obstacleGrid));
		System.out.println(new UniquePaths2().uniquePathsWithObstacles(oneElementOne));
		
	}
	
}

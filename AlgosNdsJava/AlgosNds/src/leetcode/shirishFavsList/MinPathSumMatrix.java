package leetcode.shirishFavsList;

public class MinPathSumMatrix {
	// static int minSumPath()
	// Assume we can only move either down or right at any point in time
    private final int[][] dirs = {{0, 1}, {1, 0}};
    private Integer[][] memo;
    
    public int minPathSum(int[][] grid) {
        memo = new Integer[grid.length][grid[0].length];
        return minPathSumFrom(grid, 0, 0);
    }
    
    private int minPathSumFrom(int[][] grid, int x, int y) {
        if (x == grid.length - 1 && y == grid[0].length - 1){
            return grid[x][y];
        } else {
            if (memo[x][y] != null)
                return memo[x][y];
            
            int min = Integer.MAX_VALUE;
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < grid.length && ny < grid[0].length) {
                    min = Math.min(grid[x][y] + minPathSumFrom(grid, nx, ny), min);
                }
            }
            
            memo[x][y] = min;
            return min;
        }
    }
}

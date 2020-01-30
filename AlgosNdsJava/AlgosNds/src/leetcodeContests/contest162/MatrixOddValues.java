package leetcodeContests.contest162;

public class MatrixOddValues {
	public int oddCells(int n, int m, int[][] indices) {
		int result = 0;
		
		int[][] grid = new int[n][m];
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				grid[i][j] = 0;
			}
		}
		
		for (int[] index: indices) {
			int x = index[0];
			int y = index[1];
			for (int j=0; j<m; j++) {
				grid[x][j] = grid[x][j]+1;				
			}
			for (int i=0; i<n;i++) {
				grid[i][y] = grid[i][y] + 1;
			}
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (grid[i][j]%2!=0)
					result++;
			}
		}		
		
		return result;
	}
	
	public static void main(String[] args) {
//		int n = 2, m = 3; // [[0,1],[1,1]]
//	    int[][] indices = new int[][]{{0,1},{1,1}};
		int n = 2, m = 2; // [[0,1],[1,1]]
	    int[][] indices = new int[][]{{1,1},{0,0}};
		System.out.println(new MatrixOddValues().oddCells(n,m,indices));
	}
	
}

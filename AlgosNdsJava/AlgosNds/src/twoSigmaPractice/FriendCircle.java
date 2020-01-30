package twoSigmaPractice;

import java.util.ArrayDeque;
import java.util.Queue;

public class FriendCircle {
	public int findCircleNum(int[][] M) {
        // total no. of friend circles
        // steps
        // have a boolean matrix for visited nodes
        // every bfs call update total (conn. comps)
        int count = 0;
        int m = M.length;
        int n = M[0].length;
        boolean [][] visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            if (!visited[i][i]) {
                count++;
                bfs(visited, M, i);
            }
        }
        return count;
    }
    
    private void bfs(boolean[][] visited, int[][] M, int friend) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(friend);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
               int j = q.poll();
                visited[j][j] = true;
               for (int k=0; k<M[0].length; k++) {
                   if (!visited[k][k] && M[j][k]==1)
                       q.add(k);
               }
            }
        }
    }
    
    public static void main(String[] args) {
    	// [[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
    	int[][] M = new int[][]{
    		{1,0,0,1},
    		{0,1,1,0},
    		{0,1,1,1},
    		{1,0,1,1}};
		System.out.println(new FriendCircle().findCircleNum(M));
	}
}

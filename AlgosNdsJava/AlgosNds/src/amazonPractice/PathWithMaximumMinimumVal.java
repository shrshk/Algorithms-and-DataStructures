package amazonPractice;

import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMaximumMinimumVal {
	
	public int maximumMinimumPath(int[][] A) {
        // steps
        // keep track of visited cells in an other grid
        // add the cells in the Max. path to a queue
        // use pq for q implementation to keep max. val seen so far on top.
        // in pq place a val. which is min(pathStart, currentNode)
        // since we visit the nodes in minMax order we won't visit the nodes
        // not in the max. path.
        
        int m = A.length;
        int n = A[0].length;
        Queue<int[]> pq = new PriorityQueue<>((a,b)->(b[2]-a[2]));
        boolean[][] visited = new boolean[m][n];
        pq.add(new int[]{0,0,A[0][0]});
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentX = current[0];
            int currentY = current[1];
            if (currentX == m-1 && currentY == n-1)
                return current[2];
            visited[currentX][currentY] = true;
            // if current is end of matrix return            
            for (int[] dir: dirs) {
                int x = currentX + dir[0];
                int y = currentY + dir[1];
                if (x<0 || y<0 || x>=m || y>=n || visited[x][y])
                    continue;
                pq.add(new int[]{x,y,Math.min(A[x][y],current[2])});
            }
        }
        
        return -1;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

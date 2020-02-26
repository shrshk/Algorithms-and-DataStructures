package golmansachs.practice;

import java.util.LinkedList;
import java.util.Queue;

class Move {
	int x;
	int y;
	double p;

	Move(int x, int y, double p) {
		this.x = x;
		this.y = y;
		this.p = p;
	}
}

public class KnightProbability {
	public double knightProbability(int N, int K, int r, int c) {
		int[][] dirs = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        int level = K;
        while (level-- > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir: dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x >= 0 && x < N && y >= 0 && y < N) {
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        double prob = queue.size();
        for (int i = 0; i < K; i++) {
            prob = prob / 8;
        }
        return prob;
	}

	public static void main(String[] args) {
		System.out.println(new KnightProbability().knightProbability(3, 2, 0, 0));
	}
}

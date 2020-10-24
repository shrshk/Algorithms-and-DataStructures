package leetcode30DayChallenge.september;

import java.util.Arrays;

public class RoboCircle {
	public boolean isRobotBounded(String instructions) {
		int[] cur = new int[] { 0, 0 };
		int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		int dir = 0; // 0:north(up), 1: right, 2: down, 3: left

		for (char in : instructions.toCharArray()) {
			if (in == 'G') {
				cur[0] += dirs[dir][0];
				cur[1] += dirs[dir][1];
				System.out.println(Arrays.toString(cur));
			} else if (in == 'L') {
				dir = (dir + 3) % 4;
			} else {
				dir = (dir + 1) % 4;
			}
		}
		
		if (cur[0] == 0 && cur[1] == 0) { // ended up at the same place
			return true;
		}
		if (dir == 0 && !(cur[0] == 0 && cur[1] == 0)) { // if the direction is
															// north and
															// location has
															// changed
			return false;
		}
		return true; // it is always true
	}
	
	public static void main(String[] args) {
		System.out.println(new RoboCircle().isRobotBounded("GLGLGGLGL"));
	}
}
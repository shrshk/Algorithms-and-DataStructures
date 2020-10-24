package twilioPrep;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class CourseSchedule3 {
	public int scheduleCourse(int[][] courses) {
		// [[100, 200], [1000, 1250], [200, 1300], [2000, 3200]]
		// Arrays.sort(courses, new Comparator<int[]>() {
		// public int compare(int[] a, int[] b) {
		// return a[1] - b[1];
		// }
		// });
		Arrays.sort(courses, (a, b) -> (a[1] - b[1]));
		Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
		int time = 0;
		for (int[] course : courses) {
			pq.add(course[0]);
			time += course[0];
			if (time > course[1])
				time -= pq.poll();
		}

		return pq.size();

	}
	
    public int maxProduct(int[] nums) {
        // ab-(a+b)+1

        return (nums[0]-1) * (nums[1]-1);
    }
}

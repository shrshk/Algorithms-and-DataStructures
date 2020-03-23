package leetcodeContests.contest180;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumTeamPerformance {
	public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = (int) (1e9 + 7);
        int[][] engineers = new int[n][2];
        for (int i=0; i<n; i++) {
            engineers[i][0] = speed[i];
            engineers[i][1] = efficiency[i];            
        }
        
        Arrays.sort(engineers, (a, b) -> (b[1]-a[1]));
        long res = Long.MIN_VALUE, totalSpeed = 0;
        Queue<Integer> pq = new PriorityQueue<>(k);
        
        for (int[] engineer: engineers) {
            int currSpeed = engineer[0];
            int currEfficiency = engineer[1];
            if (pq.size()==k)
                totalSpeed-=pq.poll();
            pq.add(currSpeed);
            totalSpeed+=currSpeed;
            res = Math.max(res, totalSpeed * currEfficiency);
        }
        
        return (int) (res%MOD);
        
    }
	
	public static void main(String[] args) {
		int[] speed = new int[]{2,10,3,1,5,8};
		int[] efficiency = new int[]{5,4,3,9,7,2};
		System.out.println(new MaximumTeamPerformance().maxPerformance(6, speed, efficiency, 2));
	}
}

















//Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//@Override
//public int compare(int[] a1, int[] a2) {
//	if (a1[0] != a2[0])
//		return a2[0] - a1[0];
//	return a1[1] - a1[1];
//}
//
//});
//
//for (int i=0; i<n; i++) {
//pq.add(new int[]{speed[i], efficiency[i]});
//}
//
//while (!pq.isEmpty()) {
//int speedCount = 0;
//int minEff = Integer.MAX_VALUE;
//for (int i=0; i<k; i++) {
//	int[] member = pq.poll();
//	speedCount+=member[0];
//	minEff = Math.min(minEff, member[1]);
//}
//maxPerformance = speedCount * minEff;
//}
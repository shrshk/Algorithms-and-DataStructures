package leetcodeContests.contest208;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaxProfitOperatingWheel {
	public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {

		Queue<Integer> pq = new PriorityQueue<Integer>((a,b) -> (b-a));
		for (int cust: customers) {
			pq.add(cust);
		}
		
		int profit = 0;
		int currShift = 1;
		int minShifts = -1;
		int totalPeople = 0;
		
		// [10,9,6]
		// 9,6,6
		// 6,6,5
		// 6,5,2
		// 5,2,2
		// 2,2,1
		// 
		
		while(!pq.isEmpty()) {
			// [4,3] 5 6
			int people = pq.poll();
			while (people < 4 && !pq.isEmpty()) {
				people+=pq.poll();
			}
			int curr = Math.min(people, 4);
			totalPeople+=curr; // 11
			int currProfit = totalPeople*boardingCost - currShift * runningCost;
			System.out.println(currProfit);
			if (currProfit>profit) {
				profit = currProfit; // 55 - 18
				minShifts = currShift; // 2
			}
			currShift++; // 3
			int left = people - curr; //4
			if (left>0)
				pq.add(left);
		}
		
		return minShifts;
	}
	
	public static void main(String[] args) {
		
		System.out.println(new MaxProfitOperatingWheel().minOperationsMaxProfit(new int[]{10,9,6}, 6, 4));
	}
}

package facebookPrep.sortingAndSearching;

import java.util.Arrays;

public class MeetingRooms {
	public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        
        for (int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int endIdx = 0;
        int res = 0;
        
        for (int i=0; i<starts.length; i++) {
            if (starts[i]<ends[endIdx])
                res++;
            else
                endIdx++;
        }
        
        return res;       
        
    }
	
	public static void main(String[] args) {
		// [0, 30],[5, 10],[15, 20]
		System.out.println(new MeetingRooms().minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}}));
	}
}
/*
 * 
 * 
 * 
 * [[0, 30],[5, 10],[15, 20]]
 * 
 * [0,5,10,15,20,30]
 * 
 * 0 5 15
 *            10 15 30            1+1
 *                                2,1
 * 
 * 
 * 
 * 
 * 
 * 
 * */
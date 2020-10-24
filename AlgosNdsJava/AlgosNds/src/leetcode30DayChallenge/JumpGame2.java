package leetcode30DayChallenge;

public class JumpGame2 {
    public int jump(int[] nums) {
        // steps
        // bfs
        // currMax to keep track of the max idx you can reach in a level
        // keep updating farthest to track the currMax you can reach in next level
        // if you can reach the end in next level return level+1
        // else level++ and update the currMax with farthest
        
        if (nums.length<=1)
            return 0;
        
        int i=0, currMax=0, level=0;
        
        while(i<=currMax) {
            int farthest = currMax;
            while (i<=currMax) {
                farthest = Math.max(farthest, i+nums[i]);
                if (farthest>=nums.length-1)
                    return level+1;
                i++;
            }
            level++;
            currMax = farthest;
        }
        
        return -1;       
    }
    
    public static void main(String[] args) {
		System.out.println(new JumpGame2().jump(new int[]{2,3,1,4}));
	}
}

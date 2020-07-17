package leetcode30DayChallenge;

public class JumpGame {
    public boolean canJump(int[] nums) {
        // 3 2 1 0 4 // 0
       int distance = 0;
       for (int i=0; i<=distance; i++) {
           distance = Math.max(distance, i+nums[i]);
           if (distance >=nums.length-1)
               return true;
       }
        
       return false;        
    }
    
    public static void main(String[] args) {
		System.out.println(new JumpGame().canJump(new int[]{2,3,1,1,4}));
	}
}

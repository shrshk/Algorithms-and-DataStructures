package leetcode30DayChallenge;

import java.util.HashMap;
import java.util.Map;

public class MaxLengthContiguousArray {
    public int findMaxLength(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            if (nums[i]==0)
                nums[i]=-1;
        }        
        int sum=0, max=0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int i=0; i<nums.length; i++) {
             sum+=nums[i];
             if (map.containsKey(sum)) {
                 max = Math.max(max, i - map.get(sum));
                 continue;
             }
            map.put(sum, i);
        }
        return max;
    }
}

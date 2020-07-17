package leetcode30DayChallenge.may;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num,0)+1);
            if (map.get(num)>n/2)
                return num;
        }
        
        return -1;
    }
    
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num; // [2,2,1,1,1,2,2] 2 0
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}

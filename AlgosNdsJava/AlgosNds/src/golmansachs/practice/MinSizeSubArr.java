package golmansachs.practice;

public class MinSizeSubArr {
	public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int i=0, j=0;
        int minLen = n;
        while(i<n) {
            int count=0;
            while(j<n && count<s) {
                count+=nums[j++];                
            }            
            if (count<s && j-i==n) {
                minLen=0;
            } else if (count>s && j-i<n) {
                minLen = Math.min(minLen, j-i);
            }else if (count==s) {
                minLen = Math.min(minLen, j-i);
            }
            i++;
            j=i;
        }
        
        return minLen;
        
    }
}

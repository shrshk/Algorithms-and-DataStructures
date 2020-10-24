package leetcodeContests.contest179;

public class MomentBulbs {
//    public int numTimesAllBlue(int[] light) {
//         // [2,1,3,5,4]
//    	int[] bulbs = new int[light.length+1];
//    	int count = 0; 
//    	for (int i=0; i<light.length; i++) {
//    		bulbs[light[i]] = light[i] == 1 ? 2 : 1;
//    		if (isBlue(bulbs, light[i]))
//    			count++;
//    	}
//    	return count;
//    }
//    
//    private boolean isBlue(int[] bulbs, int index) {
//    	for (int i=1; i<=index; i++) {
//    		if (bulbs[i]==2) {
//    			while (i+1<=index) {
//    				if (bulbs[i+1]==1) {
//    					bulbs[++i] = 2;
//    				}else if (bulbs[i+1]==2) {
//    					i++;
//    				} else {
//    					return false;
//    				}
//    			}
//    		} else {
//    			return false;
//    		}
//    	}
//    	return true;
//    }
	
    public int numTimesAllBlue(int[] A) {
        int right = 0, res = 0, n = A.length;
        for (int i = 0; i < n; ++i) {
            right = Math.max(right, A[i]);
            if (right == i + 1) ++res;
        }
        return res;
    }
    
    public int numTimesAllBlueMath(int[] light) {
        // steps res++ when we hit all continuous nums
        long currSum = 0;
        int currMax = 0, ans=0;
        for (int i=0; i<light.length; i++) {
            currMax = Math.max(currMax, light[i]);
            currSum+=(long)light[i];
            if(currSum == ((long)currMax * (currMax + 1)) / 2)
                ans++;
        }
        return ans;
    }
    
	public static void main(String[] args) {
		int[] light = new int[]{3,2,4,1,5}; // 0,,0,0,0
		System.out.println(new MomentBulbs().numTimesAllBlue(light));
	}
}

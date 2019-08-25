package leetcode.shirishFavsList;

public class SquareRoot {
	static int sqrt(int x) {
		int a = x;
		if (a<0)
			return -1;
		if(a==0 || a==1)
			return 1;
		
		int start = 0;
		int end = a;
		if (a<1)
			end = 1;
		
		// double precision = 0.0001;
		while(end > start){
			int mid = (start+end)/2;
			int midSqr = mid * mid;
			if (midSqr == a)
				return mid;
			else if (midSqr < a)
				start = mid;
			else
				end = mid;
		}
		
		return (start+end)/2;
		
	}
	
	static int mySqrtt(int x) {
	    if(x <= 1) return x;
	    int left = 1, right = x;
	    while(left < right) {
	        int mid = left + (right - left) / 2;
	        if(mid <= x / mid) {
	            left = mid + 1;
	        } else {
	            right = mid;
	        }
	    }
	    return left - 1;
	}
	
	static int mySqrt(int x) {
		if (x == 0) return 0;
		int start = 1, end = x;
		while (start < end) { 
			int mid = start + (end - start) / 2;
			if (mid <= x / mid && (mid + 1) > x / (mid + 1))// Found the result
				return mid; 
			else if (mid > x / mid)// Keep checking the left part
				end = mid;
			else
				start = mid + 1;// Keep checking the right part
		}
		return start;
	}
	
	public static int floorSqrt(int x) {
        // Base Cases 
        if (x == 0 || x == 1) 
            return x; 
  
        // Do Binary Search for floor(sqrt(x)) 
        int start = 1, end = x, ans=0; 
        while (start <= end) { 
            int mid = (start + end) / 2; 
  
            // If x is a perfect square 
            if (mid*mid == x) 
                return mid; 
  
            // Since we need floor, we update answer when mid*mid is 
            // smaller than x, and move closer to sqrt(x) 
            if (mid*mid < x) { 
                start = mid + 1; 
                ans = mid; 
            } 
            else   // If mid*mid is greater than x 
                end = mid-1; 
        } 
        return ans; 
    } 
	
	public static void main(String[] args) {
		System.out.println(floorSqrt(25));
	}
}

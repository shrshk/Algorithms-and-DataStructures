package leetcodeContests.contest161;

public class MinSwapsEqualStrings {
	public int minimumSwap(String s1, String s2) {
        int x1 = 0; // 'x' in s1 (skip equal chars at same index)
		int y1 = 0; // 'y' in s1 (skip equal chars at same index)
		int x2 = 0; // 'x' in s2 (skip equal chars at same index)
		int y2 = 0; // 'y' in s2 (skip equal chars at same index)

        for(int i = 0; i < s1.length(); i ++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1 == c2){ // skip chars that are equal at the same index in s1 and s2
                continue;
            }
            if(c1 == 'x'){
                x1 ++;
            }else{
                y1 ++;
            }
            if(c2 == 'x'){
                x2 ++;
            }else{
                y2 ++;
            }
        } // end for
        
        // After skip "c1 == c2", check the number of  'x' and 'y' left in s1 and s2.
        if((x1 + x2) % 2 != 0 || (y1 + y2) % 2 != 0){
            return -1;
        }
        
        int swaps = x1 / 2 + y1 / 2;
        if (x1%2!=0)
        	swaps+=2;
        // Cases to do 1 swap:
        // "xx" "xxxx" "xxxxxx", ... => x1 / 2
        // "yy" "yyyy" "yyyyyy", ... => y1 / 2
        // 
        // Cases to do 2 swaps:
        // "xy" or "yx" =>  x1 % 2
                 
        return swaps;        
    } 
	    
	public static void main(String[] args) {
		System.out.println(new MinSwapsEqualStrings().minimumSwap("xyxy", "yxyx"));// 1 xyxy yxyx
		System.out.println(1%2 * 2);
	}
}

///*
// * 	 public int minOps(String A, String B) 
//	    { 
//	          
//	        // This parts checks whether conversion is 
//	        // possible or not 
//	        if(A.length() != B.length()) 
//	            return -1; 
//	          
//	        int i, j, res = 0; 
//	        int count [] = new int [256]; 
//	          
//	        // count characters in A 
//	          
//	        // subtract count for every character in B 
//	        for(i = 0; i < A.length(); i++) 
//	        { 
//	            count[A.charAt(i)]++; 
//	            count[B.charAt(i)]--; 
//	        } 
//	          
//	        // Check if all counts become 0 
//	        for(i = 0; i < 256; i++) 
//	            if(count[i] != 0) 
//	                return -1; 
//	          
//	        i = A.length() - 1; 
//	        j = B.length() - 1; 
//	  
//	        while(i >= 0) 
//	        { 
//	            // If there is a mismatch, then  
//	            // keep incrementing result 'res' 
//	            // until B[j] is not found in A[0..i] 
//	            if(A.charAt(i) != B.charAt(j)) 
//	                res++; 
//	            else
//	                j--; 
//	            i--;          
//	        } 
//	        return res;      
//	    } 
//	 static boolean isAnagram(String s1, String s2) 
//	 { 
//	     s1 = sortString(s1); 
//	     s2 = sortString(s2); 
//	     return (s1.equals(s2)); 
//	 } 
//	   
//	 // Method to sort a string alphabetically  
//	 public static String sortString(String inputString)  
//	 {  
//	     // convert input string to char array  
//	     char tempArray[] = inputString.toCharArray();  
//	       
//	     // sort tempArray  
//	     Arrays.sort(tempArray);  
//	       
//	     // return new sorted string  
//	     return new String(tempArray);  
//	 }  
//	   
//	 // Function to return the minimum swaps required 
//	 public int countSteps(char []s1, char[] s2, int size) 
//	 { 
//	     int i = 0, j = 0; 
//	     int result = 0; 
//	   
//	     // Iterate over the first string and convert 
//	     // every element equal to the second string 
//	     while (i < size) 
//	     { 
//	         j = i; 
//	   
//	         // Find index element of first string which 
//	         // is equal to the ith element of second string 
//	         while (s1[j] != s2[i]) 
//	         { 
//	             j += 1; 
//	         } 
//	   
//	         // Swap adjacent elements in first string so 
//	         // that element at ith position becomes equal 
//	         while (i < j) 
//	         { 
//	   
//	             // Swap elements using temporary variable 
//	             char temp = s1[j]; 
//	             s1[j] = s1[j - 1]; 
//	             s1[j - 1] = temp; 
//	             j -= 1; 
//	             result += 1; 
//	         } 
//	         i += 1; 
//	     } 
//	     return result; 
//	 } 
//	 
//	 static int lcs(String X, String Y, int m, int n) 
//	    { 
//	        int L[][]=new int[m + 1][n + 1]; 
//	      
//	        /* Following steps build L[m+1][n+1] in bottom 
//	        up fashion. Note that L[i][j] contains length 
//	        of LCS of X[0..i-1] and Y[0..j-1] */
//	        for (int i = 0; i <= m; i++) 
//	        { 
//	            for (int j = 0; j <= n; j++) 
//	            { 
//	                if (i == 0 || j == 0) 
//	                    L[i][j] = 0; 
//	      
//	                else if (X.charAt(i - 1) == Y.charAt(j - 1)) 
//	                    L[i][j] = L[i - 1][j - 1] + 1; 
//	      
//	                else
//	                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]); 
//	            } 
//	        } 
//	      
//	        // L[m][n] contains length of LCS  
//	        // for X[0..n-1] and Y[0..m-1]  
//	        return L[m][n]; 
//	    } 
//	      
//	    // Returns cost of making X[] and Y[] identical.  
//	    // costX is cost of removing a character from X[]  
//	    // and costY is cost of removing a character from Y[]/ 
//	    public int findMinCost(String X, String Y) 
//	    { 
//	        // Find LCS of X[] and Y[] 
//	        int m = X.length(); 
//	        int n = Y.length(); 
//	        int len_LCS; 
//	        len_LCS = lcs(X, Y, m, n); 
//	      
//	        // Cost of making two strings identical 
//	        //  is SUM of following two 
//	        // 1) Cost of removing extra characters 
//	        // from first string 
//	        // 2) Cost of removing extra characters 
//	        // from second string 
//	        return (m - len_LCS) + (n - len_LCS); 
//	    } 
//*/

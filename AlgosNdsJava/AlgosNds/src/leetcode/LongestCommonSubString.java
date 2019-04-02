package leetcode;

public class LongestCommonSubString {
	public int longestCommonSubstring(char str1[], char str2[]){
        int T[][] = new int[str1.length+1][str2.length+1];
        
        int max = 0;
        int row=0, col=0;
        for(int i=0; i <= str1.length; i++){
            for(int j=0; j <= str2.length; j++){
            	if (i==0 || j==0) {
            		T[i][j]=0;
            	}else if(str1[i-1] == str2[j-1]){
                    T[i][j] = T[i-1][j-1] +1;
                    if(max < T[i][j]){
                        max = T[i][j];
                        row = i;
                        col = j;
                    }
                } else {
                	T[i][j] = 0;
                }
            }
        }
        String res = "";
        System.out.println("row" + row);
        System.out.println("col" + col);
        while (T[row][col]!=0) {
        	System.out.println(T[row][col]);
        	//System.out.println(row);
        	res = res + str1[row-1];
        	row--;
        	col--;
        }
        System.out.println(res);
        return max;
    }
	public static void main(String[] args) {
		System.out.println(new LongestCommonSubString().longestCommonSubstring("abcdaf".toCharArray(), "zbcdf".toCharArray()));
	}
}


/*
 * int T[][] = new int[s1.l + 1] [s2.l +1]
 * 
 * for(i=1 i<=s1.l i++
 *   for(j=1;j<=s2.l j++
 *    if (s1[i-1]=s2[j-1]
 *      T[i][j] = T[i-1][j-1]+1
 *      if(max <T[i][j]
 *          max = T[i][j]
 *          
 *    return max;
 *    
 *                 a b c d a f 
 * z               0 0 0 0 0 0
 * b               0 1 0 0 0 0
 * c               0 0 2 0 0 0
 * d               0 0 0 3 0 0
 * f               0 0 0 0 0 1
 * 
 * 
 * 
 * 
 * 
 * 
 */

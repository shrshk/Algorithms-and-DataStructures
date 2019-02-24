package leetcode;

public class LongestCommonSubString {
	public int longestCommonSubstring(char str1[], char str2[]){
        int T[][] = new int[str1.length+1][str2.length+1];
        
        int max = 0;
        for(int i=1; i <= str1.length; i++){
            for(int j=1; j <= str2.length; j++){
                if(str1[i-1] == str2[j-1]){
                    T[i][j] = T[i-1][j-1] +1;
                    if(max < T[i][j]){
                        max = T[i][j];
                    }
                }
            }
        }
        return max;
    }
	public static void main(String[] args) {
		System.out.println(new LongestCommonSubString().longestCommonSubstring("shirish".toCharArray(), "shiva".toCharArray()));
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
 * 
 * 
 */

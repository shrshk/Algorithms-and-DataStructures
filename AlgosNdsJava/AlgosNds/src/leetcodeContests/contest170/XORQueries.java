package leetcodeContests.contest170;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XORQueries {
    public int[] xorQueries(int[] arr, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        for (int[] query : queries) {
        	int indx1 = query[0];
        	int indx2 = query[1];
        	int xor = arr[indx1];
        	for (int i=indx1+1; i<=indx2; i++) {
        		xor = xor ^ arr[i];
        	}
        	list.add(xor);
         }
        int[] res = list.stream()
				 .mapToInt(Integer::intValue)
				 .toArray();
        return res;
    }
	public static void main(String[] args) {
		// arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
		// arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
		int[] arr = new int[]{16};
		int[][] q = new int[][]{{0,0},{0,0},{0,0},{0,0}};
		int[] res = new XORQueries().xorQueries(arr,q);
		System.out.println(Arrays.toString(res));
		
	}
}

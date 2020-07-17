package leetcodeContests.contest184;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class QueriesPermutation {
  public int[] processQueries(int[] queries, int m) {
        LinkedList<Integer> P = new LinkedList<>();
        for (int i=1; i<=m;i++)
            P.add(i);
        
        int[] res = new int[queries.length];
        
        for (int i=0; i<queries.length; i++) {
            int q = queries[i];
            int idx = P.indexOf(q);
            int val = P.get(idx);
            P.remove(idx);
            P.addFirst(val);
            res[i] = idx;
        }
        
        return res;
    }
    public int[] processQueriesBF(int[] queries, int m) {
        // queries = [3,1,2,1], m = 5
        // [1,2,3,4,5]
        int[] P = IntStream.range(1, m+1).toArray();    
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<queries.length; i++) {
             int pIdx = modifyP(P, queries[i]);
             res.add(pIdx);
        }        
        
        return res.stream().mapToInt(i -> i).toArray();        
    }
    
    
    private int modifyP(int[] P, int query) {
        // 12245       31245    	
        int pIdx = getIdx(P, query);
        int count = pIdx;
        int i=pIdx-1;
        while (count>0&&i>=0) {
        	P[count--] = P[i--];
        }
        P[0] = query;
        
        return pIdx;
    }
    
	private int getIdx(int[] P, int query) {
		int idx = -1;
		for (int i=0; i<P.length; i++) {
			if (P[i]==query)
				return i;
		}
		return idx;
	}
    
    public static void main(String[] args) {
    	int[] queries = new int[]{3,1,2,1};
		System.out.println(Arrays.toString(new QueriesPermutation().processQueries(queries, 5)));
	}
}

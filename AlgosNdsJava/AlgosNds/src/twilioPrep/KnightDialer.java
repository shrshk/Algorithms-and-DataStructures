package twilioPrep;

import java.util.HashMap;
import java.util.Map;

public class KnightDialer {
	int MOD = (int) (1e9 + 7);
    public int knightDialer(int N) {
        // steps
        // place knight on all possible digits
        // start going in all possible dirs
        // and add the results
        // cache i,j,n combo. i.e location and hops        
        Map<String,Long> map = new HashMap<>();
        
        long ans = 0;
        
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                
            }
        }
        
        ans = (ans + dfs(0,1,N,map))%MOD;
        
        return (int) ans;      
    }
    
    private long dfs(int i, int j, int n, Map<String,Long> map) {
        if (i>3 || j>2 || i<0 || j<0 || (i==1 && j==1))
            return 0;        
        if (n==1)
            return 1;
        String key = i + "_" + j + "_" + n;
        if (map.containsKey(key))
            return map.get(key);
        int[][] dirs = new int[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        
        long res=0;
        
        for (int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            res = res + dfs(x,y,n-1,map)%MOD;            
        }        
        map.put(key, res);      
        
        return res;
    }
    
    public static void main(String[] args) {
		System.out.println(new KnightDialer().knightDialer(4));
	}
}

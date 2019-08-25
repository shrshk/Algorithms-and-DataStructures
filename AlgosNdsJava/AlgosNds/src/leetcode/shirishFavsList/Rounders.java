package leetcode.shirishFavsList;

public class Rounders {
	static int rounders(int n) {
	    int p = 10;
	    while (n > p) {
	        if ((n % p) / (p / 10) < 5)
	            n = (n / p) * p;
	        else
	            n =  (n/p+1)*p ;
	        p *= 10;
	    }
	    return n;
	}
	
	int sumOfCubes(int n) {
	    int sum = 0; 
	    for (int x=1; x<=n; x++) 
	        sum += x*x*x; 
	    return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(rounders(1520));
	}
	
	
//	boolean isTournament(int n, int[] fromV, int[] toV) {
//		if (fromV.length < 1) {
//			return n < 2;
//		}
//		Map<Integer, Integer> map = new HashMap<>();
////		for (int i=0; i<fromV.length; i++) {
////			for (int j=0; j<toV.length; j++) {
////				map.put(key, value)
////			}
////		}
//		  int keysSize = (fromV != null) ? fromV.length : 0;
//	      int valuesSize = (toV != null) ? toV.length : 0;
//	      for (int i = 0; i < keysSize; i++) {
//	          map.put(fromV[i], toV[i]);
//	      }
//	      
//	      
//	}
	
}

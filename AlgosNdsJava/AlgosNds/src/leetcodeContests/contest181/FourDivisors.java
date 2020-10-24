package leetcodeContests.contest181;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FourDivisors {
	Map<Integer, Set<Integer>> map = new HashMap<>();
    public int sumFourDivisors(int[] nums) {
    	int res = 0;
    	// {21:[], }
    	// use recursion with dp later
    	List<Integer> total = new ArrayList<>();
    	for (int num: nums) {
    		List<Integer> divisors = new ArrayList<>();
    		divisors.add(num);
    		divisors.add(1);
    		for (int i=2; i<=Math.sqrt(num); i++) {
    			if (divisors.size()>=5)
    				break;
    			if (num%i==0) {    				
    				divisors.add(i);
    				if (i!=num/i)
    					divisors.add(num/i);
    			}
    		}
    		if (divisors.size()==4)
    			total.addAll(divisors);
    	}
    	
    	for (int divisor: total)
    		res+=divisor;
    	
        return res;
    }
    
    private Set<Integer> findDivisors(int n) {
    	Set<Integer> set = new HashSet<>();
    	// 1,3,7,21,42/
    	// 21: []
    	for (int i=1; i<=n; i++) {
    		int div = n%i;
    		// if (map.containsKey(div))
    	}
    	
    	return set;
    }
    
    
	public static void main(String[] args) {
		System.out.println(new FourDivisors().sumFourDivisors(new int[]{21,21}));
	}
}

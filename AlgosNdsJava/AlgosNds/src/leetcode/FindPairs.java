package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPairs {
	static int  numPairs(List<Integer> arr) {
		int result = 0;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (Integer num: arr) {
			if(map.containsKey(num)) {			    
				map.put(num, map.get(num)+1);
			} else {
				map.put(num, 1);
			}
		}
		
		for (Integer count: map.values()) {
			result = result + count/2;
		}
		
		
		return result;
		
	}
	
	public static void main(String[] args) {
		System.out.println(numPairs(new ArrayList<>(Arrays.asList(10,20,20,10,10,30,50,10,20))));
	}
}

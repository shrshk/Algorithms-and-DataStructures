package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FrequentInteger {
	
	public int freqInt(int[] arr) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i=0; i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			} else {
				map.put(arr[i], 1);
			}
		}
		
		int maxCount = 0; 
		int maxCountNum = 0;
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			int count = entry.getValue();
			int num = entry.getKey();
			if(maxCount<count) {
				maxCount = count;
				maxCountNum = num;
			}
		}
		
		
		return maxCountNum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{1,2,3,1,4,4,4};
		System.out.println(new FrequentInteger().freqInt(arr));

	}

}

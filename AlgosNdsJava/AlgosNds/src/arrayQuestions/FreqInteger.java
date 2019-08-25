package arrayQuestions;

import java.util.HashMap;
import java.util.Map;

public class FreqInteger {
	static int freqInteger(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0;i<arr.length;i++) {
			if(map.get(arr[i])==null){
				map.put(arr[i], 0);
			} else {
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		Map.Entry<Integer, Integer> maxEntry = null;
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
		    {
		        maxEntry = entry;
		    }
		}
		return maxEntry.getKey();
	}
	public static void main(String[] args) {
		System.out.println(freqInteger(new int[]{3,2,3}));
	}
}

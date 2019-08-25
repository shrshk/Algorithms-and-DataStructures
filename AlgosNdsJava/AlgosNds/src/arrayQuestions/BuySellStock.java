package arrayQuestions;

import java.util.HashMap;
import java.util.Map;

public class BuySellStock {
	static int buySellStock(int[] arr) { // bruteForce
		Map<Integer,Integer> map = new HashMap<>();
		for (int i=0;i<arr.length;i++) {
				map.put(arr[i], 0);	
				int buy = 0;
				for (int j=i; j<arr.length;j++) {
					if (arr[j]-arr[i] > buy) {
						buy = arr[j]-arr[i];
						map.put(arr[i], arr[j]-arr[i]);
					}						
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
		return maxEntry.getValue();
	}
	
	static int maxProfit(int[] prices) { // O(n)
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i=0; i<prices.length;i++) {
			if (prices[i]<minPrice) {
				minPrice = prices[i];
			} else if(prices[i]-minPrice>maxProfit) {
				maxProfit = prices[i]-minPrice;
			}
		}
		return maxProfit;
	}
	
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
	}
	
	
}

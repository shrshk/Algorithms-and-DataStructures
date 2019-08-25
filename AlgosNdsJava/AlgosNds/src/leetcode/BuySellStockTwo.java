package leetcode;

public class BuySellStockTwo {
	
	static int maxProfit(int[] arr) {
		int maxProfit = 0;
		int i=0,j=1;
		while(i<arr.length && j<arr.length) {
			if (arr[i]<arr[j]){
				maxProfit = maxProfit + arr[j]-arr[i];
			}
			i++;
			j++;
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
	}

}

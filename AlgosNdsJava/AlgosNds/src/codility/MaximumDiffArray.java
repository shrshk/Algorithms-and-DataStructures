package codility;

public class MaximumDiffArray {
	static int maxDiff(int[] arr) {
		int maxDiff = 0;
		int index = 0;
		for (int i=0; i<arr.length-1; i++) {
			for (int j=i+1; j<arr.length;j++) {
				if(Math.abs(arr[i]-arr[j])>maxDiff) {
					maxDiff = Math.abs(arr[i]-arr[j]);
					index=i;
				}
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		System.out.println(maxDiff(new int[]{1,3,-3}));
	}
}

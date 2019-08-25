package leetcode;

public class RemoveDuplicatesSortedArray {
	static int removeDups(int[] arr) {
		int count=0;
		for (int i=0;i<arr.length-1;i++) {
			if(arr[i]!=arr[i+1]) {
				arr[count++] = arr[i];
			}
		}
		arr[count++] = arr[arr.length-1];	
		return count;
	}
	public static void main(String[] args) {
		System.out.println(removeDups(new int[]{1,1,2}));
	}
}

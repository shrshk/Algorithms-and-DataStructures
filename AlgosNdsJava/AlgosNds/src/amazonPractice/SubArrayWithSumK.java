package amazonPractice;

public class SubArrayWithSumK {
	static int subArrKsum(int[] nums, int k) {
		// i=0, j=1, 2
		int i=0, j=1;
		while (i<nums.length-1) {
			int complement = k-nums[i];
			
			while(j<nums.length) {
				
			}
		}
		
		return 0;
	}
	public static void main(String[] args) {
		System.out.println(subArrKsum(new int[]{1,1,1}, 2));
	}
}

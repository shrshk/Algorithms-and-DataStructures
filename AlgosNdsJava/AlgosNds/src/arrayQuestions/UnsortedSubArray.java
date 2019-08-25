package arrayQuestions;

public class UnsortedSubArray {
	static int unsortedArray(int[] nums) {
		// get 2ndmin, 2ndmax //2 6  4 8 10 9 15
		int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
		boolean flag=false;
		// find min
		for (int i=1; i<nums.length; i++) {
			if (nums[i] < nums[i-1])
				flag=true;
			if(flag)
				min=Math.min(min, nums[i]);
		}
		System.out.println("min" + min);
		flag=false;
		// find max
		for (int i=nums.length-2;i>=0;i--) {
			if(nums[i]>nums[i+1])
				flag=true;
			if(flag)
				max = Math.max(max, nums[i]);
		}
		System.out.println("max" + max);
		int l,r;
		for(l=0;l<nums.length;l++) {
			if(nums[l]>min)
				break;
		}
		for(r=nums.length-1;r>=0;r--){
			if(nums[r]<max)
				break;
		}
		System.out.println("r"+ r);
		System.out.println("l" + l);
		return r-l<0?0:r-l+1;
	}
	public static void main(String[] args) {
		System.out.println(unsortedArray(new int[]{2,6,4,8,10,9,15}));
	}
}

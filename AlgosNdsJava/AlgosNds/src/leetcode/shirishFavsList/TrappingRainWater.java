package leetcode.shirishFavsList;

public class TrappingRainWater {
	public int trapOld(int[] height) {
		int secHight = 0;
		int left = 0;
		int right = height.length - 1;
		int area = 0;
		while (left < right) {
			if (height[left] < height[right]) {
				secHight = Math.max(height[left], secHight);
				area += secHight - height[left];
				left++;
			} else {
				secHight = Math.max(height[right], secHight);
				area += secHight - height[right];
				right--;
			}
		}
		return area;
	}
	
	public int trap(int[] height) {
		if (height.length<3) return 0;
		int water = 0;
		int leftMax = height[0];
		int rightMax = height[height.length-1];
		int left = 1;
		int right = height.length-2;
		while(left<=right) {
			if (leftMax<=rightMax) {
				leftMax = Math.max(leftMax, height[left]);
				water += leftMax - height[left];
				left++;
			}else {
				rightMax = Math.max(rightMax, height[right]);
				water += rightMax - height[right];
				right--;
			}
		}		
		return water;
	}
	
	public static void main(String[] args) {
		int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new TrappingRainWater().trap(height));
	}
}

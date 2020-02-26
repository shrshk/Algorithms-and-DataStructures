package facebookPrep.mockTests.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindIntersection {
	public int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> res = new ArrayList<>();
		int i = 0;
		int j = 0;

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				++i;
			} else if (nums1[i] > nums2[j]) {
				++j;
			} else if (nums1[i] == nums2[j]){
				res.add(nums1[i]);
				++i;
				++j;
			}
		}

		int[] resArr = new int[res.size()];
		int count = 0;
		for (int num : res) {
			resArr[count++] = num;
		}

		return resArr;

	}
	
	public static void main(String[] args) {
		int[] nums1 = new int[]{4,9,9,5};
		int[] nums2 = new int[]{9,4,9,8,4};
		System.out.println(Arrays.toString(new FindIntersection().intersect(nums1, nums2)));
	}
}

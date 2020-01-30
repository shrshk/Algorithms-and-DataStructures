package facebookPrep.sortingAndSearching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length) {
            if (nums1[i]<nums2[j])
                i++;
            else if (nums1[i]>nums2[j])
                j++;
            else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int[] res = new int[set.size()];
        int count=0;
        for (int x : set) {
            res[count++] = x;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
    	int[] nums1 = new int[]{1,2};
    	int[] nums2 = new int[]{1,1};
		System.out.println(new IntersectionArrays().intersection(nums1, nums2));
	}
}

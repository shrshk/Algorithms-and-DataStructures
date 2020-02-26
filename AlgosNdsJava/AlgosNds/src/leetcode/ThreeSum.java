package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	static List<List<Integer>> threeSum(int[] arr) {
		List<List<Integer>> threeSumLists = new ArrayList<List<Integer>>();
		for (int i=0;i<arr.length;i++) {
			List<Integer> tempList = new ArrayList<Integer>();
			for (int j=0;j<arr.length;j++) {
				if (j!=i) {
					tempList.add(arr[i],arr[j]);
					for(int k=0;k<arr.length;k++) {
						if(k!=i&&k!=j) {
							int sum=0;
							for (int a:tempList) {
								sum = sum + a;								
							}
							if (sum + arr[k]==0) {
								threeSumLists.add(tempList);
							}
						}
					}
				}
			}
		}
		return threeSumLists;
	}
	
    public List<List<Integer>> threeSumW(int[] nums) {
        // -4,-1,-1,0,1,2
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            int j=i+1;
            int k = nums.length-1;
            if (i>0 && nums[i]==nums[i-1])
                continue;
            while (j<k) {
                if (k<nums.length-1 && nums[k]==nums[k+1]) {
                    k--;
                    continue;
                }
                if (nums[i]+nums[j]+nums[k]>0) {
                    k--;
                } else if (nums[i]+nums[j]+nums[k]<0) {
                    j++;
                } else {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    res.add(triplet);
                    j++;
                    k--;
                }
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
	}

}

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber {
	
	static int singleNum(int[] arr) {
		List<Integer> list = new ArrayList<>();
		for (int i=0;i<arr.length;i++) {
			if (list.contains(arr[i])) {
				int index=list.indexOf(arr[i]);
				list.remove(index);
			} else {
				list.add(arr[i]);
			}
		}
		
		return list.get(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(singleNum(new int[]{2,2,1}));
	}

}

package leetcodeTopInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge2Arrays {
	public List<Integer> mergeTwoArrays(List<Integer> a, List<Integer> b) {
		int m = a.size();
		int n = b.size();
		List<Integer> res = new ArrayList<>(m+n);

		int i = 0, j = 0;
		int idx = 0;

		while (i < m && j < n) {
			if (a.get(i) < b.get(j)) {
				res.add(idx++, a.get(i++)); 
			} else if (a.get(i) > b.get(j)) {
				res.add(idx++, b.get(j++)); 
			} else {
				res.add(idx++, a.get(i++)); 
				res.add(idx++, b.get(j++));
			}
		}

		while (i < m) {
			res.add(idx++, a.get(i++)); 
		}

		while (j < n) {
			res.add(idx++, b.get(j++));
		}

		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(new Merge2Arrays().mergeTwoArrays(Arrays.asList(1,2,3), Arrays.asList(2,5,5,6)));
	}

}

package microsoftOnlineAssessmentPrep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxPossibleNumber {
	public int maxPossible(int N) {
		String numS = String.valueOf(N);
		boolean isNeg = numS.charAt(0) == '-';
		numS = isNeg ? numS.substring(1) : numS;
		List<String> list = new ArrayList<>();
		for (int i = 0; i <= numS.length(); i++) {
			String temp = numS.substring(0, i) + '5' + numS.substring(i, numS.length());
			list.add(temp);
		}

		Collections.sort(list);
		numS = isNeg ? '-' + list.get(0) : list.get(list.size() - 1);

		return Integer.valueOf(numS);
	}

	public static void main(String[] args) {
		System.out.println(new MaxPossibleNumber().maxPossible(-999));
	}
}

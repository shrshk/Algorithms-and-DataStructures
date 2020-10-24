package amazonPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FraudLogs {
	public List<String> getFraudIds(String[] input, int threshold) {
		List<String> res = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (String log : input) {
			String[] logVals = log.split(" ");
			Set<String> set = new HashSet<>(Arrays.asList(logVals[0], logVals[1]));
			for (String userId : set) {
				map.put(userId, map.getOrDefault(userId, 0) + 1);
			}
		}

		for (String userId : map.keySet()) {
			if (map.get(userId) >= threshold)
				res.add(userId);
		}

		Collections.sort(res);

		return res;
	}

	public static void main(String[] args) {
		String[] input = new String[] { "345366 89921 45", "029323 38239 23", "38239 345366 15", "029323 38239 77",
				"345366 38239 23", "029323 345366 13", "38239 38239 23" };
		System.out.println(new FraudLogs().getFraudIds(input, 3));
	}
}

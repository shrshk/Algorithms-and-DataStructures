package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak2 {

	public List<List<String>> wordBreak(List<String> input) {
		List<List<String>> res = new ArrayList<>();
		Set<String> dict = new HashSet<>();
		dict.addAll(input);
		Map<String, List<String>> cache = new HashMap<>();
		for (String s : input) {
			dict.remove(s);
			dfs(s, dict, new ArrayList<>(), res, cache);
			dict.add(s);
		}
		return res;
	}

	private void dfs(String tmp, Set<String> dict, List<String> tmpList, List<List<String>> res,
			Map<String, List<String>> cache) {
		
		if (tmp == null || tmp.length() == 0) {
			res.add(new ArrayList<>(tmpList));
			return;
		}
		
		// System.out.println(cache.toString());

//		if (cache.containsKey(tmp)) {			
//			tmpList.addAll(cache.get(tmp));
//			return;
//		}

		for (int i = 1; i <= tmp.length(); i++) {
			String left = tmp.substring(0, i);
			if (!dict.contains(left))
				continue;
			tmpList.add(left);
			String right = tmp.substring(i);
			dfs(right, dict, tmpList, res, cache);	
			tmpList.remove(tmpList.size() - 1);
		}		
		
	}

	public static void main(String[] args) {
		System.out.println(new WordBreak2().wordBreak(Arrays.asList("super", "man", "superman", "superhighwayman", "highway")));
	}
}

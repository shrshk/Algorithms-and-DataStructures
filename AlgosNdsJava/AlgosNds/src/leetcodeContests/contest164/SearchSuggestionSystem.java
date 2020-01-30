package leetcodeContests.contest164;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionSystem {
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		// steps
		// for each char in searchWord return matches or empty list
		Arrays.sort(products);
		List<List<String>> res = new ArrayList<>(searchWord.length());

		int n = searchWord.length();

		for (int i = 0; i < n; i++) {
			res.add(i, new ArrayList<>());
		}

		int i = 1;

		while (i <= n) {
			for (String prod : products) {
				if (prod.startsWith(searchWord.substring(0, i))) {
					if (res.get(i - 1).size() < 3)
						res.get(i - 1).add(prod);
				}
			}
			i++;
		}

		return res;
	}

	public static void main(String[] args) {
		// products = ["mobile","mouse","moneypot","monitor","mousepad"],
		// searchWord = "mouse"
		// "havana"
		String[] products = new String[] { "havana" };
		String searchWord = "havana";
		// System.out.println(searchWord.substring(0, 5));
		System.out.println(new SearchSuggestionSystem().suggestedProducts(products, searchWord));
	}
}

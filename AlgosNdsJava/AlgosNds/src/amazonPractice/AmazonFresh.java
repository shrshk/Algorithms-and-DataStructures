package amazonPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonFresh {
	// Input: codeList = [[apple, apple], [banana, anything, banana]]
	// shoppingCart = [orange, apple, apple, banana, orange, banana]

	// idx to loop sc and

	// idx to loop cL and idx2 to move inside codeGroup

	// when match found move idx2 and cartIdx

	public boolean isWinner(List<List<String>> codeList, List<String> shoppingCart) {

		int sIdx = 0, cIdx = 0;
		int cLen = codeList.size(), sLen = shoppingCart.size();

		while (cIdx < cLen && sIdx < sLen) {
			List<String> currCode = codeList.get(cIdx);
			List<String> subList = sIdx + currCode.size() <= shoppingCart.size()
					? shoppingCart.subList(sIdx, sIdx + currCode.size()) : new ArrayList<>();
			boolean match = isMatch(currCode, subList);

			if (match) {
				sIdx += currCode.size();
				cIdx++;
			} else {
				sIdx++;
			}

		}

		return cIdx == cLen;
	}

	private boolean isMatch(List<String> currCode, List<String> shoppingCart) {
		if (shoppingCart.isEmpty())
			return false;

		int i = 0;
		while (i < currCode.size()) {
			if (currCode.get(i).equals("anything")) {
				i++;
				continue;
			}
			if (!currCode.get(i).equals(shoppingCart.get(i))) {
				return false;
			}
			i++;
		}

		return true;
	}

	public static void main(String[] args) {
		List<List<String>> codeList = Arrays.asList(Arrays.asList("apple", "apple"),
				Arrays.asList("banana", "anything", "banana"));
		// apple, banana, apple, banana, orange, banana
		// banana, orange, banana, apple, apple
		// "orange", "apple", "apple", "banana", "orange", "banana"
		// "orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"
		List<String> shoppingCart = Arrays.asList("apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana");
		System.out.println(new AmazonFresh().isWinner(codeList, shoppingCart));
	}

}

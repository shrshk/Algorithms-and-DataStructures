package leetcodeContests.contest190;

public class WordAsPrefix {
	public int isPrefixOfWord(String sentence, String searchWord) {
		String[] tokens = sentence.split(" ");
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].startsWith(searchWord)) {
				return i + 1;
			}

		}

		return -1;
	}
}

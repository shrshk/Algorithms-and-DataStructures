package codeFights;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class WordPuzzle {

	public Set<String> findWords(char[][] puzzle, Set<String> words) {
		Set<String> foundWords = new HashSet<String>();
		int minimumWordLength = findMinimumWordLength(words);
		Set<String> possibleWords = findPossibleWords(puzzle, minimumWordLength);
		for (String word : words) {
			for (String possibleWord : possibleWords) {
				if (possibleWord.contains(word) || possibleWord.contains(new StringBuffer(word).reverse())) {
					foundWords.add(word);
					break;
				}
			}
		}
		return foundWords;
	}

	private int findMinimumWordLength(Set<String> words) {
		int minimumLength = Integer.MAX_VALUE;
		for (String word : words) {
			if (word.length() < minimumLength)
				minimumLength = word.length();
		}
		return minimumLength;
	}

	private Set<String> findPossibleWords(char[][] puzzle, int minimumWordLength) {
		Set<String> possibleWords = new LinkedHashSet<String>();
		int dimension = puzzle.length; // Assuming puzzle is square
		if (dimension >= minimumWordLength) {
			/* Every row in the puzzle is added as a possible word holder */
			for (int i = 0; i < dimension; i++) {
				if (puzzle[i].length >= minimumWordLength) {
					possibleWords.add(new String(puzzle[i]));
				}
			}
			/* Every column in the puzzle is added as a possible word holder */
			for (int i = 0; i < dimension; i++) {
				StringBuffer temp = new StringBuffer();
				for (int j = 0; j < dimension; j++) {
					temp = temp.append(puzzle[j][i]);
				}
				possibleWords.add(new String(temp));
			}
			/* Adding principle diagonal word holders */
			StringBuffer temp1 = new StringBuffer();
			StringBuffer temp2 = new StringBuffer();
			for (int i = 0; i < dimension; i++) {
				temp1 = temp1.append(puzzle[i][i]);
				temp2 = temp2.append(puzzle[i][dimension - i - 1]);
			}
			possibleWords.add(new String(temp1));
			possibleWords.add(new String(temp2));
			/* Adding non-principle diagonal word holders */
			for (int i = 1; i < dimension - minimumWordLength; i++) {
				temp1 = new StringBuffer();
				temp2 = new StringBuffer();
				StringBuffer temp3 = new StringBuffer();
				StringBuffer temp4 = new StringBuffer();
				for (int j = i, k = 0; j < dimension && k < dimension; j++, k++) {
					temp1 = temp1.append(puzzle[j][k]);
					temp2 = temp2.append(puzzle[k][j]);
					temp3 = temp3.append(puzzle[dimension - j - 1][k]);
					temp4 = temp4.append(puzzle[dimension - k - 1][j]);
				}
				possibleWords.add(new String(temp1));
				possibleWords.add(new String(temp2));
				possibleWords.add(new String(temp3));
				possibleWords.add(new String(temp4));
			}
		}
		return possibleWords;
	}

	public static void main(String args[]) {
		WordPuzzle program = new WordPuzzle();
		char[][] puzzle = { { 'F', 'Y', 'Y', 'H', 'N', 'R', 'D' }, { 'R', 'L', 'J', 'C', 'I', 'N', 'U' },
				{ 'A', 'A', 'W', 'A', 'A', 'H', 'R' }, { 'N', 'T', 'K', 'L', 'P', 'N', 'E' },
				{ 'C', 'I', 'L', 'F', 'S', 'A', 'P' }, { 'E', 'O', 'G', 'O', 'T', 'P', 'N' },
				{ 'H', 'P', 'O', 'L', 'A', 'N', 'D' } };
		Set<String> words = new HashSet<String>();
		words.add("FRANCE");
		words.add("POLAND");
		words.add("INDIA");
		words.add("JAPAN");
		words.add("USA");
		words.add("HOLLAND");
		Set<String> wordsFound = program.findWords(puzzle, words);
		for (String word : wordsFound) {
			System.out.println(word);
		}
	}
}
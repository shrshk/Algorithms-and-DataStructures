package amazonLeetCode.treesAndGraphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
	beginWord = "hit",
	endWord = "cog",
	wordList = ["hot","dot","dog","lot","log","cog"]
	"hit" -> "hot" -> "dot" -> "dog" -> "cog"
*/
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int count = 0;
		if (!wordList.contains(endWord)) return count;
		// steps
		// make a set of dict. words
		// add begin word to the q 
		// keep manipulating the word in the q 
		// when a word is explored remove it from dict. we don't wanna explore again
		Set<String> wordDict = new HashSet<>(wordList);
		wordDict.add(endWord);
		Queue<String> q = new ArrayDeque<>();
		q.add(beginWord);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i=0; i<size; i++) {
				String current = q.poll();
				if (current.equals(endWord)) return count+1;
				wordMatch(wordDict, q, current);
			}
			count++;
		}		
		
		return 0;
	}
	
	private void wordMatch(Set<String> wordDict, Queue<String> q, String current) {
		for (int j=0; j<current.length(); j++) {
			char[] word = current.toCharArray();
			for (char ch='a'; ch<='z'; ch++) {						
				if (word[j]==ch) continue;
				word[j]=ch;
				String newWord = new String(word);
				if (wordDict.contains(newWord)) {
					wordDict.remove(newWord);
					q.add(newWord);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
	}
}

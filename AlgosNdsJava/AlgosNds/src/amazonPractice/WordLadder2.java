package amazonPractice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<>();

		Set<String> dict = new HashSet<>(wordList);
		if (!dict.contains(endWord))
			return res;

		// steps
		// build graph of next word
		// build distance map of words by level

		Map<String, Set<String>> graph = new HashMap<>(); // graph
		Map<String, Integer> distance = new HashMap<>();

		BFS(graph, distance, dict, beginWord, endWord);
		DFS(graph, distance, beginWord, endWord, new ArrayList<>(Arrays.asList(beginWord)), res);

		return res;
	}

	private void BFS(Map<String, Set<String>> graph, Map<String, Integer> distance, Set<String> dict, String beginWord,
			String endWord) {
		Queue<String> q = new ArrayDeque<>();
		q.add(beginWord);
		distance.put(beginWord, 0);

		while (!q.isEmpty()) {
			boolean reachEnd = false;
			int size = q.size();
			for (int idx = 0; idx < size; idx++) {
				String curr = q.poll();

				for (int i = 0; i < curr.length(); i++) {
					char[] currArr = curr.toCharArray();
					for (char ch = 'a'; ch <= 'z'; ch++) {
						currArr[i] = ch;
						String tmpWord = String.valueOf(currArr);
						if (dict.contains(tmpWord)) {
							graph.putIfAbsent(curr, new HashSet<>());
							graph.get(curr).add(tmpWord);
						}
					}
				}

				for (String neighbor : graph.get(curr)) {
					if (!distance.containsKey(neighbor)) {
						distance.put(neighbor, distance.get(curr) + 1);
						if (neighbor.equals(endWord)) {
							reachEnd = true;
						} else {
							q.add(neighbor);
						}
					}
				}

				if (reachEnd) {
					break;
				}
			}

		}

	}

	private void DFS(Map<String, Set<String>> graph, Map<String, Integer> distance, String currWord, String endWord,
			List<String> tmpList, List<List<String>> res) {
		if (currWord.equals(endWord)) {
			res.add(new ArrayList<>(tmpList));
			return;
		}

		for (String neighbor : graph.get(currWord)) {
			if (distance.get(neighbor) == distance.get(currWord) + 1) {
				tmpList.add(neighbor);
				DFS(graph, distance, neighbor, endWord, tmpList, res);
				tmpList.remove(tmpList.size() - 1);
			}
		}
	}

	/**
	 * High level design: BFS + DFS
	 * 
	 * Step 1: use BFS to build graph (adjacency list of each word), as well as
	 * calculating distance from beginWord to each node in the graph (should
	 * store minimum distance)
	 * 
	 * Step 2: use DFS to traverse and record path from beginWord to endWord
	 * with shortest path. We can use distance map to control every next word.
	 */
	public List<List<String>> findLadderss(String beginWord, String endWord, List<String> wordList) {
		if (wordList.size() == 0) {
			return new ArrayList<>();
		}

		/**
		 * @param result:
		 *            result list to store final return list
		 * @param graph:
		 *            adjacency list of key - store all neighbors of each word
		 *            (neighbor means all words in dictionary that only has one
		 *            character difference with key)
		 * @param distance:
		 *            distance between beginWord and current key word, used for
		 *            tracing path when we do DFS
		 * @param dict:
		 *            word dictionary, efficient for searching purpose
		 */
		List<List<String>> result = new ArrayList<>();
		Map<String, Set<String>> graph = new HashMap<>();
		Map<String, Integer> distance = new HashMap<>();
		Set<String> dict = new HashSet<>(wordList);

		bfs(beginWord, endWord, dict, graph, distance);
		dfs(result, graph, distance, endWord, beginWord, new ArrayList<>(Arrays.asList(beginWord)));
		return result;
	}

	// step 1
	public void bfs(String beginWord, String endWord, Set<String> dict, Map<String, Set<String>> graph,
			Map<String, Integer> distance) {
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		distance.put(beginWord, 0);

		while (!queue.isEmpty()) {
			boolean reachEnd = false;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String curWord = queue.poll();

				/*
				 * try all possible substitution (26 characters) in every
				 * position of current word, if newWord exists in dictionary, we
				 * add it to the adjacency list of curWord
				 */
				for (int j = 0; j < curWord.length(); j++) {
					char[] curWordArr = curWord.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						curWordArr[j] = c;
						String newWord = new String(curWordArr);
						if (dict.contains(newWord)) {
							graph.putIfAbsent(curWord, new HashSet<>());
							graph.get(curWord).add(newWord);
						}
					}
				}

				// traverse all neighbors of current word, update distance map
				// and queue for next ladder (level)
				// WARNING: DO NOT USE visited set, since it is hard to deal
				// with end word if endWord is visited
				for (String neighbor : graph.get(curWord)) {
					if (!distance.containsKey(neighbor)) {
						distance.put(neighbor, distance.get(curWord) + 1);
						if (neighbor.equals(endWord)) {
							reachEnd = true;
						} else {
							queue.offer(neighbor);
						}
					}
				}
				if (reachEnd) {
					break;
				}
			}
		}
	}

	// step 2
	public void dfs(List<List<String>> result, Map<String, Set<String>> graph, Map<String, Integer> distance,
			String endWord, String curWord, List<String> tempList) {
		if (curWord.equals(endWord)) {
			result.add(new ArrayList<>(tempList));
			return;
		}

		for (String nextWord : graph.get(curWord)) {
			// only if next node is on the minimum path to the endWord, we can
			// traverse it
			if (distance.get(nextWord) == distance.get(curWord) + 1) {
				tempList.add(nextWord);
				dfs(result, graph, distance, endWord, nextWord, tempList);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}

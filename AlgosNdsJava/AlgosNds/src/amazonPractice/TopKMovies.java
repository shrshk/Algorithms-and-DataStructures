package amazonPractice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TopKMovies {
	public List<String> movieRecomm(Map<String, List<String>> userFollows, Map<String, List<String>> movieData, int k,
			int N) {

		List<String> res = new ArrayList<>(k);

		Set<String> visited = new HashSet<>();
		Set<String> movies = new HashSet<>();

		Queue<String> q = new ArrayDeque<>();
		q.add("A");

		while (!q.isEmpty() && N > 0) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String current = q.poll();

				if (visited.contains(current))
					continue;
				visited.add(current);

				List<String> movieList = movieData.getOrDefault(current, new ArrayList<>());
				for (String movie : movieList) {
					if (!movies.contains(movie) && res.size() < k) {
						res.add(movie);
						movies.add(movie);
					}
				}

				if (!userFollows.containsKey(current))
					continue;
				for (String follower : userFollows.get(current)) {
					q.add(follower);
				}
			}
			N--;
		}

		return res;
	}

	public static void main(String[] args) {
		Map<String, List<String>> userFollows = new HashMap<>();
		userFollows.put("A", Arrays.asList("B", "Z"));
		userFollows.put("B", Arrays.asList("C"));
		userFollows.put("C", Arrays.asList("D"));
		Map<String, List<String>> movieData = new HashMap<>();
		movieData.put("B", Arrays.asList("mvi1", "mvi2"));
		movieData.put("C", Arrays.asList("mvi3", "mvi1", "mvi2"));
		movieData.put("D", Arrays.asList("mvi3"));
		System.out.println(new TopKMovies().movieRecomm(userFollows, movieData, 2, 2));
	}
}

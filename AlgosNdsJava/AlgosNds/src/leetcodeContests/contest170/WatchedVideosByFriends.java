package leetcodeContests.contest170;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import static java.util.Arrays.*;

public class WatchedVideosByFriends {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        // watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 1
        // get nodes in that level and look up what videos they watched - bfs
    	// start the graph from id/person
    	// use bfs to get to the level given
    	// find friends at that level use them to lookup in watchedVideos
    	Queue<int[]> q = new ArrayDeque<>();
    	q.add(friends[id]);
    	Map<Integer, List<Integer>> levelMap = new HashMap<>();
    	int currentLevel = 0;
    	levelMap.put(currentLevel++, Arrays.asList(id));  // not needed if the while loop is existed with friends at the given level in the queue.
    	boolean[] visited = new boolean[100];
    	visited[id] = true;
    	while(!q.isEmpty() && currentLevel<=level) {
    		int size = q.size();
    		List<Integer> currList = new ArrayList<>();
    		for (int i=0; i<size; i++) {
    			int[] currFriends = q.poll();    			
    			for (int frd: currFriends) {
    				if (!visited[frd]) {
    					visited[frd] = true;
    					q.add(friends[frd]);
    					currList.add(frd);
    				}    					
    			}
    		}
    		levelMap.put(currentLevel++, currList);
    	}
    	
    	List<Integer> frds = levelMap.get(level);
    	Map<String, Integer> freqMap = new HashMap<>();
    	for (Integer frd : frds) {
    		List<String> watched = watchedVideos.get(frd);
    		for (String v: watched)
    			freqMap.put(v, freqMap.getOrDefault(v, 0)+1);
    	}
    	
    	List<String> res = new ArrayList<>(freqMap.keySet());
    	
    	res.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (freqMap.get(s1)==freqMap.get(s2))
					return s1.compareTo(s2);
				return freqMap.get(s1)-freqMap.get(s2);
			}
		});
    	return res;
    }
    
    public static void main(String[] args) {
    	// [["bjwtssmu"],["aygr","mqls"],["vrtxa","zxqzeqy","nbpl","qnpl"],["r","otazhu","rsf"],["bvcca","ayyihidz","ljc","fiq","viu"]]
    	// [[3,2,1,4],[0,4],[4,0],[0,4],[2,3,1,0]]
    			// 3
    			// 1
    	List<List<String>> watchedVideos = asList(
    			asList("bjwtssmu"),
    			asList("aygr","mqls"),
    			asList("vrtxa","zxqzeqy","nbpl","qnpl"),
    			asList("r","otazhu","rsf"),
    			asList("bvcca","ayyihidz","ljc","fiq","viu")
    			);
    	int[][] friends = new int[][]{{3,2,1,4},{0,4},{4,0},{0,4},{2,3,1,0}};
    	int id = 3;
    	int level = 1;
		System.out.println(new WatchedVideosByFriends().watchedVideosByFriends(watchedVideos, friends, id, level));
	}
}

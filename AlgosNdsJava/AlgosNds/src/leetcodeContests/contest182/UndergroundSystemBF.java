package leetcodeContests.contest182;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UndergroundSystemBF {
	Map<Integer, int[]> idMap;
	Map<String, List<Integer>> stationInMap;
	Map<String, List<Integer>> stationOutMap;

	public UndergroundSystemBF() {
		idMap = new HashMap<>();
		stationInMap = new HashMap<>();
		stationOutMap = new HashMap<>();
	}

	public void checkIn(int id, String stationName, int t) {
		// List<Integer> inTimes = inMap.getOrDefault(stationName, new
		// ArrayList<>());
		// inTimes.add(t);
		idMap.put(id, new int[] { t, 0 });
		List<Integer> ids = stationInMap.getOrDefault(stationName, new ArrayList<>());
		ids.add(id);
		stationInMap.put(stationName, ids);
	}

	public void checkOut(int id, String stationName, int t) {
		// List<Integer> outTimes = outMap.getOrDefault(stationName, new
		// ArrayList<>());
		// outTimes.add(t);
		int[] time = idMap.get(id);
		time[1] = t;
		List<Integer> ids = stationOutMap.getOrDefault(stationName, new ArrayList<>());
		ids.add(id);
		stationOutMap.put(stationName, ids);
	}

	public double getAverageTime(String startStation, String endStation) {
		List<Integer> inIds = stationInMap.get(startStation);
		List<Integer> outIds = stationOutMap.get(endStation);

		List<Integer> intersect = inIds.stream().filter(outIds::contains).collect(Collectors.toList());

		int timeCount = 0;

		for (int id : intersect) {
			int[] time = idMap.get(id);
			int diff = time[1] - time[0];
			timeCount += diff;
		}

		return (double)Math.round(timeCount / intersect.size() * 100000d) / 100000d;
	}

	public static void main(String[] args) {
		/*
		 * l : [[3,10], []] w : [[], [15,20]]
		 */

	}
}

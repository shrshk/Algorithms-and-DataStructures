package bloombergPractice;

import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;

public class UndergroundSystem {

	Map<Integer, Pair<String, Integer>> checkInMap;
	Map<String, Pair<Integer, Integer>> checkOutMap;

	public UndergroundSystem() {
		checkInMap = new HashMap<>();
		checkOutMap = new HashMap<>();
	}

	public void checkIn(int id, String stationName, int t) {
		checkInMap.put(id, new Pair<>(stationName, t));
	}

	public void checkOut(int id, String stationName, int t) {
		String checkInStation = checkInMap.get(id).getKey();
		Integer checkInTime = checkInMap.get(id).getValue();

		String routeKey = checkInStation + "_" + stationName;
		int timeTaken = t - checkInTime;

		Pair<Integer, Integer> routePair = checkOutMap.getOrDefault(routeKey, new Pair<>(0, 0));
		checkOutMap.put(routeKey, new Pair<>(routePair.getKey() + timeTaken, routePair.getValue() + 1));
	}

	public double getAverageTime(String startStation, String endStation) {

		String routeKey = startStation + "_" + endStation;

		Pair<Integer, Integer> routePair = checkOutMap.get(routeKey);

		return (double) routePair.getKey() / routePair.getValue();
	}
}

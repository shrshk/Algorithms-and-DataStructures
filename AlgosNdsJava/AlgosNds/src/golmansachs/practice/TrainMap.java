package golmansachs.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

class Station {
	private String name;
	private List<Station> neighbours;

	public Station(String name) {
		this.name = name;
		this.neighbours = new ArrayList<>(3);
	}

	String getName() {
		return name;
	}

	void addNeighbour(Station v) {
		this.neighbours.add(v);
	}

	List<Station> getNeighbours() {
		return this.neighbours;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Station && this.name.equals(((Station) obj).getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.name);
	}
}

public class TrainMap {

	private HashMap<String, Station> stations;

	public TrainMap() {
		this.stations = new HashMap<>();
	}

	public TrainMap addStation(String name) {
		Station s = new Station(name);
		this.stations.putIfAbsent(name, s);
		return this;
	}

	public Station getStation(String name) {
		return this.stations.get(name);
	}

	public TrainMap connectStations(Station fromStation, Station toStation) {
		if (fromStation == null) {
			throw new IllegalArgumentException("From station is null");
		}
		if (toStation == null) {
			throw new IllegalArgumentException("From station is null");
		}
		fromStation.addNeighbour(toStation);
		toStation.addNeighbour(fromStation);
		return this;
	}

	public List<Station> shortestPath(String from, String to) {
		/*
		 * TODO Implement
		 */

		Map<Station, Station> path = new HashMap<>();

		List<Station> result = new ArrayList<>();

		Queue<Station> q = new ArrayDeque<>();

		q.add(stations.get(from));
		path.put(stations.get(from), null);

		while (!q.isEmpty()) {
			Station current = q.poll();
			if (current.getName().equals(to))
				break;
			for (Station neighbor : current.getNeighbours()) {
				if (!path.containsKey(neighbor)) {
					q.add(neighbor);
					System.out.println(neighbor.getName() + " -- " + current.getName());
					path.put(neighbor, current);
				}

			}
		}		

		Station dest = stations.get(to);

		while (dest != null) {
			result.add(dest);
			dest = path.get(dest);
		}

		Collections.reverse(result);

		return result;
	}

	public static String convertPathToStringRepresentation(List<Station> path) {
		if (path.isEmpty()) {
			return "";
		}
		return path.stream().map(Station::getName).reduce((s1, s2) -> s1 + "->" + s2).get();
	}

	public static void main(String[] args) {
		TrainMap trainMap = new TrainMap();

		trainMap.addStation("King's Cross St Pancras").addStation("Angel").addStation("Old Street")
				.addStation("Moorgate").addStation("Farringdon").addStation("Barbican").addStation("Russel Square")
				.addStation("Holborn").addStation("Chancery Lane").addStation("St Paul's").addStation("Bank");

		trainMap.connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Angel"))
				.connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Farringdon"))
				.connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Russel Square"))
				.connectStations(trainMap.getStation("Russel Square"), trainMap.getStation("Holborn"))
				.connectStations(trainMap.getStation("Holborn"), trainMap.getStation("Chancery Lane"))
				.connectStations(trainMap.getStation("Chancery Lane"), trainMap.getStation("St Paul's"))
				.connectStations(trainMap.getStation("St Paul's"), trainMap.getStation("Bank"))
				.connectStations(trainMap.getStation("Angel"), trainMap.getStation("Old Street"))
				.connectStations(trainMap.getStation("Old Street"), trainMap.getStation("Moorgate"))
				.connectStations(trainMap.getStation("Moorgate"), trainMap.getStation("Bank"))
				.connectStations(trainMap.getStation("Farringdon"), trainMap.getStation("Barbican"))
				.connectStations(trainMap.getStation("Barbican"), trainMap.getStation("Moorgate"));

		// TrainMap map = new TrainMap();
		// map.addStation("K");
		// map.addStation("A");
		// map.addStation("O");
		// map.addStation("M");
		// map.addStation("Bn");
		// map.addStation("S");
		// map.addStation("C");
		// map.addStation("H");
		// map.addStation("R");
		// map.addStation("K");
		// map.addStation("F");
		// map.addStation("B");
		//
		// map.getStation("K").addNeighbour(map.getStation("A"));
		// map.getStation("K").addNeighbour(map.getStation("A"));
		// map.getStation("K").addNeighbour(map.getStation("F"));
		// map.getStation("K").addNeighbour(map.getStation("R"));
		//
		// map.getStation("A").addNeighbour(map.getStation("O"));
		// map.getStation("A").addNeighbour(map.getStation("K"));
		//
		// map.getStation("O").addNeighbour(map.getStation("M"));
		// map.getStation("O").addNeighbour(map.getStation("A"));
		//
		// map.getStation("M").addNeighbour(map.getStation("Bn"));
		// map.getStation("M").addNeighbour(map.getStation("B"));
		// map.getStation("M").addNeighbour(map.getStation("O"));
		//
		//
		// map.getStation("B").addNeighbour(map.getStation("S"));
		// map.getStation("B").addNeighbour(map.getStation("M"));
		//
		// map.getStation("S").addNeighbour(map.getStation("C"));
		// map.getStation("S").addNeighbour(map.getStation("B"));
		//
		// map.getStation("C").addNeighbour(map.getStation("H"));
		// map.getStation("C").addNeighbour(map.getStation("S"));
		//
		// map.getStation("H").addNeighbour(map.getStation("R"));
		// map.getStation("H").addNeighbour(map.getStation("C"));
		//
		// map.getStation("R").addNeighbour(map.getStation("K"));
		// map.getStation("R").addNeighbour(map.getStation("H"));
		//
		// map.getStation("Bn").addNeighbour(map.getStation("F"));
		// map.getStation("Bn").addNeighbour(map.getStation("M"));
		//
		// map.getStation("F").addNeighbour(map.getStation("K"));
		//
		// map.getStation("F").addNeighbour(map.getStation("Bn"));

		System.out.println(trainMap.shortestPath("King's Cross St Pancras", "Old Street"));

	}
}
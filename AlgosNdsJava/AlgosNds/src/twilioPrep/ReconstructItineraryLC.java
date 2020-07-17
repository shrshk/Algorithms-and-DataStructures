package twilioPrep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItineraryLC {
	Map<String, PriorityQueue<String>> flights;
	LinkedList<String> path;

	public List<String> findItinerary(String[][] tickets) {
		flights = new HashMap<>();
		path = new LinkedList<>();
		for (String[] ticket : tickets) {
			flights.putIfAbsent(ticket[0], new PriorityQueue<>());
			flights.get(ticket[0]).add(ticket[1]);
		}
		dfs("JFK");
		return path;
	}

	public void dfs(String departure) {
		PriorityQueue<String> arrivals = flights.get(departure);
		while (arrivals != null && !arrivals.isEmpty())
			dfs(arrivals.poll());
		path.addFirst(departure);
	}
	
	public static void main(String[] args) {
		List<List<String>> ticketList = Arrays.asList(Arrays.asList("JFK","KUL"), Arrays.asList("JFK","NRT"),
				Arrays.asList("NRT","JFK"));
		String[][] tickets = new String[ticketList.size()][2];
		
		for (int i=0; i<ticketList.size(); i++) {
			tickets[i][0] = ticketList.get(i).get(0);
			tickets[i][1] = ticketList.get(i).get(1);
		}
		
		System.out.println(new ReconstructItineraryLC().findItinerary(tickets));
	}
}

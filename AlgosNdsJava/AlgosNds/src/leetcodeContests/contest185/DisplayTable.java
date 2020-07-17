package leetcodeContests.contest185;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DisplayTable {
	// Input: orders = [["David","3","Ceviche"],["Corina","10","Beef
	// Burrito"],["David","3","Fried
	// Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
	// Output: [["Table","Beef Burrito","Ceviche","Fried
	// Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
	public List<List<String>> displayTable(List<List<String>> orders) {

		// 3->[2ce,1Fc ]
		// c
		// items -> [b,c,f,w]
		// tables -> [3,5,10]
		// counts -> []
		// c -> [3,3,5] <>
		// f -> [3]
		// w -> 5
		// b -> 10

		List<String> items = new ArrayList<>();
		List<String> tables = new ArrayList<>();
		Map<String, Map<String, Integer>> counts = new HashMap<>();

		for (List<String> order : orders) {
			String item = order.get(2);
			String table = order.get(1);
			if (!tables.contains(table))
				tables.add(table);
			if (!items.contains(item))
				items.add(item);
			Map<String, Integer> itemFreq = counts.getOrDefault(item, new HashMap<>());
			itemFreq.put(table, itemFreq.getOrDefault(table, 0) + 1);
			counts.put(item, itemFreq);
		}

		List<List<String>> res = new ArrayList<>();
		List<String> header = new ArrayList<>();

		header.add("Table");

		Collections.sort(items);
		tables.sort((t1,t2) -> (Integer.valueOf(t1)-Integer.valueOf(t2)));

		for (String item : items) {
			header.add(item);
		}

		res.add(header);

		for (String table : tables) {
			List<String> row = new ArrayList<>();
			row.add(table);
			for (String item : items) {
				Map<String, Integer> itemFreq = counts.get(item);
				int freq = 0;
				if (itemFreq.containsKey(table))
					freq = itemFreq.get(table);
				row.add(String.valueOf(freq));
			}
			res.add(row);
		}

		return res;
	}

	public static void main(String[] args) {
		// [["David","3","Ceviche"],["Corina","10","Beef
		// Burrito"],["David","3","Fried
		// Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
		List<String> x = new ArrayList<>();
		x.add("Ceviche");
		x.add("Beef Burrito");
		Collections.sort(x);
		System.out.println(x.toString());
		Set<String> set = new HashSet<>(x);
		System.out.println(set.toString());

	}
}

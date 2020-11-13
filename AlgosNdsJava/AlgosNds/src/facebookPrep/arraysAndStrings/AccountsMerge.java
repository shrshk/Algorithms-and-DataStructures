package facebookPrep.arraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class AccountsMerge {
	public List<List<String>> accountsMerge(List<List<String>> acts) {
		Map<String, String> owner = new HashMap<>();
		Map<String, String> parent = new HashMap<>();
		Map<String, TreeSet<String>> unions = new HashMap<>();
		
		// set owner to each email and set parent as self
		for (List<String> acct: acts) {
			String name = acct.get(0);
			for (int i=1; i<acct.size(); i++) {
				parent.put(acct.get(i), acct.get(i));
				owner.put(acct.get(i), name);
			}
		}
		
		
		for (List<String> acct: acts) {
			String p = find(acct.get(1), parent);
			for (int i=2; i<acct.size(); i++) {
				parent.put(find(acct.get(i), parent), p);
			}
		}
		
		for (List<String> acct: acts) {
			String p = find(acct.get(1), parent);
			unions.putIfAbsent(p, new TreeSet<>());	
			for (int i=1; i<acct.size(); i++) {
				unions.get(p).add(acct.get(i));
			}
		}
		
		List<List<String>> res = new ArrayList<>();
		
		for (String key: unions.keySet()) {
			List<String> emails = new ArrayList<>(unions.get(key));
			emails.add(0, owner.get(key));
			res.add(emails);
		}

		return res;
	}
	
	private String find(String s, Map<String, String> parent) {
		return parent.get(s).equals(s) ? parent.get(s) : find(parent.get(s), parent);
	}
}

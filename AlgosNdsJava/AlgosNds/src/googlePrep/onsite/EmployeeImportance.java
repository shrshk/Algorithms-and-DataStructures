package googlePrep.onsite;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javafx.util.Pair;

class Employee {
	public int id;
	public int importance;
	public List<Integer> subordinates;
};

public class EmployeeImportance {
	public int getImportance(List<Employee> employees, int id) {
		// treat the input as graph
		// loop thru levels with bfs
		// every level calculate importance.

		// {1: {5: [2,3]}}

		Map<Integer, Pair<Integer, List<Integer>>> map = new HashMap<>();

		for (Employee employee : employees) {
			map.put(employee.id, new Pair<>(employee.importance, employee.subordinates));
		}

		Queue<Pair<Integer, List<Integer>>> q = new ArrayDeque<>();

		Set<Integer> visited = new HashSet<>();
		int importance = 0;

		q.add(map.get(id));
		visited.add(id);

		while (!q.isEmpty()) {
			Pair<Integer, List<Integer>> curr = q.poll();
			importance += curr.getKey();
			List<Integer> emps = curr.getValue();
			for (int emp : emps) {
				if (!visited.contains(emp)) {
					q.add(map.get(emp));
					visited.add(emp);
				}
			}
		}

		return importance;
	}

	Map<Integer, Employee> map;

	public int getImportanceDFS(List<Employee> employees, int id) {
		map = new HashMap<>();
		
		LinkedList<Integer> q = new LinkedList<Integer>();
		

		for (Employee e : employees) {
			map.put(e.id, e);
		}

		return dfs(id);

	}

	private int dfs(int id) {
		Employee emp = map.get(id);
		int importance = emp.importance;
		for (int sub : emp.subordinates) {
			importance += dfs(sub);
		}
		return importance;
	}
}

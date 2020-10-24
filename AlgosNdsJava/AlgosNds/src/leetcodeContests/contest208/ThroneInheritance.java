package leetcodeContests.contest208;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Person {
	String name;
	Person parent;
	List<Person> children;
	Boolean isAlive;

	Person(String name, Person parent) {
		this.name = name;
		this.parent = parent;
		this.children = new ArrayList<>();
		this.isAlive = true;
	}
}

public class ThroneInheritance {
	Map<String, Person> kingdom;
	List<Person> inheritanceOrder;
	String king;

	public ThroneInheritance(String kingName) {
		king = kingName;
		kingdom = new HashMap<>();
		inheritanceOrder = new ArrayList<>();
		Person king = new Person(kingName, null);
		inheritanceOrder.add(king);
		kingdom.put(kingName, king);
	}

	public void birth(String parentName, String childName) {
		Person parent = kingdom.getOrDefault(parentName, new Person(parentName, null));
		Person child = kingdom.getOrDefault(childName, new Person(childName, parent));
		List<Person> children = parent.children;
		children.add(child);
		kingdom.put(parentName, parent);
		kingdom.put(childName, child);
		Person succ = successor(parent);
		for (int i=0; i<inheritanceOrder.size(); i++) {
			Person x = inheritanceOrder.get(i);
			if (x.name.equals(parentName)) {
				inheritanceOrder.add(i+1, succ);
			}
		}
	}

	public void death(String name) {
		Person deadPerson = kingdom.get(name);
		deadPerson.isAlive = false;
	}

	public List<String> getInheritanceOrder() {
		List<String> res = new ArrayList<>();
		for (Person p : inheritanceOrder) {
			if (p.isAlive)
				res.add(p.name);
		}

		return res;
	}

	private Person successor(Person x) {
		if (x.children.isEmpty() || allXChildrenInOrder(x)) {
			if (x.name.equals(king)) {
				return null;
			}
			return successor(x.parent);
		}
		return getOldestChildNotInOrder(x);
	}

	private boolean allXChildrenInOrder(Person x) {
		for (Person child : x.children) {
			if (!inheritanceOrder.contains(child))
				return false;
		}
		return true;
	}

	private Person getOldestChildNotInOrder(Person x) {
		for (Person child : x.children) {
			if (inheritanceOrder.contains(child)) {
				continue;
			}
			return child;
		}
		return null;
	}

	// Successor(x, curOrder):
	// if x has no children or all of x's children are in curOrder:
	// if x is the king return null
	// else return Successor(x's parent, curOrder)
	// else return x's oldest child who's not in curOrder

}

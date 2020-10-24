package javaConcepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Node {
	int val;
	
	int getVal() {
		return val;
	}
}

class Person {
	int age;
	String name;
	Node c;

	Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	int getAge() {
		return age;
	}
	
	Node getC() {
		return c;
	}
}

class X {
	List<Person> p;

	X() {
		p = new ArrayList<>();
	}

	List<Person> getP() {
		return p;
	}
}

public class Streams {
	// optional

	public static void main(String[] args) {
		X x = new X();

//		Optional.of(x).map(X::getP).map(list -> list.get(0)).map(Person::getAge)
//				.ifPresent(a -> System.out.println(a));
		
		Person per = new Person(20, "a");
		
		
		Optional.of(per)
		.map(Person::getC).map(Node::getVal).ifPresent(val -> System.out.println(val));

	}
}

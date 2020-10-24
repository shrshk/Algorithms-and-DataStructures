package golmansachs.practice;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

class Student {
	String name;
	String marks;

	Student(String name, String marks) {
		this.name = name;
		this.marks = marks;
	}
}

public class StudentAverage {
	public int studentWithHighestAvgMarks(List<Student> students) {
		int res = 0;
		Map<String, List<Integer>> avgMap = new HashMap<>();
		for (Student student : students) {
			List<Integer> marks = avgMap.get(student.name) != null ? avgMap.get(student.name) : new ArrayList<>();
			marks.add(Integer.parseInt(student.marks));
			avgMap.put(student.name, marks);
		}

		for (Entry<String, List<Integer>> entry : avgMap.entrySet()) {
			res = Math.max(res, average(entry.getKey(), avgMap));
		}

		return res;
	}

	private int average(String name, Map<String, List<Integer>> map) {
		int total = 0;
		List<Integer> marks = map.get(name);
		for (int score : marks) {
			total += score;
		}
		return (int) Math.floor(total / marks.size());
	}

	public static void main(String[] args) throws DatatypeConfigurationException {
		// [{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike",
		// "55"}, {"Jessica", "99"}]
		Student bob = new Student("Bob", "87");
		Student mike = new Student("Mike", "35");
		Student bob2 = new Student("Bob", "52");
		Student Jason = new Student("Jason", "35");
		Student mike2 = new Student("Mike", "55");
		Student Jessica = new Student("Jessica", "99");

		List<Student> students = new ArrayList<>();
		students.add(bob);
		students.add(mike);
		students.add(bob2);
		students.add(Jason);
		students.add(mike2);
		students.add(Jessica);
//		System.out.println(new StudentAverage().studentWithHighestAvgMarks(students));
		
        XMLGregorianCalendar cal = DatatypeFactory.newInstance()
                .newXMLGregorianCalendar(GregorianCalendar.from(null));
        
        System.out.println(cal.toString());
		
	}
}

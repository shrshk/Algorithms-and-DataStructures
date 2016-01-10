package assignment03;

import java.util.Arrays;



public class EmployeeSorter {
	private Employee[] employees;
	
	public EmployeeSorter(int size) {
		this.employees = new Employee[size];
	}
	
	public void sort() {
		for (int i = 0; i < employees.length; i++) {
			Employee current = employees[i];
			int j = i-1;
			while (j >=0 && employees[j].employeeNumber >= current.employeeNumber) {
				employees[j+1] = employees[j];
				j--;
			}
			employees[j+1] = current;
		}
	}
	
	public static void main(String[] args) {
		EmployeeSorter sorter = new EmployeeSorter(4);
		Employee emp1 = new Employee(100000009, "John","Doe", "john.doe@dsnalgos.com");
		sorter.employees[0] = emp1;
		Employee emp2 = new Employee(100000002, "Patrick","Dwight", "patrick.dwight@dsnalgos.com");
		sorter.employees[1] = emp2;
		Employee emp3 = new Employee(100000011, "Marlo","Thomas", "marlo.thomas@dsnalgos.com");
		sorter.employees[2] = emp3;
		Employee emp4 = new Employee(100000004, "Barbara","Weatherspoon", "barbara.weatherspoon@dsnalgos.com");
		sorter.employees[3] = emp4;
		sorter.sort();
		System.out.println(Arrays.deepToString(sorter.employees));
	}
	
}

class Employee {
	public int employeeNumber;
	public String firstName;
	public String lastName;
	public String email;
	
	public Employee(int employeeNumber, String firstName, String lastName,
			String email) {
		this.employeeNumber = employeeNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public String toString() {
		return this.employeeNumber + " : " + this.email;
	}

}

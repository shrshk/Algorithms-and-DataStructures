package com.AlgosAndDs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeInsertionSortImpl {

	// public static void createEmployeeObjects(){
	// // for(int i=1;i<=4;i++){
	// // List<Employee> empList = new ArrayList<Employee>();
	// // empList.add(new Employee());
	// //
	// // }
	private Employee[] empList;

	public EmployeeInsertionSortImpl(int size) {
		// super();
		this.empList = new Employee[size];
	}

	public void EmpSorter() {
		for (int i = 1; i < empList.length; i++) {
			Employee current = empList[i];
			int j;
			for (j = i - 1; j >= 0
					&& current.EmployeeNumber > empList[i].EmployeeNumber; j--) {
				empList[j] = empList[j + 1];
			}
			empList[j + 1] = current;

		}

	}

	public static void main(String[] args) {
		// //createEmployeeObjects();
		// Employee emp1 = new Employee();
		// Employee emp2 = new Employee();
		// Employee emp3 = new Employee();
		// emp1.setEmployeeNumber(4);
		// emp2.setEmployeeNumber(6);
		// emp3.setEmployeeNumber(8);
		//
		// List<Employee> empList = new ArrayList<Employee>();
		// empList.add(emp1);
		// empList.add(emp1);
		// empList.add(emp1);
		// for(int i=1;i<((CharSequence) empList).length();i++){
		// int EmployeeNumberTemp;
		// EmployeeNumberTemp = empList.get(i).getEmployeeNumber();
		// for(int
		// j=i-1;j>=0&&EmployeeNumberTemp<empList.get(j).getEmployeeNumber();j--){
		// empList.get(j+1).setEmployeeNumber(empList.get(j).getEmployeeNumber());
		// empList.get(j+1).setEmployeeNumber(EmployeeNumberTemp);
		// }
		//
		//
		// }
		EmployeeInsertionSortImpl employeeInsertionSortImpl = new EmployeeInsertionSortImpl(
				4);
		Employee emp1 = new Employee(1001, "harish", "kamuju",
				"harish.kamuju@gmail.com");
		employeeInsertionSortImpl.empList[0] = emp1;
		Employee emp2 = new Employee(1003, "amit", "devaramani",
				"amit.devaramani@gmail.com");
		employeeInsertionSortImpl.empList[1] = emp2;
		Employee emp3 = new Employee(1005, "akshay", "malhotra",
				"akshay.malhotra@gmail.com");
		employeeInsertionSortImpl.empList[2] = emp3;
		Employee emp4 = new Employee(1004, "shirish", "veerabattini",
				"shirish.veerabattini@gmail.com");
		employeeInsertionSortImpl.empList[3] = emp4;

		employeeInsertionSortImpl.EmpSorter();
		System.out.println(Arrays
				.deepToString(employeeInsertionSortImpl.empList));

	}

}

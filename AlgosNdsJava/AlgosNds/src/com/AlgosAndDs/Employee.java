package com.AlgosAndDs;

public class Employee {
	int EmployeeNumber;
	String FirstName;
	String LastName;
	String EmailId;

	

	public Employee(int employeeNumber, String firstName, String lastName,
			String emailId) {
		// super();
		EmployeeNumber = employeeNumber;
		FirstName = firstName;
		LastName = lastName;
		EmailId = emailId;
	}



	@Override
	public String toString() {
		return "Employee [EmployeeNumber=" + EmployeeNumber + ", FirstName="
				+ FirstName + ", LastName=" + LastName + ", EmailId=" + EmailId
				+ "]";
	}

	

}

package designPatterns.bestpractices;

public class Person {
	private final String firstName;
	private final String lastName;
	private final String email;
	private final String phoneNumber;

	private Person(PersonBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.email = builder.email;
		this.phoneNumber = builder.phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public static class PersonBuilder {
		private final String firstName;
		private final String lastName;
		private String email;
		private String phoneNumber;

		public PersonBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public PersonBuilder email(String email) {
			this.email = email;
			return this;
		}

		public PersonBuilder phoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public Person build() {
			Person person = new Person(this);
			return person;
		}
	}

}

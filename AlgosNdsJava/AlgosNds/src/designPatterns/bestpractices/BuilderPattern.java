package designPatterns.bestpractices;

// Builder Pattern and advantages of immutability
// no setters enforces immutability 
// multiple constructors help enforce required and optional parameters.
class User {
	// All final attributes
	private final String firstName; // required
	private final String lastName; // required
	private final int age; // optional
	private final String phone; // optional
	private final String address; // optional

	private User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}

	// All getter, and NO setter to provde immutability
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "User: " + this.firstName + ", " + this.lastName + ", " + this.age + ", " + this.phone + ", "
				+ this.address;
	}

	public static class UserBuilder {
		private final String firstName;
		private final String lastName;
		private int age;
		private String phone;
		private String address;

		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public UserBuilder age(int age) {
			this.age = age;
			return this;
		}

		public UserBuilder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}

		// Return the finally constructed User object
		public User build() {
			User user = new User(this);
			validateUserObject(user);
			return user;
		}

		private void validateUserObject(User user) {
			// Do some basic validations to check
			// if user object does not break any assumption of system
		}

	}
}

public class BuilderPattern {
	public static void main(String[] args) {
		User user1 = new User.UserBuilder("Shirish", "Veerabattini").age(30).phone("1234567").address("Fake address 1234")
				.build();

		System.out.println(user1);

		User user2 = new User.UserBuilder("Spider", "Man").age(40).phone("5655")
				// no address
				.build();

		System.out.println(user2);

		User user3 = new User.UserBuilder("Bat", "Man")
				// No age
				// No phone
				// no address
				.build();

		System.out.println(user3);
	}
}

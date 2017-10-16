package fields.enus;

import fields.PersonBuilderInterface;
import fields.PersonInterface;

public class Person implements PersonInterface {

	private final String firstName;
	private final String lastName;
	private final String title;
	private final String cellphone;
	private final String email;

	public Person(PersonBuilder pb) {
		this.firstName = pb.getFirstName();
		this.lastName = pb.getLastName();
		this.title = pb.getTitle();
		this.cellphone = pb.getCellphone();
		this.email = pb.getEmail();
	}

	public String toString() {
		return (title != null ? title + " " : "") + lastName + ", " + firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getTitle() {
		return title;
	}

	public String getCellphone() {
		return cellphone;
	}

	public String getEmail() {
		return email;
	}

	public static class PersonBuilder implements PersonBuilderInterface {

		private String firstName;
		private String lastName;
		private String title;
		private String cellphone;
		private String email;

		public PersonBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public PersonBuilder title(String title) {
			this.title = title;
			return this;
		}

		public PersonBuilder cellphone(String cellphone) {
			this.cellphone = cellphone;
			return this;
		}

		public PersonBuilder email(String email) {
			this.email = email;
			return this;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public String getTitle() {
			return title;
		}

		public String getCellphone() {
			return cellphone;
		}

		public String getEmail() {
			return email;
		}

		public Person build() {
			return new Person(this);
		}

	}

}

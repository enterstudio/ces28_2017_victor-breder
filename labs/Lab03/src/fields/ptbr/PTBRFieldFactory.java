package fields.ptbr;

import fields.AddressInterface;
import fields.DateInterface;
import fields.FieldFactoryInterface;
import fields.PersonBuilderInterface;

public class PTBRFieldFactory implements FieldFactoryInterface {

	public PersonBuilderInterface createPersonBuilder(String firstName, String lastName) {
		return new Person.PersonBuilder(firstName, lastName);
	}

	public AddressInterface createAddress(String street, String city, String state, String country, String zipCode) {
		return new Address(street, city, state, country, zipCode);
	}

	public DateInterface createDate(int year, int month, int day) {
		return new Date(year, month, day);
	}

}

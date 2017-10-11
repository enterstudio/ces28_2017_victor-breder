package fields.ptbr;

import fields.AddressInterface;

public class Address implements AddressInterface {

	private final String street;
	private final String city;
	private final String state;
	private final String country;
	private final String zipCode;

	public Address(String street, String city, String state, String country, String zipCode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(street);
		sb.append("\n");
		sb.append(city);
		sb.append(" - ");
		sb.append(state);
		sb.append(" - ");
		sb.append(zipCode);
		sb.append("\n");
		sb.append(country);
		sb.append("\n");
		return sb.toString();
	}

}

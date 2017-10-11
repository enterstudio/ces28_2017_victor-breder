package fields;

public interface FieldFactoryInterface {

	public PersonBuilderInterface createPersonBuilder(String firstName, String lastName);

	public AddressInterface createAddress(String street, String city, String state, String country, String zipCode);

	public DateInterface createDate(int year, int month, int date);

}

package fields;

public interface PersonBuilderInterface {

	public PersonBuilderInterface title(String cellphone);

	public PersonBuilderInterface cellphone(String cellphone);

	public PersonBuilderInterface email(String email);

	public String getFirstName();

	public String getLastName();

	public String getTitle();

	public String getCellphone();

	public String getEmail();

	public PersonInterface build();
}

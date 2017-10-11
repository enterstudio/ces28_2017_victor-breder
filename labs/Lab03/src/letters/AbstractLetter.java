package letters;

import fields.AddressInterface;
import fields.DateInterface;
import fields.PersonInterface;

abstract public class AbstractLetter {

	protected PersonInterface sender;
	protected PersonInterface destinatary;
	protected AddressInterface addressSender;
	protected AddressInterface addressDestinatary;
	protected DateInterface date;

	public AbstractLetter(PersonInterface sender, PersonInterface destinatary, AddressInterface addressSender,
			AddressInterface addressDestinatary, DateInterface date) {
		this.sender = sender;
		this.destinatary = destinatary;
		this.addressSender = addressSender;
		this.addressDestinatary = addressDestinatary;
		this.date = date;
	}

	public String model() {
		return header() + body() + conclusion() + signature();
	}

	public abstract String header();

	public abstract String body();

	public abstract String conclusion();

	public abstract String signature();

}

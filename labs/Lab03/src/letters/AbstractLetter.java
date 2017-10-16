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

	protected abstract String header();

	protected abstract String body();

	protected abstract String conclusion();

	protected abstract String signature();

	public void setSender(PersonInterface sender) {
		this.sender = sender;
	}

	public void setDestinatary(PersonInterface destinatary) {
		this.destinatary = destinatary;
	}

	public void setAddressSender(AddressInterface addressSender) {
		this.addressSender = addressSender;
	}

	public void setAddressDestinatary(AddressInterface addressDestinatary) {
		this.addressDestinatary = addressDestinatary;
	}

	public void setDate(DateInterface date) {
		this.date = date;
	}

}

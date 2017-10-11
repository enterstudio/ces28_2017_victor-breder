package letters;

import fields.AddressInterface;
import fields.DateInterface;
import fields.PersonInterface;

public class CommercialLetterENUS extends AbstractLetter {

	public CommercialLetterENUS(PersonInterface sender, PersonInterface destinatary, AddressInterface addressSender,
			AddressInterface addressDestinatary, DateInterface date) {
		super(sender, destinatary, addressSender, addressDestinatary, date);
	}

	public String header() {
		return date + "\n\n" + sender + "\n" + addressSender + "\n" + destinatary + "\n" + addressDestinatary + "\n"
				+ "---\n\n";
	}

	public String body() {
		return "Dear " + destinatary + "\n\n";
	}

	public String conclusion() {
		return "Sincerely,\n\n";
	}

	public String signature() {
		return sender + "\n\n---\n\n" + sender.getCellphone() + "\n" + sender.getEmail() + "\n";
	}

}

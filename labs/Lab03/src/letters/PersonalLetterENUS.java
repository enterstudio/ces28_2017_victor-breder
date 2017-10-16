package letters;

import fields.AddressInterface;
import fields.DateInterface;
import fields.PersonInterface;

public class PersonalLetterENUS extends AbstractLetter {

	public PersonalLetterENUS(PersonInterface sender, PersonInterface destinatary, AddressInterface addressSender,
			AddressInterface addressDestinatary, DateInterface date) {
		super(sender, destinatary, addressSender, addressDestinatary, date);
	}

	public String header() {
		return date + "\n\n" + sender + "\n" + addressSender + "\n" + destinatary + "\n" + addressDestinatary + "\n"
				+ "---\n\n";
	}

	public String body() {
		return "Howdy " + destinatary.getFirstName() + "?\n\n";
	}

	public String conclusion() {
		return "Cheers,\n\n";
	}

	public String signature() {
		return sender.getFirstName() + "\n";
	}

}

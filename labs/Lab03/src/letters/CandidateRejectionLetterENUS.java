package letters;

import fields.AddressInterface;
import fields.DateInterface;
import fields.PersonInterface;

public class CandidateRejectionLetterENUS extends AbstractLetter {

	public CandidateRejectionLetterENUS(PersonInterface sender, PersonInterface destinatary, AddressInterface addressSender,
			AddressInterface addressDestinatary, DateInterface date) {
		super(sender, destinatary, addressSender, addressDestinatary, date);
	}

	public String header() {
		return date + "\n\n" + destinatary + "\n" + addressDestinatary + "\n" + "---\n\n";
	}

	public String body() {
		return "Dear " + destinatary + ",\n\n" + "Thank you for your application for the position XXX at XXX.\n"
				+ "As you can imagine, we received a large number of applications.\n"
				+ "I am sorry to inform you that you have not been selected for an\ninterview for this position.\n\n";
	}

	public String conclusion() {
		return "Best,\n\n";
	}

	public String signature() {
		return sender + "\n\n---\n" + sender.getEmail() + "\n" + addressSender + "\n";
	}

}

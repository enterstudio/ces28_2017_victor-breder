package letters;

import fields.AddressInterface;
import fields.DateInterface;
import fields.PersonInterface;

public class CommercialLetterPTBR extends AbstractLetter {

	public CommercialLetterPTBR(PersonInterface sender, PersonInterface destinatary, AddressInterface addressSender,
			AddressInterface addressDestinatary, DateInterface date) {
		super(sender, destinatary, addressSender, addressDestinatary, date);
	}

	public String header() {
		return date + "\n\n" + sender + "\n" + addressSender + "\n" + destinatary + "\n" + addressDestinatary + "\n"
				+ "---\n\n";
	}

	public String body() {
		return "Querido " + destinatary + "\n\n";
	}

	public String conclusion() {
		return "Atenciosamente,\n\n";
	}

	public String signature() {
		return sender + "\n\n---\n\n" + sender.getCellphone() + "\n" + sender.getEmail() + "\n";
	}

}

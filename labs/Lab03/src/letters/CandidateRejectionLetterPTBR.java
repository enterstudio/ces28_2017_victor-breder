package letters;

import fields.AddressInterface;
import fields.DateInterface;
import fields.PersonInterface;

public class CandidateRejectionLetterPTBR extends AbstractLetter {
	public CandidateRejectionLetterPTBR(PersonInterface sender, PersonInterface destinatary, AddressInterface addressSender,
			AddressInterface addressDestinatary, DateInterface date) {
		super(sender, destinatary, addressSender, addressDestinatary, date);
	}

	public String header() {
		return date + "\n\n" + destinatary + "\n" + addressDestinatary + "\n" + "---\n\n";
	}

	public String body() {
		return "Querido " + destinatary + ",\n\n" + "Obrigado por sua aplicação para a posição XXX na XXX.\n"
				+ "Como você deve imaginar, nós recebemos um grande numero de aplicações.\n"
				+ "Sinto-lhe informar que não foi selecionado para a\nentrevista para a posição.\n\n";
	}

	public String conclusion() {
		return "Felicidades,\n\n";
	}

	public String signature() {
		return sender + "\n\n---\n" + sender.getEmail() + "\n" + addressSender + "\n";
	}
}

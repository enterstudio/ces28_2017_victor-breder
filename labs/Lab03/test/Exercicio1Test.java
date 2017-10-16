import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fields.AddressInterface;
import fields.DateInterface;
import fields.PersonInterface;
import fields.ptbr.Address;
import fields.ptbr.Date;
import fields.ptbr.Person.PersonBuilder;
import letters.AbstractLetter;
import letters.CandidateRejectionLetterENUS;
import letters.CommercialLetterENUS;
import letters.PersonalLetterENUS;

public class Exercicio1Test {

	private PersonInterface laurival;
	private PersonInterface ivan;
	private AddressInterface laurivalAddress;
	private AddressInterface ivanAddress;
	private DateInterface date;

	@Before
	public void setup() {
		laurival = new PersonBuilder("Laurival", "Neto").cellphone("12 91234-5678").email("lauriv@l.com").build();
		ivan = new PersonBuilder("Ivan", "Padalko").title("Mr.").cellphone("12 91234-5678").email("iv@n.com").build();
		laurivalAddress = new Address("Rua H8B", "Estrela", "SP", "Brazil", "12224-468");
		ivanAddress = new Address("Rua H8A", "Lua", "SP", "Brazil", "12224-469");
		date = new Date(2017, 12, 31);
	}

	@Test
	public void testCommercialLetter() {
		AbstractLetter letter = new CommercialLetterENUS(laurival, ivan, laurivalAddress, ivanAddress, date);
		assertEquals("31/12/2017\n" + "\n" + "Laurival Neto\n" + "Rua H8B\n" + "Estrela - SP - 12224-468\n" + "Brazil\n"
				+ "\n" + "Mr. Ivan Padalko\n" + "Rua H8A\n" + "Lua - SP - 12224-469\n" + "Brazil\n" + "\n" + "---\n"
				+ "\n" + "Dear Mr. Ivan Padalko\n" + "\n" + "Sincerely,\n" + "\n" + "Laurival Neto\n" + "\n" + "---\n"
				+ "\n" + "12 91234-5678\n" + "lauriv@l.com\n", letter.model());
	}

	@Test
	public void testPersonalLetter() {
		AbstractLetter letter = new PersonalLetterENUS(laurival, ivan, laurivalAddress, ivanAddress, date);
		assertEquals("31/12/2017\n" + "\n" + "Laurival Neto\n" + "Rua H8B\n" + "Estrela - SP - 12224-468\n" + "Brazil\n"
				+ "\n" + "Mr. Ivan Padalko\n" + "Rua H8A\n" + "Lua - SP - 12224-469\n" + "Brazil\n" + "\n" + "---\n"
				+ "\n" + "Howdy Ivan?\n" + "\n" + "Cheers,\n" + "\n" + "Laurival\n", letter.model());
	}

	@Test
	public void testCandidateRejectionLetter() {
		AbstractLetter letter = new CandidateRejectionLetterENUS(laurival, ivan, laurivalAddress, ivanAddress, date);
		assertEquals(
				"31/12/2017\n" + "\n" + "Mr. Ivan Padalko\n" + "Rua H8A\n" + "Lua - SP - 12224-469\n" + "Brazil\n"
						+ "\n" + "---\n" + "\n" + "Dear Mr. Ivan Padalko,\n" + "\n"
						+ "Thank you for your application for the position XXX at XXX.\n"
						+ "As you can imagine, we received a large number of applications.\n"
						+ "I am sorry to inform you that you have not been selected for an\n"
						+ "interview for this position.\n" + "\n" + "Best,\n" + "\n" + "Laurival Neto\n" + "\n"
						+ "---\n" + "lauriv@l.com\n" + "Rua H8B\n" + "Estrela - SP - 12224-468\n" + "Brazil\n\n",
				letter.model());
	}

}

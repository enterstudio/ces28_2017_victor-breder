import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fields.AddressInterface;
import fields.DateInterface;
import fields.PersonInterface;
import fields.enus.ENUSFieldFactory;
import fields.ptbr.PTBRFieldFactory;
import letters.AbstractLetter;
import letters.CandidateRejectionLetterENUS;
import letters.CandidateRejectionLetterPTBR;
import letters.CommercialLetterENUS;
import letters.CommercialLetterPTBR;
import letters.PersonalLetterENUS;
import letters.PersonalLetterPTBR;

public class Exercicio3Test {

	private ENUSFieldFactory enusFieldFactory;
	private PTBRFieldFactory ptbrFieldFactory;

	private PersonInterface ptbrLaurival;
	private PersonInterface ptbrIvan;
	private AddressInterface ptbrLaurivalAddress;
	private AddressInterface ptbrIvanAddress;
	private DateInterface ptbrDate;

	private PersonInterface enusLaurival;
	private PersonInterface enusIvan;
	private AddressInterface enusLaurivalAddress;
	private AddressInterface enusIvanAddress;
	private DateInterface enusDate;

	@Before
	public void setup() {
		ptbrFieldFactory = new PTBRFieldFactory();
		ptbrLaurival = ptbrFieldFactory.createPersonBuilder("Laurival", "Neto").cellphone("12 91234-5678")
				.email("lauriv@l.com").build();
		ptbrIvan = ptbrFieldFactory.createPersonBuilder("Ivan", "Padalko").title("Mr.").cellphone("12 91234-5678")
				.email("iv@n.com").build();
		ptbrLaurivalAddress = ptbrFieldFactory.createAddress("Rua H8B", "Estrela", "SP", "Brazil", "12224-468");
		ptbrIvanAddress = ptbrFieldFactory.createAddress("Rua H8A", "Lua", "SP", "Brazil", "12224-469");
		ptbrDate = ptbrFieldFactory.createDate(2017, 12, 31);

		enusFieldFactory = new ENUSFieldFactory();
		enusLaurival = enusFieldFactory.createPersonBuilder("Laurival", "Neto").cellphone("12 91234-5678")
				.email("lauriv@l.com").build();
		enusIvan = enusFieldFactory.createPersonBuilder("Ivan", "Padalko").title("Mr.").cellphone("12 91234-5678")
				.email("iv@n.com").build();
		enusLaurivalAddress = enusFieldFactory.createAddress("Rua H8B", "Estrela", "SP", "Brazil", "12224-468");
		enusIvanAddress = enusFieldFactory.createAddress("Rua H8A", "Lua", "SP", "Brazil", "12224-469");
		enusDate = enusFieldFactory.createDate(2017, 12, 31);
	}

	@Test
	public void testCommercialLetterInENUSFieldsInPTBR() {
		AbstractLetter letter = new CommercialLetterENUS(ptbrLaurival, ptbrIvan, ptbrLaurivalAddress, ptbrIvanAddress,
				ptbrDate);
		assertEquals("31/12/2017\n" + "\n" + "Laurival Neto\n" + "Rua H8B\n" + "Estrela - SP - 12224-468\n" + "Brazil\n"
				+ "\n" + "Mr. Ivan Padalko\n" + "Rua H8A\n" + "Lua - SP - 12224-469\n" + "Brazil\n" + "\n" + "---\n"
				+ "\n" + "Dear Mr. Ivan Padalko\n" + "\n" + "Sincerely,\n" + "\n" + "Laurival Neto\n" + "\n" + "---\n"
				+ "\n" + "12 91234-5678\n" + "lauriv@l.com\n", letter.model());
	}

	@Test
	public void testCommercialLetterInENUSFieldsIENUS() {
		AbstractLetter letter = new CommercialLetterENUS(enusLaurival, enusIvan, enusLaurivalAddress, enusIvanAddress,
				enusDate);
		assertEquals(
				"12/31/2017\n" + "\n" + "Neto, Laurival\n" + "Rua H8B\n" + "Estrela - SP - 12224-468\n" + "Brazil\n"
						+ "\n" + "Mr. Padalko, Ivan\n" + "Rua H8A\n" + "Lua - SP - 12224-469\n" + "Brazil\n" + "\n"
						+ "---\n" + "\n" + "Dear Mr. Padalko, Ivan\n" + "\n" + "Sincerely,\n" + "\n"
						+ "Neto, Laurival\n" + "\n" + "---\n" + "\n" + "12 91234-5678\n" + "lauriv@l.com\n",
				letter.model());
	}

	@Test
	public void testPersonalLetterInENUSFieldsInPTBR() {
		AbstractLetter letter = new PersonalLetterENUS(ptbrLaurival, ptbrIvan, ptbrLaurivalAddress, ptbrIvanAddress,
				ptbrDate);
		assertEquals("31/12/2017\n" + "\n" + "Laurival Neto\n" + "Rua H8B\n" + "Estrela - SP - 12224-468\n" + "Brazil\n"
				+ "\n" + "Mr. Ivan Padalko\n" + "Rua H8A\n" + "Lua - SP - 12224-469\n" + "Brazil\n" + "\n" + "---\n"
				+ "\n" + "Howdy Ivan?\n" + "\n" + "Cheers,\n" + "\n" + "Laurival\n", letter.model());
	}

	@Test
	public void testPersonalLetterInENUSFieldsInENUS() {
		AbstractLetter letter = new PersonalLetterENUS(enusLaurival, enusIvan, enusLaurivalAddress, enusIvanAddress,
				enusDate);
		assertEquals("12/31/2017\n" + "\n" + "Neto, Laurival\n" + "Rua H8B\n" + "Estrela - SP - 12224-468\n"
				+ "Brazil\n" + "\n" + "Mr. Padalko, Ivan\n" + "Rua H8A\n" + "Lua - SP - 12224-469\n" + "Brazil\n" + "\n"
				+ "---\n" + "\n" + "Howdy Ivan?\n" + "\n" + "Cheers,\n" + "\n" + "Laurival\n", letter.model());
	}

	@Test
	public void testCandidateRejectionLetterInENUSFieldsInPTBR() {
		AbstractLetter letter = new CandidateRejectionLetterENUS(ptbrLaurival, ptbrIvan, ptbrLaurivalAddress,
				ptbrIvanAddress, ptbrDate);
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

	@Test
	public void testCandidateRejectionLetterInENUSFieldsInENUS() {
		AbstractLetter letter = new CandidateRejectionLetterENUS(enusLaurival, enusIvan, enusLaurivalAddress,
				enusIvanAddress, enusDate);
		assertEquals(
				"12/31/2017\n" + "\n" + "Mr. Padalko, Ivan\n" + "Rua H8A\n" + "Lua - SP - 12224-469\n" + "Brazil\n"
						+ "\n" + "---\n" + "\n" + "Dear Mr. Padalko, Ivan,\n" + "\n"
						+ "Thank you for your application for the position XXX at XXX.\n"
						+ "As you can imagine, we received a large number of applications.\n"
						+ "I am sorry to inform you that you have not been selected for an\n"
						+ "interview for this position.\n" + "\n" + "Best,\n" + "\n" + "Neto, Laurival\n" + "\n"
						+ "---\n" + "lauriv@l.com\n" + "Rua H8B\n" + "Estrela - SP - 12224-468\n" + "Brazil\n\n",
				letter.model());
	}

	//

	@Test
	public void testCommercialLetterInPTBRFieldsInPTBR() {
		AbstractLetter letter = new CommercialLetterPTBR(ptbrLaurival, ptbrIvan, ptbrLaurivalAddress, ptbrIvanAddress,
				ptbrDate);
		assertEquals(
				"31/12/2017\n" + "\n" + "Laurival Neto\n" + "Rua H8B\n" + "Estrela - SP - 12224-468\n" + "Brazil\n"
						+ "\n" + "Mr. Ivan Padalko\n" + "Rua H8A\n" + "Lua - SP - 12224-469\n" + "Brazil\n" + "\n"
						+ "---\n" + "\n" + "Querido Mr. Ivan Padalko\n" + "\n" + "Atenciosamente,\n" + "\n"
						+ "Laurival Neto\n" + "\n" + "---\n" + "\n" + "12 91234-5678\n" + "lauriv@l.com\n",
				letter.model());
	}

	@Test
	public void testCommercialLetterInPTBRFieldsIENUS() {
		AbstractLetter letter = new CommercialLetterPTBR(enusLaurival, enusIvan, enusLaurivalAddress, enusIvanAddress,
				enusDate);
		assertEquals(
				"12/31/2017\n" + "\n" + "Neto, Laurival\n" + "Rua H8B\n" + "Estrela - SP - 12224-468\n" + "Brazil\n"
						+ "\n" + "Mr. Padalko, Ivan\n" + "Rua H8A\n" + "Lua - SP - 12224-469\n" + "Brazil\n" + "\n"
						+ "---\n" + "\n" + "Querido Mr. Padalko, Ivan\n" + "\n" + "Atenciosamente,\n" + "\n"
						+ "Neto, Laurival\n" + "\n" + "---\n" + "\n" + "12 91234-5678\n" + "lauriv@l.com\n",
				letter.model());
	}

	@Test
	public void testPersonalLetterInPTBRFieldsInPTBR() {
		AbstractLetter letter = new PersonalLetterPTBR(ptbrLaurival, ptbrIvan, ptbrLaurivalAddress, ptbrIvanAddress,
				ptbrDate);
		assertEquals("31/12/2017\n" + "\n" + "Laurival Neto\n" + "Rua H8B\n" + "Estrela - SP - 12224-468\n" + "Brazil\n"
				+ "\n" + "Mr. Ivan Padalko\n" + "Rua H8A\n" + "Lua - SP - 12224-469\n" + "Brazil\n" + "\n" + "---\n"
				+ "\n" + "E ai Ivan?\n" + "\n" + "Vlw flw,\n" + "\n" + "Laurival\n", letter.model());
	}

	@Test
	public void testPersonalLetterInPTBRFieldsInENUS() {
		AbstractLetter letter = new PersonalLetterPTBR(enusLaurival, enusIvan, enusLaurivalAddress, enusIvanAddress,
				enusDate);
		assertEquals("12/31/2017\n" + "\n" + "Neto, Laurival\n" + "Rua H8B\n" + "Estrela - SP - 12224-468\n"
				+ "Brazil\n" + "\n" + "Mr. Padalko, Ivan\n" + "Rua H8A\n" + "Lua - SP - 12224-469\n" + "Brazil\n" + "\n"
				+ "---\n" + "\n" + "E ai Ivan?\n" + "\n" + "Vlw flw,\n" + "\n" + "Laurival\n", letter.model());
	}

	@Test
	public void testCandidateRejectionLetterInPTBRFieldsInPTBR() {
		AbstractLetter letter = new CandidateRejectionLetterPTBR(ptbrLaurival, ptbrIvan, ptbrLaurivalAddress,
				ptbrIvanAddress, ptbrDate);
		assertEquals("31/12/2017\n" + "\n" + "Mr. Ivan Padalko\n" + "Rua H8A\n" + "Lua - SP - 12224-469\n" + "Brazil\n"
				+ "\n" + "---\n" + "\n" + "Querido Mr. Ivan Padalko,\n" + "\n"
				+ "Obrigado por sua aplicação para a posição XXX na XXX.\n"
				+ "Como você deve imaginar, nós recebemos um grande numero de aplicações.\n"
				+ "Sinto-lhe informar que não foi selecionado para a\n" + "entrevista para a posição.\n" + "\n"
				+ "Felicidades,\n" + "\n" + "Laurival Neto\n" + "\n" + "---\n" + "lauriv@l.com\n" + "Rua H8B\n"
				+ "Estrela - SP - 12224-468\n" + "Brazil\n\n", letter.model());
	}

	@Test
	public void testCandidateRejectionLetterInPTBRFieldsInENUS() {
		AbstractLetter letter = new CandidateRejectionLetterPTBR(enusLaurival, enusIvan, enusLaurivalAddress,
				enusIvanAddress, enusDate);
		assertEquals("12/31/2017\n" + "\n" + "Mr. Padalko, Ivan\n" + "Rua H8A\n" + "Lua - SP - 12224-469\n" + "Brazil\n"
				+ "\n" + "---\n" + "\n" + "Querido Mr. Padalko, Ivan,\n" + "\n"
				+ "Obrigado por sua aplicação para a posição XXX na XXX.\n"
				+ "Como você deve imaginar, nós recebemos um grande numero de aplicações.\n"
				+ "Sinto-lhe informar que não foi selecionado para a\n" + "entrevista para a posição.\n" + "\n"
				+ "Felicidades,\n" + "\n" + "Neto, Laurival\n" + "\n" + "---\n" + "lauriv@l.com\n" + "Rua H8B\n"
				+ "Estrela - SP - 12224-468\n" + "Brazil\n\n", letter.model());
	}

}

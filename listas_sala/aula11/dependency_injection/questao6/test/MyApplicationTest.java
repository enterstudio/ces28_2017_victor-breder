

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyApplicationTest {

	private MyApplication myApplicationEmail;
	private MyApplication myApplicationSMS;
	
	@Before
	public void setup() {
		myApplicationEmail = new MyApplication(new EmailService());
		myApplicationSMS = new MyApplication(new SMSService());
	}
	
	@Test
	public void testMyApplicationEmail() {
		String result = myApplicationEmail.processMessages("Eu entendo a utilidade dessa questão", "go@t.com");
		assertEquals("email:go@t.com:Eu entendo a utilidade dessa questão", result);
	}
	
	@Test
	public void testMyApplicationSMS() {
		String result = myApplicationSMS.processMessages("Eu entendo a utilidade dessa questão", "12912345678");
		assertEquals("sms:12912345678:Eu entendo a utilidade dessa questão", result);
	}

}

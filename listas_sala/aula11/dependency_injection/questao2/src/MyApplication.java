

public class MyApplication {
	
	private EmailService emailService = new EmailService();
	
	public void processMessages(String message, String receiver) {
		emailService.sendEmail(message, receiver);
	}

}
